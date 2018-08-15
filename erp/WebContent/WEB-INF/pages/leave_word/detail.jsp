<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../header.jsp"%>
<div id="toutiaoxinwen">

	<div id="center_top_right_c">
		<h2>${leave_word.title }</h2>
		<br /> 创建时间：${leave_word.join_date }  <br />
		<hr />
		fax:${leave_word.fax }     email:${leave_word.email }  
		<c:if test="${server.pic!=null  && server.pic!='' }">
			<img src="${server.pic }" width="100px" height="100px" />
		</c:if>
		<br /> ${leave_word.content }
	</div>

</div>

<%@include file="../bottom.jsp"%>
    