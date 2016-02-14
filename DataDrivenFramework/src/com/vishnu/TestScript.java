package com.vishnu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestScript() {
	WebDriver driver= new FirefoxDriver();

	ExcelReader excelReaderObj;

CommonMethods commonMethodobj = new CommonMethods();

TestData td = new TestData();

 

// Load the excel file for testing

excelReaderObj = new ExcelReader("Path of the excel");

 

// Load the Excel Sheet Col in to Dictionary for use in test cases

excelReaderObj.ColumnDictionary();

 

// Get the data from excel file

commonMethodobj.readExcelData (td);

 

// Populate the username

driver.findElement(By.id("idofElement")).sendKeys(td.getLoginUser().get(0));
}