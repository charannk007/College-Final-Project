package com.Servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Bean.DataBean;
import com.Bean.TransactionBean;
import com.Implementation.FarmImplementation;
import com.Interface.FarmInterface;

/**
 * Servlet implementation class PostComp
 */
@WebServlet("/PostComp")
public class PostComp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostComp() {
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
		 
		 HttpSession session=request.getSession();  
		 String title = request.getParameter("title");
		 String comment = request.getParameter("comment");
		 String farmer=session.getAttribute("farmer").toString();
//		 System.out.println("Farming Tips"+title+" "+comment);
		 
		 //Getting Current date
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			String trans_date = df.format(new Date()); 
		 
		 	TransactionBean TB=new TransactionBean();
			TB.setsenderid(farmer);
			TB.setreceiverid("To Admin");
			TB.setttype("Compliant");
			TB.settransid(title);
			TB.setdoftrans(trans_date);
			TB.settstatus("Processing");
			
			
			FarmInterface Fi=new FarmImplementation();
			Fi.AllTransactions(TB);
		 
		 
		 
		 
		 
		 
		 DataBean db=new DataBean();
		 db.settitle(title);
		 db.setcomment(comment);
		 db.setfarmer(farmer);
		 	 
		 
		 FarmInterface FI=new FarmImplementation();
		
		 int i=FI.PostComp(db);
		 
		 if(i==1)
		 {
			 response.sendRedirect("FCompliantPost.jsp");
		 }
	
		 else
		 {
			 response.sendRedirect("FarmerHome.jsp");
		 }
		
	}

}
