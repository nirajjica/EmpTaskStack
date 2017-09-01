<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<script type="text/javascript">
var baseUrl = "<%=request.getContextPath()%>";
</script>   
    
<%
    response.setHeader("Cache-Control", "no-cache"); //HTTP 1.1
    response.setHeader("Pragma", "no-cache"); //HTTP 1.0
    response.setDateHeader("Expires", 0); //prevents caching at the proxy server
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.navLinks {
    display: none;
}
</style>
</head>

<%@include file="header.jsp" %>
<body class="theme-red">
    <!-- Page Loader -->
    <div class="page-loader-wrapper">
        <div class="loader">
            <div class="preloader">
                <div class="spinner-layer pl-red">
                    <div class="circle-clipper left">
                        <div class="circle"></div>
                    </div>
                    <div class="circle-clipper right">
                        <div class="circle"></div>
                    </div>
                </div>
            </div>
            <p>Please wait...</p>
        </div>
    </div>
    <!-- #END# Page Loader -->
    <!-- Overlay For Sidebars -->
    <div class="overlay"></div>
    <!-- #END# Overlay For Sidebars -->
    <!-- Search Bar -->
    <div class="search-bar">
        <div class="search-icon">
            <i class="material-icons">search</i>
        </div>
        <input type="text" placeholder="START TYPING...">
        <div class="close-search">
            <i class="material-icons">close</i>
        </div>
    </div>
    <!-- #END# Search Bar -->
    <!-- Top Bar -->
    <nav class="navbar">
        <div class="container-fluid">
            <div class="navbar-header">
                <a href="javascript:void(0);" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse" aria-expanded="false"></a>
                <a href="javascript:void(0);" class="bars"></a>
                <a class="navbar-brand" href="index.html">Employee - Admin Panel</a>
            </div>
            <div class="collapse navbar-collapse" id="navbar-collapse">
            </div>
        </div>
    </nav>
    <!-- #Top Bar -->
    <section>
        <!-- Left Sidebar -->
        <aside id="leftsidebar" class="sidebar">
            <!-- User Info -->
            <div class="user-info">
                <div class="image">
                    <img src="resource/images/user.png" width="48" height="48" alt="User" />
                </div>
                <div class="info-container">
                    <div class="name" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">John Doe</div>
                    <div class="email">john.doe@example.com</div>
                    <!-- <div class="btn-group user-helper-dropdown">
                        <i class="material-icons" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">keyboard_arrow_down</i>
                        <ul class="dropdown-menu pull-right">
                            <li><a href="javascript:void(0);"><i class="material-icons">person</i>Profile</a></li>
                            <li role="seperator" class="divider"></li>
                            <li><a href="javascript:void(0);"><i class="material-icons">group</i>Followers</a></li>
                            <li><a href="javascript:void(0);"><i class="material-icons">shopping_cart</i>Sales</a></li>
                            <li><a href="javascript:void(0);"><i class="material-icons">favorite</i>Likes</a></li>
                            <li role="seperator" class="divider"></li>
                            <li><a href="logout"><i class="material-icons">input</i>Sign Out</a></li>
                        </ul>
                    </div> -->
                </div>
            </div>
            <!-- #User Info -->
            <!-- Menu -->
            <div class="menu">
                <ul class="list">
                    <li class="header">MAIN NAVIGATION</li>
                    <li class="active">
                        <a href="index.html">
                            <i class="material-icons">home</i>
                            <span>Home</span>
                        </a>
                    </li>
                     <li>
                        <a href="javascript:void(0);">
                            <i class="material-icons col-light-blue">donut_large</i>
                            <span divName="#department" onclick="department.get();">Department</span>
                        </a>
                    </li>
                    
                    <li>
                        <a href="javascript:void(0);">
                            <i class="material-icons col-light-blue">donut_large</i>
                            <span divName="#role" onclick="role.get()" >Role</span>
                        </a>
                    </li>
                    
                     <li>
                        <a href="javascript:void(0);">
                            <i class="material-icons col-light-blue">donut_large</i>
                            <span divName="#employee" onclick="employee.get();" >Employee</span>
                        </a>
                    </li>
                </ul>
            </div>
            <!-- #Menu -->
        </aside>
        <!-- #END# Left Sidebar -->
    </section>

    <section class="content">
    
    	<div class="container-fluid navLinks" id="role">
           <div class="block-header">
                <h2>Role</h2>
            </div>
             <div class="row clearfix">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="card">
                        <div class="header">
                            <h2>
                                Create role
                            </h2>
                        </div>
                        <div class="body">
                            <form id="roleForm" method="POST" >
                            	 <div class="row clearfix">
	                            	<div class="col-md-6">
		                               <div class="form-group form-float">
		                                    <div class="form-line">
		                                        <input type="text" id="name" name="name" class="form-control validate[required]">
		                                        <label class="form-label">Role Name</label>
		                                    </div>
		                                </div>
	                              	</div>
									<div class="col-md-12">
		                                <div class="form-group form-float">
		                                    <div class="form-line">
		                                        <input type="text" id="menu" name="menu" class="form-control validate[required]">
		                                        <label class="form-label">Role Menu</label>
		                                    </div>
		                                </div>
	                              	</div>
	                              	<input type="hidden" id="id" name="id" >
		                       	</div>
	                            
								<div class="row clearfix">
									<div class="col-md-6">
										<button type="button" onclick="role.save();" class="btn btn-primary m-t-15 waves-effect">Submit</button>
									</div>
								</div>
                            </form>
                            
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="row clearfix">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="card">
                        <div class="header">
                            <h2>
                                role List
                            </h2>
                        </div>
	                        <div class="body">
	                            <table id="roleTable" class="table table-bordered table-striped table-hover js-basic-example dataTable">
                                <thead>
                                    <tr>
                                        <th>Role Name</th>
                                        <th>Role Menu</th>
                                        <th>Edit</th>
                                    </tr>
                                </thead>
                                <tbody>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    
        <div class="container-fluid navLinks" id="department">
           <div class="block-header">
                <h2>Department</h2>
            </div>
             <div class="row clearfix">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="card">
                        <div class="header">
                            <h2>
                                Create department
                            </h2>
                        </div>
                        <div class="body">
                            <form id="departmentForm" method="POST" >
                            	 <div class="row clearfix">
	                            	<div class="col-md-6">
		                               <div class="form-group form-float">
		                                    <div class="form-line">
		                                        <input type="text" id="code" name="code" class="form-control validate[required]">
		                                        <label class="form-label">code</label>
		                                    </div>
		                                </div>
	                              	</div>
									<div class="col-md-12">
		                                <div class="form-group form-float">
		                                    <div class="form-line">
		                                        <input type="text" id="name" name="name" class="form-control validate[required]">
		                                        <label class="form-label">name</label>
		                                    </div>
		                                </div>
	                              	</div>
	                              	<input type="hidden" id="id" name="id" >
		                       	</div>
	                            
								<div class="row clearfix">
									<div class="col-md-6">
										<button type="button" onclick="department.save();" class="btn btn-primary m-t-15 waves-effect">Submit</button>
									</div>
								</div>
                                
                            </form>
                            
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="row clearfix">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="card">
                        <div class="header">
                            <h2>
                                Department list
                            </h2>
                        </div>
	                        <div class="body">
	                            <table id="deptTable" class="table table-bordered table-striped table-hover js-basic-example dataTable">
                                <thead>
                                    <tr>
                                    	<th>Dept Id</th>
                                        <th>Dept Code</th>
                                        <th>Dept Name</th>
                                        <th>Edit</th>
                                    </tr>
                                </thead>
                                <tbody>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
        <div class="container-fluid navLinks" id="employee">
           <div class="block-header">
                <h2>employee</h2>
            </div>
             <div class="row clearfix">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="card">
                        <div class="header">
                            <h2>
                                Create employee
                            </h2>
                        </div>
                        <div class="body">
                            <form id="employeeForm" method="POST" >
                            	 <div class="row clearfix">
	                            	<div class="col-md-6">
		                               <div class="form-group form-float">
		                                    <div class="form-line">
		                                        <input type="text" id="fname" name="fname" class="form-control validate[required]">
		                                        <label class="form-label">first name</label>
		                                    </div>
		                                </div>
	                              	</div>
									<div class="col-md-6">
		                                <div class="form-group form-float">
		                                    <div class="form-line">
		                                        <input type="text" id="lname" name="lname" class="form-control validate[required]">
		                                        <label class="form-label">last name</label>
		                                    </div>
		                                </div>
	                              	</div>
		                       	</div>
		                       	
		                       	<div class="row clearfix">
	                            	<div class="col-md-6">
		                               <div class="form-group form-float">
		                                    <div class="form-line">
		                                        <input type="text" id="username" name="username" class="form-control validate[required]">
		                                        <label class="form-label">username</label>
		                                    </div>
		                                </div>
	                              	</div>
									<div class="col-md-6">
		                                <div class="form-group form-float">
		                                    <div class="form-line">
		                                        <input type="password" id="password" name="password" class="form-control validate[required]">
		                                        <label class="form-label">password</label>
		                                    </div>
		                                </div>
	                              	</div>
		                       	</div>
		                       	
		                       	<div class="row clearfix">
	                            	<div class="col-md-6">
		                               <div class="form-group form-float">
		                                    <div class="form-line">
		                                        <input type="text" id="email" name="email" class="form-control validate[required]">
		                                        <label class="form-label">email</label>
		                                    </div>
		                                </div>
	                              	</div>
									<div class="col-md-6">
		                                <div class="form-group form-float">
		                                    <div class="form-line">
		                                        <input type="text" id="address" name="address" class="form-control validate[required]">
		                                        <label class="form-label">address</label>
		                                    </div>
		                                </div>
	                              	</div>
		                       	</div>
		                       	
		                       	<div class="row clearfix">
	                            	<div class="col-md-6">
		                               <div class="form-group form-float">
		                                    <div class="form-line">
		                                        <input type="text" id="salary" name="salary" class="form-control validate[required]">
		                                        <label class="form-label">salary</label>
		                                    </div>
		                                </div>
	                              	</div>
									<div class="col-md-6">
		                                <div class="form-group form-float">
		                                    <div class="form-line">
		                                        <input type="text" id="code" name="code" class="form-control validate[required]">
		                                        <label class="form-label">code</label>
		                                    </div>
		                                </div>
	                              	</div>
	                              	
		                       	</div>
		                       	
		                       	<div class="row clearfix">
	                            	<div class="col-md-12">
		                               <div class="form-group form-float">
		                                    <div class="form-line">
		                                        <input type="text" id="phone" name="phone" class="form-control validate[required]">
		                                        <label class="form-label">phone</label>
		                                    </div>
		                                </div>
	                              	</div>
									<!-- <div class="col-md-6">
	                                    <select id="accounttype" name="accounttype" class="form-control show-tick validate[required]" >
	                                         	<option value="">Select account type</option>
		                                        <option value="HR">HR</option>
		                                        <option value="Manager">Manager</option>
	                                    </select>
	                                </div> -->
		                       	</div>
		                       	
		                       	<div class="row clearfix">
		                       		<div class="col-md-4">
	                                    <select id="manager" name="manager" class="form-control show-tick" >
	                                         	<option value="">Select manager</option>
	                                    </select>
	                                </div>
	                            	<div class="col-md-4">
	                                    <select id="departmentId" name="departmentId" class="form-control show-tick validate[required]" >
	                                         	<option value="">Select department</option>
	                                    </select>
	                                </div>
									<div class="col-md-4">
	                                    <select id="roleName" name="roleName" class="form-control show-tick validate[required]" >
	                                         	<option value="">Select role name</option>
	                                    </select>
	                                </div>
		                       	</div>
	                            
								<div class="row clearfix">
									<div class="col-md-6">
										<input type="hidden" id="id" name="id" >
										<button type="button" onclick="employee.save();" class="btn btn-primary m-t-15 waves-effect">Submit</button>
									</div>
								</div>
                                
                            </form>
                            
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="row clearfix">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="card">
                        <div class="header">
                            <h2>
                                Employee list
                            </h2>
                        </div>
	                        <div class="body">
	                            <table id="empTable" class="table table-bordered table-striped table-hover js-basic-example dataTable">
                                <thead>
                                    <tr>
                                    	<th>Id</th>
                                        <th>first name</th>
                                        <th>last Name</th>
                                        <th>Edit</th>
                                    </tr>
                                </thead>
                                <tbody>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
    </section>

    <!-- Jquery Core Js -->
    <script src="resource/plugins/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core Js -->
    <script src="resource/plugins/bootstrap/js/bootstrap.js"></script>

    <!-- Select Plugin Js -->
    <script src="resource/plugins/bootstrap-select/js/bootstrap-select.js"></script>
    
   <!-- Jquery Spinner Plugin Js -->
    <script src="resource/plugins/jquery-spinner/js/jquery.spinner.js"></script>

    <!-- Bootstrap Tags Input Plugin Js -->
    <script src="resource/plugins/bootstrap-tagsinput/bootstrap-tagsinput.js"></script>

    <!-- Slimscroll Plugin Js -->
    <script src="resource/plugins/jquery-slimscroll/jquery.slimscroll.js"></script>

    <!-- Waves Effect Plugin Js -->
    <script src="resource/plugins/node-waves/waves.js"></script>

    <!-- Jquery CountTo Plugin Js -->
    <script src="resource/plugins/jquery-countto/jquery.countTo.js"></script>

    <!-- Morris Plugin Js -->
    <script src="resource/plugins/raphael/raphael.min.js"></script>
    <script src="resource/plugins/morrisjs/morris.js"></script>

    <!-- ChartJs -->
    <script src="resource/plugins/chartjs/Chart.bundle.js"></script>

    <!-- Sparkline Chart Plugin Js -->
    <script src="resource/plugins/jquery-sparkline/jquery.sparkline.js"></script>
    
    <!-- Multi Select Plugin Js -->
    <script src="resource/plugins/multi-select/js/jquery.multi-select.js"></script>
    
    <!-- Jquery DataTable Plugin Js -->
    <script src="resource/plugins/jquery-datatable/jquery.dataTables.js"></script>
    <script src="resource/plugins/jquery-datatable/skin/bootstrap/js/dataTables.bootstrap.js"></script>
    
    
        <!-- Jquery Validation Plugin -->
    <script src="resource/js/jquery.validationEngine.js"></script>
    <script src="resource/js/jquery.validationEngine-en.js"></script>
    <!-- JQuery Steps Plugin Js -->
    <script src="resource/plugins/jquery-steps/jquery.steps.js"></script>
    <!-- Sweet Alert Plugin Js -->
    <script src="resource/plugins/sweetalert/sweetalert.min.js"></script>
    
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-serialize-object/2.5.0/jquery.serialize-object.min.js"></script>
    <script src="resource/plugins/momentjs/moment.js"></script>
    <script src="resource/plugins/bootstrap-material-datetimepicker/js/bootstrap-material-datetimepicker.js"></script>
    <!-- Custom Js -->
    <script src="resource/js/admin.js"></script>
    <script src="resource/js/pages/index.js"></script>
    <!-- Demo Js -->
    <script src="resource/js/demo.js"></script>
    <!--Admin Js -->
    <script src="resource/devJs/admin.js"></script>
  
    
</body>



</html>