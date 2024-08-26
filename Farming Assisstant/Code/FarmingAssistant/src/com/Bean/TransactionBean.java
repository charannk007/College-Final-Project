package com.Bean;

public class TransactionBean {
	String senderid,receiverid,ttype,transid,doftrans,tstatus;
	
	
	public String getsenderid() {
		return senderid;
	}
	public void setsenderid(String senderid) {
		this.senderid = senderid;
	}
	
	
	public String getreceiverid() {
		return receiverid;
	}
	public void setreceiverid(String receiverid) {
		this.receiverid = receiverid;
	}
	
	
	public String gettype() {
		return ttype;
	}
	public void setttype(String ttype) {
		this.ttype = ttype;
	}
	
	
	
	public String gettransid() {
		return transid;
	}
	public void settransid(String transid) {
		this.transid = transid;
	}
	
	
	
	
	public String getdoftrans() {
		return doftrans;
	}
	public void setdoftrans(String doftrans) {
		this.doftrans = doftrans;
	}
	
	
	
	public String gettstatus() {
		return tstatus;
	}
	public void settstatus(String tstatus) {
		this.tstatus = tstatus;
	}

}
