<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>home</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h2>Tờ khai y tế</h2>
    <p>ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC KHI CẦN THIẾT ĐỂ PHÒNG CHỐNG DỊCH
        BỆNH TRUYỀN NHIỄM</p>
    <p style="color: red">Khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể xử lý hình sự</p>
    <form:form action="" modelAttribute="medicalDeclaration" method="post">
        <p>Họ và tên(ghi chữ IN HOA)</p>
        <form:input size="100%" path="name"/>
        <table class="button" >
            <tr>
                <td>Năm sinh</td>
                <td>Giới tính</td>
                <td>Quốc tịch</td>
            </tr>
            <tr>
                <td>
                    <form:select cssStyle="width: 33%" path="yearOfBirth"/>
                </td>
                <td>
                    <form:select cssStyle="width: 33%" path="gender"/>
                </td>
                <td>
                    <form:select cssStyle="width: 33%" path="nationality"/>
                </td>
            </tr>
        </table>
        <p>Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác</p>
        <form:input  path="identityCard"/>

<%--        <p>Thông tin đi lại</p>--%>
<%--        <form:radiobuttons path="vehicle" items="hi"/>--%>

        <table style="width: 100%">
            <tr>
                <td>Số hiệu phương tiện</td>
                <td>Số ghế</td>
            </tr>
            <td>
                <form:input cssStyle="width: 50%" path="vehicleNumber"/>
            </td>
            <td>
                <form:input cssStyle="width: 50%" path="numberOfSeats"/>
            </td>
        </table>

        <table style="width: 100%">
            <tr>
                <td colspan="3">Ngày khởi hành</td>
                <td colspan="3">Ngày kết thúc</td>
            </tr>
            <td>
                <form:select cssStyle="width: 33%" path="releaseDate"/>
            </td>
            <td>
                <form:select cssStyle="width: 33%" path="endDate" />
            </td>
        </table>
        <p>Trong vòng 14 ngày qua, Anh/Chị có đến tỉnh/thành phố nào?</p>
        <form:input size="100%" path="schedule"/>
        <button type="submit">Gửi tờ khai</button>
    </form:form>
</div>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>
