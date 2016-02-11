package com.vishnu.yahoo;

import java.io.FileInputStream;

import jxl.Workbook;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

public class yahoo extends Driver_yahoo
{
    static String url;
	static FirefoxDriver fd=new FirefoxDriver();
	public static String subj;	
	public static void fn_open() throws Exception
	{
		//get sheet0 having URL
	  fn_getdata(0);
	  url=ws.getCell(1,1).getContents();
	  fd.get(url);
	  fd.manage().window().maximize();

	  Thread.sleep(3000);
	}
	public static void fn_login() throws Exception
	{
		
		//get sheet2 and 3 having obj and testdata
	 fn_getdata(2,3);
	 fd.findElement(By.name(ws2.getCell(0,1).getContents())).sendKeys(ws3.getCell(0, 1).getContents().trim());
	 fd.findElement(By.name(ws2.getCell(0,2).getContents())).sendKeys(ws3.getCell(0, 2).getContents().trim());
	 fd.findElement(By.name(ws2.getCell(0,3).getContents())).click();
	 Thread.sleep(15000);
		
	}
	public static void fn_compose() throws Exception
	{  
		
		
		//get sheet2 and 3 having obj and rep
		fn_getdata(2,3);
		subj=ws3.getCell(1,2).getContents();
		fd.findElement(By.xpath(ws2.getCell(1,1).getContents().trim())).click();
	    Thread.sleep(5000);
	    fd.findElement(By.id(ws2.getCell(1,2).getContents())).sendKeys(ws3.getCell(1,1).getContents());
	    fd.findElement(By.id(ws2.getCell(1,3).getContents())).sendKeys(subj);
	    fd.findElement(By.name(ws2.getCell(1,4).getContents())).sendKeys(ws3.getCell(1,3).getContents());
	    fd.findElement(By.id(ws2.getCell(1,5).getContents())).click();
	    Thread.sleep(7000);
	    fd.findElement(By.id("inbox_back")).click();
	    Thread.sleep(2000);
	}
	public static void fn_checkmail() throws Exception
	{
		//get sheet2 having obj
		fn_getdata(2);
		fd.findElement(By.linkText(ws.getCell(2,1).getContents())).click();
		Thread.sleep(8000);
		String sub=fd.findElement(By.xpath(ws.getCell(2,2).getContents())).getText().trim();
		if (sub.matches(subj))
		{
		  Reporter.log("<b><font color='green'>Mail is received</font></b>         "+sub);
		}
		else
		{
		  Reporter.log("<b><font color='red'>Mail NOT received</font></b>         "+sub);
		}
	}
	public static void fn_logout()
	{
		fd.findElement(By.linkText("Sign Out")).click();
		fd.close();
	}
	private static void fn_getdata(int s1) throws Exception
	{
		fs=new FileInputStream("F:\\Workspace\\Keyword\\testdata\\data.xls");	
		wb=Workbook.getWorkbook(fs);
		ws=wb.getSheet(s1);
	}
	private static void fn_getdata(int s1,int s2) throws Exception
	{
		fs=new FileInputStream("F:\\Workspace\\Keyword\\testdata\\data.xls");	
		wb=Workbook.getWorkbook(fs);
		ws2=wb.getSheet(s1);
		ws3=wb.getSheet(s2);
	}

}

