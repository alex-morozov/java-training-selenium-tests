package com.example.fw;

import org.openqa.selenium.By;

import com.example.tests.GroupData;



public class GroupHelper extends HelperBase {

	public GroupHelper(ApplicationManager manager) {
		super(manager);		
	}

	public void fillGroupForm(GroupData group) {
		type(By.name("group_name"), group.groupname);
		type(By.name("group_header"), group.groupheader);
		type(By.name("group_footer"), group.groupfooter);		
	    driver.findElement(By.name("submit")).click();
	}

	public void initGroupCreation() {
		click(By.name("new"));
	}

	public void initGroupModification(int index) {		
		selectGroupByIndex(index);
		click(By.name("edit"));
	}
	
	public void deleteGroup (int index) {
		selectGroupByIndex(index);
		click(By.name("delete"));
	}

	public void selectGroupByIndex(int index) {
		click(By.xpath("//input[@name = 'selected[]'][" + index + "]"));
	}

	public void submitGroupModification() {
		click(By.name("update"));		
	}

}
