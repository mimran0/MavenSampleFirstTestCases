/**
 * 
 */
package experiment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.os.WindowsUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import afterLoginIn.CommonAPI;

/**
 * @author md shahajada imran
 *
 */
public class ImranExperiment extends afterLoginIn.CommonAPI {
	// this method will be executed before every test
	@BeforeMethod
	public void SetUpPreDataMethod() {
		System.out.println("Before Each Test  executed");
		WindowsUtils.killByName("chromedriver.exe");
		WindowsUtils.killByName("MicrosoftEdge.exe");
		WindowsUtils.killByName("firefox.exe");
		WindowsUtils.killByName("iexplore.exe");
	}

	@Test(enabled = true)
	public void test() {
		String vBaseURL = "https://login.aol.com/";
		String wBrowser = "CHROME";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver(wBrowser, vBaseURL);
		waitTime(10000);

		// WebElement object = driver.findElement(By.id("login-username"));
		// HighLight_Element(driver, object);
		List<WebElement> links = driver.findElements(By.tagName("a"));
		HighLight_Elements(driver, links);

	}

	// HighLight_Element ((Developed by md shahajada Imran on 04/02/2018)(Anyone
	// can
	// Re-use now or 40 years later for any client)).
	// This method will Highlight only one element.
	// Output: N/A
	// Input arguments: WebDriver driver, WebElement object

	public static void HighLight_Element(WebDriver driver, WebElement object) {
		// highlight only one element.
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].style.border='3px solid red'", object);
	}

	// HighLight_Elements ((Developed by md shahajada Imran on
	// 04/02/2018)(Anyone can
	// Re-use now or 40 years later for any client)).
	// This method will Highlight a list of elements.
	// Output: N/A
	// Input arguments: WebDriver driver, List<WebElement> objects
	public static void HighLight_Elements(WebDriver driver, List<WebElement> objects) {
		System.out.println(
				"There are total " + objects.size() + " elements in the list and those elements are written below.");
		for (WebElement v : objects) {
			System.out.println("if element has a text then the element is: " + v.getText());
			// highlight those elements
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].style.border='3px solid red'", v);

		}
	}

}
