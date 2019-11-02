package InputForms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MultipleCheckBoxDemoTestNG {

	WebDriver driver;
	int[] noOptions = new int[] {};
	int[] unselectOptions = new int[] { 1, 3 };

	@BeforeTest
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "/Users/prmathur/Desktop/Deepika/selenium/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/test/");
	}

	@BeforeMethod
	public void navigateToPage() {
		driver.findElement(By.cssSelector("#treemenu > li > ul > li:nth-child(1) > a")).click();
		driver.findElement(By.cssSelector("#treemenu > li > ul > li:nth-child(1) > ul > li:nth-child(2) > a")).click();
	}

	
	public void testMultipleCheckBox(int[] selectOptions, int[] unselectOptions,
			String expectedValue) {

		// Select options
		for (int i = 0; i < selectOptions.length; i++) {
			driver.findElement(By.cssSelector(
					"#easycont > div > div.col-md-6.text-left > " + "div:nth-child(5) > div.panel-body > div:nth-child("
							+ (selectOptions[i] + 2) + ") > label > input"))
					.click();
		}

		// Unselect options
		for (int i = 0; i < unselectOptions.length; i++) {
			driver.findElement(By.cssSelector(
					"#easycont > div > div.col-md-6.text-left > " + "div:nth-child(5) > div.panel-body > div:nth-child("
							+ (unselectOptions[i] + 2) + ") > label > input"))
					.click();
		}

		WebElement element = driver.findElement(By.cssSelector("#check1"));

		String actualValue = element.getAttribute("value");

		Assert.assertEquals(actualValue, expectedValue);

	}

	@Test
	public void Test1() {
		int[] optionsToSelectTest1 = new int[] { 1 };
		testMultipleCheckBox(optionsToSelectTest1, noOptions, "Check All");

	}

	@Test
	public void Test2() {
		int[] optionsToSelectTest2 = new int[] { 1, 3 };
		testMultipleCheckBox(optionsToSelectTest2, noOptions, "Check All");

	}

	@Test
	public void Test3() {
		int[] optionsToSelectTest3 = new int[] { 1, 2, 3, 4 };
		testMultipleCheckBox(optionsToSelectTest3, noOptions, "Uncheck All");

	}

	@Test
	public void Test4() {
		int[] optionsToSelectTest4 = new int[] { 1, 2, 3, 4 };
		testMultipleCheckBox(optionsToSelectTest4, unselectOptions, "Check All");
	}


	public void testCheckAllButton(WebDriver driver) {

		driver.findElement(By.cssSelector("#check1")).click();

		boolean allSelected = true;
		for (int i = 0; i < 4; i++) {
			WebElement element = driver
					.findElement(By.cssSelector("#easycont > div > div.col-md-6.text-left > div:nth-child(5)"
							+ " > div.panel-body > div:nth-child(" + (i + 3) + ") > label > input"));
			boolean actualValue = element.isSelected();
			allSelected = actualValue & allSelected;
		}

		Assert.assertTrue(allSelected);

		driver.findElement(By.cssSelector("#check1")).click();
		boolean allUnselected = false;
		for (int i = 0; i < 4; i++) {
			WebElement element = driver
					.findElement(By.cssSelector("#easycont > div > div.col-md-6.text-left > div:nth-child(5)"
							+ " > div.panel-body > div:nth-child(" + (i + 3) + ") > label > input"));
			boolean actualValue = element.isSelected();
			allUnselected = actualValue | allUnselected;
		}

		Assert.assertFalse(allUnselected);
	}

	@Test
	public void Test5() {
		testCheckAllButton(driver);

	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}

}
