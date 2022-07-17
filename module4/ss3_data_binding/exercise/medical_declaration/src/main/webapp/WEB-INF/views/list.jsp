<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>List</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <table class="table">
        <tr>
            <th>Name</th>
            <th>yearOfBirth</th>
            <th>gender</th>
            <th>nationality</th>
            <th>identityCard</th>
            <th>vehicle</th>
            <th>vehicleNumber</th>
            <th>numberOfSeats</th>
            <th>releaseDate</th>
            <th>endDate</th>
            <th>schedule</th>
            <th>update</th>
        </tr>
        <c:forEach items="${medicalDeclarationList}" var="item">
            <tr>
                <td>${item.name}</td>
                <td>${item.yearOfBirth}</td>
                <td>
                    <c:if test="${item.gender == 1}">Nam</c:if>
                    <c:if test="${item.gender == 0}">Nữ</c:if>
                </td>
                <td>${item.nationality}</td>
                <td>${item.identityCard}</td>
                <td>${item.vehicle}</td>
                <td>${item.vehicleNumber}</td>
                <td>${item.numberOfSeats}</td>
                <td>${item.releaseDate}</td>
                <td>${item.endDate}</td>
                <td>${item.schedule}</td>
                <td>
                <a href="/update?identityCard=${item.identityCard}" class="btn btn-primary">Update</a>
            </td>
            </tr>
        </c:forEach>
    </table>
    <div>
        <form:form action="create">
            <input type="submit" class="btn btn-primary" value="create">
        </form:form>
    </div>
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
