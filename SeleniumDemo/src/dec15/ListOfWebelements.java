package dec15;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ListOfWebelements {

	public static void main(String[] args) throws InterruptedException {
		
				System.setProperty("webdriver.chrome.driver", "C:\\SeleniumFiles\\browserDrivers\\chromedriver.exe");
		
				WebDriver driver = new ChromeDriver();
		
				driver.get("http://dice.com");
				
				// Search for "Automation Engineer"
				// Verify that results contain these 2 keywords
				
				String [] searchTerms = {"Automation", "Engineer"};
				
				String zipcode = "22182";
				
				driver.findElement(By.xpath("//input[@placeholder='Job title, skills or company']")).sendKeys(searchTerms[0] +" "+ searchTerms[1]);
				
				driver.findElement(By.xpath("//input[@placeholder='Location (zip, city, state)']")).sendKeys(zipcode);
				
				
				driver.findElement(By.xpath("//button[@data-cy='submit-search-button']")).click();
				
				Thread.sleep(2000);
				
				
				 int defaultCount = Integer.parseInt(new Select(driver.findElement(By.id("pageSize_2"))).getFirstSelectedOption().getText().trim());
				
				List<WebElement> results = driver.findElements
						(By.xpath("//div[@class='ng-star-inserted'][@id='searchDisplay-div']//a[@class='card-title-link bold']"));
				
				
				
				List<String> strings = new ArrayList<>();
				
				
				
				for (WebElement webElement : results) {
					strings.add(webElement.getText());
				}
				
				boolean contains = true;
				for (String string : strings) {
					if(!string.contains(searchTerms[0]) && string.contains(searchTerms[1])) {
						contains = false;
					}
				}
				
				if (contains) {
					System.out.println("PASS");
				}else {
					System.out.println("FAIL");
				}
				
				
				
				if(defaultCount == results.size()) {
					System.out.println("PASS");
				}else {
					System.out.println("FAIL");
				}

	}

}
