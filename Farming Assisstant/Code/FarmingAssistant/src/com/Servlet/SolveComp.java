package com.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Bean.DataBean;
import com.Implementation.FarmImplementation;
import com.Interface.FarmInterface;

/**
 * Servlet implementation class SolveComp
 */
@WebServlet("/SolveComp")
public class SolveComp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SolveComp() {
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
		
		 String title = request.getParameter("title");
		 String farmer = request.getParameter("farmer");
		 
//		 System.out.println(title+" "+farmer);
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
		 
		
	}

}
