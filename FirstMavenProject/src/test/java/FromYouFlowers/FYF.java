/**
 * 
 */
package FromYouFlowers;

import java.util.ArrayList;

import org.openqa.selenium.By;
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

	// Requirement 101: TBD
	@Test(enabled = true)
	public void TC_101_TBD() {
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
}
