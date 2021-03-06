/**
 * 
 */
package cat;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.os.WindowsUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sun.glass.events.KeyEvent;

import afterLoginIn.CommonAPI;

/**
 * @author md shahajada imran
 *
 */
public class TestSet_Cat extends CommonAPI {

	@BeforeMethod
	public void SetUpPreDataMethod() {
		System.out.println("Before Each Test  executed");
		WindowsUtils.killByName("chromedriver.exe");
		WindowsUtils.killByName("MicrosoftEdge.exe");
		WindowsUtils.killByName("firefox.exe");
		WindowsUtils.killByName("iexplore.exe");
	}

	// Requirement 801: Green
	@Test(enabled = true, priority = 3)
	public void TC_801_Green() throws InterruptedException {
		// Data driven Test where testdata was read from external Excel file.
		int vRow = 3;
		int vColumn = 1;
		String vExcelPath = "C:\\Users\\imran\\workspace6\\FirstMavenProject\\src\\test\\java\\cat\\HyBridFramework.xlsx";
		String vColor = ReadCellData(vRow, vColumn, vExcelPath);
		Search(vColor);
	}

	// Requirement 802: Red
	@Test(priority = 1, enabled = true)
	public void TC_802_Red() throws InterruptedException {
		// Data driven Test where testdata was read from external Excel file.
		int vRow = 4;
		int vColumn = 1;
		String vExcelPath = "C:\\Users\\imran\\workspace6\\FirstMavenProject\\src\\test\\java\\cat\\HyBridFramework.xlsx";
		String vColor = ReadCellData(vRow, vColumn, vExcelPath);
		Search(vColor);
	}

	// Requirement 803: Pink
	@Test(priority = 0, enabled = true)
	public void TC_803_Pink() throws InterruptedException {
		Search("Pink");
	}

	// Requirement 804: Yellow
	@Test(priority = 2, enabled = true)
	public void TC_804_Yellow() throws InterruptedException {
		Search("Yellow");
	}

	// Requirement 805: Upon clicking on Links social site home pages display in
	// new tabs.
	@Test(priority = 4, enabled = true)
	public void TC_805_TBD() {
		String vBaseURL = "http://www.vetstreet.com/cats/";
		String vBrowser = "FIREFOX";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver(vBrowser, vBaseURL);
		waitTime(5000);

		ArrayList<String> mySocialSites = new ArrayList<String>();
		mySocialSites.add("Facebook");
		mySocialSites.add("Twitter");
		mySocialSites.add("Google+");
		mySocialSites.add("Pinterest");
		mySocialSites.add("Instagram");
		// mySocialSites.add("YouTube");

		// One way
		for (String v : mySocialSites) {
			WebElement oSocilaSiteLink = driver.findElement(By.linkText(v));
			// making the Link click able (below 2 lines)
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].scrollIntoView()", oSocilaSiteLink);
			waitTime(3000);
			HighLight_Element(driver, oSocilaSiteLink);
			oSocilaSiteLink.click();
			waitTime(5000);
			// dealing with 2 tabs
			ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs2.get(1)); // getting new tab.
			waitTime(5000);
			System.out.println("The Page Title of " + v + " is :" + driver.getTitle());
			driver.close(); // closing new tab only.
			driver.switchTo().window(tabs2.get(0)); // Getting base browser.
			waitTime(2000);
			// System.out.println(driver.getTitle());
		}

		// way tow
		driver.navigate().refresh(); // refresh the page.
		for (int i = 0; i < mySocialSites.size(); i++) {
			SocilaNetworkingSites(driver, mySocialSites.get(i));
		}

		// way Three
		driver.navigate().refresh(); // refresh the page.
		SocilaNetworkingSites(driver, mySocialSites.get(0));
		SocilaNetworkingSites(driver, mySocialSites.get(1));
		SocilaNetworkingSites(driver, mySocialSites.get(2));
		SocilaNetworkingSites(driver, mySocialSites.get(3));
		SocilaNetworkingSites(driver, mySocialSites.get(4));
		// SocilaNetworkingSites(driver, mySocialSites.get(5));

		// way four
		int k = 0;
		while (k < mySocialSites.size()) {
			SocilaNetworkingSites(driver, mySocialSites.get(k));
			k++;
		}
		driver.quit();
	}

	// Requirement 806: Highlight all Elements that's linkText is "Twitter".
	// click the 2nd one by scanning the Page(DOM) from Top to bottom.
	// click the 1st one by scanning the Page(DOM) from Top to bottom.
	@Test(enabled = true, priority = 5)
	public void TC_806_TBD() {
		String vBaseURL = "http://www.vetstreet.com/cats/";
		String vBrowser = "FIREFOX";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver(vBrowser, vBaseURL);
		waitTime(5000);
		List<WebElement> oTweeter = driver.findElements(By.linkText("Twitter"));
		HighLight_Elements(driver, oTweeter);
		oTweeter.get(1).click(); // clicking the 2nd element from the list.
		oTweeter.get(0).click(); // clicking the 1st element from the list.

		// dealing with 3 tabs
		ArrayList<String> tabs3 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs3.get(1)); // getting 2nd tab.
		System.out.println(driver.getTitle());
		driver.switchTo().window(tabs3.get(2)); // getting 3rd tab
		System.out.println(driver.getTitle());
		driver.switchTo().window(tabs3.get(0)); // getting 1st tab
		System.out.println(driver.getTitle());
		driver.quit();

	}

	// Not TestNG test.
	public static void SocilaNetworkingSites(WebDriver driver, String v) {
		WebElement oSocilaSiteLink = driver.findElement(By.linkText(v));
		// making the Link click able (below 2 lines)
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView()", oSocilaSiteLink);
		waitTime(3000);
		HighLight_Element(driver, oSocilaSiteLink);
		oSocilaSiteLink.click();
		waitTime(5000);
		// dealing with 2 tabs
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1)); // getting new tab.
		waitTime(5000);
		System.out.println("The Page Title of " + v + " is :" + driver.getTitle());
		driver.close(); // closing new tab only.
		driver.switchTo().window(tabs2.get(0)); // Getting base browser.
		waitTime(2000);
		// System.out.println(driver.getTitle());
	}

	// Not a TestNG test.
	public static void Search(String vSearchString) throws InterruptedException {
		String vBaseURL = "http://www.vetstreet.com/cats/";
		String vBrowser = "FIREFOX";
		// String vSearchString = "Green";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver(vBrowser, vBaseURL);
		waitTime(5000);
		driver.manage().window().maximize();
		List<WebElement> oEditBox = driver.findElements(By.cssSelector("#site-search > input:nth-child(1)"));
		HighLight_Elements(driver, oEditBox);
		for (WebElement v : oEditBox) {
			v.sendKeys(vSearchString);
			break;
		}
		Robot r = null;
		try {
			r = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		String vResult = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/p[1]/span[1]")).getText();
		HighLight_Element(driver, driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/p[1]/span[1]")));
		System.out.println("There are " + vResult + " results for " + vSearchString);
	}
}
