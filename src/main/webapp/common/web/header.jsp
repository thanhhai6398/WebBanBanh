<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<header class="header_section">
	<div class="header_top">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<div class="header_top_inner d-flex justify-content-between">
						<div class="welcome_text">
							<p>Trả hàng và giao hàng hoàn toàn miễn phí</p>
						</div>
						<div class="header_top_sidebar d-flex align-items-center">
							<ul class="d-flex">
								<li><i class="icofont-phone"></i> <a href="tel:+0123456789">+84
										123 456 789</a></li>
								<li><i class="icofont-envelope"></i> <a
									href="mailto:demo@example.com">demo@example.com</a></li>
								<c:choose>
									<c:when test="${sessionScope.acc == null}">
										<li class="nav-item"><a class="nav-link"
											href="${pageContext.request.contextPath}/login">Login</a></li>
										<li class="nav-item"><a class="nav-link"
											href="${pageContext.request.contextPath}/register">Register</a></li>
									</c:when>
									<c:otherwise>
										<li class="nav-item"><a class="nav-link"
											href="${pageContext.request.contextPath}/myaccount?uid=${sessionScope.acc.uid}">${sessionScope.acc.uname}</a>
										</li>
										<li class="nav-item"><a class="nav-link"
											href="${pageContext.request.contextPath}/logout">Logout</a></li>
									</c:otherwise>
								</c:choose>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-12">
				<div
					class="main_header d-flex justify-content-between align-items-center">
					<div class="header_logo">
						<a class="sticky_none" href="${pageContext.request.contextPath}/home"><img
							style="width: 70px; height: 50px;" src="assets/img/logo/logo.png"
							alt=""></a>
					</div>
					<!--main menu start-->
					<div class="main_menu d-none d-lg-block">
						<nav>
							<ul class="d-flex">
								<li><a class="active" href="${pageContext.request.contextPath}/home">Home</a></li>

								<li><a href="product?cid=0">Products</a>
								<li><a href="#">Category</a>
									<ul class="bucker-dropdown">
										<c:forEach items="${listcate}" var="o">
											<li><a href="product?cid=${o.cID}">${o.cName}</a></li>
										</c:forEach>
									</ul></li>
								<li><a href="${pageContext.request.contextPath}/views/contact.jsp">Contact</a></li>
								<li><a href="${pageContext.request.contextPath}/seller/login">Seller Center</a></li>
							</ul>
						</nav>
					</div>
					<!--main menu end-->
					<div class="header_account">
						<form action="search" class="form-inline my-2 my-lg-0">
							<div class="input-group input-group">
								<input type="text" name="txt" value="${txtS}"
									class="form-control" placeholder="Search...">
								<div class="input-group-append">
									<button type="submit" class="btn btn-secondary btn-number">
										<i class="pe-7s-search"></i>
									</button>
								</div>
							</div>
						</form>
					</div>
					<a class="btn btn-success btn-sm ml-3"
						href="${pageContext.request.contextPath }/cart"> <c:set
							var="count" value="${0}" /> <c:forEach
							items="${sessionScope.cart}" var="map">
							<c:set var="count" value="${count + map.value.amount}" />
						</c:forEach> <i class="pe-7s-shopbag"></i> Cart <span
						class="badge badge-light">${count }</span></a>
				</div>
			</div>
		</div>
	</div>
</header>