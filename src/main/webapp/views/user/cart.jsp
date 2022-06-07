<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Clothes Shop</title>
    <link rel="stylesheet" href="/sof3021_assignment/css/style1.css">
    <link rel="stylesheet" href="/sof3021_assignment/css/bootstrap.min.css">

    <style>
        #clo_vn_time{
    font-weight:bold;
    text-align:center;
    font-size:20px;
    padding:10px;
    color:#382ff8;
    box-shadow:inset 0 0 1px rgba(0,0,0,.08), 0 0 5px rgba(255, 165, 0, 0.5);
}
    </style>
</head>
<body>
     <header>
         <div class="container">
            <div class="row my-2">
                <div class="col">
                    <a href="index.html">
                        <img src="images/logo.png" alt="" class="img-fluid" title="Cửa hàng bán quần áo" width="150">
                    </a>
                </div>
                <div class="col-12 col-sm-auto my-auto">
                    <a title="Email" class="text-dark">
                        <i class="far fa-envelope"></i>
                        <span id="clo_vn_time"></span>
                    </a>
                </div>
            </div>
         </div>
     </header>
     <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
          <a class="navbar-brand" href="#">
              Technological Shop</a>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
              <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="#">Home</a>
              </li>
              <c:if test="${userLogin.admin==1}">
              <li class="nav-item">
                <a class="nav-link" href="sof3021_assignment/views/admin/index.jsp">Admin</a>
              </li>
              </c:if >
              <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                  Account
                </a>
                <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                  <li><a class="dropdown-item" href="#">Login</a></li>
                  <li><a class="dropdown-item" href="#">Signin</a></li>
                 
                </ul>
              </li>
           <li class="nav-item">
                <a class="nav-link " href="#">Xin chào : ${userLogin.email }</a>
              </li>
              
              <!-- <li class="nav-item">
                <a class="nav-link disabled">Disabled</a>
              </li> -->
            </ul>
            <form class="d-flex">
              <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
              <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
          </div>
        </div>
      </nav>
      <div class="row mt-4">
        <aside class="col-12 col-md-3 bg-primary p-3">
            <div class="card">
                <div class="card-header">Clothes Shop</div>
                <ul class="list-group">
                    <li class="list-group-item">
                        <a href="">Home</a>
                    </li>
                    <li class="list-group-item">
                        <a href="">Product</a>
                    </li>
                    <li class="list-group-item">
                        <a href="">Login</a>
                    </li>
                    <li class="list-group-item">
                        <a href="">Signin</a>
                    </li>
                </ul>
            </div>
        </aside>
        <article class="col-12 col-md-9 bg-info p-3">
            <div class="container">
                <div class="row">
                 <div class="container mt-5">
			<div class="row bg-light">
				<div class="table-responsive p-4" style="overflow-x: auto">
					<table class="table  table-borderless">
						<thead>
							<tr>
								<td>Sản phẩm</td>
								<td>Loại hàng</td>
								<td>Đơn giá</td>
								<td>Số lượng</td>
								<td>Thành tiền</td>
								<td>Thao tác</td>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${ listDetail }" var="detail">
							<tr>
								<td>${ detail.product.name }</td>
								<td>${ detail.product.categories.name }</td>
								<td>${ detail.price }</td>
								<td>${ detail.quantity }</td>
								<td>${ detail.price*detail.quantity }</td>
								<td>
									<a type="button" class="btn  btn-danger" href="">
										<i class="fa-solid fa-xmark"></i>
									</a>
								</td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
        
    </div>
      
</body>

<script>
    // Bộ đếm ngày giờ 
    window.setTimeout("sho_clo_time()", 1000);
function get_vn_time(){
    var time = new Date();
    var dow = time.getDay();
    if(dow==0)
        dow = "Sunday";
    else if (dow==1)
        dow = "Monday";
    else if (dow==2)
        dow = "Tuesday";
    else if (dow==3)
        dow = "Wednesday";
    else if (dow==4)
        dow = "Thursday";
    else if (dow==5)
        dow = "Friday";
    else if (dow==6)
        dow = "Saturday";  
    var day = time.getDate();
    var month = time.getMonth()+1;
    var year = time.getFullYear();
    var hr = time.getHours();
    var min = time.getMinutes();
    var sec = time.getSeconds();
    day = ((day < 10) ? "0" : "") + day;
    month = ((month < 10) ? "0" : "") + month;
    hr = ((hr < 10) ? "0" : "") + hr;
    min = ((min < 10) ? "0" : "") + min;
    sec = ((sec < 10) ? "0" : "") + sec;
    return dow + " " + day + "/" + month + "/" + year + " " + hr + ":" + min + ":" + sec;
}
function sho_clo_time(){
    var clo_vn_time = document.getElementById("clo_vn_time");
    if (clo_vn_time != null)
        clo_vn_time.innerHTML = get_vn_time();
    setTimeout("sho_clo_time()", 1000);
}

// navbar di chuyển theo khi scroll trang
    window.onscroll = function () {
        myFunction()
    };

    var navbar = document.getElementById("navbar");
    // var content = document.getElementById("content");
    var banner = document.getElementById("banner");
    var sticky = 350;

    function myFunction() {
        if (window.pageYOffset >= sticky) {
            navbar.classList.add("sticky");
            // content.classList.add("sticky2");
            banner.classList.add("sticky2");
        } else {
            navbar.classList.remove("sticky");
            // content.classList.remove("sticky2");
            banner.classList.remove("sticky2");
        }
    }
</script>
<script src="/sof3021_assignment/js/jquery.min.js"></script>
<script src="/sof3021_assignment/js/popper.min.js"></script>
<script src="/sof3021_assignment/js/bootstrap.min.js"></script>
</html>