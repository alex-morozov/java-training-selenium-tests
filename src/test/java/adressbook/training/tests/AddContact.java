package adressbook.training.tests;

import static org.testng.AssertJUnit.assertTrue;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import training.common.ContactData;
import training.common.TestBase;

public class AddContact extends TestBase {
	
	@Test
	public void addContact (){
	    goToAddContact();
	    ContactData contact = new ContactData();
	    contact.adress="New-York";
	    contact.daybirth="10";
	    contact.email="test@gmail.com";
	    contact.firstname="John";
	    contact.group="Rob";
	    contact.homeadress="Wales";
	    contact.homephone="2-12-85-06";
	    contact.mobilephone="911";
	    contact.monthbirth="May";
	    contact.secondadress="London";
	    contact.secondname="Doe";
	    contact.workphone="02";
	    contact.yearbirth="1988";	  
	    fillContactForm(contact);	  
	    submit();
	    assertTrue(isElementPresent(By.cssSelector("div.msgbox")));
 }
}
