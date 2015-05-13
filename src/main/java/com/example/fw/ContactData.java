package com.example.fw;


public class ContactData implements Comparable<ContactData> {
	private String firstName;
	private String lastName;
	private String adress;
	private String homePhone;
	private String mobilePhone;
	private String workPhone;
	private String email;
	private String birthDay;
	private String birthMonth;
	private String birthYear;
	private String group;
	private String secondAdress;
	private String homeAdress;

	public ContactData(String firstName, String lastName, String adress,
			String homePhone, String mobilePhone, String workPhone,
			String email, String birthDay, String birthMonth, String birthYear,
			String group, String secondAdress, String homeAdress) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.adress = adress;
		this.homePhone = homePhone;
		this.mobilePhone = mobilePhone;
		this.workPhone = workPhone;
		this.email = email;
		this.birthDay = birthDay;
		this.birthMonth = birthMonth;
		this.birthYear = birthYear;
		this.group = group;
		this.secondAdress = secondAdress;
		this.homeAdress = homeAdress;
	}
	
	public ContactData() {
		
	}	

	@Override
	public String toString() {
		return "ContactData [firstName=" + firstName + ", lastName="
				+ lastName + ", adress=" + adress + ", homePhone="
				+ homePhone + ", mobilePhone=" + mobilePhone + ", workPhone="
				+ workPhone + ", email=" + email + ", birthDay=" + birthDay
				+ ", birthMonth=" + birthMonth + ", birthYear=" + birthYear
				+ ", group=" + group + ", secondAdress=" + secondAdress
				+ ", homeAdress=" + homeAdress + "]";
	}	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
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
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

	public int compareTo(ContactData other) {
		return this.lastName.toLowerCase().compareTo(other.lastName.toLowerCase());			
	}

	public ContactData withFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public ContactData withLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public ContactData withAdress(String adress) {
		this.adress = adress;
		return this;
	}

	public ContactData withHomePhone(String homePhone) {
		this.homePhone = homePhone;
		return this;
	}

	public ContactData withMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
		return this;
	}

	public ContactData withWorkPhone(String workPhone) {
		this.workPhone = workPhone;
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

	public ContactData withSecondAdress(String secondAdress) {
		this.secondAdress = secondAdress;
		return this;
	}

	public ContactData withHomeAdress(String homeAdress) {
		this.homeAdress = homeAdress;
		return this;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAdress() {
		return adress;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public String getWorkPhone() {
		return workPhone;
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

	public String getSecondAdress() {
		return secondAdress;
	}

	public String getHomeAdress() {
		return homeAdress;
	}
	

	
}