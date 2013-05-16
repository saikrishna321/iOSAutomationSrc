package com.test.iosdriver;

import static org.openqa.selenium.TestWaiter.waitFor;
import static org.openqa.selenium.WaitingConditions.alertToBePresent;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.uiautomation.ios.IOSCapabilities;

public class AlertIOS {

	/**
	 * @param args
	 * @throws MalformedURLException
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

		List<WebElement> getCountTables = driver.findElements(By
				.className("UIATableCell"));

		getCountTables.get(10).click();
		By Selector = By
				.xpath("//UIAStaticText[contains(@name,'Show Simple')]");
		driver.findElement(Selector).click();
		Alert alert = waitFor(alertToBePresent(driver));
		alert.accept();

	}

	@Test
	public void testShouldAllowUsersToDismissAnPromptManually() {
		
		By Selector = By
				.xpath("//UIAStaticText[contains(@name,'OK-Cancel')]");
		driver.findElement(Selector).click();
		Alert alert = waitFor(alertToBePresent(driver));
		alert.dismiss();
	}

	@Test
	public void testShouldAllowUsersToAcceptAnPromptManually() {

	
		By Selector = By
				.xpath("//UIAStaticText[contains(@name,'Show OK-Cancel')]");
		driver.findElement(Selector).click();
		Alert alert = waitFor(alertToBePresent(driver));
		alert.accept();
	}

	@Test
	public void testShouldAllowUsersToAcceptAnAlertManually() {

		List<WebElement> getCountTables = driver.findElements(By
				.className("UIATableCell"));

		getCountTables.get(6).click();
	
		Alert alert = waitFor(alertToBePresent(driver));
		alert.accept();
	}
	
	

	@Test
	public void testShouldAllowUsersToEnterSecurTextInput() {
		By Selector = By
				.xpath("//UIAStaticText[contains(@name,'Secure Text Input')]");
		driver.findElement(Selector).click();
		driver.findElement(By.className("UIASecureTextField")).sendKeys("password");
	    driver.findElement(By.xpath("//UIAButton[@name='OK']")).click();
		
	}
	
	@AfterClass
	public static void closeDriver(){
		
		driver.quit();
	}
	
}
