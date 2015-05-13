package com.example.fw;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.example.utils.SortedListOf;



public class ContactHelper extends WebDriverHelperBase {
	
	public static boolean CREATION = true;
	public static boolean MODIFICATION = false;

	public ContactHelper(ApplicationManager manager) {
		super(manager);		
	}
	
	private SortedListOf<ContactData> cachedContacts;
	
	public SortedListOf<ContactData> getContacts() {
		if (cachedContacts == null){
						rebuildCache();
					}
		return new SortedListOf<ContactData>(cachedContacts);
	}
		
	
	private void rebuildCache() {
		cachedContacts = new SortedListOf<ContactData>();
		manager.navigateTo().mainPage();
		List<WebElement> rows = driver.findElements(By.name("entry"));		
		for (WebElement row : rows) {				
			cachedContacts.add(new ContactData()
			.withFirstName(row.findElement(By.xpath(".//td[2]")).getText())
			.withLastName(row.findElement(By.xpath(".//td[3]")).getText()));
		}		
	}
	
	public ContactHelper createContact(ContactData contact) {
		manager.navigateTo().mainPage();
	    goToAddContact();
	    fillContactForm(contact, CREATION);	  
	    submitContactCreation();
	    manager.navigateTo().returnToHomePage();
	    rebuildCache();
	    return this;
	}
	
	public ContactHelper modifyContact(ContactData contact) {
	    initContactModification();	        
	    fillContactForm(contact, MODIFICATION);	  
	    submitContactModification();
	    manager.navigateTo().returnToHomePage();	
	    rebuildCache();
	    return this;
}


public ContactHelper deleteContact() {
	initContactModification();	    	  
    submitContactDeletion();
    manager.navigateTo().returnToHomePage();
    rebuildCache();	
    return this;
}
	

	public ContactHelper goToAddContact() {
		click(By.linkText("add new"));
		return this;
	}
	
	public ContactHelper submitContactCreation() {
		click(By.name("submit"));
		cachedContacts = null;
		return this;
	}

	public ContactHelper fillContactForm(ContactData contact, boolean formType) {
		type(By.name("firstname"), contact.getFirstName());	
		type(By.name("lastname"), contact.getLastName());
		type(By.name("address"), contact.getAdress());		
		type(By.name("home"), contact.getHomePhone());		
		type(By.name("mobile"), contact.getMobilePhone());		
		type(By.name("work"), contact.getWorkPhone());		
		type(By.name("email"), contact.getEmail());		
		selectByText(By.name("bday"), contact.getBirthDay());
		selectByText(By.name("bmonth"), contact.getBirthMonth());		
		type(By.name("byear"), contact.getBirthYear());	
		if (formType == CREATION){
			//selectByText(By.name("new_group"), "group 1");
		} else {
			if (driver.findElements(By.name("new_group")).size() != 0){
				throw new Error("Group selector exists in contact modification form");
			}
		}
		//selectByText(By.name("new_group"), contact.getGroup());	
		type(By.name("address2"), contact.getSecondAdress());		
		type(By.name("phone2"), contact.getHomeAdress());
		return this;
	}

	public ContactHelper initContactModification() {
		selectContactByIndex();	
		return this;
	}

	public ContactHelper selectContactByIndex() {
		click(By.xpath("//*[@id='maintable']/tbody/tr[2]/td[7]/a/img"));
		return this;
	}

	public ContactHelper submitContactModification() {
		click(By.name("update"));
		cachedContacts = null;
		return this;
	}

	public ContactHelper submitContactDeletion() {
		click(By.xpath("(//input[@name='update'])[2]"));
		cachedContacts = null;
		return this;
	}


	
	

	

	

}
