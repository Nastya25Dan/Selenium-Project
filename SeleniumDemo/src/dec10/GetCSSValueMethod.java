package dec10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class GetCSSValueMethod {

	public static void main(String[] args) {
		
		//Verify the search buttons css properties
		
				System.setProperty("webdriver.chrome.driver", "C:\\SeleniumFiles\\browserDrivers\\chromedriver.exe");
		
				WebDriver driver = new ChromeDriver();
		
				driver.get("https://www.dice.com/");
				
				WebElement searchButton = driver.findElement(By.id("submitSearch-button"));
				
				
				String expectedHeight = "58px";
				String expectedColor = "rgba(204, 0, 0, 1)";
				
				
				
				System.out.println(expectedColor.equals("rgba(204, 0, 0, 1)") && expectedHeight.equals("58px") ? "PASS" : "FAIL");
				
				
				

	}

}
