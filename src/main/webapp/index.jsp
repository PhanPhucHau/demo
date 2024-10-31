<%@ page import="java.util.List" %>
<%@ page import="com.example.demo2.resource.model.Nhanvien" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 25/10/2024
  Time: 12:10 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP</title>
    <style>
        .container {
            width: 100%;
            border: 1px solid #000;
            padding: 10px;
        }
        .header {
            text-align: center;
            margin-bottom: 20px;
        }
        .header a {
            margin: 0 10px;
            text-decoration: none;
            color: #000;
        }
        .header a:hover {
            text-decoration: underline;
        }
        .title {
            text-align: center;
            font-weight: bold;
            margin-bottom: 10px;
        }
        .total {
            text-align: right;
            margin-bottom: 10px;
        }
        table{
            width: 100%;
            border-collapse: collapse;
        }
        th,td{
            border: 1px solid;
            text-align: left;
            padding: 8px;
        }
    </style>
    <script>
        function deleteNhanVien(id) {
            if (confirm("Bạn có chắc chắn muốn xóa nhân viên này không?")) {
                fetch(`/api/nhanvien/${id}`, { // Đảm bảo đường dẫn API chính xác
                    method: 'DELETE'
                })
                    .then(response => {
                        if (response.ok) {
                            alert("Xóa thành công!");
                            window.location.reload();
                        } else {
                            response.text().then(text => alert("Xóa thất bại: " + text));
                        }
                    })
                    .catch(error => {
                        console.error("Error:", error);
                        alert("Đã xảy ra lỗi khi kết nối tới server!");
                    });
            }
        }
    </script>
</head>
<body>
<div class="container">
    <div>10-20109451-Phan Phúc Hâụ
    show grants for 'admin'@'localhost';
    grant all privileges on classdb.* to 'admin'@'localhost' identified by 'sapassword';
    flush privileges;</div>
    <div class="header">
        <a href="#">Danh sách Nhân Viên</a> |
        <a href="<%= request.getContextPath() %>/addNhanVien">Thêm Nhân Viên</a>

    </div>
    <div class="title">DANH SÁCH NHÂN VIÊN</div>
    <div class="total">Tổng: 10</div>
    <form action="/delete" method="post" enctype="multipart/form-data">
    <table>
        <thead>
        <tr>
            <th>Teen phòng ban</th>
            <th>Ma nhan vien</th>
            <th>Ten nhan vien</th>
            <th>Email</th>
            <th>Sdt</th>
            <th>Dia Chi</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <% List<Nhanvien> nhanviens = (List<Nhanvien>) request.getAttribute("nhanvien");
            if (nhanviens != null) {
                for (Nhanvien nv : nhanviens){
        %>
        <tr>
            <td><%= nv.getMaphongban().getTenphongban()%></td>
            <td><%= nv.getId()%></td>
            <td><%= nv.getTennhanvien()%></td>
            <td><%= nv.getEmail()%></td>
            <td><%= nv.getDienthoai()%></td>
            <td><%= nv.getDiachi()%></td>
            <td>
                <button type="button" onclick="deleteNhanVien(<%= nv.getId() %>)">Xóa</button>
            </td>


        </tr>
        <%
            }
        %>
        <%
            }
        %>
        </tbody>
    </table>
        </form>
</div>
</body>
</html>
