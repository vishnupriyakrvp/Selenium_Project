package com.vishnu.mc;

import org.testng.annotations.Test;

import com.testNg.vishnu.amazon_Login;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class Order_Food {
	
	public WebDriver driver;
	Logger logger = Logger.getLogger(Order_Food.class.getName());
	
	 @BeforeTest
	  public void beforeTest() {
		  // Create a new instance of the Firefox driver
	      driver = new FirefoxDriver();
	 
	      //Put a Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception
	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 
	      //Launch the Online Store Website
	      driver.get("http://www.mcdonalds.com");
	  }
	
	
  @Test
  public void orderFood() {
	  
	  driver.findElement(By.xpath(".//*[@id='popclose']/a")).click();
	  
	  //create Actions class object
	  Actions act = new Actions(driver);
	  WebElement food = driver.findElement(By.id("foodnav_link"));
	  
	  //move to food tab
	  	act.moveToElement(food).build().perform();
	  
	  	//move to salad and click
	  	act.moveToElement(driver.findElement(By.xpath("//a[contains(@href,'menu/salads.html')]"))).click().build().perform();
	
	  	logger.info("Okey..Selected the food now!!");
  }
 

  @AfterTest
  public void afterTest() {
	//Close the driver
	  driver.quit();
  }

}
