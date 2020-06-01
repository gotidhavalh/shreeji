<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>View</title>
<meta charset="utf-8">
<%@include file="/WEB-INF/pages/sidebarTemplate.jsp"%>
</head>
<body>
<div class="container-fluid px-0 main-body-warpper">
	<div class="main-content p-3">
		<div class="pages-all bg-white">
			<div class="row align-items-center border-bottom pb-2">
				<div class="col-6">
					<h5>View Leave</h5>
					<nav aria-label="breadcrumb">
						<ol class="breadcrumb mb-0">
							<li class="breadcrumb-item"><a href="#"
								class="text-secondary">Home</a></li>
							<li class="breadcrumb-item active" aria-current="page">Leave</li>
						</ol>
					</nav>
				</div>
			</div>
			<div class="heading py-2 my-2 mb-4 border-bottom px-3">
				<h6 class="mb-0 font-weight-bold">View Leave</h6>
			</div>
			<form name="updateform" action="MainController" method="post">
				<c:forEach items="${leaveview}" var="leaveview">
					<table class="table table-custom table-details">
						<tr>
							<td>Employee Name</td>
							<td>${leaveview.empName}</td>
						</tr>
						<tr>
							<td>From Date</td>
							<td>${leaveview.fromDate}</td>
						</tr>
						<tr>
							<td>To Date</td>
							<td>${leaveview.toDate}</td>
						</tr>
						<tr>
							<td>Leave Type</td>
							<td>${leaveview.day}</td>
						</tr>
						<tr>
							<td>Number Of Day(s)</td>
							<td>${leaveview.noofDays}</td>
						</tr>
						<tr>
							<td>Leave Reason</td>
							<td>${leaveview.reason}</td>
						</tr>
						<tr>
							<td>Status</td>
							<td><select name="status" class="custom-select form-control">
									<option value="Pending">Pending</option>
									<option value="Approved">Approved</option>
									<option value="Reject">Reject</option>
							</select></td>
						</tr>
					</table>
					<div class="w-100 text-right">
						<input type="submit" name="submit" value="Done"	class="btn btn-primary mr-2"> 
						<input type="hidden" name="id" value="${leaveview.ID}">
						<input type="hidden" name="action" value="editLeave">
				</c:forEach>
			</form>

			<form class="d-inline-block" name="cancelform "	action="MainController" method="post">
				<input type="hidden" id="action" name="action" value="listLeave">
				<input type="submit" class="btn btn-secondary" value="Cancel" name="cancel">
			</form>
		</div>
	</div>
	</div>
	</div>
</body>
</html>