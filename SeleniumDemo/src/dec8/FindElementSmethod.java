package dec8;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;


public class FindElementSmethod {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumFiles\\browserDrivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.duotech.io/");
		
		//to locate multi-elements - table rows, links - with return type LIST
		
		//driver.findElement(By.tagName("a")).click();//the first link
		
		List <WebElement> allLinks = driver.findElements(By.tagName("a"));
		
		for (WebElement webElement : allLinks) {
			System.out.println(webElement.getText());//->> return the text of the link
			//return empty string if it is invisible link(like drop down)
			//or simply call method .click() but will trow StaleElementReferenceException
			//which means element is not attached to the page
			
			List<WebElement> allIframes = driver.findElements(By.tagName("iframe"));
			
			System.out.println(allIframes.size());
		}
	}

}
