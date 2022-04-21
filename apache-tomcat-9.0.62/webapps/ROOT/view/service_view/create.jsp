<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 4/20/2022
  Time: 11:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Create new Service</h1>
<p>
    <c:if test='${requestScope["mess"] != null}'>
        <span class="message" style="color: green;font-size: large">${requestScope["mess"]}</span>
    </c:if>
</p>
<p>
    <a href="/service">Back to Customer list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Thông tin khách hàng</legend>
        <table>
            <tr>
                <td>Tên dịch vu</td>
                <td>
                    <input type="text" name="name">
                </td>
            </tr>
            <tr>
                <td>Diện tích</td>
                <td><input type="text" name="area"></td>
            </tr>
            <tr>
                <td>Chi phí thuê</td>
                <td><input type="text" name="chi_phi_thue"></td>
            </tr>
            <tr>
                <td>Số người tối đa</td>
                <td>
                    <input type="text" name="so_nguoi">
                </td>
            </tr>
            <tr>
                <td>Kiểu thuê</td>
                <td>
                    <select name="ma_kieu_thue">
                        <c:forEach var="y" items="${rent_list}">
                            <option value="${y.getMaKieuThue()}">${y.getTenKieuThue()}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Loại dịch vụ</td>
                <td>
                    <select name="ma_loai_dich_vu">
                        <c:forEach var="z" items="${type_list}">
                            <option value="${z.getMaLoaiDichVu()}">${z.getTenLoaiDichVu()}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Tiêu chuẩn phòng</td>
                <td><input type="text" name="tieu_chuan"></td>
            </tr>
            <tr>
                <td>Mô tả tiện nghi khác</td>
                <td><input type="text" name="mo_ta"></td>
            </tr>
            <tr>
                <td>Diện tích bể bơi</td>
                <td><input type="text" name="dien_tich_be_boi"></td>
            </tr>
            <tr>
                <td>Số tầng</td>
                <td><input type="text" name="so_tang"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Create"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
