package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class GroupRemovalTests extends TestBase {
	
	@Test
	public void deleteSomeGroup (){
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().goToGroupsPage();
		
		List<GroupData> oldList = app.getGroupHelper().getGroups();	
		
	    app.getGroupHelper().deleteGroup(0);	    
	    app.getNavigationHelper().goToGroupsPage();	  
	    
        List<GroupData> newList = app.getGroupHelper().getGroups();	
	    
	    oldList.remove(0);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);	 
	}


}
