<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<html>
    <head>
        <title>Dashboard</title>
        <meta charset="utf-8">

        <%@include file="/WEB-INF/pages/sidebarTemplate.jsp"%>
        <script src="js/employee.js"></script>
    </head>
    <body>
    	<div class="container-fluid px-0 main-body-warpper">
           <div class="main-content p-3">
                <div class="pages-all bg-white">
                    <div class="row align-items-center border-bottom pb-2">
                        <div class="col-6">
                            <h5>Employee</h5>
                            <nav aria-label="breadcrumb">
                                <ol class="breadcrumb mb-0">
                                    <li class="breadcrumb-item"><a href="#" class="text-secondary">Home</a></li>
                                    <li class="breadcrumb-item active" aria-current="page">Employee</li>
                                </ol>
                            </nav>
                        </div>
                        <div class="col-6 text-right">
                        <form name="addEmployeeForm" action="MainController" method="post">
                        	<input type="hidden" name="action" value="designation">
                        	<input type="hidden" name="designation" value="Designation">
                            <input type="submit" name="employee" value="Add Employee" class="btn btn-primary">
<!--                             <a	href="javascript:document.addEmployee.submit()" class="btn btn-primary"> Add Employee</a> -->
                        </form>
                        </div>
                    </div>
                    <table class="table table-custom" id="editEmployee">
                        <thead>
                            <tr>
                                <th>Emp Code</th>
                                <th>Name<a href="#" class="ml-1 text-secondary d-inline-block align-middle"><span class="icon icon-arrow-new"></a></th>
                                <th>Phone</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${Employeelist}" var="list">
                            <tr>
                                <td><c:out value="${list.empCode}"/></td>
                                <td><c:out value="${list.firstName}"/></td>
                                <td><c:out value="${list.phoneNumber}"/></td>
								<td>
									<form id="viewEmployeeForm" action="MainController" method="post">
										<button type="submit" class="btn btn-default">
												<i class="fa fa-street-view"></i>
										<input type="hidden" name="action" value="viewEmployee" />
										<input type="hidden" name="empcode" value="${list.empCode}" />
										<input type="hidden" name="view" value="view">
										</button>
									</form>
								</td>
								<td>
									<form id="editEmployeeForm" action="MainController" method="post">
										<button type="submit" class="btn btn-default">
												<i class="fa fa-street-view"></i>
										<input type="hidden" name="action" value="viewEmployee" />
										<input type="hidden" name="empcode" value="${list.empCode}"/>
										<input type="hidden" name="view" value="edit">
										</button>
									</form>
								</td>
								<td>
									<form id="deleteEmployeeForm" action="MainController" method="post">
										<button type="submit" class="btn btn-default">
												<i class="fa fa-street-view"></i>
										<input type="hidden" name="action" value="deleteEmployee" />
										<input type="hidden" name="empcode" value="${list.empCode}" />
										</button>
									</form>
								</td>
                            </tr>
                            </c:forEach>
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