<%--
  Created by IntelliJ IDEA.
  User: PCplusss
  Date: 15-Jun-25
  Time: 8:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Submit Complaint - CMS</title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body class="bg-light">

<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <div class="container">
        <a class="navbar-brand" href="#">CMS</a>
        <div class="d-flex">
            <a href="login.jsp" class="btn btn-outline-light btn-sm">Logout</a>
        </div>
    </div>
</nav>

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-7">
            <div class="card shadow-sm">
                <div class="card-header bg-white">
                    <h4 class="mb-0">Submit New Complaint</h4>
                </div>
                <div class="card-body">
                    <form action="SubmitComplaintServlet" method="post">
                        <div class="mb-3">
                            <label class="form-label">user Name</label>
                            <input type="text" name="username" class="form-control" placeholder="Enter User Name" required/>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Subject</label>
                            <input type="text" name="subject" class="form-control" placeholder="Enter complaint subject" required/>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Date</label>
                            <input type="date" name="date" class="form-control" placeholder="Enter Date" required/>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Description</label>
                            <textarea name="description" class="form-control" rows="4" placeholder="Describe your complaint..." required></textarea>
                        </div>

                        <div class="mb-3 text-end">
                            <button type="submit" class="btn btn-success">Submit Complaint</button>
                        </div>
                    </form>

                    <c:if test="${not empty message}">
                        <div class="alert alert-info mt-3"></div>
                    </c:if>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>