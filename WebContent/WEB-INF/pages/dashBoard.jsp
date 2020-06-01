<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Dashboard</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700,900" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/material-design-iconic-font/2.2.0/css/material-design-iconic-font.min.css">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css">
        <link href="css/style.css" rel="stylesheet" type="text/css">

        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <script src="js/custom.js"></script>
    </head>
    <body>
        <div class="container-fluid px-0 fixed-top main-header bg-white">
            <div class="d-flex align-items-center py-3">
                <div class="header-logo text-center">
                    <img src="images/logo.png" alt="" class="img-fluid" />
                </div>
                <div class="w-100 d-flex justify-content-end">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a href="#" class="nav-link h5 text-secondary mb-0"><i class="zmdi zmdi-settings"></i></a>
                        </li>
                        <li class="nav-item">
                            <a href="#" class="nav-link h5 text-secondary mb-0"><i class="zmdi zmdi-notifications"></i></a>
                        </li>
                        <li class="nav-item">
                            <a href="#" class="nav-link text-secondary ">
                                <div class="avtar">
                                    <img src="images/avtar.jpg" alt="" />
                                </div>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="container-fluid px-0 main-body-warpper">
            <div class="slidbar">
                <ul class="list-unstyled py-3">
                    <li class="w-100 active">
                        
                        <a href="#" class="d-block py-2 px-4 text-secondary font-weight-medium mb-0">
                            <i class="zmdi zmdi-home mr-3"></i>Dashboard
                        </a> 
                    </li>
                    <li class="w-100">
                        <a href="#" class="d-block py-2 px-4 text-secondary font-weight-medium mb-0">
                            <i class="zmdi zmdi-home mr-3"></i>Employee
                        </a>
                        <div class="menu-dropdwon">
							<form name="listEmployee" method="POST" action="MainController">
								<input type="hidden" name="action" value="listEmployee">
		 						<a	href="javascript:document.listEmployee.submit()" class="d-block py-2 px-4 text-secondary font-weight-medium mb-0">Employee</a>
							</form>
                            <a href="#" class="d-block py-2 px-4 text-secondary font-weight-medium mb-0">
                                Assets
                            </a>
                            <a href="#" class="d-block py-2 px-4 text-secondary font-weight-medium mb-0">
                                Leave
                            </a>
                            <a href="#" class="d-block py-2 px-4 text-secondary font-weight-medium mb-0">
                                Payroll
                            </a>
                            <a href="#" class="d-block py-2 px-4 text-secondary font-weight-medium mb-0">
                                Salary
                            </a>
                            <a href="#" class="d-block py-2 px-4 text-secondary font-weight-medium mb-0">
                                Deduction
                            </a>
                            <a href="#" class="d-block py-2 px-4 text-secondary font-weight-medium mb-0">
                                Allowance
                            </a>
                        </div>
                    </li>
                    <li class="w-100">
                        <a href="#" class="d-block py-2 px-4 text-secondary font-weight-medium mb-0">
                            <i class="zmdi zmdi-home mr-3"></i>Customer
                        </a>
                    </li>
                    <li class="w-100">
                        <a href="#" class="d-block py-2 px-4 text-secondary font-weight-medium mb-0">
                            <i class="zmdi zmdi-home mr-3"></i>Supplier
                        </a>
                    </li>
                    <li class="w-100">
                        <a href="#" class="d-block py-2 px-4 text-secondary font-weight-medium mb-0">
                            <i class="zmdi zmdi-home mr-3"></i>Inventor
                        </a>
                    </li>
                    <li class="w-100">
                        <a href="#" class="d-block py-2 px-4 text-secondary font-weight-medium mb-0">
                            <i class="zmdi zmdi-home mr-3"></i>Services
                        </a>
                    </li>
                    <li class="w-100">
                        <a href="#" class="d-block py-2 px-4 text-secondary font-weight-medium mb-0">
                            <i class="zmdi zmdi-home mr-3"></i>Sales & Support
                        </a>
                    </li>
                    <li class="w-100">
                        <a href="#" class="d-block py-2 px-4 text-secondary font-weight-medium mb-0">
                            <i class="zmdi zmdi-home mr-3"></i>Sales & Support
                        </a>
                        <div class="menu-dropdwon">
                            <a href="#" class="d-block py-2 px-4 text-secondary font-weight-medium mb-0">
                                Employee
                            </a>
                            <a href="#" class="d-block py-2 px-4 text-secondary font-weight-medium mb-0">
                                Assets
                            </a>
                            <a href="#" class="d-block py-2 px-4 text-secondary font-weight-medium mb-0">
                                Leave
                            </a>
                            <a href="#" class="d-block py-2 px-4 text-secondary font-weight-medium mb-0">
                                Payroll
                            </a>
                            <a href="#" class="d-block py-2 px-4 text-secondary font-weight-medium mb-0">
                                Salary
                            </a>
                            <a href="#" class="d-block py-2 px-4 text-secondary font-weight-medium mb-0">
                                Deduction
                            </a>
                            <a href="#" class="d-block py-2 px-4 text-secondary font-weight-medium mb-0">
                                Allowance
                            </a>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </body>
</html>				
	
