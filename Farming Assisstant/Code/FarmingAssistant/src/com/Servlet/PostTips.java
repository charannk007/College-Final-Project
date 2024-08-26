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
 * Servlet implementation class PostTips
 */
@WebServlet("/PostTips")
public class PostTips extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostTips() {
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
		 String comment = request.getParameter("comment");
		 
//		 System.out.println("Farming Tips"+title+" "+comment);
		 
		 DataBean db=new DataBean();
		 db.settitle(title);
		 db.setcomment(comment);
		 	 
		 
		 FarmInterface FI=new FarmImplementation();
		
		 int i=FI.PostTips(db);
		 
		 if(i==1)
		 {
			 response.sendRedirect("AdFarmingTips.jsp");
		 }
	
		 else
		 {
			 response.sendRedirect("AdminHome.jsp");
		 }
		
		
		
		
	}

}
