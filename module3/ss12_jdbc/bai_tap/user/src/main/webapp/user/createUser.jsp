<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tranthuan
  Date: 30/06/2022
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/user">Back ></a>
<form method="post">
    <table>
        <tr>
<%--            <th>Id</th>--%>
            <th>Name</th>
            <th>Email</th>
            <th>Country</th>
        </tr>
        <tr>
<%--            <td><input type="text" name="id"></td>--%>
            <td><input type="text" name="name"></td>
            <td><input type="text" name="email"></td>
            <td><input type="text" name="country"></td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="submit" value="tạo mới">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
