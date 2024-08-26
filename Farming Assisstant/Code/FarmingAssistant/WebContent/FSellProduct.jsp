
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
                    <%@page import="com.DBConnections.DatabaseCon"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.*" %>

<%@page import="java.sql.*" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
     
</script>
</head>
<body>
<div class="wrapper">
        <!--Header Start-->
         <header class="header-style-2">
            <nav class="navbar navbar-expand-lg">
               <a class="navbar-brand" href="AdminHome.jsp"><img src="images/h2logo.png" alt=""></a>
               <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"> <i class="fas fa-bars"></i> </button>
               <div class="collapse navbar-collapse" id="navbarSupportedContent">
                  <ul class="navbar-nav mr-auto">
              <li class="nav-item"> <a class="nav-link" href="FarmerHome.jsp">Home</a> </li>
 	              		<li class="nav-item"> <a class="nav-link" href="FCompliantPost.jsp">Compliant Page</a> </li>
                     <li class="nav-item"> <a class="nav-link" href="FFarmingTips.jsp">Farming Tips</a> </li>
                        <li class="nav-item"> <a class="nav-link" href="FAdPost.jsp">Crop Advertisement Details</a> </li>                            
						<li class="nav-item"> <a class="nav-link" href="index.jsp">Logout</a> </li>

                  </ul>

               </div>
            </nav>
         </header>
         <!--Inner Header Start-->
         <section class="wf100 p100 inner-header">
            <div class="container">
               <h1>Farming Assistant</h1>
               
            </div>
         </section>
         <!--Inner Header End--> 
   <section class="wf100 p80">
            <div class="container">
               <div class="row">
                  <div class="col-lg-8">
                  
                  <%
                  
                  String farmername=session.getAttribute("farmer").toString();
                  session.setAttribute("farmer",farmername);
                  
                  System.out.println("User: "+farmername);
                  	String title=request.getParameter("title");
                    String cropname=request.getParameter("cn");
                    String quantity=request.getParameter("q");
                    String supplier=request.getParameter("p");
                    
                  
                  %>                
                  	<!-- Start Align Area -->
	<div class="whole-wrap">
		<div class="container box_1170">
<!--Leave a Comment Start-->
                           <div class="wf100 comment-form">
                             
                              <form action="SellProduct" method="post">
                              <ul>
                                 <li class="w3">
                                    <input type="text" name="title" class="form-control" placeholder="Title" value="<%=title %>" readonly>
                                 </li>
                                 <li class="full">
                                    <input type="text" name="cropname" class="form-control" placeholder="Crop Name" value="<%=cropname %>" readonly>
                                 </li>
                                          <li class="full">
                                    <input type="text" name="suplliername" class="form-control" placeholder="Supplier Name" value="<%=supplier %>" readonly>
                                 </li>
                       				<li class="full">
                                    <input type="text" name="quantity" class="form-control" placeholder="Required Quantity per Kg" value="<%=quantity %>" readonly>
                                 </li>
                                 <li class="full">
                                     <input type="text" name="cropprice" class="form-control" placeholder="Enter your Price">
                                 </li>
                                
                                 
                                 <li class="full">
                                    <button class="post-btn">Sell Product</button>
                                 </li>
                              </ul>
                              </form>
                           </div>
                           <!--Leave a Comment End--> 
    </div>
    </div>
                  </div>
                  </div>
                  </div>
                  </section>
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