<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Edit Asset</title>
        	<%@include file="/WEB-INF/pages/sidebarTemplate.jsp"%>
        <script src="js/fileupload.js"></script>
    </head>
    <body>
<%--     	<%@include file="/WEB-INF/pages/headerTemplate.jsp"%> --%>
    	
        <div class="container-fluid px-0 main-body-warpper">
        
        	
            <div class="main-content p-3">
                <div class="pages-all bg-white">
                    <div class="row align-items-center border-bottom pb-2">
                        <div class="col-6">
                            <h5>Edit Asset</h5>
                            <nav aria-label="breadcrumb">
                                <ol class="breadcrumb mb-0">
<!--                                     <li class="breadcrumb-item"><a href="#" class="text-secondary">Home</a></li> -->
<!--                                     <li class="breadcrumb-item"><a href="#" class="text-secondary">Asset</a></li> -->
<!--                                     <li class="breadcrumb-item active" aria-current="page">Add Assets</li> -->
                                </ol>
                            </nav>
                        </div> 
                    </div>
                    <div class="add-details">
                        <form class="mb-0 px-3" action="MultipartController" method="post"  enctype="multipart/form-data">
                            <div class="row">
                       	 <c:forEach items="${assetList}" var="list">
                       	 	<input class="form-control" type="hidden" id="action" name="action" value="editAsset">
                       	 	<input class="form-control" type="hidden" name="id" value="${list.id}">
<!--                                 <div class="col-12 heading py-2 my-2 mb-4 border-bottom"> -->
<!--                                     <h6 class="mb-0 font-weight-bold">Add Assets:</h6> -->
<!--                                 </div> -->
                                <div class="col-6" style="margin-top:30px;">
                                    <div class="form-group">
                                        <label for="code" class="d-block text-left">Asset Name</label>
                                        <input class="form-control" type="text" id="assetname" name="assetname" value="${list.name}" required>
                                    </div>
                                </div>
                                <div class="col-6" style="margin-top:30px;">
                                    <div class="form-group">
                                        <label for="f-name" class="d-block text-left">Holder Name</label>
                                        <input class="form-control" type="text" id="holdername" name="holdername" value="${list.holderName}" required>
                                    </div>
                                </div>
                                <div class="col-12">
                                    <div class="form-group">
                                        <label for="l-name" class="d-block text-left">SKU</label>
                                        <input class="form-control" type="text" id="sku" name="sku" value="${list.sku}">
                                    </div>
                                </div>
                                <div class="col-12">
                                    <div class="form-group">
                                        <label for="code" class="d-block text-left">Asset Detail</label>
                                        <textarea class="form-control" id="text" rows="3" id="assetDetail" name="assetDetail">${list.description}</textarea>
                                    </div>
                                </div>
                                <div class="col-6">
                                    <div class="form-group">
                                        <p class="d-block text-left mb-1">Asset Image</p>
                                        <div class="d-flex align-items-center">
                                            <div class="avtar-file">
                                                <img src="images/Asset_${list.id}.jpg" alt="" class="w-100 h-100 object-fit" id="assetImage" name="assetImage1"/>
                                            </div>
                                            <div class="file-uploard ml-4">
                                                <label class="custom-file" id="customFile">
                                                    <input type="file" class="custom-file-input" id="inputFileDiv" name="assetImage"  aria-describedby="fileHelp">
                                                    <span class="btn btn-secondary">Upload Image</span>
                                                </label>
                                            </div>
                                        </div>
                                        <p class="mb-0 mt-2">(Max 2MB Upload)</p>
                                    </div>
                                </div>
                            </c:forEach>
                                <div class="col-12 text-right mt-3">
                                    <button type="submit" class="btn btn-primary mr-2" data-toggle="modal" data-target="#exampleModal">Submit</button>
                        	</form>           
                                    <form class="d-inline-block" name="cancelform " action="MainController" method="post">
                                     <input type="hidden" id="action" name="action" value="listAsset">
                                     <input type="submit" class="btn btn-secondary" value="Cancel" name="cancel">
                                    	
                                    </form>
                                     
                                </div>
                            </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Modal -->
     <!--      <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                <div class="modal-body text-center py-4">
                    <img src="images/pop-up.png" alt="" class="mb-3" />
                    <h5 class="mb-4">Are you sure you want to add this record?</h5>
                    <div class="">
                        <a href="#" class="btn btn-primary mr-3">Yes</a>
                        <a href="#" class="btn btn-secondary">No</a>
                    </div>
                </div>
                </div>
            </div>
        </div> -->
    </body>
</html>