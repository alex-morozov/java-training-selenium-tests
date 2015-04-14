package com.example.tests;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase {
	@Test
	public void deleteContact (){
		app.getNavigationHelper().openMainPage();
	    app.getContactHelper().initContactModification(2);	    	  
	    app.getContactHelper().deleteContact(); // может отрабатывать некорректно, поскольку кнопки Update и Delete имеют одинаковые имена
}

}
