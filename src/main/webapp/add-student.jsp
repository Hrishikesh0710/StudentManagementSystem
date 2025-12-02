<%@ include file="header.jsp" %>

<h3 class="mb-4">Add Student</h3>

<div class="card shadow-sm">
  <div class="card-body">

    <form action="add-student" method="post">

      <div class="mb-3">
      <p style="color:red; font-weight:bold;">${success}</p>
        <label class="form-label">First Name</label>
        <input type="text" name="firstName" class="form-control" required>
      </div>

      <div class="mb-3">
        <label class="form-label">Last Name</label>
        <input type="text" name="lastName" class="form-control" required>
      </div>

      <div class="mb-3">
        <label class="form-label">Email</label>
        <input type="email" name="email" class="form-control" required>
      </div>

      <button class="btn btn-success">Register Student</button>
      <a href="view-students" class="btn btn-secondary ms-2">Cancel</a>

    </form>

  </div>
</div>

</div> 
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
