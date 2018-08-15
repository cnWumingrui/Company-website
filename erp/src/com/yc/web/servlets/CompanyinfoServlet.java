package com.yc.web.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.bean.Companyinfo;
import com.yc.bean.Infotype;
import com.yc.bean.News;

@WebServlet("/companyinfo.action")
public class CompanyinfoServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			if("show".equals(op)){
				showOp(req,resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
			String basePath = (String) req.getServletContext().getAttribute("basePath");
			
			req.getSession().setAttribute("errorMsg",e.getMessage());
			resp.sendRedirect(basePath+"500.jsp");
		}
	}

	

	private void showOp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String infotype="企业简介";
		if(req.getParameter("typename")!=null && !"".equals(req.getParameter("typename"))){
			infotype=req.getParameter("typename");
		}
		ServletContext application=req.getServletContext();
		List<Infotype> infotypeList=(List<Infotype>) application.getAttribute("infotypeList");
		List<Companyinfo> companyinfoList=(List<Companyinfo>) application.getAttribute("companyinfoList");
		for(Infotype it:infotypeList){
			for(Companyinfo ci:companyinfoList){
				if(it.getId()==ci.getTypeid() && it.getTypename().equals(infotype)){
					req.setAttribute("companyinfo", ci);
				}
			}
			
		}
		req.getRequestDispatcher("/WEB-INF/pages/companyInfo/companyInfo.jsp").forward(req, resp);
	}
	
}
