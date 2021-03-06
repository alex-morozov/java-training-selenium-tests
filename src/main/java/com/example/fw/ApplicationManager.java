package com.example.fw;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ApplicationManager {
	private WebDriver driver;	
	public String baseURL;
	
	private NavigationHelper navigationHelper;
	private GroupHelper groupHelper;
	private ContactHelper contactHelper;	
	private Properties properties;
	private HibernateHelper hibernateHelper;
	
	private ApplicationModel model;
	
	
	public ApplicationManager(Properties properties){
		  this.properties = properties;		
		  model = new ApplicationModel();
		  model.setGroups(getHibernateHelper().listGroups());
	}

	public void stop() {
		driver.quit();		
	}
	
	public ApplicationModel getModel(){
		return model;
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

	public WebDriver getDriver() {
		  String browser = properties.getProperty("browser");
		if (driver ==null) {
			 if ("firefox".equals(browser)){
				  driver = new FirefoxDriver();
			  } else if ("ie".equals(browser)){
				  driver = new InternetExplorerDriver();
			  } else {
				  throw new Error("Unsupported browser: " + browser);
			  }
			  
			  baseURL = properties.getProperty("baseURL");	
			  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
			  driver.get(baseURL);			
		}
		return  driver;
	}
	
	public HibernateHelper getHibernateHelper(){
		if (hibernateHelper ==null) {
			hibernateHelper = new HibernateHelper(this);			
		}
		return  hibernateHelper;
	}
	
	public String getProperty(String key){
		return properties.getProperty(key);
	}


	
}
