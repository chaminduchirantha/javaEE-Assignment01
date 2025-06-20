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
        <input type="hidden" name="action" value="updateStatusOnly">
        <input type="hidden" name="cid" value="<%= request.getParameter("cid") %>">

        <div class="mb-3">
          <label>Status</label>
          <select name="status" class="form-control" required>
            <option value="inProgress" <%= "inProgress".equals(request.getParameter("status")) ? "selected" : "" %>>In Progress</option>
            <option value="resolved" <%= "resolved".equals(request.getParameter("status")) ? "selected" : "" %>>Complaint is Resolved</option>
            <option value="rejected" <%= "rejected".equals(request.getParameter("status")) ? "selected" : "" %>>Complaint is Rejected</option>
          </select>
        </div>


        <div class="text-end">
          <button type="submit" class="btn btn-primary">Update Status</button>
          <a href="adminDashBord.jsp" class="btn btn-secondary">Cancel</a>
        </div>
      </form>
    </div>
  </div>
</div>
</body>
</html>

