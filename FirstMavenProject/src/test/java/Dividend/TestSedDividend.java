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

import com.gargoylesoftware.htmlunit.javascript.host.Iterator;

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
	@Test(enabled = true)
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
	@Test(enabled = true)
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
	@Test(enabled = true)
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

	@Test(enabled = true)
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
			WebElement obj_Next = driver.findElement(By.linkText("Next �"));
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
		MouseOverOnSocialSite(driver); // calling reusable method.
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
		Assert.assertEquals("LinkedIn: Log In or Sign Up", driver.getTitle());
		driver.close(); // closing the 2nd Tab that contains Twitter
		driver.switchTo().window(tabs2.get(0));

		driver.quit(); // Closing all open browsers.

	}

	// Requirement 106: Highlight a link(Given link).
	@Test(enabled = true)
	public void TC_106_TBD() {
		String vBaseURL = "http://www.dividend.com/";
		String wBrowser = "IE";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver(wBrowser, vBaseURL);
		waitTime(4000);
		driver.manage().window().maximize();
		waitTime(4000);

		// HighLight
		WebElement objDividendTools = driver
				.findElement(By.cssSelector(".navbar-nav > li:nth-child(8) > a:nth-child(1)"));
		HighLight_Element(driver, objDividendTools);
		waitTime(3000);
		// MouseOver
		Actions action = new Actions(driver);
		action.moveToElement(objDividendTools).build().perform();
		waitTime(4000);

	}

	// Requirement 107: Users are refused to login with wrong credentials.
	@Test(enabled = true)
	public void TC_107_Login_NegitiveTest() {
		String vBaseURL = "http://www.dividend.com/";
		String wBrowser = "CHROME";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver(wBrowser, vBaseURL);
		waitTime(4000);
		driver.manage().window().maximize();
		waitTime(4000);

		driver.findElement(By.linkText("Login")).click();
		waitTime(3000);
		// Login Attempt with wrong credentials.
		driver.findElement(By.name("amember_login")).sendKeys("wrongId");
		driver.findElement(By.name("amember_pass")).sendKeys("wrongpassword");
		driver.findElement(By.id("login-button")).click();
		waitTime(1000);
		String LoginFailAlert = driver.findElement(By.xpath("/html/body/div[7]/div[4]/div[1]/div[3]/div[1]/div[1]"))
				.getText();
		// System.out.println(LoginFailAlert);
		// Checkpoint
		Assert.assertEquals("Incorrect login credentials. Please try again.", LoginFailAlert);

	}

	// Requirement 108: Login Button is enabled or disabled based on credentials
	// presence in login fields.
	@Test(enabled = true)
	public void TC_108_EnabledOrDisabledField() {
		String vBaseURL = "http://www.dividend.com/";
		String wBrowser = "CHROME";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver(wBrowser, vBaseURL);
		waitTime(4000);
		driver.manage().window().maximize();
		waitTime(4000);
		driver.findElement(By.linkText("Login")).click();

		// Check Login button is disabled if login credentials is empty.
		waitTime(3000);
		WebElement obj_LoginButton = driver.findElement(By.id("login-button"));
		boolean isDisabled = obj_LoginButton.isEnabled();
		Assert.assertEquals(false, isDisabled);

		// Check Login button is enabled if login credentials is not empty.
		driver.findElement(By.name("amember_login")).sendKeys("wrongId");
		driver.findElement(By.name("amember_pass")).sendKeys("wrongpassword");
		WebElement obj_LoginButton2 = driver.findElement(By.id("login-button"));
		boolean isDisabled2 = obj_LoginButton.isEnabled();
		Assert.assertEquals(true, isDisabled2);
	}

	// Requirement 109: "remember" check box is checked in login page as
	// default. Users are able to un check as well.
	@Test(enabled = true)
	public void TC_109_CheckOrUnCheckRemember() {
		String vBaseURL = "http://www.dividend.com/";
		String wBrowser = "CHROME";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver(wBrowser, vBaseURL);
		waitTime(4000);
		driver.manage().window().maximize();
		waitTime(4000);
		driver.findElement(By.linkText("Login")).click();

		// check that "remember" check box is checked as default.
		WebElement objRemember = driver.findElement(By.id("remember"));
		boolean IsChecked = objRemember.isSelected();
		Assert.assertEquals(true, IsChecked);

		// check that users are able to uncheck the "remember" checkbox.
		objRemember.click();
		boolean IsChecked2 = objRemember.isSelected();
		Assert.assertEquals(false, IsChecked2);
	}

	// Requirement 110: Users are able to search stocks or securities in the
	// page. Use different loops.
	@Test(enabled = true)
	public void TC_110_Search_Securities() {
		String vBaseURL = "http://www.dividend.com/";
		String wBrowser = "CHROME";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver(wBrowser, vBaseURL);
		waitTime(4000);
		driver.manage().window().maximize();
		waitTime(4000);

		ArrayList<String> myArray = new ArrayList<String>();
		myArray.add("BAC");
		myArray.add("JPM");
		myArray.add("AVP");
		myArray.add("NYMT");
		myArray.add("BP");

		System.out.println("Using 'For Each' loop");
		int i = 0;
		for (String v : myArray) {
			driver.findElement(By.id("sponsored-search-typeahead")).sendKeys(myArray.get(i));
			driver.findElement(By.name("button")).click();
			waitTime(2000);
			String StockName = driver.findElement(By.xpath("/html/body/div[10]/div[4]/div/div/h1/span")).getText();
			System.out.println(StockName);
			i++;
		}

		System.out.println("Using 'Iterator'");
		java.util.Iterator<String> ite = myArray.iterator();
		while (ite.hasNext()) {
			String obj = (String) ite.next();
			driver.findElement(By.id("sponsored-search-typeahead")).sendKeys(obj);
			driver.findElement(By.name("button")).click();
			waitTime(2000);
			String StockName = driver.findElement(By.xpath("/html/body/div[10]/div[4]/div/div/h1/span")).getText();
			System.out.println(StockName);
		}

		System.out.println("Using 'For' loop");
		for (int j = 0; j < myArray.size(); j++) {
			driver.findElement(By.id("sponsored-search-typeahead")).sendKeys(myArray.get(j));
			driver.findElement(By.name("button")).click();
			waitTime(2000);
			String StockName = driver.findElement(By.xpath("/html/body/div[10]/div[4]/div/div/h1/span")).getText();
			System.out.println(StockName);
		}

		System.out.println("Using 'While' loop");
		int k = 0;
		while (k < myArray.size()) {
			driver.findElement(By.id("sponsored-search-typeahead")).sendKeys(myArray.get(k));
			driver.findElement(By.name("button")).click();
			waitTime(2000);
			String StockName = driver.findElement(By.xpath("/html/body/div[10]/div[4]/div/div/h1/span")).getText();
			System.out.println(StockName);
			k++;
		}

		System.out.println("using 'DO WHILE' loop");
		int m = 0;
		do {
			driver.findElement(By.id("sponsored-search-typeahead")).sendKeys(myArray.get(m));
			driver.findElement(By.name("button")).click();
			waitTime(2000);
			String StockName = driver.findElement(By.xpath("/html/body/div[10]/div[4]/div/div/h1/span")).getText();
			System.out.println(StockName);
			m = m + 1;
		} while (m < myArray.size());

	}

	// This is not TestNG method. It is reused in TestNG methods.
	// This method will mouse over on a element called "Follow Dividend.com" in'
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

	// This is not TestNG method. It is resued in TestNG methods.
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

	// This is not TestNG method. It is reused in TestNG methods.
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
