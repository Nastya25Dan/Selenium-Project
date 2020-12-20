package dec10;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class GetSizeMethod {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumFiles\\browserDrivers\\chromedriver.exe");
		
				WebDriver driver = new ChromeDriver();
		
				driver.get("https://www.dice.com/");
				
				try {
					Dimension size = driver.findElement(By.xpath("//img[@alt='Dice logo'][@class='dice-brand']")).getSize();
					
					System.out.println(size);
								
					
					if(size.height>0 && size.width>0) {
						System.out.println("Element exists on the page");
					}else {
						System.out.println("Element does not exist on the page");
					}
				} catch (NoSuchElementException e) {
					System.out.println("Element does not exist");
				}


	}

}
