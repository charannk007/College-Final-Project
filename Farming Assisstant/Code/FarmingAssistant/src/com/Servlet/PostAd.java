package com.Servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;
import javax.servlet.*;

import javax.servlet.http.*;
import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.*;
import org.apache.commons.fileupload.servlet.*;
import org.apache.commons.io.output.*;

import com.Bean.DataBean;
import com.Bean.TransactionBean;
import com.Implementation.FarmImplementation;
import com.Interface.FarmInterface;

/**
 * Servlet implementation class PostAd
 */
@WebServlet("/PostAd")
public class PostAd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostAd() {
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
       // session.setAttribute("uname",n);  
		 
		 String imgpath="";
		 String supplier=session.getAttribute("supplier").toString();
		 session.setAttribute("supplier",supplier);
		 String fileName="";
		 String title="";
		 String cropname="";
		 String quantity = null;
		 String arrdata[]=new String[3];
				 /////////////////////////////////////////////////////////////////////////////////////////
		 
		 
	 
	        	
		 
		 
		 
		 
		   File file ;
		   int maxFileSize = 5000 * 1024;
		   int maxMemSize = 5000 * 1024;
		  // GenericServlet pageContext;
		ServletContext context =request.getServletContext();
		   String filePath = context.getInitParameter("file-upload");

		   // Verify the content type
		   String contentType = request.getContentType();
		   
		   if ((contentType.indexOf("multipart/form-data") >= 0)) {
		      DiskFileItemFactory factory = new DiskFileItemFactory();
		      // maximum size that will be stored in memory
		      factory.setSizeThreshold(maxMemSize);
		      
		         // Location to save data that is larger than maxMemSize.
		      factory.setRepository(new File("c:\\temp"));

		      // Create a new file upload handler
		      ServletFileUpload upload = new ServletFileUpload(factory);
		      
		      // maximum file size to be uploaded.
		      upload.setSizeMax( maxFileSize );
		      
		      try { 
		         // Parse the request to get file items.
		         List fileItems = upload.parseRequest(request);

		         // Process the uploaded file items
		         Iterator i = fileItems.iterator();

		         int jj=0;
		         while ( i.hasNext () ) {
		            FileItem fi = (FileItem)i.next();
	            	   if ( !fi.isFormField () ) {

	  		         
		   		  
		               // Get the uploaded file parameters
		               String fieldName = fi.getFieldName();
		               fileName = fi.getName();
		               boolean isInMemory = fi.isInMemory();
		               long sizeInBytes = fi.getSize();
		            
		               // Write the file
		               if( fileName.lastIndexOf("\\") >= 0 ) {
		                  file = new File( filePath + 
		                  fileName.substring( fileName.lastIndexOf("\\"))) ;
//		                  System.out.println(fileName);
		               } else {
		                  file = new File( filePath + 
		                  fileName.substring(fileName.lastIndexOf("\\")+1)) ;
//		                  System.out.println(fileName);
		               }
		               fi.write( file ) ;
		               imgpath=fileName;
//		               System.out.println(fileName);
		            //   out.println("Uploaded Filename: " + filePath + 
		          //     fileName + "<br>");
		            }
	            	   else
	            	   {
	            		   String data=fi.getString();
	            		   arrdata[jj]=data;
	            		   jj++;
//	            		   System.out.println(data);
	            		   
	            		 
	            		 
	            	
	            	   }
		         }
		       //  out.println("</body>");
		       //  out.println("</html>");
		      } catch(Exception ex) {
		         System.out.println(ex);
		      }
		   } else {
		    
		   }
		
		 
		 
		 
		   title = arrdata[0];
	       cropname =  arrdata[1];
		   quantity= arrdata[2];
		 
		 
		 
		   System.out.println("post crop "+title+" "+cropname+" "+quantity+" "+supplier);
		 //////////////////////////////////////////////////////////////////////////////////////////
		 
		   //Getting Current date
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			String trans_date = df.format(new Date()); 
		 
		 	TransactionBean TB=new TransactionBean();
			TB.setsenderid(supplier);
			TB.setreceiverid("To Farmer");
			TB.setttype("Post");
			TB.settransid(title);
			TB.setdoftrans(trans_date);
			TB.settstatus("Processing");
			
			
			FarmInterface Fi=new FarmImplementation();
			Fi.AllTransactions(TB);
		
		   DataBean db=new DataBean();
		   db.settitle(title);
		   db.setcropname(cropname);
		   db.setquantity(quantity);
		   db.setimagepath(imgpath);
		   db.setpostedby(supplier);
		 
		   FarmInterface FI=new FarmImplementation();
			
			 int i=FI.PostAd(db);
			 
			 if(i==1)
			 {
				 response.sendRedirect("SupplierHome.jsp");
			 }
		
			 else
			 {
				 response.sendRedirect("SPostAd.jsp");
			 }
 
		   
		   
		
		 
		 
		 
		
	}

}
