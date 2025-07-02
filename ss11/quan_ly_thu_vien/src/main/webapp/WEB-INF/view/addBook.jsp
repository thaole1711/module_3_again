<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 6/8/2025
  Time: 10:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">

<html>
<head>
    <title>Title</title>

<style>

    .mb-3 input,
    .mb-3 select:focus {
         border-color: #ffc107 !important;
        box-shadow: 0 0 0 0.25rem rgba(255, 193, 7, 0.25);
    }
</style>
</head>
<body>
<div class="container" style="max-width: 900px; margin-top: 30px;background-color: #fff4e5; border-radius: 10px">
    <h4 class="mb-4 text-center">Thêm Sách</h4>

    <form method="post">
        <div class="mb-3">
            <label for="formGroupExampleInput0" class="form-label">Tên</label>
            <input pattern="[A-Za-zÀ-ỹà-ỹ0-9\s]+" title="không nhập kí tự đặc biệt"
                   name="title" required value="${book.title}" type="text" class="form-control"
                   id="formGroupExampleInput0" placeholder="title">
        </div>

        <div class="mb-3">
            <label for="formGroupExampleInput" class="form-label">Trang</label>
            <input pattern="[0-9]+" title="chỉ nhập số" min="10" max="400" name="pageSize" required value="${book.pageSize}"
                   type="text"  class="form-control" id="formGroupExampleInput" placeholder="pageSize">
        </div>

        <div class="mb-3">
            <label for="formGroupExampleInput3" class="form-label"> Thể Loại</label>
            <select name="categoryId" id="formGroupExampleInput3">
                <option>Tất cả loại</option>
                <c:forEach var="category" items="${category}">
                    <option value="${category.categoryId}">${category.categoryName}</option>
                </c:forEach>
            </select>

        </div>

        <div class="mb-3">
            <label for="formGroupExampleInput2" class="form-label">Mã tác giả</label>
            <input pattern="[0-9]+" title="chỉ nhập số" name="authorId" required value="${book.authorId}"
                   type="number" min="1" max="7" class="form-control" id="formGroupExampleInput2" placeholder="authorId">
        </div>

        <div class="d-flex justify-content-end gap-2 mt-2">
            <button type="submit" class="btn btn-warning btn-sm">Thêm</button>
        </div>
    </form>
</div>
</body>

</html>
