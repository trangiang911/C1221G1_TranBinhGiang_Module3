<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 4/13/2022
  Time: 8:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/display12" method="get">
  <button type="submit" >Hiển thi danh sách KH</button>
  </form>
  <form action="/display12" method="post">
    <input type="text" name="name" placeholder="Nhập tên">
    <input type="text" name="date" placeholder="Nhập ngày ngày sinh">
    <input type="text" name="dia-chi" placeholder="Nhập địa chỉ">
    <input type="text" name="anh" placeholder="Nhập url ảnh">
    <button type="submit">Thêm mới khách hàng</button>
  </form>
  </body>
</html>
