<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 4/12/2022
  Time: 4:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h2>Product Discount Calculator</h2>
  <form action="/display-discount" method="get">
    <input type="text" name="productDescription" placeholder="Mô tả sản phẩm">
    <input type="number" name="listPrice" placeholder="Giá niêm yết">
    <input type="number" name="discountPercent" placeholder="Tỉ lệ chiết khấu">
    <button type="submit">Calculate Discount</button>
  </form>
  </body>
</html>
