package com.Bean;

public class DataBean {

	
	private String title,comment,farmer;

	private String cropname,quantity,imagepath,postedby,status,cropprice;
	public String gettitle() {
		return title;
	}

	public void settitle(String title) {
		this.title= title;
	}

	public String getcomment() {
		return comment;
	}

	public void setcomment(String comment) {
		this.comment= comment;
	}
	public String getfarmer() {
		return farmer;
	}

	public void setfarmer(String farmer) {
		this.farmer= farmer;
	}
	
	public String getcropname() {
		return cropname;
	}

	public void setcropname(String cropname) {
		this.cropname= cropname;
	}
	
	public String getquantity() {
		return quantity;
	}

	public void setquantity(String quantity) {
		this.quantity= quantity;
	}
	
	
	public String getimagepath() {
		return imagepath;
	}

	public void setimagepath(String imagepath) {
		this.imagepath= imagepath;
	}
	
	public String getpostedby() {
		return postedby;
	}

	public void setpostedby(String postedby) {
		this.postedby= postedby;
	}
	
	public String getstatus() {
		return status;
	}

	public void setstatus(String status) {
		this.status=status;
	}
	
	
	public String getcropprice() {
		return cropprice;
	}

	public void setcropprice(String cropprice) {
		this.cropprice=cropprice;
	}
	
	
}
