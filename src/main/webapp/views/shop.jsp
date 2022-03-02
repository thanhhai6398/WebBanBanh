<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!-- breadcrumbs area start -->

	
	<div class="container">
	<img style="width: 1920px; height: 300px;" src="assets/img/bg/shop.png"
		alt="">
		<h1>${shop.sName}</h1>
		<ul>
			<li>${shop.sAddrs}</li>
			<li>${shop.sPhone}</li>
		</ul>
	</div>
<!-- breadcrumbs area end -->
<!-- product page section start -->
<div class="product_page_section mb-100">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="product_page_wrapper">
					<!--shop toolbar area start-->
					<div
						class="product_sidebar_header mb-60 d-flex justify-content-between align-items-center">
						<div class="page__amount border">
							<p>
								<span>12</span> Product Found of <span>30</span>
							</p>
						</div>
						<div class="product_header_right d-flex align-items-center">
							<div class="sorting__by d-flex align-items-center">
								<span>Sort By : </span>
								<form class="select_option" action="#">
									<select name="orderby" id="short">
										<option selected value="1">Default</option>
										<option value="2">Sort by popularity</option>
										<option value="3">Sort by newness</option>
										<option value="4">low to high</option>
										<option value="5">high to low</option>
										<option value="6">Product Name: Z</option>
									</select>
								</form>
							</div>
							<div class="product__toolbar__btn">
								<ul class="nav" role="tablist">
									<li class="nav-item"><a class="active"
										data-bs-toggle="tab" href="#grid" role="tab"
										aria-controls="grid" aria-selected="true"><i
											class="ion-grid"></i></a></li>
									<li class="nav-item"><a data-bs-toggle="tab" href="#list"
										aria-controls="list" role="tab" aria-selected="false"><i
											class="ion-ios-list"></i></a></li>
								</ul>
							</div>
						</div>
					</div>
					<!--shop toolbar area end-->


					<!--shop gallery start-->
					<div class="product_page_gallery">
						<div class="tab-content" id="myTabContent">
							<div class="tab-pane fade show active" id="grid">
								<div class="row grid__product">
									<c:forEach items="${list}" var="p">
										<div class="col-xl-3 col-md-4 col-sm-6">
											<article class="single_product wow fadeInUp"
												data-wow-delay="0.3s" data-wow-duration="1.3s">
												<figure>
													<div class="product_thumb">
														<a
															href="productdetail?pid=${p.pID}&cid=${p.category.cID}&sid=${p.shop.sID}"><img
															style="width: 300px; height: 350px;" class="card-img-top"
															src="${p.pImage}" alt="${p.pName}"></a>
														<div class="action_links">
															<ul class="d-flex justify-content-center">
																<li class="add_to_cart"><a
																	href="<c:url value="/cart-add?pId=${p.pID}&quantity=1"></c:url>"
																	title="Add to cart"> <span class="pe-7s-shopbag"></span></a></li>
																<li class="quick_button"><a href="#"
																	title="Quick View" data-bs-toggle="modal"
																	data-bs-target="#modal_box"> <span
																		class="pe-7s-look"></span></a></li>
															</ul>
														</div>
													</div>
													<figcaption class="product_content text-center">
														<h4>
															<a
																href="productdetail?pid=${p.pID}&cid=${p.category.cID}&sid=${p.shop.sID}">${p.pName}</a>
														</h4>
														<div class="price_box">
															<span class="price">${p.pPrice}</span>
														</div>
													</figcaption>
												</figure>
											</article>
										</div>
									</c:forEach>
								</div>
							</div>

							<div class="pagination poduct_pagination">
								<ul>
									<li class="current"><span>1</span></li>
									<li><a href="#">2</a></li>
									<li><a href="#">3</a></li>
									<li class="next"><a href="#"><i
											class="ion-chevron-right"></i></a></li>
								</ul>
							</div>
							<!--shop gallery end-->
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- product page section end -->
	</div>
</div>
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