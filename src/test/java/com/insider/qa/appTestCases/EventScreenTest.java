package com.insider.qa.appTestCases;

import static io.restassured.RestAssured.given;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.insider.qa.appPages.EventScreen;
import com.insider.qa.appPages.HomeScreen;
import com.insider.qa.appPages.IntroScreen;
import com.insider.qa.base.AppTestBase;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class EventScreenTest extends AppTestBase{

	IntroScreen introScreen;
	HomeScreen homeScreen;
	EventScreen eventScreen;
	
	@BeforeMethod
	public void setup() throws MalformedURLException {
		
		capabilities("appName");
		introScreen = new IntroScreen();		
	}
	
	@Test
	public void TC01() {
		
		homeScreen = introScreen.goToHomeScreen();
		eventScreen = homeScreen.goToEventScreen();
		String eventNameFromPage = eventScreen.getEventName();
		
		RestAssured.baseURI=prop.getProperty("apiUrl");
		Response response = given().when().get("/faqs-the-knowledge-series-faye-dsouza-with-janice-sequeira-on-how-to-be-a-journalist-in-2020-aug8-2020");
		String eventNameFromApi = response.then().extract().jsonPath().get("data.name");
		
		Assert.assertEquals(eventNameFromPage, eventNameFromApi);
	}
	
	@AfterMethod
	public void clean() {
		driver.quit();
	}

}
