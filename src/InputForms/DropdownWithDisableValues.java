package InputForms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DropdownWithDisableValues {

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
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[3]/div/div[2]/span/span[1]/span/span[2]/b"))
				.click();

		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[3]/div/div[2]/span/span[1]/span/span[2]/b"))
				.click();
		Thread.sleep(1000);
	}

	@Test
	public void testDisableDropDown() throws InterruptedException {
		driver.findElement(By.cssSelector("body > span > span > span.select2-search.select2-search--dropdown > input"))
				.sendKeys("Guam");
		Thread.sleep(1000);
		String output = driver.findElement(By.cssSelector("body > span > span > span.select2-results > ul > li"))
				.getCssValue("user-select");
		Assert.assertEquals(output, "none");

		driver.findElement(By.cssSelector("body > span > span > span.select2-results > ul > li")).click();
		Thread.sleep(1000);
		String actualSelectedValue = driver.findElement(By.cssSelector(
				"body > div.container-fluid.text-center >" + " div > div.col-md-6.text-left > div:nth-child(4) > div > "
						+ "div.panel-body > span > span.selection > span > span"))
				.getText();

		Assert.assertEquals(actualSelectedValue, "American Samoa");

	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}

}
