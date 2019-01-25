<%@ page import="org.vincent.domain.Product" %>
<%

    Product product = (Product) request.getAttribute("product");
%>
<%--

--%>
<!DOCTYPE HTML>
<html>
<head>
    <title>Save Product</title>
    <style type="text/css">@import url(/css/main.css);</style>
</head>
<body>
<div id="global">
    <h4>The product has been saved.</h4>
    <p>
    <h5>Details:</h5>
    Product Name: <%=product.getName()%><br/>
    Description: <%=product.getDescription()%><br/>
    Price: $<%=product.getPrice()%>
    </p>
</div>
</body>
</html>