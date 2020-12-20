package dec12;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class CheckBoxesDemo {

	public static void main(String[] args) throws InterruptedException {
		
		// Go to web orders
				// Check all orders and hit delete button
				// Verify that the message "List of orders is empty. In order to add new order use this link." is there
				
				
				System.setProperty("webdriver.chrome.driver", "C:\\SeleniumFiles\\browserDrivers\\chromedriver.exe");
		
				WebDriver driver = new ChromeDriver();
				
				driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
				
				
				WebElement userName = driver.findElement(By.name("ctl00$MainContent$username"));// located element
				userName.sendKeys("Tester");
				WebElement password = driver.findElement(By.name("ctl00$MainContent$password"));// located element
				password.sendKeys("test" + Keys.ENTER);
				
				List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
				
				
				for (WebElement webElement : checkboxes) {
					if(!webElement.isSelected()) {
						webElement.click();
						Thread.sleep(2000);
					}
				}
				
				driver.findElement(By.id("ctl00_MainContent_btnDelete")).click();
				
				if(driver.getPageSource().contains("List of orders is empty")) {
					System.out.println("PASS");
				}else {
					System.out.println("FAIL");
				}

		
		
	}

}
