package InputForms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SingleInputFieldTestNG {
	WebDriver driver;

	@BeforeTest
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "/Users/prmathur/Desktop/Deepika/selenium/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/test/");
	}

	@BeforeMethod
	public void navigateToPage() {
		driver.findElement(By.cssSelector("#treemenu > li > ul > li:nth-child(1) > a")).click();
		driver.findElement(By.cssSelector("#treemenu > li > ul > li:nth-child(1) > ul > li:nth-child(1) > a")).click();
	}

	@Test
	public void testString1() {
		checkString("Priyank");
	}
	
	@Test
	public void testString2() {
		checkString("Deepika");
	}
	
	public void checkString(String inputString) {
		driver.findElement(By.cssSelector("#user-message")).sendKeys(inputString);

		driver.findElement(By.cssSelector("#get-input > button")).click();

		WebElement valueElement = driver.findElement(By.cssSelector("#display"));
		String value = valueElement.getText();
		
		Assert.assertEquals(value, inputString);
	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}

}
