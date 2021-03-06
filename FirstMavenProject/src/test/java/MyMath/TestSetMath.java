/**
 * 
 */
package MyMath;

import java.io.IOException;
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
public class TestSetMath extends CommonAPI {

	public static ArrayList<String> Arr_buy = new ArrayList<String>();
	public static ArrayList<String> Arr_DoNotBuy = new ArrayList<String>();

	@BeforeMethod
	public void SetUpPreDataMethod() {
		System.out.println("Before Each Test  executed");
		WindowsUtils.killByName("chromedriver.exe");
		WindowsUtils.killByName("iexplore.exe");
		WindowsUtils.killByName("geckodriver.exe");
		WindowsUtils.killByName("MicrosoftWebDriver.exe");
		WindowsUtils.killByName("MicrosoftEdge.exe");
	}
	// Requirement 104: Users are able to check if the stocks are good to buy or
	// not on all available pages.

	@Test(enabled = true, priority = 1)
	public void TC_104_CheckStockOnAllPage() {
		String vBaseURL = "http://www.dividend.com/dividend-stocks/preferred-dividend-stocks.php#stocks&sort_name=dividend_yield&sort_order=desc&page=1";
		String wBrowser = "CHROME";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver(wBrowser, vBaseURL);
		waitTime(4000);
		driver.manage().window().maximize();
		waitTime(4000);
		// WebElement obj_Next = driver.findElement(By.linkText("Next >"));
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

	@Test(enabled = true, priority = 2)
	public void TC_102() throws IOException {

		String vExcelPath = "C:\\Users\\imran\\workspace6\\FirstMavenProject\\src\\test\\java\\MyMath\\Resultabc.xlsx";

		// List of buy
		int vBuyList_Stock_Count = Arr_buy.size();
		System.out.println("There are " + vBuyList_Stock_Count + " stocks in the buy bucket");
		int i = 3;
		for (String v : Arr_buy) {
			System.out.println(v);
			// WriteCellData(i, 7, vExcelPath, v);
			i++;
		}

		// List of Do not buy
		int vDoNotBuyList_Stock_Count = Arr_DoNotBuy.size();
		System.out.println("There are " + vDoNotBuyList_Stock_Count + " stocks in the do not buy bucket");
		System.out.println(
				"*******************************************************************Buy Ends here. Don't buy below stocks.");
		int j = 3;
		for (String v : Arr_DoNotBuy) {
			System.out.println(v);
			// WriteCellData(j, 2, vExcelPath, v);
			j++;
		}

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
			Arr_DoNotBuy.add(GetCellData(driver, RowNumber, 1));
			return result = "do not buy";
		} else {
			System.out.println("Eligible to Buy '" + GetCellData(driver, RowNumber, 1)
					+ "' as Price is expected to rise in future");
			Arr_buy.add(GetCellData(driver, RowNumber, 1));
			return result = "BUY";
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
}
