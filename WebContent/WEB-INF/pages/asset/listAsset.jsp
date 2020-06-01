<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Assets List</title>
         <%@include file="/WEB-INF/pages/sidebarTemplate.jsp"%>
    </head>
    <body>
        <div class="container-fluid px-0 main-body-warpper">

            <div class="main-content p-3">
                <div class="pages-all bg-white">
                    <div class="row align-items-center border-bottom pb-2">
                        <div class="col-6">
                            <h5>Asset List</h5>
                            <nav aria-label="breadcrumb">
                                <ol class="breadcrumb mb-0">
                                    <li class="breadcrumb-item"><a href="#" class="text-secondary">Home</a></li>
                                    <li class="breadcrumb-item active" aria-current="page">Asset</li>
                                </ol>
                            </nav>
                        </div>
                        <div class="col-6 text-right">
<!--                         <form name="addAsset" action="MainController" method="post"> -->
<!--                         	<input type="hidden" name="action" value="asset"> -->
<!--                             <a	href="javascript:document.addAsset.submit()" class="btn btn-primary"> Add Asset</a> -->
<!--                         </form> -->
                        <form name="addAsset" action="MainController" method="post">
                        	<input type="hidden" name="action" value="asset">
                        	<input type="submit" name="asset" class="btn btn-primary"value="Add Asset">
                        </form>     
                        </div>
                    </div>
                    <table class="table table-custom mt-4">
                        <thead>
                            <tr>
                                <th>Name<a href="#" class="ml-1 text-secondary d-inline-block align-middle"><span class="icon icon-arrow-new"></span></a></th>
                                <th>Holder Name</th>
                                <th>Image</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                        	<c:forEach items="${assetList}" var="item" varStatus="loop">
	                            <tr>
	                                <td>${item.name}</td>
	                                <td>${item.holderName}</td>
	                                <td>
	                                    <div class="assets-img">
	                                        <img  src="images/Asset_${item.id}.jpg" alt="">
	                                    </div>
	                                </td>
	                                <td>
									<form id="viewAssertForm" action="MainController" method="post">
										<button type="submit" class="btn btn-default">
												<i class="fa fa-street-view"></i>
										<input type="hidden" name="action" value="viewAsset" />
										<input type="hidden" name="id" value="${item.id}" />
										<input type="hidden" name="view" value="view">
										</button>
									</form>
								</td>
								<td>
									<form id="editAssetForm" action="MainController" method="post">
										<button type="submit" class="btn btn-default">
												<i class="fa fa-street-view"></i>
										<input type="hidden" name="action" value="viewAsset" />
										<input type="hidden" name="id" value="${item.id}"/>
										<input type="hidden" name="view" value="edit">
										</button>
									</form>
								</td>
								<td>
									<form id="deleteAssetForm" action="MainController" method="post">
										<button type="submit" class="btn btn-default">
												<i class="fa fa-street-view"></i>
										<input type="hidden" name="action" value="deleteAsset" />
										<input type="hidden" name="id" value="${item.id}" />
										</button>
									</form>
								</td>
<!-- 	                                <td><a href="#" class="text-secondary"><span class="icon icon-delete"></span></a></td> -->
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