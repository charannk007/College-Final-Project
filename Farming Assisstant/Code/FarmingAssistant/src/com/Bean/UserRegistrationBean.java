package com.Bean;

public class UserRegistrationBean {

	private String username,password,utype;
	private String name,address,phoneno;

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
	
	public void setname(String name)
	{
		this.name=name;
	}
	
	public String getname()
	{
		return name;
	}
	
	public void setphoneno(String phone)
	{
		this.phoneno=phone;
	}
	public String getphoneno()
	{
		return phoneno;
	}
	public void setaddress(String addr)
	{
		this.address=addr;
	}
	public String getaddress()
	{
		return address;
	}
}
