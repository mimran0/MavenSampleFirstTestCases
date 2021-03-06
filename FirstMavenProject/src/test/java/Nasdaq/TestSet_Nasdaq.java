/**
 * 
 */
package Nasdaq;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
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
public class TestSet_Nasdaq extends afterLoginIn.CommonAPI {
	@BeforeMethod
	public void SetUpPreDataMethod() {
		System.out.println("Before Each Test  executed");
		WindowsUtils.killByName("chromedriver.exe");
		WindowsUtils.killByName("MicrosoftEdge.exe");
		WindowsUtils.killByName("firefox.exe");
		WindowsUtils.killByName("iexplore.exe");
	}

	// Business Requirement 101: Users are able to search stock and collect
	// stock name
	// and price as pair.
	@Test(enabled = false)
	public void TC_101_StockSearch() {

		String[] arrImageList = new String[5];
		arrImageList[0] = "NYMT";
		arrImageList[1] = "SIX";
		arrImageList[2] = "BAC";
		arrImageList[3] = "JPM";
		arrImageList[4] = "BCS";

		String vBaseURL = "https://www.nasdaq.com/";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver("MICROSOFE EDGE", vBaseURL);
		waitTime(5000);
		driver.manage().window().maximize();
		// dealing bottom window
		try {
			driver.findElement(By.partialLinkText("Ok, got it")).click();
		} catch (Exception e) {
		}

		// creating a hash table
		Hashtable h = new Hashtable();
		for (String v : arrImageList) {
			driver.findElement(By.id("stock-search-text")).clear();
			driver.findElement(By.id("stock-search-text")).sendKeys(v);
			// Hit enter from the keyboard starts here
			Robot r = null;
			try {
				r = new Robot();
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			// Hit enter from the keyboard Ends here
			// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			waitTime(20000); // Explicit wait.
			WebElement oStockName = driver
					.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/h1"));
			String vStockName = oStockName.getText();
			System.out.println(vStockName);
			String vStockPrice = driver.findElement(By.xpath("//*[@id=\"qwidget_lastsale\"]")).getText();
			System.out.println(vStockPrice);
			h.put(vStockName, vStockPrice);
		}
		// checking Hashtable h
		System.out.println("stock name and price from Hashtable " + h);
		h.clear(); // removing everything from HashTable.
		driver.quit();
	}

	// Requirement 102: find out how many web tables in the given page.
	@Test(enabled = false)
	public void TC_102_WebTableCount() {
		String vBaseURL = "https://www.nasdaq.com/";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver("FIREFOX", vBaseURL);
		waitTime(5000);
		driver.findElement(By.linkText("ETFs")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		List<WebElement> arr_AssetClass = driver.findElements(By.tagName("table"));
		HighLight_Elements(driver, arr_AssetClass);
		driver.quit();
	}

	// Technical Requirement 103: get broker name and commission using HashMap
	// and display using iterator.
	@Test(enabled = false)
	public void TC_103_HashMap() {
		String vBaseURL = "https://www.nasdaq.com/";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver("FIREFOX", vBaseURL);
		waitTime(5000);
		driver.findElement(By.linkText("Online Broker Center")).click();
		waitTime(3000);
		WebElement oTable = driver
				.findElement(By.cssSelector("div.genTable:nth-child(18) > table:nth-child(1) > tbody:nth-child(2)"));
		HighLight_Element(driver, oTable);
		// System.out.println(oTable.getText());

		List<WebElement> rows = driver.findElements(By.xpath("/html/body/div[1]/div[2]/section/div[8]/table/tbody/tr"));
		System.out.println(rows.size());

		HashMap<String, String> map = new HashMap<>();
		for (int i = 1; i <= rows.size(); i++) {
			WebElement oRow = driver
					.findElement(By.xpath("/html/body/div[1]/div[2]/section/div[8]/table/tbody/tr[" + i + "]"));
			HighLight_Element(driver, oRow);

			try {
				WebElement oBroker = driver.findElement(
						By.xpath("/html/body/div[1]/div[2]/section/div[8]/table/tbody/tr[" + i + "]/td[1]"));
				WebElement oMinimumDiposit = driver.findElement(
						By.xpath("/html/body/div[1]/div[2]/section/div[8]/table/tbody/tr[" + i + "]/td[2]"));
				WebElement oCommission = driver.findElement(
						By.xpath("/html/body/div[1]/div[2]/section/div[8]/table/tbody/tr[" + i + "]/td[3]"));
				System.out.println(oBroker.getText());
				System.out.println(oMinimumDiposit.getText());
				System.out.println(oCommission.getText());
				map.put(oBroker.getText(), oCommission.getText());
			} catch (Exception e) {

			}

		}
		/* Display content using Iterator */
		Set set = map.entrySet();
		Iterator iterator = set.iterator();
		while (iterator.hasNext()) {
			Map.Entry mentry = (Map.Entry) iterator.next();
			System.out.print("Broker is: " + mentry.getKey() + " & Commission is: ");
			System.out.println(mentry.getValue());
		}
	}

	// Requirement 104: N/A
	@Test(enabled = false)
	public void TC_104_NA() {
		String vBaseURL = "https://www.nasdaq.com/";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver("FIREFOX", vBaseURL);
		waitTime(5000);

		// ArrayList<WebElement> arrMyList = new ArrayList<WebElement>();
		List<WebElement> arrMyList = new ArrayList<WebElement>();
		arrMyList.add(driver.findElement(By.linkText("Our Businesses")));
		arrMyList.add(driver.findElement(By.cssSelector("#site-nav-quotes > a:nth-child(1) > span:nth-child(1)")));
		arrMyList.add(driver.findElement(By.xpath("/html/body/header/nav/ul/li[3]/a/span")));
		arrMyList.add(driver.findElement(By.cssSelector("li[id*='site-nav-news']")));
		List<WebElement> arrAll_spans = driver.findElements(By.tagName("span"));
		for (WebElement v : arrAll_spans) {
			String vSpanText = v.getText();
			// System.out.println(vSpanText);
			if (vSpanText.equals("Investing")) {
				arrMyList.add(v);
				break;
			}
		}
		arrMyList.add(driver.findElement(By.xpath("/html/body/header/nav/ul/li[6]/a/span")));
		arrMyList.add(driver.findElement(By.id("site-nav-nasdaq")));

		// Mouse Over.
		for (WebElement v : arrMyList) {
			HighLight_Element(driver, v);
			Actions action = new Actions(driver);
			action.moveToElement(v).build().perform();
			waitTime(2000);
		}
	}

	// Requirement 105: Verify that EPS column has value of current page only.
	@Test(enabled = false)
	public void TC_105_VerifyEPS() {
		String vBaseURL = "https://www.nasdaq.com/earnings/earnings-calendar.aspx?";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver("FIREFOX", vBaseURL);
		waitTime(5000);

		WebElement oMyTable = driver.findElement(By.cssSelector("div[class*='genTable']"));
		// HighLight_Element(driver,oMyTable);

		List<WebElement> arrListofRows = driver.findElements(By.xpath("//*[@id=\"ECCompaniesTable\"]/tbody/tr"));
		int rowCount = arrListofRows.size();
		// System.out.println("total row in the table is " + rowCount);

		List<WebElement> arrListofColumn = driver
				.findElements(By.xpath("//*[@id=\"ECCompaniesTable\"]/tbody/tr[1]/td"));
		int columnCount = arrListofColumn.size();
		// System.out.println("Total column in the table is " + columnCount);

		for (int i = 1; i < rowCount; i++) {
			String vEPSforecast = driver
					.findElement(By.xpath("//*[@id=\"ECCompaniesTable\"]/tbody/tr[" + i + "]/td[5]")).getText();
			// System.out.println(vEPSforecast);
			String vCompanyName = driver
					.findElement(By.xpath("//*[@id=\"ECCompaniesTable\"]/tbody/tr[" + i + "]/td[2]")).getText();
			// System.out.println(vCompanyName + " = " + vEPSforecast);
			if (!((vEPSforecast.length()) == 0)) {
				System.out.println("passed");
			} else {
				Assert.fail(vCompanyName + " has no EPS value");
			}
		}

	}

	// Requirement 106: Verify that EPS column has value of all open pages.
	@Test(enabled = false)
	public void TC_106_EPS_All_Pages() {
		String vBaseURL = "https://www.nasdaq.com/earnings/earnings-calendar.aspx?";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver("FIREFOX", vBaseURL);
		waitTime(5000);

		int j = 0;
		for (int i = 2; i < 7; i++) {
			WebElement oMonday = driver
					.findElement(By.cssSelector("span#two_column_main_content_lreportweek a:nth-of-type(" + i + ")"));
			// HighLight_Element(driver,oMonday);
			WebElement oTuesday = driver
					.findElement(By.cssSelector("span#two_column_main_content_lreportweek a:nth-of-type(" + i + ")"));
			WebElement oWednesday = driver
					.findElement(By.cssSelector("span#two_column_main_content_lreportweek a:nth-of-type(" + i + ")"));
			WebElement oThursday = driver
					.findElement(By.cssSelector("span#two_column_main_content_lreportweek a:nth-of-type(" + i + ")"));
			WebElement oFriday = driver
					.findElement(By.cssSelector("span#two_column_main_content_lreportweek a:nth-of-type(" + i + ")"));

			List<WebElement> arrMyWeek = new ArrayList<WebElement>();
			arrMyWeek.add(oMonday);
			arrMyWeek.add(oTuesday);
			arrMyWeek.add(oWednesday);
			arrMyWeek.add(oThursday);
			arrMyWeek.add(oFriday);

			arrMyWeek.get(j).click();
			j++;
			waitTime(4000);
			WebElement oMyTable = driver.findElement(By.cssSelector("div[class*='genTable']"));
			// HighLight_Element(driver,oMyTable);

			List<WebElement> arrListofRows = driver.findElements(By.xpath("//*[@id=\"ECCompaniesTable\"]/tbody/tr"));
			int rowCount = arrListofRows.size();
			// System.out.println("total row in the table is " + rowCount);

			List<WebElement> arrListofColumn = driver
					.findElements(By.xpath("//*[@id=\"ECCompaniesTable\"]/tbody/tr[1]/td"));
			int columnCount = arrListofColumn.size();
			// System.out.println("Total column in the table is " +
			// columnCount);

			for (int k = 1; k < rowCount; k++) {
				String vEPSforecast = driver
						.findElement(By.xpath("//*[@id=\"ECCompaniesTable\"]/tbody/tr[" + k + "]/td[5]")).getText();
				// System.out.println(vEPSforecast);
				String vCompanyName = driver
						.findElement(By.xpath("//*[@id=\"ECCompaniesTable\"]/tbody/tr[" + k + "]/td[2]")).getText();
				// System.out.println(vCompanyName + " = " + vEPSforecast);
				if (!((vEPSforecast.length()) == 0)) {
					System.out.println("passed");
				} else {
					Assert.fail(vCompanyName + " has no EPS value");
				}
			}
			driver.navigate().refresh();
		}

	}

	// Technical Requirement 107: Verify text color of a web Element.
	@Test(enabled = false)
	public void TC_107_VerifyColor() {

		String vBaseURL = "https://www.nasdaq.com/investing/online-brokers/";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver("FIREFOX", vBaseURL);
		waitTime(5000);

		WebElement oCC = driver.findElement(By.linkText("Centerpoint Securities"));
		HighLight_Element(driver, oCC);

		String vColor = oCC.getCssValue("color");
		System.out.println(vColor);

		// String vColor = "rgb(0, 149, 197)";
		// removing "rgb(" from the string
		String v_hexValue = vColor.replace("rgb(", "");
		System.out.println(v_hexValue);
		// removing ")" from the string
		v_hexValue = v_hexValue.replace(")", "");
		System.out.println(v_hexValue);
		// Storing 3 string numbers into 3 elements of an array.
		String[] arr_hexValue = v_hexValue.split(",");
		// Removing spaces from the array elements
		arr_hexValue[0] = arr_hexValue[0].trim();
		arr_hexValue[1] = arr_hexValue[1].trim();
		arr_hexValue[2] = arr_hexValue[2].trim();

		// Converting strings to integers
		int hexvalue1 = Integer.parseInt(arr_hexValue[0]);
		int hexvalue2 = Integer.parseInt(arr_hexValue[1]);
		int hexvalue3 = Integer.parseInt(arr_hexValue[2]);

		// Making the color format
		String vActualColor = String.format("#%02x%02x%02x", hexvalue1, hexvalue2, hexvalue3);
		System.out.println(vActualColor);
		// CheckPoint
		Assert.assertEquals("#0095c5", vActualColor);
	}

	// Business Requirement 108: Verify text colors of all broker names
	// displayed on
	// given page.
	@Test(enabled = false)
	public void TC_108_TBD() {
		String vBaseURL = "https://www.nasdaq.com/investing/online-brokers/";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver("FIREFOX", vBaseURL);
		waitTime(5000);

		for (int i = 1; i < 43; i++) {
			WebElement oBrokerName = driver
					.findElement(By.xpath("//*[@id=\"main-content\"]/div[8]/table/tbody/tr[" + i + "]/td[1]/b/a"));
			// HighLight_Element(driver, oBrokerName);
			String vColor = oBrokerName.getCssValue("color");
			// System.out.println(vColor);

			// String vColor = "rgb(0, 149, 197)";
			// removing "rgb(" from the string
			String v_hexValue = vColor.replace("rgb(", "");
			System.out.println(v_hexValue);
			// removing ")" from the string
			v_hexValue = v_hexValue.replace(")", "");
			System.out.println(v_hexValue);
			// Storing 3 string numbers into 3 elements of an array.
			String[] arr_hexValue = v_hexValue.split(",");
			// Removing spaces from the array elements
			arr_hexValue[0] = arr_hexValue[0].trim();
			arr_hexValue[1] = arr_hexValue[1].trim();
			arr_hexValue[2] = arr_hexValue[2].trim();

			// Converting strings to integers
			int hexvalue1 = Integer.parseInt(arr_hexValue[0]);
			int hexvalue2 = Integer.parseInt(arr_hexValue[1]);
			int hexvalue3 = Integer.parseInt(arr_hexValue[2]);

			// Making the color format
			String vActualColor = String.format("#%02x%02x%02x", hexvalue1, hexvalue2, hexvalue3);
			System.out.println(vActualColor);
			// CheckPoint
			Assert.assertEquals("#0095c5", vActualColor);
		}
	}

	// Requirement 109: Verify that the text color of all "View All" links on
	// Nasdaq home page are green.
	@Test(enabled = false)
	public void TC_109_TBD() {
		String vBaseURL = "https://www.nasdaq.com/";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver("FIREFOX", vBaseURL);
		waitTime(5000);
		List<WebElement> arrVeiwAll = driver.findElements(By.linkText("View All"));
		HighLight_Elements(driver, arrVeiwAll);

		for (WebElement v : arrVeiwAll) {
			String vColor = v.getCssValue("color");
			// System.out.println(vColor);
			// String vColor = "rgb(0, 149, 197)";
			// removing "rgb(" from the string
			String v_hexValue = vColor.replace("rgb(", "");
			System.out.println(v_hexValue);
			// removing ")" from the string
			v_hexValue = v_hexValue.replace(")", "");
			System.out.println(v_hexValue);
			// Storing 3 string numbers into 3 elements of an array.
			String[] arr_hexValue = v_hexValue.split(",");
			// Removing spaces from the array elements
			arr_hexValue[0] = arr_hexValue[0].trim();
			arr_hexValue[1] = arr_hexValue[1].trim();
			arr_hexValue[2] = arr_hexValue[2].trim();

			// Converting strings to integers
			int hexvalue1 = Integer.parseInt(arr_hexValue[0]);
			int hexvalue2 = Integer.parseInt(arr_hexValue[1]);
			int hexvalue3 = Integer.parseInt(arr_hexValue[2]);

			// Making the color format
			String vActualColor = String.format("#%02x%02x%02x", hexvalue1, hexvalue2, hexvalue3);
			System.out.println(vActualColor);
			// CheckPoint
			Assert.assertEquals("#0095c5", vActualColor);
		}
	}

	// requirement 110: Verify that green color data display if secondary market
	// goes up and red color data display if secondary market goes down.
	@Test(enabled = false)
	public void TC_110_MarketDataColor() {
		String vBaseURL = "https://www.nasdaq.com/";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver("FIREFOX", vBaseURL);
		waitTime(5000);
		List<WebElement> arrMarketResult = new ArrayList<WebElement>();

		arrMarketResult.add(driver.findElement(By.cssSelector("div.indexmktdata:nth-child(4) > span:nth-child(1)")));
		arrMarketResult.add(driver.findElement(By.cssSelector("div.indexmktdata:nth-child(4) > span:nth-child(2)")));
		arrMarketResult.add(driver.findElement(By.cssSelector("div.indexmktdata:nth-child(6) > span:nth-child(1)")));
		arrMarketResult.add(driver.findElement(By.cssSelector("div.indexmktdata:nth-child(6) > span:nth-child(2)")));
		arrMarketResult.add(driver.findElement(By.cssSelector("div.indexmktdata:nth-child(8) > span:nth-child(1)")));
		arrMarketResult.add(driver.findElement(By.cssSelector("div.indexmktdata:nth-child(8) > span:nth-child(2)")));

		for (WebElement v : arrMarketResult) {
			HighLight_Element(driver, v);
			String vdata = v.getText();
			System.out.println(vdata);
			// checking if data is negative or positive
			boolean isNegative = vdata.contains("-");
			System.out.println(isNegative);

			// Setting expected color
			String vExpectedColor;
			if (isNegative == false) {
				vExpectedColor = "#008000";
			} else {
				vExpectedColor = "#ee3524";
			}

			// Checking color
			String vColor = v.getCssValue("color");
			System.out.println(vColor);
			// String vColor = "rgb(0, 149, 197)";
			// removing "rgb(" from the string
			String v_hexValue = vColor.replace("rgb(", "");
			System.out.println(v_hexValue);
			// removing ")" from the string
			v_hexValue = v_hexValue.replace(")", "");
			System.out.println(v_hexValue);
			// Storing 3 string numbers into 3 elements of an array.
			String[] arr_hexValue = v_hexValue.split(",");
			// Removing spaces from the array elements
			arr_hexValue[0] = arr_hexValue[0].trim();
			arr_hexValue[1] = arr_hexValue[1].trim();
			arr_hexValue[2] = arr_hexValue[2].trim();

			// Converting strings to integers
			int hexvalue1 = Integer.parseInt(arr_hexValue[0]);
			int hexvalue2 = Integer.parseInt(arr_hexValue[1]);
			int hexvalue3 = Integer.parseInt(arr_hexValue[2]);

			// Making the color format
			String vActualColor = String.format("#%02x%02x%02x", hexvalue1, hexvalue2, hexvalue3);
			System.out.println(vActualColor);
			Assert.assertEquals(vExpectedColor, vActualColor);
		}
	}

	// Business Requirement 111: validate the text colors of "Change Net" column
	// of "Stock Market Overview" webTable.
	@Test(enabled = false)
	public void TC_111_TBD() {
		String vBaseURL = "https://www.nasdaq.com/";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver("FIREFOX", vBaseURL);
		waitTime(5000);
		// Creating an arrayList to store WebElements.
		ArrayList<WebElement> arrMyElementList = new ArrayList<WebElement>();
		// Storing elements into the arrayList
		for (int i = 0; i < 7; i++) {
			arrMyElementList.add(
					driver.findElement(By.cssSelector("#indexTableRow" + i + " > td:nth-child(3) > div:nth-child(1)")));
		}
		// going through for each loop
		for (WebElement v : arrMyElementList) {
			HighLight_Element(driver, v);
			System.out.println(v.getText());
			// checking if text is negative or positive
			boolean isNegative = v.getText().contains("-");
			System.out.println(isNegative);

			// Setting expected color
			String vExpectedColor;
			if (isNegative == false) {
				vExpectedColor = "#387c2c";
			} else {
				vExpectedColor = "#ee3524";
			}

			// Checking color
			String vColor = v.getCssValue("color");
			System.out.println(vColor);
			// String vColor = "rgb(0, 149, 197)";
			// removing "rgb(" from the string
			String v_hexValue = vColor.replace("rgb(", "");
			System.out.println(v_hexValue);
			// removing ")" from the string
			v_hexValue = v_hexValue.replace(")", "");
			System.out.println(v_hexValue);
			// Storing 3 string numbers into 3 elements of an array.
			String[] arr_hexValue = v_hexValue.split(",");
			// Removing spaces from the array elements
			arr_hexValue[0] = arr_hexValue[0].trim();
			arr_hexValue[1] = arr_hexValue[1].trim();
			arr_hexValue[2] = arr_hexValue[2].trim();

			// Converting strings to integers
			int hexvalue1 = Integer.parseInt(arr_hexValue[0]);
			int hexvalue2 = Integer.parseInt(arr_hexValue[1]);
			int hexvalue3 = Integer.parseInt(arr_hexValue[2]);

			// Making the color format
			String vActualColor = String.format("#%02x%02x%02x", hexvalue1, hexvalue2, hexvalue3);
			System.out.println(vActualColor);
			Assert.assertEquals(vExpectedColor, vActualColor);
		}

	}

	// Requirement 112: Validate that first column's text is Bold and 2nd
	// column's text is not bold in "More Brokers" webTable. Excludes 1st row.
	@Test(enabled = false)
	public void TC_112_ValidateBoldTexts() {
		String vBaseURL = "https://www.nasdaq.com/investing/online-brokers/";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver("FIREFOX", vBaseURL);
		waitTime(5000);
		for (int i = 2; i < 43; i++) {

			// First Column
			WebElement oBrokerName = driver
					.findElement(By.xpath("//*[@id=\"main-content\"]/div[8]/table/tbody/tr[" + i + "]/td[1]/b/a"));
			HighLight_Element(driver, oBrokerName);
			String vFont = oBrokerName.getCssValue("font-weight");
			System.out.println(vFont);
			Assert.assertEquals("700", vFont);

			// 2nd column
			try {
				WebElement oMinimumDiposit = driver
						.findElement(By.xpath("//*[@id=\"main-content\"]/div[8]/table/tbody/tr[" + i + "]/td[2]"));
				HighLight_Element(driver, oMinimumDiposit);
				String vFont_oMinimumDiposit = oMinimumDiposit.getCssValue("font-weight");
				System.out.println(vFont_oMinimumDiposit);
				Assert.assertEquals("400", vFont_oMinimumDiposit);
			} catch (Exception e) {
				System.out.println("There is empty data on  row number " + i);
			}

		}
	}

	// Requirement 113: TBD
	@Test(enabled = false)
	public void TC_113_TBD() {
		String vBaseURL = "https://www.nasdaq.com/investing/online-brokers/";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver("FIREFOX", vBaseURL);
		waitTime(5000);

		// List<WebElement>
		// myFuckenList=driver.findElements(By.tagName("button"));
		// HighLight_Elements(driver,myFuckenList);

		List<WebElement> myList = new ArrayList<WebElement>();
		myList.add(driver.findElement(By.cssSelector("a[href^='https://www.facebook.com/']")));
		myList.add(driver.findElement(By.cssSelector("a[href$='twitter.com/nasdaq']")));
		myList.add(driver.findElement(By.cssSelector("a[href*='https://plus.google.com/+nasdaq']")));
		myList.add(driver.findElement(By.cssSelector("a[title*='Annual Report']")));
		myList.add(driver.findElement(By.cssSelector("a[title*='Contact']")));
		myList.add(driver.findElement(By.cssSelector("a[title*='Careers']")));
		myList.add(driver.findElement(By.cssSelector("a[title*='Advertise on Nasdaq.com']")));
		myList.add(driver.findElement(By.partialLinkText("Mobile Versi")));
		List<WebElement> myLinkList = driver.findElements(By.tagName("a"));
		for (WebElement v : myLinkList) {
			if ((v.getText().equals("Feedback"))) {
				myList.add(v);
			}
		}
		for (WebElement v : myLinkList) {
			if ((v.getAttribute("title").equals("Glossary"))) {
				myList.add(v);
			}
		}
		for (WebElement v : myLinkList) {
			if ((v.getAttribute("href").equals("https://www.nasdaq.com/help/sitemap.aspx"))) {
				myList.add(v);
			}
		}

		myList.add(driver.findElement(By.xpath("//a[@title='Privacy Policy']")));
		myList.add(driver.findElement(By.xpath("//*[@title='Terms of Use']")));
		myList.add(driver.findElement(By.xpath("//a[@title='Company News']")));
		for (WebElement v : myList) {
			HighLight_Element(driver, v);
		}
	}

	// Requirement 114: TBD
	@Test(enabled = true)
	public void TC_114_TBD() {
		String vBaseURL = "https://www.nasdaq.com/investing/online-brokers/";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver("FIREFOX", vBaseURL);
		waitTime(5000);
		driver.findElement(By.xpath("//input[@id='stock-search-text'][@name='stock-search-text']")).sendKeys("NYMT");
		waitTime(3000);
		driver.findElement(By.xpath("//button[@id='stock-search-submit'][@type='submit']")).click();
		waitTime(2000);
		String vStockPrice=driver.findElement(By.xpath("//div[@id='qwidget_lastsale'][@class='qwidget-dollar']")).getText();
		System.out.println(vStockPrice);
		String vAsOfDate=driver.findElement(By.xpath("//span[@id='qwidget_markettime']")).getText();
		System.out.println(vAsOfDate);
		driver.findElement(By.xpath("//a[@href='javascript:void(0);']")).click();
	}
}
