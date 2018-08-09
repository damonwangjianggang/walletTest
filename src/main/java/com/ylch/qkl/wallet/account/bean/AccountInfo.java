package com.ylch.qkl.wallet.account.bean;

public class AccountInfo {
    private String userName;
    
    private String phone;
 
    private String address;
 
    private String school;

	public AccountInfo(String userName, String phone, String address, String school) {
		super();
		this.userName = userName;
		this.phone = phone;
		this.address = address;
		this.school = school;
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

	@Override
	public String toString() {
		return "AccountInfo [userName=" + userName + ", phone=" + phone + ", address=" + address + ", school=" + school
				+ "]";
	}
    

}
