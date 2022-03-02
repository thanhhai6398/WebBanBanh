<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<div class="container mb-4">

	<div class="row">
		<div class="col-12">
			<div class="table-responsive">
				<table class="table table-striped">
					<thead>
						<tr>
							<th scope="col">Ảnh</th>
							<th scope="col">Tên sản phẩm</th>
							<th scope="col">Giá</th>
							<th scope="col">Số lượng</th>
							<th scope="col">Thành tiền</th>
							<th scope="col">Cập nhật</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${sessionScope.cart}" var="map">
							<tr>
								<c:url value="${map.value.pId.pImage}" var="imgUrl"></c:url>
								<td><img class="img-responsive" width="60px" height="60px"
									src="${imgUrl}" /></td>
								<td class="col-3">${map.value.pId.pName }</td>
								<td class="col-3 price">${map.value.pId.pPrice }</td>
								<td class="col-2">${map.value.amount }</td>
								<td class="col-2 price">${map.value.pId.pPrice * map.value.amount }</td>
								<td class="col-2"><a
									href="${pageContext.request.contextPath}/cart-add?pId=${map.value.pId.pID}&quantity=1"
									class="btn btn-sm btn-success"><b>+</b></a>&nbsp;<a
									href="${pageContext.request.contextPath}/cart-minus?pId=${map.value.pId.pID}"
									class="btn btn-sm btn-primary"><b>-</b></a>&nbsp;<a
									href="${pageContext.request.contextPath}/cart-remove?pId=${map.value.pId.pID}"
									class="btn btn-sm btn-danger"><i class="pe-7s-close"></i> </a>
								</td>

							</tr>
						</c:forEach>
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td>Tổng tiền</td>
							<td class="text-right price"><c:set var="total" value="${0}" /> <c:forEach
									items="${sessionScope.cart}" var="map">
									<c:set var="total"
										value="${total + map.value.amount * map.value.pId.pPrice}" />
								</c:forEach>
								<div class="total-result-in">
									<span> ${total }</span>
								</div></td>
						</tr>
						<tr>
							<td>
								<div class="country-select clearfix">
									<label>Đơn vị vận chuyển: <span class="required">*</span></label>
									<select id="com" class="myniceselect nice-select wide">
										<c:forEach items="${listDeli}" var="o">
											<option value="${o.comID }">${o.comName }</option>
											<c:set var="comID" value="${o.comID }" />
											<c:set var="ship" value="${o.comPrice }" />
										</c:forEach>
									</select>

								</div>
							<td></td>
							<td></td>
							<td></td>
							<td>Phí ship</td>
							<td class="price"> ${ ship }</td>
						</tr>
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td><strong>Tổng thanh toán</strong></td>
							<td class="text-right"><strong>${total + ship }</strong></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<div class="col-md-12">
			<div class="checkout-form-list">
				<label>Address <span class="adrs">*</span></label> <input
					placeholder="Street address" type="text" name="adrs">
			</div>
		</div>
		<div class="col mb-2">
			<div class="row">
				<div class="col-sm-12  col-md-6">
					<a href="${pageContext.request.contextPath}/home"
						class="btn btn-block btn-light">Continue Shopping</a>
				</div>
				<div class="col-sm-12 col-md-6 text-right">
					<a href="${pageContext.request.contextPath}/order?comID=${comID}"
						class="btn btn-lg btn-block btn-success text-uppercase" type="submit">Checkout</a>
				</div>
			</div>
		</div>
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