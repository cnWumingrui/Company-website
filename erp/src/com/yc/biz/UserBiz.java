package com.yc.biz;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;






import com.yc.bean.Admin;
import com.yc.dao.DBUtil;
import com.yc.utils.Encrypt;

public class UserBiz {
	private DBUtil db = new DBUtil();

//	// ע�����
//	public int reg(String uname, String upwd,String tel) throws Exception {
//		boolean r = isUnameExists(uname);
//		if (r == false) {
//			String sql = "insert into admin(username,userpassword,join_time) values(?,?,now()) ";
//			List<Object> params = new ArrayList<Object>();
//			params.add(uname);
//			upwd = Encrypt.md5(upwd); 
//			params.add(upwd);
//			params.add(tel);
//			int result = db.doUpdate(sql, params);
//			return result;
//		} else {
//			throw new RuntimeException("uname" + uname + "exists");
//		}
//	}

	// ��½����
	public Admin login(String uname, String upwd) throws Exception {

		List list = db.select(Admin.class, "select * from admin where username=? and userpassword=?",uname,Encrypt.md5(upwd));
		if(list!=null && list.size()>0){
			return (Admin) list.get(0);
		}else{
			return null;
		}
	}

	public boolean isUnameExists(String uname) throws Exception {
		String sql = "select * from admin where username=?";
		List<Object> params = new ArrayList<Object>();
		params.add(uname);
		List<Map<String, String>> list = db.select(sql, params);
		if (list != null && list.size() > 0) {
			return true;
		} else {
			return false;
		}
	}
	
}
