<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="../header.jsp"%>
<div id="center_line"></div>



<div id="center_top">
	<div id="gongsijianjie">
		<div id="center_top_left_b">
			<ul>
				<c:forEach items="${product_classList }" var="product_class">
					<li>
						<a
							href="product.action?op=show&product_class=${product_class.id }&protype=${product_class.protype }"
						>${product_class.protype }</a>
					</li>
				</c:forEach>
			</ul>
		</div>
	</div>

	<div id="toutiaoxinwen">
		<div id="center_top_right_c">
			<div id="center_top_right_c_l">

				<c:forEach items="${requestScope.productPageBean.list }" var="product">
					<a href="product.action?op=detail&id=${product.id }">${product.product_name }</a>
					<span>${product.change_date }</span>
					<hr width="100%" />
				</c:forEach>
				<yc:pageBar pageBean="${requestScope.productPageBean }"
					href="product.action?op=show&product_class=${requestScope.id }"
				></yc:pageBar>
			</div>
		</div>

	</div>

	<%@ include file="../bottom.jsp"%>