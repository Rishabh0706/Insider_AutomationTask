package com.insider.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppTestBase {
	
	protected static AppiumDriver<WebElement> driver;
	protected static Properties prop;
	
	private static long IMPLICIT_WAIT = 20;
	
	public AppTestBase() {
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/insider"
					+ "/qa/config/appConfig.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	protected static void capabilities(String appName) throws MalformedURLException {
		
		File appDir = new File("src");
	    File app = new File(appDir, prop.getProperty(appName));
	    
	    DesiredCapabilities capabilities = new DesiredCapabilities();
	    
	    capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, prop.getProperty("platformName"));
	    capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, prop.getProperty("platformVersion"));
	    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, prop.getProperty("deviceName"));
	    capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, prop.getProperty("automationName"));
	    capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
	    
	    driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	    driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
	   
//	   return driver;
		
	}

}
