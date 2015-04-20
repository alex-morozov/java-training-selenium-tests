package com.example.tests;


import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;
import com.example.utils.SortedListOf;




public class ContactCreationTests extends TestBase {
	
	@Test (dataProvider = "randomValidContactGenerator")
	public void addContact (ContactData contact){
		SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();	
		
		app.getContactHelper().createGroup(contact);		
			    
	    
	    SortedListOf<ContactData> newList = app.getContactHelper().getContacts();	
	    
	    assertThat(newList, equalTo(oldList.withAdded(contact)));
 }
}
