<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css"
	integrity="sha512-YWzhKL2whUzgiheMoBFwW8CKV4qpHQAEuvilg9FAn5VJUDwKZZxkJNuGM4XkWuk94WCrrwslk8yWNGmY1EduTA=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Playfair+Display&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="<c:url value="/templates/seller/css/reset.css"/>">
<link rel="stylesheet"
	href="<c:url value="/templates/seller/css/login-register.css"/>">
<title>Đăng nhập vào trang bán hàng</title>
</head>
<body>
	<div class="container-fluid">
		<div class="page-content">
			<div class="row">
				<div class="col-md-6">
					<div class="text">
						<h3>Bakery Seller</h3>
						<p>
							Quản lý shop của bạn một cách hiệu quả hơn trên Bakery <span>Kênh
								Người bán.</span><br>
								<span>Mỗi tài khoản chỉ được tạo được duy nhất một Shop</span>
						</p>
					</div>
					<div class="img">
						<img
							src="<c:url value="/templates/image/bf09ac1cde054555c4b31450e3741970.jpg"/>"
							alt="Bakery Shop">
					</div>
				</div>
				<div class="offset-1 col-md-5" id="form-content">
					<!--Dang nhap-->
					<div class="wrapper" id="login">
						<h5 class="text-center">Đăng nhập vào kênh Người Bán</h5>
						<c:if test="${msg!=null}">
							<h6 class="alert alert-danger">${msg}</h6>
						</c:if>
						<c:url value="/seller/login" var="login" />
						<form action="${login}" method="POST">
							<div class="form-group row">
								<div class="col-sm-12">
									<input type="text" class="form-control" id="inputUsername"
										placeholder="Tên tài khoản" name="username">
								</div>
							</div>
							<div class="form-group row">
								<div class="col-sm-12">
									<input type="password" class="form-control" id="inputPassword"
										placeholder="Mật khẩu" name="passwd">
								</div>
							</div>
							<div class="form-group row">
								<div class="col-sm-12">
									<input type="submit" class="btn " value="Đăng nhập">
								</div>
							</div>
						</form>
						<div class="sub-info">
							<p>
								Chưa có tài khoản bán hàng?<a class="nav-link" href="#"
									onclick="createShop(2)"> Tạo Shop</a>
							</p>
						</div>
					</div>
					<!--End Dang nhap-->
					<!--Dang ky-->
					<div class="wrapper" id="register">
						<h5 class="text-center pb-2">Đăng ký bán hàng</h5>
						<c:if test="${msg!=null}">
							<h6 class="alert alert-danger">${msg}</h6>
						</c:if>
						<c:url value="/seller/register" var="register" />
						<form action="${register}" method="POST">
							<div class="form-group row">
								<div class="col-sm-12">
									<input type="text" class="form-control" id="inputUsername"
										placeholder="Tài khoản đăng nhập" name="username">
								</div>
							</div>
							<div class="form-group row">
								<div class="col-sm-12">
									<input type="password" class="form-control" id="inputPassword"
										placeholder="Mật khẩu" name="passwd">
								</div>
							</div>
							<div class="form-group row">
								<div class="col-sm-12">
									<input type="text" class="form-control" id="shopName"
										placeholder="Nhập tên Shop" name="shopName">
								</div>
							</div>
							<div class="form-group row">
								<div class="col-sm-12">
									<input type="text" class="form-control" id="shopAddrs"
										placeholder="Địa chỉ Shop" name="shopAddrs">
								</div>
							</div>
							<div class="form-group row">
								<div class="col-sm-12">
									<input type="text" class="form-control" id="shopPhone"
										placeholder="Số điện thoại" name="shopPhone">
								</div>
							</div>
							<div class="form-group row">
								<div class="col-sm-12">
									<input type="submit" class="btn " value="Tạo Shop">
								</div>
							</div>
						</form>
						<div class="sub-info">
							<p>
								Về trang<a class="nav-link" href="#" onclick="createShop(1)">
									Đăng nhập</a>
							</p>
						</div>
					</div>

					<!--End Dang ky-->
				</div>
			</div>
		</div>
	</div>
</body>
<script>
	function createShop(type) {
		var login = document.getElementById("login");
		var register = document.getElementById("register");
		if (type === 1) {
			register.style.display = "none";
			login.style.display = "block";
		} else {
			login.style.display = "none";
			register.style.display = "block";
		}
	}
</script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
</html>