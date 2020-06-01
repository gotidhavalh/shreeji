<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>Add</title>
        <meta charset="utf-8">
			<%@include file="/WEB-INF/pages/sidebarTemplate.jsp"%>
			<script src="js/leave.js"></script>
    </head>
    <body>
            <div class="main-content p-3" style="margin-top:63px;">
                <div class="pages-all bg-white">
                    <div class="row align-items-center border-bottom pb-2">
                        <div class="col-6">
                            <h5>Add Leave</h5>
                            <nav aria-label="breadcrumb">
                                <ol class="breadcrumb mb-0">
<!--                                     <li class="breadcrumb-item"><a href="#" class="text-secondary">Home</a></li> -->
<!--                                     <li class="breadcrumb-item"><a href="#" class="text-secondary">Leave</a></li> -->
<!--                                     <li class="breadcrumb-item active" aria-current="page">Add Leave</li> -->
                                </ol>
                            </nav>
                        </div> 
                    </div>
                    <div class="add-details">
                        <form class="mb-0 px-3" name="addleave" action="MainController" method="post" id="addLeave">
                         <input class="form-control" type="hidden" id="action" name="action" value="addLeave">
                            <div class="row">
<!--                                 <div class="col-12 heading py-2 my-2 mb-4 border-bottom"> -->
<!--                                     <h6 class="mb-0 font-weight-bold">Add Leave</h6> -->
<!--                                 </div> -->
                                <div class="col-12"style="margin-top:30px;">
                                    <div class="form-group">
                                        <label for="code" class="d-block text-left">Employee Name</label>
                                        <select class="custom-select form-control" name="empcode">
                                        <c:forEach items="${listEmployee}" var="list">
                                        	<option value="${list.empCode}">${list.firstName}</option>
                                        </c:forEach>
                                        </select>
                                    </div>
                                </div>
<!--                                 <div class="col-12"> -->
<!--                                     <div class="form-group"> -->
<!--                                         <label for="code" class="d-block text-left">Employee Name</label> -->
<!--                                         <input list="browsers" name="dataempcode"> -->
<!-- 										  <datalist id="browsers" name="datalist"> -->
<%-- 										    <c:forEach items="${listEmployee}" var="list"> --%>
<%--                                         	<option label="${list.empCode}" >${list.firstName}</option> --%>
<%--                                         </c:forEach> --%>
<!-- 										  </datalist> -->
<!--                                     </div> -->
<!--                                 </div> -->
                                <div class="col-6">
                                    <div class="form-group">
                                        <label for="f-name" class="d-block text-left">From Date</label>
                                        <div class='input-group date'>
                                            <input type='text' class="form-control" id='datetimepicker3' aria-describedby="inputGroupPrepend2" name="fromDate" required/>
                                            <span class="input-group-append">
                                                <span class="input-group-text" id="inputGroupPrepend2">
                                                    <span class="icon icon-calendar"></span>
                                                </span>
                                            </span>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-6">
                                    <div class="form-group">
                                        <label for="l-name" class="d-block text-left">To Date</label>
                                        <div class='input-group date'>
                                            <input type='text' class="form-control" id='datetimepicker4' aria-describedby="inputGroupPrepend2" name="toDate" required/>
                                            <span class="input-group-append">
                                                <span class="input-group-text" id="inputGroupPrepend2">
                                                    <span class="icon icon-calendar"></span>
                                                </span>
                                            </span>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-12">
                                    <div class="form-group">
                                        <div class="custom-control custom-radio custom-control-inline">
                                            <input type="radio" id="customRadioInline1" name="Day" class="custom-control-input mr-4" value="halfDay">
                                            <label class="custom-control-label" for="customRadioInline1">Half Day</label>
                                        </div>
                                        <div class="custom-control custom-radio custom-control-inline">
                                            <input type="radio" id="customRadioInline2" name="Day" class="custom-control-input" value="fullDay">
                                            <label class="custom-control-label" for="customRadioInline2">Full Day</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-12">
                                    <div class="form-group">
                                        <label for="code" class="d-block text-left">Leave Reason</label>
                                        <textarea class="form-control" id="c-address" rows="5" name="reason" id="reason" required="required"></textarea>
                                    </div>
                                </div>
                                <div class="col-12 text-right mt-3">
                                    <button type="submit" class="btn btn-primary mr-2 d-inline-flex" data-toggle="modal" data-target="#exampleModal" id="submit">Submit</button>
                                </form>
                                <form name="listleave1" method="post" action="MainController" class="d-inline-flex">
                            		<input type="hidden" name="action" value="listLeave">
                            		<a href="javascript:document.listleave1.submit()" class="btn btn-secondary">Cancel</a>
                            		</form>
                            	
<!--                                     <button type="reset" class="btn btn-secondary">Cancel</button> -->
                                </div>
                            </div>
                                   
                    </div>
                </div>
            </div>
        </div>
        <!-- Modal -->
<!--         <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true"> -->
<!--             <div class="modal-dialog" role="document"> -->
<!--                 <div class="modal-content"> -->
<!--                 <div class="modal-body text-center py-4"> -->
<!--                     <img src="images/pop-up.png" alt="" class="mb-3" /> -->
<!--                     <h5 class="mb-4">Are you sure you want to add this record?</h5> -->
<!--                     <div class=""> -->
<!--                         <a href="#" class="btn btn-primary mr-3">Yes</a> -->
<!--                         <a href="#" class="btn btn-secondary">No</a> -->
<!--                     </div> -->
<!--                 </div> -->
<!--                 </div> -->
<!--             </div> -->
<!--         </div> -->
    </body>
</html>>