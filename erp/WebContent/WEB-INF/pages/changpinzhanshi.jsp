<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<div id="changpinzhanshi">
                            <div id="center_b_r_l_b_t"></div>
                            <div id="center_b_r_l_b_b">
                                <ul>
                                	<c:forEach items="${productPageBean.list }" var="p">
                                    	<li><a href="?id=${p.id }"><img src="${p.product_picture }"/></a> </li>
                                   	</c:forEach>
                                </ul>
                            </div>
                        </div>
                    </div>