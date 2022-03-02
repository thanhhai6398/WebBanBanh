<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<nav class="navbar navbar-expand-lg fixed-top" id="home-navbar">
	<a class="navbar-brand" href="<c:url value="/seller/home"/>">SELLER HOME</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="#">Trang
					chủ <span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item"><a class="nav-link" href="<c:url value="/view-shop"/>">My Shop</a></li>
		</ul>
		<ul class="nav navbar-nav ml-auto account-menu">
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> My Account </a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item" href="#">Tài khoản của tôi</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="<c:url value="/seller/logout"/>">Đăng xuất</a>
				</div></li>
		</ul>
	</div>
</nav>