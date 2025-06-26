<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 6/21/2025
  Time: 2:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách sản phẩm</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
    <!-- DataTables CSS + JS -->
    <link rel="stylesheet" href="https://cdn.datatables.net/1.13.4/css/dataTables.bootstrap5.min.css">
    <script src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/1.13.4/js/dataTables.bootstrap5.min.js"></script>
    <style>

        /* Hover màu vàng nhạt */
        table.table-hover > tbody > tr:hover {
            background-color: #fff9c4 !important;
        }

        .form-control:focus,
        .form-select:focus {
            border-color: #ffc107 !important;
            box-shadow: 0 0 0 0.25rem rgba(255, 193, 7, 0.25);
        }

        .table-hover tbody tr:hover {
            background-color: #fff9c4 !important; /* vàng nhạt */
        }

        td button {
            border: none;
            background: none;
            padding: 0 4px;
        }

        td i:hover {
            color: #ffc107;
            cursor: pointer;
        }


    </style>
</head>
<body>
<div>
    <h2 style="font-family: Arial ; margin-top: 30px ; text-align: center; color: #e3b159;"> DANH SÁCH HỌC SINH</h2>


</div>
</div>


<!-- Bảng sản phẩm -->
<div class="m-5">
    <table id="tableProduct" class="table table-hover table-bordered">
        <thead class="table-light">
        <tr style="background-color: #e3b159">
            <th>STT</th>
            <th>Tên</th>
            <th>Giới tính</th>
            <th>Điểm</th>
            <th>Xếp loại</th>

        </tr>
        </thead>
        <tbody style="background-color: #fff4e5">

        <c:if test="${empty students }">
            <tr>không tìm thấy học sinh</tr>
        </c:if>


        <c:forEach var="student" items="${students}" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td>${student.nameStudent}</td>
                <td>${student.gender}</td>

                <td>${student.score}</td>

                <td><c:choose>
                    <c:when test="${student.score >=9.0}">Giỏi</c:when>
                    <c:when test="${student.score >=8.0}">Khá</c:when>
                    <c:when test="${student.score >=6.0}">Trung Bình</c:when>
                    <c:otherwise>Yếu</c:otherwise>
                </c:choose></td>
            </tr>
        </c:forEach>


        </tbody>
    </table>
</div>


</script>
<!-- jQuery phải được load đầu tiên -->
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>

<!-- Bootstrap Bundle (đã có Popper) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"></script>

<!-- DataTables -->
<script src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.13.4/js/dataTables.bootstrap5.min.js"></script>

</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"></script>
</html>






