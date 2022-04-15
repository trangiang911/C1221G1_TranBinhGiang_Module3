<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 4/14/2022
  Time: 9:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/customer" method="post">
    <input type="text" name="id" placeholder="Nhập id xoá hoặc tìm kiếm">
    <hr>
    <br>
    <div>
    <input type="text" name="id1" placeholder="Nhập id thêm mới">
    <input type="text" name="name" placeholder="Nhập tên thêm mới">
    <input type="text" name="email" placeholder="Nhập email">
    <input type="text" name="address" placeholder="Nhập địa chỉ">
    </div>
    <hr>
    <br>
    <select name="select" >
      <option value="add">Thêm mới khách hàng</option>
      <br>
      <option value="edit">Chỉnh sửa</option>
      <br>
      <option value="del">Xoá khách hàng</option>
      <br>
      <option value="find">Tìm khách hàng</option>
      <br>
      <option value="display">Hiển thị toàn bộ khách hàng</option>
      <br>
    </select>
    <br>
    <button type="submit">Xác nhận</button>
  </form>
  <form>
    <h2>Danh sách khách hàng</h2>
    <table>
      <tr>
        <td>Id</td>
        <td>Tên khách hàng</td>
        <td>Email</td>
        <td>Địa chỉ</td>
      </tr>
      <c:forEach var="x" items="${list}" >
        <tr>
          <td>${x.getId()}</td>
          <td>${x.getName()}</td>
          <td>${x.getEmail()}</td>
          <td>${x.getAddress()}</td>
        </tr>
      </c:forEach>
    </table>
  </form>
  </body>
</html>
