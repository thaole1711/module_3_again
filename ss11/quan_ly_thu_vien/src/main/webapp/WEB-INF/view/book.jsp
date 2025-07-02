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
    <h2 style="font-family: Arial ; margin-top: 30px ; text-align: center; color: #e3b159;"> QUẢN LÝ THƯ VIỆN</h2>
    <div class="d-flex align-items-center gap-3 p-3">
        <!-- FORM THÊM + TÌM KIẾM TRÊN CÙNG 1 HÀNG, TRÁI - PHẢI -->
        <div class="container my-4" style="max-width: 900px;">
            <div class="d-flex justify-content-between align-items-center">
                <!-- Nút Thêm sách (bên trái) -->
                <a href="/book?action=add" class="btn btn-warning btn-sm d-flex align-items-center">
                    <i class="bi bi-plus-circle me-1"></i> Thêm sách
                </a>

                <!-- Form Tìm kiếm (bên phải) -->
                <form method="get" action="/book" class="d-flex align-items-center gap-2 p-3">
                    <input type="hidden" name="action" value="search"/>
                    <input type="text" name="name"
                           class="form-control form-control-sm"
                           placeholder="Tìm theo tên"
                           value="${param.name}" style="width: 200px;">

                    <select name="categoryId" class="form-select form-select-sm" style="width: 200px;">
                        <option value="">Tất cả loại</option>
                        <c:forEach var="category" items="${category}">
                            <option value="${category.categoryId}"
                                    <c:if test="${param.categoryId == category.categoryId.toString()}">selected</c:if>>
                                    ${category.categoryName}
                            </option>
                        </c:forEach>
                    </select>
                    <button type="submit" class="btn btn-sm btn-warning d-flex align-items-center">
                        <i class="bi bi-search me-1"></i> Tìm kiếm
                    </button>
                </form>
            </div>
        </div>

    </div>
</div>
<p style="color: red">${param.mess}</p>

<!-- Bảng sản phẩm -->
<div class="m-5">
    <table id="tableProduct" class="table table-hover table-bordered">
        <thead class="table-light">
        <tr style="background-color: #e3b159">
            <th>STT</th>
            <th>Tên</th>
            <th>Số trang</th>
            <th>Category</th>
            <th>Author</th>
            <th>Xóa</th>
            <th>Chỉnh sửa</th>

        </tr>
        </thead>
        <tbody style="background-color: #fff4e5">

                <c:if test="${empty books }">
                    <tr>không tìm thấy sản phẩm</tr>
                </c:if>


        <c:forEach var="book" items="${books}" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td>${book.title}</td>
                <td>${book.pageSize}</td>
                <td>
                    <c:forEach var="category" items="${category}">
                        <c:if test="${book.categoryId==category.categoryId}">
                            ${category.categoryName}
                        </c:if>
                    </c:forEach>
                </td>
                <td>${book.authorId}</td>
                <td>
                    <button onclick="deleteInfo(${book.bookId},'${book.title}')"
                            class="btn btn- btn-sm" data-bs-toggle="modal" data-bs-target="#exampleModal">
                        <i class="bi bi-trash text-danger me-2"></i></button>
                </td>
                <td>
                    <button onclick="window.location.href=`/book?action=update&id=${book.bookId}`"><i
                            class="bi bi-pencil text-primary"></i></button>
                </td>
                    <%--                                                    <button class="btn btn-warning"--%>
                    <%--                                                            onclick="window.location.href='/admin/product-management?action=update&id=${product.id}'">--%>
                    <%--                                                        <i class="ti ti-pencil text-light"></i>--%>
                    <%--                                                    </button>--%>


            </tr>
        </c:forEach>


        </tbody>
    </table>
</div>

<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form method="post" action="/book?action=delete">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="exampleModalLabel">Xóa sách</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input type="hidden" id="deleteId" name="deleteId" >
                    <span>Bạn có muốn xoá </span> <span id="deleteName"></span> không?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Huỷ</button>
                    <button class="btn btn-primary">Xoá</button>
                </div>
            </div>
        </form>
    </div>
</div>
<script>
    function deleteInfo(id, name) {
        console.log(id)
        document.getElementById("deleteId").value = id;
        document.getElementById("deleteName").innerText = name;
    }

</script>
<!-- jQuery phải được load đầu tiên -->
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>

<!-- Bootstrap Bundle (đã có Popper) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"></script>

<!-- DataTables -->
<script src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.13.4/js/dataTables.bootstrap5.min.js"></script>
<script>
    $(document).ready(function () {
        $('#tableProduct').DataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5,
            "language": {
                "info": "Hiển thị _START_ đến _END_ của _TOTAL_ mục",
                "infoEmpty": "Không có dữ liệu",
                "paginate": {
                    "next": "Sau",
                    "previous": "Trước"
                }
            }
        });
    });

</script>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"></script>
</html>






