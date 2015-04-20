package com.example.fw;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ApplicationManager {
	public WebDriver driver;	
	public String baseURL;
	
	private NavigationHelper navigationHelper;
	private GroupHelper groupHelper;
	private ContactHelper contactHelper;
	
	
	public ApplicationManager(){
		  driver = new FirefoxDriver();
		  baseURL = "http://localhost/addressbookv4.1.4/";		
		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
		  driver.get(baseURL);
	}

	public void stop() {
		driver.quit();		
	}
	
	public NavigationHelper navigateTo(){
		if (navigationHelper ==null) {
			 navigationHelper = new NavigationHelper(this);			
		}
		return  navigationHelper;
	}
	
	public ContactHelper getContactHelper(){
		if (contactHelper ==null) {
			contactHelper = new ContactHelper(this);			
		}
		return  contactHelper;
	}
	
	public GroupHelper getGroupHelper(){
		if (groupHelper ==null) {
			groupHelper = new GroupHelper(this);			
		}
		return  groupHelper;
	}
	
}
