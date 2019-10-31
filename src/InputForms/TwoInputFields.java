package InputForms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TwoInputFields {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "/Users/prmathur/Desktop/Deepika/selenium/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/test/");

		addTwoInputs("10", "5", "15", driver);
		addTwoInputs("a", "10", "NaN", driver);
		addTwoInputs("10", "b", "NaN", driver);
		addTwoInputs("*", "b", "NaN", driver);
		addTwoInputs("-10", "6", "-4", driver);
		addTwoInputs("-10", "-6", "-16", driver);
		addTwoInputs("", "10", "NaN", driver);
		addTwoInputs("", "10s", "NaN", driver);
		addTwoInputs("1000000000000", "1000000000000", "2000000000000", driver);

		driver.quit();

	}

	public static void addTwoInputs(String a, String b, String expectedOutput, WebDriver driver) {

		driver.findElement(By.cssSelector("#treemenu > li > ul > li:nth-child(1) > a")).click();
		driver.findElement(By.xpath("//*[@id=\'treemenu\']/li/ul/li[1]/ul/li[1]")).click();

		driver.findElement(By.id("sum1")).sendKeys(a);
		driver.findElement(By.id("sum2")).sendKeys(b);
		driver.findElement(By.cssSelector("#gettotal > button")).click();
		WebElement outputElement = driver.findElement(By.id("displayvalue"));
		String actualOutput = outputElement.getText();

		System.out.println(actualOutput.equals(expectedOutput));

	}

}
