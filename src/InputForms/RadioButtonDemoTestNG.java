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

public class RadioButtonDemoTestNG {

	WebDriver driver;

	@BeforeTest
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "/Users/prmathur/Desktop/Deepika/selenium/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/test/");
	}

	@Test
	public void clickRadioButtonMale() {
		driver.findElement(By.cssSelector(
				"#easycont > div > div.col-md-6.text-left > div:nth-child(4) > div.panel-body > label:nth-child(2) > input[type=radio]"))
				.click();

		driver.findElement(By.id("buttoncheck")).click();

		WebElement element = driver.findElement(By.cssSelector(
				"#easycont > div > div.col-md-6.text-left > div:nth-child(4) > div.panel-body > p.radiobutton"));

		String actualOutput = element.getText();
		String expectedOutput = "Radio button 'Male' is checked";
		Assert.assertEquals(expectedOutput, actualOutput);
	}

	@Test
	public void clickRadioButtonFemale() {
		driver.findElement(By.cssSelector(
				"#easycont > div > div.col-md-6.text-left > div:nth-child(4) > div.panel-body > label:nth-child(3) > input[type=radio]"))
				.click();

		driver.findElement(By.id("buttoncheck")).click();

		WebElement element = driver.findElement(By.cssSelector(
				"#easycont > div > div.col-md-6.text-left > div:nth-child(4) > div.panel-body > p.radiobutton"));

		String actualOutput = element.getText();
		String expectedOutput = "Radio button 'Female' is checked";
		Assert.assertEquals(expectedOutput, actualOutput);
	}

	@Test
	public void clickRadioButtonEmpty() {

		driver.findElement(By.id("buttoncheck")).click();

		WebElement element = driver.findElement(By.cssSelector(
				"#easycont > div > div.col-md-6.text-left > div:nth-child(4) > div.panel-body > p.radiobutton"));

		String actualOutput = element.getText();
		String expectedOutput = "Radio button is Not checked";
		Assert.assertEquals(expectedOutput, actualOutput);
	}

	@Test
	public void clickRadioButtonMaleFemale() {
		clickRadioButtonFemale();
		clickRadioButtonMale();
	}

	@BeforeMethod
	public void navigate() {
		driver.findElement(By.cssSelector("#treemenu > li > ul > li:nth-child(1)")).click();
		driver.findElement(By.cssSelector("#treemenu > li > ul > li:nth-child(1) > ul > li:nth-child(3) > a")).click();
	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}
