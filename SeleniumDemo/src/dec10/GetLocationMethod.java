package dec10;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetLocationMethod {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumFiles\\browserDrivers\\chromedriver.exe");
		
				WebDriver driver = new ChromeDriver();
		
				driver.get("https://www.dice.com/");
				
				
				driver.manage().window().maximize(); // maximizes the window
				
				Point location = driver.findElement(By.xpath("//img[@alt='Dice logo'][@class='dice-brand']")).getLocation();
				
				System.out.println(location);

	}

}
