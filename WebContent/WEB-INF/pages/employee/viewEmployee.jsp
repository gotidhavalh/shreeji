<%@page import="main.scs.dao.DBConnection"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.Import"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
						<h5>View Employee</h5>
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
					<h6 class="mb-0 font-weight-bold">Personal Detail:</h6>
				</div>
				<table class="table table-custom table-details">
					<c:forEach items="${list}" var="list">
						<tr>
							<td>Employee code</td>
							<td>${list.empCode}</td>
						</tr>
						<tr>
							<td>First Name</td>
							<td>${list.firstName}</td>
						</tr>
						<tr>
							<td>Last Name</td>
							<td>${list.lastName}</td>
						</tr>
						
						<tr>
							<td>Phone Number</td>
							<td>${list.phoneNumber}</td>
						</tr>
						<tr>
							<td>Alternate Phone Number</td>
							<td>${list.alternativePhoneNumber}</td>
						</tr>
						<tr>
							<td>Email Address</td>
							<td>${list.email}</td>
						</tr>
						<tr>
							<td>Company Email Address</td>
							<td>${list.companyEmail}</td>
						</tr>
						<tr>
							<td>Education/Qualification</td>
							<td>${list.education}</td>
						</tr>
						<tr>
							<td>Gender</td>
							<td>${list.gender}</td>
						</tr>
						<tr>
							<td>Current Address</td>
							<td>${list.cAddress}</td>
						</tr>
						<tr>
							<td>Permanent Address</td>
							<td>${list.pAddress}</td>
						</tr>
						<tr>
							<td>Resident Proof</td>
<!-- 							<td><img src="images/pdf.png" alt="" class="mr-2" /> -->
<!-- 								Residentproof.pdf</td> -->
							<td>
							<form name="ResidentProof" method="POST" action="MainController">
								<input type="hidden" name="action" value="ProofDownload">
								<input type="hidden" name="proofType" value="ResidentProof">
								<input type="hidden" name="EmpCode" value="<c:out value ="${list.empCode}"/>">
		 						<a	href="javascript:document.ResidentProof.submit()" class="btn btn-secondary mr-2">ResidentProof.pdf</a>
							</form>
							</td>
						</tr>
						<tr>
							<td>Employee Image</td>
							<td>
								<div class="avtar-detail">
								<img  src="images/emp${list.empCode}.jpg" alt="">
								</div></td>
						</tr>
					</c:forEach>
				</table>
				<div class="heading py-2 my-2 mb-4 border-bottom px-3">
					<h6 class="mb-0 font-weight-bold">Other Information:</h6>
				</div>
				<table class="table table-custom table-details">
				<c:forEach items="${list}" var="list">
					<tr>
						<td>PAN Card Number</td>
						<td class="d-flex align-items-center justify-content-between">
							<p class="mb-0">${list.panCard}</p>
							<p class="mb-0">
							<form name="PANProof" method="POST" action="MainController">
								<input type="hidden" name="action" value="ProofDownload">
								<input type="hidden" name="proofType" value="PANProof">
								<input type="hidden" name="EmpCode" value="<c:out value ="${list.empCode}"/>">
		 						<a	href="javascript:document.PANProof.submit()" class="btn btn-secondary mr-2">PANCard.pdf</a>
							</form>
							</p>
						</td>
					</tr>
					<tr>
						<td>Aadhaar Card Number</td>
						<td class="d-flex align-items-center justify-content-between">
							<p class="mb-0">${list.adharCard}</p>
							<p class="mb-0">
							<form name="AadharProof" method="POST" action="MainController">
								<input type="hidden" name="action" value="ProofDownload">
								<input type="hidden" name="proofType" value="AadharProof">
								<input type="hidden" name="EmpCode" value="<c:out value ="${list.empCode}"/>">
		 						<a	href="javascript:document.AadharProof.submit()" class="btn btn-secondary mr-2">Aadhaarcard.pdf</a>
							</form>
							</p>
						</td>
					</tr>
					<tr>
						<td>Driving Licence Number</td>
						<td class="d-flex align-items-center justify-content-between">
							<p class="mb-0">${list.licence}</</p>
							<p class="mb-0">
							<form name="DrivingLicenseProof" method="POST" action="MainController">
								<input type="hidden" name="action" value="ProofDownload">
								<input type="hidden" name="proofType" value="DrivingLicenseProof">
								<input type="hidden" name="EmpCode" value="<c:out value ="${list.empCode}"/>">
		 						<a	href="javascript:document.DrivingLicenseProof.submit()" class="btn btn-secondary mr-2">DrivingLicence.pdf</a>
							</form>
							</p>
						</td>
					</tr>
					</c:forEach>
				</table>
				
				<div class="heading py-2 my-2 mb-4 border-bottom px-3">
					<h6 class="mb-0 font-weight-bold">Bank Details:</h6>
				</div>
				<table class="table table-custom table-details">
					<c:forEach items="${list}" var="list">
					<tr>
						<td>Holder Name</td>
						<td>${list.holderName}</td>
					</tr>
					<tr>
						<td>Account Number</td>
						<td>${list.accountNumber}</td>
					</tr>
					<tr>
						<td>Bank Name</td>
						<td>${list.bankName}</td>
					</tr>
					<tr>
						<td>IFSC Code</td>
						<td>${list.IFSC}</td>
					</tr>
					<tr>
						<td>Account Type</td>
						<td>${list.accountType}</td>
					</tr>
					<tr>
						<td>Payment Type</td>
						<td>${list.paymentType}</td>
					</tr>
					</c:forEach>
					</table>
				
				
				<div class="heading py-2 my-2 mb-4 border-bottom px-3">
					<h6 class="mb-0 font-weight-bold">Company Details:</h6>
				</div>
				<table class="table table-custom table-details">
					<c:forEach items="${list}" var="list">
					<tr>
						<td>Joing Date</td>
						<fmt:formatDate value="${list.joinDate}" pattern="dd/MM/yyyy" var="joinDate" />
						<td>${list.joinDate}</td>
					</tr>
					<tr>
						<c:forEach items="${listDesingation}" var="listdes">
						<td>Designation</td>
						<td>${listdes.designationDesc}</td>
						</c:forEach>
					</tr>
					<tr>
						<td>Current Salary</td>
						<td>${list.currentSalary}</td>
					</tr>
					<tr>
						<td>Next Increment</td>
						<fmt:formatDate value="${list.nextIncrement}" pattern="dd/MM/yyyy" var="nextIncrement" />
						<td>${list.nextIncrement}</td>
					</tr>
					<tr>
						<td>User Name</td>
						<td>${list.username}</td>
					</tr>
					</c:forEach>
					</table>
					
				<div class="w-100 text-right">
						<form name="listEmployee1" method="POST" action="MainController">
								<input type="hidden" name="action" value="listEmployee">
		 						<a	href="javascript:document.listEmployee1.submit()" class="btn btn-secondary mr-2">Cancel</a>
							</form>
					</div>
			</div>
		</div>
	</div>
</body>
</html>