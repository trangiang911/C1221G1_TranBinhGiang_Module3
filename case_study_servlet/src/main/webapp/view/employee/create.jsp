<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 4/21/2022
  Time: 8:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Create new employee</h1>
<p>
    <c:if test='${requestScope["mess"] != null}'>
        <span class="message" style="color: green;font-size: large">${requestScope["mess"]}</span>
    </c:if>
</p>
<p>
    <a href="/employee">Back to employee list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Thông tin nhân viên</legend>
        <table>
            <tr>
                <td>Tên khách hàng</td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td>Ngày sinh khách hàng</td>
                <td><input type="date" name="date"></td>
            </tr>
            <tr>
                <td>Số chứng minh nhân dân</td>
                <td><input type="text" name="cmnd"></td>
            </tr>
            <tr>
                <td>Lương nhân viên</td>
                <td><input type="text" name="luong"></td>
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
                <td>Vị trí nhân viên</td>
                <td>
                    <select name="vi_tri">
                    <c:forEach var="x" items="${position_list}">
                        <option value="${x.getMaViTri()}">${x.getTenViTri()}</option>
                    </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Trình độ nhân viên</td>
                <td>
                    <select name="trinh_do">
                        <c:forEach var="y" items="${education_list}">
                            <option value="${y.getMaTringDo()}">${y.getTenTrinhDo()}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Bộ phận</td>
                <td>
                    <select name="bo_phan">
                        <c:forEach var="z" items="${division_list}">
                            <option value="${z.getMaBoPhan()}">${z.getTenBoPhan()}</option>
                        </c:forEach>
                    </select>
                </td>
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
