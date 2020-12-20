package dec10;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class SubmitMehtod {

	public static void main(String[] args) throws InterruptedException {

		
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumFiles\\browserDrivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.dice.com/");
		
		
		driver.findElement(By.xpath("//input[@placeholder='Job title, skills or company']")).sendKeys("Automation Test Engineer" );
		Thread.sleep(2000);
		
		driver.findElement(By.id("submitSearch-button")).click();
		
		
		driver.get("https://www.google.com/");
		
		driver.findElement(By.name("q")).sendKeys("PS5 Scalpers" );
		
		driver.findElement(By.name("q")).submit();

	}

}
