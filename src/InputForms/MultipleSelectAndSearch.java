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

public class MultipleSelectAndSearch {

	WebDriver driver;

	@BeforeTest
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "/Users/prmathur/Desktop/Deepika/selenium/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/test/");
	}

	@BeforeMethod
	public void navigateToPage() throws InterruptedException {
		driver.findElement(By.cssSelector("#treemenu > li > ul > li:nth-child(1) > a")).click();
		driver.findElement(By.xpath("//*[@id=\'treemenu\']/li/ul/li[1]/ul/li[7]/a")).click();
		Thread.sleep(1000);
	}

	public void openDropdownAndSelectValue(int location) throws InterruptedException {
		driver.findElement(By
				.cssSelector("body > div.container-fluid.text-center > div > div.col-md-6.text-left > div:nth-child(3) "
						+ "> div > div.panel-body > span > span.selection > span > ul > li > input"))
				.click();

		Thread.sleep(1000);
		driver.findElement(By.cssSelector("body > span > span > span > ul > li:nth-child(" + location + ")")).click();
		Thread.sleep(1000);
	}

	public void assertSelect(int expectedSelections) {
		int size = driver
				.findElements(By.cssSelector("body > div.container-fluid.text-center > div > div.col-md-6.text-left "
						+ "> div:nth-child(3) > div > div.panel-body > span > span.selection > span > ul > li"))
				.size();
		Assert.assertEquals(size, expectedSelections);
	}

	@Test
	public void testOneState() throws InterruptedException {
		openDropdownAndSelectValue(10);
		assertSelect(2);

		openDropdownAndSelectValue(10);
		assertSelect(1);
	}

	@Test
	public void testInvalidInput() throws InterruptedException {

		driver.findElement(By.cssSelector(
				"body > div.container-fluid.text-center > div > div.col-md-6.text-left > div:nth-child(3) >"
						+ " div > div.panel-body > span > span.selection > span > ul > li > input"))
				.click();

		Thread.sleep(1000);

		driver.findElement(By
				.cssSelector("body > div.container-fluid.text-center > div > div.col-md-6.text-left > div:nth-child(3) "
						+ "> div > div.panel-body > span > span.selection > span > ul > li > input"))
				.sendKeys("Vegas");
		Thread.sleep(1000);

		String actualOutput = driver.findElement(By.cssSelector("body > span > span > span > ul > li")).getText();
		Assert.assertEquals(actualOutput, "No results found");

	}

	@Test
	public void testMultipleInput() throws InterruptedException {
		for (int i = 1; i <= 4; i++) {
			openDropdownAndSelectValue(i);
			Thread.sleep(100);
		}
		assertSelect(5);
	}

	@Test
	public void testByRemovingCross() throws InterruptedException {
		openDropdownAndSelectValue(10);
		openDropdownAndSelectValue(1);
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(
				"body > div.container-fluid.text-center > div > div.col-md-6.text-left > div:nth-child(3) > div > div.panel-body > "
						+ "span > span.selection > span > ul > li.select2-selection__choice > span"))
				.click();
		Thread.sleep(1000);
		assertSelect(2);

	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}

}
