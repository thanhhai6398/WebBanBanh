<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>


<!-- content -->
<div class="container">
	<div class="row">
		<div class="col">
			<nav aria-label="breadcrumb">
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="index.html">Home</a></li>
					<li class="breadcrumb-item"><a href="category.html">Category</a></li>
					<li class="breadcrumb-item active" aria-current="page">Sub-category</li>
				</ol>
			</nav>
		</div>
	</div>
</div>
<div class="container">
	<div class="row">
		<div class="col-12 col-sm-3">
			<div class="card bg-light mb-3">
				<div class="card-header bg-warning text-white text-uppercase">
					<i class="fa fa-list"></i> Categories
				</div>
				<ul class="list-group category_block">
					<c:forEach items="${listcate}" var="o">
						<li class="list-group-item ${tagactive==o.cID ?"active ":""}"><a
							href="product?cid=${o.cID}">${o.cName}</a></li>

					</c:forEach>
				</ul>
			</div>
		</div>


		<div class="col">
			<div class="row">
				<%-- Không chia SP theo danh mục --%>
				<c:forEach items="${listAllproduct}" var="p">
					<div class="col-12 col-md-6 col-lg-4">
						<div class="card">
							<img style="width: 300px; height: 350px;" class="card-img-top"
								src="${p.pImage}" alt="${p.pName}">
							<div class="card-body">
								<h4 class="card-title">
									<a href="productdetail?pid=${p.pID}&cid=${p.category.cID}&sid=${p.shop.sID}"
										title="View Product">${p.pName}</a>
								</h4>
								<p class="card-text">${p.pDescs}</p>
								<div class="row">
									<div class="col">
										<p class="btn btn-danger btn-block price">${p.pPrice}</p>
									</div>
									<div class="col">
										<a href="<c:url value="/cart-add?pId=${p.pID}&quantity=1"></c:url>" class="btn btn-success btn-block">Add to cart</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>

				<div class="col-12">
					<nav aria-label="...">
						<ul class="pagination">
							<c:if test="${tag>1}">
								<li class="page-item"><a class="page-link"
									href="product?cid=${tagactive}&index=${tag-1}">Previous</a></li>
							</c:if>
							<c:forEach begin="1" end="${endP}" var="i">
								<li class="page-item ${tag==i ? "active" : "" }"><a
									class="page-link" href="product?cid=${tagactive}&index=${i}">${i}</a></li>
							</c:forEach>
							<c:if test="${tag<endP}">
								<li class="page-item"><a class="page-link"
									href="product?cid=${tagactive}&index=${tag+1}">Next</a></li>
							</c:if>
						</ul>
					</nav>
				</div>
			</div>

		</div>
	</div>
</div>

<!-- end content -->
<script>
	
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