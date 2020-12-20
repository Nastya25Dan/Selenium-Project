package dec10;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClearMethod {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumFiles\\browserDrivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.hoteltonight.com/");
		
		Thread.sleep(2000);
		
		driver.findElement(By.name("searchfield")).click();
		driver.findElement(By.name("searchfield")).sendKeys(Keys.BACK_SPACE);
		
		Thread.sleep(1000);
		driver.findElement(By.name("searchfield")).sendKeys("Washington DC" + Keys.ENTER);


		driver.get("https://dice.com");
		
		driver.findElement(By.xpath("//input[@placeholder='Job title, skills or company']")).sendKeys("SDET");
		driver.findElement(By.xpath("//input[@placeholder='Job title, skills or company']")).clear();

		
		
	}

}
