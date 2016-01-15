import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test {

	public static void main(String[] args) {
		
		WebDriver driver= new FirefoxDriver();
				driver.get("http://www.amazon.ca");
		
				driver.manage().window().maximize();
				driver.findElement(By.xpath(".//*[@id='nav-xshop']/a[2]")).click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
				driver.findElement(By.xpath(".//*[@id='widgetFilters']/div[1]/div/span[9]/div//input")).click();
	//	driver.quit();
	}

}
