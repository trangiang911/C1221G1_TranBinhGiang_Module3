<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 4/15/2022
  Time: 8:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <input type="text" name="name" value="${product.getName()}"><br>
    <input type="number" name="price" value="${product.getPrice()}"><br>
    <input type="text" name="sumary" value="${product.getSummary()}"><br>
    <input type="text" name="producer" value="${product.getProducer()}">
    <button type="submit">Xác nhận</button>
</form>
</body>
</html>
