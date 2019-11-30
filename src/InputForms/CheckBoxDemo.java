package InputForms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class CheckBoxDemo {

	public static void main(String args[]) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/prmathur/Desktop/Deepika/selenium/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/test/");
		
		clickCheckBox(driver, 1, "Success - Check box is checked");
		clickCheckBox(driver, 2, "");
		
		
		Thread.sleep(2000);
		driver.quit();
	}

	public static void clickCheckBox(WebDriver driver, int numClicks, String expectedOutput) throws InterruptedException {
		driver.findElement(By.cssSelector("#treemenu > li > ul > li:nth-child(1) > a")).click();
		driver.findElement(By.cssSelector("#treemenu > li > ul > li:nth-child(1) > ul > li:nth-child(2) > a")).click();
		
		for(int i = 0; i < numClicks; i++) {
			driver.findElement(By.id("isAgeSelected")).click();
			Thread.sleep(100);
		}
		

		WebElement element = driver.findElement(By.id("txtAge"));
		String actualOutput = element.getText();

		System.out.println(actualOutput.equals(expectedOutput));
	
	}

}
