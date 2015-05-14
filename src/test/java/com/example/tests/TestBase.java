package com.example.tests;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import com.example.fw.ApplicationManager;
import com.example.fw.ContactData;
import com.example.fw.GroupData;

import static com.example.fw.ContactDataGenerator.*;
import static com.example.fw.GroupDataGenerator.*;

public class TestBase {
	
	protected static ApplicationManager app;
	private int checkCounter;
	private int checkFrequency;
		
	@BeforeTest (alwaysRun = true)
	  public void setUp () throws FileNotFoundException, IOException{
		String configFile = System.getProperty("configFile", "application.properties");
		Properties properties =new Properties();
		properties.load(new FileReader(new File(configFile)));
		app = new ApplicationManager(properties);
		checkCounter = 0;
		checkFrequency = Integer.parseInt(properties.getProperty("check.frequency", "0"));	 
	  }
	
	protected boolean wantToCheck(){
		checkCounter++;
		if (checkCounter > checkFrequency){
			checkCounter = 0;
			return true;
		} else {
			return false;
		}
		
	}
	
	@AfterTest (alwaysRun = true)
	public void tearDown (){
		app.stop();		
	}
	
	@DataProvider
	public Iterator<Object[]> randomValidGroupGenerator(){
		return wrapGroupsForDataProvider(generateRandomGroups(5)).iterator();
}
	
	public static List<Object[]> wrapGroupsForDataProvider(List<GroupData> groups) {
		List<Object[]> list = new ArrayList<Object[]>();
		for (GroupData group : groups) {
			list.add(new Object[]{group});
		}
		return list;
	}

	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator(){
		return wrapContactsForDataProvider(generateRandomContacts(5)).iterator();
}
	
	public static List<Object[]> wrapContactsForDataProvider(List<ContactData> contacts) {
		List<Object[]> list = new ArrayList<Object[]>();
		for (ContactData contact : contacts) {
			list.add(new Object[]{contact});
		}
		return list;
	}

	
	
}
