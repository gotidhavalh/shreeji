<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Attendence</title>
<%@include file="/WEB-INF/pages/sidebarTemplate.jsp"%>
<script src="js/employee.js"></script>
</head>
<body>
	<div class="container-fluid px-0 main-body-warpper">
		<div class="main-content p-3">
			<div class="pages-all bg-white">
				<div class="row align-items-center border-bottom pb-2">
					<div class="col-6">
						<h5>Asset List</h5>
						<nav aria-label="breadcrumb">
							<ol class="breadcrumb mb-0">
								<li class="breadcrumb-item"><a href="#"
									class="text-secondary">Home</a></li>
								<li class="breadcrumb-item active" aria-current="page">Asset</li>
							</ol>
						</nav>
					</div>
				</div>

				<form name="form1" id="form1" action="MultipartController" method="post" enctype="multipart/form-data">
					
					<input type="hidden" name="action" value="addattendence">
					Files to upload:
					<input type="file" size="50" name="csv"	id="fileUpload">
					<span id="lblError" style="color: red;"></span>
					<br /> 
					<input type="submit" value="Upload" id="btnUpload">
				</form>
			</div>
		</div>
	</div>
</body>
</html>