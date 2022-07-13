<%--
  Created by IntelliJ IDEA.
  User: tranthuan
  Date: 10/07/2022
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create</title>

    <link rel="shortcut icon" type="image/png"
          href="../style/image/91196518_151889716288463_5846000305799430144_n.jpeg"/>

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../style/bootstrap/normalize.css">
    <link rel="stylesheet" href="../style/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="../style/datatables/css/dataTables.bootstrap4.min.css"/>
</head>
<body>
<div class="container-fluid">
    <div class="header">
        <div class="row">
            <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
                <div class="container-fluid">
                    <a class="navbar-brand" href="#">
                        <img src="../style/image/91196518_151889716288463_5846000305799430144_n.jpeg"
                             alt="Avatar Logo" style="width:40px;" class="rounded-pill">
                    </a>
                    <a class="navbar-brand" href="#">Trần thuận</a>
                </div>
            </nav>
        </div>
        <!--        menu-->
        <div class="row">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
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

                <form class="d-flex" role="search" action="/customer">
                    <input class="form-control me-2" name="nameSearch" type="search" placeholder="Search"
                           aria-label="Search">
                    <input type="text" name="action" value="search" hidden>
                    <button class="btn" type="submit">Search</button>
                </form>
            </nav>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <form method="post">
                <div class="form-floating">
                    <select class="form-select" id="sel1" name="typeId">
                        <option value="1">Diamond</option>
                        <option value="2">Platinium</option>
                        <option value="3">Gold</option>
                        <option value="4">Silver</option>
                        <option value="5">Member</option>
                    </select>
                    <label for="sel1" class="form-label">Select list (select one):</label>
                </div>

                <div class="form-floating mb-3 mt-3">
                    <input type="text" class="form-control" id="name" placeholder="Enter name" name="name">
                    <label for="name">name</label>
                </div>


                <div class="form-floating mb-3 mt-3">
                    <input type="date" class="form-control" id="dateOfBirth" placeholder="Enter email"
                           name="dateOfBirth">
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
                    <input type="text" class="form-control" id="idCard" placeholder="Enter idCard" name="idCard">
                    <label for="idCard">idCard</label>
                </div>
                <div class="form-floating mb-3 mt-3">
                    <input type="text" class="form-control" id="phoneNumber" placeholder="Enter phoneNumber"
                           name="phoneNumber">
                    <label for="email">phoneNumber</label>
                </div>
                <div class="form-floating mb-3 mt-3">
                    <input type="text" class="form-control" id="email" placeholder="Enter email" name="email">
                    <label for="email">Email</label>
                </div>
                <div class="form-floating mb-3 mt-3">
                    <input type="text" class="form-control" id="address" placeholder="Enter address" name="address">
                    <label for="address">address</label>
                </div>
                <div class="d-grid gap-3">
                    <button type="submit" class="btn btn-primary btn-block">create</button>
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

<script src="../style/jquery/jquery-3.5.1.min.js"></script>
<script src="../style/datatables/js/jquery.dataTables.min.js"></script>
<script src="../style/datatables/js/dataTables.bootstrap4.min.js"></script>
<script src="../style/bootstrap/bootstrap.bundle.min.js"></script>
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

