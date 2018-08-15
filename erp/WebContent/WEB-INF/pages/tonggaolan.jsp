<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<div id="center_bottom_bottom">
                <div id="tonggaolan">
                    <ul>
                    	<c:forEach items="${pronunciamentPageBean.list }" var="p">
                    	  <li><img src="images/arrow_02.gif" id="center_bottom_img2"/><a href="?id=${p.id }">${p.titleFormat}</a><img src="images/line01.gif" id="center_bottom_img" /></li>
                    	</c:forEach>
                    </ul>
                </div>