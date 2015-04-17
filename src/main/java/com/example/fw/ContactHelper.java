package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.example.tests.ContactData;
import com.example.tests.GroupData;
import com.example.tests.TestBase;


public class ContactHelper extends HelperBase {

	public ContactHelper(ApplicationManager manager) {
		super(manager);		
	}

	public void goToAddContact() {
		click(By.linkText("add new"));
	}
	
	public void submit() {
		click(By.name("submit"));
	}

	public void fillContactForm(ContactData contact) {
		type(By.name("firstname"), contact.firstname);	
		type(By.name("lastname"), contact.lastname);
		type(By.name("address"), contact.adress);		
		type(By.name("home"), contact.homephone);		
		type(By.name("mobile"), contact.mobilephone);		
		type(By.name("work"), contact.workphone);		
		type(By.name("email"), contact.email);		
		selectByText(By.name("bday"), contact.daybirth);
		selectByText(By.name("bmonth"), contact.monthbirth);		
		type(By.name("byear"), contact.yearbirth);	
		selectByText(By.name("new_group"), contact.group);	
		type(By.name("address2"), contact.secondadress);		
		type(By.name("phone2"), contact.homeadress);
	}

	public void initContactModification(int index) {
		selectContactByIndex(index);		
	}

	public void selectContactByIndex(int index) {
		click(By.xpath("//*[@id='maintable']/tbody/tr[" + index + "]/td[7]/a/img"));
	}

	public void submitContactModification() {
		click(By.name("update"));		
	}

	public void deleteContact() {
		click(By.name("update"));		
	}

	public List<ContactData> getContacts() {
		List<ContactData> contacts = new ArrayList<ContactData>();
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {
			ContactData contact = new ContactData();
			String title = checkbox.getAttribute("title");			
			contact.lastname = title.substring("Select (".length(), title.length() - ")".length() );
			contacts.add(contact);
		}
		return contacts;
	}

	

}
