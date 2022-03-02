<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<!-- single product section start-->
<div class="single_product_section mb-100">
	<div class="container">
		<div class="row">
			<div class="col-lg-6 col-md-6">
				<div class="single_product_gallery">
					<div class="product_gallery_inner d-flex">
						<div class="product_gallery_main_img">
							<div class="gallery_img_list">
								<img style="width: 500px; height: 550px;"
									src="${pdetail.pImage}" alt="">
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="col-lg-6 col-md-6">
				<div class="product_details_sidebar">
					<h5 class="product__title">Category: ${cdetail.cName}</h5>
					<h2 class="product__title">${pdetail.pName}</h2>
					<div class="price_box">
						<span class="price">${pdetail.pPrice}</span>
					</div>
					<div>
						<label>Xuất xứ : ${pdetail.pOrigin}</label>
					</div>
					<label>Khối lượng : ${pdetail.pUnit}</label>
					<form method="get" action="<c:url value="/cart-add"></c:url>">
						<div class="form-group">
							<label>Kho : ${pdetail.pAmount}</label> <input type="text"
								value="${pdetail.pID }" name="pId" hidden="">
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<button type='button'
										onclick='javascript: document.getElementById("qty").value--;'
										value='-'
										class="quantity-left-minus btn btn-danger btn-number">
										-</button>
								</div>
								<input type="text" class="form-control" id="qty" name="quantity"
									value="1">
								<div class="input-group-append">
									<button type='button'
										onclick='javascript: document.getElementById("qty").value++;'
										value='+'
										class="quantity-right-plus btn btn-success btn-number">
										+</button>
								</div>
							</div>
						</div>
						<div>
							<button type="submit"
								class="btn btn-success btn-lg btn-block text-uppercase">
								<i class="pe-7s-shopbag"></i> Add to Cart
							</button>
						</div>
					</form>
					<div class="quickview__info mb-0">
						<p class="product_review d-flex align-items-center">
							<span class="review_icon d-flex"> <i class="ion-ios-star"></i>
								<i class="ion-ios-star"></i> <i class="ion-ios-star"></i> <i
								class="ion-ios-star"></i> <i class="ion-ios-star"></i>
							</span> <span class="review__text"> (2 reviews)</span>
						</p>
					</div>
					<p class="product_details_desc">Mô tả : ${pdetail.pDescs}</p>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="container">
	<div class="row">
		<!-- Shop -->
		<div class="col-lg-6 col-md-6">
			<h6 class="card-header bg-info text-white text-uppercase">
				<u>Shop</u>
			</h6>
			<h5>
				<a href="shop?sid=${pdetail.shop.sID}">${pdetail.shop.sName}</a>
			</h5>
			<p class="pe-7s-map-marker">${pdetail.shop.sAddrs}</p>
		</div>
		<!-- Reviews -->
		<div class="col-lg-6 col-md-6" id="reviews">
			<div class="card border-light mb-3">
				<div class="card-header bg-dark text-white text-uppercase">
					Reviews</div>
				<div class="card-body">
					<div class="review">
						<span class="glyphicon glyphicon-calendar" aria-hidden="true"></span>
						January 01, 2020 by MyMy
						<p class="blockquote">
							<span class="review_icon d-flex"> <i class="ion-ios-star"></i>
								<i class="ion-ios-star"></i> <i class="ion-ios-star"></i> 
								<i class="ion-ios-star"></i> <i class="ion-ios-star"></i>
							</span>
							<p class="mb-0">This cheesecake is really yummy. I’m going for
								another slice.</p>
						</p>
						<hr>
					</div>
					<div class="review">
						<span class="glyphicon glyphicon-calendar" aria-hidden="true"></span>
						April 10, 2021 by Paul Smith
						<p class="blockquote">
							<span class="review_icon d-flex"> <i class="ion-ios-star"></i>
								<i class="ion-ios-star"></i> <i class="ion-ios-star"></i> <i
								class="ion-ios-star"></i> <i class="ion-ios-star"></i>
							</span>
						<p class="mb-0">It’s really good!</p>
						</p>
						<hr>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- endShop -->

<!-- product details section end-->

<!-- Shop's products -->
<div class="container">
	<div class="section_title text-center mb-55">
		<h2>Sản phẩm khác của shop</h2>
		<p>
			Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do
			eiusmod <br> tempor incididunt ut labore et dolore magna
		</p>
	</div>
	<div class="row product_slick slick_navigation slick__activation"
		data-slick='{
                "slidesToShow": 4,
                "slidesToScroll": 1,
                "arrows": true,
                "dots": false,
                "autoplay": false,
                "speed": 300,
                "infinite": true ,  
                "responsive":[ 
                  {"breakpoint":992, "settings": { "slidesToShow": 3 } }, 
                  {"breakpoint":768, "settings": { "slidesToShow": 2 } }, 
                  {"breakpoint":500, "settings": { "slidesToShow": 1 } }  
                 ]                                                     
            }'>
		<c:forEach items="${listproShop}" var="o">
			<div class="col-lg-3">
				<article class="single_product">
					<figure>
						<div class="product_thumb">
							<a
								href="productdetail?pid=${o.pID}&cid=${o.category.cID}&sid=${o.shop.sID}"><img
								style="width: 250px; height: 300px;" src="${o.pImage}" alt=""></a>
							<div class="action_links">
								<ul class="d-flex justify-content-center">
									<li class="add_to_cart"><a
										href="<c:url value="/cart-add?pId=${o.pID}&quantity=1"></c:url>"
										title="Add to cart"> <span class="pe-7s-shopbag"></span></a></li>
									<li class="wishlist"><a href="wishlist.html"
										title="Add to Wishlist"><span class="pe-7s-like"></span></a></li>
									<li class="quick_button"><a href="#" title="Quick View"
										data-bs-toggle="modal" data-bs-target="#modal_box"> <span
											class="pe-7s-look"></span></a></li>
								</ul>
							</div>
						</div>
						<figcaption class="product_content text-center">
							<h4>
								<a
									href="productdetail?pid=${o.pID}&cid=${o.category.cID}&sid=${o.shop.sID}">${o.pName}</a>
							</h4>
							<div class="price_box">
								<span class="price">${o.pPrice}</span>
							</div>
						</figcaption>
					</figure>
				</article>
			</div>
		</c:forEach>
	</div>
</div>
<!-- end Shop's products -->


<!-- product section start -->
<div class="product_section mb-80">
	<div class="container">
		<div class="section_title text-center mb-55">
			<h2>Sản phẩm tương tự</h2>
			<p>
				Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do
				eiusmod <br> tempor incididunt ut labore et dolore magna
			</p>
		</div>
		<div class="row product_slick slick_navigation slick__activation"
			data-slick='{
                "slidesToShow": 4,
                "slidesToScroll": 1,
                "arrows": true,
                "dots": false,
                "autoplay": false,
                "speed": 300,
                "infinite": true ,  
                "responsive":[ 
                  {"breakpoint":992, "settings": { "slidesToShow": 3 } }, 
                  {"breakpoint":768, "settings": { "slidesToShow": 2 } }, 
                  {"breakpoint":500, "settings": { "slidesToShow": 1 } }  
                 ]                                                     
            }'>
			<c:forEach items="${listpro}" var="o">
				<div class="col-lg-3">
					<article class="single_product">
						<figure>
							<div class="product_thumb">
								<a
									href="productdetail?pid=${o.pID}&cid=${o.category.cID}&sid=${o.shop.sID}"><img
									style="width: 250px; height: 300px;" src="${o.pImage}" alt=""></a>
								<div class="action_links">
									<ul class="d-flex justify-content-center">
										<li class="add_to_cart"><a
											href="<c:url value="/cart-add?pId=${o.pID}&quantity=1"></c:url>"
											title="Add to cart"> <span class="pe-7s-shopbag"></span></a></li>
										<li class="wishlist"><a href="wishlist.html"
											title="Add to Wishlist"><span class="pe-7s-like"></span></a></li>
										<li class="quick_button"><a href="#" title="Quick View"
											data-bs-toggle="modal" data-bs-target="#modal_box"> <span
												class="pe-7s-look"></span></a></li>
									</ul>
								</div>
							</div>
							<figcaption class="product_content text-center">
								<h4>
									<a
										href="productdetail?pid=${o.pID}&cid=${o.category.cID}&sid=${o.shop.sID}">${o.pName}</a>
								</h4>
								<div class="price_box">
									<span class="price">${o.pPrice}</span>
								</div>
							</figcaption>
						</figure>
					</article>
				</div>
			</c:forEach>
		</div>
	</div>
</div>
<!-- product section end -->
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