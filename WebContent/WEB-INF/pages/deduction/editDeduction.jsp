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
						<h5>Modify Dedection</h5>
					</div>
				</div>
				<div class="add-details">
					<form class="mb-0 px-3" action="MainController" name="addDeduction" method="post">
						<c:forEach items="${deductlist}" var="list">
						<div class="row">
							<div class="col-12 heading py-2 my-2 mb-4 border-bottom">
								<h6 class="mb-0 font-weight-bold">Edit Deduction</h6>
							</div>
							<div class="col-6">
								<div class="form-group">
									<label for="code" class="d-block text-left">Employee Name</label>
									<input class="form-control" type="text" id="code" name="empName" value="${list.name}" disabled="disabled"> 
								</div>
							</div>
							<div class="col-6">
								<div class="form-group">
									<label for="code" class="d-block text-left">PF</label> 
									<input class="form-control" type="text" id="code" name="pf" value="${list.pf}">
								</div>
							</div>
							<div class="col-6">
								<div class="form-group">
									<label for="code" class="d-block text-left">TDS</label> 
									<input class="form-control" type="text" id="code" name="tds" value="${list.tds}">
								</div>
							</div>
							<div class="col-6">
								<div class="form-group">
									<label for="code" class="d-block text-left">Leave Deduction</label> 
									<input class="form-control" type="text" id="code" name="leaveDeduct" value="${list.leaveDeduct}">
								</div>
							</div>
							<div class="col-6">
								<div class="form-group">
									<label for="code" class="d-block text-left">Assets Deduction</label> 
									<input class="form-control" type="text" id="code" name="assetDeduct" value="${list.assetDeduct}">
								</div>
							</div>
							<div class="col-6">
								<div class="form-group">
									<label for="p-address" class="d-block text-left">Month</label>
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
							<div class="col-6">
								<div class="form-group">
									<label for="code" class="d-block text-left">Other</label> 
									<input	class="form-control" type="text" id="code" name="other" value="${list.other}">
								</div>
							</div>
							<div class="col-12 text-right mt-3">
								<input type="hidden" name="action" value="editDeduct">
								<input type="hidden" name="id" value="${list.id}">
								<input type="submit" class="btn btn-primary mr-2" value="Submit">
						</c:forEach>	
					</form>
					<form class="d-inline-block" name="cancelform "	action="MainController" method="post">
						<input type="hidden" id="action" name="action" value="listDeduction"> 
						<input type="submit" class="btn btn-secondary" value="Cancel" name="cancel">
					</form>
							</div>
				</div>
			</div>
		</div>
</body>
</html>