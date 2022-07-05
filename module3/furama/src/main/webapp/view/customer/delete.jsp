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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
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
    <div class="row">
        <form method="post">
            <table class="table">
                <tr>
                    <th>id</th>
                    <th>nameType</th>
                    <th>name</th>
                    <th>dateOfBirth</th>
                    <th>gender</th>
                    <th>idCard</th>
                    <th>phoneNumber</th>
                    <th>email</th>
                    <th>address</th>
                </tr>
                <tr>
                    <td>${customer.id}</td>
                    <c:forEach var="typeList" items="${typeList}">
                        <c:if test="${typeList.id==customer.typeId}">
                            <td>${typeList.name}</td>
                        </c:if>
                    </c:forEach>
                    <td>${customer.name}</td>
                    <td>${customer.dateOfBirth}</td>
                    <c:if test="${customer.gender == 1 }">
                        <td>Nam</td>
                    </c:if>
                    <c:if test="${customer.gender == 0 }">
                        <td>Nữ</td>
                    </c:if>
                    <td>${customer.idCard}</td>
                    <td>${customer.phoneNumber}</td>
                    <td>${customer.email}</td>
                    <td>${customer.address}</td>
                </tr>
            </table>
            <%--            <button type="submit" class="btn btn-primary btn-block">--%>
            <%--                delete--%>
            <%--            </button>--%>
            <div>
                <!-- Button trigger modal -->
                <button type="button" class="btn btn-outline-danger" data-bs-toggle="modal"
                        data-bs-target="#staticBackdrop${customer.id}">
                    Xoá
                </button>

                <!-- Modal -->
                <div class="modal fade" id="staticBackdrop${customer.id}" data-bs-backdrop="static"
                     data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="staticBackdropLabel">Xác nhận xoá</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal"
                                        aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                Bạn có xác nhận xoá khách hàng ${customer.name} có id là ${customer.id}
                            </div>
                            <div class="modal-footer">
                                <button type="submit" class="btn btn-primary btn-block">
                                    chấp nhận
                                </button>
                                <%--<a href="/customer?action=delete&id=${customer.id}" class="btn btn-outline-primary">Chấp nhận</a>--%>
                                <button type="button" class="btn btn-outline-secondary" data-bs-dismiss="modal">Huỷ
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <%--            <a href="/customer?action=delete">delete</a>--%>
        </form>
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
