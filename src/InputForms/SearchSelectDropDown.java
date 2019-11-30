package InputForms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SearchSelectDropDown {

	WebDriver driver;

	@BeforeTest
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "/Users/prmathur/Desktop/Deepika/selenium/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/test/");
	}

	@BeforeMethod
	public void navigateToPageAndOpenSelect() throws InterruptedException {
		driver.findElement(By.cssSelector("#treemenu > li > ul > li:nth-child(1) > a")).click();
		driver.findElement(By.cssSelector("#treemenu > li > ul > li:nth-child(1) > ul > li:nth-child(7) > a")).click();
	}

	@Test
	public void testSelection() throws InterruptedException {
		driver.findElement(By
				.cssSelector("body > div.container-fluid.text-center > div > div.col-md-6.text-left > div:nth-child(2)"
						+ " > div > div.panel-body > span > span.selection > span"))
				.click();
		Thread.sleep(1000);

		driver.findElement(By.cssSelector("#select2-country-results > li:nth-child(6)")).click();

		Thread.sleep(1000);
		String actualOutput = driver.findElement(By.cssSelector("#select2-country-container")).getText();

		Assert.assertEquals(actualOutput, "India");
	}

	@Test
	public void testInvalidSelection() throws InterruptedException {
		driver.findElement(By
				.cssSelector("body > div.container-fluid.text-center > div > div.col-md-6.text-left > div:nth-child(2)"
						+ " > div > div.panel-body > span > span.selection > span"))
				.click();
		Thread.sleep(1000);

		driver.findElement(By.cssSelector(
				"body > div.container-fluid.text-center > div > div.col-md-6.text-left > div:nth-child(2) > div > div.panel-body > "
						+ "span > span.selection > span > span.select2-selection__arrow > b"))
				.click();
		Thread.sleep(1000);

		driver.findElement(By.cssSelector("body > span > span > span.select2-search.select2-search--dropdown > input"))
				.sendKeys("Canada");
		Thread.sleep(1000);
		String actualOutput = driver.findElement(By.cssSelector("#select2-country-results > li")).getText();
		Assert.assertEquals(actualOutput, "No results found");
	}

	@Test
	public void testSearchPresent() throws InterruptedException {
		driver.findElement(By
				.cssSelector("body > div.container-fluid.text-center > div > div.col-md-6.text-left > div:nth-child(2)"
						+ " > div > div.panel-body > span > span.selection > span"))
				.click();
		Thread.sleep(1000);

		driver.findElement(By.cssSelector("body > span > span > span.select2-search.select2-search--dropdown > input"))
				.sendKeys("Australia");
		Thread.sleep(1000);

		int size = driver.findElements(By.cssSelector("#select2-country-results > li")).size();
		Assert.assertEquals(size, 1);
		String actualOutput = driver.findElement(By.cssSelector("#select2-country-results > li")).getText();
		Assert.assertEquals(actualOutput, "Australia");
	}

	@Test
	public void testSelectionChange() throws InterruptedException {
		driver.findElement(By
				.cssSelector("body > div.container-fluid.text-center > div > div.col-md-6.text-left > div:nth-child(2)"
						+ " > div > div.panel-body > span > span.selection > span"))
				.click();
		Thread.sleep(1000);

		driver.findElement(By.cssSelector("#select2-country-results > li:nth-child(10)")).click();
		Thread.sleep(1000);
		String actualOutput = driver.findElement(By.cssSelector("#select2-country-container")).getText();
		Assert.assertEquals(actualOutput, "South Africa");

		driver.findElement(By
				.cssSelector("body > div.container-fluid.text-center > div > div.col-md-6.text-left > div:nth-child(2)"
						+ " > div > div.panel-body > span > span.selection > span"))
				.click();
		Thread.sleep(1000);

		driver.findElement(By.cssSelector("#select2-country-results > li:nth-child(7)")).click();
		String changedOutput = driver.findElement(By.xpath("//*[@id=\'select2-country-container\']")).getText();
		Assert.assertEquals(changedOutput, "Japan");
	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}
