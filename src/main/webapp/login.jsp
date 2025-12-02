<%@ include file="header.jsp" %>

<div class="row justify-content-center">
  <div class="col-md-6">

    <div class="card shadow-sm">
      <div class="card-body">
        <h3 class="mb-4">Admin Login</h3>

        <form action="admin-login" method="post">

          <div class="mb-3">
          	 <p style="color:red; font-weight:bold;">${error}</p>
            <label class="form-label">Username</label>
            <input type="text" name="username" class="form-control" required>
          </div>

          <div class="mb-3">
            <label class="form-label">Password</label>
            <input type="password" name="password" class="form-control" required>
          </div>

          <button class="btn btn-primary">Login</button>

        </form>
      </div>
    </div>

  </div>
</div>

</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
