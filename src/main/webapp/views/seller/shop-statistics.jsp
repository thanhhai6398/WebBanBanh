<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<script
	src="https://cdn.jsdelivr.net/npm/chart.js@3.6.0/dist/chart.min.js"></script>
<div id="shop-statistics">
	<div class="container">
		<div class="row">
			<section class="shop-statics-section">
				<h3>Doanh thu</h3>
				<p>Tổng quan về doanh thu</p>
				<div class="row">
					<table class="table table-borderless ml-4 mb-0">
						<tbody>
							<tr id="shop-statics-table">
								<td class="text-center col-4">
									<div class="notify-item text-center">
										<h4 class="text-dark price">${sumReceiptPrice}</h4>
										<p>Số tiền phải thu</p>
									</div>
								</td>
								<td class="text-center col-4">
									<div class="notify-item text-center">
										<h4 class="text-dark price">${sumDeliveredReceiptPrice}</h4>
										<p>Đã thu</p>
									</div>
								</td>
								<td class="text-center col-4">
									<div class="notify-item text-center">
										<h4 class="text-dark">${countDelivered} / ${sumAllReceipt}</h4>
										<p>Tỷ lệ dựa trên số đơn</p>
									</div>
								</td>
							</tr>

						</tbody>
					</table>
				</div>

			</section>

			<section class="shop-statics-section">
				<h3>Doanh số theo đơn hàng</h3>
				<p>Tỷ lệ đơn hàng thành công trong 4 tháng qua</p>
				<div class="row">
					<div class="offset-1 col-md-8">
						<div class="chart-area">
							<canvas id="myChart1"></canvas>
						</div>
					</div>
					<div class="col-md-3"></div>
				</div>
			</section>
		</div>
		<div class="row">
			<section class="shop-statics-section">
				<h3>Doanh số theo sản phẩm</h3>
				<p>Sản phẩm phổ biến</p>
				<div class="row">
					<div class="offset-1 col-md-8">
						<div class="chart-area">
							<canvas id="bar-chart" width="800" height="450"></canvas>
						</div>
					</div>
					<div class="col-md-3"></div>
				</div>
			</section>
		</div>
		<div class="row">
			<section class="shop-statics-section">
				<h3>Phân loại sản phẩm</h3>
				<p>Tỷ lệ sản phẩm theo phân loại</p>
				<div class="row">
					<div class="offset-1 col-md-6">
						<div class="chart-area">
							<canvas id="pie-chart"></canvas>
						</div>
					</div>
					<div class="col-md-3"></div>
				</div>
			</section>
		</div>
	</div>
</div>
<script>
	window.onload = function() {
		var priceItems = document.querySelectorAll(".price");
		var numVND = new Intl.NumberFormat('vi-VN', {
			style : "currency",
			currency : "VND"

		})
		for (var i = 0; i < priceItems.length; i++) {
			var priceRaw = priceItems[i].textContent;
			priceItems[i].style.color = "#c13030";
			priceItems[i].textContent = numVND.format(priceRaw);
		}
	}
</script>
<!-- Chart1 -->
<script>
	function addData(chart, data2) {
		console.log(data2);
		chart.data.datasets.push({
			label : 'Đơn thành công',
			data : data2,
			backgroundColor : [ '#16F529' ],
			borderColor : [ '#12AD2B' ],
			borderWidth : 2,
		});
		console.log(chart.data.datasets[0]);
		chart.update();
	}
	//Tat ca don dat hang
	var urlAll = "http://localhost:8080/Bakery/api-all-receipt";
	var xmlhttp = new XMLHttpRequest();
	xmlhttp.open('GET', urlAll, true);
	xmlhttp.send();
	xmlhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			let dataPointsAll = JSON.parse(this.responseText);
			const dataAll = dataPointsAll.map(function(e) {
				return e.data;
			});
			const labelAll = dataPointsAll.map(function(e) {
				return "Tháng " + e.labels;
			});
			const ctx = document.getElementById('myChart1').getContext('2d');
			const myChart = new Chart(ctx, {
				type : 'line',
				data : {
					labels : labelAll,
					datasets : [ {
						label : 'Tất cả đơn hàng',
						data : dataAll,
						backgroundColor : [ '#FD1C03' ],
						borderColor : [ '#FF0000' ],
						borderWidth : 2,
						fill: false,
						 tension: 0.2
					} ],
				},
				options : {
					scales : {
						y : {
							beginAtZero : true
						}
					}
				}
			});
			//Don thanh cong
			var url2 = "http://localhost:8080/Bakery/api-delivered-receipt";
			xmlhttp = new XMLHttpRequest();
			xmlhttp.open('GET', url2, true);
			xmlhttp.send();
			xmlhttp.onreadystatechange = function() {
				if (this.readyState == 4 && this.status == 200) {
					let dataPoints = JSON.parse(this.responseText);
					const data2 = dataPoints.map(function(e) {
						return e.data;
					});
					const label2 = dataPointsAll.map(function(e) {
						return "Tháng " + e.labels;
					});
					console.log(label2)
					addData(myChart, data2);
				}
			}
		}
	}
</script>
<!-- Char2 -->
<script>
	var url = "http://localhost:8080/Bakery/api-sold-product";
	var xmlhttp = new XMLHttpRequest();
	xmlhttp.open('GET', url, true);
	xmlhttp.send();
	xmlhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			var dataPoints = JSON.parse(this.responseText);
			var datas = dataPoints.map(function(e) {
				return e.data;
			});

			var labels = dataPoints.map(function(e) {
				return e.labels;
			});
			new Chart(document.getElementById("bar-chart"), {
				type : 'bar',
				data : {
					labels : labels,
					datasets : [ {
						label : "Số lượng",
						backgroundColor : [ ' #3366FF', '#666699', '#006699',
								'#9999FF', '#6699CC', '#669999', '#339999',
								'#339966' ],
						data : datas,
						borderWidth : 1
					} ]
				},
				options : {
					legend : {
						display : false,
						labels : {
							font : {
								size : 20
							}
						}
					}
				}
			});
		}
	}
</script>
<!-- Chart3 -->
<script>
	var url = "http://localhost:8080/Bakery/api-category";
	var xmlhttp = new XMLHttpRequest();
	xmlhttp.open('GET', url, true);
	xmlhttp.send();
	xmlhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			var dataPoints = JSON.parse(this.responseText);
			var datas = dataPoints.map(function(e) {
				return e.data;
			});

			var labels = dataPoints.map(function(e) {
				return e.labels;
			});
			new Chart(document.getElementById("pie-chart"), {
				type : 'pie',
				data : {
					labels : labels,
					datasets : [ {
						label : 'Thống kê theo doanh mục',
						backgroundColor : [ "#3e95cd", "#8e5ea2", "#3cba9f",
								"#e8c3b9", "#c45850" ],
						data : datas
					} ]
				},
				options : {
					legend : {
						display : true,
						labels : {
							fontSize : 14
						}

					}
				}
			});
		}
	}
</script>