package dec8;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocateTables {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumFiles\\browserDrivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.bloomberg.com/markets/stocks");
		
		List<WebElement> allTableRows = driver.findElements(By.tagName("tr"));
		
		System.out.println(allTableRows.size());
		
		for (WebElement webElement : allTableRows) {
			System.out.println(webElement.getText());
		}
		
		//to close all sessions
		//taskkill /f /im chrome.exe
		//clean after yourself
	}

}
