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
import org.openqa.selenium.Dimension;
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

	// Requirement 105: Verify that EPS column has value. (Not validation)
	@Test(enabled = true)
	public void TC_105_TBD() {
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
}
