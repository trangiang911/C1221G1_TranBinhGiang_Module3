<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 4/18/2022
  Time: 10:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<h1>Danh sách sản phẩm</h1>
<form action="/user">
    <input type="hidden" name="action" value="search">
    <input type="text" name="name">
    <button type="submit">Search</button>
</form>
<button type="submit"><a href="/product?action=create">Thêm mới</a></button>
<table class="table table-striped">
    <tr>
        <td>id</td>
        <td>Name</td>
        <td>Email</td>
        <td>Country</td>
    </tr>
    <c:forEach var="x" items="${list}">
        <tr>
            <td>${x.getId()}</td>
            <td>${x.getName()}</td>
            <td>${x.getEmail()}</td>
            <td>${x.getCountry()}</td>
            <td><a href="/user?action=edit&id=${x.getId()}">edit</a></td>
            <td>
                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter" onclick="deleteUser(${x.getId()})">
                    delete
                </button>
                <!-- Modal -->
                <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog"
                     aria-labelledby="exampleModalCenterTitle"
                     aria-hidden="true">
                    <div class="modal-dialog modal-dialog-centered" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLongTitle">Modal title</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                Bạn có muốn xoá ko
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                <form method="post">
                                    <input type="hidden" name="action" value="del">
                                    <input type="hidden" name="id" id="id-del">
                                    <button type="submit" class="btn btn-primary">Xác nhận xoá</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </td>
        </tr>

    </c:forEach>
</table>


<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
<script>
    function deleteUser(id) {
        document.getElementById("id-del").value=id;
    }
</script>
</body>
</html>
