<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: tranthuan
  Date: 15/07/2022
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>create</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container">

    <h1>Settings</h1>
    <table class="table w-7">
        <form:form modelAttribute="mailbox" method="post">
            <h3 style="color: darkgreen">${message}</h3>
            <tr>
                <th>Languages:</th>
                <td>
                    <form:select path="languages" itemValue="English" disabled="true">
                        <form:option value="English"/>
                        <form:option value="Vietnamese"/>
                        <form:option value="Japanese"/>
                        <form:option value="Chinese"/>
                    </form:select>
                </td>
            </tr>
            <tr>
                <th>Page Size:</th>
                <td>
                    <span>Show</span>
                    <form:select path="pageSize" itemValue="English" disabled="true">
                        <form:option value="5"/>
                        <form:option value="10"/>
                        <form:option value="15"/>
                        <form:option value="25"/>
                        <form:option value="50"/>
                        <form:option value="100"/>
                    </form:select>
                    <span>emails per page</span>
                </td>

            </tr>
            <tr>
                <th>Spams Filter</th>
                <td>
                    <form:checkbox path="spamsFilter" disabled="true"/>
                    <span> Enable spams filter</span>
                </td>
            </tr>
            <tr>
                <th>Signature:</th>
                <td>
                    <form:input path="signature" readonly="true"/>
                </td>
            </tr>
        </form:form>
        <tr>
            <td colspan="2">
                <form action="setting">
                    <button type="submit" class="btn btn-primary w-100  " value="setting">setting</button>
                </form>
            </td>
        </tr>
    </table>

</div>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>
