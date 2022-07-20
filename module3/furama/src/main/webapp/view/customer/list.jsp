<%--
  Created by IntelliJ IDEA.
  User: tranthuan
  Date: 04/07/2022
  Time: 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customer</title>

    <link rel="shortcut icon" type="image/png"
          href="https://scontent.fhan14-2.fna.fbcdn.net/v/t1.6435-9/91196518_151889716288463_5846000305799430144_n.jpg?_nc_cat=106&ccb=1-7&_nc_sid=174925&_nc_ohc=ILchzhLVzNoAX8aZnNY&_nc_ht=scontent.fhan14-2.fna&oh=00_AT-eTN5FqctxeJ7yVp2A8c9Phs_Cx425S8klzH598BB5ug&oe=62DEE3F6"/>

    <%--    <meta name="viewport" content="width=device-width, initial-scale=1">--%>
    <%--    <link rel="stylesheet" href="../style/bootstrap/normalize.css">--%>
    <%--    <link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css">--%>
    <%--    <link rel="stylesheet" href="../style/datatables/css/dataTables.bootstrap4.min.css"/>--%>
    <link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../bootstrap/DataTables/datatables.min.css"/>
    <!-- CSS only -->
    <%--    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"--%>
    <%--          integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">--%>
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
                    <form class="d-flex" role="search" action="/customer">
                        <input class="form-control me-2" name="nameSearch" type="search" placeholder="Search" aria-label="Search">
                        <input type="text" name="action" value="search" hidden>
                        <button class="btn" type="submit">Search</button>
                    </form>
                </div>
            </nav>
        </div>
    </div>


    <div class="row">
        <form>
            <table class="table table-striped" id="myTable">
                <thead>
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
                    <td>edit</td>
                    <td>delete</td>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="customer" items="${customerList}">
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
                        <td>
                            <!-- Button trigger modal -->
                            <button type="button" class="btn btn-outline-warning" data-bs-toggle="modal"
                                    data-bs-target="#staticBackdrop1${customer.id}">
                                edit
                            </button>
                                <%--                            <a href="<c:url value="/customer?action=edit&id=${customer.id}"/>" class="btn btn-outline-warning">Edit</a>--%>
                            <!-- Modal -->
                            <div class="modal fade" id="staticBackdrop1${customer.id}" data-bs-backdrop="static"
                                 data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel1"
                                 aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="staticBackdropLabel1">Edit</h5>
                                            <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                    aria-label="Close"></button>
                                        </div>
                                        <div class="modal-body"> <%--hiển thị nội dung muốn thông báo--%>
                                            <form action="/customer?action=edit&id=${customer.id}" method="post">
                                                <div class="form-floating">
                                                    <select class="form-select" id="sel1" name="typeId">
                                                        <c:forEach var="typeList" items="${typeList}">
                                                            <c:if test="${typeList.id == customer.typeId}">
                                                                <option value="${typeList.id}"
                                                                        selected>${typeList.name} </option>
                                                            </c:if>
                                                            <c:if test="${typeList.id != customer.typeId}">
                                                                <option value="${typeList.id}">${typeList.name}</option>
                                                            </c:if>
                                                        </c:forEach>
                                                    </select>
                                                    <label for="sel1" class="form-label">type Name</label>
                                                </div>

                                                <div class="form-floating mb-3 mt-3">
                                                    <input type="text" class="form-control" id="name"
                                                           placeholder="Enter name" name="name"
                                                           value="${customer.name}">
                                                    <label for="name">name</label>
                                                </div>


                                                <div class="form-floating mb-3 mt-3">
                                                    <input type="date" class="form-control" id="dateOfBirth"
                                                           placeholder="Enter email"
                                                           name="dateOfBirth" value="${customer.dateOfBirth}">
                                                    <label for="dateOfBirth">date Of Birth</label>
                                                </div>

                                                <div class="form-check">
                                                    <input class="form-check-input" type="radio" name="gender"
                                                           id="gender1" value="1" checked>
                                                    <label class="form-check-label" for="gender1">Nam</label>
                                                </div>
                                                <div class="form-check">
                                                    <input class="form-check-input" type="radio" name="gender"
                                                           id="gender0" value="0">
                                                    <label class="form-check-label" for="gender0">Nữ</label>
                                                </div>

                                                <div class="form-floating mb-3 mt-3">
                                                    <input type="text" class="form-control" id="idCard"
                                                           placeholder="Enter idCard" name="idCard"
                                                           value="${customer.idCard}">
                                                    <label for="idCard">idCard </label>
                                                </div>
                                                <div class="form-floating mb-3 mt-3">
                                                    <input type="text" class="form-control" id="phoneNumber"
                                                           placeholder="Enter phoneNumber"
                                                           name="phoneNumber" value="${customer.phoneNumber}">
                                                    <label for="email">phoneNumber</label>
                                                </div>
                                                <div class="form-floating mb-3 mt-3">
                                                    <input type="text" class="form-control" id="email"
                                                           placeholder="Enter email" name="email"
                                                           value="${customer.email}">
                                                    <label for="email">Email: </label>
                                                </div>
                                                <div class="form-floating mb-3 mt-3">
                                                    <input type="text" class="form-control" id="address"
                                                           placeholder="Enter address" name="address"
                                                           value="${customer.address}">
                                                    <label for="address">address</label>
                                                </div>
                                                <div class="d-grid gap-3">
                                                    <button type="submit" class="btn btn-primary btn-block">edit
                                                    </button>
                                                </div>
                                            </form>
                                        </div>

                                    </div>
                                </div>
                            </div>
                                <%--/Modal--%>
                        </td>
                        <td>
                            <!-- Button trigger modal -->
                            <button type="button" class="btn btn-outline-danger" data-bs-toggle="modal"
                                    data-bs-target="#staticBackdrop${customer.id}">
                                Xoá
                            </button>
                            <!-- Modal -->
                            <div class="modal fade" id="staticBackdrop${customer.id}" data-bs-backdrop="static"
                                 data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel"
                                 aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="staticBackdropLabel">Xác nhận xoá</h5>
                                            <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                    aria-label="Close"></button>
                                        </div>
                                        <div class="modal-body">
                                                <%--hiển thị nội dung muốn thông báo--%>
                                            <table class="table">
                                                <tr>
                                                    <th>id</th>
                                                    <td>${customer.id}</td>
                                                </tr>
                                                <tr>
                                                    <th>nameType</th>
                                                    <c:forEach var="typeList" items="${typeList}">
                                                        <c:if test="${typeList.id==customer.typeId}">
                                                            <td>${typeList.name}</td>
                                                        </c:if>
                                                    </c:forEach>
                                                </tr>
                                                <tr>
                                                    <th>name</th>
                                                    <td>${customer.name}</td>
                                                </tr>
                                                <tr>
                                                    <th>dateOfBirth</th>
                                                    <td>${customer.dateOfBirth}</td>
                                                </tr>
                                                <tr>
                                                    <th>gender</th>
                                                    <c:if test="${customer.gender == 1 }">
                                                        <td>Nam</td>
                                                    </c:if>
                                                    <c:if test="${customer.gender == 0 }">
                                                        <td>Nữ</td>
                                                    </c:if>
                                                </tr>
                                                <tr>
                                                    <th>idCard</th>
                                                    <td>${customer.idCard}</td>
                                                </tr>
                                                <tr>
                                                    <th>phoneNumber</th>
                                                    <td>${customer.phoneNumber}</td>
                                                </tr>
                                                <tr>
                                                    <th>email</th>
                                                    <td>${customer.email}</td>
                                                </tr>
                                                <tr>
                                                    <th>address</th>
                                                    <td>${customer.address}</td>
                                                </tr>
                                            </table>
                                        </div>
                                        <div class="modal-footer">
                                            <a href="<c:url value="/customer?action=delete&id=${customer.id}"/>"
                                               class="btn btn-outline-primary">Chấp nhận</a>
                                            <button type="button" class="btn btn-outline-secondary"
                                                    data-bs-dismiss="modal">Huỷ
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- /Modal -->
                        </td>
                    </tr>
                </c:forEach>
                </tbody>

            </table>
            <a href="<c:url value="/customer?action=create"/>" class="btn btn-outline-primary">Add</a>
        </form>
    </div>
    <div class="row ">
        <div class="blockquote-footer bg-black text-center">
            <p>Trần thuận ® 2022- Đà nẵng</p>
        </div>
    </div>
</div>


<%--<script src="../style/jquery/jquery-3.5.1.min.js"></script>--%>
<%--<script src="../style/datatables/js/jquery.dataTables.min.js"></script>--%>
<%--<script src="../style/datatables/js/dataTables.bootstrap4.min.js"></script>--%>
<%--<script src="../style/bootstrap/bootstrap.bundle.min.js"></script>--%>
<script src="../bootstrap/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript" src="../bootstrap/DataTables/datatables.min.js"></script>
<script>
    $("#btnClick").click(function () {
        let img = `<img src="https://iaslinks.org/wp-content/uploads/2021/03/fbi-warning-la-gi.jpg" style="width: 100%" alt="">`;
        $("#bodyTable").html(img);
    })

</script>
<script>
    $(document).ready(function () {
        $('#myTable').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        });
    });

</script>
</body>
</html>
