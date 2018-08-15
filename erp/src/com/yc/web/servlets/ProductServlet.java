package com.yc.web.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.bean.JsonModel;
import com.yc.bean.Product;
import com.yc.bean.Product_class;
import com.yc.biz.BaseBiz;
import com.yc.dao.DBUtil;
import com.yc.model.DataGridModel;
import com.yc.model.PageBean;



@WebServlet({ "/product.action", "/backLogin/product.action" })
public class ProductServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private DBUtil db = new DBUtil();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			if ("show".equals(op)) {
				showOp(request, response);
			} else if ("detail".equals(op)) {
				detailOp(request, response);
			} else if ("list".equals(op)) {
				listOp(request, response);
			} else if ("getAllProductClass".equals(op)) {
				getAllProductClssOp(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			String basePath = (String) request.getServletContext().getAttribute("basePath");
			request.getSession().setAttribute("errorMsg", e.getMessage());
			response.sendRedirect(basePath + "500.jsp");
		}
	}

	private void getAllProductClssOp(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		List<Product_class> Product_classList = (List<Product_class>) request.getServletContext().getAttribute("product_classList");
		JsonModel jm = new JsonModel();
		jm.setCode(1);
		jm.setObj(Product_classList);
		super.outJsonString(response, jm);
	}

	private void listOp(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int page = Integer.parseInt(request.getParameter("page"));
		int rows = Integer.parseInt(request.getParameter("rows"));
		String order = request.getParameter("order");
		String sort = request.getParameter("sort");

		int total = (int) db.selectFunc(" select count(*) from Product ");

		int start = (page - 1) * rows;

		List<Product> list = db
				.select(Product.class,
						"select p.id,Product_name,protype as Product_class,Product_spec"
								+ " from Product p,Product_class pc where p.Product_class=pc.id order by p."
								+ sort + " " + order + " limit " + start + "," + rows);

		DataGridModel dgm = new DataGridModel();
		dgm.setRows(list);
		dgm.setTotal(total);

		// 将他转为json格式 ->gson
		super.outJsonString(response, dgm);
	}

	private void detailOp(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Integer id = Integer.parseInt(request.getParameter("id"));

		List<Product> list = db.select(Product.class, "select * from Product where id=?", id);
		Product product = list != null && list.size() > 0 ? list.get(0) : null;
		request.setAttribute("product", product);
		request.getRequestDispatcher("WEB-INF/pages/product/detail.jsp").forward(request, response);
	}

	private void showOp(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Integer id = null;

		if (request.getParameter("product_class") != null
				&& !"".equals(request.getParameter("product_class"))) {
			id = Integer.parseInt(request.getParameter("product_class"));
		}

		BaseBiz bb = new BaseBiz();
		int start = (pages - 1) * pagesize;
		PageBean productPageBean = null;

		if (id == null) {
			productPageBean = bb.findByPage("select count(*) from Product", null,
					"select * from Product order by change_date desc limit " + start + ","
							+ pagesize, null, pages, pagesize, Product.class);
		} else {
			productPageBean = bb.findByPage("select count(*) from Product  where Product_class="
					+ id, null, "select p.id,Product_name,protype as Product_class,Product_spec "
					+ " from Product p,Product_class pc where  p.Product_class=" + id
					+ " and p.Product_class=pc.id order by change_date desc limit " + start + ","
					+ pagesize, null, pages, pagesize, Product.class);

		}

		request.setAttribute("id", id);
		request.setAttribute("productPageBean", productPageBean);
		request.getRequestDispatcher("WEB-INF/pages/product/product.jsp")
				.forward(request, response);
	}
}
