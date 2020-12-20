package dec12;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RAdioButtons {

	public static void main(String[] args) throws InterruptedException {

		// https://www.keynotesupport.com/internet/web-contact-form-example-radio-buttons.shtml
		
		
				System.setProperty("webdriver.chrome.driver", "C:\\SeleniumFiles\\browserDrivers\\chromedriver.exe");
	
				WebDriver driver = new ChromeDriver();
				
				driver.get("https://www.keynotesupport.com/internet/web-contact-form-example-radio-buttons.shtml");
				
				driver.findElement(By.xpath("//a[.='Understood']")).click();
				
				Thread.sleep(1000);
				
				driver.findElement(By.xpath("//input[@value='Excel']")).click();
				
				WebElement radioButton = driver.findElement(By.xpath("//input[@value='Intermediate']"));
				
				
				if(!radioButton.isSelected()) {
					radioButton.click();
				}
				
				List<WebElement> list = driver.findElements(By.xpath("//input[@name='software']"));
				
				System.out.println(list.size());
				
				for (WebElement webElement : list) {
					
					if(webElement.getAttribute("value").equals("Photoshop")) {
						webElement.click();
					}
				}

	}

}
