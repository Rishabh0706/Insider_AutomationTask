package com.insider.qa.webPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.insider.qa.base.WebTestBase;

public class HomePage extends WebTestBase{
	
	@FindBy(xpath="//span[text()=\"Featured events\"]//ancestor::div[@class=\"card-list-head\"]//following-sibling::div/ul/li[2]")
	WebElement featuredItem;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public EventPage clickOnFeaturedItem() {
		featuredItem.click();
		return new EventPage();
	}
}
