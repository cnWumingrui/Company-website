package com.yc.web.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.bean.Leave_word;
import com.yc.biz.BaseBiz;
import com.yc.dao.DBUtil;
import com.yc.model.PageBean;

@WebServlet("/leave_word.action")
public class Leave_wordServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			if ("show".equals(op)) {
				showOp(request, response);
			} else if ("detail".equals(op)) {
				detailOp(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			String basePath = (String) request.getServletContext()
					.getAttribute("basePath");

			request.getSession().setAttribute("errorMsg", e.getMessage());
			response.sendRedirect(basePath + "500.jsp");
		}
	}
	private void detailOp(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		DBUtil db = new DBUtil();
		List<Leave_word> list = db.select(Leave_word.class, "select * from leave_word where id=?",
				id);
		Leave_word l = list != null & list.size() > 0 ? list.get(0) : null;
		request.setAttribute("leave_word", l);
		request.getRequestDispatcher("/WEB-INF/pages/leave_word/detail.jsp").forward(
				request, response);
	}

	private void showOp(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		BaseBiz bb = new BaseBiz();
		int start = (pages - 1) * pagesize;
		PageBean leave_wordPageBean = bb.findByPage("select count(*) from leave_word", null,
				"select * from leave_word order by join_date desc limit " + start
						+ "," + pagesize, null, pages, pagesize,Leave_word.class);
		request.setAttribute("leave_wordPageBean", leave_wordPageBean);
		request.getRequestDispatcher("/WEB-INF/pages/leave_word/leave_word.jsp").forward(
				request, response);
	}

}
