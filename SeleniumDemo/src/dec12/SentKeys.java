package dec12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SentKeys {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumFiles\\browserDrivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.cargurus.com");
		
		driver.findElement(By.id("dealFinderZipUsedId_dealFinderForm")).sendKeys("22182");
		
		//To troubleshoot your issue with selenium:
		//1. Check your locator if it is correct, if it is not changing over time
		//2. Check the synchronization/waits
		//3. Check if the element is hidden/invisible
		//4. JSExecutor -> JavaScriptExecutor Interface

	}

}
