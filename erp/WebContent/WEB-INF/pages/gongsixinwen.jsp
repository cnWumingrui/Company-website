<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<div id="center_bottom_right">
                    <div id="center_b_r_left">
                        <div id="gongsixinwen">
                            <div id="center_b_r_l_t_t"></div>
                            <div id="center_b_r_l_t_b">
                                <ul>
                                	<c:forEach items="${newsPageBean.list }" var="n">
                                    	<li><img src="images/arrow_02.gif" id="center_bottom_img2"/><a href="?id=${n.id }">${n.titleFormat }</a><img src="images/line01.gif" id="center_bottom_img" /></li>
									</c:forEach>
                                </ul>
                            </div>
                        </div>