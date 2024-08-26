<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
   <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
      <meta name="description" content="">
      <meta name="author" content="">
      <link rel="icon" href="images/favicon.png">
      <title>Farming Assistant | Web Service Digital Market</title>
      <!-- CSS FILES START -->
      <link href="css/custom.css" rel="stylesheet">
      <link href="css/color.css" rel="stylesheet">
      <link href="css/responsive.css" rel="stylesheet">
      <link href="css/owl.carousel.min.css" rel="stylesheet">
      <link href="css/bootstrap.min.css" rel="stylesheet">
      <link href="css/prettyPhoto.css" rel="stylesheet">
      <link href="css/all.min.css" rel="stylesheet">
      <!-- CSS FILES End -->
</head>
<body>
  <div class="wrapper">
         <!--Header Start-->
         <header class="header-style-2">
            <nav class="navbar navbar-expand-lg">
               <a class="navbar-brand" href="index.jsp"><img src="images/h2logo.png" alt=""></a>
               <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"> <i class="fas fa-bars"></i> </button>

            </nav>
         </header>
         <div id="search">
            <button type="button" class="close">×</button>
            <form class="search-overlay-form">
               <input type="search" value="" placeholder="type keyword(s) here" />
               <button type="submit" class="btn btn-primary"><i class="fas fa-search"></i></button>
            </form>
         </div>
         <!--Header End-->
         <!--Inner Header Start-->
         <section class="wf100 p100 inner-header">
            <div class="container">
               <h1>Farming Assistant</h1>
               <ul>
                  <li><a href="#">Home</a></li>
                  <li><a href="#"> Account </a></li>
               </ul>
            </div>
         </section>
         <!--Inner Header End--> 
         <!--Causes Start-->
         <section class="wf100 p80">
            <div class="container">
               <div class="row">
                  <div class="col-lg-8">
                     <div class="myaccount-form">
                        <h3>Register Your Account</h3>
                        <form action="UserRegistrationServlet" method="post">
                           <ul class="row">
                            <li class="col-md-6">
                                    <div class="input-group">
                             <select name="utype" id="utype" class="form-control" >
                             <option value="0">Select</option>
  								<option value="F">Farmer</option>
  									<option value="S">Supplier</option>
  															
											</select>
                           </div>
                           </li>
                           <li class="col-md-6">
                                   <div class="input-group">
                                    <input type="text" name="username" class="form-control" placeholder="User Id">
                                 </div>
                           </li>
                              <li class="col-md-6">
                                 <div class="input-group">
                                    <input type="text" name="name" class="form-control" placeholder="Name">
                                 </div>
                              </li>
                              <li class="col-md-6">
                                 <div class="input-group">
                                    <input type="text" name="address" class="form-control" placeholder="Address" required>
                                 </div>
                              </li>
                              <li class="col-md-6">
                                 <div class="input-group">
                                    <input type="text" name="phoneno" class="form-control" placeholder="Mobile Number" required maxlength="10">
                                 </div>
                              </li>
                              <li class="col-md-6">
                                 <div class="input-group">
                                    <input type="password" name="password" class="form-control" placeholder="Password" maxlength="10">
                                 </div>
                              </li>
            
                              <li class="col-md-12">
                                 <div class="input-group form-check">
                                    <input type="checkbox" class="form-check-input" id="exampleCheck1" required="required">
                                    <label class="form-check-label" for="exampleCheck1">I agree to the Terms of <a href="#">Services & Privacy Plicy</a></label>
                                 </div>
                              </li>
                              <li class="col-md-12">
                                 <button class="register">Register Your Account</button>
                              </li>
                           </ul>
                        </form>
                     </div>
                  </div>
                  <div class="col-lg-4">
                     <div class="login-box">
                        <h3>Login Account</h3>
                        <form action="UserLoginServlet" method="get">
                           <div class="input-group">
                              <input type="text" name="username" class="form-control" placeholder="Username" required>
                           </div>
                           <div class="input-group">
                              <input type="password" name="password" class="form-control" placeholder="Password" required>
                           </div>
               
                           <div class="input-group">
                             <select name="utype" id="utype" class="form-control">
                             <option value="0">Select</option>
  								<option value="F">Farmer</option>
  									<option value="S">Supplier</option>
  										<option value="A">Admin</option>
  											
											</select>
                           </div>
                                       
                           <div class="input-group">
                              <button class="login-btn">Login Account</button>
                           </div>
                        </form>
                     </div>
                  </div>
               </div>
            </div>
         </section>
         <!--Causes End--> 
         <!--Footer Start-->
         <footer class="footer">
            <div class="footer-copyr wf100">
               <div class="container">
                  <div class="row">
                     <div class="col-md-4 col-sm-4"> <img src="images/logo.png" alt=""> </div>
                     <div class="col-md-8 col-sm-8">
                        
                     </div>
                  </div>
               </div>
            </div>
         </footer>
         <!--Footer End--> 
      </div>
      <!--   JS Files Start  --> 
      <script src="js/jquery-3.3.1.min.js"></script> 
      <script src="js/jquery-migrate-1.4.1.min.js"></script> 
      <script src="js/popper.min.js"></script> 
      <script src="js/bootstrap.min.js"></script> 
      <script src="js/owl.carousel.min.js"></script> 
      <script src="js/jquery.prettyPhoto.js"></script> 
      <script src="js/isotope.min.js"></script> 
      <script src="js/custom.js"></script>
</body>
</html>