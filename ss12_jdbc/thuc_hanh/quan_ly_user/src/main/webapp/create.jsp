<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 4/18/2022
  Time: 10:19 AM
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
        <span class="message">${requestScope["mess"]}</span>
    </c:if>
</p>
<p>
    <a href="/">Back to User list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Product information</legend>
        <table>
            <tr>
                <td>Name User </td>
                <td><input type="text" name="name_user" id="name_user"></td>
            </tr>
            <tr>
                <td>Email </td>
                <td><input type="text" name="email" id="email"></td>
            </tr>
            <tr>
                <td>Country </td>
                <td><input type="text" name="country" id="country"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Create user"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
