<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>

<div class="clearfix">
</div>
<!-- BEGIN CONTAINER -->
<div class="page-container">
	<!-- BEGIN SIDEBAR -->
	<div class="page-sidebar-wrapper">
		<div class="page-sidebar navbar-collapse collapse">
			<!-- BEGIN SIDEBAR MENU -->
			<!-- DOC: Apply "page-sidebar-menu-light" class right after "page-sidebar-menu" to enable light sidebar menu style(without borders) -->
			<!-- DOC: Apply "page-sidebar-menu-hover-submenu" class right after "page-sidebar-menu" to enable hoverable(hover vs accordion) sub menu mode -->
			<!-- DOC: Apply "page-sidebar-menu-closed" class right after "page-sidebar-menu" to collapse("page-sidebar-closed" class must be applied to the body element) the sidebar sub menu mode -->
			<!-- DOC: Set data-auto-scroll="false" to disable the sidebar from auto scrolling/focusing -->
			<!-- DOC: Set data-keep-expand="true" to keep the submenues expanded -->
			<!-- DOC: Set data-auto-speed="200" to adjust the sub menu slide up/down speed -->
			<ul class="page-sidebar-menu" data-keep-expanded="false" data-auto-scroll="true" data-slide-speed="200">
				<li>
					<a href="javascript:;">
					<i class="icon-home"></i>
					<span class="title">Dashboard</span>
					<span class="selected"></span>
					<span class="arrow open"></span>
					</a>
					<ul class="sub-menu">
						<li class="active">
							<a href="${pageContext.request.contextPath }/admin/dashboard">
							<i class="icon-bar-chart"></i>
							Dashboard</a>
						</li>
					</ul>
				</li>
				<li>
					<a href="javascript:;">
					<i class="icon-basket"></i>
					<span class="title">Quản lý Người Dùng</span>
					<span class="arrow "></span>
					</a>
					<ul class="sub-menu">
						<li>
							<a href="${pageContext.request.contextPath }/admin/user/list?type=list">
							<i class="icon-home"></i>
							Danh Sách Người Dùng</a>
						</li>
						<li>
							<a href="${pageContext.request.contextPath }/admin/user/list?type=add">
							<i class="icon-basket"></i>
							Thêm Người Dùng</a>
						</li>
					</ul>
				</li>
				<li>
					<a href="javascript:;">
					<i class="icon-rocket"></i>
					<span class="title">Quản lý danh mục</span>
					<span class="arrow "></span>
					</a>
					<ul class="sub-menu">
						<li>
							<a href="${pageContext.request.contextPath }/admin/cate/list?type=list">
							Danh Sách Danh Mục</a>
						</li>
						<li>
							<a href="${pageContext.request.contextPath }/admin/cate/list?type=add">
							Thêm Danh Mục</a>
						</li>
					</ul>
				</li>
				<li>
					<a href="javascript:;">
					<i class="icon-diamond"></i>
					<span class="title">Thống Kê</span>
					<span class="arrow "></span>
					</a>
					<ul class="sub-menu">
						<li>
							<a href="${pageContext.request.contextPath }/admin/statistic?type=sanpham">
							Thống Kê Sản Phẩm</a>
						</li>
						<li>
							<a href="${pageContext.request.contextPath }/admin/statistic?type=donhang">
							Thống Kê Đơn Hàng</a>
						</li>
						<li>
							<a href="${pageContext.request.contextPath }/admin/statistic?type=nguoidung">
							Thống Kê Người Dùng</a>
						</li>
					</ul>
				</li>
			</ul>
			<!-- END SIDEBAR MENU -->
		</div>
	</div>
	<!-- END SIDEBAR -->
	<!-- BEGIN CONTENT -->
	<dec:body />
	<!-- END CONTENT -->
</div>

<!-- END CONTAINER -->