package com.example.tests;

import static org.testng.AssertJUnit.assertTrue;
import org.openqa.selenium.By;
import org.testng.annotations.Test;



public class ContactCreationTest extends TestBase {
	
	@Test
	public void addContact (){
		app.getNavigationHelper().openMainPage();
	    app.getContactHelper().goToAddContact();
	    ContactData contact = new ContactData();
	    contact.adress="New-York";
	    contact.daybirth="10";
	    contact.email="test@gmail.com";
	    contact.firstname="John";
	    contact.group="Rob";
	    contact.homeadress="Wales";
	    contact.homephone="2-12-85-06";
	    contact.mobilephone="911";
	    contact.monthbirth="May";
	    contact.secondadress="London";
	    contact.secondname="Doe";
	    contact.workphone="02";
	    contact.yearbirth="1988";	  
	    app.getContactHelper().fillContactForm(contact);	  
	    app.getContactHelper().submit();
 }
}
