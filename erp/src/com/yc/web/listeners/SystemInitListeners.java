package com.yc.web.listeners;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import org.apache.log4j.Logger;

import com.yc.bean.Companyinfo;
import com.yc.bean.Friendlink;
import com.yc.bean.Infotype;
import com.yc.bean.News_class;
import com.yc.bean.Product_class;
import com.yc.bean.Webconfig;
import com.yc.dao.DBUtil;




@WebListener
public class SystemInitListeners implements ServletContextListener{

	
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		 //访问数据库
//    	RoleBiz rb = new RoleBiz();
//    	Map<Integer,List<Func>> roleMap = null;
//    	try {
//			roleMap = rb.findAllRole();
//			arg0.getServletContext().setAttribute("roleMap", roleMap);
//			System.out.println(roleMap+"在application启动时初始化成功");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		System.setProperty("log.base", System.getProperty("user.home"));
		Logger logger=Logger.getLogger(SystemInitListeners.class);
		
		ServletContext application=arg0.getServletContext();
		
		DBUtil db=new DBUtil();
		
		try {
			List<Infotype> infotypeList=db.select(Infotype.class, "select * from infotype");
			application.setAttribute("infotypeList", infotypeList);
			
			List<Companyinfo> companyinfoList=db.select(Companyinfo.class, "select * from Companyinfo");
			application.setAttribute("companyinfoList", companyinfoList);
			
			List<Friendlink> friendlinkList=db.select(Friendlink.class, "select * from friendlink");
			application.setAttribute("friendlinkList", friendlinkList);
		
			List<News_class> news_classList=db.select(News_class.class, "select * from News_class");
			application.setAttribute("news_classList", news_classList);
			
			List<Product_class> product_classList=db.select(Product_class.class, "select * from Product_class");
			application.setAttribute("product_classList", product_classList);
			
			List<Webconfig> webconfigList=db.select(Webconfig.class, "select * from Webconfig");
			application.setAttribute("webconfigList", webconfigList);
		
			logger.info("系统正常启动。。。");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("系统初始化错误，详细信息如下：",e);
			logger.error("系统推出，请检查后再次部署。。。");
			System.exit(0);
		}
		
		
		
		
		
	}

	

    
	
}
