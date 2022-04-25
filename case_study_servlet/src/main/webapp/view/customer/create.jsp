<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 4/19/2022
  Time: 9:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Create new User</h1>
<p>
    <c:if test='${requestScope["mess"] != null}'>
        <span class="message" style="color: green;font-size: large">${requestScope["mess"]}</span>
    </c:if>
</p>
<p>
    <a href="/customer">Back to Customer list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Thông tin khách hàng</legend>
        <table>
            <tr>
                <td>Loại khách</td>
                <td>
                    <select name="type_customer">
                        <c:forEach var="x" items="${sub_list}">
                    <option value="${x.getMaLoaiKhachHang()}">${x.getLoaiKhachHang()}</option>
                        </c:forEach>
                </select>
                </td>
            </tr>
            <tr>
                <td>Tên khách hàng</td>
                <td>
                    <input type="text" name="name">
                    <p style="color: #ff0000">${error.get("name")}</p>
                </td>
            </tr>
            <tr>
                <td>Ngày sinh khách hàng</td>
                <td><input type="date" name="date">
                </td>
            </tr>
            <tr>
                <td>Giới tính</td>
                <td>
                    <select name="gender" id="">
                        <option value="0">Nữ</option>
                        <option value="1">Nam</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Số chứng minh nhân dân</td>
                <td>
                    <input type="text" name="cmnd">
                    <p style="color: red">${error.get("cmnd")}</p>
                </td>
            </tr>
            <tr>
                <td>Số điện thoại khách hàng</td>
                <td><input type="text" name="sdt"></td>
            </tr>
            <tr>
                <td>Email khách hàng</td>
                <td><input type="text" name="email"></td>
            </tr>
            <tr>
                <td>Địa chỉ khách hàng</td>
                <td><input type="text" name="dia_chi"></td>
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
