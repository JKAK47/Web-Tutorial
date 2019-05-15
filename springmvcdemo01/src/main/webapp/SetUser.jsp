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
<form action="/springmvc-demo-01/settype" method="POST">
    用户1姓名：<input type="text" name="users[0].name"/><br/>
    用户1年龄：<input type="text" name="users[0].id"/><br/>
    用户2姓名：<input type="text" name="users[1].name"/><br/>
    用户2年龄：<input type="text" name="users[1].id"/><br/>
    用户3姓名：<input type="text" name="users[2].name"/><br/>
    用户3年龄：<input type="text" name="users[2].id"/><br/>
    <input type="submit" value="提交"/>
</form>
</body>
</html>