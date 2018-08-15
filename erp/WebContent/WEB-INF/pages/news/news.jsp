<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../header.jsp" %>   
<div id="center_line"></div>
    	<div id="center_top">
            <div id="gongsijianjie">
                <div id="center_top_left_t"></div>
                <div id="center_top_left_b">
                    <ul>
                    	<c:forEach items="${news_classList }" var="news_class">
                        	<li><a href="news.action?op=show&id=${news_class.id }&typename=${news_class.typename }">${news_class.typename }</a></li>
              			</c:forEach>
                    </ul>
                </div>
            </div>
            
<div id="toutiaoxinwen">
                <div id="center_top_right_c">
	                    <c:forEach items="${requestScope.newsPageBean.list }" var="news">
	                        <a href="news.action?op=detail&id=${news.id }" id="headlineNews">${news.title }</a><span>${news.change_date }</span>
	                        <hr width="85%"/>
	                    </c:forEach>
                    <br />
                    <yc:pageBar href="news.action?op=show&id=${id }" pageBean="${requestScope.newsPageBean}"></yc:pageBar>
                </div>
                
            </div>


<%@include file="../bottom.jsp" %>  