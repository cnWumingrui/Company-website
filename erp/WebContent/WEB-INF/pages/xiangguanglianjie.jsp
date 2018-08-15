<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
    
    <script type="text/javascript" >
    	function gotopage(address){
    		window.open(address);
    	}
    </script>
<div id="xiangguanglianjie">
                            <div id="center_b_r_b_t"></div>
                            <div id="center_b_r_b_b">
                                <select onchange="gotopage(this.value)">
                                	<c:forEach items="${friendlinkList }" var="friendlink">
                                    	<option value="${friendlink.web_address }">${friendlink.web_name }</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>