/**
 * 
 */
package MyMath;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.os.WindowsUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.steadystate.css.parser.ParseException;

import afterLoginIn.CommonAPI;
import sun.util.calendar.BaseCalendar.Date;

/**
 * @author md shahajada imran
 *
 */
public class TestSetMath_Version2 extends CommonAPI {

	public static ArrayList<String> Arr_buy = new ArrayList<String>();
	public static ArrayList<String> Arr_DoNotBuy = new ArrayList<String>();
	public static ArrayList<String> Arr_buy_withOver8PercentDividend = new ArrayList<String>();
	public static ArrayList<String> Arr_buy_withExdate = new ArrayList<String>();

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

		// List of buy with over 7% dividend
		int vArr_buy_withOver8PercentDividend_Count = Arr_buy_withOver8PercentDividend.size();
		System.out.println("There are " + vArr_buy_withOver8PercentDividend_Count
				+ " stocks in buy bucket with over 7% dividend.");
		System.out.println("*************************************************** Buy List with over 7% dividend");
		for (String v : Arr_buy_withOver8PercentDividend) {
			System.out.println(v);
		}

	}

	// Ex-date
	@Test(enabled = false, priority = 3)
	public void TC_Exdate_p() throws java.text.ParseException, ParseException {
		String sWeekStartdate = "2018-09-12";
		String wWeekEndDate = "2018-09-31";
		TC_Exdate(sWeekStartdate, wWeekEndDate);
		System.out.println(
				"********************************List of stocks with given Exdate time frame and over 7% dividend");
		for (String v : Arr_buy_withExdate) {
			System.out.println(v);
		}

	}

	// Not TestNG test.
	// this method will take each stock of "Arr_buy_withOver8PercentDividend"
	// and check the exdate with given 2 dates.
	public static void TC_Exdate(String sWeekStartdate, String wWeekEndDate)
			throws java.text.ParseException, ParseException {

		// Arr_buy_withOver8PercentDividend.add("CMO-E");
		// Arr_buy_withOver8PercentDividend.add("GOODP");
		// Arr_buy_withOver8PercentDividend.add("BHR-B");

		for (String v : Arr_buy_withOver8PercentDividend) {
			try {
				WindowsUtils.killByName("chromedriver.exe");
				String vBaseURL = "http://www.dividend.com/dividend-stocks";
				String wBrowser = "CHROME";
				CommonAPI CommonAPI = new CommonAPI();
				WebDriver driver = CommonAPI.getDriver(wBrowser, vBaseURL);
				waitTime(4000);
				driver.manage().window().maximize();
				waitTime(4000);
				driver.findElement(By.name("q")).sendKeys(v);
				waitTime(2000);
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
				waitTime(5000);
				String sExDate = driver
						.findElement(By
								.xpath("//*[@id=\"stock-price-recovery-table-collapse\"]/div/table/tbody/tr[1]/td[1]"))
						.getText();
				// System.out.println(sExDate);
				// sExDate="2018-09-19";
				// Converting string to date starts here
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				String dateInString = sExDate;
				java.util.Date date = formatter.parse(dateInString);
				// System.out.println(date);
				// System.out.println(formatter.format(date));
				// Converting string to date ends here

				// checking if exDate is in next working week
				java.util.Date dWeekStartDate = formatter.parse(sWeekStartdate);
				java.util.Date dWeekEndDate = formatter.parse(wWeekEndDate);
				// System.out.println(dWeekStartDate);
				// System.out.println(dWeekEndDate);

				if (date.after(dWeekStartDate) && date.before(dWeekEndDate)) {
					System.out.println("Exdate is in the given time frame for " + v);

				}
				Arr_buy_withExdate.add(v);
			} catch (Exception e) {
			}
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

		// dividend comparison
		String sDividend = GetCellData(driver, RowNumber, 3);
		// System.out.println(sDividend);
		sDividend = sDividend.replace("%", ""); // removing % from the string
		sDividend = sDividend.replace("$", ""); // removing $ if any
		System.out.println(sDividend);
		double iDividend = Double.parseDouble(sDividend);
		if (iDividend > 7.00) {
			Arr_buy_withOver8PercentDividend.add(myListOne.get(0));
		}

		// buy or not buy Comparison
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
