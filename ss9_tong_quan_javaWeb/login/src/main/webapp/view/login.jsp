<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 6/24/2025
  Time: 4:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">
<style>
    .login{
        max-width: 360px; /* nhỏ gọn */
        margin: 60px auto; /* căn giữa theo chiều ngang, cách đỉnh 60px */
        padding: 30px;
        border: 1px solid #ddd;
        border-radius: 8px;
        background-color: #f8f9fa; /* nền xám nhạt */
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* bóng nhẹ */
    }
</style>
</head>
<body>

<div class="login">
<form action="login" method="post" >
    <input type="hidden" name="action" value="login">
    <h1 style="font-family: Arial">login</h1>
    <div class="mb-3">
        <label for="exampleInputEmail1" class="form-label">User</label>
        <input name="user" type="text" pattern="[a-z]{5}" title="admin" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">

    </div>
    <div class="mb-3">
        <label for="exampleInputPassword1" class="form-label">Password</label>
        <input name="password" pattern="[0-9]{3}[a-z]{3}" title="123abc"  type="password" class="form-control" id="exampleInputPassword1">
    </div>
    <p style="color: red">${param.mess}</p>
    <button type="submit" class="btn btn-primary">Submit</button>


</form>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js" integrity="sha384-ndDqU0Gzau9qJ1lfW4pNLlhNTkCfHzAVBReH9diLvGRem5+R9g2FzA8ZGN954O5Q" crossorigin="anonymous"></script>
</html>
