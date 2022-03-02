<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
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
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css"
	integrity="sha512-YWzhKL2whUzgiheMoBFwW8CKV4qpHQAEuvilg9FAn5VJUDwKZZxkJNuGM4XkWuk94WCrrwslk8yWNGmY1EduTA=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Playfair+Display&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Playfair+Display&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="<c:url value="/templates/seller/css/reset.css"/>">
<link rel="stylesheet"
	href="<c:url value="/templates/seller/css/style.css"/>">
<link rel="stylesheet"
	href="<c:url value="/templates/seller/css/myshop.css"/>">
<title>Xem Shop</title>
</head>

<body>
	<!-- Header -->
	<%@include file="/common/seller/header.jsp"%>
	<!-- End Header -->
	<div class="container">
		<div id="myshop" class="pt-2 pb-5">
			<div class="shop-sidebar">
				<div class="shop-info">
					<img
						src="<c:url value="/templates/image/bf09ac1cde054555c4b31450e3741970.jpg"/>"
						alt="Bakery Shop" class="rounded-circle">
					<h5>${shop.sName}</h5>
				</div>
				<ul class="list-group category-list">
					<li class="title">DANH MỤC SHOP</li>
					<c:forEach items="${listCate}" var="cate">
						<li><a href="<c:url value="/view-shop?cateID=${cate.cID}"/>"
							class="nav-link">${cate.cName}</a></li>
					</c:forEach>
					<li><a href="<c:url value="/view-shop"/>"
						class="nav-link active">Tất cả</a></li>

				</ul>
			</div>
			<div class="product-page">
				<div class="row">
					<div class="col-md-12">
						<div class="sub-topnav">
							<c:url value="/view-shop" var="search"></c:url>
							<form action="${search}" method="GET">
								<div class="input-group mb-3">
									<input type="text" class="form-control"
										placeholder="Tìm kiếm trong Shop.." name="sTxt">
									<div class="input-group-append">
										<button class="btn btn-info" type="submit">
											<i class="fas fa-search"></i>
										</button>
									</div>
							</form>
						</div>
						<div class="d-flex align-items-stretch">
							<nav class="nav">
								<a class="active" href="#">Mới nhất</a> <a class="" href="#">Bán
									chạy</a> <a class="" href="#">Phổ biến</a>
							</nav>
							<ul class="nav ml-auto">
								<li class="text-paging"><span class="active">2</span>/<span>15</span></li>
								<li><a href="#" class="mr-0 border-right "><i
										class="fas fa-chevron-left nav-icon"></i></a></li>
								<li><a href="#" class="mr-0"><i
										class="fas fa-chevron-right nav-icon"></i></a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="product-paging">
						<div class="row">
							<c:forEach items="${listP}" var="p">
								<div class="col-md-3 col-lg-3 col-sm-6">
									<div class="product-item">
										<c:url value="/image?fname=${p.pImage}" var="imgUrl"></c:url>
										<img class="product-item-img" src="${imgUrl}"
											alt="${p.pImage}">
										<ul class="product-option">
											<li><a href="#" class="product-option-link"> <i
													class="fas fa-shopping-bag"></i>
											</a></li>
											<li><a href="#" class="product-option-link"> <i
													class="far fa-heart"></i>
											</a></li>
											<li><a href="#" class="product-option-link"> <i
													class="far fa-eye"></i>
											</a></li>
										</ul>
										<div class="product-item-text">
											<h5 class="text-center">${p.pName}</h5>
											<div class="text-price">
												<span class="price new">${p.pPrice}</span>
												<c:choose>
													<c:when test="${soldAmount.get(p.pID)!=null}">
														<span class="price">Đã bán:
															${soldAmount.get(p.pID)}</span>
													</c:when>
													<c:otherwise>
														<span class="price">Đã bán: 0</span>
													</c:otherwise>
												</c:choose>

											</div>
										</div>

									</div>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script>
		window.onload = function() {
			var priceItems = document.querySelectorAll(".price.new");
			var numVND = new Intl.NumberFormat('vi-VN', {
				style : "currency",
				currency : "VND"

			})
			for (var i = 0; i < priceItems.length; i++) {
				var priceRaw = priceItems[i].textContent;
				priceItems[i].style.color = "#c13030";
				priceItems[i].textContent = numVND.format(priceRaw);
			}
		}
	</script>
</body>
</html>