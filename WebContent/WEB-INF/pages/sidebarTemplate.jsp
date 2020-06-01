<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <head>
    <title><c:out value="${pageTitle}"/></title>
    <%@ include file="/WEB-INF/pages/headerTemplate.jsp" %>
    </head>
	<body>
			<div class="slidbar">
                <ul class="list-unstyled py-3">
                    <li class="w-100 active">
                        
                        <a href="#" class="d-block py-2 px-4 text-secondary mb-0">
                            <span class="icon icon-home mr-3"></span>Dashboard
                        </a> 
                    </li>
                    <li class="w-100">
                        <a href="#" class="d-block py-2 px-4 text-secondary font-weight-medium mb-0">
                             <span class="icon icon-user mr-3"></span>Employee
                            <span class="crt"></span>
                        </a>
                        <div class="menu-dropdwon">
<!-- 							<form name="listEmployee" method="POST" action="MainController">
								<input type="hidden" name="action" value="listEmployee">
								<input type="hidden" name="list" value="Employee">
		 						<a	href="javascript:document.listEmployee.submit()" class="d-block py-2 px-4 text-secondary font-weight-medium mb-0">Employee</a>
							</form> -->
							<a	href="listEmployee" class="d-block py-2 px-4 text-secondary font-weight-medium mb-0">Employee</a>
<!-- 							<form name="listAsset" method="POST" action="MainController">
								<input type="hidden" name="action" value="listAsset">
                            	<a href="javascript:document.listAsset.submit()" class="d-block py-2 px-4 text-secondary font-weight-medium mb-0">
                                Assets
                            	</a>
                            </form> -->
                            <a href="listAsset" class="d-block py-2 px-4 text-secondary font-weight-medium mb-0">Assets</a>
                            <form name="listleave" method="POST" action="MainController" >
                            <input type="hidden" name="action" value="listLeave">
                            <a href="javascript:document.listleave.submit()" class="d-block py-2 px-4 text-secondary font-weight-medium mb-0">
                                Leave
                            </a>	
                            </form>
<!--                             <a href="#" class="d-block py-2 px-4 text-secondary font-weight-medium mb-0"> -->
<!--                                 Payroll -->
<!--                             </a> -->
                            <form name="salaryForm" method="POST" action="MainController">
                            	<input type="hidden" name="action" value="listSalary">
                            	<a href="javascript:document.salaryForm.submit()" class="d-block py-2 px-4 text-secondary font-weight-medium mb-0">
                                	Salary
                            	</a>
                            </form>
<!--                             <form name="listDeduction" method="post" action="MainController" > -->
<!--                             	<input type="hidden" name="action" value="listDeduction"> -->
<!--                             	<a href="javascript:document.listDeduction.submit()" class="d-block py-2 px-4 text-secondary font-weight-medium mb-0"> -->
<!--                                 	Deduction -->
<!--                             	</a>	 -->
<!--                             </form> -->
                           
<!--                            <form name="listAllowence" method="post" action="MainController" > -->
<!--                             	<input type="hidden" name="action" value="listAllow"> -->
<!--                             	<a href="javascript:document.listAllowence.submit()" class="d-block py-2 px-4 text-secondary font-weight-medium mb-0"> -->
<!--                                 	Allownce -->
<!--                             	</a>	 -->
<!--                             </form> -->
                            <form name="attendence" method="POST" action="MainController">
                            	<input type="hidden" name="action" value="attendence">
		 						<a	href="javascript:document.attendence.submit()" class="d-block py-2 px-4 text-secondary font-weight-medium mb-0">Attendence</a>
		 					</form>
		 					<form name="holidayForm" method="POST" action="MainController">
                            	<input type="hidden" name="action" value="listHolidays">
		 						<a	href="javascript:document.holidayForm.submit()" class="d-block py-2 px-4 text-secondary font-weight-medium mb-0">HoliDays</a>
		 					</form>
                        </div>
                        
                    </li>
                    <li class="w-100">
                        <a href="#" class="d-block py-2 px-4 text-secondary font-weight-medium mb-0">
                            <span class="icon icon-user-group mr-3"></span>Customer
                            <span class="crt"></span>
                        </a>
                    </li>
                    <li class="w-100">
                        <a href="#" class="d-block py-2 px-4 text-secondary font-weight-medium mb-0">
                            <span class="icon icon-supplier mr-3"></span>Supplier
                            <span class="crt"></span>
                        </a>
                    </li>
                    <li class="w-100">
                        <a href="#" class="d-block py-2 px-4 text-secondary font-weight-medium mb-0">
                            <span class="icon icon-sitemap mr-3"></span>Inventor
                            <span class="crt"></span>
                        </a>
                    </li>
                    <li class="w-100">
                        <a href="#" class="d-block py-2 px-4 text-secondary font-weight-medium mb-0">
                            <span class="icon icon-services mr-3"></span>Services
                            <span class="crt"></span>
                        </a>
                    </li>
                    <li class="w-100">
                        <a href="#" class="d-block py-2 px-4 text-secondary font-weight-medium mb-0">
                            <span class="icon icon-support mr-3"></span>Sales & Support
                            <span class="crt"></span>
                        </a>
                    </li>
                    <li class="w-100">
                        <a href="#" class="d-block py-2 px-4 text-secondary font-weight-medium mb-0">
                            <span class="icon icon-chart-bar mr-3"></span>Report
                            <span class="crt"></span>
                        </a>
<!--                         <div class="menu-dropdwon"> -->
<!--                             <a href="#" class="d-block py-2 px-4 text-secondary font-weight-medium mb-0"> -->
<!--                                 Employee -->
<!--                             </a> -->
<!--                             <a href="#" class="d-block py-2 px-4 text-secondary font-weight-medium mb-0"> -->
<!--                                 Assets -->
<!--                             </a> -->
<!--                             <a href="#" class="d-block py-2 px-4 text-secondary font-weight-medium mb-0"> -->
<!--                                 Leave -->
<!--                             </a> -->
<!--                             <a href="#" class="d-block py-2 px-4 text-secondary font-weight-medium mb-0"> -->
<!--                                 Payroll -->
<!--                             </a> -->
<!--                             <a href="#" class="d-block py-2 px-4 text-secondary font-weight-medium mb-0"> -->
<!--                                 Salary -->
<!--                             </a> -->
<!--                             <a href="#" class="d-block py-2 px-4 text-secondary font-weight-medium mb-0"> -->
<!--                                 Deduction -->
<!--                             </a> -->
<!--                             <a href="#" class="d-block py-2 px-4 text-secondary font-weight-medium mb-0"> -->
<!--                                 Allowance -->
<!--                             </a> -->
<!--                         </div> -->
                    </li>
                </ul>
            </div>
         <c:if test="${!empty responseMessage}">
			<c:if test="${responseType == 'success'}">
				<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
					<div class="modal-dialog modal-md">
					    <div class="modal-content">
					      <div class="modal-header">
					        <h5 class="modal-title" id="exampleModalLabel">Action Successful:</h5>
					        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
					          <span aria-hidden="true">&times;</span>
					        </button>
					      </div>
					      <div class="modal-body" align="center">
					       <img id="responseImage" src="images/checkMark.png" alt="response message" />
						   <p id="responseMessage"><br><c:out value="${responseMessage}" /></p>
					      </div>
					      <div class="modal-footer">
					        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
					      </div>
					    </div>
				  	</div>
				</div>
			</c:if>
			<c:if test="${responseType == 'fail'}">
				<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
					<div class="modal-dialog modal-md">
					    <div class="modal-content">
					      <div class="modal-header">
					        <h5 class="modal-title" id="exampleModalLabel">Action Failed:</h5>
					        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
					          <span aria-hidden="true">&times;</span>
					        </button>
					      </div>
					      <div class="modal-body" align="center">
					       <img id="responseImage" src="images/xMark.png" alt="response message" />
						   <p id="responseMessage"><br><c:out value="${responseMessage}" /></p>
					      </div>
					      <div class="modal-footer">
					        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
					      </div>
					    </div>
				  	</div>
				</div>
			</c:if>
			<c:if test="${responseType == 'info'}">
				<div id="exampleModal" class="modal fade" role="dialog" style="z-index: 1000000">
	  				<div class="modal-dialog modal-md">
	    				<!-- Modal content-->
	  					<div class="modal-content">
	    					<div class="modal-header">
	      						<button type="button" class="close" data-dismiss="modal">&times;</button>
	      						<h4 id="responseTitle" class="modal-title"></h4>
	    					</div>
	    					<div class="modal-body" align="center">
	      						<img id="responseImage" src="images/info.png" alt="response message" />
		       					 <p id="responseMessage"><br><c:out value="${responseMessage}" /></p>
	    					</div>
	    					<div class="modal-footer">
	      						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	    					</div>
	  					</div>
					</div>
				</div>
			</c:if>
  		<script>$("#exampleModal").modal("show");</script>
	</c:if>
	<c:remove var="responseMessage"/>
	<c:remove var="responseType"/>   
	</body>
</html>