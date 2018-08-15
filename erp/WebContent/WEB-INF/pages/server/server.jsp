<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../header.jsp" %>   

<div id="toutiaoxinwen">
                <div id="center_top_right_c">
	                    <c:forEach items="${requestScope.serverPageBean.list }" var="server">
	                        <a href="server.action?op=detail&id=${server.id }" id="headlineNews">${server.title }</a>
	                        <span>${server.join_date } </span>
	                        <hr width="80%"/>
	                    </c:forEach>
                    <br />
                    <yc:pageBar href="server.action?op=show" pageBean="${requestScope.serverPageBean}"></yc:pageBar>
                </div>
                
            </div>


<%@include file="../bottom.jsp" %>  