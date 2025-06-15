<%--
  Created by IntelliJ IDEA.
  User: PCplusss
  Date: 15-Jun-25
  Time: 12:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.*, lk.ijse.gdse.model.*, lk.ijse.gdse.dto.ComplainDto" %>
<%@ page import="lk.ijse.gdse.dto.ComplainDto" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>My Complaints</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<div class="container mt-5">
    <h3>My Complaints</h3>
    <%
        String uname = request.getParameter("uname");
        ComplainModel model = new ComplainModel();
        List<ComplainDto> complaints = model.getComplaintsByUser(uname);
    %>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>User Name</th>
            <th>Subject</th>
            <th>Description</th>
            <th>Date</th>
        </tr>
        </thead>
        <tbody>
            <% for (ComplainDto c : complaints) { %>
        <tr>
            <td><%= c.getUname() %></td>
            <td><%= c.getSubject() %></td>
            <td><%= c.getDescription() %></td>
            <td><%= c.getDate() %></td>
        </tr>
        <% } %>
        </tbody>
    </table>
</div>
</body>
</html>
