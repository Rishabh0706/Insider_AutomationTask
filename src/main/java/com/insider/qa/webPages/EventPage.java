package com.insider.qa.webPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.insider.qa.base.WebTestBase;

public class EventPage extends WebTestBase{
	
	@FindBy(className="css-1v7txka")
	WebElement titleName;
	
	
	public EventPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getEventName() {
		String eventTitle = titleName.getText();
		
		return eventTitle;
	}

}
