<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="yc"  uri="http://www.hyycinfo.com/taglib/"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${webconfigList[0].web_name}</title>

<base href="${basePath}" />

<style>
	*{
		margin:0px auto;
		padding:0px;
	}
	
	#top{
		width:867px;
		height:200px;
	}
	
	#top embed{
		width:100%;
		height:100%;
	}
	
	#menu_line{
		width:867px;
		height:2px;
        background-color: aliceblue;
	}
	
	#menu{
		height:45px;
		width:867px;
	}
	
	#menu a{
		text-decoration:none;
		color:white;
	}
	
	#menu a:hover{
		color:greenyellow;
		font-size:18px;
		font-weight:bold;
	}

	#menu li{
		list-style:none;
		float:left;
		width:120.7px;
		height:44px;
		text-align:center;
		line-height:51px;
		background-image:url(images/dh_dt.gif);
	}

    #gdxw2{
        float:right;
        padding-top: 14px;
        padding-right: 10px;
    }

    #center_line{
        width:867px;
        height:5px;
        background-color: orange;
    }
	
	#center{
		width:867px;
		height:900px !important;
	}
	
    #center_top{
        width: 100%;
        height: 35%;
    }

    #gongsijianjie{
        width: 23%;
        height:100%;
        float: left;
        background-color: rgba(69,128,117,0.1);
    }

    #center_top_left_t{
        width: 100%;
        height:15%;
        background-image: url(images/gsjs.gif);
        background-repeat: space;
        border-top-left-radius: 10px;
        border-top-right-radius: 10px;
        border-bottom-left-radius: 10px;
        border-bottom-right-radius: 10px;
    }

    #center_top_left_b{
        width: 100%;
        height:85%;
    }

    #center_top_left_b li{
        margin-top: 10px;
        list-style:none;
        float: left;
        width: 200px;
        height: 40px;
        line-height:43px;
        text-align:center;
        background: url(images/2j_gsyw.gif) no-repeat;
        background-size:100% auto;
    }

    #center_top_left_b li a{
        text-decoration:none;
        color:black;
    }

    #toutiaoxinwen{
        width: 77%;
        height:100%;
        float: right;
        border-top-left-radius:10px;
        border-top-right-radius:10px;
        background: url(images/tt_02.gif) repeat-x;
    }

    #center_top_right_c{
        width: 97%;
        height:95%;
        margin:10px auto;
        border-top-left-radius:10px;
        border-top-right-radius:10px;
        background-color: white;
    }

    #center_top_right_c_l{
        float: left;
        height: 85%;
        width: 67%;
        margin-top: 15px;
        margin-left: 5px;
    }

    #headlineNews{
        width:100%;
        text-align: center;
        font-weight: bolder;
    }

    #underline{
        width: 100%;
        height: 10px;
        background: url(images/tt_xx.gif) repeat-x;
    }

    #headlineNewsContexts{
        margin-top: 20px;
        width: 100%;
        height: 70%;
    }

    #center_top_right_c_r{
        float: right;
        height: 60%;
        width: 30%;
        margin-top: 15px;
        margin-right: 5px;
    }

    #center_bottom{
        width: 100%;
        height: 65%;
    }

    #center_bottom_top{
        width: 100%;
        height: 5%;
    }

    #center_bottom_bottom{
        width: 100%;
        height: 93%;
    }

    #center_bottom_top_l{
        height: 100%;
        width: 26.5%;
        float: left;
        background: url(images/tgl.gif) no-repeat;
        background-size:auto 100%;
    }

    #center_bottom_top_r{
        height: 100%;
        width: 73.5%;
        float: right;
        background: url(images/zxdt02.gif) repeat-x;
        background-size:auto 100%;
    }

    #tonggaolan{
        float: left;
        width: 22%;
        height: 100% !important;
    }

    #tonggaolan a{
        text-decoration:none;
        color: black;
    }

    #tonggaolan ul{
        width:100%;
    }

    #tonggaolan li{
        list-style:none;
        width: 100%;
        height: 3%;
        text-align:left;
        font-size: 10px;
    }

    #center_bottom_img{
        height: 5px;
        width: 100%;

    }

    #center_bottom_img2{
        float: left;
        margin-top: 5px;
        margin-left: 20px;
    }

    #center_bottom_right{
        float: right;
        width: 78%;
        height: 100%;
    }

    #center_b_r_left{
        float: left;
        width: 65%;
        height: 100%;
    }

    #gongsixinwen{
        width: 100%;
        height: 50%;
     }

    #gongsixinwen a{
        text-decoration:none;
        color: black;
    }

    #center_b_r_l_t_t{
        width:100%;
        height:10%;
        background: url(images/gsxw.gif) no-repeat;
        background-size: 100% 100%;
    }

    #center_b_r_l_t_b ul{
        width:100%;
     }

    #center_b_r_l_t_b li{
        list-style:none;
        width: 100%;
        height: 3%;
        text-align:left;
        font-size: 10px;
    }

    #changpinzhanshi{
        width: 100%;
        height: 50%;
    }

    #center_b_r_l_b_t{
        width:100%;
        height:10%;
        background: url(images/cpzs.gif) no-repeat;
        background-size: 100% 100%;
    }

    #center_b_r_l_b_b li{
        list-style:none;
        width: 100px;
        height:100px;
        float:left;
        padding:50px 0 0 50px;
    }

    #center_b_r_l_b_b img{
        width: 100px;
        height: 100px;
    }

    #center_b_l_right{
        float: right;
        width: 35%;
        height: 100%;
    }

    #zhanneisousuo{
        width: 100%;
        height: 150px;
    }

    #center_b_r_t_t{
        width:100%;
        height:19%;
        background: url(images/ztzl.gif) no-repeat;
        background-size: 100% 100%;
    }

    #center_b_r_t_b{
        width:100%;
        height:40%;
        margin-top: 10px;
    }

    #center_b_r_t_b select{
        width: 80px;
        height: 20px;
    }

    #xiangguanglianjie{
        width: 100%;
        height: 150px;
    }

    #center_b_r_b_t{
        width:100%;
        height:19%;
        background: url(images/xglj.gif) no-repeat;
        background-size: 100% 100%;
    }

    #center_b_r_b_b select{
        width: 150px;
        height: 20px;
     }

    #center_line_bottom{
        width: 100%;
        height: 10px;
        background: url(images/tt_xx.gif) repeat-x;
    }

	#bottom{
		width:867px;
		height:100px;
		background-color:#CCC;
	}

    #bottom p{
        padding-top: 23px;
        font-size: 10px;
        text-align: center;
    }
	
</style>
</head>
<body>
	<c:if test="${webconfigList[0].banner!=null && webconfigList[0].banner!='' }">
		<div id="top">
	    	<embed src="${webconfigList[0].banner }" title="banner"></embed>
	    </div>
    </c:if>
     <div id="menu">
        <div id="menu_line"></div>
        <img id="dh_l" src="images/dh_l.gif"  style="float:left;"/>
    	<ul>

        	<li><a href="index.jsp">首页</a><img id="gdxw2" src="images/gdxw2.gif"/></li>
            <li><a href="companyinfo.action?op=show">公司介绍</a><img id="gdxw2" src="images/gdxw2.gif"/></li>
            <li><a href="news.action?op=show">新闻中心</a><img id="gdxw2" src="images/gdxw2.gif"/></li>
            <li><a href="product.action?op=show">产品信息</a><img id="gdxw2" src="images/gdxw2.gif"/></li>
            <li><a href="server.action?op=show">服务与支持</a><img id="gdxw2" src="images/gdxw2.gif"/></li>
            <li><a href="job.action?op=show">招贤纳士</a><img id="gdxw2" src="images/gdxw2.gif"/></li>
            <li><a href="leave_word.action?op=show">联系我们</a></li>
        </ul>
        <img id="dh_r" src="images/dh_r.gif"/>
    </div>
  <div id="center">
        <div id="center_line"></div>
	