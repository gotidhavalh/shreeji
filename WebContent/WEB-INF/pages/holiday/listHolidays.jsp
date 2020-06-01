<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Holidays</title>
<%@include file="/WEB-INF/pages/sidebarTemplate.jsp"%>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.9.1/themes/base/jquery-ui.css" />
<script src="http://code.jquery.com/ui/1.9.1/jquery-ui.js"></script>
<!-- <link rel="stylesheet" href="css/fonts.css" type="text/css">  -->
<script>
$(function() { 
    $("#datepickerYear").datepicker({changeYear: true,dateFormat: 'yy' });
    $("#datepickerYear").keyup(function(){
    	var date = $(this).val();
    	
    	$.ajax({
//     		url : 
    	});
    });
});
</script>
</head>
<body>
	<div class="container-fluid px-0 main-body-warpper">
		<div class="main-content p-3">
			<div class="pages-all bg-white">
				<div class="row align-items-center border-bottom pb-2">
					<div class="col-6">
						<h5>Holidays</h5>
						<nav aria-label="breadcrumb">
							<ol class="breadcrumb mb-0">
								<li class="breadcrumb-item"><a href="#"
									class="text-secondary">Home</a></li>
								<li class="breadcrumb-item active" aria-current="page">Holiday</li>
							</ol>
						</nav>
					</div>
					<div class="col-6 text-right">
					<form name="holidayForm" action="MainController" method="get">
						<input type="hidden" name="action" value="addHolidaysForm">
						<input type="submit" name="add" value="Add Holiday" class="btn btn-primary">
					</form>
					</div>
				</div>
				<div class="w-100 py-4">
				<input type="text" id="datepickerYear"/>
<!-- 					<select class="custom-select w-auto"> -->
<!-- 						<option>2018</option> -->
<!-- 						<option>2017</option> -->
<!-- 						<option>2016</option> -->
<!-- 						<option>2015</option> -->
<!-- 						<option>2014</option> -->
<!-- 					</select> -->
				</div>
				
				<table class="table table-custom mb-0">
					<thead>
						<tr>
							<th>Day</th>
							<th>Holiday Name</th>
							<th>Date</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${holiDayList}" var="list">
						<tr class="past-holiday">
							<td>${list.day}</td>
							<td>${list.holiDayName}</td>
							<td>${list.date}</td>
							<td>
								<form name="editform" action="MainController" method="post" class="d-inline">
									<button type="submit" class="btn btn-default">
										<span class="icon icon-eye">
										</span>
										<input type="hidden" name="action" value="viewHoliDays"/>
										<input type="hidden" name="id" value="${list.id}" />
									</button>
								</form>
								
								<form name="deleteform" action="MainController" method="post" class="d-inline">
									<button type="submit" class="btn btn-default d-inline">
										<span class="icon icon-delete">
										</span>
										<input type="hidden" name="action" value="deleteHoliday" />
										<input type="hidden" name="id" value="${list.id}" />
									</button>
								</form>
<!-- 								<a href="#" class="text-secondary mr-3"> -->
<!-- 									<span class="icon icon-eye"> -->
<!-- 									</span> -->
<!-- 								</a>  -->
<!-- 								<a href="#"	class="text-secondary mr-3"> -->
<!-- 									<span class="icon icon-delete"> -->
<!-- 									</span> -->
<!-- 								</a> -->
							</td>
						</tr>
					</c:forEach>
						
					</tbody>
				</table>

			</div>
		</div>
	</div>
</body>
</html>