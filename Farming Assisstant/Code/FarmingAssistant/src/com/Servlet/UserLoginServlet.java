package com.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Bean.UserLoginBean;
import com.Implementation.FarmImplementation;
import com.Interface.FarmInterface;


/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HttpSession session=request.getSession();  
		 String emailid = request.getParameter("username");
		 String password = request.getParameter("password");
		 String utype=request.getParameter("utype");
		 
//		 System.out.println("login" + emailid);
		 
		 if(!utype.equals("A"))
		 {
			 UserLoginBean ULB = new UserLoginBean();
			 ULB.setusername(emailid);
			 ULB.setPassword(password);
			 ULB.setusertype(utype);
			 
//			 System.out.println("login" + ULB);
				
			 FarmInterface SDI = new FarmImplementation();
			 int i = SDI.UserLogin(emailid,password,utype);
			 
//			 System.out.println("login " + i);
			 
			 if(i==1)
			 {
				 if(utype.equals("F"))
				 {
					 response.sendRedirect("FarmerHome.jsp?emailid="+ emailid);
					 session.setAttribute("farmer",emailid);
				 }
				 else
				 {
					 response.sendRedirect("SupplierHome.jsp?emailid="+ emailid);
					 session.setAttribute("supplier",emailid);
				 }
				
			 }
			 else
			 {
				response.sendRedirect("error.jsp");
			 }
		 }
		 else
		 {
			 if(emailid.equals("admin")&&password.equals("admin"))
			 {
				 response.sendRedirect("AdminHome.jsp");
			 }
			 else
			 {
				 response.sendRedirect("error.jsp");
			 }
		 }
		 
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
