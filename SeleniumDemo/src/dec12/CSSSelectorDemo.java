package dec12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSSSelectorDemo {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumFiles\\browserDrivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.khanacademy.org/");
		
		
		
		//cssSSelector() ->Find elements via the driver's underlying W3C Selector engine. 
		//If the browser does not implement the Selector API, a best effort is made to emulate the API. 
		//In this case, we strive for at least CSS2 support, but offer no guarantees.
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("li._kaxcmv label._r0a03cs")).click(); // li._ysxxn8y label._r0a03cs
		driver.findElement(By.xpath("//input[@value='75']/ancestor::label")).click();
		
		
		driver.findElement(By.cssSelector("input[class='_2zwjgv'][type='text']")).sendKeys("Duotech Academy");
		driver.findElement(By.cssSelector("a#login-or-signup")).click();
		


	}

}
