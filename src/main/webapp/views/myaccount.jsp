<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<div class="container">
	<h4 class="small-title text-center" style="color:Tomato;">MY ORDERS</h4>
	<h4 class="small-title" style="color:Tomato;">Chờ xác nhận</h4>
	<div class="row">
		<div class="col-12">
			<div class="table-responsive">
				<table class="table table-bordered table-hover">
					<thead>
						<tr>
							<th class="text-center">Shop</th>
							<th class="text-center">Tổng đơn hàng</th>
							<th class="text-center">Đơn vị vận chuyển</th>
							<th class="text-center">Trạng thái</th>
							<th class="text-center">Chi tiết đơn</th>
							<th class="text-center">Thao tác</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listDeli}" var="d">
							<c:forEach items="${listReceipt1}" var="p">
								<c:if test="${d.receipt.rId == p.rId }">
									<tr>
										<td class="col-1 text-center">${p.sId.sName}</td>
										<td class="col-2 price">${d.repPrice}</td>
										<td class="col-2 text-center">${d.company.comName}</td>
										<td class="col-2 text-center">${p.stId.stName}</td>
										<td><c:forEach items="${listDetail}" var="i">
												<c:if test="${p.rId == i.rId.rId }">
													<a><span style="font-size: 10px">${i.amount}x</span></a>
													<img class="img-responsive" width="60px" height="60px"
														src="${i.pId.pImage}" />
													<a>${i.pId.pName}</a>

													<br>
												</c:if>
											</c:forEach></td>
										<td><a
											href="${pageContext.request.contextPath}/editState?id=${ p.rId}&stId=4"
											class="btn btn-sm btn-danger">Hủy</a></td>
									</tr>
								</c:if>
							</c:forEach>
						</c:forEach>

					</tbody>
				</table>
			</div>
		</div>
	</div>

	<h4 class="small-title" style="color:Tomato;">Đang giao</h4>
	<div class="row">
		<div class="col-12">
			<div class="table-responsive">
				<table class="table table-bordered table-hover">
					<thead>
						<tr>
							<th class="text-center">Shop</th>
							<th class="text-center">Tổng đơn hàng</th>
							<th class="text-center">Đơn vị vận chuyển</th>
							<th class="text-center">Trạng thái</th>
							<th class="text-center">Chi tiết đơn</th>
							<th class="text-center">Thao tác</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listDeli}" var="d">
							<c:forEach items="${listReceipt2}" var="p">
								<c:if test="${d.receipt.rId == p.rId }">
									<tr>
										<td class="col-1 text-center">${p.sId.sName}</td>
										<td class="col-2 price">${d.repPrice}</td>
										<td class="col-2 text-center">${d.company.comName}</td>
										<td class="col-2 text-center">${p.stId.stName}</td>
										<td><c:forEach items="${listDetail}" var="i">
												<c:if test="${p.rId == i.rId.rId }">
													<a><span style="font-size: 10px">${i.amount}x</span></a>
													<img class="img-responsive" width="60px" height="60px"
														src="${i.pId.pImage}" />
													<a>${i.pId.pName}</a>

													<br>
												</c:if>
											</c:forEach></td>
										<td><a
											href="${pageContext.request.contextPath}/editState?id=${ p.rId}&stId=4"
											class="btn btn-sm btn-danger">Hủy</a>
											<a
											href="${pageContext.request.contextPath}/editState?id=${ p.rId}&stId=3"
											class="btn btn-sm btn-success">Đã nhận hàng</a></td>
											
									</tr>
								</c:if>
							</c:forEach>
						</c:forEach>

					</tbody>
				</table>
			</div>
		</div>
	</div>

	<h4 class="small-title" style="color:Tomato;">Đã giao</h4>
	<div class="row">
		<div class="col-12">
			<div class="table-responsive">
				<table class="table table-bordered table-hover">
					<thead>
						<tr>
							<th class="text-center">Shop</th>
							<th class="text-center">Tổng đơn hàng</th>
							<th class="text-center">Đơn vị vận chuyển</th>
							<th class="text-center">Trạng thái</th>
							<th class="text-center">Chi tiết đơn</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listDeli}" var="d">
							<c:forEach items="${listReceipt3}" var="p">
								<c:if test="${d.receipt.rId == p.rId }">
									<tr>
										<td class="col-1 text-center">${p.sId.sName}</td>
										<td class="col-2 text-center price">${d.repPrice}</td>
										<td class="col-2 text-center">${d.company.comName}</td>
										<td class="col-2 text-center">${p.stId.stName}</td>
										<td><c:forEach items="${listDetail}" var="i">
												<c:if test="${p.rId == i.rId.rId }">
													<a><span style="font-size: 10px">${i.amount}x</span></a>
													<img class="img-responsive" width="60px" height="60px"
														src="${i.pId.pImage}" />
													<a>${i.pId.pName}</a>

													<br>
												</c:if>
											</c:forEach></td>
									</tr>
								</c:if>
							</c:forEach>
						</c:forEach>

					</tbody>
				</table>
			</div>
		</div>
	</div>

	<h4 class="small-title" style="color:Tomato;">Đã hủy</h4>
	<div class="row">
		<div class="col-12">
			<div class="table-responsive">
				<table class="table table-bordered table-hover">
					<thead>
						<tr>
							<th class="text-center">Shop</th>
							<th class="text-center">Tổng đơn hàng</th>
							<th class="text-center">Đơn vị vận chuyển</th>
							<th class="text-center">Trạng thái</th>
							<th class="text-center">Chi tiết đơn</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listDeli}" var="d">
							<c:forEach items="${listReceipt4}" var="p">
								<c:if test="${d.receipt.rId == p.rId }">
									<tr>
										<td class="col-1 text-center">${p.sId.sName}</td>
										<td class="col-2 text-center price">${d.repPrice}</td>
										<td class="col-2 text-center">${d.company.comName}</td>
										<td class="col-2 text-center">${p.stId.stName}</td>
										<td><c:forEach items="${listDetail}" var="i">
												<c:if test="${p.rId == i.rId.rId }">
													<a><span style="font-size: 10px">${i.amount}x</span></a>
													<img class="img-responsive" width="60px" height="60px"
														src="${i.pId.pImage}" />
													<a>${i.pId.pName}</a>

													<br>
												</c:if>
											</c:forEach></td>
									</tr>
								</c:if>
							</c:forEach>
						</c:forEach>

					</tbody>
				</table>
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