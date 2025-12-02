<%@ page import="com.model.Student" %>
<%@ include file="header.jsp" %>

<%
    Student s = (Student) request.getAttribute("student");
%>

<h3 class="mb-4">Edit Student</h3>

<div class="card shadow-sm">
  <div class="card-body">

    <form action="update-student" method="post">

      <input type="hidden" name="id" value="<%= s.getStudentId() %>">

      <div class="mb-3">
      	<p style="color:red; font-weight:bold;">${successMsg}</p>
      	<p style="color:red; font-weight:bold;">${errorMsg}</p>
        <label class="form-label">First Name</label>
        <input type="text" name="firstName" class="form-control"
               value="<%= s.getFirstName() %>" required>
      </div>

      <div class="mb-3">
        <label class="form-label">Last Name</label>
        <input type="text" name="lastName" class="form-control"
               value="<%= s.getLastName() %>" required>
      </div>

      <div class="mb-3">
        <label class="form-label">Email</label>
        <input type="email" name="email" class="form-control"
               value="<%= s.getEmail() %>" required>
      </div>

      <button class="btn btn-primary">Update Student</button>
      <a href="view-students" class="btn btn-secondary ms-2">Cancel</a>

    </form>

  </div>
</div>

</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
