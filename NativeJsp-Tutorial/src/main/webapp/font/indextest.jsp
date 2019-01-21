<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    /**
     * request ：HttpServletRequest
     * 应用上下文 path ：/nativejsp
     */
    String path = request.getContextPath();
    /**
     * basePath = http://localhost:8088/nativejsp
     */
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path;
%>
<html>
<head>
    <%-- 添加 html head 头元素--%>
    <meta charset="UTF-8" content="text/html" http-equiv="content-type"/>
    <link href="css/main.css" type="text/css" rel="stylesheet" media="all"/>
</head>
<body>
<%--<h1><%=path%></h1>
<h1><%=basePath%></h1>--%>

<%-- 顶部导航栏 include 指令插入 导航栏代码--%>
<%@include file="page-header.jsp" %>

<%-- 页面中部实现图片轮播  --%>
<!--轮播 -->
<div id="fwslider" style="height: 554px;">
    <div class="slider_container">
        <div class="slide" style=" opacity: 1; z-index: 0; display: none;">
            <img id="img1" src="../img/img1.jpg">
        </div>
        <div class="slide" style="opacity: 1; z-index: 1; display: block;">
            <img id="img2" src="../img/img2.jpg">
        </div>
        <div class="slide" style="opacity: 1; z-index: 1; display: block;">
            <img id="img3" src="../img/img3.jpg">
        </div>
        <div class="slide" style=" opacity: 1;z-index: 0; display: none;">
            <img id="img4" src="../img/img4.jpg">
        </div>
        <div class="slide" style=" opacity: 1;z-index: 0; display: none;">
            <img id="img5" src="../img/img5.jpg">
        </div>
    </div>
    <%-- 实现图片左右滑动 以及定时图片切换  --%>
    <%-- 定时轮播  --%>
    <div class="timers" style="width: 180px;">
    </div>
    <%-- 左边图片 --%>
    <div class="slidePrev" style="left: 0px; top: 252px;">
        <span></span>
    </div>
    <%-- 右边图片 --%>
    <div class="slideNext" style="right: 0px; top: 252px; opacity: 0.5;">
        <span></span>
    </div>


</div>
<!--轮播结束 -->
<%-- 页面底部 功能栏 --%>
<!-- start main-->
<div class="main_bg">
    <div class="business">
        业务领域 BUSINESS
    </div>
    <div class="wrap w_72">
        <div class="grids_1_of_3">
            <div class="grid_1_of_3  images_1_of_3">
                <img src="../img/pic1.png" >

            </div>
            <div class="grid_1_of_3  images_1_of_3">
                <img src="../img/pic2.png" >

            </div>
            <div class="grid_1_of_3  images_1_of_3">
                <img src="../img/pic3.png" >

            </div>
            <div class="grid_1_of_3  images_1_of_3">
                <img src="../img/pic4.png" >

            </div>
            <div class="grid_1_of_3  images_1_of_3"  style="background: none">
                <img src="../img/pic5.png" >

            </div>
            <div class="clear"></div>
        </div>
    </div>
    <%-- 网页页脚 --%>
    <%@include file="common_footer.jsp"%>
</div>
<!-- start  main-->



<%-- 加載用於圖片轮播 js 代码，和当前jsp 页面在同一级页面目录下 --%>
<script src="js/jquery.min.js"></script>
<script src="js/jquery-ui.min.js"></script>
<%-- 用于图片轮播左右按钮事件响应  --%>
<script src="js/fwslider.js"></script>
</body>


</html>
