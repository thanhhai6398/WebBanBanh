<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<!-- BEGIN CONTENT -->
<div class="page-content-wrapper">
	<div class="page-content">
		<!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->
		<div class="modal fade" id="portlet-config" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true"></button>
						<h4 class="modal-title">Modal title</h4>
					</div>
					<div class="modal-body">Widget settings form goes here</div>
					<div class="modal-footer">
						<button type="button" class="btn blue">Save changes</button>
						<button type="button" class="btn default" data-dismiss="modal">Close</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
		<!-- /.modal -->
		<!-- END SAMPLE PORTLET CONFIGURATION MODAL FORM-->
		<!-- BEGIN PAGE HEADER-->
		<h3 class="page-title">Quản Lý Người Dùng</h3>
		<div class="page-bar">
			<ul class="page-breadcrumb">
				<li><i class="fa fa-home"></i> <a href="index.html">Home</a> <i
					class="fa fa-angle-right"></i></li>
				<li><a href="#">Quản Lý Người Dùng</a> <i
					class="fa fa-angle-right"></i></li>
			</ul>
		</div>
		<!-- END PAGE HEADER-->
		<!-- BEGIN PAGE CONTENT-->
		<div class="row">
			<div class="col-md-12">
				<div class="portlet box grey-cascade">
					<div class="portlet-title">
						<div class="caption">
							<i class="fa fa-globe"></i>Danh Sách Người Dùng
						</div>
						<div class="tools">
							<a href="javascript:;" class="collapse"> </a> <a
								href="#portlet-config" data-toggle="modal" class="config"> </a>
							<a href="javascript:;" class="reload"> </a> <a
								href="javascript:;" class="remove"> </a>
						</div>
					</div>
					<div class="portlet-body">
						<div class="table-toolbar">
							<div class="row">
								<div class="col-md-6">
									<div class="btn-group">
									<a href="${pageContext.request.contextPath }/admin/user/list?type=add">
										<button id="sample_editable_1_new" class="btn green">
											Add New <i class="fa fa-plus"></i>
										</button>
										</a>
									</div>
								</div>
								<div class="col-md-6">
									<div class="btn-group pull-right">
										<button class="btn dropdown-toggle" data-toggle="dropdown">
											Tools <i class="fa fa-angle-down"></i>
										</button>
										<ul class="dropdown-menu pull-right">
											<li><a href="#"> Print </a></li>
											<li><a href="#"> Save as PDF </a></li>
											<li><a href="#"> Export to Excel </a></li>
										</ul>
									</div>
								</div>
							</div>
						</div>
						<table class="table table-striped table-bordered table-hover"
							id="sample_1">
							<thead>
								<tr>
									<th>UserID</th>
									<th>Username</th>
									<th>Password</th>
									<th>Is Seller</th>
									<th>Is Admin</th>
									<th>Shop name</th>
									<th>Tools</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach items="${userList }" var="u">
								<tr class="odd gradeX">
									<td>${u.uid }</td>
									<td>${u.uname }</td>
									<td>${u.upass }</td>
									<c:choose>
										<c:when test="${u.isSel == '1' }">
											<td>True</td>
										</c:when>
										<c:otherwise>
											<td>False</td>
										</c:otherwise>
									</c:choose>
									<c:choose>
										<c:when test="${u.isAd == '1' }">
											<td>True</td>
										</c:when>
										<c:otherwise>
											<td>False</td>
										</c:otherwise>
									</c:choose>
									<c:choose>
										<c:when test="${not empty u.shop }">
											<td>${u.shop.sName }</td>
										</c:when>
										<c:otherwise>
											<td>Null</td>
										</c:otherwise>
									</c:choose>
									<td>
										<a href="${pageContext.request.contextPath }/admin/user/list?type=delete&uid=${u.uid }">
										<button type="button" class="btn red btn-xs">Xóa</button> 
										</a>
										<a href="${pageContext.request.contextPath }/admin/user/list?type=edit&uid=${u.uid }">
										<button type="button" class="btn blue btn-xs">Sữa</button>
										</a>
									</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>

				</div>
			</div>
			<!-- END PAGE CONTENT-->
		</div>
	</div>
	<!-- END CONTENT -->
</div>
	<!-- END CONTAINER -->