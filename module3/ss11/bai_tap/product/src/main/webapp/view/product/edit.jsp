<%--
  Created by IntelliJ IDEA.
  User: tranthuan
  Date: 29/06/2022
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>
    <c:if test='${ message!= null}'>
        <span class="message">${message}</span>
    </c:if>
</p>
<a href="/product">back ></a>
<form method="post">
    <table>
        <tr>
            <th>name</th>
            <td><input type="text" name="name" id="name" value="${product.name}"></td>
        </tr>
        <tr>
            <th>price</th>
            <td><input type="text" name="price" id="price" value="${product.price}"></td>
        </tr>
        <tr>
            <th>describe</th>
            <td><input type="text" name="describe" id="describe" value="${product.describe}"></td>
        </tr>
        <tr>
            <th>producer</th>
            <td><input type="text" name="producer" id="producer" value="${product.producer}"></td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="submit" value="Update product">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
