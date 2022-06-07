<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
           <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
    <link rel="stylesheet" href="/sof3021_assignment/css/style.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="/sof3021_assignment/css/bootstrap.min.css" />
<style type="text/css">
a{
    text-decoration: none;
}
</style>
</head>
<body>
<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark static-top">
    <div class="container">
      <a class="navbar-brand" href="#">
        <img src="https://placeholder.pics/svg/150x50/888888/EEE/Logo" alt="..." height="36">
      </a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav ms-auto">
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="#">Home</a>
          </li>
          
          <li class="nav-item">
            <a class="nav-link" href="#">Link</a>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
              Dropdown
            </a>
            <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
              <li><a class="dropdown-item" href="#">Action</a></li>
              <li><a class="dropdown-item" href="#">Another action</a></li>
              <li>
                <hr class="dropdown-divider">
              </li>
              <li><a class="dropdown-item" href="#">Something else here</a></li>
            </ul>
          </li>
        </ul>
      </div>
    </div>
  </nav>

<!-- Sidebar -->
<div class="w3-sidebar w3-light-grey w3-bar-block" style="width:25%">
    <h3 class="w3-bar-item">Menu</h3>
    <a href="#" class="w3-bar-item w3-button">Account </a>
    <a href="#" class="w3-bar-item w3-button">Category</a>
    <a href="#" class="w3-bar-item w3-button">Product</a>
    <a href="#" class="w3-bar-item w3-button">Order</a>
    <a href="#" class="w3-bar-item w3-button">OrderDetail</a>
  </div>
  
  <!-- Page Content -->
  <div style="margin-left:25%">
  
  <div class="w3-container w3-teal">
    <h1>Admin Dashbroad</h1>
  </div>
  <form:form
		modelAttribute="order"
		method="POST"
		action="/sof3021_assignment/admin/orders/store">
		<div>
			<label class="form-label">Address</label>
			<form:input class="form-control" name="address" path="address" />
		</div>
			<div>
			<label class="form-label">CreatedDate</label>
			<form:input class="form-control" name="createDate" path="createDate" type="date"/>
		</div>
		
		<div>
													<label  class="form-label">User_ID</label>
													<form:select path="account" class="form-select">
														<c:forEach items="${ listAcc }" var="acc">
															<form:option value="${ acc.id }">
																${ acc.id }
															</form:option>
														</c:forEach>
													</form:select>
												</div>
		
		<button>Create</button>
	</form:form>

  

  
  </div>
	<script src="/sof3021_assignment/js/jquery.min.js"></script>
	<script src="/sof3021_assignment/js/popper.min.js"></script>
	<script src="/sof3021_assignment/js/bootstrap.min.js"></script>
</body>
</html>