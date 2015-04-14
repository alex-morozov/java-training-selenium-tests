package com.example.tests;

import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase {
	
	@Test
	public void modifySomeGroup (){
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().goToGroupsPage();
	    app.getGroupHelper().initGroupModification(1);
	    GroupData group = new GroupData();
	    group.groupname=" new name";	   
	    app.getGroupHelper().fillGroupForm(group);
	    app.getGroupHelper().submitGroupModification();// не срабатывает
	    app.getNavigationHelper().goToGroupsPage();	   	   
	}

}
