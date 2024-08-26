package com.Implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.Bean.DataBean;
import com.Bean.TransactionBean;
import com.Bean.UserRegistrationBean;
import com.DBConnections.DatabaseCon;
import com.Interface.FarmInterface;

public class FarmImplementation implements FarmInterface{

	static Connection con;
	int k=0;
	public int UserRegistration(UserRegistrationBean URB) {
		// TODO Auto-generated method stub
		con = DatabaseCon.createConnection();
		System.out.println(con);
		
		try
		{
			PreparedStatement obj = con.prepareStatement("INSERT INTO `farmassistant`.`userregistration` VALUES(?,?,?,?,?,?)");
			obj.setString(1, URB.getusername());
			obj.setString(2, URB.getPassword());
			obj.setString(3, URB.getutype());
			obj.setString(4, URB.getname());
			obj.setString(5, URB.getaddress());
			obj.setString(6, URB.getphoneno());
			k = obj.executeUpdate();
			System.out.println("k======"+k);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return k;
	}
	@Override
	public int UserLogin(String emailid, String password,String utype) {
		// TODO Auto-generated method stub
		con = DatabaseCon.createConnection();
//		System.out.println(con);
		
		try
		{
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("SELECT * FROM `farmassistant`.`userregistration` where utype='"+utype+"'");
			
//			System.out.println(emailid);
//			System.out.println(password);
			
			while(rs.next())
			{
				String emailidch = rs.getString("username");
				String passwordch = rs.getString("password");
				
//				System.out.println(emailidch +" "+ passwordch);
				
				if(emailidch.equals(emailid) && passwordch.equals(password))
				{
					
					k=1;
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
//			System.out.println(e);
		}
		return k;
	}
	
	public String GenUserID(String Utype)
	{
		String userid="";
		
		
		con = DatabaseCon.createConnection();
//		System.out.println(con);
	
		try
		{
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("SELECT count(*) as ucount FROM `farmassistant`.`userregistration` where utype='"+Utype+"'");
			
				
			while(rs.next())
			{
				String emailidch = rs.getString("ucount");
			    int value=Integer.parseInt(emailidch)+1;
				userid=Utype+String.valueOf(value);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
//			System.out.println(e);
		}
		
		
		
		
		
		return userid;
	}
	@Override
	public int PostTips(DataBean DB) {
		// TODO Auto-generated method stub
		con = DatabaseCon.createConnection();
//		System.out.println(con);
		
		try
		{
			PreparedStatement obj = con.prepareStatement("INSERT INTO `farmassistant`.`farmingtips` VALUES(?,?)");
			obj.setString(1, DB.gettitle());
			obj.setString(2, DB.getcomment());
//			obj.setString(3, "Pending");

			k = obj.executeUpdate();
//			System.out.println("k======"+k);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return k;
	}
	@Override
	public int PostComp(DataBean DB) {
		// TODO Auto-generated method stub
		con = DatabaseCon.createConnection();
//		System.out.println(con);
		
		try
		{
			PreparedStatement obj = con.prepareStatement("INSERT INTO `farmassistant`.`compliant` VALUES(?,?,?,?)");
			obj.setString(1, DB.gettitle());
			obj.setString(2, DB.getcomment());
			obj.setString(3, "Pending");
			obj.setString(4, DB.getfarmer());

			k = obj.executeUpdate();
//			System.out.println("k======"+k);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return k;
	}
	
	@Override
	public int PostAd(DataBean DB) {
		// TODO Auto-generated method stub
		con = DatabaseCon.createConnection();
//		System.out.println(con);
		
		try
		{
			PreparedStatement obj = con.prepareStatement("INSERT INTO `farmassistant`.`adpost` VALUES(?,?,?,?,?,?,?,?)");
			obj.setString(1, DB.gettitle());
			obj.setString(2, DB.getcropname());
			obj.setString(3, DB.getquantity());
			obj.setString(4, DB.getimagepath());
			obj.setString(5, DB.getpostedby());
			obj.setString(6, "Waiting");
			obj.setString(7, "0");
			obj.setString(8, "Waiting");
			k = obj.executeUpdate();
//			System.out.println("k======"+k);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return k;
	}
	
	@Override
	public int SellProduct(DataBean DB) {
		// TODO Auto-generated method stub
		con = DatabaseCon.createConnection();
//		System.out.println(con);
		
		try
		{
			PreparedStatement obj = con.prepareStatement("update `farmassistant`.`adpost` set cropcost=?,status='Accept',acceptby=? where title=? and cropname=? and postby=?");
			obj.setString(1, DB.getcropprice());
			obj.setString(2, DB.getcomment());
			obj.setString(3, DB.gettitle());
			obj.setString(4, DB.getcropname());
			obj.setString(5, DB.getpostedby());
			
			k = obj.executeUpdate();
//			System.out.println("k======"+k);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return k;
	}
	
	@Override
	public int SolveCompliant(DataBean DB) {
		// TODO Auto-generated method stub
		con = DatabaseCon.createConnection();
//		System.out.println(con);
		
		try
		{
			PreparedStatement obj = con.prepareStatement("update `farmassistant`.`compliant` set status='Solved' where title=? and farmer=?");
			obj.setString(1, DB.gettitle());
			obj.setString(2, DB.getfarmer());
			k = obj.executeUpdate();
//			System.out.println("k======"+k);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return k;
	}
	@Override
	public int AllTransactions(TransactionBean TB) {
		// TODO Auto-generated method stub
		con = DatabaseCon.createConnection();
//		System.out.println(con);
		
		try
		{
			PreparedStatement obj = con.prepareStatement("INSERT INTO `farmassistant`.`transactions`(sender,receiver,ttype,transid,doftrans,status) VALUES(?,?,?,?,?,?)");
			obj.setString(1, TB.getsenderid());
			obj.setString(2, TB.getreceiverid());
			obj.setString(3, TB.gettype());
			obj.setString(4, TB.gettransid());
			obj.setString(5, TB.getdoftrans());
			obj.setString(6, TB.gettstatus());
			k = obj.executeUpdate();
//			System.out.println("k======"+k);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return k;
	}
}
