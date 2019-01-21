<%--
  Created by IntelliJ IDEA.
  User: PengRong
  Date: 2019/1/20
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*"   pageEncoding="UTF-8" %>
<!-- 网页头部 部分 -->
<div class="header_bg">
    <div class="wrap">
        <div class="header">
            <div class="logo">
                <%-- 返回webapp下的 index.jsp  --%>
                <a href="../font/indextest.jsp"><img src="../img/logo.png" alt=""> </a>
            </div>
            <div class="pull-icon">
                <a id="pull"></a>
            </div>
            <div class="cssmenu">
                <ul>
                    <li>
                        <a href="../font/indextest.jsp">首页</a>
                    </li>
                    <li>
                        <a href="about.jsp">企业简介</a>
                    </li>
                    <li>
                        <%-- 通过a标签超链接调用servlet ，并传递Url参数 --%>
                        <a href="../newsA?id=10&name=20">新闻</a>
                    </li>
                    <li>
                        <a href="content.jsp">核心竞争力</a>
                    </li>
                    <li class="last">
                        <a href="contact.jsp">联系我们</a>
                    </li>
                </ul>
            </div>
            <!--清除浮动-->
            <div class="clear"></div>
        </div>
    </div>
</div>
<!--头部-->

