<%--
  Created by IntelliJ IDEA.
  User: PengRong
  Date: 2019/1/20
  Time: 18:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Login</title>
</head>
<body>
<%-- 调用 servlet = RegisterServlet 的后台处理类
    action="../register" 这样写 是因为 login.jsp 在 webapp\admin\目录下，在web 根目录下admin子目录
    所以你要访问映射到根目录下的 register servlet服务，直接通过浏览器URL = http://localhost:8088/nativejsp/register访问
    那么在login.jsp这里你要访问根目录下的  register servlet服务，是不是就是要通过  ../register 访问。
 --%>
<form method="post" action="../register">
    注册页面
    <table>
        <!-- 第一行 -->
        <tr>
            <td>
                账户：
            </td>
            <td>
                <input type="text" name="account"/>
            </td>
        </tr>
        <!-- 第二行 -->
        <tr>
            <td>
                姓名：
            </td>
            <td>
                <input type="text" name="name"/>
            </td>
        </tr>
        <!-- 第三行 -->
        <tr>
            <td>
                性别：
            </td>
            <td>
                <select name="gender">
                    <option value="M">男</option>
                    <option value="W">女</option>
                </select>
            </td>
        </tr>
        <!-- 第四行 -->
        <tr>
            <td>
                爱好：
            </td>
            <td>
                <input type="checkbox" name="interest" value="吃饭"/>吃饭
                <input type="checkbox" name="interest" value="睡觉"/>睡觉
                <input type="checkbox" name="interest" value="打豆豆"/>打豆豆
            </td>
        </tr>
        <!-- 第五行 -->
        <tr>
            <td>
                简介：
            </td>
            <td>
                <textarea rows="8" cols="20" name="msg"></textarea>
            </td>
        </tr>
        <!-- 第六行 -->
        <tr>
            <td>

            </td>
            <td>
                <input type="submit" value="提交"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
