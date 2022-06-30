<%--
  Created by IntelliJ IDEA.
  User: tranthuan
  Date: 29/06/2022
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
</head>
<body>
<p>
    <a href="/product">Back to product list</a>
</p>
<button>
    <a href="/product?action=create">Create New Product</a>
</button>
<form action="/product">
    <input type="text" name="nameSearch">
    <input type="submit" name="action" value="search">
</form>

<form>
    <table class="table w-75 bd-black">
        <tr>
            <th>id</th>
            <th>name</th>
            <th>gia</th>
            <th>mieu ta</th>
            <th>nha sx</th>
            <th>update</th>
            <th>xoa</th>
            <th>Xem chi tiet</th>
        </tr>
        <c:forEach var="temp" items='${hihi}'>
            <tr>
                <td>${temp.id}</td>
                <td>${temp.name}</td>
                <td>${temp.price}</td>
                <td>${temp.describe}</td>
                <td>${temp.producer}</td>
                <td><a href="/product?action=edit&id=${temp.getId()}">edit</a></td>
                <td><a href="/product?action=delete&id=${temp.getId()}">delete</a></td>
                <td><a href="/product?action=view&id=${temp.getId()}">chi tiet</a></td>
            </tr>
        </c:forEach>
    </table>
</form>
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
</body>
</html>
