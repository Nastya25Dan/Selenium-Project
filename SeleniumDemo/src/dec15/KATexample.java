package dec15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class KATexample {
	
	public static void main(String [] atgs) {
	
		
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumFiles\\browserDrivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("http://automationpractice.com/index.php");
		
		driver.findElement(By.className("login")).click();
    
		WebElement email = driver.findElement(By.id("email_create"));
		
		email.sendKeys("123abc123abc@gmail.com");
    
		driver.findElement(By.id("SubmitCreate")).click();
    
		WebElement firstName = driver.findElement(By.id("customer_firstname"));
		firstName.sendKeys("ABC");

		WebElement lastName = driver.findElement(By.id("customer_lastname"));
		lastName.sendKeys("DEF");

		WebElement password = driver.findElement(By.id("passwd"));
		password.sendKeys("ABCDEF");

		WebElement address = driver.findElement(By.id("address1"));
		address.sendKeys("123 ABC St");

		WebElement city = driver.findElement(By.id("city"));
		city.sendKeys("Cumming");

		WebElement zipcode = driver.findElement(By.id("postcode"));
		zipcode.sendKeys("30040");

		WebElement phone = driver.findElement(By.id("phone_mobile"));
		phone.sendKeys("404-111-1111");

		driver.findElement(By.id("submitAccount")).click();

		boolean actualResult = driver.getPageSource().contains("My Account");
		if (actualResult) {
			System.out.println("PASS");
		} else {
			System.err.println("FAIL");
		}
		boolean actualResult1 = driver.getPageSource()
				.contains("Welcome to your account. Here you can manage all of your personal information and orders.");
		if (actualResult1) {
			System.out.println("PASS");
		} else {
			System.err.println("FAIL");
		}
	}

}
