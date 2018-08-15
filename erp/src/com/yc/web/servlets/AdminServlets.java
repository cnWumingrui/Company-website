package com.yc.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.util.RequestUtil;

import com.google.gson.Gson;
import com.yc.bean.Admin;
import com.yc.bean.JsonModel;
import com.yc.biz.UserBiz;
import com.yc.dao.DBUtil;
import com.yc.model.DataGridModel;
import com.yc.utils.Encrypt;
import com.yc.utils.RequestUtils;


@WebServlet("/backLogin/admin.action")
public class AdminServlets extends BaseServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		try {
			if("login".equals(op)){
				loginOp(request,response);
			}else if("list".equals(op)){
				listOp(request,response);
			}else if("reg".equals(op)){
				regOp(request,response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			String basePath = (String) request.getServletContext().getAttribute("basePath");
			request.getSession().setAttribute("errorMsg", e.getMessage());
			response.sendRedirect(basePath+"500.jsp");
		} 
	}
	
	private void regOp(HttpServletRequest request, HttpServletResponse response) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {
		Admin admin = RequestUtils.parseRequest(request, Admin.class);
		admin.setUserpassword(Encrypt.md5(admin.getUserpassword()));
		
		JsonModel jm =new JsonModel();
		
		try {
			DBUtil db =new DBUtil();
			db.doUpdate("insert into admin(username,userpassword,join_time) values(?,?,now()) ", admin.getUsername(),admin.getUserpassword());
			jm.setCode(1);
		} catch (Exception e) {
			jm.setCode(0);
			jm.setMsg(e.getMessage());
			e.printStackTrace();
		}
		
		super.outJsonString(response, jm);
	}

	private void listOp(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		DBUtil db =new DBUtil();
		int total = (int) db.selectFunc("select count(*) from admin ");
		
		int start = (page-1)*rows;
		List<Admin> list = db.select(Admin.class, "select * from admin order by "+sort+" "+order+" limit "+start+","+rows);
		
		DataGridModel dgm = new DataGridModel();
		dgm.setRows(list);
		dgm.setTotal(total);
		
		//将它转为json格式 -> gson
		super.outJsonString(response, dgm);
	}

	protected void loginOp(HttpServletRequest request, HttpServletResponse response) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {
		Admin u = RequestUtils.parseRequest(request, Admin.class);
		System.out.print(u.toString());
		HttpSession session = request.getSession();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String valcode = request.getParameter("valcode");
		String sRand = (String) session.getAttribute("sRand");
		if (valcode.equals(sRand) == false) {
			out.println("<script>alert('验证码错误!');</script>");
			response.sendRedirect("login.html");
		}else if (u==null || (u.getUsername() == null || u.getUsername().equals("")) || (u.getUserpassword() == null || u.getUserpassword().equals(""))) {
			
			out.println("<html><body><script>alert('用户名和密码不能为空');</script></body></html>");
			response.sendRedirect("login.html");
			out.flush();
			out.close();
		}else{
			UserBiz ub = new UserBiz();
			try {
				Admin admin = ub.login(u.getUsername(), u.getUserpassword());
				if (admin != null) {
					System.out.println(admin.toString());
					//用转发跳转页面,观察转发的重复提交问题
					//request.getRequestDispatcher("loginSuccess.jsp").forward(request, response);
					//取application中所有的人
					//TODO: 记住信息 利用cookie
//					if("1".equals(re)){
//						Cookie c = new Cookie("uname",uname);
//						Cookie c2 = new Cookie("upwd",upwd);
//						response.addCookie(c);
//						response.addCookie(c2);
//					}
					session.setAttribute("admin", admin);//权限
					//重定向方法
					response.sendRedirect("manager/index.jsp");
				} else {
					out.println("<html><body><script>alert('Login failed!!!');</script></body></html>");
					response.sendRedirect("login.html");
					out.flush();
					out.close();
				}
			} catch (Exception ex) {
				out.println("<html><body><script>alert('Login failed!!!" + ex.getMessage() + "');</script></body></html>");
				response.sendRedirect("login.html");
				out.flush();
				out.close();
			}
		}
	}


}
