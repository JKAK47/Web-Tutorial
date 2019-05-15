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
<%--
   enctype 元素指定 请求头的Content-Type由<form>元素上的enctype属性指定  multipart/form-data
   enctype="multipart/form-data"
--%>
<form action="/springmvc-demo-01/addUser" method="POST" enctype="application/x-www-form-urlencoded;charset=UTF-8">
    编号：<input type="text" name="id"/><br/>
    姓名：<input type="text" name="name"/><br/>
    地址：<input type="text" name="address.name"/><br/>
    <input type="submit" value="提交"/>
</form>
</body>
</html>