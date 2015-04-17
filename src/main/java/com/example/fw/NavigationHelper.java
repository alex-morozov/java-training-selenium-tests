package com.example.fw;

import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase {

	public NavigationHelper(ApplicationManager manager) {
		super(manager);		
	}

	public void goToGroupsPage() {
		click(By.linkText("groups"));
	}

	public void openMainPage() {
		driver.get(manager.baseURL);
	}

	public void returnToHomePage() {
		click(By.linkText("home page"));		
	}

}
