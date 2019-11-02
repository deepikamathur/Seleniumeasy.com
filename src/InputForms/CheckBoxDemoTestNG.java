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

public class CheckBoxDemoTestNG {

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

	public void clickCheckBox(int numClicks, String expectedOutput) throws InterruptedException {
		driver.findElement(By.cssSelector("#treemenu > li > ul > li:nth-child(1) > a")).click();
		driver.findElement(By.cssSelector("#treemenu > li > ul > li:nth-child(1) > ul > li:nth-child(2) > a")).click();

		for (int i = 0; i < numClicks; i++) {
			driver.findElement(By.id("isAgeSelected")).click();
			Thread.sleep(100);
		}

		WebElement element = driver.findElement(By.id("txtAge"));
		String actualOutput = element.getText();

		Assert.assertEquals(actualOutput, expectedOutput);
	}

	@Test
	public void testString1() throws InterruptedException {
		clickCheckBox(1, "Success - Check box is checked");
	}

	@Test
	public void testString2() throws InterruptedException {
		clickCheckBox(2, "");
	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}

}
