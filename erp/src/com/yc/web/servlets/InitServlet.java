package com.yc.web.servlets;

import java.io.IOException;
import java.util.List;







import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.yc.bean.Companyinfo;
import com.yc.bean.Infotype;
import com.yc.bean.News;
import com.yc.bean.Product;
import com.yc.bean.Pronunciament;
import com.yc.biz.BaseBiz;
import com.yc.model.PageBean;




@WebServlet("/init.action")
public class InitServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Logger logger=Logger.getLogger(InitServlet.class);
		
		BaseBiz bb=new BaseBiz();
//		List<Pronunciament> pronunciamentList =null;
//		List<Product> productList=null;
//		List<News> newsList =null;
		PageBean pronunciamentPageBean =null;
		PageBean productPageBean=null;
		PageBean newsPageBean=null;
		try {
			
			pronunciamentPageBean = bb.findByPage("select count(*) from pronunciament", null, "select * from pronunciament order by join_date desc,id desc limit 0,10", null, 1, 10, Pronunciament.class);
			//pronunciamentList=bb.findList("select * from pronunciament order by join_date desc", null, Pronunciament.class);
			productPageBean = bb.findByPage("select count(*) from Product", null, "select * from Product order by change_date desc limit 0,10", null, 1, 10, Product.class);
			//productList=bb.findList("select * from Product", null, Product.class);
			newsPageBean = bb.findByPage("select count(*) from news", null, "select * from news order by change_date desc limit 0,10", null, 1, 10, News.class);
			//newsList=bb.findList("select * from news", null, News.class);
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
			String basePath = (String) request.getServletContext().getAttribute("basePath");
			
			request.getSession().setAttribute("errorMsg",e.getMessage());
			response.sendRedirect(basePath+"500.jsp");
		}
		
		HttpSession session=request.getSession();
		session.setAttribute("pronunciamentPageBean", pronunciamentPageBean);
		session.setAttribute("productPageBean", productPageBean);
		session.setAttribute("newsPageBean", newsPageBean);
		
		ServletContext application=request.getServletContext();
		List<Infotype> infotypeList=(List<Infotype>) application.getAttribute("infotypeList");
		List<Companyinfo> companyinfoList=(List<Companyinfo>) application.getAttribute("companyinfoList");
		for(Infotype it:infotypeList){
			for(Companyinfo ci:companyinfoList){
				if(it.getId()==ci.getTypeid() && it.getTypename().equals("企业简介")){
					session.setAttribute("companyinfo", ci);
				}
			}
		}
		request.getRequestDispatcher("/WEB-INF/pages/index.jsp").forward(request, response);
	}

}
