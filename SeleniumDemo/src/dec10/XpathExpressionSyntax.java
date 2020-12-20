package dec10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathExpressionSyntax {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumFiles\\browserDrivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.dice.com/");
		
		System.out.println((driver.findElements(By.xpath("//div")).size()));
	}

}
