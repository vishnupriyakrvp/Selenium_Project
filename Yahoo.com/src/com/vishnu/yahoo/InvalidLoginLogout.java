package com.vishnu.yahoo;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
public class InvalidLoginLogout {
    // Create WebDriver instance
    WebDriver driver;

    @BeforeTest
    public void setUp() throws Exception {
        // Initialize the WebDriver instance using FirefoxDriver and launch the web browser
        driver = new FirefoxDriver();
        // Open the application - "https://login.yahoo.com/"
       driver.get("https://login.yahoo.com/");
        // Maximize the current window
        driver.manage().window().maximize();
    }
    @Test
    public void testLogin() throws Exception {
        // Verify the page title to check if the correct page is launched
        String pageTitle = driver.getTitle();
        if (!pageTitle.equals("Sign in to Yahoo"))
        {
            System.out.println("Launched the incorrect webpage");
	     tearDown();

        }        
        
        // Enter an invalid username and password
        WebElement TB_Username = driver.findElement(By.id("username"));        
        TB_Username.sendKeys("InvalidUsername");
        
        WebElement TB_Password = driver.findElement(By.id("passwd"));        
        TB_Password.sendKeys("InvalidPassword");
        
        // Click on login button
        WebElement BTN_Login = driver.findElement(By.id(".save"));        
        BTN_Login.click();
        // Wait for authentication process
        Thread.sleep(3000);
        
        //    Verify that error message is displayed for authentication failure.
        String InvalidLoginMessage = driver.findElement(By.xpath("//fieldset[@id='fsLogin']//div")).getText();
        if (InvalidLoginMessage.equals("Invalid ID or password."))
        {
            System.out.println("Correct message is displayed");
        }
        else
        {
            System.out.println("Incorrect message is displayed");
        } 
    }
    @AfterTest
    public void tearDown() {
        // Quit the launched web browser
        driver.quit();
    }
}