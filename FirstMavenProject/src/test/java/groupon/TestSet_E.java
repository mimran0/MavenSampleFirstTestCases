/**
 * 
 */
package groupon;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.os.WindowsUtils;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import afterLoginIn.CommonAPI;

/**
 * @author md shahajada imran
 *
 */
public class TestSet_E extends afterLoginIn.CommonAPI {
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
		WindowsUtils.killByName("MicrosoftEdge.exe");
		WindowsUtils.killByName("firefox.exe");
		WindowsUtils.killByName("iexplore.exe");
	}

	@AfterMethod(enabled = false)
	public void aftermethod() {
		WindowsUtils.killByName("chromedriver.exe");
		WindowsUtils.killByName("MicrosoftEdge.exe");
		WindowsUtils.killByName("firefox.exe");
		WindowsUtils.killByName("iexplore.exe");
	}

	// 801:Requirement: Users are able to search
	@Test(enabled = true)
	public void TC_801_testOne() {
		String vBaseURL = "https://www.groupon.com/";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver("FIREFOX", vBaseURL);
		waitTime(25000);
		// driver.manage().window().maximize();
		// Optional Steps start here
		try {
			if (driver.findElement(By.id("nothx")).isDisplayed()) {
				driver.findElement(By.id("nothx")).click(); // closing the PopUp
															// window if opens
			}
		} catch (Exception e) {
			System.out.println("Sign Up Popup window did not open up or display");
		}
		// Optional Steps Ends here
		driver.findElement(By.name("search")).sendKeys("full body message");
		driver.findElement(By.name("location")).sendKeys("08810");
		driver.findElement(By.id("ls-header-search-button")).click();
		driver.findElement(By.id("ls-header-search-button")).click();
		waitTime(14000);
		// Optional Steps start here
		try {
			if (driver.findElement(By.id("nothx")).isDisplayed()) {
				driver.findElement(By.id("nothx")).click(); // closing the PopUp
															// window if opens
			}
		} catch (Exception e) {
			System.out.println("Sign Up Popup window did not open up or display");
		}
		// Optional Steps Ends here
		driver.findElement(By.id("grpn-sorts-select")).click(); // displaying
																// the list
		waitTime(4000);
		Select oSelect = new Select(driver.findElement(By.id("grpn-sorts-select")));
		oSelect.selectByValue("distance");
		driver.findElement(By.id("grpn-sorts-select")).click(); // not
																// displaying
																// the list
		// Scroll down and up
		ScrollDownAndUp(driver); // calling a static method

	}

	// Requirement402: Find out how many links on a webpage and highlight all of
	// those
	@Test(enabled = true)
	public void TC_402_LinkCount() {
		String vBaseURL = "https://www.groupon.com/";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver("FIREFOX", vBaseURL);
		waitTime(15000);
		// driver.manage().window().maximize();
		// Optional Steps start here
		try {
			if (driver.findElement(By.id("nothx")).isDisplayed()) {
				driver.findElement(By.id("nothx")).click(); // closing the PopUp
															// window if opens
			}
		} catch (Exception e) {
			System.out.println("Sign Up Popup window did not open up or display");
		}
		// Optional Steps Ends here

		java.util.List<WebElement> links = driver.findElements(By.tagName("a"));

		System.out.println(links.size());
		for (WebElement v : links) {
			System.out.println(v.getText()); // printing out the text property
												// value of those links
			// highlight those elements/(Links)
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].style.border='3px solid red'", v);

		}
		CAPTURESCREEN(driver, "Groupon_AllLinksAreHighlighted");
	}

	// Requirement403: Highlight one specific link (signin link)
	@Test(enabled = true)
	public void TC_403_Highlignt() {
		String vBaseURL = "https://www.groupon.com/";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver("FIREFOX", vBaseURL);
		waitTime(15000);
		// driver.manage().window().maximize();
		// Optional Steps start here
		try {
			if (driver.findElement(By.id("nothx")).isDisplayed()) {
				driver.findElement(By.id("nothx")).click(); // closing the PopUp
															// window if opens
			}
		} catch (Exception e) {
			System.out.println("Sign Up Popup window did not open up or display");
		}
		// Optional Steps Ends here
		WebElement signin = driver.findElement(By.id("ls-user-signin"));
		// highlight those elements/(Links)
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].style.border='3px solid red'", signin);

	}

	// Requirement 404: Highlight all the elements under coupon link in the
	// landing page.
	@Test(enabled = true)
	public void TC_404_HighlightElementsUnderCOUPON() {
		String vBaseURL = "https://www.groupon.com/";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver("FIREFOX", vBaseURL);
		waitTime(15000);
		// driver.manage().window().maximize();
		// Optional Steps start here
		try {
			if (driver.findElement(By.id("nothx")).isDisplayed()) {
				driver.findElement(By.id("nothx")).click(); // closing the PopUp
															// window if opens
			}
		} catch (Exception e) {
			System.out.println("Sign Up Popup window did not open up or display");
		}
		// Optional Steps Ends here
		WebElement oCoupon = driver.findElement(By.id("sls-aria-5"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].style.border='3px solid red'", oCoupon);
		// Mouseover starts here
		Actions action = new Actions(driver);
		action.moveToElement(oCoupon).build().perform();
		waitTime(2000);
		// mouseover ends here
		ArrayList<String> list = new ArrayList<String>();
		list.add("amazon-coupons");
		list.add("bloomingdale-s-coupons");
		list.add("saks-off-5th-coupons");
		list.add("guitar-center-coupons");
		list.add("bed-bath-beyond-coupons");
		list.add("ebay-coupons");
		list.add("express-coupons");
		list.add("express-coupons");
		list.add("target-coupons");
		list.add("kohl-s-coupons");
		list.add("turbotax-coupons");
		list.add("old-navy-coupons");
		list.add("best-buy-coupons");
		list.add("babiesrus-coupons");
		list.add("saks-fifth-avenue-coupons");
		list.add("best-buy-coupons");
		list.add("shutterfly-coupons");
		list.add("nordstrom-coupons");
		list.add("vistaprint-coupons");
		list.add("macy-s-coupons");
		list.add("h-r-block-at-home-coupons");
		list.add("finish-line-coupons");
		list.add("walmart-coupons");
		list.add("all-stores");
		list.add("lowe-s-coupons");
		list.add("foot-locker-coupons");
		list.add("neiman-marcus-coupons");
		list.add("nike-coupons");
		list.add("home-depot-coupons");
		list.add("american-eagle-coupons");
		// highlight those elements/(Links)
		int i;
		i = 0;
		while (i < list.size()) {
			System.out.println(list.get(i));
			WebElement obj = driver.findElement(By.id(list.get(i)));
			// JavascriptExecutor jse = (JavascriptExecutor) driver; //commented
			// out because jse is already created above Coupon mouseover. line
			// 165
			jse.executeScript("arguments[0].style.border='3px solid red'", obj);
			i++;
		}
	}

	// This is not a TestNG method. this method has 2 input arguments. this
	// method will be used to call into TestNG method to cover parameterization.
	public void CommonSearcOnLandingPAGE(String vTest, String vZipCode) {
		String vBaseURL = "https://www.groupon.com/";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver("FIREFOX", vBaseURL);
		waitTime(25000);
		// driver.manage().window().maximize();
		// Optional Steps start here
		try {
			if (driver.findElement(By.id("nothx")).isDisplayed()) {
				driver.findElement(By.id("nothx")).click(); // closing the PopUp
															// window if opens
			}
		} catch (Exception e) {
			System.out.println("Sign Up Popup window did not open up or display");
		}
		// Optional Steps Ends here
		driver.findElement(By.name("search")).sendKeys(vTest);
		driver.findElement(By.name("location")).sendKeys(vZipCode);
		driver.findElement(By.id("ls-header-search-button")).click();
		driver.findElement(By.id("ls-header-search-button")).click();
		waitTime(24000);
		// Optional Steps start here
		try {
			if (driver.findElement(By.id("nothx")).isDisplayed()) {
				driver.findElement(By.id("nothx")).click(); // closing the PopUp
															// window if opens
			}
		} catch (Exception e) {
			System.out.println("Sign Up Popup window did not open up or display");
		}
		// Optional Steps Ends here
		driver.findElement(By.id("grpn-sorts-select")).click(); // displaying
																// the list
		waitTime(4000);
		Select oSelect = new Select(driver.findElement(By.id("grpn-sorts-select")));
		oSelect.selectByValue("distance");
		driver.findElement(By.id("grpn-sorts-select")).click(); // not
																// displaying
																// the list
		// Scroll down and up
		ScrollDownAndUp(driver); // calling a static method
	}

	/// This is a alternate of parameterization as "Selenium WebDriver" doesn't
	/// support in-built parameterization
	// By Definition, Parameterization is using same method/script for different
	/// set's of input data.
	// Requirement 405: Users are able to search.
	@Test(enabled = true)
	public void TC_405_Searchability_SPA_11372() {
		TestSet_E TestSet_E = new TestSet_E();
		TestSet_E.CommonSearcOnLandingPAGE("SPA", "11372");
	}

	@Test(enabled = true)
	public void TC_406_Searchability_restaurants() {
		TestSet_E TestSet_E = new TestSet_E();
		TestSet_E.CommonSearcOnLandingPAGE("restaurants", "11369");
	}

	@Test(enabled = true)
	public void TC_407_Searchability_Public_Library() {
		TestSet_E TestSet_E = new TestSet_E();
		TestSet_E.CommonSearcOnLandingPAGE("Public Library", "08810");
	}

	@Test(enabled = true)
	public void TC_408_Searchability_Grocery() {
		TestSet_E TestSet_E = new TestSet_E();
		TestSet_E.CommonSearcOnLandingPAGE("Grocery", "08810");
	}

	@Test(enabled = true)
	public void TC_409_Searchability_Fitness() {
		TestSet_E TestSet_E = new TestSet_E();
		TestSet_E.CommonSearcOnLandingPAGE("Fitness Center", "08810");
	}

	@Test(enabled = true)
	public void TC_410_Searchability_yoga() {
		TestSet_E TestSet_E = new TestSet_E();
		TestSet_E.CommonSearcOnLandingPAGE("yoga", "08810");
	}

	@Test(enabled = true)
	public void TC_411_Searchability_spaMessage() {
		TestSet_E TestSet_E = new TestSet_E();
		TestSet_E.CommonSearcOnLandingPAGE("SPA message", "11372");
	}

	@Test(enabled = true)
	public void TC_412_Searchability_DunkinDonuts() {
		TestSet_E TestSet_E = new TestSet_E();
		TestSet_E.CommonSearcOnLandingPAGE("DunkinDonuts", "08810");
	}

	@Test(enabled = true)
	public void TC_413_Searchability_SeaFoodStores() {
		TestSet_E TestSet_E = new TestSet_E();
		TestSet_E.CommonSearcOnLandingPAGE("Sea Food Stores", "08810");
	}
}
