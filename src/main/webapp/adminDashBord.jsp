<%--
  Created by IntelliJ IDEA.
  User: PCplusss
  Date: 15-Jun-25
  Time: 8:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-5">
    <h3>All Complaints (Admin View)</h3>
    <table class="table table-bordered">
        <thead class="table-warning">
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Status</th>
            <th>Employee</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>1</td>
            <td>Printer Issue</td>
            <td>NEW</td>
            <td>john.doe</td>
            <td>
                <a href="#" class="btn btn-warning btn-sm">Update</a>
                <a href="#" class="btn btn-danger btn-sm">Delete</a>
            </td>
        </tr>
        </tbody>
    </table>
</div>

</body>
</html>
