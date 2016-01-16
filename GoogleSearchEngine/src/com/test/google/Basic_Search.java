package com.test.google;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class Basic_Search {
	
	public WebDriver driver;
	
  @Test
  public void search() {
	  
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  
	  //locate the search box
	  driver.get("http://www.google.com");

      // Find the text input element by its name
      WebElement element = driver.findElement(By.name("q"));

      // Enter something to search for
      element.sendKeys("Cheese!");

      // Now submit the form. WebDriver will find the form for us from the element
      element.submit();

	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  // Create a new instance of the Firefox driver
	  
      driver = new FirefoxDriver();
 
      //Put a Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception
 
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 
      //Launch the Online Store Website
 
      driver.get("http://www.google.ca");
  }

  @AfterMethod
  public void afterMethod() {
	  
	//Close the driver
	  
	  driver.quit();
  }

}
