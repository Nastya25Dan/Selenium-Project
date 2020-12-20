package dec19;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NonJSAlertsOverlaysOrPopUps {
	
	public static void main(String [] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumFiles\\browserDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		//hard to handle, able to inspect but not know hwen it is going to popup
	}

}
