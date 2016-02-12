package com.vishnu.miscellaneous;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BrowserStackTestCase {

private WebDriver driver;
public static final String USERNAME = "YourUserName";
public static final String AUTOMATE_KEY = "YourAccessKey";
public static final String URL = "http://&#8221; + USERNAME + ":" + AUTOMATE_KEY"+ "@hub.browserstack.com/wd/hub";

	@BeforeTest
	@Parameters(value = { "browser", "version", "platform" })
	public void setUp(String browser, String version, String platform) throws Exception {
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("platform", platform);
		capability.setCapability("browserName", browser);
		capability.setCapability("browserVersion", version);
		capability.setCapability("project", "MyProject");
		capability.setCapability("build", "2.01");
		driver = new RemoteWebDriver(new URL(URL), capability);
	}

	@Test(priority = 1)
	public void testcase001() throws Exception {
		driver.get("http://www.google.com&#8221");
		System.out.println("Page title : " + driver.getTitle());
		Assert.assertEquals("Google", driver.getTitle());
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Merry christmas");
		element.sendKeys(Keys.ENTER);

	}

	@Test(priority = 2)
	public void testcase002() {
		driver.get("http://seleniumhq.org&#8221");
		System.out.println("Page title : " + driver.getTitle());
		Assert.assertEquals("Selenium – Web Browser Automation", driver.getTitle());
	}

	@AfterMethod
	public void takeScreenShot(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			driver = new Augmenter().augment(driver);

			File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(srcFile, new File("D:\\Screenshot" + result.getParameters().toString() + ".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@AfterTest
	public void tearDown() throws Exception {
		driver.quit();
	}

}
