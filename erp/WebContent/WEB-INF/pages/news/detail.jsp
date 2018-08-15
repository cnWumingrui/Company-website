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
                	<h2>${news.title }</h2>
                	<br /> 来自：${news.laiz }  创建时间：${news.join_date }
                	最后修改时间：${news.change_date }  <br />
                	<hr />
                	<c:if test="${news.picture!=null  && news.picture!='' }">
                		<img src="${news.picture }" width="100px" height="100px" />
                	</c:if>
                	<br />  ${news.content }
                </div>
                
            </div>


<%@include file="../bottom.jsp" %>  