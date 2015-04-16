package com.example.tests;

import java.util.Collections;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class GroupCreationTests extends TestBase{	

	@Test(dataProvider = "randomValidGroupGenerator")
	public void testGroupCreationWithValidData (GroupData group){
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().goToGroupsPage();
		
		List<GroupData> oldList = app.getGroupHelper().getGroups();	
		
	    app.getGroupHelper().initGroupCreation();	   
	    app.getGroupHelper().fillGroupForm(group);
	    app.getGroupHelper().submitGroupCreation();
	    app.getNavigationHelper().goToGroupsPage();	 
	    
	    List<GroupData> newList = app.getGroupHelper().getGroups();	
	    
	    oldList.add(group);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);	    
	}
	
	
	
	
	
}
