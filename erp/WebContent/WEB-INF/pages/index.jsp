<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="header.jsp" %>    
<%@include file="center_left.jsp" %>  
            <div id="toutiaoxinwen">
                <div id="center_top_right_c">
                    <div id="center_top_right_c_l">
                        <p id="headlineNews">${companyinfo.title }</p>
                        <div id="underline"></div>
                        <p id="headlineNewsContexts">${companyinfo.content }</p>
                    </div>
                    <div id="center_top_right_c_r">
                    	<c:if test="${companyinfo.picture==null  || companyinfo.picture=='' }">
                    		<img src="images/example.jpeg" style="background: fixed;width: 100%;height: 100%" />
                        </c:if>
                        <c:if test="${companyinfo.picture!=null  && companyinfo.picture!='' }">
                    		<img src="${companyinfo.picture }" style="background: fixed;width: 100%;height: 100%" />
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
<%@include file="center_bottom_top.jsp" %>
<%@include file="tonggaolan.jsp" %>    
<%@include file="gongsixinwen.jsp" %>    
<%@include file="changpinzhanshi.jsp" %>    
<%@include file="zhanneisousuo.jsp" %>    
<%@include file="xiangguanglianjie.jsp" %>    
      
<%@include file="bottom.jsp" %>  