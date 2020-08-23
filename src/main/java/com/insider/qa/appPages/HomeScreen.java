package com.insider.qa.appPages;

import org.openqa.selenium.support.PageFactory;

import com.insider.qa.base.AppTestBase;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomeScreen extends AppTestBase{
	
	@AndroidFindBy(id="in.insider.consumer:id/iv_goout")
	AndroidElement eventButton;
	
	public HomeScreen() {
			PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		}
	
	public EventScreen goToEventScreen() {
		eventButton.click();
		return new EventScreen();
	}

}
