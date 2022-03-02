<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<div id="seller-setting" class="pb-5 pt-3">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h2 class="text-lg-center section-title">Hồ sơ Shop</h2>
				<p class="text-center mb-5">${msg}</p>

			</div>
		</div>
		<div class="row">
			<div class="col-md-4">
				<div class="shop-statics-item">
					<h5>
						<i class="fas fa-cookie-bite"></i> Số sản phẩm
					</h5>
					<span>${countProduct}</span>
				</div>
				<div class="shop-statics-item">
					<h5>
						<i class="fas fa-file-invoice-dollar"></i> Số đơn hàng
					</h5>
					<span>${countDelivered}</span>
				</div>
				<div class="shop-statics-item">
					<h5>
						<i class="fas fa-money-check"></i> Xem Shop
					</h5>
					<a href="<c:url value="/view-shop"/>"><span>Xem</span></a>
				</div>
			</div>
			<div class="col-md-8">
				<c:url value="/seller/shop/setting" var="setting"></c:url>
				<form action="${setting}" method="POST">
					<input type="text" name="sID" value="${shop.sID}" hidden="">
					<div class="form-group row d-flex align-items-center">
						<label for="inputName" class="col-sm-3 col-form-label">Tên
							Shop</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" id="inputName" required
								placeholder="Bakery" value="${shop.sName}" name="sName">
						</div>
					</div>
					<div class="form-group row d-flex align-items-center">
						<label for="inputName" class="col-sm-3 col-form-label">Số
							điện thoại</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" id="inputPhone" required
								placeholder="09...." value="${shop.sPhone}" name="sPhone">
						</div>
					</div>
					<div class="form-group row d-flex align-items-center">
						<label for="description" class="col-sm-3 col-form-label">Địa
							chỉ</label>
						<div class="col-sm-9">
							<textarea class="form-control" id="description" rows="3"
								placeholder="Thủ Đức, Tp.HCM" name="sAddrs">${shop.sAddrs}</textarea>
						</div>
					</div>
					<div class="form-group row d-flex align-items-center">
						<label for="inputName" class="col-sm-3 col-form-label">Tên
							tài khoản</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" id="inputSeller" required
								readonly placeholder="Tên tài khoản" value="${acc.uname}">
						</div>
					</div>
					<div class="form-group row d-flex align-items-center">
						<label for="inputName" class="col-sm-3 col-form-label">Mật
							khẩu</label>
						<div class="col-sm-9">
							<input type="password" class="form-control" id="inputPass" required
								readonly placeholder="Mật khẩu đăng nhập" value="${acc.upass}">
						</div>
					</div>
					<div class="col-md-9 offset-md-3">
						<input type="submit" class="btn btn-success" value="Lưu">
					</div>
				</form>
			</div>

		</div>
	</div>
</div>