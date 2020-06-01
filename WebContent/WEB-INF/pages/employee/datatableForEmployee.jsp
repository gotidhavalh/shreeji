<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Employee List</title>
<meta charset="utf-8">

<%@include file="/WEB-INF/pages/sidebarTemplate.jsp"%>
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css"
	type="text/css" />
<link rel="stylesheet"
	href="https://cdn.datatables.net/buttons/1.5.2/css/buttons.dataTables.min.css"
	type="text/css" />
<link rel="stylesheet"
	href="https://cdn.datatables.net/select/1.2.6/css/select.dataTables.min.css"
	type="text/css" />
<link rel="stylesheet"
	href="https://editor.datatables.net/extensions/Editor/css/editor.dataTables.min.css"
	type="text/css" />

<link rel="stylesheet" type="text/css" href="css/datatableCss.css">


<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js">
</script>
<script type="text/javascript"
	src="https://cdn.datatables.net/buttons/1.5.2/js/dataTables.buttons.min.js">
	
</script>
<script type="text/javascript"
	src="https://cdn.datatables.net/select/1.2.6/js/dataTables.select.min.js">
	
</script>
<script src="js/employee.js"></script>
</head>

<body>
<div class="container-fluid px-0 main-body-warpper">
	<div class="main-content p-3">
		<div class="pages-all bg-white">
			<div class="row align-items-center border-bottom pb-2">
            	<div class="col-6">
                <h5>Employee list</h5>
                </div>
                <div class="col-6 text-right">
                	    <form name="addAsset" action="MainController" method="post">
                        	<input type="hidden" name="action" value="designation">
                        	<input type="hidden" name="designation" value="Designation">
                        	<input type="submit" name="employee" class="btn btn-primary" value="Add Employee">
                        </form>
                </div>
            </div>
			<table id="example" class="display" >
				<thead>
					<tr>
						<th>Employee Code</th>
						<th>Name</th>
						<th>Phone Number</th>
						<th>Actions</th>
				</thead>
			</table>
		</div>
	</div>
</div>
</body>

</html>