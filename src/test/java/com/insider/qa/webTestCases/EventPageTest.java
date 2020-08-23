package com.insider.qa.webTestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.insider.qa.base.WebTestBase;
import com.insider.qa.webPages.EventPage;
import com.insider.qa.webPages.HomePage;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;

public class EventPageTest extends WebTestBase{
	
	HomePage homePage;
	EventPage eventPage;
	
	@BeforeMethod
	public void setup() {
		initialization();
		homePage = new HomePage();
	}
	
	@Test
	public void TC01() {
		
		eventPage = homePage.clickOnFeaturedItem();
		String eventNameFromPage = eventPage.getEventName();
		
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
