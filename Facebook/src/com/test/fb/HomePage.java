package com.test.fb;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import static org.testng.Assert.assertEquals;

public class HomePage {
	
	WebDriver driver;
	
	@BeforeMethod
	  public void beforeMethod() {
		  // Create a new instance of the Firefox driver
	      driver = new FirefoxDriver();
	 
	      //Put a Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception
	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 
	      //Launch the Online Store Website
	      driver.get("http://www.facebook.com");
	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
		  ///login email
		 driver.findElement(By.xpath(".//*[@id='email']")).sendKeys("ckpalli.maavuru@gmail.com");
		 
		 //password encription logic
		 WebElement pwd =  driver.findElement(By.xpath(".//*[@id='pass']"));

		 byte[] encodedBytes = Base64.encodeBase64("ckpalli143919".getBytes());
		 System.out.println("encodedBytes "+ new String(encodedBytes));

		 byte[] decodedBytes = Base64.decodeBase64(encodedBytes);
		 System.out.println("decodedBytes "+ new String(decodedBytes));

		 pwd.sendKeys(new String(decodedBytes));
		 
		 //login button
		 driver.findElement(By.xpath(".//*[@id='u_0_n']")).click();
	  }
	
	
  @Test
  public void HomePageNavigation() {
	  
	 String element= driver.findElement(By.xpath(".//*[@id='u_0_1']")).getText();
	 assertEquals(element,"Home0");
  }
  

  @AfterMethod
  public void afterMethod() {
	  
	  // Lout out button
		 driver.findElement(By.xpath("//div[@id='userNavigationLabel']")).click();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.findElement(By.xpath("//li[12]/a/span/span")).click();  
		 
		 driver.quit();
  }

}
