package com.example.tests;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.fw.ContactData;
import com.example.utils.SortedListOf;

import static com.example.fw.ContactDataGenerator.*;

public class ContactCreationTests extends TestBase {
	    @DataProvider
		public Iterator<Object[]> contactsFromFile() throws IOException {
			return wrapContactsForDataProvider(loadContactsFromXmlFile(new File("contacts.xml"))).iterator();
		}		
		
	
	@Test(dataProvider = "contactsFromFile")
	public void addContact (ContactData contact){
		SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();	
		
		app.getContactHelper().createGroup(contact);				    
	    
	    SortedListOf<ContactData> newList = app.getContactHelper().getContacts();	
	    
	    assertThat(newList, equalTo(oldList.withAdded(contact)));
 }
}
