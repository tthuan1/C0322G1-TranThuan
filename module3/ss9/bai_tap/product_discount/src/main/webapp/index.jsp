<%--
  Created by IntelliJ IDEA.
  User: tranthuan
  Date: 27/06/2022
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
</head>
<title>$Title$</title>
<body>
<form action="/ProductServlet" method="post">
    <div class="input-group mb-3">
        <div class="input-group-prepend w-25">
            <span class="input-group-text">Product description</span>
        </div>
        <input type="text" class="form-control" aria-label="Large" aria-describedby="inputGroup-sizing-sm"
               name="product_description" placeholder="Mô tả sản phẩm">
    </div>

    <div class="input-group mb-3">
        <div class="input-group-prepend w-25">
            <span class="input-group-text">Price</span>
        </div>
        <input type="text" class="form-control" aria-label="Large" aria-describedby="inputGroup-sizing-sm"
               name="list_price" placeholder="Giá niêm yết của sản phẩm">
    </div>

    <div class="input-group mb-3">
        <div class="input-group-prepend w-25">
            <span class="input-group-text">discount percent</span>
        </div>
        <input type="text" class="form-control" aria-label="Large" aria-describedby="inputGroup-sizing-sm"
               name="discount_percent" placeholder="Tỷ lệ chiết khấu ">
    </div>

    <button type="submit" class="btn btn-outline-secondary">Discount Product</button>
</form>
<h4>Product description: ${description}</h4>
<h4>Discount Amount: ${discount_amount}</h4>
<h4>Discount Price: ${discount_price}</h4>

<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
        crossorigin="anonymous"></script>
</body>
</html>
