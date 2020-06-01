<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<html>
    <head>
    
        <title>Leave</title>
        <meta charset="utf-8">
		<%@include file="/WEB-INF/pages/sidebarTemplate.jsp"%>
		<meta http-equiv='cache-control' content='no-cache'>
		<meta http-equiv='expires' content='0'>
		<meta http-equiv='pragma' content='no-cache'>
    </head>
    <body>   
<div class="container-fluid px-0 main-body-warpper">
            <div class="main-content p-3">
                <div class="pages-all bg-white">
                    <div class="row align-items-center border-bottom pb-2">
                        <div class="col-6">
                            <h5>Leave</h5>
                            <nav aria-label="breadcrumb">
                                <ol class="breadcrumb mb-0">
                                    <li class="breadcrumb-item"><a href="#" class="text-secondary">Home</a></li>
                                    <li class="breadcrumb-item active" aria-current="page">Leave</li>
                                </ol>
                            </nav>
                        </div>
                        <div class="col-6 text-right">
                        <form name="addLeave" action="MainController" method="post">
                            <input type="submit" class="btn btn-primary" value="ADD Leave">
                            <input type="hidden" name="action" value="designation">
                            <input type="hidden" name="designation" value="leave">
                        </form>
                        </div>
                    </div>
                    <table class="table table-custom mt-4">
                        <thead>
                            <tr>
                                <th>Emp Name<a href="#" class="ml-1 text-secondary d-inline-block align-middle"><span class="icon icon-arrow-new"></span></a></th>
                                <th>From Date</th>
                                <th>To Date</th>
                                <th>Leave Approved Name</th>
                                <th>Status</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${leavelist}" var="leavelist">
                        
                            <tr>
								<td>${leavelist.empName}</td>
                                <td>${leavelist.fromDate}</td>
                                <td>${leavelist.toDate}</td>
                                <td>${leavelist.approverName}</td>
                                <td>
                                	<c:if test="${leavelist.status == 'Pending'}"> 
                                	<span class="badge badge-pending">${leavelist.status}</span>
                                	</c:if>
                                	<c:if test="${leavelist.status == 'Approved'}">
		                                <span class="badge badge-approved">${leavelist.status}</span>
									</c:if>
									<c:if test="${leavelist.status == 'Reject'}">
		                                <span class="badge badge-cancel">${leavelist.status}</span>
                                	</c:if>
                                </td>
                                <td>		
									<form id="viewLeaveForm" action="MainController" method="post">
										<button type="submit" class="btn btn-default">
												<i class="fa fa-street-view"></i>
										<input type="hidden" name="action" value="viewLeave" />
										<input type="hidden" name="id" value="${leavelist.ID}" />
										<input type="hidden" name="empcode" value="${leavelist.empCode}">
										</button>
									</form>
								</td>
								</tr>
                            </c:forEach>
<!-- 								<td> -->
<!-- 									<form id="editEmployeeForm" action="MainController" method="post"> -->
<!-- 										<button type="submit" class="btn btn-default"> -->
<!-- 												<i class="fa fa-street-view"></i> -->
<!-- 										<input type="hidden" name="action" value="viewEmployee" /> -->
<%-- 										<input type="hidden" name="empcode" value="${list.empCode}"/> --%>
<!-- 										<input type="hidden" name="view" value="edit"> -->
<!-- 										</button> -->
<!-- 									</form> -->
<!-- 								</td> -->
<!-- 								<td> -->
<!-- 									<form id="deleteEmployeeForm" action="MainController" method="post"> -->
<!-- 										<button type="submit" class="btn btn-default"> -->
<!-- 												<i class="fa fa-street-view"></i> -->
<!-- 										<input type="hidden" name="action" value="deleteEmployee" /> -->
<%-- 										<input type="hidden" name="empcode" value="${list.empCode}" /> --%>
<!-- 										</button> -->
<!-- 									</form> -->
<!-- 								</td> -->
                                
                                
                                
                                
<!--                                 <td><a href="#" class="text-secondary"><span class="icon icon-delete"></span></a></td> -->
                            
                        </tbody>
                    </table>
                    <div class="row align-items-center">
                        <div class="col-6">
                            <p class="mb-0">Showing 1 to 6 of 57 entries</p>
                        </div>
                        <div class="col-6">
                            <nav aria-label="Page navigation example">
                                <ul class="pagination justify-content-end mb-0">
                                    <li class="page-item">
                                        <a class="page-link" href="#" tabindex="-1">Previous</a>
                                    </li>
                                    <li class="page-item active"><a class="page-link" href="#">1</a></li>
                                    <li class="page-item"><a class="page-link" href="#">2</a></li>
                                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                                    <li class="page-item">
                                    <a class="page-link" href="#">Next</a>
                                    </li>
                                </ul>
                            </nav>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>