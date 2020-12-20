package dec10;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class GetTagMethod {

	public static void main(String[] args) {
		
		// Locate all elements with a specific class and go through them and filter them by tag name
		
				System.setProperty("webdriver.chrome.driver", "C:\\SeleniumFiles\\browserDrivers\\chromedriver.exe");
		
				WebDriver driver = new ChromeDriver();
		
				driver.get("https://www.dice.com/");
				
				//seo-list-item
				
				List<WebElement> allElements = driver.findElements(By.className("seo-list-item"));
				
				
				for (WebElement webElement : allElements) {
					if(webElement.getTagName().equals("p"))
					System.out.println(webElement.getText());
				}

	}

}
