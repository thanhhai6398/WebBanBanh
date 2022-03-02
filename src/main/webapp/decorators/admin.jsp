<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<!-- 
Template Name: Metronic - Responsive Admin Dashboard Template build with Twitter Bootstrap 3.3.1
Version: 3.6
Author: KeenThemes
Website: http://www.keenthemes.com/
Contact: support@keenthemes.com
Follow: www.twitter.com/keenthemes
Like: www.facebook.com/keenthemes
Purchase: http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469?ref=keenthemes
License: You must have a valid license purchased only from themeforest(the above link) in order to legally use the theme for your project.
-->
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en" class="no-js">
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
<meta charset="utf-8"/>
<title>Metronic | Admin Dashboard Template</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1" name="viewport"/>
<meta content="" name="description"/>
<meta content="" name="author"/>
<!-- BEGIN GLOBAL MANDATORY STYLES -->
<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all" rel="stylesheet" type="text/css"/>
<link href="<c:url value="/templates/assets/global/plugins/font-awesome/css/font-awesome.min.css"/>" rel="stylesheet" type="text/css"/>
<link href="<c:url value="/templates/assets/global/plugins/simple-line-icons/simple-line-icons.min.css"/>" rel="stylesheet" type="text/css"/>
<link href="<c:url value="/templates/assets/global/plugins/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet" type="text/css"/>
<link href="<c:url value="/templates/assets/global/plugins/uniform/css/uniform.default.css"/>" rel="stylesheet" type="text/css"/>
<link href="<c:url value="/templates/assets/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css"/>" rel="stylesheet" type="text/css"/>
<!-- END GLOBAL MANDATORY STYLES -->
<!-- BEGIN PAGE LEVEL STYLES -->
<link rel="stylesheet" type="text/css" href="<c:url value="/templates/assets/global/plugins/select2/select2.css"/>"/>
<link rel="stylesheet" type="text/css" href="<c:url value="/templates/assets/global/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.css"/>"/>
<!-- END PAGE LEVEL STYLES -->
<!-- BEGIN PAGE LEVEL PLUGIN STYLES -->
<link href="<c:url value="/templates/assets/global/plugins/bootstrap-daterangepicker/daterangepicker-bs3.css"/>" rel="stylesheet" type="text/css"/>
<link href="<c:url value="/templates/assets/global/plugins/fullcalendar/fullcalendar.min.css"/>" rel="stylesheet" type="text/css"/>
<link href="<c:url value="/templates/assets/global/plugins/jqvmap/jqvmap/jqvmap.css"/>" rel="stylesheet" type="text/css"/>
<!-- END PAGE LEVEL PLUGIN STYLES -->
<!-- BEGIN PAGE STYLES -->
<link href="<c:url value="/templates/assets/admin/pages/css/tasks.css"/>" rel="stylesheet" type="text/css"/>
<!-- END PAGE STYLES -->
<!-- BEGIN THEME STYLES -->
<!-- DOC: To use 'rounded corners' style just load 'components-rounded.css' stylesheet instead of 'components.css' in the below style tag -->
<link href="<c:url value="/templates/assets/global/css/components.css"/>" id="style_components" rel="stylesheet" type="text/css"/>
<link href="<c:url value="/templates/assets/global/css/plugins.css"/>" rel="stylesheet" type="text/css"/>
<link href="<c:url value="/templates/assets/admin/layout/css/layout.css"/>" rel="stylesheet" type="text/css"/>
<link href="<c:url value="/templates/assets/admin/layout/css/themes/darkblue.css"/>" rel="stylesheet" type="text/css" id="style_color"/>
<link href="<c:url value="/templates/assets/admin/layout/css/custom.css"/>" rel="stylesheet" type="text/css"/>
<!-- END THEME STYLES -->
<link rel="shortcut icon" href="favicon.ico"/>
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<!-- DOC: Apply "page-header-fixed-mobile" and "page-footer-fixed-mobile" class to body element to force fixed header or footer in mobile devices -->
<!-- DOC: Apply "page-sidebar-closed" class to the body and "page-sidebar-menu-closed" class to the sidebar menu element to hide the sidebar by default -->
<!-- DOC: Apply "page-sidebar-hide" class to the body to make the sidebar completely hidden on toggle -->
<!-- DOC: Apply "page-sidebar-closed-hide-logo" class to the body element to make the logo hidden on sidebar toggle -->
<!-- DOC: Apply "page-sidebar-hide" class to body element to completely hide the sidebar on sidebar toggle -->
<!-- DOC: Apply "page-sidebar-fixed" class to have fixed sidebar -->
<!-- DOC: Apply "page-footer-fixed" class to the body element to have fixed footer -->
<!-- DOC: Apply "page-sidebar-reversed" class to put the sidebar on the right side -->
<!-- DOC: Apply "page-full-width" class to the body element to have full width page without the sidebar menu -->

<body class="page-header-fixed page-quick-sidebar-over-content page-style-square"> 
<!-- BEGIN HEADER -->
<%@ include file="/common/admin/header.jsp"%>
<!-- END HEADER -->


<!-- BEGIN CONTAINER -->
<%@ include file="/common/admin/sidebar.jsp"%>
<!-- END CONTAINER -->


<!-- BEGIN FOOTER -->
<%@ include file="/common/admin/footer.jsp"%>
<!-- END FOOTER -->

<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
<!-- BEGIN CORE PLUGINS -->
<!--[if lt IE 9]>
<script src="../../assets/global/plugins/respond.min.js"></script>
<script src="../../assets/global/plugins/excanvas.min.js"></script> 
<![endif]-->
<script src="<c:url value="/templates/assets/global/plugins/jquery.min.js"/>" type="text/javascript"></script>
<script src="<c:url value="/templates/assets/global/plugins/jquery-migrate.min.js"/>" type="text/javascript"></script>
<!-- IMPORTANT! Load jquery-ui-1.10.3.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->
<script src="<c:url value="/templates/assets/global/plugins/jquery-ui/jquery-ui-1.10.3.custom.min.js"/>" type="text/javascript"></script>
<script src="<c:url value="/templates/assets/global/plugins/bootstrap/js/bootstrap.min.js"/>" type="text/javascript"></script>
<script src="<c:url value="/templates/assets/global/plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js"/>" type="text/javascript"></script>
<script src="<c:url value="/templates/assets/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js"/>" type="text/javascript"></script>
<script src="<c:url value="/templates/assets/global/plugins/jquery.blockui.min.js"/>" type="text/javascript"></script>
<script src="<c:url value="/templates/assets/global/plugins/jquery.cokie.min.js"/>" type="text/javascript"></script>
<script src="<c:url value="/templates/assets/global/plugins/uniform/jquery.uniform.min.js"/>" type="text/javascript"></script>
<script src="<c:url value="/templates/assets/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js"/>" type="text/javascript"></script>
<!-- END CORE PLUGINS -->
<!-- BEGIN PAGE LEVEL PLUGINS -->
<script type="text/javascript" src="<c:url value="/templates/assets/global/plugins/select2/select2.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/templates/assets/global/plugins/datatables/media/js/jquery.dataTables.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/templates/assets/global/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.js"/>"></script>
<script src="<c:url value="/templates/assets/global/plugins/amcharts/amcharts/amcharts.js"/>" type="text/javascript"></script>
<script src="<c:url value="/templates/assets/global/plugins/amcharts/amcharts/serial.js"/>" type="text/javascript"></script>
<script src="<c:url value="/templates/assets/global/plugins/amcharts/amcharts/pie.js"/>" type="text/javascript"></script>
<script src="<c:url value="/templates/assets/global/plugins/amcharts/amcharts/themes/light.js"/>" type="text/javascript"></script>
<script src="<c:url value="/templates/assets/global/plugins/amcharts/amcharts/themes/patterns.js"/>" type="text/javascript"></script>
<script src="<c:url value="/templates/assets/global/plugins/amcharts/amcharts/themes/chalk.js"/>" type="text/javascript"></script>
<!-- END PAGE LEVEL PLUGINS -->
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="<c:url value="/templates/assets/global/scripts/metronic.js"/>" type="text/javascript"></script>
<script src="<c:url value="/templates/assets/admin/layout/scripts/layout.js"/>" type="text/javascript"></script>
<script src="<c:url value="/templates/assets/admin/layout/scripts/demo.js"/>" type="text/javascript"></script>
<script src="<c:url value="/templates/assets/admin/pages/scripts/table-managed.js"/>"></script>
<script src="<c:url value="/templates/assets/admin/pages/scripts/charts-amcharts.js"/>"></script>
<!-- END PAGE LEVEL SCRIPTS -->
<script>
jQuery(document).ready(function() {    
   Metronic.init(); // init metronic core componets
   Layout.init(); // init layout
   Demo.init(); // init demo features 
   TableManaged.init();
   ChartsAmcharts.init(${ShopMapForBarCharts }); // init demo charts
});
</script>
<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>