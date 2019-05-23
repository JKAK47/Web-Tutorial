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
    <%--<script src="/static/lib/jquery/jquery.min.js"></script> 为什么本地的不行 原因还没定 --%>
    <script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
</head>
<body>
    <%-- 提交ajax 请求--%>
<input type="submit" value="提交" onclick="submit()"/>
<script type="text/javascript">
    /*
    * submit 方法实现，input 按钮单击事件
    * jquery  方法提交网络请求
    * */
    submit =function () {

        var user = {
            "name":"张三",
            "id":22
        };
        $.ajax({
            url:"/springmvc-demo-01/jsonType",
            data:JSON.stringify(user),
            type:"post",
            contentType: "application/json;charset=UTF-8",
            dataType:"text",
            success:function(data){
                var obj = eval("(" + data + ")");
                alert(obj.name+"---"+obj.id);
            }
        })
    }

</script>
</body>
</html>