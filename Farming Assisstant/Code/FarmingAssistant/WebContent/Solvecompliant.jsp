<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
         <%@page import="com.DBConnections.DatabaseCon"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.*" %>

<%@page import="com.Bean.DataBean" %>  
<%@page import="com.Implementation.FarmImplementation" %> 
<%@page import="com.Interface.FarmInterface" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%

String title = request.getParameter("title");
String farmer = request.getParameter("farmer");

System.out.println(title+" "+farmer);
DataBean db=new DataBean();
db.settitle(title);
db.setfarmer(farmer);

FarmInterface FI=new FarmImplementation();
	
int i=FI.SolveCompliant(db);

if(i==1)
{
	 response.sendRedirect("AdViewCompliant.jsp");
}

else
{
	 response.sendRedirect("AdminHome.jsp");
}


%>

</body>
</html>