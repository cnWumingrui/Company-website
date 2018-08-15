package com.yc.web.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.yc.bean.Job;
import com.yc.biz.BaseBiz;
import com.yc.dao.DBUtil;
import com.yc.model.PageBean;

@WebServlet("/job.action")
public class JobServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
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
		List<Job> list = db.select(Job.class, "select * from job where id=?",
				id);
		Job j = list != null & list.size() > 0 ? list.get(0) : null;
		request.setAttribute("job", j);
		request.getRequestDispatcher("/WEB-INF/pages/job/detail.jsp").forward(
				request, response);
	}

	private void showOp(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		BaseBiz bb = new BaseBiz();
		int start = (pages - 1) * pagesize;
		PageBean jobPageBean = bb.findByPage("select count(*) from job", null,
				"select * from job order by join_date desc limit " + start
						+ "," + pagesize, null, pages, pagesize,Job.class);
		request.setAttribute("jobPageBean", jobPageBean);
		request.getRequestDispatcher("/WEB-INF/pages/job/job.jsp").forward(
				request, response);
	}
}
