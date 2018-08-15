package com.yc.model;

import java.util.List;

public class PageBean {
	private int total;//总记录数
	private int pages;//当前第几页
	private int pagesize;//每页多少条
	private List<Object> list;//存这页有多少行
	private int totalpages;//总共有多少页
	
	
	public int getPrePage(){
		if(pages>1){
			return pages-1;
		}else{
			return 1;
		}
	}
	
	
	public int getNextPage(){
		if(pages>=totalpages){
			return totalpages<=0?1:totalpages;
		}else{
			return pages+1;
		}
	}


	public int getTotal() {
		return total;
	}


	public void setTotal(int total) {
		this.total = total;
	}


	public int getPages() {
		return pages;
	}


	public void setPages(int pages) {
		this.pages = pages;
	}


	public int getPagesize() {
		return pagesize;
	}


	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}


	public List<Object> getList() {
		return list;
	}


	public void setList(List<Object> list) {
		this.list = list;
	}


	public int getTotalpages() {
		return totalpages<=0?1:totalpages;
	}


	public void setTotalpages(int totalpages) {
		this.totalpages = totalpages;
	}


	@Override
	public String toString() {
		return "PageBean [total=" + total + ", pages=" + pages + ", pagesize="
				+ pagesize + ", list=" + list + ", totalpages=" + totalpages
				+ "]";
	}
	
	
	
	
	
	
}
