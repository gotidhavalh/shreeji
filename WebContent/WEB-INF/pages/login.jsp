<%@ page language="java" contentType="text/html; charset=ISO-8859-1"   pageEncoding="ISO-8859-1"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700,900" rel="stylesheet">
        <link rel="stylesheet" href="css/fonts.css">
        
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>
        <link href="css/style.css" rel="stylesheet" type="text/css">

        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <script src="js/custom.js"></script>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row align-items-center">
                <div class="col-6 px-0">
                    <img src="images/login.jpg" alt="" class="w-100 h-100vh object-fit" />
                </div>
                <div class="col-6">
                    <div class="row justify-content-center">
                        <div class="col-11 col-lg-9 col-xl-7 text-center">
                            <h2 class="mb-4">LOGIN</h2>
                            <form class="mb-0c" action="MainController" name="loginForm"  method="post">
                                <div class="form-group">
                                    <label for="username" class="d-block text-left">Username</label>
                                    <input class="form-control" type="text" id="username" name="username" />
                                </div>
                                <div class="form-group">
                                    <label for="password" class="d-block text-left">Password</label>
                                    <input  type="password" class="form-control" id="password" name="password" />
                                </div>
									<input type="hidden" name="action" value="loginUser"> 
        	                        <input type="submit" class="btn btn-primary w-100 mb-3" name="submit" value="Login">
    	                            <a class="h6 font-weight-normal text-secondary" href="#">Forgot password?</a>
                            </form>
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <c:if test="${!empty responseMessage}">
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
						   <p id="responseMessage"><br>
						   <c:out value="${responseMessage}" />
						   </p>
					      </div>
					      <div class="modal-footer">
					        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
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

