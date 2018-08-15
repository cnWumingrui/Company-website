package com.yc.web.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.yc.model.PageBean;


public class PageTag extends TagSupport {
	private static final long serialVersionUID = 4456289798611001394L;
	private Object pageBean;
	private String href;
	
	public void setHref(String href) {
		this.href = href;
	}

	public void setPageBean(Object pageBean) {
		this.pageBean = pageBean;
	}


	@Override
	public int doStartTag() throws JspException {
		try {
			JspWriter out = super.pageContext.getOut();
			if(pageBean!=null && pageBean instanceof PageBean){
				PageBean pb = (PageBean) pageBean;
				showPage(pb,out);
			}
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return super.EVAL_BODY_INCLUDE;
	}


	private void showPage(PageBean pb, JspWriter out) {
		String pageBar="<div>共"+pb.getTotal()+"条记录/每页"+pb.getPagesize()+"条  共"+pb.getTotalpages()+"页/当前第"+pb.getPages() +"页|";
		pageBar+="<a href=\""+href+"&pages=1\">第一页</a>|";
		pageBar+="<a href=\""+href+"&pages="+pb.getPrePage()+"\" >上一页</a>|";
		pageBar+="<a href=\""+href+"&pages="+pb.getNextPage()+"\" >下一页</a>|";
		pageBar+="<a href=\""+href+"&pages="+pb.getTotalpages()+"\">最后一页</a></div>";
		
		try {
			out.println(pageBar);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
}
