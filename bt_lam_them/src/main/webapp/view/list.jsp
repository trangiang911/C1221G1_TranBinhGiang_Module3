<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 4/24/2022
  Time: 4:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.11.5/css/dataTables.bootstrap4.min.css">
</head>
<body>
<div class="row">
    <div class="col-sm-12">
        <h1>Danh sách Nhân viên</h1>
        <p>
            <c:if test='${requestScope["mess"] != null}'>
                <span class="message" style="color: green;font-size: large">${requestScope["mess"]}</span>
            </c:if>
        </p>
<%--        <button type="submit"><a href="/san_pham?action=create">Thêm mới</a></button>--%>
        <button type="button" class="btn btn-primary" data-toggle="modal"
                data-target="#exampleModalCenter1">
            create
        </button>
        <hr>
        <form action="/san_pham">
            <input type="hidden" name="action" value="search">
            <input type="text" name="name" placeholder="name">
            <input type="text" name="price" placeholder="price">
            <button>Search</button>
        </form>
        <table border="1" cellpadding="5" id="Mytable" class="table table-striped table-bordered"
               style="width: 100%">
            <thead>
            <tr>
                <td>Stt</td>
                <td>Tên sản phẩm</td>
                <td>giá</td>
                <td>Số lượng</td>
                <td>màu sắc</td>
                <td>mô tả</td>
                <td>edit</td>
                <td>xoá</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="x" items="${list}" varStatus="index">
                <tr>
                    <td>${index.count}</td>
                    <td>${x.getName()}</td>
                    <td><fmt:formatNumber>${x.getPrice()}</fmt:formatNumber></td>
                    <td>${x.getQuantity()}</td>
                    <td>${x.getColor()}</td>
                    <td>
                        <c:forEach var="y" items="${category}">
                            <c:if test="${x.getId_cate() eq y.getId_cate()}">
                                ${y.getName()}
                            </c:if>
                        </c:forEach>
                    </td>
                    <td><a href="/san_pham?action=edit&id=${x.getId()}">edit</a></td>
                    <td>
                        <button type="button" class="btn btn-primary" data-toggle="modal"
                                data-target="#exampleModalCenter" onclick="deleteSanPham(${x.getId()},'${x.getName()}')">
                            delete
                        </button>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <!-- Modal -->
    <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog"
         aria-labelledby="exampleModalCenterTitle"
         aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLongTitle">Delete employee</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    Bạn có muốn xoá ko
                    <span>Tên: <p id="name"></p></span>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close
                    </button>
                    <form method="post">
                        <input type="hidden" name="action" value="del">
                        <input type="hidden" name="id" id="id-del">
                        <button type="submit" class="btn btn-primary">Xác nhận xoá</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <!-- Modal -->
    <div class="modal fade" id="exampleModalCenter1" tabindex="-1" role="dialog"
         aria-labelledby="exampleModalCenterTitle"
         aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLongTitle1">Delete</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <form method="post">
                <div class="modal-body">
                    <fieldset>
                        <legend>Thông tin sản phẩm</legend>
                        <table>
                            <tr>
                                <td>Tên sản phẩm</td>
                                <td>
                                    <input type="text" name="name">
                                    <p style="color: #ff0000">${error.get("name")}</p>
                                </td>
                            </tr>
                            <tr>
                                <td>Giá sản phẩm</td>
                                <td><input type="text" name="price">
                                    <p style="color: #ff0000">${error.get("price")}</p>
                                </td>
                            </tr>
                            <tr>
                                <td>Số lượng</td>
                                <td>
                                    <input type="text" name="quantity">
                                    <p style="color: red">${error.get("quantity")}</p>
                                </td>
                            </tr>
                            <tr>
                                <td>Màu sản phẩm</td>
                                <select name="color">
                                    <option value="Đen">Đen</option>
                                    <option value="Đỏ">Đỏ</option>
                                    <option value="Vàng">Vàng</option>
                                    <option value="Trắng">Trắng</option>
                                    <option value="Xanh">Xanh</option>
                                </select>
                            </tr>
                            <tr>
                                <td>Mô tả</td>
                                <td>
                                    <select name="category">
                                        <c:forEach var="x" items="${category}">
                                            <option value="${x.getId_cate()}">${x.getName()}</option>
                                        </c:forEach>
                                    </select>
                                </td>
                            </tr>
                        </table>
                    </fieldset>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close
                    </button>

                        <input type="hidden" name="action" value="create">
<%--                        <input type="hidden" name="id" id="id-del">--%>
                        <button type="submit" class="btn btn-primary">thêm mới</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
<%--</div>--%>

<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
        integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.min.js"
        integrity="sha384-VHvPCCyXqtD5DqJeNxl2dtTyhF78xXNXdkwX1CZeRusQfRKp+tA7hAShOK/B/fQ2"
        crossorigin="anonymous"></script>
<script src="https://cdn.datatables.net/1.11.5/js/dataTables.bootstrap4.min.js"></script>
<script>
    function deleteSanPham(id,name) {
        document.getElementById("id-del").value = id;
        document.getElementById("name").innerText=name;
    }
</script>
<script>
    $(document).ready(function () {
        $('#Mytable').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        });
    });</script>
</body>
</html>
