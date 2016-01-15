package com.testNg.vishnu;

import java.util.concurrent.TimeUnit;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class amazon_Login {
	public WebDriver driver;
	Logger Log = Logger.getLogger(amazon_Login.class.getName());
	
	 @BeforeMethod
	  public void beforeMethod() {
		  // Create a new instance of the Firefox driver
		     driver = new FirefoxDriver();
	 
	      //Put a Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception
	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 
	      //Launch the Online Store Website
	      driver.get("http://www.amazon.ca");
	  }
  @Test
  public void login() {
	  
	  //check if the text is displayed on the page before we start looking for web elements.
	  
	  
	//  if(ele.equals("Registration")){
	  // click on the locator for sigin-in
	 driver.findElement(By.xpath(".//*[@id='nav-link-yourAccount']")).click();
	 
	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 
	 // enter name
	 driver.findElement(By.xpath(".//*[@id='ap_customer_name']")).sendKeys("test");
	 
	 //enter email address
	 driver.findElement(By.xpath(".//*[@id='ap_email']")).sendKeys("vish");
	 
	 //enter email address again
	 driver.findElement(By.xpath(".//*[@id='ap_email_check_input']")).sendKeys("vish");
	 
	 //enter password
	 driver.findElement(By.xpath(".//*[@id='ap_password']")).sendKeys("pswd");
	 
	 //enter password again
	 driver.findElement(By.xpath(".//*[@id='ap_password_check']")).sendKeys("pswd");
	  
	 //click on create account button
	 driver.findElement(By.xpath(".//*[@id='continue-input']")).click();
	/*  }else{
		  Log.info("page not loaded properlt yet!!");
	  }*/
  }
  
  @AfterMethod
  public void afterMethod() {
	  
	//Close the driver
	  driver.quit();
  }
}
