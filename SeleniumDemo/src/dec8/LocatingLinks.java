package dec8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatingLinks {

	public static void main(String[] args) {


		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumFiles\\browserDrivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.cnn.com");
		
		driver.findElement(By.linkText("Videos")).click();//one of the easiest and better approaches for locating links
		
		

	}

}
