package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumDemo {
	
	public static void main(String [] args) {
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumFiles\\browserDrivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();//create a session and open a new browser
		
		driver.get("https://www.duotech.io");//navigate to indicated URL
	}

}
