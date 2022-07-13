<%--
  Created by IntelliJ IDEA.
  User: tranthuan
  Date: 10/07/2022
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home</title>

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
                        <a class="nav-link active" aria-current="page" href="/hoKhau">Hộ khẩu</a>
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

    <div class="row">
        <form>
            <table class="table table-striped" id="myTable">
                <thead>
                <tr>
                    <th>Mã hộ khẩu</th>
                    <th>Tên chủ hộ</th>
                    <th>Số lượng</th>
                    <th>Ngày lập hộ khẩu</th>
                    <th>Địa chỉ nhà</th>
                    <td>Sửa</td>
                    <td>xem thành viên</td>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="hoKhauList" items="${hoKhauList}">
                    <tr>
                        <td>${hoKhauList.maHoKhau}</td>
                        <td>${hoKhauList.tenChuHo}</td>
                        <td>${hoKhauList.soLuong}</td>
                        <td>${hoKhauList.ngayLapHoKhau}</td>
                        <td>${hoKhauList.diaChiNha}</td>
                        <td>
                            <!-- Button trigger modal -->
                            <button type="button" class="btn btn-outline-warning" data-bs-toggle="modal"
                                    data-bs-target="#staticBackdrop1${hoKhauList.maHoKhau}">
                                edit
                            </button>
                                <%--<a href="<c:url value="/customer?action=edit&id=${customer.id}"/>" class="btn btn-outline-warning">Edit</a>--%>
                            <!-- Modal -->
                            <div class="modal fade" id="staticBackdrop1${hoKhauList.maHoKhau}" data-bs-backdrop="static"
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
                                            <form action="/hoKhau?action=edit&maHoKhau=${hoKhauList.maHoKhau}" method="post">

                                                <div class="form-floating mb-3 mt-3">
                                                    <input type="text" class="form-control" id="maHoKhau"
                                                           placeholder="Enter maHoKhau" name="maHoKhau"
                                                           value="${hoKhauList.maHoKhau}" readonly>
                                                    <label for="maHoKhau">ma Ho Khau</label>
                                                </div>

                                                <div class="form-floating mb-3 mt-3">
                                                    <input type="text" class="form-control" id="tenChuHo"
                                                           placeholder="Enter tenChuHo"
                                                           name="tenChuHo" value="${hoKhauList.tenChuHo}">
                                                    <label for="tenChuHo">ten Chu Ho</label>
                                                </div>


                                                <div class="form-floating mb-3 mt-3">
                                                    <input type="text" class="form-control" id="soLuong"
                                                           placeholder="Enter soLuong" name="soLuong"
                                                           value="${hoKhauList.soLuong}" readonly>
                                                    <label for="soLuong">so Luong thanh vien </label>
                                                </div>

                                                <div class="form-floating mb-3 mt-3">
                                                    <input type="date" class="form-control" id="ngayLapHoKhau"
                                                           placeholder="Enter ngayLapHoKhau"
                                                           name="ngayLapHoKhau" value="${hoKhauList.ngayLapHoKhau}">
                                                    <label for="ngayLapHoKhau">ngay Lap Ho Khau</label>
                                                </div>

                                                <div class="form-floating mb-3 mt-3">
                                                    <input type="text" class="form-control" id="diaChiNha"
                                                           placeholder="Enter diaChiNha" name="diaChiNha"
                                                           value="${hoKhauList.diaChiNha}">
                                                    <label for="diaChiNha">dia Chi Nha </label>
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
                        </td>
                        <td>
<%--                            <!-- Button trigger modal -->--%>
<%--                            <button type="button" class="btn btn-outline-danger" data-bs-toggle="modal"--%>
<%--                                    data-bs-target="#staticBackdrop${customer.id}">--%>
<%--                                Xoá--%>
<%--                            </button>--%>
<%--                            <!-- Modal -->--%>
<%--                            <div class="modal fade" id="staticBackdrop${customer.id}" data-bs-backdrop="static"--%>
<%--                                 data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel"--%>
<%--                                 aria-hidden="true">--%>
<%--                                <div class="modal-dialog">--%>
<%--                                    <div class="modal-content">--%>
<%--                                        <div class="modal-header">--%>
<%--                                            <h5 class="modal-title" id="staticBackdropLabel">Xác nhận xoá</h5>--%>
<%--                                            <button type="button" class="btn-close" data-bs-dismiss="modal"--%>
<%--                                                    aria-label="Close"></button>--%>
<%--                                        </div>--%>
<%--                                        <div class="modal-body"> &lt;%&ndash;hiển thị nội dung muốn thông báo&ndash;%&gt;--%>
<%--                                            <table class="table">--%>
<%--                                                <tr>--%>
<%--                                                    <th>id</th>--%>
<%--                                                    <td>${customer.id}</td>--%>
<%--                                                </tr>--%>
<%--                                                <tr>--%>
<%--                                                    <th>nameType</th>--%>
<%--                                                    <c:forEach var="typeList" items="${typeList}">--%>
<%--                                                        <c:if test="${typeList.id==customer.typeId}">--%>
<%--                                                            <td>${typeList.name}</td>--%>
<%--                                                        </c:if>--%>
<%--                                                    </c:forEach>--%>
<%--                                                </tr>--%>
<%--                                                <tr>--%>
<%--                                                    <th>name</th>--%>
<%--                                                    <td>${customer.name}</td>--%>
<%--                                                </tr>--%>
<%--                                                <tr>--%>
<%--                                                    <th>dateOfBirth</th>--%>
<%--                                                    <td>${customer.dateOfBirth}</td>--%>
<%--                                                </tr>--%>
<%--                                                <tr>--%>
<%--                                                    <th>gender</th>--%>
<%--                                                    <c:if test="${customer.gender == 1 }">--%>
<%--                                                        <td>Nam</td>--%>
<%--                                                    </c:if>--%>
<%--                                                    <c:if test="${customer.gender == 0 }">--%>
<%--                                                        <td>Nữ</td>--%>
<%--                                                    </c:if>--%>
<%--                                                </tr>--%>
<%--                                                <tr>--%>
<%--                                                    <th>idCard</th>--%>
<%--                                                    <td>${customer.idCard}</td>--%>
<%--                                                </tr>--%>
<%--                                                <tr>--%>
<%--                                                    <th>phoneNumber</th>--%>
<%--                                                    <td>${customer.phoneNumber}</td>--%>
<%--                                                </tr>--%>
<%--                                                <tr>--%>
<%--                                                    <th>email</th>--%>
<%--                                                    <td>${customer.email}</td>--%>
<%--                                                </tr>--%>
<%--                                                <tr>--%>
<%--                                                    <th>address</th>--%>
<%--                                                    <td>${customer.address}</td>--%>
<%--                                                </tr>--%>
<%--                                            </table>--%>
<%--                                        </div>--%>
<%--                                        <div class="modal-footer">--%>
<%--                                            <a href="<c:url value="/customer?action=delete&id=${customer.id}"/>"--%>
<%--                                               class="btn btn-outline-primary">Chấp nhận</a>--%>
<%--                                            <button type="button" class="btn btn-outline-secondary"--%>
<%--                                                    data-bs-dismiss="modal">Huỷ--%>
<%--                                            </button>--%>
<%--                                        </div>--%>
<%--                                    </div>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                            <!-- /Modal -->--%>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>

            </table>
<%--            <a href="<c:url value="/customer?action=create"/>" class="btn btn-outline-primary">Add</a>--%>
        </form>
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
            "pageLength": 7
        });
    });
</script>
</body>
</html>

