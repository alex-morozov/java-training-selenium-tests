package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class ContactData {
	public String firstname;
	public String secondname;
	public String adress;
	public String homephone;
	public String mobilephone;
	public String workphone;
	public String email;
	public String daybirth;
	public String monthbirth;
	public String yearbirth;
	public String group;
	public String secondadress;
	public String homeadress;

	public ContactData(String firstname, String secondname, String adress,
			String homephone, String mobilephone, String workphone,
			String email, String daybirth, String monthbirth, String yearbirth,
			String group, String secondadress, String homeadress) {
		this.firstname = firstname;
		this.secondname = secondname;
		this.adress = adress;
		this.homephone = homephone;
		this.mobilephone = mobilephone;
		this.workphone = workphone;
		this.email = email;
		this.daybirth = daybirth;
		this.monthbirth = monthbirth;
		this.yearbirth = yearbirth;
		this.group = group;
		this.secondadress = secondadress;
		this.homeadress = homeadress;
	}
	
	public ContactData() {
		
	}

	
}