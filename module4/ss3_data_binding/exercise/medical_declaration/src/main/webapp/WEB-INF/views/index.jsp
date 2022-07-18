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
    <div class="text-center">
        <h3>TỜ KHAI Y TẾ</h3>
        <p>ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC KHI CẦN THIẾT ĐỂ PHÒNG CHỐNG
            DỊCH BỆNH TRUYỀN NHIỄM</p>
        <p class="text-danger">Khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể xử lý hình
            sự</p>
    </div>

    <form:form method="post" modelAttribute="medicalDeclaration" action="create">
        <div class="mb-3">
            <form:label path="name" class="form-label">Họ Tên (ghi in Chữ Hoa)</form:label>
            <form:input path="name" class="form-control"/>
        </div>
        <div class="row">
            <div class="col">
                <div class="mb-3">
                    <form:label path="yearOfBirth" class="form-label">Năm Sinh</form:label>
                    <form:select path="yearOfBirth" class="form-control" items="${yearOfBirthList}"/>
                </div>
            </div>
            <div class="col">
                <div class="mb-3">
                    <form:label path="gender" class="form-label">Giới tính</form:label>
                    <form:select path="gender" class="form-control">
                        <option selected>Choose...</option>
                        <option value="0">Nữ</option>
                        <option value="1">Nam</option>
                    </form:select>
                </div>
            </div>
            <div class="col">
                <div class="mb-3">
                    <label class="form-label"></label>
                    <form:label path="nationality" class="form-label">Quốc tịch</form:label>
                    <form:select path="nationality" class="form-control" items="${nationalityList}"/>

                </div>
            </div>
        </div>
        <div class="mb-3">
            <form:label path="identityCard"
                        class="form-label">Số hộ chiếu hoặc CMND hoặc giấy tờ thông hành khác</form:label>
            <form:input path="identityCard" class="form-control"/>
        </div>
        <div class="mb-3">
            <form:label path="vehicle" class="form-label">Thông tin ghi lại</form:label>
            <form:radiobuttons path="vehicle" items="${vehicleList}"/>
<%--            <div>--%>
<%--                <div class="form-check form-check-inline">--%>
<%--                    <form:radiobutton path="vehicle"  class="form-check-input" item="vehicleList"/>--%>
<%--                </div>--%>
<%--                <div class="form-check form-check-inline">--%>
<%--                    <form:radiobutton path="vehicle" class="form-check-input" label="Tàu thuyền" value="tàu thuyền"/>--%>
<%--                </div>--%>
<%--                <div class="form-check form-check-inline">--%>
<%--                    <form:radiobutton path="vehicle" class="form-check-input" label="Ô tô" value="ô tô"/>--%>
<%--                </div>--%>
<%--                <div class="form-check form-check-inline">--%>
<%--                    <form:radiobutton path="vehicle" class="form-check-input" label="Khác(ghi rõ)" value="khác"/>--%>
<%--                </div>--%>
<%--            </div>--%>
        </div>
        <div class="row">
            <div class="col">
                <div class="mb-3">
                    <form:label path="vehicleNumber" class="form-label">Số hiệu phương tiện</form:label>
                    <form:input path="vehicleNumber" cssClass="form-control" placeholder="VD: VN123"/>
                </div>
            </div>
            <div class="col">
                <div class="mb-3">
                    <form:label path="numberOfSeats" class="form-label">Số ghế</form:label>
                    <form:input path="numberOfSeats" cssClass="form-control"/>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <div class="mb-3">
                    <form:label path="releaseDate" class="form-label">Ngày khỏi hành</form:label>
                    <form:input path="releaseDate" type="date" class="form-control"/>
                </div>
            </div>
            <div class="col">
                <div class="mb-3">
                    <form:label path="endDate" class="form-label">Ngày kết thúc</form:label>
                    <form:input path="endDate" type="date" class="form-control"/>
                </div>
            </div>
        </div>
        <div class="mb-3">
            <label class="form-label">Trong vòng 14 ngày qua, Anh/chị có đến tỉnh/thành phố nào?</label>
            <form:textarea path="schedule" class="form-control"/>
        </div>
        <div class="text-center p-2">
            <input type="submit" class="btn btn-primary" value="GỬI TỜ KHAI">
        </div>
    </form:form>
    <form:form  action="admin" method="get" >
        <input type="submit" class="btn btn-primary" value="quản lí danh sách">
    </form:form>


</div>
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
