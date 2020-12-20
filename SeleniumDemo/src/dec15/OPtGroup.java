package dec15;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class OPtGroup {

	public static void main(String[] args) {

		
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumFiles\\browserDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.cargurus.com/");
		
//		Select s = new Select (driver.findElement(By.id("carPickerUsed_makerSelect")));
//		
//		List<WebElement> options = s.getOptions();
//		
//		for (WebElement webElement : options) {
//			System.out.println(webElement.getText());
//		}
		driver.findElement(By.id("carPickerUsed_makerSelect")).click();
		driver.findElement(By.xpath("//option[@value='m154']")).click();

	}

}
