package dec10;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class KeysMethod {

	public static void main(String[] args) {
		

		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumFiles\\browserDrivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.dice.com/");
		
//		driver.findElement(By.xpath("//input[@placeholder='Job title, skills or company']")).sendKeys("SDET" + Keys.ENTER);
		
//		driver.findElement(By.xpath("//input[@placeholder='Job title, skills or company']")).

		//sendKeys(Keys.chord(Keys.SHIFT, "sdet") + Keys.ENTER);
		
		driver.findElement(By.xpath("//a[@href='https://insights.dice.com/covid-19-jobs-resource/']"));


	}

}
