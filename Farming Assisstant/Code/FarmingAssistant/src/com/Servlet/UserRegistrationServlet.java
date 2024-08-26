package com.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Bean.UserRegistrationBean;
import com.Implementation.FarmImplementation;
import com.Interface.FarmInterface;

/**
 * Servlet implementation class UserRegistrationServlet
 */
@WebServlet("/UserRegistrationServlet")
public class UserRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String username = request.getParameter("username");
		String name = request.getParameter("name");
		String phoneno = request.getParameter("phoneno");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String utype = request.getParameter("utype");
		
//		    System.out.println("registration" + username);
		
			UserRegistrationBean URB = new UserRegistrationBean();
			
			URB.setusername(username);
			URB.setPassword(password);
			URB.setusertype(utype);
			URB.setname(name);
			URB.setaddress(address);
			URB.setphoneno(phoneno);
			
//			System.out.println("registration"+ URB);
			
			FarmInterface SDI = new FarmImplementation();
			int i = SDI.UserRegistration(URB);
//			System.out.println("registration"+ i);
			
			if(i==1)
			{
				response.sendRedirect("index.html");
			}
			else
			{
				response.sendRedirect("error.jsp");
			}
			
		
		
	}

}
