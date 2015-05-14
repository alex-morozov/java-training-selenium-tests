package com.example.tests;


import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;
import static com.example.fw.GroupDataGenerator.loadGroupsFromXmlFile;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.fw.GroupData;
import com.example.utils.SortedListOf;



public class GroupCreationTests extends TestBase{	

	@DataProvider
	public Iterator<Object[]> groupsFromFile() throws IOException {
		return wrapGroupsForDataProvider(loadGroupsFromXmlFile(new File("groups.xml"))).iterator();
	}	

	@Test(dataProvider = "groupsFromFile")
	public void testGroupCreationWithValidData (GroupData group){
				
		SortedListOf<GroupData> oldList	= app.getModel().getGroups();
		
		app.getGroupHelper().createGroup(group);	  
	    
		SortedListOf<GroupData> newList = app.getModel().getGroups();	
	    
		assertThat(newList, equalTo(oldList.withAdded(group)));	   
		
		if ("yes".equals(app.getProperty("check.db"))){
			if (wantToCheck()){
			assertThat(app.getModel().getGroups(), equalTo(app.getHibernateHelper().listGroups()));	
			}
		}
		if ("yes".equals(app.getProperty("check.ui"))){
			if (wantToCheck()){
		assertThat(app.getModel().getGroups(), equalTo(app.getGroupHelper().getUiGroups()));
			}
			}
	}
	
	
	
	
	
}
