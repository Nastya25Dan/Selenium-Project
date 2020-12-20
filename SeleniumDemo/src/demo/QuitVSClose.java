package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class QuitVSClose {
	
	public static void main(String [] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumFiles\\browserDrivers\\chromedriver.exe");
		
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.duotech.io");
		
		
		driver.get("htpps://www.github.com");
		
//		driver.close();//closes the current window but does not end the session
		
//		driver = new ChromeDriver();
//		
//		driver.get("htpps://twitter.com");
		
		driver.close();
		
		//driver.quit();//closing the whole session
	}

}
