package walmart;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.os.WindowsUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import afterLoginIn.CommonAPI;

public class TestSetB extends afterLoginIn.CommonAPI {

	// This method will be executed once before the test set that contains by
	// this class "TestSetA"
	@BeforeTest
	public void SetUpPreData() {
		System.out.println("Before TestSet  executed");
		WindowsUtils.killByName("chromedriver.exe");
	}

	// this method will be executed before every test
	@BeforeMethod
	public void SetUpPreDataMethod() {
		System.out.println("Before Each Test  executed");
		WindowsUtils.killByName("chromedriver.exe");
		WindowsUtils.killByName("iexplore.exe");
		WindowsUtils.killByName("geckodriver.exe");
		WindowsUtils.killByName("MicrosoftWebDriver.exe");
		WindowsUtils.killByName("MicrosoftEdge.exe");
	}

	// Requirement 501: Users are able to search text in walmart website
	@Test(enabled = true)
	public void TC_501_UsersAreAbleToSearch() {
		String[] list = new String[10];
		list[0] = "T-shart";
		list[1] = "panty";
		list[2] = "cap";
		list[3] = "tie";
		list[4] = "belt";
		list[5] = "bra";
		list[6] = "watch";
		list[7] = "Phone";
		list[8] = "Computer";
		list[9] = "Candle";
		String vBaseURL = "http://www.walmart.com";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver(vBaseURL);
		waitTime(5000);
		// driver.manage().window().maximize();
		for (int i = 0; i < list.length; i++) {
			driver.findElement(By.id("listboxActive")).click();
			driver.findElement(By.id("header-SearchDropdown-option-0")).click();
			waitTime(2000);
			driver.findElement(By.id("global-search-input")).sendKeys(list[i]);
			driver.findElement(By.xpath("//*[@id=\"global-search-form\"]/div/div[3]/button/span[1]")).click();
			waitTime(6000);
			driver.findElement(By.xpath("//*[@id=\"global-search-clear\"]/span[1]")).click();
			String vSearchResult1ST = driver
					.findElement(By.xpath("//*[@id=\"SearchContainer\"]/div/div[1]/div[1]/span[1]")).getText();
			String vSearchResult2ND = driver
					.findElement(By.xpath("//*[@id=\"SearchContainer\"]/div/div[1]/div[1]/span[2]")).getText();
			System.out.println(vSearchResult1ST + vSearchResult2ND);
		}
	}

	// Requirement 502: Users are able to select all values from search dropdown
	// list
	@Test(enabled = true)
	public void TC_502_SelectDropdownValue() {
		String vBaseURL = "http://www.walmart.com";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver(vBaseURL);
		waitTime(5000);
		for (int i = 0; i <= 25; i++) {
			driver.findElement(By.id("listboxActive")).click();
			driver.findElement(By.id("header-SearchDropdown-option-" + i)).click();
			waitTime(2000);
		}
	}

	// Requirement 503: Users are able to view list after mouseover on elements.
	@Test(enabled = true)
	public void TC_503_mouseOver() {
		String[] ids = new String[15];
		ids[0] = "header-GlobalEyebrowNav-button-0";
		ids[1] = "header-GlobalEyebrowNav-button-1";
		ids[2] = "header-GlobalLefthandNav-toggle-1";
		ids[3] = "superDeptId-0";
		ids[4] = "superDeptId-1";
		ids[5] = "superDeptId-2";
		ids[6] = "superDeptId-3";
		ids[7] = "superDeptId-4";
		ids[8] = "superDeptId-5";
		ids[9] = "superDeptId-6";
		ids[10] = "superDeptId-7";
		ids[11] = "superDeptId-8";
		ids[12] = "superDeptId-9";
		ids[13] = "superDeptId-10";
		ids[14] = "superDeptId-11";

		String vBaseURL = "http://www.walmart.com";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver(vBaseURL);
		waitTime(5000);
		// driver.manage().window().maximize();
		for (String v : ids) {
			Actions action = new Actions(driver);
			WebElement we = driver.findElement(By.id(v));
			action.moveToElement(we).build().perform();
			waitTime(2000);
		}
	}

	// Requirement 504: Users are able to view all credit card options, click on
	// each options and able to view corresponding page loads.
	@Test(enabled = true)
	public void TC_504_Credit_Cards() {
		String vBaseURL = "http://www.walmart.com";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver(vBaseURL);
		waitTime(5000);
		// driver.manage().window().maximize();
		driver.findElement(By.id("header-GlobalEyebrowNav-link-4")).click();
		waitTime(2000);
		// list of id's
		String[] list = new String[11];
		list[0] = "WalmartCreditCard-menu-button";
		list[1] = "MoneyTransfers-menu-button";
		list[2] = "WalmartMoneyCard-menu-button";
		list[3] = "PromotionalProducts-menu-button";
		list[4] = "ProductCarePlan-menu-button";
		list[5] = "CheckPrinting-menu-button";
		list[6] = "BillPay&MoneyOrder-menu-button";
		list[7] = "Bluebird-menu-button";
		list[8] = "TaxPrepServices-menu-button";
		list[9] = "CheckCashing-menu-button";
		list[10] = "RapidReload-menu-button";

		// list of expected results
		String[] list_ExpectedResult = new String[11];
		list_ExpectedResult[0] = "Walmart Credit Card";
		list_ExpectedResult[1] = "Online Money Transfers";
		list_ExpectedResult[2] = "Walmart MoneyCard";
		list_ExpectedResult[3] = "Promotional Products";
		list_ExpectedResult[4] = "Product Care Plan";
		list_ExpectedResult[5] = "Check Printing";
		list_ExpectedResult[6] = "Bill Pay & Money Order";
		list_ExpectedResult[7] = "Bluebird";
		list_ExpectedResult[8] = "Tax Prep Services";
		list_ExpectedResult[9] = "Check Cashing";
		list_ExpectedResult[10] = "Rapid Reload";

		for (int i = 0; i < list.length; i++) {
			driver.findElement(By.id(list[i])).click();
			waitTime(2000);
			String vActualResult = driver
					.findElement(By.xpath("//*[@id=\"categoryContainer\"]/div[1]/div[1]/div/nav/ol/li[2]/h1"))
					.getText();
			System.out.println(vActualResult);
			// putting a checkpoint if the correct page loads or not based on
			// text displays
			Assert.assertEquals(vActualResult, list_ExpectedResult[i]);
			driver.findElement(By.xpath("//*[@id=\"categoryContainer\"]/div[1]/div[1]/div/nav/ol/li[1]/a")).click();
			waitTime(1000);
		}
	}

	// Requirement 505: Users are able to login into walmart website using valid
	// credentials
	@Test(enabled = true)
	public void ValidLogin() {
		String vBaseURL = "https://www.walmart.com/account/login?tid=0&returnUrl=%2F";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver(vBaseURL);
		waitTime(5000);
		// driver.manage().window().maximize();
		// driver.findElement(By.xpath("/html/body/div/div/div/div/header/div/div[2]/div/div/div/div/div/div[6]/div/div/div/div[1]/a")).click();
		waitTime(2000);
		driver.findElement(By.name("email")).sendKeys("imranlimon00@gmail.com");
		driver.findElement(By.name("password")).sendKeys("1234560y");
		// Uncheck the check box
		/*
		 * WebElement CheckBox=driver.findElement(By.name("rememberme"));
		 * System.out.println(CheckBox.getText()); if(CheckBox.isSelected()){
		 * CheckBox.click(); waitTime(5000); }else{ //Do Nothing
		 * System.out.println("Else block Executed"); }
		 */
		driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/section/form/div[5]/button")).click();
		waitTime(10000);
		String vActualCheckPoint = driver
				.findElement(By
						.xpath("/html/body/div/div/div/div/header/div/div[2]/div/div/div/div/div/div[6]/div/div/div/div[1]/a"))
				.getText();
		System.out.println(vActualCheckPoint);
		Assert.assertEquals("Hello, Imran", vActualCheckPoint);
		// below 3 lines for mouseover
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.id("header-GlobalAccountFlyout-flyout-link"));
		action.moveToElement(we).build().perform();
		waitTime(2000);
		driver.get("https://www.walmart.com/account/logout");
	}

	// This is a method that is called in TestNG method to cover
	// parameterization
	public void StoreFinder(String BrowserName) {
		String vBaseURL = "http://www.walmart.com";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver(BrowserName, vBaseURL);
		waitTime(15000);
		// driver.manage().window().maximize();
		driver.findElement(By.id("header-GlobalEyebrowNav-button-5")).click();
		driver.get("https://www.walmart.com/store/finder");
		waitTime(2000);
		driver.findElement(By.id("find-new-location-input")).sendKeys("08810");
		// Hit enter from the keyboard starts here
		Robot r = null;
		try {
			r = new Robot();
		} catch (AWTException e) {

		}
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		// Hit enter from the keyboard Ends here
		ScrollDownAndUp(driver, 300);
	}

	// Requirement 506: Users are able to find store map with nearby walmart
	// stores in Google Chrome Browser
	@Test(enabled = true)
	public void TC_506_StoreFinder_GoogleChromeBrowser() {
		TestSetB TestSetB = new TestSetB();
		TestSetB.StoreFinder("CHROME");
	}

	// Requirement 507: Users are able to find store map with nearby walmart
	// stores in Firefox
	@Test(enabled = true)
	public void TC_506_StoreFinder_FireFoxBrowser() {
		TestSetB TestSetB = new TestSetB();
		TestSetB.StoreFinder("FIREFOX");
	}

	// Requirement 508: Users are able to find store map with nearby walmart
	// stores in Microsoft Edge
	@Test(enabled = true)
	public void TC_506_StoreFinder_MicrosoftEdgeBrowser() {
		TestSetB TestSetB = new TestSetB();
		TestSetB.StoreFinder("MICROSOFE EDGE");
	}

	// Requirement 509: Users are able to find store map with nearby walmart
	// stores in Internet Explorer
	@Test(enabled = true)
	public void TC_506_StoreFinder_InternetExplorerBrowser() {
		TestSetB TestSetB = new TestSetB();
		TestSetB.StoreFinder("IE");
	}

	// this is not TestNG test. this is re-used for creating TestNG tests.
	public void WeeklyAdd(String wBrowser) {
		String vBaseURL = "http://www.walmart.com";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver(wBrowser, vBaseURL);
		waitTime(15000);
		driver.get("https://www.walmart.com/store/2003/north-brunswick-nj/weekly-ads");
		waitTime(2000);
		ScrollDownAndUp(driver, 700);
	}

	// Requirement 510: Users are able to see all weekly adds in Google Chrome
	// Browser
	@Test(enabled = true)
	public void TC_510_WeeklyAdd_GoogleChrome() {
		TestSetB TestSetB = new TestSetB();
		TestSetB.WeeklyAdd("CHROME");
	}

	// Requirement 511: Users are able to see all weekly adds in Google Firefox
	// Browser
	@Test(enabled = true)
	public void TC_511_WeeklyAdd_Firefox() {
		TestSetB TestSetB = new TestSetB();
		TestSetB.WeeklyAdd("FIREFOX");
	}

	// Requirement 512: Users are able to see all weekly adds in Google
	// MicrosoftEdge
	// Browser
	@Test(enabled = true)
	public void TC_512_WeeklyAdd_MicorsoftEdge() {
		TestSetB TestSetB = new TestSetB();
		TestSetB.WeeklyAdd("MICROSOFE EDGE");
	}

	// Requirement 513: Users are able to see all weekly adds in Internet
	// Explorer
	@Test(enabled = true)
	public void TC_513_WeeklyAdd_InternetExplorer() {
		TestSetB TestSetB = new TestSetB();
		TestSetB.WeeklyAdd("IE");
	}

	// Requirement 514: TBD
	@Test
	public void TC_514() {
		String vBaseURL = "http://www.walmart.com";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver("CHROME", vBaseURL);
		waitTime(3000);
	}
}
