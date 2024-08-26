package com.Bean;

public class UserLoginBean {

	private String username,password,utype;

	public String getusername() {
		return username;
	}

	public void setusername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setusertype(String utype)
	{
		this.utype=utype;
		
	}
	
	public String getutype()
	{
		return utype;
	}
	
}
