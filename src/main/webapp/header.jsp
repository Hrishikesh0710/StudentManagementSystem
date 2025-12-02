<%@ page session="true" %>

<%

    String admin = null;
    if (session != null && session.getAttribute("admin") != null) {
        admin = (String) session.getAttribute("admin");
    }
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Management System</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">

    <style>
        body { padding-top: 70px; }
        .container-sm { max-width: 900px; }
    </style>
</head>
<body>

<!-- NAVBAR -->
<nav class="navbar navbar-dark bg-primary fixed-top" style="padding: 14px 0;">
  <div class="container-fluid d-flex justify-content-between align-items-center">

 
    <div class="d-flex align-items-center" style="gap: 25px;">
        <span class="navbar-brand mb-0" style="font-size: 1.3rem; font-weight: bold;">
            SMS
        </span>

        <% if (admin != null) { %>
            <a class="nav-link" href="index.jsp" style="color: white; font-size: 1.1rem;">
                Home
            </a>
        <% } %>
    </div>

 
    <div class="text-center w-50">
        <% if (admin != null) { %>
           <span style="color: white; font-size: 1.5rem; font-weight: 600;">
   				 Hello, <%= admin %>
			</span>
        <% } %>
    </div>


    <div class="d-flex align-items-center">

        <% if (admin != null) { %>
            <a class="btn btn-outline-light btn-sm" href="logout" 
               style="font-size: 1rem; padding: 6px 14px;">
               Logout
            </a>
        <% } else { %>
            <a class="btn btn-outline-light btn-sm" href="login.jsp"
               style="font-size: 1rem; padding: 6px 14px;">
               Login
            </a>
        <% } %>

    </div>

  </div>
</nav>


<div class="container container-sm mt-4">
