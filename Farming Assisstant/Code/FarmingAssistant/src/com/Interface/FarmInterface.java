package com.Interface;

import com.Bean.DataBean;
import com.Bean.TransactionBean;
import com.Bean.UserRegistrationBean;

public interface FarmInterface {

	public int UserRegistration(UserRegistrationBean URB);
	public int UserLogin(String username,String password,String utype);
	public String GenUserID(String Utype);
	public int PostTips(DataBean DB);
	public int PostComp(DataBean DB);
	public int PostAd(DataBean DB);
	public int SellProduct(DataBean DB);
	public int SolveCompliant(DataBean DB);
	public int AllTransactions(TransactionBean TB);
}
