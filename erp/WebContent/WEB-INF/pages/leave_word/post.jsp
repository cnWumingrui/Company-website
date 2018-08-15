<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<center>
	<form action="doPost.jsp" method="post" enctype="multipart/form-data">
		内容：<textarea rows="5" cols="20" name="contents"></textarea>
		<br/>
		贴图：<input type="file" name="pic"/><br/>
		<input type="submit"/>
	</form>
</center>