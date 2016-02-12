package com.vishnu.miscellaneous;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Testng_BrowserCompactability
 {
	public WebDriver fd;

	@Test
	@Parameters({ "browser" })
	public void browserTest(String str) throws Exception {
		if (str.matches("firefox")) {

			fd = new FirefoxDriver();
			fd.get("https://seleniumbycharan.wordpress.com&#8221");
			fd.close();

		}
		if (str.matches("ie")) {

			// Following code is to set the ie driver with webdriver
			// property.You need IE Driver //server. download from here.
			System.setProperty("webdriver.ie.driver", "F:\\Selenium_project\\IEDriverServer.exe");
			fd = new InternetExplorerDriver();
			fd.get("https://seleniumbycharan.wordpress.com&#8221");
			fd.close();

		} else {
			Reporter.log("test failed");
		}

	}
}
