package com.yc.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;



public class RequestUtils {
	/**
	 * 工具类：将request中的参数取出，，将参数值对应的存到一个clz生成的对象中。 注意：
	 * 
	 * @param request
	 * @param clz
	 * @return
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws InvocationTargetException
	 * @throws IllegalArgumentException
	 */
	public static <T> T parseRequest(HttpServletRequest request, Class<T> clz)
			throws InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		// 1创建clz的对象 反射实例
	//	T obj = clz.newInstance(); // product p=new Product()    //newInstance()调用的是无参的构造方法
		// 将参数值存成单个的值
		Map<String, String[]> maps = request.getParameterMap();
		Map<String, String> m = new HashMap<String, String>();
		for (Map.Entry<String, String[]> entry : maps.entrySet()) {
			m.put(entry.getKey(), entry.getValue()[0]);
		}
		return parseRequest(m, clz);

	}

	public static <T> T parseRequest(Map<String,String> m, Class<T> clz)
			throws InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		// 1创建clz的对象 反射实例
		T obj = clz.newInstance(); // product p=new Product()

		// 取set方法
		List<Method> allSetMethods = getAllSetMethods(clz);
		// 循环m 取出每个参数
		for (Map.Entry<String, String> entry : m.entrySet()) {
			String parameterName = entry.getKey();// pname price
			String parameterValue = entry.getValue();// apple 23
			// 取出allSetMethods中的方法的方法名
			for (Method method : allSetMethods) {
				String methodName = method.getName();// setPname setPrice
				if (methodName.equalsIgnoreCase("set" + parameterName)) {
					// 取出当前method中的参数类型，判断是哪种，在进行类型转换
					String parameterTypeName = method.getParameterTypes()[0]
							.getName();
					if ("double".equals(parameterTypeName)
							|| "java.lang.Double".equals(parameterTypeName)) {
						double v = Double.parseDouble(parameterValue);
						method.invoke(obj, v);
					} else if ("int".equals(parameterTypeName)
							|| "java.lang.Integer".equals(parameterTypeName)) {
						int v = Integer.parseInt(parameterValue);
						method.invoke(obj, v);

					} else if ("int".equals(parameterTypeName)
							|| "java.lang.Integer".equals(parameterTypeName)) {
						int v = Integer.parseInt(parameterValue);
						method.invoke(obj, v);
					} else {
						//激活方法  argument  type mismatch
						method.invoke(obj, parameterValue);//price 在product中double类型，但map中price是String  要类型转换
					}
				}
			}
		}
		return obj;

	}

	/**
	 * 取出一个类中的所有的set方法
	 * 
	 * @param clz
	 * @return
	 */
	private static List<Method> getAllSetMethods(Class clz) {
		List<Method> allSetMethods = new ArrayList<Method>();
		Method[] ms = clz.getMethods();
		for (Method m : ms) {
			if (m.getName().startsWith("set")) {
				allSetMethods.add(m);
			}
		}
		return allSetMethods;
	}


}
