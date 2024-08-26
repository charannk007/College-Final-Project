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
                     <li class="nav-item"> <a class="nav-link" href="SupplierHome.jsp">Home</a> </li>
                     <li class="nav-item"> <a class="nav-link" href="SPostAd.jsp">Post Advertisement</a> </li>
                           <li class="nav-item"> <a class="nav-link" href="SCropReceived.jsp">Crop Received</a> </li>             
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
                  
                              
                  <h3>Posted Advertisement</h3>

    <%
    
    	String suppliername=session.getAttribute("supplier").toString();
    
	 	session.setAttribute("supplier",suppliername); 
    
    try
    {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=(Connection)DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/farmassistant","root","root");
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select * from adpost where status='Accept' and postby='"+suppliername+"'");
    %><table border=1 align=left style="text-align:center" width="100%">
      <thead>
          <tr>
          	
             <th>Title</th>
             <th>Crop Name</th>
              <th>Quantity (KG)</th>
              <th>CropCost</th>
              <th>Farmer Name</th>
              <th>Crop Image</th>
     
          </tr>
      </thead>
      <tbody>
        <%while(rs.next())
        {
            %>
            <tr>
               
                <td><%=rs.getString("title") %></td>
                <td><%=rs.getString("cropname") %></td>
                <td><%=rs.getString("quantity") %></td>
                <td><%=rs.getString("cropcost") %></td>
                <td><%=rs.getString("acceptby") %></td>
                <td><img src='images/<%=rs.getString("imagepath") %>' width="50" height="60"/></td>
            
            </tr>
            
            <%}%>
           </tbody>
        </table><br>
    <%}
    catch(Exception e){
        out.print(e.getMessage());%><br><%
    }

    %>

    </div>
    </div>
    <div class="section-top-border">
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