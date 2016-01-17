package com.test.fb;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProfilePage {
	
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
  public void profilePage() {
	  
	 //locate profile  
	 driver.findElement(By.xpath(".//*[@id='navItem_100008458750670']/a/div/span")).click();
	
	 //Locate about button
	// driver.findElement(By.xpath("//div[text()='Update Profile Picture']")).click();
	// driver.findElement(By.xpath(".//*[@id='pagelet_timeline_profile_actions']/a")).click();
	 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 
	 //Find finends button on header tab
	 driver.findElement(By.xpath(".//*[@id='findFriendsNav']")).click();
	 
	
	 //check for text
	 String ele = driver.findElement(By.xpath(".//*[@id='u_jsonp_3_1']/div/div/div[1]/ul/li[1]/div/div/div[2]/div[2]/ul/li/table/tbody/tr/td[2]")).getText();
	 assertEquals(ele,"Sri Chaitanya College, Vijayawada");
	 
  }
  

  @AfterMethod
  public void afterMethod() {
	  
	  // Lout out button
		 driver.findElement(By.xpath("//div[@id='userNavigationLabel']")).click();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.findElement(By.xpath("//li[12]/a/span/span")).click();  
	
		 //quit the driver 
		 driver.quit();
  }

}
