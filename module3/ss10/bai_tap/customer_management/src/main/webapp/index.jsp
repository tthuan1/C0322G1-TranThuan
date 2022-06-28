<%--
  Created by IntelliJ IDEA.
  User: tranthuan
  Date: 28/06/2022
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
  </head>
  <body>
  <h1>List of customers</h1>
  <table class="table">
    <tr>
      <th>Customer name</th>
      <th>Date of birth</th>
      <th>Address</th>
      <th>Image customer</th>
    </tr>
<%--@elvariable id="customers" type="java.util.List"--%>
<c:forEach items="${customers}" var="customer">
<tr>
  <td> ${customer.name}</td>
  <td> ${customer.dateOfBirth}</td>
  <td> ${customer.address} </td>
  <td> <img style="height: 100px" src="${customer.image}" alt=""> </td>
</tr>
</c:forEach>
  </table>


  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
          integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
          crossorigin="anonymous"></script>
  </body>
</html>
