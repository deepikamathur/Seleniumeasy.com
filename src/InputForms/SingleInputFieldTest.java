package InputForms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SingleInputFieldTest {

	public static void main(String args[]) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/prmathur/Desktop/Deepika/selenium/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/test/");

		checkInputField(driver, "Priyank");
		checkInputField(driver, "Deepika");

		driver.close();
	}

	public static void checkInputField(WebDriver driver, String inputString)
			throws InterruptedException {

		driver.findElement(By.cssSelector("#treemenu > li > ul > li:nth-child(1) > a")).click();

		driver.findElement(By.cssSelector("#treemenu > li > ul > li:nth-child(1) > ul > li:nth-child(1) > a")).click();

		driver.findElement(By.cssSelector("#user-message")).sendKeys(inputString);

		driver.findElement(By.cssSelector("#get-input > button")).click();

		WebElement valueElement = driver.findElement(By.cssSelector("#display"));
		String value = valueElement.getText();

		System.out.println(value.equals(inputString));
	}

}
