<%--
  Created by IntelliJ IDEA.
  User: tranthuan
  Date: 30/06/2022
  Time: 14:52
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
<a href="/user?action=create">Thêm mới User</a>
<form action="/user">
    <input type="text" name="nameSearch" placeholder="Tìm theo tên">
    <input type="text" name="action" value="search" hidden>
    <button type="submit">Tìm kiếm</button>
</form>

<form>
    <table class="table">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Email</th>
            <th>country</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach var="temp" items="${userList}">
            <tr>
                <td>${temp.id}</td>
                <td>${temp.name}</td>
                <td>${temp.email}</td>
                <td>${temp.country}</td>
                <td>
                    <a href="/user?action=edit&id=${temp.id}">Edit</a>
                </td>
                <td>
                    <a href="/user?action=delete&id=${temp.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>

    </table>
</form>
<form action="/user">
    <input type="text" name="action" value="sort_by_name" hidden>
    <button type="submit">Sắp xếp theo tên</button>
</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
</body>
</html>
