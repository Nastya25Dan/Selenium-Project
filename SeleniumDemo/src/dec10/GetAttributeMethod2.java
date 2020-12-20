package dec10;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class GetAttributeMethod2 {

	public static void main(String[] args) {	
		
		//Verify the text of the search button
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumFiles\\browserDrivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver(); 
				
		driver.get("https://www.dice.com/");
		
		String expectedText = "Location (zip, city, state)";
		
		
		String actualText = driver.findElement(By.xpath("(//input[@type='search'])[2]")).getAttribute("placeholder");
		
		if(actualText.equals(expectedText)) {
			System.out.println("PASS");
		}else {
			System.out.println("FAIL");
		}
		
		


	}

}
