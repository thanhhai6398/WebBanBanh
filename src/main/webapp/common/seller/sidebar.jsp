<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<div class="wrapper">
	<nav id="sidebar">
		<ul class="list-unstyled components">
			<li class="sidebar-item active"><a href="#homeSubmenu"
				data-toggle="collapse" aria-expanded="false"
				class="dropdown-toggle sidebar-text"> <i
					class="fas fa-shopping-bag"></i> Quản lý đơn hàng
			</a>
				<ul class="collapse list-unstyled" id="homeSubmenu">
					<li><a href="<c:url value="/seller/receipt/list?type=all"/>" class="active">Tất cả</a></li>
					<li><a href="<c:url value="/seller/receipt/list?type=checked"/>">Chờ xác nhận</a></li>
					<li><a href="<c:url value="/seller/receipt/list?type=delivering"/>">Đang giao</a></li>
					<li><a href="<c:url value="/seller/receipt/list?type=delivered"/>">Đã giao</a></li>
					<li><a href="<c:url value="/seller/receipt/list?type=cancelled"/>">Đã hủy</a></li>
					
				</ul></li>
			<li class="sidebar-item"><a href="#pageSubmenu"
				data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">
					<i class="fas fa-cookie-bite"></i> Quản lý sản phẩm
			</a>
				<ul class="collapse list-unstyled" id="pageSubmenu">
					<li><a href="<c:url value="/seller/product/list?type=all"/>">Tất cả sản phẩm</a></li>
					<li><a href="<c:url value="/seller/product/edit?action=add"/>">Thêm sản phẩm</a></li>
				</ul></li>
			<li class="sidebar-item"><a href="<c:url value="/seller/shop/statistics"/>"> <i
					class="fas fa-tools"></i> Phân tích bán hàng
			</a></li>
			<li class="sidebar-item"><a href="<c:url value="/seller/shop/setting"/>"> <i
					class="fas fa-tools"></i> Thiết lập Shop
			</a></li>
		</ul>
	</nav>
</div>