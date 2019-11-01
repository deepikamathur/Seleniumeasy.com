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

public class TwoInputFieldsTestNG {
	WebDriver driver;

	@BeforeTest
	public void openBrowser() {

		System.setProperty("webdriver.chrome.driver", "/Users/prmathur/Desktop/Deepika/selenium/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/test/");
	}

	@AfterTest
	public void closeDriver() {
		driver.quit();
	}

	@BeforeMethod
	public void navigateToPage() {
		driver.findElement(By.cssSelector("#treemenu > li > ul > li:nth-child(1) > a")).click();
		driver.findElement(By.xpath("//*[@id=\'treemenu\']/li/ul/li[1]/ul/li[1]")).click();

	}

	public void addTwoInputs(String a, String b, String expectedOutput) {

		driver.findElement(By.id("sum1")).sendKeys(a);
		driver.findElement(By.id("sum2")).sendKeys(b);
		driver.findElement(By.cssSelector("#gettotal > button")).click();
		WebElement outputElement = driver.findElement(By.id("displayvalue"));
		String actualOutput = outputElement.getText();

		Assert.assertEquals(actualOutput, expectedOutput);
	}

	@Test
	public void testTwoInputs1() {
		addTwoInputs("5", "10", "15");
	}

	@Test
	public void testTwoInputs2() {
		addTwoInputs("a", "10", "NaN");
	}
	
	@Test
	public void testTwoInputs3() {
		addTwoInputs("10", "b", "NaN");
	}
	
	@Test
	public void testTwoInputs4() {
		addTwoInputs("*", "b", "NaN");
	}
	
	@Test
	public void testTwoInputs5() {
		addTwoInputs("-10", "6", "-4");
	}
	
	@Test
	public void testTwoInputs6() {
		addTwoInputs("-10", "-6", "-16");
	}
	
	@Test
	public void testTwoInputs7() {
		addTwoInputs("", "10", "NaN");
	}
	
	@Test
	public void testTwoInputs8() {
		addTwoInputs("1000000000000", "1000000000000", "2000000000000");
	}
	
}
