<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ADD DEDUCTION</title>
<%@include file="/WEB-INF/pages/sidebarTemplate.jsp"%>
</head>
<body>
	<div class="container-fluid px-0 main-body-warpper">
		<div class="main-content p-3">
			<div class="pages-all bg-white">
				<div class="row align-items-center border-bottom pb-2">
					<div class="col-6">
						<h5>View Allowance</h5>

					</div>
				</div>
				<div class="heading py-2 my-2 px-3">
					<h6 class="mb-0 font-weight-bold">View Details</h6>
				</div>
				<c:forEach items="${allowlist}" var="list">
					<table class="table table-custom table-details">
						<tr>
							<td>Emp Name</td>
							<td>${list.name}</td>
						</tr>
						<tr>
							<td>Fual</td>
							<td>${list.fual}</td>
						</tr>
						<tr>
							<td>OverTime</td>
							<td>${list.overTime}</td>
						</tr>
						<tr>
							<td>Date</td>
							<td>${list.month}</td>
						</tr>

					</table>
				</c:forEach>
				<div class="w-100 text-right">
					<form name="cancelAllow" method="POST" action="MainController">
						<input type="hidden" name="action" value="listAllow">
						<a href="javascript:document.cancelAllow.submit()"	class="btn btn-secondary mr-2">Cancel</a>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>