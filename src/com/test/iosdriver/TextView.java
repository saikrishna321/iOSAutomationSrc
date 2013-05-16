package com.test.iosdriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.uiautomation.ios.IOSCapabilities;

public class TextView {

	/**
	 * @param args
	 */

	public static DesiredCapabilities cap;
	public static RemoteWebDriver driver;

	@BeforeClass
	public static void setUp() throws MalformedURLException {

		cap = IOSCapabilities.iphone("UICatalog", "2.10");
		// start the application
		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),
				cap);
	}

	@Test
	public void testApplication() throws MalformedURLException {

		WebElement textView = driver.findElement(By
				.xpath("//UIATableCell[contains(@name,'TextView')]"));
		
		textView.click();
		
	WebElement text=	driver.findElement(By.className("UIATextView"));
	text.click();
	text.clear();
	text.sendKeys("Sai Krishna");
		
		
	}

	@AfterClass
	public static void closeApp(){
		
		driver.quit();
	}
}
