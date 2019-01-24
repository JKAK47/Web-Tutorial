<%--
  Created by IntelliJ IDEA.
  User: PengRong
  Date: 2019/1/24
  Time: 17:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
    获取 Servlet java代码设置的值

--%>
<%
    String thisServletClassName= (String) request.getAttribute("this");
    String  contextPath = (String) request.getAttribute("contextPath");
    String servletPath = (String) request.getAttribute("servletPath");
%>
<html>
<head>
    <title>display urlpattern </title>
</head>
<body>
<h2>This is： <%=thisServletClassName%></h2>
<h2>contextPath： <%=contextPath%></h2>
<h2>servletPath： <%=servletPath%></h2>

</body>
</html>
