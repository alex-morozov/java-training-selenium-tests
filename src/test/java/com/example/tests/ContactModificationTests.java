package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase{

	@Test (dataProvider = "randomValidContactGenerator")
	public void editContact (ContactData contact){
		app.getNavigationHelper().openMainPage();
		
		List<ContactData> oldList = app.getContactHelper().getContacts();
		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size()-1);
		
	    app.getContactHelper().initContactModification(index);	        
	    app.getContactHelper().fillContactForm(contact);	  
	    app.getContactHelper().submitContactModification();
	    app.getNavigationHelper().returnToHomePage();
	    
	    List<ContactData> newList = app.getContactHelper().getContacts();	
	    
	    oldList.remove(index);    
	    oldList.add(contact);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);
	    
}
	
}