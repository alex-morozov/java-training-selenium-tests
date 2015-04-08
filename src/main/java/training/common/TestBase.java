package training.common;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
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

	protected void submit() {
		driver.findElement(By.name("submit")).click();
	}

	protected void fillContactForm(ContactData contact) {
		driver.findElement(By.name("firstname")).clear();
		driver.findElement(By.name("firstname")).sendKeys(contact.firstname);
		driver.findElement(By.name("lastname")).clear();
		driver.findElement(By.name("lastname")).sendKeys(contact.secondname);
		driver.findElement(By.name("address")).clear();
		driver.findElement(By.name("address")).sendKeys(contact.adress);
		driver.findElement(By.name("home")).clear();
		driver.findElement(By.name("home")).sendKeys(contact.homephone);
		driver.findElement(By.name("mobile")).clear();
		driver.findElement(By.name("mobile")).sendKeys(contact.mobilephone);
		driver.findElement(By.name("work")).clear();
		driver.findElement(By.name("work")).sendKeys(contact.workphone);	
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys(contact.email);
		new Select(driver.findElement(By.name("bday"))).selectByVisibleText(contact.daybirth);
		new Select(driver.findElement(By.name("bmonth"))).selectByVisibleText(contact.monthbirth);
		driver.findElement(By.name("byear")).clear();
		driver.findElement(By.name("byear")).sendKeys(contact.yearbirth);
		new Select(driver.findElement(By.name("new_group"))).selectByVisibleText(contact.group);
		driver.findElement(By.name("address2")).clear();
		driver.findElement(By.name("address2")).sendKeys(contact.secondadress);
		driver.findElement(By.name("phone2")).clear();
		driver.findElement(By.name("phone2")).sendKeys(contact.homeadress);
	}

	protected void goToAddContact() {
		driver.findElement(By.linkText("add new")).click();
	}
}
