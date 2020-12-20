package dec8;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementMethod {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumFiles\\browserDrivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com/");
		
		WebElement searchBox = driver.findElement(By.name("q"));
		
		searchBox.sendKeys("How to make money?");// + Keys.ENTER
		
		Thread.sleep(2000);
		
		driver.findElement(By.name("btnK")).click();//BY is an abstract class with a static method
		//that return By object
		Thread.sleep(2000);
		String expectedResult = "How to make money?";
		
		String actualResult = driver.getTitle();
		
		if(actualResult.contains(expectedResult)) {
			System.out.println("PASS");
		}else {
			System.out.println("FAIL");
		}
		
	}

}
