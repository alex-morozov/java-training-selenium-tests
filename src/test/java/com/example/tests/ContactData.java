package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class ContactData implements Comparable<ContactData> {
	public String firstname;
	public String lastname;
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
		this.lastname = secondname;
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
	
	

	@Override
	public String toString() {
		return "ContactData [firstname=" + firstname + ", lastname="
				+ lastname + ", adress=" + adress + ", homephone="
				+ homephone + ", mobilephone=" + mobilephone + ", workphone="
				+ workphone + ", email=" + email + ", daybirth=" + daybirth
				+ ", monthbirth=" + monthbirth + ", yearbirth=" + yearbirth
				+ ", group=" + group + ", secondadress=" + secondadress
				+ ", homeadress=" + homeadress + "]";
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactData other = (ContactData) obj;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		return true;
	}

	public int compareTo(ContactData other) {
		return this.lastname.toLowerCase().compareTo(other.lastname.toLowerCase());			
	}

	
}