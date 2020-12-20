package dec17;

import org.openqa.selenium.By;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InClassWebTables2 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumFiles\\browserDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
		driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_username\"]")).sendKeys("Tester");
		driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_password\"]")).sendKeys("test");
		driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_login_button\"]")).click();
		

		driver.findElement(By.xpath("//a[@href='Default.aspx']")).click();

		// Verify the expiration column data has a correct format
		
		
		int noOfColumns = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr[1]//th")).size();
		
		int noOfRows = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr")).size();
		
		System.out.println(noOfRows);
		
		int indexOfExp = -1;
		
		List<WebElement> ths = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr[1]//th"));
		
		for (int i = 0; i < ths.size(); i++) {
			if(ths.get(i).getText().equals("Exp")) {
				indexOfExp = i + 1;
			}
		}
		
		
		
		boolean hasCorrectFormat = true;
		
		for (int i = 2; i <= noOfRows ; i++) {  // skip the first row (header)
			
		String xpath = 	"//table[@id='ctl00_MainContent_orderGrid']//tr["+i+"]//td["+indexOfExp+"]";
			
			String text = driver.findElement(By.xpath(xpath)).getText();
			
			if(    text.length() != 5  &&
				! Character.isDigit(text.charAt(0))	 &&
				! Character.isDigit(text.charAt(1))	 &&	
				! Character.isDigit(text.charAt(3))	 &&	
				! Character.isDigit(text.charAt(4))	 &&	
				text.charAt(2) == '/'	
					) {
				hasCorrectFormat = false;
			}
			
		}
		
		
		if(hasCorrectFormat) {
			System.out.println("PASS");
		}else {
			System.out.println("FAIL");
		}
		
		
		
		
		
		for (int i = 2; i <= noOfRows; i++) {
			
			
			for (int j = 1; j <= noOfColumns; j++) {
				
				String cellData = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr["+i+"]//td["+j+"]")).getText();
				System.out.print(cellData + "\t");
			}
			System.out.println();
			
		}
		
		
		System.out.println(driver.findElement(By.id("ctl00_MainContent_orderGrid")).getText());
		
		
	}
	}




		
		



