/**
 * 
 */
package FromYouFlowers;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.os.WindowsUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import afterLoginIn.CommonAPI;

/**
 * @author md shahajada imran
 *
 */
public class FYF extends afterLoginIn.CommonAPI {
	@BeforeMethod
	public void SetUpPreDataMethod() {
		System.out.println("Before Each Test  executed");
		WindowsUtils.killByName("chromedriver.exe");
		WindowsUtils.killByName("iexplore.exe");
		WindowsUtils.killByName("geckodriver.exe");
		WindowsUtils.killByName("MicrosoftWebDriver.exe");
		WindowsUtils.killByName("MicrosoftEdge.exe");
	}

	// Requirement 101: Users are able to mouse over on random elements
	@Test(priority = 1, enabled = true)
	public void TC_101_MouseOver() {
		String vBaseURL = "https://www.fromyouflowers.com/";
		String wBrowser = "CHROME";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver(wBrowser, vBaseURL);
		waitTime(4000);
		driver.manage().window().maximize();
		ArrayList<String> myList = new ArrayList<String>();
		myList.add(0, "Birthday");
		myList.add(1, "Occasions");
		myList.add(2, "Get Well");
		myList.add(3, "SALE");
		myList.add(4, "Flowers");
		myList.add(5, "Sympathy");
		myList.add(6, "Plants");
		myList.add(7, "Gift Baskets & Food");

		for (String v : myList) {
			Actions action = new Actions(driver);
			WebElement we = driver.findElement(By.partialLinkText(v));
			action.moveToElement(we).build().perform();
			waitTime(4000);
		}

	}

	// Requirement 102: highlight all elements with tagname input
	@Test(enabled = true)
	public void TC_02_HighlightAllInputs() {
		String vBaseURL = "https://www.fromyouflowers.com/";
		String wBrowser = "CHROME";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver(wBrowser, vBaseURL);
		waitTime(4000);
		driver.manage().window().maximize();
		List<WebElement> arr_Inputboxs = driver.findElements(By.tagName("input"));
		HighLight_Elements(driver, arr_Inputboxs);
		scrolldown(driver, 1000);
	}

	// Requirement 103: Users are able to search flowers by color
	@Test(enabled = true)
	public void TC_03_SearchByColor() {
		String vBaseURL = "https://www.fromyouflowers.com/";
		String wBrowser = "CHROME";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver(wBrowser, vBaseURL);
		waitTime(4000);
		driver.manage().window().maximize();

		ArrayList<String> myFlowerColorList = new ArrayList<String>();
		myFlowerColorList.add("Red");
		myFlowerColorList.add("Yellow");
		myFlowerColorList.add("Green");
		myFlowerColorList.add("Pink");
		myFlowerColorList.add("Black");
		myFlowerColorList.add("Blue");

		for (String v : myFlowerColorList) {
			driver.get("https://www.fromyouflowers.com/");
			driver.findElement(By.id("sli_search_1")).clear();
			driver.findElement(By.id("sli_search_1")).sendKeys(v);
			waitTime(3000);
			driver.findElement(By.xpath("//*[@id=\"search\"]/form/input[2]")).click();
			waitTime(2000);
			ScrollDownAndUp(driver, 200);
		}
	}

	// Requirement 104: Users are able to print property value in the console.
	@Test(enabled = true)
	public void TC_04_PrintPropertyValueInTheConsole() {
		String vBaseURL = "https://www.fromyouflowers.com/";
		String wBrowser = "CHROME";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver(wBrowser, vBaseURL);
		waitTime(4000);
		driver.manage().window().maximize();
		List<WebElement> arr_Inputboxs = driver.findElements(By.tagName("input"));
		for (WebElement v : arr_Inputboxs) {
			System.out.println(v.getText());
			// highlight those elements
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].style.border='3px solid red'", v);
			String vPropertyValue = v.getAttribute("name");
			System.out.println(vPropertyValue);

		}
	}
}
