package dec8;

import org.openqa.selenium.chrome.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class FindElementMethod2 {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumFiles\\browserDrivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();//->> create a session and open a new browser
		
		//WebDriver and WebElement are Selenium Interface
		
		driver.get("https://ww.duotech.io//");//-->>navigate and indicate url
		
		//findElement locates the first element on the html document even though there may be 
		//				more then one element meeting the search
		
		driver.findElement(By.className("link-4")).click();
		
		
	}

}
