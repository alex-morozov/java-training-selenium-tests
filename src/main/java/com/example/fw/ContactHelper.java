package com.example.fw;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.example.tests.ContactData;
import com.example.utils.SortedListOf;



public class ContactHelper extends HelperBase {
	
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
		cachedContacts = new SortedListOf<ContactData> ();
		manager.navigateTo().mainPage();
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {			
			String title = checkbox.getAttribute("title");			
			String name = title.substring("Select (".length(), title.length() - ")".length() );
			cachedContacts.add(new ContactData().withLastName(name));
		}		
	}
	
	public ContactHelper createGroup(ContactData contact) {
		manager.navigateTo().mainPage();
	    goToAddContact();
	    fillContactForm(contact, CREATION);	  
	    submitContactCreation();
	    manager.navigateTo().returnToHomePage();
	    rebuildCache();
	    return this;
	}
	
	public ContactHelper modifyContact(int index, ContactData contact) {
	    initContactModification(index);	        
	    fillContactForm(contact, MODIFICATION);	  
	    submitContactModification();
	    manager.navigateTo().returnToHomePage();	
	    rebuildCache();
	    return this;
}


public ContactHelper deleteContact(int index) {
	initContactModification(index);	    	  
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

	public ContactHelper initContactModification(int index) {
		selectContactByIndex(index);	
		return this;
	}

	public ContactHelper selectContactByIndex(int index) {
		click(By.xpath("//*[@id='maintable']/tbody/tr[" + index + "]/td[7]/a/img"));
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
