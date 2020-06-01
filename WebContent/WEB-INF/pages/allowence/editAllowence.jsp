<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
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
						<h5>Edit Allowence</h5>
					</div>
				</div>
				<div class="add-details">
				<c:forEach items="${allowlist}" var="list">
					<form class="mb-0 px-3" action="MainController" name="editAllowence" method="post">
						<div class="row">
							<div class="col-12 heading py-2 my-2 mb-4 border-bottom">
								<h6 class="mb-0 font-weight-bold">Allowence Details:</h6>
							</div>
							<div class="col-6">
								<div class="form-group">
									<label for="code" class="d-block text-left">Employee Name</label>
									<input class="form-control" type="text" id="code" name="empname" value="${list.name}" disabled="disabled">
								</div>
							</div>
							<div class="col-6">
								<div class="form-group">
									<label for="code" class="d-block text-left">Fual</label> 
									<input class="form-control" type="text" id="code" name="fual" value="${list.fual}">
								</div>
							</div>
							<div class="col-6">
								<div class="form-group">
									<label for="code" class="d-block text-left">Over Time</label> 
									<input class="form-control" type="text" id="code" name="overtime" value="${list.overTime}">
								</div>
							</div>
							<div class="col-6">
								<div class="form-group">
									<label for="p-address" class="d-block text-left">Date</label>
									<div class="input-group date">
										<input type="text" class="form-control" id="datetimepicker5" aria-describedby="inputGroupPrepend3" name="date" value="${list.month}"> 
										<span class="input-group-append"> 
											<span class="input-group-text" id="inputGroupPrepend3">
										 		<span class="icon icon-calendar"></span>
											</span>
										</span>
									</div>
								</div>
							</div>
							
							<div class="col-12 text-right mt-3">
								<input type="hidden" name="action" value="editAllowence">
								<input type="hidden" name = "id" value="${list.id}">
								<input type="submit" class="btn btn-primary mr-2" value="Submit">
							
					</form>
					</c:forEach>
					<form class="d-inline-block" name="cancelform "	action="MainController" method="post">
						<input type="hidden" id="action" name="action" value="listAllow"> 
						<input type="submit" class="btn btn-secondary" value="Cancel" name="cancel">
					</form>
							</div>
				</div>
			</div>
		</div>
</body>
</html>