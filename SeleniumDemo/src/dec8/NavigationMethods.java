package dec8;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationMethods {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumFiles\\browserDrivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://aws.amazon.com/"); //-> navigate to indicate url
		
		//difference between get()  ->> method refreshes and re-loads the whole page whereas
		//and navigate() method ->> doesn't wait till the page load
		//->Navigate() maintains browser history and cookies whereas method doesn't
		
		driver.navigate().to("https://twitter.com/");
		
		driver.navigate().to("https://google.com");
		
		driver.navigate().back();
		
		driver.navigate().forward();
		
		driver.navigate().refresh();
		
	

	}

}
