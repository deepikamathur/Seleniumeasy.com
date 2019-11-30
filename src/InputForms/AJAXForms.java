package InputForms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AJAXForms {

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
		driver.findElement(By.cssSelector("#treemenu > li > ul > li:nth-child(1) > ul > li:nth-child(6) > a")).click();
	}

	@Test
	public void testEmptyForm() throws InterruptedException {
		driver.findElement(By.cssSelector("#btn-submit")).click();
		Thread.sleep(200);
		checkEmptyName();
	}

	public void checkEmptyName() {
		String actualOutput = driver.findElement(By.cssSelector("#frm > div:nth-child(1) > span")).getText();
		Assert.assertEquals("*", actualOutput);

		// border-color getCssValue("border-color")
		String actBorderColor = driver.findElement(By.cssSelector("#title")).getCssValue("border-color");
		Assert.assertEquals(actBorderColor, "rgb(255, 0, 0)");
	}

	@Test
	public void testFilledForm() throws InterruptedException {
		driver.findElement(By.id("title")).sendKeys("Deepika");
		driver.findElement(By.id("description")).sendKeys("Hello");
		driver.findElement(By.id("btn-submit")).click();
		checkSubmit();
	}

	public void checkSubmit() throws InterruptedException {
		// submit button should disappear
		Boolean isPresent = driver.findElements(By.id("btn-submit")).size() > 0;
		Assert.assertFalse(isPresent);

		// Ajax request is processing should appear
		String submitMessage = driver.findElement(By.id("submit-control")).getText();
		Assert.assertEquals(submitMessage, "Ajax Request is Processing!");

		// Form submited Successfully! should appear
		Thread.sleep(1500);
		String afterMessage = driver.findElement(By.id("submit-control")).getText();
		Assert.assertEquals(afterMessage, "Form submited Successfully!");
	}

	@Test
	public void testNameEmpty() throws InterruptedException {
		driver.findElement(By.id("description")).sendKeys("Hello");
		driver.findElement(By.id("btn-submit")).click();
		Thread.sleep(200);
		checkEmptyName();
	}

	@Test
	public void testCommentEmpty() throws InterruptedException {
		driver.findElement(By.id("title")).sendKeys("Deepika");
		driver.findElement(By.id("btn-submit")).click();
		checkSubmit();
	}

	@AfterTest
	public void closeDriver() {
		driver.quit();
	}

}
