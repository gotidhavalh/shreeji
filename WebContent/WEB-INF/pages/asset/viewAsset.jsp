<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>View</title>
<%@include file="/WEB-INF/pages/sidebarTemplate.jsp"%>
</head>
<body>
	<div class="main-content p-3">
		<div class="pages-all bg-white">
			<div class="row align-items-center border-bottom pb-2">
				<div class="col-6">
					<h5>View Asset</h5>
					<nav aria-label="breadcrumb">
						<ol class="breadcrumb mb-0">
							<li class="breadcrumb-item"><a href="#"
								class="text-secondary">Home</a></li>
							<li class="breadcrumb-item active" aria-current="page">Employee</li>
						</ol>
					</nav>
				</div>
			</div>
			<div class="heading py-2 my-2 mb-4 border-bottom px-3">
				<h6 class="mb-0 font-weight-bold">Asset Detail:</h6>
			</div>
			<table class="table table-custom table-details">
				<c:forEach items="${assetList}" var="list">
					<tr>
						<td>Assets Name</td>
						<td>${list.name}</td>
					</tr>
					<tr>
						<td>Holder Name</td>
						<td>${list.holderName}</td>
					</tr>
					<tr>
						<td>SKU</td>
						<td>${list.sku}</td>
					</tr>
					<tr>
						<td>Assets Detail</td>
						<td>${list.description}</td>
					</tr>
					<tr>
						<td>Assets Image</td>
						<td>
							<div class="avtar-detail">
								<img src="images/Asset_${list.id}.jpg" alt="">
							</div>
						</td>
					</tr>
				</c:forEach>
			</table>
			<div class="w-100 text-right">
				<!--                         <a href="#" class="btn btn-primary mr-2">Edit</a> -->
				<!--                         <a href="#" class="btn btn-secondary">Cancel</a> -->
				<form class="d-inline-block" name="cancelform "
					action="MainController" method="post">
					<input type="hidden" id="action" name="action" value="listAsset">
					<input type="submit" class="btn btn-secondary" value="Cancel"
						name="cancel">

				</form>
			</div>
		</div>
	</div>
	</div>
</body>
</html>