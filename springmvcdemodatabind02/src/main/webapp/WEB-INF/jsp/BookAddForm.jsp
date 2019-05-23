<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
<title>Add Book Form</title>
<style type="text/css">@import url("<c:url value="/css/main.css"/>");</style>
<script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
</head>
<body>

<div id="global">
<form   action="book_save" method="post">
    <fieldset>
        <legend>Add a book</legend>
        <p>
            <label  >Category: </label>
            <input id="category.id" path="category.id"/>
            <input id="category.name" path="category.name"/>
        </p><br/>
        <p>
            <label for="title">Title: </label>
            <input id="title" path="title"/>
        </p>
        <p>
            <label for="author">Author: </label>
            <input id="author" path="author"/>
        </p>
        <p>
            <label for="isbn">ISBN: </label>
            <input id="isbn" path="isbn"/>
        </p>
        
        <p id="buttons">
            <input id="reset" type="reset" tabindex="4">

        </p>
    </fieldset>
</form>
    <input id="submit" type="submit"   onclick="submit()"
           value="Add Book">
</div>
<script type="text/javascript">
    /*
    * submit 方法实现，input 按钮单击事件
    * jquery  方法提交网络请求
    * */
    submit =function () {
        debugger;
        var user = {
            "isbn":"sdfasdf-1212",
            "id":22,
            "title":"Java",
            "author":"LAO TOU ZI",
            "category":{
                "id":11,
                "name":"sdfasd"
            }
        };
        $.ajax({
            url:"/springmvc-demo-databind-02/book_save",
            data:JSON.stringify(user),
            type:"post",
            contentType: "application/json;charset=UTF-8",
            dataType:"text",
            success:function(data){

            }
        })
    }

</script>
</body>
</html>
