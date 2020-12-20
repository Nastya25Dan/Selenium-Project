package dec10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAttributeMethod {
	
	public static void main(String[] args) {
		
		
		//Verify the text of the search button
		
		
				System.setProperty("webdriver.chrome.driver", "C:\\SeleniumFiles\\browserDrivers\\chromedriver.exe");
				
				WebDriver driver = new ChromeDriver(); 
						
				driver.get("https://www.google.com/");
				
				String expectedText = "Google Search";
				
				
				String actualText = driver.findElement(By.className("gNO89b")).getAttribute("value");
				
				if(actualText.equals(expectedText)) {
					System.out.println("PASS");
				}else {
					System.out.println("FAIL");
				}

	}

}
