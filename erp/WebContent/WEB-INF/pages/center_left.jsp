<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<div id="center_line"></div>
    	<div id="center_top">
            <div id="gongsijianjie">
                <div id="center_top_left_t"></div>
                <div id="center_top_left_b">
                    <ul>
              			<c:forEach items="${infotypeList }" var="infotype">
                        	<li><a href="companyinfo.action?op=show&typename=${infotype.typename }">${infotype.typename }</a></li>
              			</c:forEach>
                    </ul>
                </div>
            </div>