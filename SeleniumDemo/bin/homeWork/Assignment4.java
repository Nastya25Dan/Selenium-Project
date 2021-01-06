package homeWork;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment4 {

	static WebDriver driver;

	
	public static void main(String[] args) throws InterruptedException{

		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumFiles\\browserDrivers\\chromedriver.exe");
		
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().window().maximize();
		
		//1.Go to lexus.com
		driver.get("https://www.lexus.com/");
		
		//2.Verify the title of the page contains “Experience Amazing”.
		runTest(driver.getTitle().contains("Experience Amazing"));
	
		//3.Click on Do not Sell My Personal information at the bottom of the page.
		driver.findElement(By.xpath("//a[@href='https://privacy.toyota.com/']")).click();
		
		//4. Verify the page title contains “Privacy Hub”.	

		String mainPage = driver.getWindowHandle();
		Set<String> windowS = driver.getWindowHandles();
		
		for(String next : windowS) {
			if(!(next.equals(mainPage))){
				driver.switchTo().window(next);
			}
		}

		runTest(driver.getTitle().contains("Privacy Hub"));
		
		String privacyPage = driver.getWindowHandle();
		
			
		//5.Click on Your Privacy Rights.
		driver.findElement(By.xpath("//img[@class='m-auto ']")).click();
		
		//6. Verify that the page url is “https://privacy.toyota.com/privacy-hub/privacyright.html”.
		runTest(driver.getCurrentUrl().equals("https://privacy.toyota.com/privacy-hub/privacyright.html"));
		
		//7.Go back to the main window and click on Build your Lexus.
		driver.switchTo().window(mainPage);
		driver.findElement(By.xpath("//a[@href='/build-your-lexus/#!/']")).click();
		
		//8.Enter “22182” for zipcode and click on Enter on pop-up window.
		WebElement zipCode = driver.findElement(By.xpath("//input[@value='Enter Zip']"));
		Thread.sleep(2000);
		zipCode.sendKeys("22181");//ElementNotInteractableException: element not interactable
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//9.Click on model GS.
		driver.findElement(By.xpath("//img[@src='/byl2014/pub-share/images/series/gs.png']")).click();
		
		
		//10.Choose 2020 GS 350 F Sport AWD.		//54.505//2020 GS 350 F SPORT 
			//Before clicking, get the price of the vehicle and save it into an int variable.
		
		WebElement wb = driver.findElement(By.xpath("(//span[@class='title-price-med float-right'])[4]"));

		int sportPrice = convertThePrice(wb);
		Thread.sleep(1000);

		driver.findElement(By.xpath("(//span[@class='title-price-med float-right'])[4]")).click();
		
		//11.On the next page, click on the price menu on top and retrieve and store the base price,
			//dp&h fee and msrp into separate int variables.
			//Verify that the base price is the same as the price shown at Step 10. 
			//Verify that msrp equals to base price + dp&h fee;

		driver.findElement(By.xpath("//span[@id='total-price']")).click();
		
		WebElement wb1 = driver.findElement(By.xpath("//span[@class='title-price-small']"));
	
		int base = convertThePrice(wb1);
		
		WebElement wb2 =  driver.findElement(By.xpath("(//span[@class='title-price-small'])[4]"));
		
		int feeNum = convertThePrice(wb2);
		
		WebElement wb3 = driver.findElement(By.xpath("//*[@id=\"total-amount\"]"));
	
		int mspNum = convertThePrice(wb3);

		runTest(base==sportPrice);
		
		runTest(mspNum == base + feeNum);
		
		//12.Close the menu and click on Ultrasonic Blue Mica color.
		driver.findElement(By.xpath("//a[@class='img-icon-x']")).click();
		
		driver.findElement(By.xpath("(//li[@class='color-item'])[5]")).click();
		
		//13.Click on the price menu on top again and retrieve the price for color and store into int variable.
			//Retrieve msrp one more time and verify that msrp  now equals to base price + dp&h fee + color
		driver.findElement(By.xpath("//span[@id='total-price']")).click();
		
		WebElement wb4 = driver.findElement(By.xpath("(//span[@class='title-price-small'])[2]"));

		int colorPrice = convertThePrice(wb4);
		
		WebElement wb5 = driver.findElement(By.xpath("//span[@id='total-amount']"));
		
		int totalAmount = convertThePrice(wb5);
		
		runTest(totalAmount == base + feeNum + colorPrice);
		
		//14.Close the price menu and click on Next:Interior button
		driver.findElement(By.xpath("//a[@class='img-icon-x']")).click();
		
		driver.findElement(By.xpath("//a[@id='configurator-interior-color-selected']")).click();
		
		Thread.sleep(1000);
		//15.Choose “Rioja Red leather with Naguri Aluminum trim” from the options .Click on Next:packages 
		
		driver.findElement(By.xpath("(//a[@class='byl-js-color'])[2]")).click();
		
		driver.findElement(By.xpath("//a[@id='configurator-packages-selected']")).click();
		
		//16.In the next menu, click on add button for Mark Levinson sound system.
		
		driver.findElement(By.xpath("(//a[@class='byl-js-opt-select addRemove'])[1]")).click();
		
		//17.Click on price menu again and retrieve and store the price for Sound system into int variable.
			//Retrieve msrp once again and verify that msrp now equals to to base price + dp&h fee + color+sound system.
		driver.findElement(By.xpath("//span[@id='total-price']")).click();
		
		WebElement wb6 = driver.findElement(By.xpath("//*[@id=\"price-breakup-list\"]/li[4]/div/span"));
		
		int priceforMusicSys = convertThePrice(wb6);
		
		WebElement wb7 = driver.findElement(By.xpath("//span[@id='total-amount']"));
		
		int totalAmount2 = convertThePrice(wb7);
		
		//System.out.println(totalAmount2 +" "+ base +" "+ feeNum +" "+ colorPrice +" "+ priceforMusicSys);

		runTest(totalAmount2 == base + feeNum + colorPrice + priceforMusicSys);
		
		//18.Click on Next:Accessories , on the next menu don’t add anything and click on Next:summary
		
		driver.findElement(By.xpath("//a[@role='button']")).click();
		driver.findElement(By.xpath("//a[@class='display-summary omniture']")).click();
		
		//19.On the next page, retrieve msrp and verify that it is equal to the final msrp from step 17.
			//Then click on Send to Dealer.
		
		WebElement wb8 = driver.findElement(By.xpath("//h2[@class='title-price']"));

		int finalPrice = convertThePrice(wb8);

		runTest(totalAmount2 == finalPrice);

		driver.findElement(By.xpath("//a[@href='purchase-inquiry.html']")).click();
		
		//20.Next, first verify that the page contains “Send us Your Dream Car” text.
			//Then enter the below information to the form fields, choose Pohanka as preferred dealer and click on submit.
		
		Set<String> windowSnew = driver.getWindowHandles();

		for (String next : windowSnew) {
			if (!(next.equals(mainPage) && next.equals(privacyPage))) {
				driver.switchTo().window(next);
			}
		}

		driver.findElement(By.xpath("//h1[@class='title-intro-overlay']")).getText();
		runTest(driver.getPageSource().contains("Send us Your Dream Car"));
		
		WebElement firstName = driver.findElement(By.name("firstname"));
		firstName.sendKeys("Thomas");
		WebElement lastName = driver.findElement(By.id("last-name"));
		lastName.sendKeys("Anderson");
		WebElement email = driver.findElement(By.name("email"));
		email.sendKeys("tom.anderson@gmail.com");
		WebElement phone = driver.findElement(By.id("phone"));
		phone.sendKeys("5024030787");
		
		WebElement radioButton = driver.findElement(By.xpath("//label[@for='64504']"));
		
//		if(!radioButton.isSelected()) {
//			radioButton.click();
//		}
		//maybe other people had options, in my case i had only one option pohanka
		//and i try to check if it is check or not, but t gives me 
		//ElementNotInteractableException: element not interactable
		
		
		driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
		
		

		//21.In the last page, verify that the page contains “We'll Be In Touch Shortly” text.
	
		driver.findElement(By.xpath("//div[@class='list-title-sub']")).getText();
		runTest(driver.getPageSource().contains("We'll Be In Touch Shortly"));
	
	
	}

	public static void runTest(boolean condition) {
			
		if (condition) {
			System.out.println("PASS");
		} else {
			System.out.println("FAIL");
		}
	}

	public static int convertThePrice(WebElement webPrice) {

		int price = Integer.parseInt((webPrice.getText()).replaceAll("[$,*]", ""));

		return price;
	}

}
