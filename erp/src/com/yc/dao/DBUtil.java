package com.yc.dao;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

public class DBUtil {
	private static ResourceBundle rb = ResourceBundle.getBundle("db");

	static { // 加载数据库
		try {
			Class.forName(rb.getString("driverClassName"));
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("加载数据库驱动失败!!!\n", e);
		}
	}

	/**
	 * 
	 * @return 与数据库连接的对象
	 * @throws SQLException
	 */
	private static Connection getConn() {
		try {
			// 采用数据库联接池方案
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			DataSource ds = (DataSource) envCtx.lookup("jdbc/mysql_erp");
//			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "aaaa");
			return ds.getConnection();
//			return DriverManager.getConnection(rb.getString("url"), rb.getString("user"), rb.getString("password"));
		} catch (Exception e) {
			try {
				return DriverManager.getConnection(rb.getString("url"), rb.getString("user"), rb.getString("password"));
			} catch (SQLException e1) {
				throw new RuntimeException("建立与数据库的连接失败!!!\n", e);
			}
		}
	}

	/**
	 * 关闭数据连接，sql语句执行工具对象，数据集对象
	 * 
	 * @param con
	 *            数据库连接对象
	 * @param st
	 *            sql语句执行工具对象
	 * @param rs
	 *            数据集对象
	 */
	private static void close(Connection con, Statement st, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				throw new RuntimeException("关闭数据集失败!!!\n", e);
			}
		}
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				throw new RuntimeException("关闭sql执行工具失败!!!\n", e);
			}
		}
		try {
			if (con != null && !con.isClosed()) {
				try {
					con.close();
				} catch (SQLException e) {
					throw new RuntimeException("关闭数据连接失败!!!\n", e);
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException("关闭数据连接失败!!!\n", e);
		}
	}

	/**
	 * 增 在增加产品时，如果用户输入的产品名称相同则修改数量,否则为添加产品
	 * 
	 * @param sql
	 * @param params
	 * @return 受影响的行数
	 */
//	public static int doInsert(String sql, Object... params) { // sql插入语句
//		Connection con = null;
//		PreparedStatement pst = null;
//		try {
//			con = getConn();
//			pst = con.prepareStatement(sql);
//			setPlaceHolderValue(pst, params);
//			String pname = (String) params[1];
//			int pquantity = (int) params[2];
//			String sql01 = "select * from product";
//			List<Map<String, Object>> list = list(sql01, null);
//			if (list == null) {
//				System.out.println("list = null");
//				return pst.executeUpdate();
//			} else {
//				int id = -1;
//				for (Map<String, Object> map : list) {
//					if (pname.intern() == ((String) map.get("PNAME")).intern()) {
//						id = Integer.valueOf((String) map.get("PRODUCTCODE"));
//						// id = (int)map.get("PRODUCTCODE"); // 这种不可以！！！
//						break;
//					}
//				}
//				if (id != -1) {
//					String sql02 = "update product set quantity=quantity+" + pquantity + " where productcode=" + id;
//					return doUpdate(sql02, null);
//				}
//				return pst.executeUpdate();
//			}
//		} catch (SQLException e) {
//			throw new RuntimeException("创建sql执行语句工具失败!!!\n", e);
//		} finally {
//			close(con, pst, null);
//		}
//	}

    private static void setPlaceHolderValue(PreparedStatement pst, Object... params) {
	if (params != null && params.length != 0) {
	    for (int i = 0; i < params.length; i++) {
		try {
		    if (params[i] instanceof java.io.InputStream) {
			pst.setBlob(i + 1, (java.io.InputStream) params[i]);
		    } else if (params[i] instanceof java.sql.Date) {
			pst.setDate(i + 1, (java.sql.Date) params[i]);
		    } else if (params[i] instanceof java.util.Date) {
			pst.setDate(i + 1, new java.sql.Date(((java.util.Date) params[i]).getTime()));
		    } else {
			pst.setObject(i + 1, params[i]);
		    }
		} catch (SQLException e) {
		    throw new RuntimeException("给第" + (i + 1) + "个占位符注值时出错！！！", e);
		}
	    }
	}
    }

	/**
	 * 删
	 * 
	 * @param sql
	 * @param params
	 * @return
	 */
//	public static int doDelete(String sql, Object... params) {
//		Connection con = null;
//		PreparedStatement pst = null;
//		try {
//			con = getConn();
//			pst = con.prepareStatement(sql);
//			setPlaceHolderValue(pst, params);
//			return pst.executeUpdate();
//		} catch (SQLException e) {
//			throw new RuntimeException("创建sql执行工具出错！！！", e);
//		} finally {
//			close(con, pst, null);
//		}
//	}

	public int doUpdate(String sql,List<Object> params) throws Exception{
		Connection con=getConn();
		PreparedStatement stmt=con.prepareStatement(sql);
		if(params!=null && params.size()>0){
			for(int i=0;i<params.size();i++){
				stmt.setString(i+1, params.get(i).toString());
			}
		}
		int r=stmt.executeUpdate();
		close(con,stmt,null);
		return r;
	}
	
	public int doUpdate(String sql,Object...params) throws Exception{
		List<Object> pp = new ArrayList<Object>();
		if(params!=null && params.length>0){
			for(Object o:params){
				pp.add(o);
			}
		}
		return doUpdate(sql,pp);
	}
	
	/**
	 * 查
	 * 
	 * @param sql
	 * @param params
	 * @return
	 */
	public static Map<String, Object> get(String sql, Object... params) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = getConn();
			pst = con.prepareStatement(sql);
			setPlaceHolderValue(pst, params);
			rs = pst.executeQuery();
			if (rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				ResultSetMetaData rsmd = rs.getMetaData();
				int columnCount = rsmd.getColumnCount();
				for (int i = 0; i < columnCount; i++) {
					map.put(rsmd.getColumnName(i + 1), rs.getObject(i + 1));
				}
				return map;
			}
		} catch (SQLException e) {
			throw new RuntimeException("创建sql执行工具出错！！！", e);
		} finally {
			close(con, pst, rs);
		}
		return null;
	}

	public static <T> T get(Class<T> clazz, String sql, Object... params) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = getConn();
			pst = con.prepareStatement(sql);
			setPlaceHolderValue(pst, params);
			rs = pst.executeQuery();
			if (rs.next()) {
				try {
					T t = clazz.newInstance();
					Field[] fs = clazz.getDeclaredFields();
					for (Field field : fs) {
						field.setAccessible(true);
						String fieldType = field.getType().getName();
						try {
							if (fieldType.intern() == "java.lang.Integer" || fieldType.intern() == "int") {
								field.setInt(t, rs.getInt(field.getName()));
							} else if (fieldType.intern() == "java.lang.Double" || fieldType.intern() == "double") {
								field.setDouble(t, rs.getDouble(field.getName()));
							} else if (fieldType.intern() == "java.lang.Float" || fieldType.intern() == "float") {
								field.setDouble(t, rs.getFloat(field.getName()));
							} else if (fieldType.intern() == "java.io.InputStream") {
								// field.set(t, rs.getBlob(fieldType));
								InputStream in = rs.getBlob(field.getName()).getBinaryStream();
								ByteArrayOutputStream out = new ByteArrayOutputStream();
								byte[] bs = new byte[1024];
								int len = 0;
								while ((len = in.read(bs)) != -1) {
									out.write(bs, 0, len);
								}
								out.flush();
								field.set(t, new ByteArrayInputStream(out.toByteArray()));
								in.close();
								out.close();
							} else if (fieldType.intern() == "java.util.Date"
									|| fieldType.intern() == "java.sql.Date") {
								field.set(t, new java.util.Date(rs.getTimestamp(field.getName()).getTime()));
							} else {
								field.set(t, rs.getObject(field.getName()));
							}
						} catch (Exception e) {
						}
					}
					return t;
				} catch (InstantiationException | IllegalAccessException e) {
					throw new RuntimeException("创建对象失败！！！", e);
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException("创建sql执行工具出错！！！", e);
		} finally {
			close(con, pst, rs);
		}
		return null;
	}

	/**
	 * 遍历
	 * 
	 * @param sql
	 * @param params
	 * @return
	 */
	public static List<Map<String, Object>> list(String sql, Object... params) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = getConn();
			pst = con.prepareStatement(sql);
			setPlaceHolderValue(pst, params);
			rs = pst.executeQuery();
			List<Map<String, Object>> list = new ArrayList<>();
			boolean flag = false;
			while (rs.next()) {
				flag = true;
				Map<String, Object> map = new HashMap<String, Object>();
				ResultSetMetaData rsmd = rs.getMetaData();
				;
				int columnCount = rsmd.getColumnCount();
				for (int i = 0; i < columnCount; i++) {
					map.put(rsmd.getColumnLabel(i + 1), rs.getObject(i + 1));
				}
				list.add(map);
			}
			return flag ? list : null;
		} catch (SQLException e) {
			throw new RuntimeException("创建数据库连接出错！！！", e);
		} finally {
			close(con, pst, rs);
		}
	}
	
	public double selectFunc(String sql,List<Object> params) throws Exception{
		double result=0;
		Connection con=getConn();
		PreparedStatement stmt=con.prepareStatement(sql);
		if(params!=null && params.size()>0){
			for(int i=0;i<params.size();i++){
				stmt.setString(i+1, params.get(i).toString());
			}
		}
		ResultSet rs=stmt.executeQuery();
		if(rs.next()){
			result=rs.getDouble(1);
		}
		close(con,stmt,rs);
		return result;
	}
	
	public double selectFunc(String sql,Object... params) throws Exception{
		List<Object> pp = new ArrayList<Object>();
		if(params != null && params.length>0){
			for(Object o:params){
				pp.add(o);
			}
		}
		return selectFunc(sql,pp);
	}

	public List<Map<String,String>> select(String sql,List<Object> params) throws Exception{
		List<Map<String,String>> list=new ArrayList<Map<String,String>>();
		Connection con=getConn();
		PreparedStatement stmt=con.prepareStatement(sql);
		if(params!=null && params.size()>0){
			for(int i=0;i<params.size();i++){
				stmt.setString(i+1, params.get(i).toString());
			}
		}
		ResultSet rs=stmt.executeQuery();
		ResultSetMetaData rsmd=rs.getMetaData();	//ͨ��Ԫ������֪���ж�����
		int cc=rsmd.getColumnCount();
		List<String> columnNames=new ArrayList<String>();
		for(int i=0;i<cc;i++){
			String cn=rsmd.getColumnLabel(i+1);
			columnNames.add(cn);	//�������
		}
		//ѭ�����еĽ������¼
		while(rs.next()){
			//ÿһ�����ݾ���һ��Map����
			Map<String,String> map=new HashMap<String,String>();
			//ѭ��ÿ����¼���е�����
			for(int i=0;i<columnNames.size();i++){
				String cn=columnNames.get(i);	//����
				String value=rs.getString(cn);	//��������ȡֵ
				map.put(cn, value);		//�浽map��, ��(����)   ֵ(ֵ)
			}
			list.add(map);
		}
		close(con,stmt,rs);
		return list;
	}
	
	public <T> List<T> select(Class<T> cls,String sql,Object...params) throws Exception{
		List<T> list = new ArrayList<T>();
		List<Object> pp = new ArrayList<Object>();
		if(params != null && params.length>0){
			for(Object o:params){
				pp.add(o);
			}
		}
		List<Map<String,String>> listMap = select(sql,pp);
		//将listMap转为 List<T>
		for(Map<String,String> map:listMap){
			T t = parseRequest(map,cls);
			list.add(t);
		}
		return list;
	}
	
	public  <T> T parseRequest( HttpServletRequest request,Class<T> clz) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		//创建clz对象 反射实例
		T obj = clz.newInstance();
		//将参数存成单个值
		Map<String,String[]> maps = request.getParameterMap();
		Map<String,String> m = new HashMap<String,String>();
		for(Map.Entry<String, String[]> entry:maps.entrySet()){
			m.put(entry.getKey(), entry.getValue()[0]);
		}
		return parseRequest(m,clz);
	}
	
	public <T> T parseRequest(Map<String,String> m,Class<T> clz) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException{
		//创建clz对象 反射实例
		T obj = clz.newInstance();
		//取set方法
		List<Method> allSetMethods = getAllSetMethods(clz);
		//循环 m,取出每个参数
		for(Map.Entry<String, String> entry:m.entrySet()){
			String parameterName = entry.getKey(); //pname price
			String parameterValue = entry.getValue(); // apple 20
			
			//取allSetMethods中的方法的方法名
			for(Method method:allSetMethods){
				String methodName = method.getName(); //setPname setPrice
				if(methodName.equalsIgnoreCase("set"+parameterName)){
					
					//取出当前method中的参数类型，判断是哪一种，再进行类型转换
					String parameterTypeName = method.getParameterTypes()[0].getName();
					if(parameterValue==null){
						continue;
					}else{
						if("double".equals(parameterTypeName) || "java.lang.Double".equals(parameterTypeName)){
							double v = Double.parseDouble(parameterValue);
							method.invoke(obj, v);
						}else if("int".equals(parameterTypeName) || "java.lang.Integer".equals(parameterTypeName)){
							int v = Integer.parseInt(parameterValue);
							method.invoke(obj, v);
						}else if("float".equals(parameterTypeName) || "java.lang.Float".equals(parameterTypeName)){
							float v = Float.parseFloat(parameterValue);
							method.invoke(obj, v);
						}else{
							//激活方法： argument type mismatch
							method.invoke(obj,parameterValue); //price类中double型，但map中的price是String，所以类型转换
						}
					}
					
				}
 			}
		}
		return obj;
	}
	private List<Method> getAllSetMethods(Class clz){
		List<Method> allSetMethods = new ArrayList<Method>();
		Method[] ms = clz.getMethods();  //clz中的所有方法
		for( Method m:ms){
			if(m.getName().startsWith("set")){ //只要set方法
				allSetMethods.add(m);
			}
		}
		return allSetMethods;
	}
	
	public static <T> List<T> list(Class<T> clazz, String sql, Object... params) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = getConn();
			pst = con.prepareStatement(sql);
			setPlaceHolderValue(pst, params);
			rs = pst.executeQuery();
			List<T> list = new ArrayList<T>();
			boolean flag = false;
			while (rs.next()) {
				T t = null;
				try {
					flag = true;
					t = clazz.newInstance();
					Field[] fs = clazz.getDeclaredFields();
					for (Field field : fs) {
						field.setAccessible(true);
						String fieldType = field.getType().getName();
						try {
							if (fieldType.intern() == "java.lang.Integer" || fieldType.intern() == "int") {
								field.setInt(t, rs.getInt(field.getName()));
							} else if (fieldType.intern() == "java.lang.Double" || fieldType.intern() == "double") {
								field.setDouble(t, rs.getDouble(field.getName()));
							} else if (fieldType.intern() == "java.lang.Float" || fieldType.intern() == "float") {
								field.setDouble(t, rs.getFloat(field.getName()));
							} else if (fieldType.intern() == "java.io.InputStream") {
								// field.set(t, rs.getBlob(fieldType));
								InputStream in = rs.getBlob(field.getName()).getBinaryStream();
								ByteArrayOutputStream out = new ByteArrayOutputStream();
								byte[] bs = new byte[1024];
								int len = 0;
								while ((len = in.read(bs)) != -1) {
									out.write(bs, 0, len);
								}
								out.flush();
								field.set(t, new ByteArrayInputStream(out.toByteArray()));
								in.close();
								out.close();
							} else if (fieldType.intern() == "java.util.Date"
									|| fieldType.intern() == "java.sql.Date") {
								field.set(t, new java.util.Date(rs.getTimestamp(field.getName()).getTime()));
							} else {
								field.set(t, rs.getObject(field.getName()));
							}
						} catch (Exception e) {
						}
					}
				} catch (InstantiationException | IllegalAccessException e) {
					throw new RuntimeException("创建对象失败！！！", e);
				}
				list.add(t);
			}
			return flag ? list : null;
		} catch (SQLException e) {
			throw new RuntimeException("创建数据库连接出错！！！", e);
		} finally {
			close(con, pst, rs);
		}
	}
}
