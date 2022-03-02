<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!--slide banner section start-->
<div class="hero_banner_section d-flex align-items-center mb-110">
	<div class="container">
		<div class="hero_banner_inner">
			<div class="row align-items-center">
				<div class="col-lg-5">
					<div class="hero_content">
						<h3 class="wow fadeInUp" data-wow-delay="0.1s"
							data-wow-duration="1.1s">
							<span>70%</span> Sale Off
						</h3>
						<h1 class="wow fadeInUp" data-wow-delay="0.2s"
							data-wow-duration="1.2s">Quality Products Bakery Items</h1>
						<a class="btn btn-link wow fadeInUp" data-wow-delay="0.3s"
							data-wow-duration="1.3s" href="product?cid=0">Shop Now</a>
					</div>
				</div>
				<div class="col-lg-7">
					<div class="hero_shape_banner">
						<img class="banner_keyframes_animation wow"
							src="assets/img/bg/big.png" alt="">
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="hero_mini_shape shape1">
		<img src="assets/img/others/b6.png" alt="">
	</div>
	<div class="hero_mini_shape shape2">
		<img src="assets/img/others/b2.png" alt="">
	</div>
	<div class="hero_mini_shape shape3">
		<img src="assets/img/others/b3.png" alt="">
	</div>
	<div class="hero_mini_shape shape4">
		<img src="assets/img/others/b4.png" alt="">
	</div>
	<div class="hero_mini_shape shape5">
		<img src="assets/img/others/b5.png" alt="">
	</div>
</div>
<!--slider area end-->

<!-- product section start -->
<div class="product_section mb-80 wow fadeInUp" data-wow-delay="0.1s"
	data-wow-duration="1.1s">
	<div class="container">
		<div class="product_header">
			<div class="section_title text-center">
				<h2>New Products</h2>
				<p>
				A delicious and pretty cake will make your day more wonderful <br> Please choose one for yourself
			</p>
			</div>
		</div>
		<div class="tab-content product_container">
			<div class="tab-pane fade show active" role="tabpanel">
				<div class="product_gallery">
					<div class="row">
						<c:forEach items="${list8New}" var="p">
							<div class="col-lg-3 col-md-4 col-sm-6">
								<article class="single_product">
									<figure>
										<div class="product_thumb">
											<a href="productdetail?pid=${p.pID}&cid=${p.category.cID}&sid=${p.shop.sID}"><img style="width:300px;height:350px;"
												src="${p.pImage}" alt="${p.pName}"></a>
											<div class="action_links">
												<ul class="d-flex justify-content-center">
													<li class="add_to_cart"><a href="<c:url value="/cart-add?pId=${p.pID}&quantity=1"></c:url>"
														title="Add to cart"> <span class="pe-7s-shopbag"></span></a></li>
													<li class="quick_button"><a href="#"
														title="Quick View" data-bs-toggle="modal"
														data-bs-target="#modal_box"> <span class="pe-7s-look"></span></a></li>
												</ul>
											</div>
										</div>
										<figcaption class="product_content text-center">
											<h4>
												<a href="productdetail?pid=${p.pID}&cid=${p.category.cID}&sid=${p.shop.sID}">${p.pName}</a>
											</h4>
											<div class="price_box">
												<span class="col-5 price">${p.pPrice}</span>
											</div>
										</figcaption>
									</figure>
								</article>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- product section end -->



<!-- product section start -->
<div class="product_section mb-80 wow fadeInUp" data-wow-delay="0.1s"
	data-wow-duration="1.1s">
	<div class="container">
		<div class="section_title text-center mb-55">
			<h2>Best Seller</h2>
			<p>
				A delicious and pretty cake will make your day more wonderful <br> Please choose one for yourself
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
            <c:forEach items="${list8BestSeller}" var="o">
			<div class="col-lg-3">
				<article class="single_product">
					<figure>
						<div class="product_thumb">
							<a href="productdetail?pid=${o.pID}&cid=${o.category.cID}&sid=${o.shop.sID}"><img style="width:300px;height:350px;"
								src="${o.pImage}" alt=""></a>
							<div class="action_links">
								<ul class="d-flex justify-content-center">
									<li class="add_to_cart"><a href="<c:url value="/cart-add?pId=${o.pID}&quantity=1"></c:url>"
										title="Add to cart"> <span class="pe-7s-shopbag"></span></a></li>
									<li class="quick_button"><a href="#" title="Quick View"
										data-bs-toggle="modal" data-bs-target="#modal_box"> <span
											class="pe-7s-look"></span></a></li>
								</ul>
							</div>
						</div>
						<figcaption class="product_content text-center">
							<h4>
								<a href="productdetail?pid=${o.pID}&cid=${o.category.cID}&sid=${o.shop.sID}">${o.pName}</a>
							</h4>
							<div class="price_box">
								<span class="col-5 price"> ${o.pPrice}</span>
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

<!-- modal area start-->
<div class="modal fade" id="modal_box" tabindex="-1" role="dialog"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<button type="button" class="close" data-bs-dismiss="modal"
				aria-label="Close">
				<span aria-hidden="true"><i class="ion-android-close"></i></span>
			</button>
			<div class="modal_body">
				<div class="container">
					<div class="row">
						<div class="col-lg-5 col-md-5 col-sm-12">
							<div class="modal_tab">
								<div class="tab-content product-details-large">
									<div class="tab-pane fade show active" id="tab1"
										role="tabpanel">
										<div class="modal_tab_img">
											<a href="single-product.html"><img
												src="assets/img/product/product1.png" alt=""></a>
										</div>
									</div>
									<div class="tab-pane fade" id="tab2" role="tabpanel">
										<div class="modal_tab_img">
											<a href="single-product.html"><img
												src="assets/img/product/product2.png" alt=""></a>
										</div>
									</div>
									<div class="tab-pane fade" id="tab3" role="tabpanel">
										<div class="modal_tab_img">
											<a href="#"><img src="assets/img/product/product3.png"
												alt=""></a>
										</div>
									</div>
									<div class="tab-pane fade" id="tab4" role="tabpanel">
										<div class="modal_tab_img">
											<a href="#"><img src="assets/img/product/product4.png"
												alt=""></a>
										</div>
									</div>
								</div>
								<div class="modal_tab_button">
									<ul class="nav product_navactive owl-carousel" role="tablist">
										<li><a class="nav-link active" data-toggle="tab"
											href="#tab1" role="tab" aria-controls="tab1"
											aria-selected="false"><img
												src="assets/img/product/mini-product/product1.png" alt=""></a>
										</li>
										<li><a class="nav-link" data-toggle="tab" href="#tab2"
											role="tab" aria-controls="tab2" aria-selected="false"><img
												src="assets/img/product/mini-product/product2.png" alt=""></a>
										</li>
										<li><a class="nav-link button_three" data-toggle="tab"
											href="#tab3" role="tab" aria-controls="tab3"
											aria-selected="false"><img
												src="assets/img/product/mini-product/product3.png" alt=""></a>
										</li>
										<li><a class="nav-link" data-toggle="tab" href="#tab4"
											role="tab" aria-controls="tab4" aria-selected="false"><img
												src="assets/img/product/mini-product/product4.png" alt=""></a>
										</li>

									</ul>
								</div>
							</div>
						</div>
						<div class="col-lg-7 col-md-7 col-sm-12">
							<div class="modal_right">
								<div class="modal_title mb-10">
									<h2>Donec Ac Tempus</h2>
								</div>
								<div class="modal_price mb-10">
									<span class="new_price">$64.99</span> <span class="old_price">$78.99</span>
								</div>
								<div class="modal_description mb-15">
									<p>Lorem ipsum dolor sit amet, consectetur adipisicing
										elit. Mollitia iste laborum ad impedit pariatur esse optio
										tempora sint ullam autem deleniti nam in quos qui nemo ipsum
										numquam, reiciendis maiores quidem aperiam, rerum vel
										recusandae</p>
								</div>
								<div class="variants_selects">
									<div class="variants_size">
										<h2>size</h2>
										<select class="select_option">
											<option selected value="1">s</option>
											<option value="1">m</option>
											<option value="1">l</option>
											<option value="1">xl</option>
											<option value="1">xxl</option>
										</select>
									</div>
									<div class="variants_color">
										<h2>color</h2>
										<select class="select_option">
											<option selected value="1">purple</option>
											<option value="1">violet</option>
											<option value="1">black</option>
											<option value="1">pink</option>
											<option value="1">orange</option>
										</select>
									</div>
									<div class="modal_add_to_cart">
										<form action="#">
											<input min="1" max="100" step="1" value="1" type="number">
											<button type="submit">add to cart</button>
										</form>
									</div>
								</div>
								<div class="modal_social">
									<h2>Share this product</h2>
									<ul>
										<li class="facebook"><a href="#"><i
												class="ion-social-facebook"></i></a></li>
										<li class="twitter"><a href="#"><i
												class="ion-social-twitter"></i></a></li>
										<li class="pinterest"><a href="#"><i
												class="ion-social-pinterest"></i></a></li>
										<li class="google-plus"><a href="#"><i
												class="ion-social-googleplus"></i></a></li>
										<li class="linkedin"><a href="#"><i
												class="ion-social-linkedin"></i></a></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- modal area end-->
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
