<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@  taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
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
        <div class="container-fluid px-0 fixed-top main-header bg-white">
            <div class="d-flex align-items-center py-3">
                <div class="header-logo text-center">
                   <a href="#"><img src="images/shreeji_logo.png" alt="" class="img-fluid" /></a> 
                </div>
                <div class="w-100 d-flex justify-content-end navbar-light">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a href="#" class="nav-link h5 text-secondary mb-0"><span class="icon icon-setting"></span></a>
                        </li>
                        <li class="nav-item">
                            <a href="#" class="nav-link h5 text-secondary mb-0"><span class="icon icon-bell"></span></a>
                        </li>
                        <li class="nav-item">
                            <a href="#" class="nav-link text-secondary ">
                                <div class="avtar">
                                    <img src="images/emp${EmpCode}.jpg" alt="" />
                                </div>
                            </a>
                        </li>
                        <li class="nav-item d-xl-none">
                            <a href="#" class="nav-link text-secondary ">
                                <button class="navbar-toggler" type="button" id="sliderbarmenu">
                                    <span class="navbar-toggler-icon"></span>
                                </button>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
	</body>
</html>