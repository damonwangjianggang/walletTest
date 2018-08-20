package com.ylch.qkl.wallet.util.bean;

public class RequestBodyBean {
	//AccountController 接口 参数信息
	  //rule: /getAccountsInfo
	private String accountId;
	  //rule: /createAccount
	private String accountName;
	private String 	password;
	private String userName;
    private String phone;
    private String address;
    private String school;

    //tradeConTroller 接口 参数信息
	  //rule: /sendTrasfer
	private String fromAccountId;
	private String toAccountId;
	private String fromAccountIdPassword;
	private String amount;
	private String data;
	  //rule: /getTrasferInfo
	private String tranferHash;

	private String ip;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getTranferHash() {
		return tranferHash;
	}

	public void setTranferHash(String tranferHash) {
		this.tranferHash = tranferHash;
	}

	public String getFromAccountIdPassword() {
		return fromAccountIdPassword;
	}

	public void setFromAccountIdPassword(String fromAccountIdPassword) {
		this.fromAccountIdPassword = fromAccountIdPassword;
	}

	public void setFromAccountId(String fromAccountId) {
		this.fromAccountId = fromAccountId;
	}

	public String getFromAccountId() {
		return fromAccountId;
	}

	public void setToAccountId(String toAccountId) {
		this.toAccountId = toAccountId;
	}



	public void setAmount(String amount) {
		this.amount = amount;
	}

	public void setData(String data) {
		this.data = data;
	}



	public String getToAccountId() {
		return toAccountId;
	}



	public String getAmount() {
		return amount;
	}

	public String getData() {
		return data;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}
	
	

}
