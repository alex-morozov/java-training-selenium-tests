package com.example.tests;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;


import java.util.Random;
import org.testng.annotations.Test;

import com.example.fw.ContactData;
import com.example.utils.SortedListOf;


public class ContactModificationTests extends TestBase{

	@Test (dataProvider = "randomValidContactGenerator")
	public void editContact (ContactData contact){			
		SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();
		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size()-1);
		
		app.getContactHelper().modifyContact(contact);
	    
		SortedListOf<ContactData> newList = app.getContactHelper().getContacts();	
		
	    assertThat(newList, equalTo(oldList.without(index).withAdded(contact)));	    
}
	
}