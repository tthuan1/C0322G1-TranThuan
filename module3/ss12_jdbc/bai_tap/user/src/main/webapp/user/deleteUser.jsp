<%--
  Created by IntelliJ IDEA.
  User: tranthuan
  Date: 30/06/2022
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form method="post">
    <table>
        <h2>delete User</h2>
        <tr>
            <th>User ID:</th>
            <td>
                <p></p>
                <input type="text" name="id" id="id" value="${user.id}" readonly>
            </td>
        </tr>
        <tr>
            <th>User Name:</th>
            <td>
                <input type="text" name="name" id="name" value="${user.name}" readonly>
            </td>
        </tr>
        <tr>
            <th>User Email:</th>
            <td>
                <input type="text" name="email" id="email" value="${user.email}" readonly>
            </td>
        </tr>
        <tr>
            <th>Country:</th>
            <td>
                <input type="text" name="country" id="country" value="${user.country}" readonly>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="submit" value="xoa">
            </td>
        </tr>
    </table>
</form>
<a href="/user">back</a>
</body>
</html>
