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
		<h3 class="page-title">Thống Kê</h3>
		<div class="page-bar">
			<ul class="page-breadcrumb">
				<li><i class="fa fa-home"></i> <a href="index.html">Home</a> <i
					class="fa fa-angle-right"></i></li>
				<li><a href="#">Thống Kê Đơn Hàng</a> <i
					class="fa fa-angle-right"></i></li>
			</ul>
		</div>
		<!-- END PAGE HEADER-->
		<!-- BEGIN PAGE CONTENT-->
		<!-- BEGIN ROW -->
		<div class="row">
			<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
					<div class="dashboard-stat blue-madison">
						<div class="visual">
							<i class="fa fa-bar-chart-o"></i>
						</div>
						<div class="details">
							<div class="number">
								 ${receiptCount }
							</div>
							<div class="desc">
								 Total Sold Receipt
							</div>
						</div>
					</div>
				</div>
		</div>
		<!-- END ROW -->
		<!-- BEGIN ROW -->
		<div class="row">
			<div class="col-md-12">
				<div class="portlet box grey-cascade">
					<div class="portlet-title">
						<div class="caption">
							<i class="fa fa-globe"></i>Thống Kê Số Lượng Đơn Hàng Theo Shop
						</div>
					</div>
					<div class="portlet-body">
						<table class="table table-striped table-bordered table-hover"
							id="sample_2">
							<thead>
								<tr>
									<th>Shop ID</th>
									<th>Shop Name</th>
									<th>Amount</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach items="${myShopMap }" var="m">
								<tr class="odd gradeX">
									<td><c:out value="${m.key.sID }"/></td>
									<td><c:out value="${m.key.sName }"/></td>
									<td><c:out value="${m.value }"/></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
		<!-- END ROW -->
		<!-- BEGIN ROW -->
					<div class="row">
						<div class="col-md-12">
							<!-- BEGIN CHART PORTLET-->
							<div class="portlet light bordered">
								<div class="portlet-title">
									<div class="caption">
										<i class="icon-bar-chart font-green-haze"></i>
										<span class="caption-subject bold uppercase font-green-haze"> Bar Charts</span>
										<span class="caption-helper">column and line mix</span>
									</div>
									<div class="tools">
										<a href="javascript:;" class="collapse">
										</a>
										<a href="#portlet-config" data-toggle="modal" class="config">
										</a>
										<a href="javascript:;" class="reload">
										</a>
										<a href="javascript:;" class="fullscreen">
										</a>
										<a href="javascript:;" class="remove">
										</a>
									</div>
								</div>
								<div class="portlet-body">
									<div id="chart_1" class="chart" style="height: 500px;">
									</div>
								</div>
							</div>
							<!-- END CHART PORTLET-->
						</div>
					</div>
					<!-- END ROW -->
					
		<!-- BEGIN ROW -->
					<div class="row">
						<div class="col-md-6">
							<!-- BEGIN CHART PORTLET-->
							<div class="portlet light bordered">
								<div class="portlet-title">
									<div class="caption">
										<i class="icon-bar-chart font-green-haze"></i>
										<span class="caption-subject bold uppercase font-green-haze"> Simple Pie Chart</span>
									</div>
									<div class="tools">
										<a href="javascript:;" class="collapse">
										</a>
										<a href="#portlet-config" data-toggle="modal" class="config">
										</a>
										<a href="javascript:;" class="reload">
										</a>
										<a href="javascript:;" class="fullscreen">
										</a>
										<a href="javascript:;" class="remove">
										</a>
									</div>
								</div>
								<div class="portlet-body">
									<div id="chart_6" class="chart" style="height: 525px;">
									</div>
								</div>
							</div>
							<!-- END CHART PORTLET-->
						</div>
						</div>	
			<!-- END ROW -->
	<!-- END CONTENT -->
</div>
	<!-- END CONTAINER -->
	</div>
	