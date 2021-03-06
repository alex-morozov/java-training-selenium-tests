package com.example.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public abstract class WebDriverHelperBase extends HelperBase{
	

protected WebDriver driver;

public WebDriverHelperBase (ApplicationManager manager){
	super(manager);	
	this.driver=manager.getDriver();
}

public boolean isElementPresent(By by) {
    try {
    driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

protected void type(By locator, String text) {
	if (text != null){
	driver.findElement(locator).clear();	  
	driver.findElement(locator).sendKeys(text);
	}
}

protected void click(By locator) {
	driver.findElement(locator).click();
}

protected void selectByText(By locator, String text) {
	if (text != null){
	new Select(driver.findElement(locator)).selectByVisibleText(text);
	}
}

}
