package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase {
	
	@Test (dataProvider = "randomValidContactGenerator")
	public void deleteContact (){
		app.navigateTo().mainPage();
		
		List<ContactData> oldList = app.getContactHelper().getContacts();	
		
		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size()-1);
		
	    app.getContactHelper().initContactModification(index);	    	  
	    app.getContactHelper().deleteContact(); // может отрабатывать некорректно, поскольку кнопки Update и Delete имеют одинаковые имена
	    app.navigateTo().returnToHomePage();
	    
	    List<ContactData> newList = app.getContactHelper().getContacts();
	    
	    oldList.remove(index);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);
}

}
