<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%-- 基于Jsp 实现一个首页  --%>
<html>
<head>
    <%-- 添加 html head 头元素--%>
    <meta charset="UTF-8" content="text/html" http-equiv="content-type"/>
</head>
<body>
<h2>JSP 用java 代码思维写HTML代码，相当于在html 标签中写java 代码片段进行 插入数据</h2>
<%=
request.getRemoteHost()
%>
<
<hr/>
<%-- 页面里面跳转只能跳转webapp目录下的页面，WET-INF目录下的页面不能访问。
 font/indextest.jsp 是webapp 目录下的font 目录，
 WEB-INF/font/indextest.jsp 这个目录下的页面通过页面跳转是不能访问
 --%>
<button><a href="font/indextest.jsp">第一个jsp 页面 indextest.jsp</a></button>

<%-- 页面加载完后直接通过js 跳转到另外一个页面（indextest.jsp) --%>
<%--<script>
    window.location.href="font/indextest.jsp"
</script>--%>

</body>
</html>
