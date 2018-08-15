package com.yc.biz;

import java.util.List;

import com.yc.dao.DBUtil;
import com.yc.model.PageBean;

public class BaseBiz {
		protected DBUtil db=new DBUtil();

	    /**
	     * ��ҳ��ѯ
	     * @param pages
	     * @param pagesize
	     * @param orderColumn
	     * @param orderway
	     * @return
	     * @throws Exception
	     */
		public PageBean findByPage(String sqlCount,List<Object> sqlCountParameter,String sqlList,List<Object> sqlListParameter,int pages,int pagesize,Class cls) throws Exception{
			int total=findCount(sqlCount,sqlCountParameter);
			
			List list=findList(sqlList, sqlListParameter, cls); 
			
			PageBean pageBean=new PageBean();
			pageBean.setTotal(total);
			pageBean.setPages(pages);
			pageBean.setPagesize(pagesize);
			
			//������ҳ��   10  5  2   /11  5  3
			int totalpages=total%pagesize==0?(total/pagesize):(total/pagesize+1);
			pageBean.setTotalpages(totalpages);
			
			pageBean.setList(list);
			
			
			return pageBean;
		}

		public List findList(String sqlList,List<Object> sqlListParameter,Class cls) throws Exception {
			if(sqlListParameter==null||sqlListParameter.size()<=0){
				return db.select(cls, sqlList);
			}else{
				return db.select(cls, sqlList, sqlListParameter);
			}
			
		}

		public int findCount(String sqlCount,List<Object> sqlCountParameter) throws Exception {
			int result=(int)db.selectFunc(sqlCount, sqlCountParameter);
			return result;
		}
		
		
		
}
