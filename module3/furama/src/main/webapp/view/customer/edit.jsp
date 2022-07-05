<%--
  Created by IntelliJ IDEA.
  User: tranthuan
  Date: 05/07/2022
  Time: 00:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customer</title>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
          crossorigin="anonymous">
</head>
<body>
<div class="container-fluid">
    <div class="header">
        <div class="row">
            <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
                <div class="container-fluid">
                    <a class="navbar-brand" href="#">
                        <img src="https://scontent.fhan14-2.fna.fbcdn.net/v/t1.6435-9/91196518_151889716288463_5846000305799430144_n.jpg?_nc_cat=106&ccb=1-7&_nc_sid=174925&_nc_ohc=ILchzhLVzNoAX8aZnNY&_nc_ht=scontent.fhan14-2.fna&oh=00_AT-eTN5FqctxeJ7yVp2A8c9Phs_Cx425S8klzH598BB5ug&oe=62DEE3F6"
                             alt="Avatar Logo" style="width:40px;" class="rounded-pill">
                    </a>
                    <a class="navbar-brand" href="#">Trần thuận</a>
                </div>
            </nav>
        </div>
        <!--        menu-->
        <div class="row">
            <nav class="navbar navbar-expand-lg bg-light">
                <div class="container-fluid">
                    <nav class="navbar navbar-expand-lg bg-light">
                        <div class="container-fluid">
                            <a class="navbar-brand">Furama resort</a>
                            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                                    data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup"
                                    aria-expanded="false" aria-label="Toggle navigation">
                                <span class="navbar-toggler-icon"></span>
                            </button>
                            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                                <div class="navbar-nav">
                                    <a class="nav-link active" aria-current="page" href="/home">Home</a>
                                    <a class="nav-link active" aria-current="page" href="/employee">Employee</a>
                                    <a class="nav-link active" aria-current="page" href="/customer">Customer</a>
                                    <a class="nav-link active" aria-current="page" href="/service">Service</a>
                                    <a class="nav-link active" aria-current="page" href="/contract">Contract</a>
                                </div>
                            </div>
                        </div>
                    </nav>
                    <form class="d-flex" role="search">
                        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                        <button class="btn" type="submit">Search</button>
                    </form>
                </div>
            </nav>
        </div>
    </div>

    <div class="container">
        <div class="row">
            <form method="post">
                <div class="form-floating">
                    <select class="form-select" id="sel1" name="typeId">
                        <option value="${customer.typeId}">
                            <c:forEach var="typeList" items="${typeList}">
                                <c:if test="${typeList.id==customer.typeId}">
                                    ${typeList.name}
                                </c:if>
                            </c:forEach>
                        </option>
                        <option value="1">Diamond</option>
                        <option value="2">Platinium</option>
                        <option value="3">Gold</option>
                        <option value="4">Silver</option>
                        <option value="5">Member</option>
                    </select>
                        <label for="sel1" class="form-label">type Name</label>
                </div>

                <div class="form-floating mb-3 mt-3">
                    <input type="text" class="form-control" id="name" placeholder="Enter name" name="name" value="${customer.name}">
                    <label for="name">name</label>
                </div>


                <div class="form-floating mb-3 mt-3">
                    <input type="date" class="form-control" id="dateOfBirth" placeholder="Enter email"
                           name="dateOfBirth" value="${customer.dateOfBirth}">
                    <label for="dateOfBirth">date Of Birth</label>
                </div>

                <div class="form-check">
                    <input class="form-check-input" type="radio" name="gender" id="gender1" value="1" checked>
                    <label class="form-check-label" for="gender1">Nam</label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="gender" id="gender0" value="0">
                    <label class="form-check-label" for="gender0">Nữ</label>
                </div>

                <div class="form-floating mb-3 mt-3">
                    <input type="text" class="form-control" id="idCard" placeholder="Enter idCard" name="idCard" value="${customer.idCard}">
                    <label for="idCard">idCard </label>
                </div>
                <div class="form-floating mb-3 mt-3">
                    <input type="text" class="form-control" id="phoneNumber" placeholder="Enter phoneNumber"
                           name="phoneNumber" value="${customer.phoneNumber}">
                    <label for="email">phoneNumber</label>
                </div>
                <div class="form-floating mb-3 mt-3">
                    <input type="text" class="form-control" id="email" placeholder="Enter email" name="email" value="${customer.email}">
                    <label for="email">Email: </label>
                </div>
                <div class="form-floating mb-3 mt-3">
                    <input type="text" class="form-control" id="address" placeholder="Enter address" name="address" value="${customer.address}">
                    <label for="address">address</label>
                </div>
                <div class="d-grid gap-3">
                    <button type="submit" class="btn btn-primary btn-block">edit</button>
                </div>
            </form>

        </div>
    </div>
    <div class="row">
        <div class="blockquote-footer bg-black text-center">
            <p>Trần thuận ® 2022- Đà nẵng</p>
        </div>
    </div>
</div>

<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
        crossorigin="anonymous"></script>
</body>
</html>
