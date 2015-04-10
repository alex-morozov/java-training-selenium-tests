package com.example.fw;

import org.openqa.selenium.By;

import com.example.tests.GroupData;



public class GroupHelper extends HelperBase {

	public GroupHelper(ApplicationManager manager) {
		super(manager);		
	}

	public void fillGroupCreationForm(GroupData group) {
		type(By.name("group_name"), group.groupname);
		type(By.name("group_header"), group.groupheader);
		type(By.name("group_footer"), group.groupfooter);		
	    driver.findElement(By.name("submit")).click();
	}

	public void initGroupCreation() {
		click(By.name("new"));
	}

}
