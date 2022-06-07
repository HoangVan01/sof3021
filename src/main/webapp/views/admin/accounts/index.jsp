<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
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
   
img{
        width: 60px;
        height: 60px;
      }
   
</style>
</head>
<body>
<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark static-top">
    <div class="container">
      <a class="navbar-brand" href="#">
        <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcREiFPeE19eRTlKa8_jaezFqOXYYZB0BF866pfFgogm74U7WPridjLP6tZMYkyOcxhmAKU&usqp=CAU" alt="..." height="36">
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
  

  
<table class="table">
		<thead>
			<th>Id</th>
			<th>Fullname</th>
			<th>Username</th>
			<th>Email</th>
			<th>Photo</th>
			<th>Activated</th>
			<th>Role</th>
			<th colspan="2">Action</th>
		</thead>
		<tbody>
			<c:forEach items="${ data.content }" var="acc">
			<tr>
				<td>${ acc.id }</td>
				<td>${ acc.fullname }</td>
				<td>${ acc.username }</td>
				<td>${ acc.email }</td>
				<td>
					<img src="${ acc.photo }" />
				</td>
				<td>${ acc.activated == 0 ? "Not active" : "Active" }</td>
				<td>${ acc.admin == 0 ? "User" : "Admin" }</td>
				<td>
					<button class="btn btn-primary" data-bs-toggle="modal"
												data-bs-target="#modalUpdate_${acc.id }">
												<i class="fa-solid fa-pen-to-square"></i> Update
											</button> <!-- Modal update -->
											<div class="modal fade" id="modalUpdate_${acc.id}"
												data-bs-backdrop="static" data-bs-keyboard="false"
												tabindex="-1" aria-labelledby="staticBackdropLabel"
												aria-hidden="true">
												<div class="modal-dialog">
													<div class="modal-content">
														<div class="modal-header bg-info">
															<h5 class="modal-title text-white"
																id="staticBackdropLabel">Update a account</h5>
															<button type="button" class="btn" data-bs-dismiss="modal"
																aria-label="Close">
																<i class="fa-solid fa-xmark fs-5 text-white"></i>
															</button>
														</div>
														<div class="modal-body">
															<form method="GET"
																action="/sof3021_assignment/admin/accounts/update/${ acc.id }"
																>
																<div>
																	<label>Full name</label>
																	<input name="fullname" class="form-control" value = "${acc.fullname }"/>
																</div>
																<div>
																	<label>Email</label>
																	<input name="email" type="email"
																		class="form-control" value = "${acc.email }" />
																</div>
																<div>
																	<label>User name</label>
																	<input name="username" class="form-control"
																		value = "${acc.username}" />
																</div>
																<div>
																	<label>Photo</label>
																	<input name="photo" class="form-control"
																		value = "${acc.photo }" />
																</div>
																<button class="btn btn-primary w-100 mt-3"
																	id="liveToastBtn">Update</button>
																<div class="position-fixed top-0 end-0 p-5"
																	style="z-index: 11">
																	<div style="background-color: #2ecc71" id="liveToast"
																		class="toast align-items-center text-white border-0"
																		role="alert" aria-live="assertive" aria-atomic="true">
																		<div class="d-flex">
																			<div class="toast-body">Successful !</div>
																			<button type="button"
																				class="btn-close btn-close-white me-2 m-auto"
																				data-bs-dismiss="toast" aria-label="Close"></button>
																		</div>
																	</div>
																</div>
															</form>
														</div>
													</div>
												</div>
											</div>
		
		

      </div>
    </div>
  </div>
</div>
				</td>
				<td>
					<a href="/sof3021_assignment/admin/accounts/delete/${ acc.id }">
						Delete
					</a>
					</a>
						<a href="/sof3021_assignment/admin/accounts/create">
						Create
					</a>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<div>
		<ul class="pagination">
			<li class="page-item">
				<a class="page-link" href="/sof3021_assignment/admin/accounts/index">
					First page
				</a>
			</li>
			<li class="page-item">
				<a class="page-link" href="/sof3021_assignment/admin/accounts/index?page=${ data.number - 1 }">
					Previos page
				</a>
			</li>
			<li class="page-item">
				<a class="page-link" href="/sof3021_assignment/admin/accounts/index?page=${ data.number + 1 }">
					Next page
				</a>
			</li>
			<li class="page-item">
				<a class="page-link" href="/sof3021_assignment/admin/accounts/index?page=${ data.totalPages - 1 }">
					Last page
				</a>
			</li>
		</ul>
	</div>
  
  </div>
	<script src="/sof3021_assignment/js/jquery.min.js"></script>
	<script src="/sof3021_assignment/js/popper.min.js"></script>
	<script src="/sof3021_assignment/js/bootstrap.min.js"></script>
</body>
</html>