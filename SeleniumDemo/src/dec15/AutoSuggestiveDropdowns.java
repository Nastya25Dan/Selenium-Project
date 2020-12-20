package dec15;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestiveDropdowns {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumFiles\\browserDrivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.kayak.com/");
		
		driver.findElement(By.cssSelector("div[id*='pickup-display-inner']")).click();
		
		driver.findElement(By.name("pickup")).sendKeys("atl" + Keys.DOWN + Keys.ENTER);


	}

}
