package com.test.iosdriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IphoneDriver {

	
	
	WebDriver driver;
	
	@Test
	public void testApp() throws MalformedURLException{
		
		 driver = new RemoteWebDriver(new URL("http://172.16.37.2:8086/wd/hub/"), DesiredCapabilities.iphone());
		// or use the convenience class which uses localhost:3001 by default
		 
		 
		driver.get("http://m.google.com");
		
	}
	
	
}
