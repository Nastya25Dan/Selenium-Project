package dec10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTextMethod {

	public static void main(String[] args) {
		
		// //*[@id="slot-words-list"]/li[1]
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumFiles\\browserDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.dice.com/");
		
		String text = driver.findElement(By.id("slot-words-header")).getText();
		
		System.out.println(text);
		
		String develop = driver.findElement(By.xpath("//ul[@id='slot-words-list']/li[1]")).getText();
		
		System.out.println(develop);


	}

}
