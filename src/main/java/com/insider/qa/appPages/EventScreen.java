package com.insider.qa.appPages;

import org.openqa.selenium.support.PageFactory;

import com.insider.qa.base.AppTestBase;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class EventScreen extends AppTestBase{
	
	
	@AndroidFindBy(xpath="//*[@text='FEATURED EVENTS']//parent::*[@class='android.widget.RelativeLayout']//following-sibling::*[@class='android.widget.ViewSwitcher']"
			+ "/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]")
	AndroidElement featuredEvent;
	
	@AndroidFindBy(id="in.insider.consumer:id/tv_eventdetail_title")
	AndroidElement titleNmae;
	
	public EventScreen() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public String getEventName() {
		
		featuredEvent.click();
		
		String eventTitle = titleNmae.getText();
		
		return eventTitle;
	}
	

}
