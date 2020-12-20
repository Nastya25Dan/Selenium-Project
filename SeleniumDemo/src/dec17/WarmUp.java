package dec17;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WarmUp {
	
    static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumFiles\\browserDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.kayak.com/");
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        
        driver.findElement(By.xpath("//a[@href='/flights']")).click();
        
        driver.findElement(By.xpath("(//button[@type='button'][@class='Button-No-Standard-Style js-remove-selection _iae _h-Y'])[1]")).click();
        driver.findElement(By.cssSelector("input[id$='-origin-airport']")).sendKeys("ATL" + Keys.ENTER);
        driver.findElement(By.cssSelector("div[id$='destination-airport-display-inner']")).click();
        driver.findElement(By.cssSelector("input[id$='-destination-airport']")).sendKeys("Oranjestad");
        
        driver.findElement(By.xpath("//div[.='Oranjestad, Aruba']")).click();
        
        
        driver.findElement(By.cssSelector("div[id$='dateRangeInput-display-start-inner']")).click();
        
        
//      driver.findElement(By.xpath("(//div[@class='month '])[2]//div[.='23']")).click();
//      
//      driver.findElement(By.xpath("(//div[@class='month '])[2]//div[.='30']")).click();
        
        
//      driver.findElement(By.xpath("(//div[@class='month '])[2]//div[.='31']")).click();
//      
//      driver.findElement(By.xpath("(//div[@class='month '])[3]//div[.='6']")).click();
        
        
        
        
        pickAYearAndMonth("2021", "February");
        
        pickADate("23");
        pickADate("30");
        
        
    }
    
    public static void pickAYearAndMonth(String year, String month) throws InterruptedException {
        WebElement button = driver.findElement(By.xpath("//div[@id='stl-jam-cal-nextMonth']"));
        month = month.substring(0,1).toUpperCase() + month.substring(1);
        System.out.println(month);
        while(! driver.findElement(By.xpath("(//div[@class='_ijM _iAr _iaB _idE _iXr'])[2]")).getText().
                equals( month + " " + year)) {
            button.click();
        }
        
        Thread.sleep(3000);
    }
    
    public static void pickADate(String date) throws InterruptedException {
        
        driver.findElement(By.xpath("(//div[@class='month '])[2]//div[.='"+date+"']")).click();

	
		
	}

}
