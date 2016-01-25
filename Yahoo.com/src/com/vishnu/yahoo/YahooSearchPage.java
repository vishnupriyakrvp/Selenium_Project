package com.vishnu.yahoo;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class YahooSearchPage {
	
	public WebDriver driver;
	
	  @BeforeTest
	    public void setUp() throws Exception {
	        // Initialize the WebDriver instance using FirefoxDriver and launch the web browser
	        driver = new FirefoxDriver();
	        // Open the application - "https://ca.yahoo.com/"
	       driver.get("https://ca.yahoo.com/");
	       
	       driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	       System.out.println("GHGHGDHWGFWHKFG   ::" +driver.getTitle());
	        // Maximize the current window
	       // driver.manage().window().maximize();
	    }
	  @Test
	    public void search() {
		  
	        // Verify the page title to check if the correct page is launched
	        WebElement pageText = driver.findElement(By.xpath(".//*[@id='set-homepage']"));
	            System.out.println("Launched the incorrect webpage::  " +pageText);
		    
	  }
	  
	  @AfterTest
	    public void tearDown() {
	        // Quit the launched web browser
	        driver.quit();
	    }
}
