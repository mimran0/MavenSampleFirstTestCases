/**
 * 
 */
package bing2;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
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
public class TestSet2_bing extends CommonAPI {
	// this method will be executed before every test
	@BeforeMethod
	public void SetUpPreDataMethod() {
		System.out.println("Before Each Test  executed");
		WindowsUtils.killByName("chromedriver.exe");
		WindowsUtils.killByName("MicrosoftEdge.exe");
		WindowsUtils.killByName("firefox.exe");
		WindowsUtils.killByName("iexplore.exe");
		WindowsUtils.killByName("operadriver.exe");
	}

	// Requirement 101: Verify that users are able to search on bing home page.
	@Test(enabled = true)
	public void TC_101_TBD() {
		String vBaseURL = "https://www.bing.com/";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver("FIREFOX", vBaseURL);
		waitTime(5000);
		WebElement obj_SearchBox = driver.findElement(By.xpath("//input[@aria-owns='sw_as']"));
		HighLight_Element(driver, obj_SearchBox);
		obj_SearchBox.sendKeys("md shahajada imran");
		waitTime(2000);
		driver.findElement(By.className("b_searchboxSubmit")).click();
		waitTime(3000);
		CAPTURESCREEN(driver, "md shahajada imran");
	}

	// Requirement 102: Verify in GoogleChrome Browser that users are able to
	// search on bing home page.
	@Test(enabled = true)
	public void TC_SE_CHROME() {
		SearchEngineInBing("CHROME");
	}

	// Requirement 103: Verify in Firefox Browser that users are able to search
	// on bing home page.
	@Test(enabled = true)
	public void TC_SE_Firefox() {
		SearchEngineInBing("FIREFOX");
	}

	// Requirement 104: Verify in Microsoft Edge Browser that users are able to
	// search on bing home page.
	@Test(enabled = true)
	public void TC_SE_MicrosoftEdge() {
		SearchEngineInBing("MICROSOFE EDGE");
	}

	// Requirement 105: Verify in Internet Explorer Browser that users are able
	// to search on bing home page.
	@Test(enabled = true)
	public void TC_SE_ie() {
		SearchEngineInBing("IE");
	}

	// Requirement 106: Verify in Opera Browser that users are able to search on
	// bing home page.
	@Test(enabled = false)
	public void TC_SE_Opera() {
		SearchEngineInBing("OPERA");
	}

	// This is not TestNG test.
	public static void SearchEngineInBing(String wBrowser) {

		String vBaseURL = "https://www.bing.com/";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver(wBrowser, vBaseURL);
		waitTime(5000);

		List<String> MyList = new ArrayList<String>();
		MyList.add("Rose");
		MyList.add("Cat");
		MyList.add("Tia bird");
		MyList.add("Fish");
		MyList.add("flower");
		MyList.add("md shahajada imran");

		for (String v : MyList) {
			driver.navigate().to("https://www.bing.com/");
			waitTime(3000);
			WebElement obj_SearchBox = driver.findElement(By.xpath("//input[@aria-owns='sw_as']"));
			HighLight_Element(driver, obj_SearchBox);
			obj_SearchBox.sendKeys(v);
			waitTime(2000);
			driver.findElement(By.className("b_searchboxSubmit")).click();
			waitTime(3000);
			CAPTURESCREEN(driver, v);
		}
	}
}
