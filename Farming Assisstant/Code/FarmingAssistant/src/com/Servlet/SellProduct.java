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
 * Servlet implementation class SellProduct
 */
@WebServlet("/SellProduct")
public class SellProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellProduct() {
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
		 String cropname = request.getParameter("cropname");
		 String quantity = request.getParameter("quantity");
		 String supplier = request.getParameter("suplliername");
		 String price = request.getParameter("cropprice");
		
		 String farmername=session.getAttribute("farmer").toString();
//		 System.out.println("farmername :"+farmername);
		
		//Getting Current date
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String trans_date = df.format(new Date());
		
		
		TransactionBean TB=new TransactionBean();
		TB.setsenderid(farmername);
		TB.setreceiverid(supplier);
		TB.setttype("Sale");
		TB.settransid(title);
		TB.setdoftrans(trans_date);
		TB.settstatus("Processing");
		
		
		FarmInterface Fi=new FarmImplementation();
		Fi.AllTransactions(TB);
		 
		 
		 
		 DataBean db=new DataBean();
		 db.settitle(title);
		 db.setcropname(cropname);
		 db.setquantity(quantity);
		 db.setpostedby(supplier);
		 db.setcropprice(price);
		 db.setcomment(farmername);
		 
		 FarmInterface FI=new FarmImplementation();
			
		 int i=FI.SellProduct(db);
		 
		 if(i==1)
		 {
			 response.sendRedirect("FarmerHome.jsp");
		 }
	
		 else
		 {
			 response.sendRedirect("FAdPost.jsp");
		 }
		 
		 
		
	}

}
