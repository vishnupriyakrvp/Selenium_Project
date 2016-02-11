package com.vishnu.yahoo;

import org.openqa.selenium.By;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

public class google1 {
	static FirefoxDriver fd = new FirefoxDriver();

	public static void fn_searchdata() throws Exception {

		fd.get("http://www.google.co.in");
		Thread.sleep(3000);
		fd.findElement(By.name("q")).sendKeys("seleniumbycharan");
		fd.findElement(By.name("btnG")).click();
		Thread.sleep(3000);
		if (fd.findElement(By.id("resultStats")).isDisplayed()) {
			System.out.println("Results are displayed");
			Reporter.log("Results are displayed");
		} else {
			System.out.println("Results are not displayed");
			Reporter.log("Results are not displayed");
		}
	}

	public static void fn_check() throws Exception {
		Thread.sleep(3000);
		String t = fd.getTitle();
		if (t.contains("Google")) {
			Reporter.log("Google page is displayed correct");
		} else {
			Reporter.log("Google page is not displayed correct");
		}
	}

}
