<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<style>
td {
	text-decoration: capitalize;
}
</style>
<div id="all-product">
	<div class="container">
		<div id="top-subnav">
			<div class="row">
				<div class="col-md-12">
					<nav class="nav" id="subnav-link">
						<a class="nav-link"
							href="<c:url value="/seller/product/list?type=all"/>">Tất cả</a>
						<a class="nav-link"
							href="<c:url value="/seller/product/list?type=active"/>">Đang
							hoạt động</a> <a class="nav-link"
							href="<c:url value="/seller/product/list?type=noActive"/>">Đã
							ẩn</a> <a class="nav-link"
							href="<c:url value="/seller/product/list?type=none"/>">Hết
							hàng</a>
					</nav>
				</div>
			</div>
		</div>
		<div id="page-product">
			<div class="row">
				<div class="col-md-12">
					<div class="search-form mt-3 mb-3">
						<c:url value="/seller/product/search" var="search"></c:url>
						<form action="${search}" id="form-search-txt">
							<div class="input-group">
								<input type="text" class="form-control"
									placeholder="Nhập tên sản phẩm" name="sTxt" value="${sTXT}">
								<div class="input-group-append">
									<button class="btn form-btn" type="submit">Tìm kiếm</button>
								</div>
							</div>
						</form>
						<form action="${search}" id="form-search-dropdown">
							<div class="input-group">
								<select class="custom-select" id="inputGroupSelect" name="cate">
									<option selected disabled>Danh mục</option>
									<c:forEach items="${listCate}" var="c">
										<c:choose>
											<c:when test="${c.cID.equals(cateID)}">
												<option selected value="${c.cID}">${c.cName}</option>
											</c:when>
											<c:otherwise>
												<option value="${c.cID}">${c.cName}</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>

								</select>
								<div class="input-group-append">
									<button class="btn form-btn" type="submit">Tìm kiếm</button>
								</div>
							</div>

						</form>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="container">
						<div class="add-product mb-3">
							<a href="<c:url value="/seller/product/edit?action=add"/>"
								class="col-md-4 col btn add-product-btn"> <i
								class="fas fa-plus-circle"></i> Thêm sản phẩm
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<table class="table table-bordered">
					<thead>
						<tr class="text-center">
							<th scope="col">Tên sản phẩm</th>
							<th scope="col">Loại</th>
							<th scope="col">Giá bán</th>
							<th scope="col">Kho</th>
							<th scope="col">Đã bán</th>
							<th scope="col">Hành động</th>
						</tr>

					</thead>
					<tbody>
						<c:forEach items="${listAll}" var="p">
							<tr>
								<td class="col-4">
									<div class="table-product-item">
										<p>${p.pName}</p>
										<c:url value="/image?fname=${p.pImage}" var="imgUrl"></c:url>
										<img src="${imgUrl}" alt="${p.pName}">
									</div>
								</td>
								<td class="col-2">${p.category.cName}</td>
								<td class="col-2 price">${p.pPrice}</td>
								<td class="col-1">${p.pAmount}</td>
								<td class="col-1"><c:choose>
										<c:when test="${soldAmount.get(p.pID)!=null}">
											<span>${soldAmount.get(p.pID)}</span>
										</c:when>
										<c:otherwise>
											<span >0</span>
										</c:otherwise>
									</c:choose></td>
								<td class="col-2 text-center"><c:if test="${p.pActive==1}">
										<a
											href="<c:url value="/seller/product/active?pID=${p.pID}&state=0"/>"
											class="btn btn-outline-danger">Ẩn</a>
									</c:if> <c:if test="${p.pActive==0}">
										<a
											href="<c:url value="/seller/product/active?pID=${p.pID}&state=1"/>"
											class="btn btn-outline-success">Hiện</a>
									</c:if> <a
									href="<c:url value="/seller/product/edit?action=update&pID=${p.pID}"/>"
									class="btn btn-outline-warning">Sửa</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

		</div>
	</div>
</div>
<script>
	const currentLocation = location.href;
	const navItems = document.querySelectorAll(".nav .nav-link");
	for (let i = 0; i < navItems.length; i++) {
		if (navItems[i].href === currentLocation) {
			navItems[i].className = "nav-link active";
		}
	}
	window.onload = function(){
		var priceItems = document.getElementsByClassName("price");
		var numVND = new Intl.NumberFormat('vi-VN', {
			style: "currency",
			currency: "VND"

		})
		for (var i = 0; i < priceItems.length; i++) {
			var priceRaw = priceItems[i].textContent;
			priceItems[i].textContent= numVND.format(priceRaw);
		}
		
	}
</script>