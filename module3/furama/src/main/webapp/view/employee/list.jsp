<%--
  Created by IntelliJ IDEA.
  User: tranthuan
  Date: 04/07/2022
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>employee - furama</title>
    <link rel="shortcut icon" type="image/png"
          href="https://scontent.fhan14-2.fna.fbcdn.net/v/t1.6435-9/91196518_151889716288463_5846000305799430144_n.jpg?_nc_cat=106&ccb=1-7&_nc_sid=174925&_nc_ohc=ILchzhLVzNoAX8aZnNY&_nc_ht=scontent.fhan14-2.fna&oh=00_AT-eTN5FqctxeJ7yVp2A8c9Phs_Cx425S8klzH598BB5ug&oe=62DEE3F6"/>

    <%--    <meta name="viewport" content="width=device-width, initial-scale=1">--%>
    <%--    <link rel="stylesheet" href="../style/bootstrap/normalize.css">--%>
    <%--    <link rel="stylesheet" href="../style/bootstrap/bootstrap.min.css">--%>
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
                    <a class="navbar-brand" href="#">Tr???n thu???n</a>
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
                    <form class="d-flex" role="search" action="/employee">
                        <select class="form-control me-2 " id="sel" name="typeSearch">
                            <option value="name">search by name</option>
                            <option value="division">search by division</option>
                            <option value="position">search by position</option>
                        </select>
                        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search"
                               name="nameSearch">
                        <input type="text" name="action" value="search" hidden>
                        <button class="btn" type="submit">Search</button>
                    </form>
                </div>
            </nav>
        </div>
    </div>
    <div class="row">
        <form>
            <table class="table table-striped " id="myTable">
                <thead>
                <tr>
                    <th>id</th>
                    <th>name</th>
                    <th>date Of Birth</th>
                    <th>id Card</th>
                    <th>salary</th>
                    <th>phone Number</th>
                    <th>email</th>
                    <th>address</th>
                    <th>division</th>
                    <th>position</th>
                    <th>education Degree</th>
                    <th>edit</th>
                    <th>delete</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="employeeDTOList" items="${employeeDTOList}">
                    <tr>
                        <td>${employeeDTOList.id}</td>
                        <td>${employeeDTOList.name}</td>
                        <td>${employeeDTOList.dateOfBirth}</td>
                        <td>${employeeDTOList.idCard}</td>
                        <td>${employeeDTOList.salary}</td>
                        <td>${employeeDTOList.phoneNumber}</td>
                        <td>${employeeDTOList.email}</td>
                        <td>${employeeDTOList.address}</td>
                        <td>${employeeDTOList.divisionName}</td>
                        <td>${employeeDTOList.positionName}</td>
                        <td>${employeeDTOList.educationDegreeName}</td>
                        <td>
                            <a href="<c:url value="/employee?action=edit&id=${employeeDTOList.id}"/>"
                               class="btn btn-outline-warning">Edit</a>
                        </td>
                        <td>
                            <!-- Button trigger modal -->
                            <button type="button" class="btn btn-outline-danger" data-bs-toggle="modal"
                                    data-bs-target="#staticBackdrop${employeeDTOList.id}">
                                Xo??
                            </button>
                            <!-- Modal -->
                            <div class="modal fade" id="staticBackdrop${employeeDTOList.id}"
                                 data-bs-backdrop="static"
                                 data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel"
                                 aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="staticBackdropLabel">X??c nh???n xo??</h5>
                                            <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                    aria-label="Close"></button>
                                        </div>
                                        <div class="modal-body"> <%--hi???n th??? n???i dung mu???n th??ng b??o--%>
                                            <h1>b???n c?? mu???n xo?? b???n ${employeeDTOList.name} n??y kh??ng ??</h1>
                                        </div>
                                        <div class="modal-footer">
                                            <a href="<c:url value="/employee?action=delete&id=${employeeDTOList.id}"/>"
                                               class="btn btn-outline-primary">Ch???p nh???n</a>
                                            <button type="button" class="btn btn-outline-secondary"
                                                    data-bs-dismiss="modal">Hu???
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
            <a href="<c:url value="/employee?action=create"/>" class="btn btn-outline-primary">Add</a>
        </form>
    </div>

    <div class="row ">
        <div class="blockquote-footer bg-black text-center">
            <p>Tr???n thu???n ?? 2022- ???? n???ng</p>
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
