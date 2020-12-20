package dec15;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class WarmUp {

	public static void main(String[] args) throws InterruptedException {
		
		/*
         * Warm up:
                1. Go to http://automationpractice.com/index.php
                2. Click on Sign In
                3. Click on "Create account" by entering a new email
                4. Fill out the form using Selenium methods, and Select class for dropdowns
                5. Click on Register
                6. Verify the page title contains "My Account"
                7. Verify that page contains "Welcome to your account. Here you can manage all of your personal information and orders."
                8. Verify that customer name is the same as the entered name.
                9.Click on Sign Out and verify that you are successfully signed out by verifying the page title.
         */

		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumFiles\\browserDrivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://automationpractice.com/index.php");
		
	//	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);-> global implicit wait for all findElement() method
//	driver.manage
		driver.findElement(By.className("login")).click();
		smartWait(2000);
		
		driver.findElement(By.id("email_create")).sendKeys(randomEmail());
		smartWait(2000);
		
		driver.findElement(By.name("SubmitCreate")).click();
		smartWait(2000);
		
		driver.findElement(By.xpath("//input[@value='2']")).click();
		smartWait(2000);
		String firstname = "Ada";
		String lastname = "Aga";
		driver.findElement(By.id("customer_firstname")).sendKeys(firstname);
		driver.findElement(By.id("customer_lastname")).sendKeys(lastname);
		driver.findElement(By.id("passwd")).sendKeys("112255");
		
//		WebElement dateOfB = driver.findElement(By.name("days"));
//		Select dateofBirth = new Select(dateOfB);
//		dateofBirth.selectByValue("2");
		new Select(driver.findElement(By.name("days"))).selectByValue("" + (1 + new Random().nextInt(31)));
		new Select(driver.findElement(By.name("months"))).selectByValue("" + (1 + new Random().nextInt(12)));
		new Select(driver.findElement(By.name("years"))).selectByValue("" + (1900 + new Random().nextInt(120)));
		
		WebElement checkbox = driver.findElement(By.id("newsletter"));
		
		 if (!checkbox.isSelected()) {
	            checkbox.click();
	        }
		
		
		driver.findElement(By.id("address1")).sendKeys("120 Talbot St");
		driver.findElement(By.id("city")).sendKeys("Bethesda");
		new Select(driver.findElement(By.name("id_state"))).selectByValue("" + (1 + new Random().nextInt(53)));
		smartWait(53);
		 driver.findElement(By.id("postcode")).sendKeys("" + (10000 + new Random().nextInt(90000)));
	        smartWait(1000);
	        WebElement country = driver.findElement(By.id("id_country"));
	        Select myCountry = new Select(country);
	        myCountry.selectByVisibleText("United States");
	        driver.findElement(By.id("phone_mobile")).sendKeys(randomPhone());
	        driver.findElement(By.id("submitAccount")).click();
	        smartWait(3000);
	        
	        String str = "Welcome to your account";
	        String title = "My account";
	        
	        if (driver.getTitle().contains(title)) {
	            System.out.println("PASS");
	        } else {
	            System.out.println("FAIL");
	        }
	        if (driver.getPageSource().contains(str)) {
	            System.out.println("PASS");
	        } else {
	            System.out.println("FAIL");
	        }
	        
	        WebElement span = driver.findElement(
	                By.xpath("//a[@href='http://automationpractice.com/index.php?controller=my-account']/span"));
//	       
	        if (span.getText().equals(firstname + " " + lastname)) {
	            System.out.println("PASS");
	        } else {
	            System.out.println("FAIL");
	        }
	        smartWait(1000);
	        driver.findElement(By.xpath("//a[@href='http://automationpractice.com/index.php?mylogout=']")).click();

	        smartWait(3000);
	        String str1 = "Create an account";
	        if (driver.getPageSource().contains(str1)) {
	            System.out.println("PASS");
	        } else {
	            System.out.println("FAIL");
	        }
	        
	        if (driver.getTitle().contains("Login")) {
	            System.out.println("PASS");
	        } else {
	            System.out.println("FAIL");
	        }

	}
	private static String randomEmail() {
		String str="";
		String str1="@gmail.com";
		
		for(int i=0;i<5;i++) {
			str=str + ((char)((Math.random()*26)+97));
		}
		return str+str1;
		
		
	}
private static void smartWait(int time) {
        
        try{ Thread.sleep(time);}
        catch(Exception e){}
        
    }
private static String randomPhone() {
	String str="";
	for(int i=0;i<10;i++) {
		str=str + (int)(Math.random()*9 + 1);
	}
	return str;
	}

}
