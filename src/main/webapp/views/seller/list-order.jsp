<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<div id="seller-bill">
	<div class="container">
		<div class="row">
			<div class="col-md-12" id="top-subnav">
				<nav class="nav">
					<a class="nav-link"
						href="<c:url value="/seller/receipt/list?type=all"/>">Tất cả</a> <a
						class="nav-link"
						href="<c:url value="/seller/receipt/list?type=waitting"/>">Chờ
						xác nhận</a> <a class="nav-link"
						href="<c:url value="/seller/receipt/list?type=delivering"/>">Đang
						giao</a> <a class="nav-link"
						href="<c:url value="/seller/receipt/list?type=delivered"/>">Đã
						giao</a> <a class="nav-link"
						href="<c:url value="/seller/receipt/list?type=cancelled"/>">Đã
						hủy</a>
				</nav>
			</div>
		</div>
		<div id="page-product">
			<div class="row">
				<div class="col-md-12">
					<div class="search-form mt-3 mb-4">
					<c:url value="/seller/receipt/search" var="search"></c:url>
						<form action="${search}" id="form-search-txt" method="GET">
							<div class="input-group">
								<input type="text" class="form-control"
									placeholder="Nhập mã đơn hàng" name="rID" required>
								<div class="input-group-append">
									<input type="submit" class="btn form-btn" value="Tìm kiếm" />
								</div>
							</div>
						</form>
						<form action="${search}" id="form-search-date" method="GET">
							<div class="input-group">
							<div class="d-flex">
							<input type="date" name="dateStart" style="border-right:0;border-top-right-radius:0;border-bottom-right-radius:0;"
									class="form-control form-search-date--input" required value="${dateStart}">
							<input type="date" name="dateEnd" style="border-left:0;border-top-left-radius:0;border-bottom-left-radius:0;"
									class="form-control form-search-date--input" value="${dateEnd}">
							</div>
								<div class="input-group-append">
									<input type="submit" class="btn form-btn" value="Lọc" />
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
			<c:if test="${msg!=null}">
			<p id="notify" hidden="">${msg}</p>
			</c:if>
				<table class="table table-bordered">
					<thead>
						<tr class="text-center">
							<th scope="col">Sản phẩm</th>
							<th scope="col">Tổng đơn hàng</th>
							<th scope="col">Vận chuyển</th>
							<th scope="col">Trạng thái</th>
							<th scope="col">Thao tác</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${orderList}" var="o">
							<div class="order-item">
								<tr class="order-item-info">
									<td colspan="3"><span>Người đặt hàng: </span>${o.key.receipt.uId.uname}</td>
									<td colspan="2" ><span>Mã đơn hàng: </span><p style="margin-bottom:0;display: inline-block;">${o.key.receipt.rId}</p>
									</td>
								</tr>
								<tr class="order-item-detail">
									<td class="col-4"><c:forEach items="${o.value}" var="d">
											<div class="order-product">
												<c:url value="/image?fname=${d.pId.pImage}" var="imgUrl"></c:url>
												<img src="${imgUrl}" alt="">
												<div class="order-product-info">
													<div class="order-product-amount">
														<h5>${d.pId.pName}</h5>
														<p>
															<span>x</span>${d.amount}
														</p>
													</div>
													<p>${d.pId.category.cName}</p>
												</div>
											</div>
										</c:forEach></td>
									<td class="col-2 text-center order-value">${o.key.repPrice}</td>
									<td class="col-2 text-center">${o.key.company.comName}</td>
									<td class="col-2 text-center">${o.key.receipt.stId.stName}</td>
									<td class="col-2 text-center"><c:choose>
											<c:when test="${o.key.receipt.stId.stId==1}">
												<button type="button"
													class="btn btn-outline-danger btn-check"
													data-toggle="modal" data-target="#checkOrder">Xác
													nhận</button>
											</c:when>
											<c:otherwise>
												<button type="button"
													class="btn btn-outline-success btn-check"
													data-toggle="modal" data-target="#checkOrder">Thông
													tin vận chuyển</button>
											</c:otherwise>
										</c:choose></td>
								</tr>
							</div>
						</c:forEach>
					</tbody>
				</table>
			</div>

		</div>
	</div>
</div>
<!-- Modal -->
<div class="modal fade" id="checkOrder" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">

	</div>
</div>

<!-- Modal -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$("document").ready(function() {
		$(".btn-check").click(function() {
			var OrderItem = $(this).parents("div tr").prev();
			var rID = OrderItem[0].querySelector("td p").textContent;
			$.ajax({
				type : "GET",
				url : "/Bakery/ajax/receipt",
				data : {
					receiptID : rID
				},
				success : function(data) {
					$("#checkOrder .modal-dialog").html(data);
				},
				error : function(xhr) {
				}
			});
		});
	});
</script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script>
	const currentLocation = location.href;
	const navItems = document.querySelectorAll(".nav .nav-link");
	for (let i = 0; i < navItems.length; i++) {
		if (navItems[i].href === currentLocation) {
			navItems[i].className = "nav-link active";
		}
	}
	//Format Price
	window.onload = function(){
		var priceItems = document.getElementsByClassName("order-value");
		var numVND = new Intl.NumberFormat('vi-VN', {
			style: "currency",
			currency: "VND"

		})
		for (var i = 0; i < priceItems.length; i++) {
			var priceRaw = priceItems[i].textContent;
			priceItems[i].textContent= numVND.format(priceRaw);
		}
		
	}
	//Notify Check Order
	var notify = document.getElementById("notify").textContent;
	if(notify!=null){
		swal({
			  title: "Thông báo!",
			  text: notify,
			  icon: "error",
			  button: "Tiếp tục",
			});
	}
	
	
</script>