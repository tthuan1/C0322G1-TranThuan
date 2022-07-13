<%--
  Created by IntelliJ IDEA.
  User: tranthuan
  Date: 13/07/2022
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>dictionary</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<form action="/dictionary" method="post">
    <div class="input-group mb-3">
        <span class="input-group-text" id="basic-addon1">Tiếng việt</span>
        <input type="text" class="form-control" placeholder="Nhập" aria-label="vnWord" aria-describedby="basic-addon1"
               name="vnWord" value="${vnWord}">
    </div>
    <div class="input-group mb-3">
        <span class="input-group-text" id="basic-addon">Tiếng anh</span>
        <input type="text" class="form-control" aria-label="esWord" aria-describedby="basic-addon1" value="${esWord}"
               readonly>
    </div>
    <input type="submit" value="Dịch">
</form>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous">
</script>
</body>
</html>
