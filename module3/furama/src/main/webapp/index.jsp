<%--
  Created by IntelliJ IDEA.
  User: tranthuan
  Date: 01/07/2022
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Trang chủ - furama</title>
  <link>
  <link rel="shortcut icon" type="image/png"
        href="https://scontent.fhan14-2.fna.fbcdn.net/v/t1.6435-9/91196518_151889716288463_5846000305799430144_n.jpg?_nc_cat=106&ccb=1-7&_nc_sid=174925&_nc_ohc=ILchzhLVzNoAX8aZnNY&_nc_ht=scontent.fhan14-2.fna&oh=00_AT-eTN5FqctxeJ7yVp2A8c9Phs_Cx425S8klzH598BB5ug&oe=62DEE3F6"/>
  <!-- CSS bootstrap -->
<%--  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"--%>
<%--        integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">--%>
  <!-- my CSS -->
  <link rel="stylesheet" href="bootstrap/css/bootstrap.css"/>

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
    <!--    carousel-->
    <div class=" col-lg-7 col-md-9 col-sm-10 mx-auto">
      <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel">
        <ol class="carousel-indicators">
          <li data-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active"></li>
          <li data-target="#carouselExampleIndicators" data-bs-slide-to="1"></li>
          <li data-target="#carouselExampleIndicators" data-bs-slide-to="2"></li>
        </ol>
        <div class="carousel-inner">
          <div class="carousel-item active">
            <img class="d-block w-100"
                 src="https://demos.creative-tim.com/test/material-dashboard-pro/assets/img/products/product-1-min.jpg"
                 alt="First slide">
          </div>
          <div class="carousel-item">
            <img class="d-block w-100"
                 src="https://demos.creative-tim.com/test/material-dashboard-pro/assets/img/products/product-2-min.jpg"
                 alt="Second slide">
          </div>
          <div class="carousel-item">
            <img class="d-block w-100"
                 src="https://demos.creative-tim.com/test/material-dashboard-pro/assets/img/products/product-3-min.jpg"
                 alt="Third slide">
          </div>
        </div>
        <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-bs-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        </a>
        <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-bs-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
        </a>
      </div>
    </div>
  </div>

  <div class="row">
    <!--        <ul class="list-group">-->
    <!--            <li class="list-group-item">An item</li>-->
    <!--            <li class="list-group-item">A second item</li>-->
    <!--            <li class="list-group-item">A third item</li>-->
    <!--            <li class="list-group-item">A fourth item</li>-->
    <!--            <li class="list-group-item">And a fifth one</li>-->
    <!--        </ul>-->
    <!--        <div class="col-lg-10 col-md-10 col-sm-10">-->
    <!--            <p>-->
    <!--                hello my name is Thuan see your late !!-->
    <!--            </p>-->
    <!--        </div>-->
    <div class="col-lg-2 col-md-3 col-sm-4">
      <div id="list-example" class="d-flex flex-column">
        <ul>
          <li>
            <a class="list-group-item " href="#item-1">Giới thiệu</a>
          </li>
          <li>
            <a class="list-group-item " href="#item-2">Các loại phòng</a>

          </li>
          <li>
            <a class="list-group-item " href="#item-3">TRẢI NGHIỆM ẨM THỰC & GIẢI TRÍ</a>
          </li>
        </ul>
      </div>
    </div>
    <div class="col-lg-10 col-md-9 col-sm-8">
      <div data-bs-spy="scroll" data-bs-target="#list-example" data-bs-offset="0" data-bs-smooth-scroll="true"
           class="scrollspy-example" tabindex="0">
        <h4 id="item-1">Giới thiệu</h4>
        <p>Hướng ra bãi biển Đà Nẵng trải dài cát trắng, Furama Resort Đà Nẵng là cửa ngõ đến với 3 di sản văn
          hoá thế giới: Hội An (20 phút), Mỹ Sơn (90 phút) và Huế (2 tiếng. 196 phòng hạng sang cùng với 70
          căn biệt thự từ hai đến bốn phòng ngủ có hồ bơi riêng đều được trang trí trang nhã, theo phong cách
          thiết kế truyền thống của Việt Nam và kiến trúc thuộc địa của Pháp, biến Furama thành khu nghỉ dưỡng
          danh giá nhất tại Việt Nam – vinh dự được đón tiếp nhiều người nổi tiếng, giới hoàng gia, chính
          khách, ngôi sao điện ảnh và các nhà lãnh đạo kinh doanh quốc tế.

        </p>
        <h4 id="item-2">Các loại phòng</h4>
        <p>Khu nghỉ dưỡng có 196 phòng được thiết kế theo phong cách truyền thống Việt Nam kết hợp với phong
          cách Pháp, 2 tòa nhà 4 tầng có hướng nhìn ra biển, nhìn ra hồ bơi trong xanh và những khu vườn nhiệt
          đới xanh tươi mát. Ngoài ra, khu nghỉ dưỡng Furama còn cung cấp các liệu pháp spa, phòng xông hơi
          ướt, phòng xông hơi khô, dịch vụ mát-xa cạnh hồ bơi, các dịch vụ thể thao dưới nước và các
          lớp tập yoga và Thái Cực Quyền trên bãi </p>
        <h4 id="item-3">TRẢI NGHIỆM ẨM THỰC & GIẢI TRÍ</h4>
        <p>
          Khu nghỉ dưỡng Furama Đà Nẵng là một khu nghỉ dưỡng 5 sao sang trọng, có uy tín và được xem là một
          trong những biểu tượng của ngành du lịch Việt Nam.
        </p>
        <p>DIVING
          The coast surrounding the Furama Resort offers a new and exciting destination for divers in Asia
          during the Danang diving season from February to October. Furama Resort Dive Center is operated by
          highly qualified PADI instructors, offering diving or snorkeling tours to Son Tra Peninsula and Cham
          Island, and classes at the resort’s pools.</p>
        <p>GOLF
          Have a unique golf experience and an unforgettable time at the 18-hole Montgomerie Links by tranquil
          Danang Beach and striking Marble Mountain or make the most of your holiday at the 18-hole Danang
          Golf Club – the unique Greg Norman designed and only true“Links Course” in Southeast Asia, both just
          7 minutes drive from Furama Resort.</p>
        <p>WATER SPORTS
          A full range of water sports will keep you busy. We offer catamaran sailing, windsurfing, ocean
          kayaking, body boarding, aqua cycling, water skiing, jet skiing, wake boarding, banana, parasailing
          and other towable items all available for rent. While at the beach don’t miss out on our daily Tai
          Chi lesson or a list of other activities that change daily; yoga lessons, organized volleyball,
          football and badminton competitions.

          For those who like to work out on their holidays, the Fitness Centre in our Health Club is open from
          6:00am to 11:00pm daily.</p>
        <p>HELICOPTER TOURS
          FURAMA HELICOPTER TOURS TAKING OFF FROM THE RESORT’S OWN HELIPAD

          Enjoy the breathtaking view of Danang City features all the famous landmarks including the iconic
          Dragon Bridge and the extremely impressive 67-metre Lady Buddha statue at Linh Ung pagoda.

          Take a deep breath and admire the beautiful scenery along both banks of the poetic Han River; The
          many fishing-boats bobbing on the water</p>
        <p>...</p>
      </div>
    </div>
  </div>
  <div class="row">
    <div class="blockquote-footer bg-black text-center">
      <p>Trần thuận ® 2022- Đà nẵng</p>
    </div>
  </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
        crossorigin="anonymous"></script>
</body>
</html>
