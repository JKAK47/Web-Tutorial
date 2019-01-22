<%--
  Created by IntelliJ IDEA.
  User: PengRong
  Date: 2019/1/21
  Time: 7:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.vincent.dao.model.UserBean" %>
<%
    /* 获取request 级别的数据 被servlet 设置的属性  */
    UserBean user = (UserBean) request.getAttribute("USERLIST");
    String requestUrl=request.getRequestURL().toString();
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>userList</title>
</head>
<body>
<%-- java print  requestUrl --%>
<h3><%=
    requestUrl
%></h3>

<table border="1px;">
    <!-- 第一行 -->
    <tr>
        <td>序号</td>
        <td>账号</td>
        <td>姓名</td>
        <td>性别</td>
        <td>爱好</td>
        <td>简介</td>
    </tr>
    <!-- 第二行 -->

    <tr>
        <td><%=1%>
        </td>
        <td><%=user.getAccount()%>
        </td>
        <td><%=user.getName()%>
        </td>
        <td><%=user.getGender()%>
        </td>
        <td><%=user.getInterest()%>
        </td>
        <td><%=user.getMsg()%>
        </td>
    </tr>

</table>
</body>
</html>
