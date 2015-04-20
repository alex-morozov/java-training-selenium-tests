package com.example.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.example.fw.ContactHelper.CREATION;



public class ContactCreationTests extends TestBase {
	
	@Test (dataProvider = "randomValidContactGenerator")
	public void addContact (ContactData contact){
		app.navigateTo().mainPage();
	    app.getContactHelper().goToAddContact();	    
		    
	    List<ContactData> oldList = app.getContactHelper().getContacts();		   
	    
	    app.getContactHelper().fillContactForm(contact, CREATION);	  
	    app.getContactHelper().submit();
	    app.navigateTo().returnToHomePage();	    
	    
	    List<ContactData> newList = app.getContactHelper().getContacts();	
	    
	    oldList.add(contact);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);
 }
}
