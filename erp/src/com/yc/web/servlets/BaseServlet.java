package com.yc.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

//使用适配器
//抽象类，即不能直接使用，将来写一个Servlet继承自BaseServlet. 
public abstract class BaseServlet extends HttpServlet {

	private static final long serialVersionUID = 3929147019319436036L;
	
	protected String op;
	protected int pages;
	protected int pagesize;
	
	protected int page;
	protected int rows;
	protected String sort;
	protected String order;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost( req, resp);
	}
	
	protected void outJsonString (HttpServletResponse response,Object obj) throws IOException{
		Gson g = new Gson();
		String jsonString = g.toJson(obj);
		
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(jsonString);
		out.flush();
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8"); // 这样所有的servlet的编码都设置好了.
		op=null;
		pages=1;
		pagesize=10;
		
		if(req.getParameter("op")!=null && !"".equals(req.getParameter("op"))){
			op=req.getParameter("op");
		}
		if(req.getParameter("pages")!=null && !"".equals(req.getParameter("pages"))){
			pages=Integer.parseInt(req.getParameter("pages"));
		}
		if(req.getParameter("pagesize")!=null  && !"".equals(req.getParameter("pagesize"))){
			pagesize=Integer.parseInt(req.getParameter("pagesize"));
		}
		if(req.getParameter("page")!=null && !"".equals(req.getParameter("page"))){
			page=Integer.parseInt(req.getParameter("page"));
		}
		if(req.getParameter("rows")!=null && !"".equals(req.getParameter("rows"))){
			rows=Integer.parseInt(req.getParameter("rows"));
		}
		if(req.getParameter("sort")!=null && !"".equals(req.getParameter("sort"))){
			sort=req.getParameter("sort");
		}
		if(req.getParameter("order")!=null && !"".equals(req.getParameter("order"))){
			order=req.getParameter("order");
		}
		
		super.service(req, resp);   // 判断请求方式，如果是get,调用doGet(),..
		
	}

	

}
