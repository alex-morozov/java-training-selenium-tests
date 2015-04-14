package com.example.tests;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase{

	@Test
	public void editContact (){
		app.getNavigationHelper().openMainPage();
	    app.getContactHelper().initContactModification(2);
	    ContactData contact = new ContactData();
	    contact.adress="London";	    
	    app.getContactHelper().fillContactForm(contact);	  
	    app.getContactHelper().submitContactModification();
}
}