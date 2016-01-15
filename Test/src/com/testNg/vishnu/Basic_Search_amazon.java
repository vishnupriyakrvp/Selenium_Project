package com.testNg.vishnu;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class Basic_Search_amazon {
	
	public WebDriver driver;
	
  @Test
  public void main() {
	
		//driver.manage().window().maximize();
		driver.findElement(By.xpath(".//*[@id='nav-xshop']/a[2]")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.findElement(By.xpath(".//*[@id='widgetFilters']/div[1]/div/span[9]/div//input")).click();
  }
  @BeforeMethod
  public void beforeMethod() {
	  // Create a new instance of the Firefox driver
	  
      driver = new FirefoxDriver();
 
      //Put a Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception
 
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 
      //Launch the Online Store Website
 
      driver.get("http://www.amazon.ca");
  }

  @AfterMethod
  public void afterMethod() {
	  
	//Close the driver
	  
	  driver.quit();
  }

}
