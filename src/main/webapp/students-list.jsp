w<%@ page import="java.util.List" %>
<%@ page import="com.model.Student" %>
<%@ include file="header.jsp" %>

<h3 class="mb-4">Registered Students</h3>

<a href="add-student.jsp" class="btn btn-success mb-3">+ Add Student</a>

<table class="table table-striped table-hover">
  <thead class="table-primary">
    <tr>
      <th>ID</th>
      <th>First Name</th>
      <th>Last Name</th>
      <th>Email</th>
      <th>Actions</th>
    </tr>
  </thead>

  <tbody>
  <%
      List<Student> list = (List<Student>) request.getAttribute("studentsList");
      if (list != null) {
          for (Student s : list) {
  %>
      <tr>
        <td><%= s.getStudentId() %></td>
        <td><%= s.getFirstName() %></td>
        <td><%= s.getLastName() %></td>
        <td><%= s.getEmail() %></td>
        <td>
          <a href="edit-student?id=<%= s.getStudentId() %>" class="btn btn-warning btn-sm me-1">
            Edit
          </a>
          <a href="delete-student?id=<%= s.getStudentId() %>"
             class="btn btn-danger btn-sm"
             onclick="return confirm('Are you sure?');">
            Delete
          </a>
        </td>
      </tr>
  <%
          }
      }
  %>
  </tbody>
</table>

</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
