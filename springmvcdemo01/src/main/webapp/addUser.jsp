<%--
  Created by IntelliJ IDEA.
  User: PengRong
  Date: 2019/5/13
  Time: 23:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>添加用户</title>
</head>
<body>
<form action="/springmvc-demo-01/addUser" method="POST">
    编号：<input type="text" name="id"/><br/>
    姓名：<input type="text" name="name"/><br/>
    地址：<input type="text" name="address.name"/><br/>
    <input type="submit" value="提交"/>
</form>
</body>
</html>