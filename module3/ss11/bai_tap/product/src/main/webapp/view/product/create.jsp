<%--
  Created by IntelliJ IDEA.
  User: tranthuan
  Date: 29/06/2022
  Time: 15:15
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
        <tr>
            <td>name</td>
            <td>
                <input type="text" name="name" id="name">
            </td>
        </tr>
        <tr>
            <td>price</td>
            <td>
                <input type="text" name="price" id="price">
            </td>
        </tr>
        <tr>
            <td>describe</td>
            <td>
                <input type="text" name="describe" id="describe">
            </td>
        </tr>
        <tr>
            <td>producer</td>
            <td>
                <input type="text" name="producer" id="producer">
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <button type="submit"> tao moi</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
