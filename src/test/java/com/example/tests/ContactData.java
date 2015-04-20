package com.example.tests;


public class ContactData implements Comparable<ContactData> {
	private String firstname;
	private String lastname;
	private String adress;
	private String homephone;
	private String mobilephone;
	private String workphone;
	private String email;
	private String birthDay;
	private String birthMonth;
	private String birthYear;
	private String group;
	private String secondadress;
	private String homeadress;

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
		this.birthDay = daybirth;
		this.birthMonth = monthbirth;
		this.birthYear = yearbirth;
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
				+ workphone + ", email=" + email + ", birthDay=" + birthDay
				+ ", birthMonth=" + birthMonth + ", birthYear=" + birthYear
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

	public ContactData withFirstname(String firstname) {
		this.firstname = firstname;
		return this;
	}

	public ContactData withLastname(String lastname) {
		this.lastname = lastname;
		return this;
	}

	public ContactData withAdress(String adress) {
		this.adress = adress;
		return this;
	}

	public ContactData withHomephone(String homephone) {
		this.homephone = homephone;
		return this;
	}

	public ContactData withMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
		return this;
	}

	public ContactData withWorkphone(String workphone) {
		this.workphone = workphone;
		return this;
	}

	public ContactData withEmail(String email) {
		this.email = email;
		return this;
	}

	public ContactData withBirthDay(String birthDay) {
		this.birthDay = birthDay;
		return this;
	}

	public ContactData withBirthMonth(String birthMonth) {
		this.birthMonth = birthMonth;
		return this;
	}

	public ContactData withBirthYear(String birthYear) {
		this.birthYear = birthYear;
		return this;
	}

	public ContactData withGroup(String group) {
		this.group = group;
		return this;
	}

	public ContactData withSecondadress(String secondadress) {
		this.secondadress = secondadress;
		return this;
	}

	public ContactData withHomeadress(String homeadress) {
		this.homeadress = homeadress;
		return this;
	}
	
	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getAdress() {
		return adress;
	}

	public String getHomephone() {
		return homephone;
	}

	public String getMobilephone() {
		return mobilephone;
	}

	public String getWorkphone() {
		return workphone;
	}

	public String getEmail() {
		return email;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public String getBirthMonth() {
		return birthMonth;
	}

	public String getBirthYear() {
		return birthYear;
	}

	public String getGroup() {
		return group;
	}

	public String getSecondadress() {
		return secondadress;
	}

	public String getHomeadress() {
		return homeadress;
	}
	

	
}