<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="org.vincent.pojo.User" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags" %>
<%

    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path;
    User totalNew = (User) request.getAttribute("user");
    System.out.println(totalNew.getName());
    System.out.println( ((User) request.getAttribute("user")).getName());
    String URL=request.getRequestURL().toString();
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>index</title>
</head>
<body>
<h2>Hello World!sfasdfasdhttp://localhost:8080/springmvc-demo-databind-02/</h2>
<h3> ${user.name} EL expression</h3>
<h3> <%= ((User) request.getAttribute("user")).getName() %></h3><%-- 这个 是获取request 中的值 的  ，其他的不 行  , 务必保证不是空指针 --%>
<h3> <%= ((User) session.getAttribute("user")).getName() %></h3><%-- 这个 是获取 session 中的值 的  ，其他的不行, 务必保证不是空指针--%>
<h4>${user.name } </br> ${user.id}</h4>
<h4>Map: ${requestScope.names}</h4>
<h4>${requestScope.user}</h4>
<h4>${sessionScope.user}</h4>
<h5>${pageContext.request.getAttribute("user")}</h5>

</body>
</html>
