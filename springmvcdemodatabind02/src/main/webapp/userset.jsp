<%--
  Created by IntelliJ IDEA.
  User: S0076
  Date: 2019/5/15
  Time: 13:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title usertype</title>
</head>
<body>
<form action="/xx/settype" method="POST">
    用户1姓名：<input type="text" name="users[0].name"/><br/>
    用户1年龄：<input type="text" name="users[0].age"/><br/>
    用户2姓名：<input type="text" name="users[1].name"/><br/>
    用户2年龄：<input type="text" name="users[1].age"/><br/>
    用户3姓名：<input type="text" name="users[2].name"/><br/>
    用户3年龄：<input type="text" name="users[2].age"/><br/>
    <input type="submit" value="提交"/>
</form>
</body>
</html>
