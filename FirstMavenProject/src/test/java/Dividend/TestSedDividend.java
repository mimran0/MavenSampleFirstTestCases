/**
 * 
 */
package Dividend;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.os.WindowsUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import afterLoginIn.CommonAPI;

/**
 * @author md shahajada imran
 *
 */
public class TestSedDividend extends afterLoginIn.CommonAPI {

	@BeforeMethod
	public void SetUpPreDataMethod() {
		System.out.println("Before Each Test  executed");
		WindowsUtils.killByName("chromedriver.exe");
		WindowsUtils.killByName("iexplore.exe");
		WindowsUtils.killByName("geckodriver.exe");
		WindowsUtils.killByName("MicrosoftWebDriver.exe");
		WindowsUtils.killByName("MicrosoftEdge.exe");
	}

	// Requirement: Users are able to read and display webtable data.
	@Test(enabled = false)
	public void TC_101_TBD() {
		String vBaseURL = "http://www.dividend.com/dividend-stocks/preferred-dividend-stocks.php#stocks&sort_name=dividend_yield&sort_order=desc&page=1";
		String wBrowser = "CHROME";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver(wBrowser, vBaseURL);
		waitTime(4000);
		driver.manage().window().maximize();

		// creating an array of string
		ArrayList<String> myListOne = new ArrayList<String>();
		// storing cell data into the array
		myListOne.add(GetCellData(driver, 1, 1));
		myListOne.add(GetCellData(driver, 1, 2));
		myListOne.add(GetCellData(driver, 1, 3));
		myListOne.add(GetCellData(driver, 1, 4));
		myListOne.add(GetCellData(driver, 1, 5));
		myListOne.add(GetCellData(driver, 1, 6));
		myListOne.add(GetCellData(driver, 1, 7));

		// Math to check if the stock is eligible to buy or not.
		String sHighPrice = GetCellData(driver, 1, 6);
		double dHighPrice = Double.parseDouble(sHighPrice);
		String sLowPrice = GetCellData(driver, 1, 7);
		double dLowPrice = Double.parseDouble(sLowPrice);
		double Gap_between_High_Low = dHighPrice - dLowPrice;
		System.out.println("" + Gap_between_High_Low);

		String sCurrentMarketPrice = GetCellData(driver, 1, 4);
		// removing $ sign from the string (Market Price)
		sCurrentMarketPrice = sCurrentMarketPrice.substring(1);
		double dCurrentMarketPrice = Double.parseDouble(sCurrentMarketPrice);
		System.out.println("" + dCurrentMarketPrice);
		// Comparison
		if (dCurrentMarketPrice > (dLowPrice + Gap_between_High_Low / 2)) {
			System.out.println("Do Not Buy");
		} else {
			System.out.println("Eligible to Buy as Price is expected to rise in future");
		}

		// displaying all data of the array
		for (String v : myListOne) {
			System.out.println(v);
		}

	}

	// Requirement 102: Users are able to check if a stock is good to buy or
	// not.
	@Test(enabled = false)
	public void TC_102() {
		String vBaseURL = "http://www.dividend.com/dividend-stocks/preferred-dividend-stocks.php#stocks&sort_name=dividend_yield&sort_order=desc&page=1";
		String wBrowser = "CHROME";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver(wBrowser, vBaseURL);
		waitTime(4000);
		driver.manage().window().maximize();

		// Checking if "FTRPR" stock is advisable to buy
		String vResult_FTRPR = GetBuyOrNot(driver, 1);

		// Checking if "GST-B" stock is advisable to buy
		String vResult_GST_B = GetBuyOrNot(driver, 2);

		// Checking if "GST-A" stock is advisable to buy
		String vResult_GST_A = GetBuyOrNot(driver, 3);

	}

	// Requirement 103: Users are able to check if the stocks are good to buy or
	// not on current open page.
	@Test(enabled = false)
	public void TC_103_CheckStockOnCurrentPage() {
		String vBaseURL = "http://www.dividend.com/dividend-stocks/preferred-dividend-stocks.php#stocks&sort_name=dividend_yield&sort_order=desc&page=1";
		String wBrowser = "CHROME";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver(wBrowser, vBaseURL);
		waitTime(4000);
		driver.manage().window().maximize();
		waitTime(4000);
		// Checking all the stocks buy eligibility in the current page
		for (int i = 1; i <= 25; i++) {
			GetBuyOrNot(driver, i);
		}

	}

	// Requirement 104: Users are able to check if the stocks are good to buy or
	// not on all available pages.

	@Test(enabled = false)
	public void TC_104_CheckStockOnAllPage() {
		String vBaseURL = "http://www.dividend.com/dividend-stocks/preferred-dividend-stocks.php#stocks&sort_name=dividend_yield&sort_order=desc&page=1";
		String wBrowser = "CHROME";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver(wBrowser, vBaseURL);
		waitTime(4000);
		driver.manage().window().maximize();
		waitTime(4000);
		// WebElement obj_Next = driver.findElement(By.linkText("Next ›"));
		// HighLight_Element(driver, obj_Next);

		// Checking all the stocks buy eligibility in all the available pages.
		int j = 1;
		do {
			System.out.println("*******************************************************Page Number: " + j);
			List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"stocks\"]/tbody/tr"));
			int RowCount = rows.size();
			System.out.println("There are " + RowCount + " rows in the page Number " + j);
			for (int i = 1; i <= RowCount; i++) {
				GetBuyOrNot(driver, i);
			}
			WebElement obj_Next = driver.findElement(By.linkText("Next ›"));
			if (j < 12) {
				obj_Next.click();
			} else {
				break;
			}
			waitTime(10000);
			j++;
		} while (j < 13);

	}

	// Requirement 105: Clicking upon the the links Social Sites display in new
	// Browser Tabs.
	@Test(enabled = true)
	public void TC_105_Social_Sites_On_New_Tabs() {
		String vBaseURL = "http://www.dividend.com/";
		String wBrowser = "CHROME";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver(wBrowser, vBaseURL);
		waitTime(4000);
		driver.manage().window().maximize();
		waitTime(4000);

		ArrayList<String> tabs2; // Needed to handle 2 browser tabs.

		/// *********************Facebook
		MouseOverOnSocialSite(driver); //calling reusable method.
		WebElement obj_FaceBookLink = driver.findElement(By.cssSelector(
				"#follow-module-social > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > a:nth-child(1) > i:nth-child(1)"));
		obj_FaceBookLink.click();
		// dealing 2 tabs
		tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		waitTime(5000);
		System.out.println(driver.getTitle());
		// Checkpoint
		Assert.assertEquals("Dividend.com - Home | Facebook", driver.getTitle());
		driver.close(); // closing the 2nd Tab that contains Facebook
		driver.switchTo().window(tabs2.get(0));

		/// *********************Twitter
		MouseOverOnSocialSite(driver);
		WebElement obj_Twitter = driver.findElement(By.cssSelector(
				"#follow-module-social > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > a:nth-child(1) > i:nth-child(1)"));
		obj_Twitter.click();
		waitTime(3000);
		tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1)); // selecting 2nd tab.
		waitTime(5000);
		System.out.println(driver.getTitle());
		// Checkpoint
		Assert.assertEquals("Dividend.com (@dividenddotcom) | Twitter", driver.getTitle());
		driver.close(); // closing the 2nd Tab that contains Twitter
		driver.switchTo().window(tabs2.get(0));

		/// *********************GooglePlus
		MouseOverOnSocialSite(driver);
		WebElement obj_GooglePlus = driver.findElement(By.cssSelector(
				"#follow-module-social > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > a:nth-child(1) > i:nth-child(1)"));
		obj_GooglePlus.click();
		waitTime(3000);
		tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1)); // selecting 2nd tab.
		waitTime(5000);
		System.out.println(driver.getTitle());
		// Checkpoint
		Assert.assertEquals("Dividend.com - Google+", driver.getTitle());
		driver.close(); // closing the 2nd Tab that contains Twitter
		driver.switchTo().window(tabs2.get(0));

		/// *********************LinkedIn
		MouseOverOnSocialSite(driver);
		WebElement obj_LinkedIn = driver.findElement(By.cssSelector(
				"#follow-module-social > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(5) > a:nth-child(1) > i:nth-child(1)"));
		obj_LinkedIn.click();
		waitTime(3000);
		tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1)); // selecting 2nd tab.
		waitTime(5000);
		System.out.println(driver.getTitle());
		// Checkpoint
		Assert.assertEquals("Dividend.com | LinkedIn", driver.getTitle());
		driver.close(); // closing the 2nd Tab that contains Twitter
		driver.switchTo().window(tabs2.get(0));

		driver.quit(); // Closing all open browsers.

	}

	// This method will mouse over on a element called "Follow Dividend.com" in
	// the Dividend Homepage.
	public static void MouseOverOnSocialSite(WebDriver driver) {
		List<WebElement> objects = driver.findElements(By.className("social-module-btns"));
		HighLight_Elements(driver, objects);
		for (WebElement v : objects) {
			String vText = v.getText();
			if (vText.equals("Follow Dividend.com")) {
				// mouseover
				Actions action = new Actions(driver);
				action.moveToElement(v).build().perform();
				waitTime(2000);
			}
		}
	}

	// red cell data based on row count and column count in WebTable. If there
	// is no data then return 0.
	public static String GetCellData(WebDriver driver, int sRow, int sColumn) {
		String result;
		// Here we are locating the xpath by passing variables in the xpath
		String sCellValue = null;
		try {
			sCellValue = driver.findElement(By.xpath("//*[@id=\"stocks\"]/tbody/tr[" + sRow + "]/td[" + sColumn + "]"))
					.getText();
		} catch (Exception e) {
			System.out.println("The field is empty");
		}
		if (sCellValue.isEmpty() == true) {
			sCellValue = "$0.00";
		}
		return result = sCellValue;
	}

	public static String GetBuyOrNot(WebDriver driver, int RowNumber) {
		String result;
		// creating an array of string
		ArrayList<String> myListOne = new ArrayList<String>();
		// storing cell data into the array
		myListOne.add(GetCellData(driver, RowNumber, 1));
		myListOne.add(GetCellData(driver, RowNumber, 2));
		myListOne.add(GetCellData(driver, RowNumber, 3));
		myListOne.add(GetCellData(driver, RowNumber, 4));
		myListOne.add(GetCellData(driver, RowNumber, 5));
		myListOne.add(GetCellData(driver, RowNumber, 6));
		myListOne.add(GetCellData(driver, RowNumber, 7));
		// Math to check if the stock is eligible to buy or not.
		String sHighPrice = GetCellData(driver, RowNumber, 6);
		double dHighPrice = Double.parseDouble(sHighPrice);
		String sLowPrice = GetCellData(driver, RowNumber, 7);
		double dLowPrice = Double.parseDouble(sLowPrice);
		double Gap_between_High_Low = dHighPrice - dLowPrice;
		System.out.println("" + Gap_between_High_Low);

		String sCurrentMarketPrice = GetCellData(driver, RowNumber, 4);
		// removing $ sign from the string (Market Price)
		sCurrentMarketPrice = sCurrentMarketPrice.substring(1);
		// remove , from from the string (Market Price)
		sCurrentMarketPrice = sCurrentMarketPrice.replace(",", "");
		double dCurrentMarketPrice = Double.parseDouble(sCurrentMarketPrice);
		System.out.println("" + dCurrentMarketPrice);
		// Comparison
		if (dCurrentMarketPrice > (dLowPrice + Gap_between_High_Low / 2)) {
			System.out.println("Do Not Buy '" + GetCellData(driver, RowNumber, 1) + "'");
			return result = "do not buy";
		} else {
			System.out.println("Eligible to Buy '" + GetCellData(driver, RowNumber, 1)
					+ "' as Price is expected to rise in future");
			return result = "BUY";
		}

	}

}
