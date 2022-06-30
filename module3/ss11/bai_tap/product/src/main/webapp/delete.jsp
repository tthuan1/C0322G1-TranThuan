<%--
  Created by IntelliJ IDEA.
  User: tranthuan
  Date: 30/06/2022
  Time: 01:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>xoa</title>
</head>
<body>
<h1>Delete product</h1>
<p>
    <a href="/product">Back to product list</a>
</p>
<form method="post">
    <h3>Are you sure?</h3>
    <table>
        <tr>
            <td>Product Name:</td>
            <td>${product.getName()}</td>
        </tr>
        <tr>
            <td>Product Price:</td>
            <td>${product.getPrice()}</td>
        </tr>
        <tr>
            <td>Product Description:</td>
            <td>${requestScope["product"].getDescribe()}</td>
        </tr>
        <tr>
            <td>Producer:</td>
            <td>${requestScope["product"].getProducer()}</td>
        </tr>
        <tr>
            <td><input type="submit" value="Delete product"></td>
            <td><a href="/product">Back to product list</a></td>
        </tr>
    </table>
</form>
</body>
</html>
