package com.example.tests;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.example.fw.ApplicationManager;

public class TestBase {
	
	protected ApplicationManager app;
		
	@BeforeTest (alwaysRun = true)
	  public void init (){
		app = new ApplicationManager();
	 
	  }
	
	@AfterTest (alwaysRun = true)
	public void stop (){
		app.stop();
		
	}
}
