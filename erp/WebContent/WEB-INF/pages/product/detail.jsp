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
						<a href="product.action?op=show&product_class=${product_class.id }&protype=${product_class.protype }">${product_class.protype }</a>
					</li>
				</c:forEach>
			</ul>
		</div>
	</div>

	<div id="toutiaoxinwen">
		<div id="center_top_right_c">
			<div id="center_top_right_c_l">
				<h2>${product.product_name }</h2>
				<br />
				来自:${product.product_in }
				<br />
				创建时间：${product.join_date }
				<br />
				最后修改时间：${product.change_date }
				<br />
				<c:if test="${product.product_picture!=null && product.product_picture!='' }">
					<img src="${product.product_picture }" width="100px" height="100px" />
				</c:if>
				<br />
				${product.product_explain }

			</div>
		</div>

	</div>

	<%@ include file="../bottom.jsp"%>