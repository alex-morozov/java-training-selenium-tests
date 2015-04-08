package training.common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class TestBase {
	public static WebDriver driver = new FirefoxDriver();	
	public static String baseURL = "http://localhost/addressbookv4.1.4/";
		
	@BeforeTest (alwaysRun = true)
	  public void init (){
	  driver.get(baseURL);
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  }
	
	@AfterTest (alwaysRun = true)
	public void stop (){
		driver.quit();
	}

	protected void fillGroupCreationForm(GroupData group) {
		driver.findElement(By.name("group_name")).clear();
	    driver.findElement(By.name("group_name")).sendKeys(group.groupname);
	    driver.findElement(By.name("group_header")).clear();
	    driver.findElement(By.name("group_header")).sendKeys(group.groupheader);
	    driver.findElement(By.name("group_footer")).clear();
	    driver.findElement(By.name("group_footer")).sendKeys(group.groupfooter);
	    driver.findElement(By.name("submit")).click();
	}

	protected void initGroupCreation() {
		driver.findElement(By.name("new")).click();
	}

	protected void goToGroupsPage() {
		driver.findElement(By.linkText("groups")).click();
	}

	protected boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }
}
