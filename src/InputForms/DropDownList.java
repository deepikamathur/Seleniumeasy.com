package InputForms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DropDownList {

	WebDriver driver;

	@BeforeTest
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "/Users/prmathur/Desktop/Deepika/selenium/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/test/");
	}

	@Test

	public void clickOnDropDown1() {
		driver.findElement(By.cssSelector("#treemenu > li > ul > li:nth-child(1) > a")).click();
		driver.findElement(By.cssSelector("#treemenu > li > ul > li:nth-child(1) > ul > li:nth-child(4) > a")).click();

		Select select = new Select(driver.findElement(By.id("select-demo")));
		select.selectByValue("Monday");

		WebElement element = driver.findElement(By.cssSelector(
				"#easycont > div > div.col-md-6.text-left > div:nth-child(4) > div.panel-body > p.selected-value"));

		String actualOutput = element.getText();
		System.out.println(actualOutput);
		String expectedOutput = "Day selected :- Monday";

		if (actualOutput.equals(expectedOutput)) {
			System.out.println("True");
		} else
			System.out.println("False");
	}

	@Test

	public void clickOnDropDown2() {
		driver.findElement(By.cssSelector("#treemenu > li > ul > li:nth-child(1) > a")).click();
		driver.findElement(By.cssSelector("#treemenu > li > ul > li:nth-child(1) > ul > li:nth-child(4) > a")).click();

		Select select = new Select(driver.findElement(By.id("select-demo")));
		select.selectByValue("Thursday");

		WebElement element = driver.findElement(By.cssSelector(
				"#easycont > div > div.col-md-6.text-left > div:nth-child(4) > div.panel-body > p.selected-value"));

		String actualOutput = element.getText();
		System.out.println(actualOutput);
		String expectedOutput = "Day selected :- Thursday";

		if (actualOutput.equals(expectedOutput)) {
			System.out.println("True");
		} else
			System.out.println("False");
	}

	@AfterTest

	public void closeBrowser() {
		driver.close();
	}

}
