package com.vishnu.flights;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheapFlights {
	WebDriver driver= new FirefoxDriver();
	
	@BeforeTest
	public	void setup(){
		
		//Open the browser with the URL
		driver.get("http://www.cheapflights.com/");
		
		// Put an Implicit wait, 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	@Test
	public void bookFlight(){
		
		//Enable one way radio button
		driver.findElement(By.xpath(".//*[@id='sb-ticket']/ul/li[2]/span")).click();
		
		// Select FROM Destination
		driver.findElement(By.xpath(".//*[@id='sb-from']/input")).sendKeys("Banglore");
		
		//Select To Destination
		driver.findElement(By.xpath(".//*[@id='sb-to']/input")).sendKeys("Delhi");
		//driver.findElement(By.xpath("html/body/div[3]/ul/li[1]/a")).click();
		
		// Depart date
		driver.findElement(By.xpath(".//*[@id='sb-depart']/input")).click();
		
		//Date selection
		driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[5]/td[6]/a"));
		
		// Time selection "Morning" "Afternoon" "Evening"
		// Use list for all the elements and select from there
		List<WebElement> option = driver.findElements(By.tagName("option"));

	    option.get(0).click();
	    // option.get(1).click(); // option.get(0).click();
	    
	    // Click on "Find Deals" button
	    driver.findElement(By.xpath(".//*[@id='sb-be-search']/span[1]")).click();
		
		
	}
	
	@AfterTest
	public void after(){
		driver.quit();
	}
}
