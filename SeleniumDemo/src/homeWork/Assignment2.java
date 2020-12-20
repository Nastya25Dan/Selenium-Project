package homeWork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumFiles\\browserDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//1. Go  to carfax.com
		driver.get("https://www.carfax.com/");
		Thread.sleep(2000);
		
		//2. Click on Find a Used Car
		driver.findElement(By.id("cfx-cars")).click();
		
		//3. Verify the page title contains the word “Used Cars”
		String actualResult = driver.getTitle();
		String expectedResult = "Used Cars";
		System.out.print("Test case #1: ");
		runTest(actualResult.contains(expectedResult));
		
		//4. Choose “Tesla” for  Make.
		WebElement selectMake = driver.findElement(
				By.xpath("//select[@class='form-control search-make']"));
		selectMake.click();
		Select makeToSelect = new Select(selectMake);
		makeToSelect.selectByValue("Tesla");
		
		//5. Verify that the Select Model dropdown box contains 3 current Tesla models - (Model 3, Model S, Model X). 
		WebElement selectModel = driver.findElement(
				By.xpath("//select[@class='form-control search-model ']"));
		selectModel.click();
		Select modelToSelect = new Select(selectModel);
		List<String> expectedOptions = Arrays.asList("Model 3", "Model S", "Model X");
		List<WebElement> options = modelToSelect.getOptions();
		boolean pass = true;
		for (int i = 0; i < expectedOptions.size(); i++) {
			if (options.get(i).getText().equals(expectedOptions.get(i))) {
				pass = false;
			}
		}
		System.out.print("Test case #2: ");
		runTest(pass);
		
		//6. Choose “Model S” for Model.
		modelToSelect.selectByValue("Model S");
		
		//7. Enter the zipcode as 22182 and click Next
		driver.findElement(By.xpath("//input[@name='zip']")).sendKeys("22182");
		
		//8. Verify that the page has “Step 2 – Show me cars with” text
		driver.findElement(By.id("make-model-form-submit")).click();
		String expectedPage2Con = "Step 2 - Show me cars with";
		System.out.print("Test case #3: ");
		runTest(driver.getPageSource().contains(expectedPage2Con));

		//9. Click on all 4 checkboxes.
		List<WebElement> checkboxes = driver.findElements(
				By.xpath("//span[@class='checkbox-list-item--fancyCbx']"));
		for (WebElement webElement : checkboxes) {
			if (!webElement.isSelected()) {
				webElement.click();
				Thread.sleep(1000);
			}
		}
			
		//10. Save the result of “Show me X Results” button to a variable. In this case it is 6.
		String result = driver.findElement(
				By.xpath("//span[@class='totalRecordsText']")).getText();
		
		//11. Click on “Show me x Results” button. 
		driver.findElement(By.xpath("//button[@class='button large primary-green']")).click();
			
		//12. On the next page, verify that the results page has the same number of results as indicated in Step 10 
			//by extracting the number and comparing the result
		String result2 = driver.findElement(By.id("totalResultCount")).getText();
		System.out.print("Test case #4: ");
		runTest(result.equals(result2));
			
		//13. Verify the results also by getting the actual number of results displayed in the page with the number in the Step 10.
			//For this step get the count the number of WebElements related to each result.
		int size = driver.findElements(
				By.xpath("//h4[@class='srp-list-item-basic-info-model']")).size();
		System.out.print("Test case #5: ");
		runTest(size == Integer.parseInt(result));
			
		//14. Verify that each result contains String “Tesla Model S”.
		List<WebElement> elementResult = driver.findElements(
				By.xpath("//h4[@class='srp-list-item-basic-info-model']"));
		System.out.print("Test case #6: ");
		for (WebElement eachElement : elementResult) {
			runTest(eachElement.getText().contains("Tesla Model S"));
		}

		//15. Get the price of each result and save them into a list in the order of their appearance.
		List<WebElement> prices = driver.findElements(
				By.xpath("//*[@class='srp-list-item-price']"));
		List<String> listOfPrices = new ArrayList<String>();
		for (WebElement eachPrice : prices) {
			listOfPrices.add(eachPrice.getText().substring(7));
		}
		System.out.println(listOfPrices);

		//16.Choose “Price - High to Low” option from Sort menu
		WebElement filterOPtions = driver.findElement(By.className("srp-header-sort-select"));
		Select chooseFilter = new Select(filterOPtions);
		chooseFilter.selectByVisibleText("Price - High to Low ");
		
		//17. Verify that the results are displayed from high to low price. 
		String actualText = driver.findElement(By.id("priceDesc")).getText();
		System.out.print("Test case #7: ");
		runTest(actualText.equals("Price - High to Low "));
		
		//18. Choose “Mileage - Low to High” option from Sort menu
		chooseFilter.selectByValue("MILEAGE_ASC");
		
		//19. Verify that the results are displayed from low to high mileage.
		String actualTest2 = driver.findElement(By.id("mileageAsc")).getText();
		System.out.println("Test case #8: ");
		runTest(actualTest2.equals("Mileage - Low to High "));
		
		//20. Choose “Year - New to Old” option from Sort menu
		chooseFilter.selectByIndex(6);
		
		//21. Verify that the results are displayed from new to old year. 
		String actualResult3 = driver.findElement(By.id("yearDesc")).getText();
		System.out.println("Test case #9: ");
		runTest(actualResult3.equals("Year - New to Old "));
		
			
	}
		public static void runTest(boolean condition) {

			if (condition) {
				System.out.println("PASS");
			} else {
				System.out.println("FAIL");
			}
		}
	}
