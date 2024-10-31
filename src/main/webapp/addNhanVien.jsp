<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 30/10/2024
  Time: 9:57 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Thêm mới nhân viên</h2>
<form action="<%= request.getContextPath() %>/addNhanVien" method="post">
  <label>Mã nhân viên:</label>
  <input type="number" name="id" required><br>

  <label>Tên nhân viên:</label>
  <input type="text" name="tennhanvien" maxlength="50" required><br>

  <label>Email:</label>
  <input type="email" name="email" maxlength="50"><br>

  <label>Địa chỉ:</label>
  <input type="text" name="diachi" maxlength="50"><br>

  <label>Điện thoại:</label>
  <input type="number" name="dienthoai"><br>

  <label>Mã phòng ban:</label>
  <input type="text" name="maphongban"><br>

  <button type="submit">Lưu nhân viên</button>
</form>
</body>
</html>
