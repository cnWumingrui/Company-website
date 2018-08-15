<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../header.jsp" %> 


<div id="toutiaoxinwen">
                <div id="center_top_right_c">
	            	<span><a href="pages/leave_word/post.jsp">发表留言</a></span><br>
	            	<hr>
	            	<c:forEach items="${requestScope.leave_wordPageBean.list }" var="leave_word">
	                	<a href="leave_word.action?op=detail&id=${leave_word.id }" id="headlineNews">${leave_word.title }</a>
	                    <span>${leave_word.join_date }</span>
	                    <hr width="85%"/>
	                </c:forEach>
                    <br />
                    <yc:pageBar href="leave_word.action?op=show" pageBean="${requestScope.leave_wordPageBean}"></yc:pageBar>
                </div>
                
            </div>


<%@include file="../bottom.jsp" %>  