package com.insider.qa.appPages;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.PageFactory;

import com.insider.qa.base.AppTestBase;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;

public class IntroScreen extends AppTestBase{
	
	@AndroidFindBy(id="in.insider.consumer:id/ob_1")
	AndroidElement viewOne;
	
	@AndroidFindBy(id="in.insider.consumer:id/ob_2")
	AndroidElement viewTwo;
	
	@AndroidFindBy(id="in.insider.consumer:id/rl_ob3_dropdown")
	AndroidElement dropDownButton;
	
	@AndroidFindBy(id="in.insider.consumer:id/etxt_search")
	AndroidElement searchTextBox;
	
	@AndroidFindBy(id="in.insider.consumer:id/tv_city_name")
	AndroidElement selectCity;
	
	@AndroidFindBy(id="in.insider.consumer:id/txt_ob3_skip")
	AndroidElement skipButton;
	
	public IntroScreen() {
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public HomeScreen goToHomeScreen() {
		
		if (viewOne.isDisplayed()) {
			swipeHorizontal();
		}
		
		if (viewTwo.isDisplayed()) {
			swipeHorizontal();
		}
		
		dropDownButton.click();
		
		searchTextBox.sendKeys("Delhi");
		
		selectCity.click();
		
		skipButton.click();
		
		return new HomeScreen();
	}
	
	public void swipeHorizontal() {
		
		//Get the size of screen
		Dimension size = driver.manage().window().getSize();
		
		//Find swipe start points from screen's with and height
		int startx = (int) (size.width * 0.90);
		int starty = (int) (size.height * 0.50);
		
		//Find swipe end points from screen's with and height.
		int endx = (int) (size.width * 0.10);
		int endy = (int) (size.height * 0.50);
		
		
		TouchAction<?> action = new TouchAction<>(driver);
		
		action.longPress(PointOption.point(startx, starty)).moveTo(PointOption.point(endx, endy)).release().perform();	
	}
	
	

}
