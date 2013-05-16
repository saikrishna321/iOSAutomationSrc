package com.test.iosdriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.uiautomation.ios.IOSCapabilities;

public class WebView {

	/**
	 * @param args
	 * @throws MalformedURLException
	 */
	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub

		IOSCapabilities catalog = IOSCapabilities.iphone("UICatalog");

		RemoteWebDriver driver = new RemoteWebDriver(new URL(
				"http://localhost:4444/wd/hub"), catalog);
		// by default, the app starts in native mode.
		WebElement web = driver.findElement(By
				.xpath("//UIATableCell[contains(@name,'Web')]"));
		web.click();

		// now that a webview is displayed, switch to web mode.
		driver.switchTo().window("Web");

		By contentFree = By.partialLinkText("iPad");
		WebElement text = driver.findElement(contentFree);
		text.click();
	

		driver.quit();

	}

}
