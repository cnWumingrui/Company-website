<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../header.jsp"%>
<div id="toutiaoxinwen">
	<div id="center_top_right_c">
		<h2>${server.title }</h2>
		<br /> 创建时间：${server.join_date }  <br />
		<hr />
		<c:if test="${server.pic!=null  && server.pic!='' }">
			<img src="${server.pic }" width="100px" height="100px" />
		</c:if>
		<br /> ${server.content }
	</div>

</div>

<%@include file="../bottom.jsp"%>
