package InputForms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleCheckBoxDemo {
	public static void main(String args[]) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/prmathur/Desktop/Deepika/selenium/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/test/");

		/*
		 * int[] noOptions = new int[] {}; int[] unselectOptions = new int[] { 1, 3 };
		 * 
		 * int[] optionsToSelectTest1 = new int[] { 1 }; testMultipleCheckBox(driver,
		 * optionsToSelectTest1, noOptions, "Check All");
		 * 
		 * int[] optionsToSelectTest2 = new int[] { 1, 3 }; testMultipleCheckBox(driver,
		 * optionsToSelectTest2, noOptions, "Check All");
		 * 
		 * int[] optionsToSelectTest3 = new int[] { 1, 2, 3, 4 };
		 * testMultipleCheckBox(driver, optionsToSelectTest3, noOptions, "Uncheck All");
		 * 
		 * int[] optionsToSelectTest4 = new int[] { 1, 2, 3, 4 };
		 * testMultipleCheckBox(driver, optionsToSelectTest4, unselectOptions,
		 * "Check All");
		 */
		
		testCheckAllButton(driver);

		Thread.sleep(1000);
		driver.quit();

	}

	public static void testMultipleCheckBox(WebDriver driver, int[] selectOptions, int[] unselectOptions,
			String expectedValue) {

		driver.findElement(By.cssSelector("#treemenu > li > ul > li:nth-child(1) > a")).click();
		driver.findElement(By.cssSelector("#treemenu > li > ul > li:nth-child(1) > ul > li:nth-child(2) > a")).click();

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

		System.out.println(actualValue.equals(expectedValue));

	}

	public static void testCheckAllButton(WebDriver driver) {
		driver.findElement(By.cssSelector("#treemenu > li > ul > li:nth-child(1) > a")).click();
		driver.findElement(By.cssSelector("#treemenu > li > ul > li:nth-child(1) > ul > li:nth-child(2) > a")).click();

		driver.findElement(By.cssSelector("#check1")).click();

		boolean allSelected = true;
		for (int i = 0; i < 4; i++) {
			WebElement element = driver
					.findElement(By.cssSelector("#easycont > div > div.col-md-6.text-left > div:nth-child(5)"
							+ " > div.panel-body > div:nth-child(" + (i + 3) + ") > label > input"));
			boolean actualValue = element.isSelected();
			allSelected = actualValue & allSelected;
		}

		System.out.println(allSelected);
		
		driver.findElement(By.cssSelector("#check1")).click();
		boolean allUnselected = false;
		for (int i = 0; i < 4; i++) {
			WebElement element = driver
					.findElement(By.cssSelector("#easycont > div > div.col-md-6.text-left > div:nth-child(5)"
							+ " > div.panel-body > div:nth-child(" + (i + 3) + ") > label > input"));
			boolean actualValue = element.isSelected();
			allUnselected = actualValue | allUnselected;
		}

		System.out.println(!allUnselected);


	}

}
