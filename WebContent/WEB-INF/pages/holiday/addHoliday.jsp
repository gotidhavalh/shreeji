<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Holiday</title>
<%@include file="/WEB-INF/pages/sidebarTemplate.jsp"%>
<!-- 	<script src="js/custom.js"></script> -->
</head>
<body>
	<div class="container-fluid px-0 main-body-warpper">
		<div class="main-content p-3">
			<div class="pages-all bg-white">
				<div class="row align-items-center border-bottom pb-2">
					<div class="col-6">
						<h5>Holiday</h5>
						<nav aria-label="breadcrumb">
							<ol class="breadcrumb mb-0">
								<li class="breadcrumb-item">
									<a href="#"	class="text-secondary">Home</a></li>
								<li class="breadcrumb-item">
									<a href="#"	class="text-secondary">Holiday</a></li>
								<li class="breadcrumb-item active" aria-current="page">Add Holiday</li>
							</ol>
						</nav>
					</div>
				</div>
				<div class="add-details">
					<form class="mb-0 px-3" name="addHoliday" action="MainController" method="post">
						<div class="row">
							<div class="col-12 heading py-2 my-2 mb-4 border-bottom">
								<h6 class="mb-0 font-weight-bold">Add Holiday</h6>
							</div>
								<div class="col-6">
									<div class="form-group">
										<label for="day" class="d-block text-left">Day</label> 
										<select class="custom-select form-control" name="days" required="required">
											<option value="sun">Sunday</option>
											<option value="mon">Monday</option>
											<option value="tue">Tuesday</option>
											<option value="wed">Wednesday</option>
											<option value="thu">Thursday</option>
											<option value="fri">Friday</option>
											<option value="sat">saturday</option>
										</select>
									</div>
								</div>	
								<div class="col-6">
								<div class="form-group">
									<label for="p-address" class="d-block text-left">Date</label>
									<div class="input-group date">
										<input type="text" class="form-control" id="datetimepicker4" aria-describedby="inputGroupPrepend3" name="date" required="required"> 
										<span class="input-group-append"> 
											<span class="input-group-text" id="inputGroupPrepend3"> 
												<span class="icon icon-calendar">
												</span>
											</span>
										</span>
									</div>
								</div>
							</div>
							<div class="col-12">
								<div class="form-group">
									<label for="code" class="d-block text-left">Holiday	Name</label> 
										<input class="form-control" type="text" id="code" name="holiName" required="required">
								</div>
							</div>
						</div>
						<div class="col-12 text-right mt-3">
							<input type="hidden" name="action" value="addHolidays"> 
							<input type="submit" class="btn btn-primary mr-2 d-inline-block" value="Submit">
					</form>
				<form class="d-inline-block" name="cancelform "	action="MainController" method="post">
					<input type="hidden" id="action" name="action" value="listHolidays">
					<input type="submit" class="btn btn-secondary" value="Cancel" name="cancel">
				</form>
				</div>
			</div>
		</div>
	</div>

	<!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-body text-center py-4">
					<img src="images/pop-up.png" alt="" class="mb-3" />
					<h5 class="mb-4">Are you sure you want to add this record?</h5>
					<div class="">
						<a href="#" class="btn btn-primary mr-3">Yes</a> <a href="#"
							class="btn btn-secondary">No</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>