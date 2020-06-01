<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import = "java.io.*,java.util.*" %>
<%@ page import = "javax.servlet.*,java.text.*" %>

<html>
<head>
<title>DataTable</title>
<meta charset="utf-8">

<%@include file="/WEB-INF/pages/sidebarTemplate.jsp"%>
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css" type="text/css" />
<link rel="stylesheet" href=https://cdn.datatables.net/buttons/1.5.2/css/buttons.dataTables.min.css	type="text/css" />
<link rel="stylesheet" href="https://cdn.datatables.net/select/1.2.6/css/select.dataTables.min.css"	type="text/css" />
<link rel="stylesheet" href="https://editor.datatables.net/extensions/Editor/css/editor.dataTables.min.css"	type="text/css" />
<link rel="stylesheet" type="text/css" href="css/datatableCss.css">

<script type="text/javascript" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/buttons/1.5.2/js/dataTables.buttons.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/select/1.2.6/js/dataTables.select.min.js"></script>
<script src="js/salary.js"></script>
<script type="text/javascript">
function totalcount(){
		  var basic = document.getElementById('basic');
		  var total = document.getElementById('total');
		  total.value = basic.value;
			deduction();
		  
}
function deduction(){

	var total = document.getElementById('total');
	var net= document.getElementById('netSalary');
	var deduct = document.getElementById('leaveDeduct');
	net.value = total.value - deduct.value;
	
}
</script>

</head>

<body>
	<div class="container-fluid px-0 main-body-warpper">
		<div class="main-content p-3">
			<div class="pages-all bg-white">
				<div class="row align-items-center border-bottom pb-2">
					<div class="col-6">
						<h5>Salary List</h5>
					</div>
				</div>
				<form name="listsalry" action="MainController" method="post">
					<table id="listSalary" class="display" style="width: 100%">
						<thead>
							<tr class="selectRow">
								<th><input name="select_all" value="1" id="select-all" type="checkbox" /></th>
								<th>EmpName</th>
								<th>Current Salary</th>
								<th>Payment Mode</th>
								<th>Date</th>
								<th>
									<input type="hidden" name="action" value="verifyall">
									<input type="submit" id="select" style="display: none" value="VerifyAll" class="btn btn-primary">
								</th>
							</tr>
						</thead>
					</table>
				</form>
				<c:forEach items="${salaryList}" var="list">
					<div class="modal fade salary${list.id}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
						<div class="modal-dialog modal-dialog-centered modal-lg" role="document">
							<div class="modal-content">
								<div class="modal-header d-block border-0 text-center pb-0">
									<h5	class="modal-title d-flex justify-content-center w-100 mb-2" id="exampleModalLabel">
										<a href="#"><img src="images/logo2.png" class="img-fluid" alt="" /></a>
									</h5>
									<p class="w-50 mx-auto mb-0">Yash Plaza, U-2, Ashirwad Complex, Opp. Dhanamal Mill, Nr, Varachha Main Rd, Surat, Gujarat 395006</p>
								</div>
								<div class="modal-body p-0 pt-2">
									<div class="text-center">
										<h5 class="font-weight-bold">
											Salary Slip
											</h5>
									</div>
									<div class="px-4 d-flex justify-content-between">
										<ul class="list-unstyled">
											<li class="mb-1"><b>Employee Name:</b> ${list.name}</li>
											<li class="mb-1"><b>Designation:</b> ${list.designation}</li>
											<li class="mb-1"><b>Emp Code:</b> ${list.empCode}</li>
											<li class="mb-1"><b>Leave Adjusted:</b> ${list.noofLeaveDays}</li>
											<li class="mb-1"><b>PF No:</b> 9876543</li>
										</ul>
										<ul class="list-unstyled">
											<li class="mb-1"><b>Date:</b>
											<%
         										Date dNow = new Date( );
         										SimpleDateFormat ft = new SimpleDateFormat ("dd-MMM-yyyy");
         										out.print(ft.format(dNow));
      										%>
											</li>
											<li class="mb-1"><b>Month & Year:</b> ${list.month}</li>
											<li class="mb-1"><b>Payment Type:
											<select name="paymentTypeOption" id="paymentTypeOption">
												<option value="bank">Bank</option>
												<option value="cash">Cash</option>
												<option value="cheque">Cheque</option>
											</select> 
											<input type="text" name="chequeNo" id="chequeNo" style="visibility:hidden;"/>
<%-- 											</b> ${list.paymentType}</li> --%>
											<li class="mb-1"><b>Paid Days:</b> ${list.noofWorkingDays}</li>
											<li class="mb-1"><b>ESIC No: </b> 3456754</li>
										</ul>
									</div>
									<table class="table table-custom custom-salary-slip mb-2">
										<tr>
											<th class="w-50">Earnings
											</td>
											<th class="w-50">Deductions
											</td>
										</tr>
										<tr>
											<td>
												<div class="d-flex justify-content-between">
													<span>Basic & HRA</span>
													<span><input type="text" class="from-control border-0 text-right salary_list" name="hra" id="basic" value="${list.salary}"/></span>
												</div>
											</td>
											<td>
												<div class="d-flex justify-content-between">
													<span>PF</span> <span>00</span>
												</div>
											</td>
										</tr>
										<tr>
											<td>
												<div class="d-flex justify-content-between">
													<span>Fuel Expense</span> <span>00</span>
												</div>
											</td>
											<td>
												<div class="d-flex justify-content-between">
													<span>ESIC</span> <span>00</span>
												</div>
											</td>
										</tr>
										<tr>
											<td>
												<div class="d-flex justify-content-between">
													<span>Overtime</span> <span>00</span>
												</div>
											</td>
											<td>
												<div class="d-flex justify-content-between">
													<span>TDS</span> <span>00</span>
												</div>
											</td>
										</tr>
										<tr>
											<td></td>
											<td>
												<div class="d-flex justify-content-between">
													<span>Leaves Deduction</span> 
													<span><input type="text" class="from-control border-0 text-right leaveDeduct" name = "deduct" id="leaveDeduct" value="${list.leaveDeduction}" onkeyup="deduction()"/></span>
												</div>
											</td>
										</tr>
										<tr>
											<td></td>
											<td>
												<div class="d-flex justify-content-between">
													<span>Assets Deduction</span> <span>00</span>
												</div>
											</td>
										</tr>
										<tr>
											<td></td>
											<td>
												<div class="d-flex justify-content-between">
													<span>Other</span> <span>00</span>
												</div>
											</td>
										</tr>
										<tr>
											<td>
												<div class="d-flex justify-content-between font-weight-bold">
													<span>Total</span>
													<span><input type="text" class="from-control border-0 text-right subTotal" id="total" value="${list.salary}" readonly="readonly"/></span>
												</div>
											</td>
											<td>
												<div class="d-flex justify-content-between font-weight-bold">
													<span>Net Salary</span>
													<c:set var="total" value="${list.salary}"></c:set>
													<c:set var="leave" value="${list.leaveDeduction}"/>
													<span><input type="text" class="from-control border-0 text-right finalTotalSalary"  name=" net" id="netSalary" value="${list.netSalary}" readonly="readonly"/></span>
												
												</div>
											</td>
										</tr>
									</table>
									<p class="mb-0 text-danger pl-4">*If you are save this then this record can not be chnaged by Admin or HR.</p>
								</div>
								<div class="modal-footer border-0 pt-0">
									<button type="button" class="btn btn-primary" name="verify" id="saveVerify" value="${list.id}">Save</button>
									<button type="button" class="btn btn-secondary"	data-dismiss="modal">Cancel</button>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</body>

</html>