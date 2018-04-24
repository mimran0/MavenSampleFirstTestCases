/**
 * 
 */
package bing;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.os.WindowsUtils;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import afterLoginIn.CommonAPI;

/**
 * @author md shahajada imran
 *
 */
public class TestSetBing extends afterLoginIn.CommonAPI {
	// this method will be executed before every test
	@BeforeMethod
	public void SetUpPreDataMethod() {
		System.out.println("Before Each Test  executed");
		WindowsUtils.killByName("chromedriver.exe");
		WindowsUtils.killByName("MicrosoftEdge.exe");
		WindowsUtils.killByName("firefox.exe");
		WindowsUtils.killByName("iexplore.exe");
	}

	// Requirement 101: Users are able to search on bing homepage
	@Test(enabled = true)
	public void TC_101_searchOnBingHomePage() {
		String vBaseURL = "https://www.bing.com/";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver("FIREFOX", vBaseURL);
		waitTime(25000);

		// ArrayList Data Structure
		ArrayList<String> dt_MyList = new ArrayList<String>();
		dt_MyList.add(0, "Red Rose");
		dt_MyList.add(1, "bird");
		dt_MyList.add(2, "rain");
		dt_MyList.add(3, "water");
		dt_MyList.add(4, "md shahajada imran");

		// for loop
		for (int i = 0; i < dt_MyList.size(); i++) {
			driver.get("https://www.bing.com/");
			driver.findElement(By.tagName("input")).sendKeys(dt_MyList.get(i));
			waitTime(3000);
			driver.findElement(By.className("b_searchboxSubmit")).click();
			waitTime(5000);
			WebElement obj_SearhResult = driver.findElement(By.className("sb_count"));
			HighLight_Element(driver, obj_SearhResult);
			waitTime(2000);
			String vSearchResult = obj_SearhResult.getText();
			System.out.println(vSearchResult + " found for " + dt_MyList.get(i));
		}
	}

}