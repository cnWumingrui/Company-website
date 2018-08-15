package com.yc.web.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.bean.Companyinfo;
import com.yc.bean.Infotype;
import com.yc.bean.News;
import com.yc.biz.BaseBiz;
import com.yc.dao.DBUtil;
import com.yc.model.PageBean;

@WebServlet("/news.action")
public class NewsServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		try {
			if ("show".equals(op)) {
				showOp(request, response);
			}else if("detail".equals(op)){
				detailOp(request,response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			String basePath = (String) request.getServletContext().getAttribute("basePath");
			
			request.getSession().setAttribute("errorMsg",e.getMessage());
			response.sendRedirect(basePath+"500.jsp");
		}
	}

	private void detailOp(HttpServletRequest request,HttpServletResponse response) throws Exception  {
		Integer id=Integer.parseInt(request.getParameter("id"));
		DBUtil db = new DBUtil();
		List<News> list =db.select(News.class, "select * from news where id =?",id);
		News n =   list!=null && list.size()>0? list.get(0):null;
		request.setAttribute("news", n);
		request.getRequestDispatcher("/WEB-INF/pages/news/detail.jsp").forward(request, response);
	}

	private void showOp(HttpServletRequest req, HttpServletResponse resp)throws Exception {
		Integer id = null;
		if (req.getParameter("id") != null && !"".equals(req.getParameter("id"))) {
			id = Integer.parseInt(req.getParameter("id"));
		}
		BaseBiz bb = new BaseBiz();
		int start = (pages - 1) * pagesize;
		PageBean newsPageBean = null;
		if (id == null) {
			newsPageBean = bb.findByPage("select count(*) from news", null,
					"select * from news order by change_date desc limit "
							+ start + "," + pagesize, null, pages, pagesize,
					News.class);
		} else {
			newsPageBean = bb.findByPage(
					"select count(*) from news where typeid=" + id, null,
					"select * from news where typeid=" + id
							+ " order by change_date desc limit " + start + ","
							+ pagesize, null, pages, pagesize, News.class);
		}

		req.setAttribute("newsPageBean", newsPageBean);
		
		req.setAttribute("id", id);
		req.getRequestDispatcher("/WEB-INF/pages/news/news.jsp").forward(req,
				resp);
	}

}
