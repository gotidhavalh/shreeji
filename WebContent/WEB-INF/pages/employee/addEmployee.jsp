<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
 <!DOCTYPE html>
<html>
    <head>
        <title>Add Employee</title>
		<%@include file="/WEB-INF/pages/sidebarTemplate.jsp"%>
        <script type="text/javascript"  src="js/fileupload.js"></script>
        <script type="text/javascript" src="js/employee.js"></script>
    </head>
    <body>
    	<div class="container-fluid px-0 main-body-warpper">	
            <div class="main-content p-3">
                <div class="pages-all bg-white">
                    <div class="row align-items-center border-bottom pb-2">
                        <div class="col-6">
                            <h5>Add Employee</h5>
                            <nav aria-label="breadcrumb">
                                <ol class="breadcrumb mb-0">
                                    <li class="breadcrumb-item"><a href="#" class="text-secondary">Home</a></li>
                                    <li class="breadcrumb-item"><a href="#" class="text-secondary">Employee</a></li>
                                    <li class="breadcrumb-item active" aria-current="page">Add Employee</li>
                                </ol>
                            </nav>
                        </div> 
                    </div>
                    <div class="add-details">
                        <form name="addEmp" action="MultipartController" enctype="multipart/form-data" method="post" class="mb-0 px-3">
                            <div class="row">
                                <div class="col-12 heading py-2 my-2 mb-4 border-bottom">
                                    <h6 class="mb-0 font-weight-bold">Personal Detail:</h6>
                                </div>
                                <div class="col-12">
                                    <div class="form-group">
                                        <label for="code" class="d-block text-left">Employee code</label>
                                        <label for="code" class="d-block text-left" id="Error1"></label>
                                        <input class="form-control" type="text" id="code" name="empCode" required="required">
                                    </div>
                                </div>
                                 
                                <div class="col-6">
                                    <div class="form-group">
                                        <label for="f-name" class="d-block text-left">First Name</label>
                                        <input class="form-control" type="text" id="code" name="firstName" required="required">
                                    </div>
                                </div>
                                <div class="col-6">
                                    <div class="form-group">
                                        <label for="l-name" class="d-block text-left">Last Name</label>
                                        <input class="form-control" type="text" id="code" name="lastName" required="required"">
                                    </div>
                                </div>
                                <div class="col-6">
                                    <div class="form-group">
                                        <label for="code" class="d-block text-left">Phone Number</label>
                                        <input class="form-control" type="text" id="code" name="phoneNumber" required="required" onkeypress="return isNumber(event)">
                                    </div>
                                </div>
                                <div class="col-6">
                                    <div class="form-group">
                                        <label for="code" class="d-block text-left">Alternate Phone Number</label>
                                        <input class="form-control" type="text" id="code" name="alternativeNumber" onkeypress="return isNumber(event)">
                                    </div>
                                </div>
                                <div class="col-6">
                                    <div class="form-group">
                                        <label for="code" class="d-block text-left">Email Address</label>
                                        <input class="form-control" type="email" id="code" name="Email" required="required">
                                    </div>
                                </div>
                                <div class="col-6">
                                    <div class="form-group">
                                        <label for="code" class="d-block text-left">Company Email Address</label>
                                        <input class="form-control" type="email" id="code" name="companyEmail">
                                    </div>
                                </div>
                                <div class="col-6">
                                    <div class="form-group">
                                        <label for="code" class="d-block text-left">Education/Qualification</label>
                                        <input class="form-control" type="text" id="code" name="education">
                                    </div>
                                </div>
                                <div class="col-6">
                                    <div class="form-group">
                                        <label for="gender" class="d-block text-left">Gender</label>
                                        <select class="custom-select form-control" name="gender" required="required">
                                            <option value="male">Male</option>
                                            <option value="female">FeMale</option>
                                        </select>
                                   </div>
                                </div> 
                                <div class="col-6">
                                    <div class="form-group">
                                        <label for="c-address" class="d-block text-left">Current Address</label>
                                        <textarea class="form-control" id="c-address" rows="3" name="currentAddress"></textarea>
                                    </div>
                                </div>
                                <div class="col-6">
                                    <div class="form-group">
                                        <label for="p-address" class="d-block text-left">Permanent Address</label>
                                        <textarea class="form-control" id="p-address" rows="3" name="permanentAddress" required="required"></textarea>
                                    </div>
                                </div>
                              
                                <div class="col-6">
                                    <div class="form-group">
                                        <p class="d-block text-left mb-1">Employee Image</p>
                                        <div class="">
                                            <div class="avtar-file">
                                                <img src="images/default-user.jpg" alt="" class="w-100 h-100 object-fit" id="empImage" name="empImage1"/>
                                            </div>
                                            <div class="file-uploard">
                                                <label class="custom-file" id="customFile">
                                                    <input type="file" class="custom-file-input" id="empImageName" aria-describedby="fileHelp" name="empImage" accept="image/x-png,image/gif,image/jpeg">
                                                    <span class="btn btn-secondary">Upload Image</span>
                                                </label>
                                            </div>
                                        </div>
                                        <p class="mb-0 mt-2">(Max 2MB Allowed)</p>
                                    </div>
                                </div>
                                <div class="col-6">
                                    <div class="form-group">
                                        <label for="p-address" class="d-block text-left">Resident Proof</label>
                                        <input class="form-control" type="file" id="residentPDF" name="residentPdf">
                                    </div>
                                </div>
                                
                                <!--  OTHER INFORMATION-->
                                
                                <div class="col-12 heading py-2 my-2 mb-4 border-bottom">
                                    <h6 class="mb-0 font-weight-bold">Other Information:</h6>
                                </div>
                                <div class="col-6">
                                    <div class="form-group mb-2">
                                        <label for="p-address" class="d-block text-left">PAN Card Number</label>
                                        <input class="form-control" type="text" id="panNumber" name="panNumber">
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" type="file" id="code" name="panPdf">
                                    </div>
                                </div>
                                <div class="col-6">
                                    <div class="form-group mb-2">
                                        <label for="p-address" class="d-block text-left">Aadhaar Card Number</label>
                                        <input class="form-control" type="number" id="adharNumber" name="adharNumber" required="required" onkeypress="return isNumber(event)">
                                        
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" type="file" id="code" name="adharPdf">
                                    </div>
                                </div>
                                <div class="col-6">
                                    <div class="form-group mb-2">
                                        <label for="p-address" class="d-block text-left">Driving Licence Number</label>
                                        <input class="form-control" type="text" id="licenceNumber" name="licenceNumber">
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" type="file" id="code" name="licencePdf">
                                    </div>
                                </div>
                                
                                <!-- BANK DETAILS -->
                                
                                
                                <div class="col-12 heading py-2 my-2 mb-4 border-bottom">
                                    <h6 class="mb-0 font-weight-bold">Bank Detail:</h6>
                                </div>
                                <div class="col-6">
                                    <div class="form-group">
                                        <label for="code" class="d-block text-left">Account Holder Name</label>
                                        <input class="form-control" type="text" id="code" name="holderName">
                                    </div>
                                </div>
                                <div class="col-6">
                                    <div class="form-group">
                                        <label for="code" class="d-block text-left">Account Number</label>
                                        <input class="form-control" type="text" id="code" name="accountNumber">
                                    </div>
                                </div>
                                <div class="col-6">
                                    <div class="form-group">
                                        <label for="code" class="d-block text-left">Bank Name</label>
                                        <input class="form-control" type="text" id="code" name="bankName">
                                    </div>
                                </div>
                                <div class="col-6">
                                    <div class="form-group">
                                        <label for="code" class="d-block text-left">IFSC Code</label>
                                        <input class="form-control" type="text" id="code" name="ifsc">
                                    </div>
                                </div>
                                <div class="col-6">
                                    <div class="form-group">
                                        <label for="gender" class="d-block text-left">Account Type</label>
                                        <select class="custom-select form-control" name="accountType">
                                            <option value="saving">Saving</option>
                                            <option value="current">Current</option>
                                        </select>
                                   </div>
                                </div>
                                <div class="col-6">
                                    <div class="form-group">
                                        <label for="gender" class="d-block text-left">Payment Type</label>
                                        <select class="custom-select form-control" name="paymentType">
                                            <option value="cash">Cash</option>
                                            <option value="check">Check</option>
                                            <option value="bank">Bank</option>
                                        </select>
                                   </div>
                                </div>
                                
                                <!-- COMPANY DETAILS -->
                                
                                <div class="col-12 heading py-2 my-2 mb-4 border-bottom">
                                    <h6 class="mb-0 font-weight-bold">Company Detail:</h6>
                                </div>
                                <div class="col-6">
                                    <label for="p-address" class="d-block text-left">Joining Date</label>
                                    <div class='input-group date'>
                                        <input type='text' class="form-control" id='datetimepicker1' aria-describedby="inputGroupPrepend2" name="joinDate" required="required"/>
                                        <span class="input-group-append">
                                            <span class="input-group-text" id="inputGroupPrepend2">
                                                <span class="icon icon-calendar"></span>

                                            </span>
                                        </span>
                                    </div>
                                </div>
                                <div class="col-6">
                                    <div class="form-group">
                                        <label for="p-address" class="d-block text-left">Current Salary</label>
                                        <input class="form-control" type="text" id="code" name="currSalary">
                                    </div>
                                </div>
                                <div class="col-6">
                                    <div class="form-group">
                                        <label for="p-address" class="d-block text-left">Next Increment</label>
                                        <div class='input-group date'>
                                            <input type='text' class="form-control" id='datetimepicker2' aria-describedby="inputGroupPrepend3" name="nextIncrement"/>
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
                                        <label for="p-address" class="d-block text-left">Designation</label>
                                        <select class="custom-select form-control" name="designation" required="required">
                                            
                                            <option value="0">Select Superior Name</option>
                                        <c:forEach items="${listDesignation}" var="listDesignation">
 	                                        <option value="${listDesignation.ID}">${listDesignation.designation}</option>
                                        </c:forEach>
                                        </select>
                                   </div>
                                </div>
                                <div class="col-6">
                                    <div class="form-group">
                                        <label for="p-address" class="d-block text-left">Username</label>
                                        <input class="form-control" type="text" id="userName" name="username" required="required">
                                    </div>
                                </div>
                                <div class="col-6">
                                    <div class="form-group">
                                        <label for="p-address" class="d-block text-left">Password</label>
                                        <input class="form-control" type="password" id="code" name="password" required="required">
                                    </div>
                                </div>
                                <div class="col-6">
                                	<label for="username" class="d-block text-left" id="divElement" name="user"></label>
                                </div>
                                <div class="col-12 text-right mt-3">
                                    <input type="hidden" name="action" value="addEmployee">
                                    <input type="submit" class="btn btn-primary mr-2" value="Submit">
	                        	</form>
	                        	<form class="d-inline-block" name="cancelform " action="MainController" method="post">
                                     <input type="hidden" id="action" name="action" value="listEmployee">
                                     <input type="submit" class="btn btn-secondary" value="Cancel" name="cancel">
                                </form>  
                                </div>
                            </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>