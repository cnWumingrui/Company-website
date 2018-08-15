package com.yc.web.filters;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.yc.bean.Admin;





@WebFilter("/back/*")   //��̨����Դ��Ҫ����
public class CheckLoginFilter implements Filter {

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//session
		HttpServletRequest req=(HttpServletRequest)request;
		HttpSession session=req.getSession();
		if(session.getAttribute("admin")!=null){
//			Admin u = (Admin) session.getAttribute("admin");
//			Map<Integer,List<Func>> roleMap = (Map<Integer,List<Func>>) request.getServletContext().getAttribute("roleMap");
//			List<Func> funcList = roleMap.get(u.getId());
//			session.setAttribute("funcList", funcList);
			chain.doFilter(request, response);
		}else{
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.println("<script>alert('您还没有登录');location.href='../login.html';</script>");
		}
	}


	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
		
	}



}
