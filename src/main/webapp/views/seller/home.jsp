<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<div id="home-seller" class="pb-5 pt-3">
	<div class="container">
		<section id="seller-notify">
			<h2 class="text-lg-left mb-3 mt-4 section-title">
				<i class="far fa-bell"></i> Notify
			</h2>
			<div class="row">
				<table class="table table-borderless ml-4">
					<tbody>
						<tr id="bill">
							<td class="text-center col-3">
								<div class="notify-item text-center">
									<h4 class="text-primary">${countWaitting}</h4>
									<p>Chờ xác nhận</p>
								</div>
							</td>
							<td class="text-center col-3">
								<div class="notify-item text-center">
									<h4 class="text-primary">${countDelivering}</h4>
									<p>Đang giao</p>
								</div>
							</td>
							<td class="text-center col-3">
								<div class="notify-item text-center">
									<h4 class="text-primary">${countDelivered}</h4>
									<p>Đã giao</p>
								</div>
							</td>
							<td class="text-center col-3">
								<div class="notify-item text-center">
									<h4 class="text-primary">${countCancelled}</h4>
									<p>Đã hủy</p>
								</div>
							</td>
						</tr>
						<tr id="product">
							<td class="text-center col-3">
								<div class="notify-item text-center">
									<h4 class="text-danger">${countAll}</h4>
									<p>Tất cả</p>
								</div>
							</td>
							<td class="text-center col-3">
								<div class="notify-item text-center">
									<h4 class="text-danger">${countActive}</h4>
									<p>Đang hoạt động</p>
								</div>
							</td>

							<td class="text-center col-3">
								<div class="notify-item text-center">
									<h4 class="text-danger">${countNoActive}</h4>
									<p>Đã ẩn</p>
								</div>
							</td>
							<td class="text-center col-3">
								<div class="notify-item text-center">
									<h4 class="text-danger">${countNone}</h4>
									<p>Hết hàng</p>
								</div>
							</td>
						</tr>

					</tbody>
				</table>
			</div>
		</section>
		<section id="new-products">
			<h2 class="text-lg-center mb-4 mt-5 section-title">New Products</h2>
			<div class="row">
				<c:forEach items="${list4New}" var="n">
					<div class="col-md-3 col-lg-3 col-sm-6">
						<div class="product-item">
							<c:url value="/image?fname=${n.pImage}" var="imgUrl"></c:url>
							<img class="product-item-img" src="${imgUrl}" alt="${n.pImage}">
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
								<h5 class="text-center">${n.pName}</h5>
								<div class="text-price">
									<span class="price new">${n.pPrice}</span>
									<c:choose>
										<c:when test="${soldAmount.get(n.pID)!=null}">
											<span class="price">Đã bán: ${soldAmount.get(n.pID)}</span>
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
		</section>
		<section id="best-seller">
			<h2 class="text-lg-center mb-4 mt-5 section-title">Best Seller</h2>
			<div class="row">
				<c:forEach items="${list4Best}" var="b">
					<div class="col-md-3 col-lg-3 col-sm-6">
						<div class="product-item">
						<c:url value="/image?fname=${b.pImage}" var="imgUrl"></c:url>
						<img class="product-item-img" src="${imgUrl}" alt="${b.pImage}">
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
								<h5 class="text-center">${b.pName}</h5>
								<div class="text-price">
									<span class="price new">${b.pPrice}</span>
									<c:choose>
										<c:when test="${soldAmount.get(b.pID)!=null}">
											<span class="price">Đã bán: ${soldAmount.get(b.pID)}</span>
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
		</section>
	</div>
</div>
<script>
window.onload = function(){
	var  priceItems = document.querySelectorAll(".price.new");
	var numVND = new Intl.NumberFormat('vi-VN', {
		style: "currency",
		currency: "VND"

	})
	for(var i=0;i<priceItems.length;i++){
		var priceRaw = priceItems[i].textContent;
		priceItems[i].style.color="#c13030";
		priceItems[i].textContent= numVND.format(priceRaw);
	}
}
</script>