package dec19;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Iframes {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumFiles\\browserDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://the-internet.herokuapp.com/iframe");
		
//	driver.switchTo().frame(0); // by index (zero-based)
		
//		driver.switchTo().frame("mce_0_ifr"); // by name or id
		
		WebElement iframe = driver.findElement(By.tagName("iframe"));
		
		driver.switchTo().frame(iframe);
		
		
		System.out.println(driver.findElement(By.xpath("//body[@id='tinymce']/p")).getText());
		
		driver.switchTo().defaultContent(); //switches the focus back to the main window
		
		System.out.println(driver.findElement(By.xpath("//a[@href='http://elementalselenium.com/']")).getText());
		
		//body[@id='tinymce']/p
		
//		.sendKeys("Ifarmes are windows inside windows");

	}

}
