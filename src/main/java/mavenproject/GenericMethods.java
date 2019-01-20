package mavenproject;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import junit.framework.Assert;

public class GenericMethods {
	public static WebDriver driver;
	public static Properties OR;

	public static void openBrowser() throws Exception {
		try {
			OR = new Properties();
			FileInputStream objFile = new FileInputStream(System.getProperty("user.dir") + "\\OR.properties");
			OR.load(objFile);

			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			System.out.println("INFO: Browser opened");
		} catch (Exception e) {
			e.printStackTrace();
			driver.close();
		}
	}

	public static void navigate(String url) throws Exception {
		try {
			driver.get(url);
			System.out.println("INFO: URL opened");
		} catch (Exception e) {
			e.printStackTrace();
			driver.close();
		}
	}

	public static void sendKeys(String object, String text) throws Exception {
		try {
			driver.findElement(By.xpath(object)).clear();
			driver.findElement(By.xpath(object)).sendKeys(text);
			System.out.println("INFO: Object is written");
		} catch (Exception e) {
			e.printStackTrace();
			driver.close();
		}
	}

	public static void click(String object) throws Exception {
		try {
			driver.findElement(By.xpath(object)).click();
			System.out.println("INFO: Object clicked");
		} catch (Exception e) {
			e.printStackTrace();
			driver.close();
		}
	}

	public static void enter(String object) throws Exception {
		try {
			driver.findElement(By.xpath(object)).sendKeys(Keys.ENTER);
			System.out.println("INFO: Enter is pressed");
		} catch (Exception e) {
			e.printStackTrace();
			driver.close();
		}
	}

	public static void quitDriver() {
		driver.quit();
	}

	public static void waitForObject(String object) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(object)));
	}

	public static void validateElementVisible(String object) throws Exception {
		WebElement element = driver.findElement(By.xpath(object));
		Assert.assertEquals("Please enter a valid email.", element.getText());
		System.out.println("INFO: '" + element.getText() + "' is found");
	}

	public void validateResultList(String objectTextResult, String objectListResult) {
		String textSearch = driver.findElement(By.xpath(objectTextResult)).getText();
		String textResult = textSearch.substring(textSearch.indexOf('"') + 1, textSearch.length() - 1);
		List<WebElement> links = driver.findElements(By.xpath(objectListResult));

		for (int i = 0; i < links.size(); i++) {
			if (links.get(i).getText().toUpperCase().contains(textResult.toUpperCase())) {
				System.out.println("INFO: Text contains '" + textResult + "'");
			} else {
				System.out.println("ERROR: Text not contains '" + textResult + "'");
			}
		}
	}
}
