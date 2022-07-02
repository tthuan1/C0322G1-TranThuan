<%--
  Created by IntelliJ IDEA.
  User: tranthuan
  Date: 30/06/2022
  Time: 01:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Delete product</h1>
<p>
    <a href="/product">Back to product list</a>
</p>
<form method="post">
    <table>
        <tr>
            <td>Product Name:</td>
            <td>${requestScope["product"].getName()}</td>
        </tr>
        <tr>
            <td>Product Price:</td>
            <td>${requestScope["product"].getPrice()}</td>
        </tr>
        <tr>
            <td>Product Description:</td>
            <td>${requestScope["product"].getDescribe()}</td>
        </tr>
        <tr>
            <td>Producer:</td>
            <td>${requestScope["product"].getProducer()}</td>
        </tr>
    </table>
</form>
</body>
</html>
