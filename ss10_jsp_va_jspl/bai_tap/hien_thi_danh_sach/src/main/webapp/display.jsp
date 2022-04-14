<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 4/13/2022
  Time: 9:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        table, th, td {
            border: 1px solid black;
        }
    </style>
</head>
<body>
<h1>Danh Sách Khách Hàng</h1>
<table>
    <tr>
        <td>Tên</td>
        <td>Ngày Sinh</td>
        <td>Địa chỉ</td>
        <td>Ảnh</td>
    </tr>
    <c:forEach var="result" items="${name}">
        <tr>
            <td>${result.getName()}</td>
            <td>${result.getDate()}</td>
            <td>${result.getDiaChi()}</td>
            <td>
                <img src="${result.getAvt()}" alt="" style="width: 100px;height: 100px"></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
