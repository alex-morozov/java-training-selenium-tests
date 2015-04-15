package com.example.tests;



import java.util.Collections;
import java.util.List;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class GroupCreationTests extends TestBase{

	@Test
	public void testNonEmptyGroupCreation (){
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().goToGroupsPage();
		
		List<GroupData> oldList = app.getGroupHelper().getGroups();	
		
	    app.getGroupHelper().initGroupCreation();
	    GroupData group = new GroupData();
	    group.name="name";
	    group.footer="footer";
	    group.header="header";
	    app.getGroupHelper().fillGroupForm(group);
	    app.getGroupHelper().submitGroupCreation();
	    app.getNavigationHelper().goToGroupsPage();	 
	    
	    List<GroupData> newList = app.getGroupHelper().getGroups();	
	    
	    oldList.add(group);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);	    
	}
	
	@Test
	public void testEmptyGroupCreation (){
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().goToGroupsPage();
		
		List<GroupData> oldList = app.getGroupHelper().getGroups();	
		
	    app.getGroupHelper().initGroupCreation();
	    GroupData group = new GroupData("", "", "");	    
	    app.getGroupHelper().fillGroupForm(group);
	    app.getGroupHelper().submitGroupCreation();
	    app.getNavigationHelper().goToGroupsPage();	 
	    
	    List<GroupData> newList = app.getGroupHelper().getGroups();
	    oldList.add(group);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);	
	}
	
	
	
}
