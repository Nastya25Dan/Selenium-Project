package dec8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathDemo {

	public static void main(String[] args) {


		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumFiles\\browserDrivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.car.com");
		
		///driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[2]/div/div/div[1]/div[3]/div[1]/div[1]/div[2]/div/div/div/form/div[1]/div/select"));

		//relative path by attribute
		
		
	
	
	
	
	}

}
