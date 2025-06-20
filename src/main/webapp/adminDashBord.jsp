<%@ page import="lk.ijse.gdse.Dao.ComplainModel" %>
<%@ page import="lk.ijse.gdse.model.ComplainDto" %>
<%@ page import="java.util.List" %><%--
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


<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <div class="container">
        <a class="navbar-brand" href="#">CMS</a>
        <div class="d-flex">
            <a href="login.jsp" class="btn btn-outline-light btn-sm">Logout</a>
        </div>
    </div>
</nav>

<div class="container mt-5">
    <h3>All Complaints (Admin View)</h3>
    <%
        String uname = request.getParameter("uname");
        String subject = request.getParameter("subject");
        String  description = request.getParameter("Description");
        String date = request.getParameter("date");
        String status = request.getParameter("status");

        ComplainModel model = new ComplainModel();
        List<ComplainDto> complaints = model.getAllComplaints(uname ,subject,description,date,status);
    %>
    <table class="table table-bordered">
        <thead class="table-warning">
        <tr>
            <th>user Name</th>
            <th>Subject</th>
            <th>description</th>
            <th>date</th>
            <th>status</th>
            <th>action</th>
        </tr>
        </thead>
        <tbody>
        <% for (ComplainDto c : complaints) { %>
        <tr>
            <td><%= c.getUname() %></td>
            <td><%= c.getSubject() %></td>
            <td><%= c.getDescription() %></td>
            <td><%= c.getDate() %></td>
            <td><%= c.getStatus() %></td>
            <td>
                <form action="updateForm.jsp" method="post" style="display:inline-block">
                    <input type="hidden" name="action" value="update">
                    <input type="hidden" name="cid" value="<%= c.getCid() %>">
                    <input type="hidden" name="uname" value="<%= c.getUname() %>">
                    <input type="hidden" name="subject" value="<%= c.getSubject() %>">
                    <input type="hidden" name="description" value="<%= c.getDescription() %>">
                    <input type="hidden" name="date" value="<%= c.getDate() %>">
                    <input type="hidden" name="status" value="<%= c.getStatus() %>">
                    <button type="submit" class="btn btn-warning btn-sm">Update</button>
                </form>
                <form action="complaint" method="post" style="display:inline-block">
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="cid" value="<%= c.getCid() %>">
                    <button type="submit" class="btn btn-danger btn-sm">Delete</button>
                </form>
            </td>
        </tr>
        <% } %>
        </tbody>
    </table>
</div>

<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

<%
    String msg = (String) request.getAttribute("message");
    String icon = "success";
    String title = "Success";

    if (msg != null) {
        if (msg.toLowerCase().contains("fail")) {
            icon = "error";
            title = "Error";
        } else if (msg.toLowerCase().contains("delete")) {
            title = "Delete Success";
        } else if (msg.toLowerCase().contains("update")) {
            title = "Update Success";
        }
%>
<script>
    Swal.fire({
        icon: '<%= icon %>',
        title: '<%= title %>',
        text: '<%= msg %>',
        confirmButtonColor: '#3085d6',
        confirmButtonText: 'OK'
    });
</script>
<% } %>


</body>
</html>


