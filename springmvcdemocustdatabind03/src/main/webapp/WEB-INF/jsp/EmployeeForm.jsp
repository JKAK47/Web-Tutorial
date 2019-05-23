<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
<title>Add Employee Form</title>
    <script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
</head>
<body>

<div id="global">

    <input id="submit" type="submit"  onclick="submit()"
           value="Add Employee">
</div>
<script type="text/javascript">
    /*
    * submit 方法实现，input 按钮单击事件
    * jquery  方法提交网络请求
    * */
    submit =function () {
        debugger;
        var user = {
            "name":"sdfasdf-1212",
            "id":22,
            "birthDate":"06-25-2009"

        };
        $.ajax({
            url:"/springmvcdemocustdatabind03/employee_save",
            data:JSON.stringify(user),
            type:"POST",
            contentType: "application/json;charset=UTF-8",
            dataType:"text",
            success:function(data){

            }
        })
    }

</script>
</body>
</html>
