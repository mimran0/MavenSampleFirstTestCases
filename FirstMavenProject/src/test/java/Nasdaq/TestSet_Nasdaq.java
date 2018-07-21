/**
 * 
 */
package Nasdaq;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

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
	@Test(enabled = true)
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
	@Test(enabled = true)
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
	@Test(enabled = true)
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
}