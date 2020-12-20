package dec17;

import org.openqa.selenium.By;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InClassWebTables {

	public static void main(String[] args) throws InterruptedException {
		
		//Automation Project #1
		//TestCase:VerifyNewOrderCreation
		
		//1. Open the chrome browser
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumFiles\\browserDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//2. Go to http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx
		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

		//3.Login using username Tester and Password test
		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
		driver.findElement(By.name("ctl00$MainContent$login_button")).click();
		
		//4. Click on Order Link
		driver.findElement(By.linkText("Order")).click();
		
		//5. Enter a random quantity between 1 and 100
		int randomQuantity = (int)(1 + Math.random()*100);
		String randQ = String.valueOf(randomQuantity);
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).sendKeys(randQ);
		
		//6. Enter Customer Name: Mid Name  - should enter a random String of length 5 everytime
		char first = (char)(65 + Math.random()*26);
		String randomMidName = "" + first;
		
		for(int i = 0; i < 5; i++) {
			char c = (char)(97 + Math.random()*26);
			randomMidName += c;
		}
		String name = "Julius " + randomMidName + " Ceasar";
		
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName")).sendKeys(name);
		
		//7. Enter street: 8607 Westwood Center Dr
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2")).sendKeys("8607 Westwood Center Dr");
		
		//8. Enter city: Vienna
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3")).sendKeys("Vienna");
		
		//9. Enter state: Virginia
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4")).sendKeys("Virginia");
		
		//10. Enter a random 5 digit number to the zip code field
		int randZip = (int)(11111 + Math.random()*100000);
		String zip = String.valueOf(randZip);
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).sendKeys(zip);
		
		//11. Select any card type. Every time your code should select a different type.
		int randCardNum = (int)(Math.random()*3);
		String str = String.valueOf(randCardNum);
		String chooseCard = "ctl00_MainContent_fmwOrder_cardList_" + str;
		driver.findElement(By.id(chooseCard)).click();
		
		
		/*12.Enter any card number: 
		If you selected Visa, card number should start with 4.
		If you selected Master, card number should start with 5.
		If you selected American Express, card number should start with 3.
		New card number should be auto generated every time you run the test.
		Card numbers should be 16 digits for Visa and Master,
		15 for American Express.*/
		
		String cardNumRand = "";
		for(int i = 1; i<=15;i++) {
			cardNumRand += (int)(Math.random()*i);
		}
		String card = String.valueOf(cardNumRand);
		String strCardNum = "";

		if (str.equals("0")) {
			strCardNum = "4" + card;
		} else if (str.equals("1")) {
			strCardNum = "5" + card;
		} else if(str.equals("2")) {
			strCardNum = "3" + card.substring(1);
		} else {
			System.out.println("Wrong card number");
		}
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys(strCardNum);
		
		
		//13. Enter a valid expiration date (newer than the current date)
		
		LocalDate today = LocalDate.now();
		today = today.plusYears(4);
		int month = today.getMonthValue();
		String year = String.valueOf(today.getYear());
		
		//DateTimeFormatter f1 = DateTimeFormatter.ofPattern("MM/yy");
		String dateAndYear = month +"/" + year.substring(2);
		//LocalDate date5 = LocalDate.parse(dateAndYear, f1);
		
		//System.out.println(dateAndYear);
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1")).sendKeys(dateAndYear);
		
		//14. Click on process 
		
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();
		
		//15. Verify that the page contains text "New order has been successfully added".
		String containText = "//*[contains(text(),'New order has been successfully added')]";
		String expectedResult = driver.findElement(By.xpath(containText)).getText();
		String actualResult = "New order has been successfully added.";
		
		if(expectedResult.equals(actualResult)) {
			System.out.println("PASS");
		}else {
			System.out.println("FAIL");
		}
		
		
		//
		driver.findElement(By.xpath("//a[@href='Default.aspx']")).click();
        List<WebElement> ths = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr[1]//th"));
        int indexOfName = -1;
        int indexOfZip = -1;
        for (int i = 0; i < ths.size(); i++) {
            if (ths.get(i).getText().equals("Name")) {
                indexOfName = i + 1;
            }
            if (ths.get(i).getText().equals("Zip")) {
                indexOfZip = i + 1;
            }
        }
        
        
        String xpathName = "//table[@id='ctl00_MainContent_orderGrid']//tr[2]//td["+indexOfName+"]";
        
        String actualName = driver.findElement(By.xpath(xpathName))
                .getText();
        if (actualName.equals(name)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        
        
        
        String xpathZip = "//table[@id='ctl00_MainContent_orderGrid']//tr[2]//td["+ indexOfZip +"]";
        
        String actualZip = driver.findElement(By.xpath(xpathZip))
                .getText();
        if (actualZip.equals(zip)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }

		
		
		
		
		
		
	}



}
		
		



