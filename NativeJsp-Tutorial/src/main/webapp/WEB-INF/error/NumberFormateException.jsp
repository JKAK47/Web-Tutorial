<%--
  Created by IntelliJ IDEA.
  User: PengRong
  Date: 2019/1/28
  Time: 0:06
  To change this template use File | Settings | File Templates.

  因为这个页面调用了exception内置对象，所以isErrorPage必须为true。
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true"%>
<html>
<head>
    <title>NumberFormateException</title>
</head>
<body>
<h1>错误:</h1><%=exception%>
<h2>错误内容:</h2>
<%
    exception.printStackTrace(response.getWriter());
%>
</body>
</html>
