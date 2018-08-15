<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../header.jsp"%>

<div id="toutiaoxinwen">
                <div id="center_top_right_c">
	                    <c:forEach items="${requestScope.jobPageBean.list }" var="job">
	                        <a href="job.action?op=detail&id=${job.id }" id="headlineNews">${job.inviter }</a>
	                        <span>${job.join_date } </span>
	                        <hr width="80%"/>
	                    </c:forEach>
                    <br />
                    <yc:pageBar href="job.action?op=show" pageBean="${requestScope.jobPageBean}"></yc:pageBar>
                </div>
                
            </div>


<%@include file="../bottom.jsp"%>
