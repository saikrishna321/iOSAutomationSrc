package com.test.iosdriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.uiautomation.ios.IOSCapabilities;

public class Controls{

	/**
	 * @param args
	 */
	
	public static DesiredCapabilities cap;
	public static RemoteWebDriver driver;
	
	private TouchActions getBuilder(WebDriver driver) {
	    return new TouchActions(driver);
	  }


	@BeforeClass
	public  static void setUp() throws MalformedURLException {

		cap = IOSCapabilities.iphone("UICatalog", "2.10");
		// start the application
		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),
				cap);
	}

	@Test
	public void testApplication() throws MalformedURLException {

		List<WebElement> getCountTables = driver.findElements(By
				.className("UIATableCell"));

		getCountTables.get(1).click();
		
		((RemoteUIASwitch)driver.findElement(By.className("UIASwitch"))).setValue(true);

	}
	
	@AfterClass
	public static void closeBrowser(){
		
		driver.quit();
	}

}
