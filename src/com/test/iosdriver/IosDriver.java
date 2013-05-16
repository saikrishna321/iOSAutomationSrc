package com.test.iosdriver;


import static org.openqa.selenium.TestWaiter.waitFor;
import static org.openqa.selenium.WaitingConditions.alertToBePresent;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Rotatable;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.uiautomation.ios.IOSCapabilities;


public class IosDriver {

	/**
	 * @param args
	 */
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
	public void testShouldAllowUsersToAcceptAnAlertManually() {

		List<WebElement> getCountTables = driver.findElements(By
				.className("UIATableCell"));

		getCountTables.get(6).click();
	
		Alert alert = waitFor(alertToBePresent(driver));
		alert.accept();
	}
	
	

	@Test
	public void testShouldAllowUsersToDismissAnAlert() {

		By Selector = By
				.xpath("//UIATableCell[contains(@name,'Show OK-Cancel')]");
		driver.findElement(Selector).click();
		Alert alert = waitFor(alertToBePresent(driver));
		alert.accept();
	}
	
	
	
}
