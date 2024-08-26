<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.DBConnections.DatabaseCon"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.*" %>
<%@page import="com.blockchain.*"%>
<%@page import="java.sql.*" %>
<%@page import="com.Bean.*" %>    
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
        			<li class="nav-item"> <a class="nav-link" href="AdminHome.jsp">Home</a> </li>
                     <li class="nav-item"> <a class="nav-link" href="AdViewCompliant.jsp">View Compliant</a> </li>
                     <li class="nav-item"> <a class="nav-link" href="AdFarmingTips.jsp">Farming Tips</a> </li> 
                      <li class="nav-item"> <a class="nav-link" href="AdViewTransactions.jsp">Transactions</a> </li>
                     <li class="nav-item"> <a class="nav-link" href="AdViewBlockchain.jsp">Blockchain</a> </li>
					 <li class="nav-item"> <a class="nav-link" href="index.jsp">Logout</a> </li>

                  </ul>

               </div>
            </nav>
         </header>
         <!--Header End-->
         <!--Inner Header Start-->
         <section class="wf100 p100 inner-header">
            <div class="container">
               <h1>Farming Assistant</h1>
               <ul>
                  <li><a href="#">Admin</a></li>
                  <li><a href="#"> Transactions </a></li>
               </ul>
            </div>
         </section>
         <!--Inner Header End--> 
         <!--Causes Start-->
         <section class="wf100 p80">
            <div class="container">
               <div class="row">
                  <div class="col-lg-8">
         
	<!-- Start Align Area -->
	<div class="whole-wrap">
		<div class="container box_1170">
			
		<%
		
		String Author="";
		String URL="";
		String Description="";
		String id=request.getParameter("tid");
		%>
		
			
		
		
			
			
			<div class="section-top-border">
			 <div class="container">
                  <div class="row">
				<h3>Applied Block Chain - Transaction</h3>

    <%
    try
    {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=(Connection)DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/farmassistant","root","root");
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select * from transactions where id='"+id+"' and status='Processing'");
       
    %>
    
    
					<table id="mytable" class="table table-bordred table-striped">

						<thead>
							<th>Packet Details</th>
							<th>Information</th>
						</thead>
						<tbody>
							<%
							ArrayList<Block> blockchain = new ArrayList<Block>();
							String blockid="";
							String senderid1="";
							String benificiaryid="";
							String transtype="";
							String tamount="";
							String transdate="";
							String Status="";		
							
							
							while(rs.next())
							{
								blockid=rs.getString("id");
								senderid1=rs.getString("sender");
								benificiaryid=rs.getString("receiver");
								transtype=rs.getString("ttype");
								tamount=rs.getString("transid");
								transdate=rs.getString("doftrans");
								Status="Sucess";
							}
							TransactionBean TB=new TransactionBean();
							PreparedStatement obj = con.prepareStatement("update transactions set status='Success' where id=?");
							obj.setString(1, blockid);
							obj.executeUpdate();
							

							
							String[] packetdata=new String[6];
							packetdata[0]=blockid;
							packetdata[1]=senderid1;
							packetdata[2]=benificiaryid;
							packetdata[3]=transtype;
							packetdata[4]=tamount;
							packetdata[5]=transdate;
								
							NoobChain nc=new NoobChain();
									
							blockchain=nc.doblockchain(packetdata);
								
							
							PreparedStatement obj1 = con.prepareStatement("insert into blockchaintbl values(?,?,?,?,?,?,?,?,?,?)");
							obj1.setString(1, blockid);
							obj1.setString(2, blockid+senderid1+benificiaryid+transtype+tamount+transdate);
							obj1.setString(3, "6");
							obj1.setString(4, blockchain.get(0).hash );
							obj1.setString(5, blockchain.get(1).hash );
							obj1.setString(6, blockchain.get(2).hash );
							obj1.setString(7, blockchain.get(3).hash );
							obj1.setString(8, blockchain.get(4).hash );
							obj1.setString(9, blockchain.get(5).hash );
							obj1.setString(10, "Success");
							obj1.executeUpdate();
	
							%>
							<tr><td>Block ID</td><td><%=blockid%></td></tr>
							<tr><td>Packet Data</td><td><%=blockid%>-<%=senderid1%>-<%=benificiaryid%>-<%=transtype%>-<%=tamount%>-<%=transdate%></td></td></tr>
							<tr><td>No of Blocks</td><td>6</td></tr>
							<tr><td>Block 1</td><td><%=blockchain.get(0).hash %></td></tr>
							<tr><td>Block 2</td><td><%=blockchain.get(1).hash %></td></tr>
							<tr><td>Block 3</td><td><%=blockchain.get(2).hash %></td></tr>
							<tr><td>Block 4</td><td><%=blockchain.get(3).hash %></td></tr>
							<tr><td>Block 5</td><td><%=blockchain.get(4).hash %></td></tr>
							<tr><td>Block 6</td><td><%=blockchain.get(5).hash %></td></tr>
							<tr><td>Status</td><td>Success</td></tr>
						
							<tr><td></td>
								<td></td>
							</tr>
							

						</tbody>

					</table>
    
    
    
    
    <br>
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
	<!-- End Align Area -->
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