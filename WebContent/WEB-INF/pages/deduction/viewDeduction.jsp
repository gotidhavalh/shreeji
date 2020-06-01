<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>View</title>
<%@include file="/WEB-INF/pages/sidebarTemplate.jsp"%>
</head>
<body>
	<div class="container-fluid px-0 main-body-warpper">
		<div class="main-content p-3">
			<div class="pages-all bg-white">
				<div class="row align-items-center border-bottom pb-2">
					<div class="col-6">
						<h5>Deduction Details:</h5>
					</div>
				</div>

				<div class="heading py-2 my-2 px-3">
					<h6 class="mb-0 font-weight-bold">View Deduction</h6>
				</div>
				<c:forEach items="${deductlist}" var="list">
					<table class="table table-custom table-details">
						<tr>
							<td>Emp Name</td>
							<td>${list.name}</td>
						</tr>
						<tr>
							<td>PF</td>
							<td>${list.pf}</td>
						</tr>
						<tr>
							<td>TDS</td>
							<td>${list.tds}</td>
						</tr>
						<tr>
							<td>Leave Deduction</td>
							<td>${list.leaveDeduct}</td>
						</tr>
						<tr>
							<td>Assets Deduction</td>
							<td>${list.assetDeduct}</td>
						</tr>
						<tr>
							<td>Month</td>
							<td>${list.month}</td>
						</tr>
						<tr>
							<td>Other</td>
							<td>${list.other}</td>
						</tr>
					</table>
				</c:forEach>
				<div class="w-100 text-right">
					<form name="cancelDeduct" method="POST" action="MainController">
						<input type="hidden" name="action" value="listDeduction">
		 				<a	href="javascript:document.cancelDeduct.submit()" class="btn btn-secondary mr-2">Cancel</a>
					</form>
				</div>

			</div>