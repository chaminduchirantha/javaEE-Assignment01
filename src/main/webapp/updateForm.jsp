<%--
  Created by IntelliJ IDEA.
  User: PCplusss
  Date: 15-Jun-25
  Time: 10:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Update Complaint</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
  <div class="card shadow-sm">
    <div class="card-header">
      <h4>Update Complaint</h4>
    </div>
    <div class="card-body">
      <form action="complaint" method="post">
        <input type="hidden" name="action" value="update">
        <input type="hidden" name="cid" value="<%= request.getParameter("cid") %>">

        <div class="mb-3">
          <label>User Name</label>
          <input type="text" name="uname" class="form-control" value="<%= request.getParameter("uname") %>" required>
        </div>

        <div class="mb-3">
          <label>Subject</label>
          <input type="text" name="subject" class="form-control" value="<%= request.getParameter("subject") %>" required>
        </div>

        <div class="mb-3">
          <label>Description</label>
          <textarea name="description" class="form-control" required><%= request.getParameter("description") %></textarea>
        </div>

        <div class="mb-3">
          <label>Date</label>
          <input type="date" name="date" class="form-control" value="<%= request.getParameter("date") %>" required>
        </div>

        <div class="text-end">
          <button type="submit" class="btn btn-primary">Update Complaint</button>
          <a href="adminDashBord.jsp" class="btn btn-secondary">Cancel</a>
        </div>
      </form>
    </div>
  </div>
</div>

</body>
</html>

