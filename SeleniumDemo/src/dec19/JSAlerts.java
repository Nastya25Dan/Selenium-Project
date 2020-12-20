package dec19;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSAlerts {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumFiles\\browserDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		driver.findElement(By.xpath("//button[.='Click for JS Alert']")).click();
		
		Alert alert = driver.switchTo().alert();
		
		// NoAlertPresentException -> switchTo().alert() is called and there is no alert on the UI
		String alertText = alert.getText();
		
		alert.accept();
		//alert.dismiss();
		
		if(driver.findElement(By.xpath("//P[@id='result']")).getText().equals("You successfuly clicked an alert")) {
			System.out.println("PASS");
		}else {
			System.out.println("FAIL");
		}
		
		
		driver.findElement(By.xpath("//button[.='Click for JS Confirm']")).click();
		
Alert alert2 = driver.switchTo().alert();
		
		String text = alert2.getText();
		
		alert2.dismiss();
		
		if(driver.findElement(By.xpath("//p[@id='result']")).getText().equals("You clicked: Cancel")
				&& text.equals("I am a JS Confirm")) {
			System.out.println("PASS");
		}else {
			System.out.println("FAIL");
		}
		
		
		driver.findElement(By.xpath("//button[.='Click for JS Prompt']")).click();
		
		driver.switchTo().alert().sendKeys("Duotech");
		// UnhandledAlertException: unexpected alert open:
		driver.switchTo().alert().accept();
		
		if(driver.findElement(By.xpath("//p[@id='result']")).getText().equals("You entered: Duotech")
				) {
			System.out.println("PASS");
		}else {
			System.out.println("FAIL");
		}

	}

}
