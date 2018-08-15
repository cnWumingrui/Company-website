<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../header.jsp" %>   
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
            
<div id="toutiaoxinwen">
                <div id="center_top_right_c">
                    <div id="center_top_right_c_l">
                        <p id="headlineNews">${requestScope.companyinfo.title }</p>
                        <div id="underline"></div>
                        <p id="headlineNewsContexts">${requestScope.companyinfo.content }</p>
                    </div>
                    <div id="center_top_right_c_r">
                    	<c:if test="${requestScope.companyinfo.picture==null  || requestScope.companyinfo.picture=='' }">
                    		<img src="images/example.jpeg" style="background: fixed;width: 100%;height: 100%" />
                        </c:if>
                        <c:if test="${requestScope.companyinfo.picture!=null  && requestScope.companyinfo.picture!='' }">
                    		<img src="${requestScope.companyinfo.picture }" style="background: fixed;width: 100%;height: 100%" />
                        </c:if>
                    </div>
                </div>
            </div>


<%@include file="../bottom.jsp" %>  