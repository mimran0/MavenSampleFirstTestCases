package usps;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.os.WindowsUtils;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import afterLoginIn.CommonAPI;
/**
 * @author md shahajada imran
 *
 */
public class TestSetJ extends afterLoginIn.CommonAPI {

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

	// Requirement 01: Users are able to find ZIPCode using address in USPS web
	// site.
	@Test(enabled = true)
	public void TC_01_FindZipCode() {
		String vBaseURL = "http://www.usps.com/";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver("CHROME", vBaseURL);
		waitTime(5000);
		// Mouseover on "mail & ship" tab
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.xpath("//*[@id=\"global-menu\"]/div/nav/ol/li[3]/a/span[1]"));
		action.moveToElement(we).build().perform();
		waitTime(2000);
		// highlight the "look up a ZIP code" for visual pleasure
		WebElement obj_LookUpAZipCode = driver
				.findElement(By.xpath("//*[@id=\"global-menu\"]/div/nav/ol/li[3]/ol/li[6]/a"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].style.border='3px solid red'", obj_LookUpAZipCode);
		waitTime(7000);
		// Click on "Look up a ZIP Code" link from the drop down list
		obj_LookUpAZipCode.click();
		waitTime(5000);
		// Enter address in the edit fields
		driver.findElement(By.name("tCompany")).sendKeys("I love you Company");
		driver.findElement(By.name("tAddress")).sendKeys("36 breeze dr");
		driver.findElement(By.name("tApt")).sendKeys("F1");
		driver.findElement(By.name("tCity")).sendKeys("dayton");
		driver.findElement(By.xpath("//*[@id=\"sStateList\"]/div[1]/span")).click();
		waitTime(2000);
		driver.findElement(By.xpath("//*[@id=\"select-frame\"]/div[5]/div[9]/ul/li[36]/a")).click();
		waitTime(2000);
		// Click on "Find" button
		driver.findElement(By.id("lookupZipFindBtn")).click();
		waitTime(2000);
		// capturing the ZIPCODE
		WebElement objZipCode = driver.findElement(By.xpath("//*[@id=\"result-list\"]/ul/li/div/p[1]/span[5]"));
		String vZIPCode = objZipCode.getText();
		System.out.println("The ZIP Code is :" + vZIPCode);
		// highlight the ZIPcode for visual pleasure
		jse.executeScript("arguments[0].style.border='3px solid red'", objZipCode);
		waitTime(7000);
		// putting a checkpoint. (if web site tells the ZIPcode is not 08810
		// then test fail.)
		Assert.assertEquals("08810", vZIPCode);
		// Capture screenshot of the automation test
		CAPTURESCREEN(driver, "USPC_TC01_");
	}

	// Requirement 02: Calculate a price
	@Test(enabled = true)
	public void TC_02_CalculateAprice() {
		String vBaseURL = "http://www.usps.com/";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver("CHROME", vBaseURL);
		waitTime(5000);
		// Mouseover on "mail & ship" tab
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.xpath("//*[@id=\"global-menu\"]/div/nav/ol/li[3]/a/span[1]"));
		action.moveToElement(we).build().perform();
		waitTime(2000);
		// highlight the "Calculate A Price" for visual pleasure
		WebElement obj_LookUpAZipCode = driver
				.findElement(By.xpath("//*[@id=\"global-menu\"]/div/nav/ol/li[3]/ol/li[4]/a"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].style.border='3px solid red'", obj_LookUpAZipCode);
		waitTime(7000);
		// Click on "Calculate A Price" link from the drop down list
		obj_LookUpAZipCode.click();
		waitTime(5000);
		// select destination country from the dropdown list
		Select objCountry = new Select(driver.findElement(By.id("CountryID")));
		objCountry.selectByVisibleText("Bangladesh");
		waitTime(2000);
		// Enter item value in the edit field
		driver.findElement(By.name("ItemValue")).sendKeys("100");
		// check the "Only Nonnegotiable documents(s)" checkbox.
		boolean isSelected_OnlyNonnegotiableDocument = driver.findElement(By.name("NonnegotiableDocument"))
				.isSelected();
		if (!isSelected_OnlyNonnegotiableDocument) {
			driver.findElement(By.name("NonnegotiableDocument")).click();
		}
		// click on "calculate PostCard price" .
		driver.findElement(By.name("action")).click();
		driver.findElement(By.id("quantity-0")).sendKeys("3");
		waitTime(1000);
		driver.findElement(By.xpath("//*[@id=\"continue-section\"]/input")).click();
		waitTime(1000);
		String vTotalPrice = driver.findElement(By.id("total")).getText();
		System.out.println("Total price is " + vTotalPrice);
		// checkpoint
		Assert.assertEquals("$3.45", vTotalPrice);
		// capture screenshot
		CAPTURESCREEN(driver, "USPC_TC02_");
	}

	// Requirement 03: experiment all 8 selectors
	@Test(enabled = true)
	public void TC_03_ExperimentAll8Selectors() {
		// 1 LinkText
		// 2 className
		// 3 id
		// 4 cssSelector
		// 5 xpath
		// 6 name
		// 7 TagName
		// 8 partialLinkText

		String vBaseURL = "http://www.usps.com/";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver("CHROME", vBaseURL);
		waitTime(5000);
		// highlight a link and identify the link using LinkText selector (1)
		WebElement obj_F = driver.findElement(By.linkText("Customer  Service"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].style.border='3px solid red'", obj_F);
		waitTime(7000);
		System.out.println(obj_F.getClass());
		obj_F.click();
		waitTime(2000);
		driver.findElement(By.linkText("Learn More")).click();
		waitTime(1000);
		// identify a element using className (2)
		WebElement obj_l = driver.findElement(By.className("section-wrap"));
		jse.executeScript("arguments[0].style.border='3px solid red'", obj_l);
		waitTime(7000);
		System.out.println(obj_l.getText());
		driver.findElement(By.linkText("File a Claim")).click();
		waitTime(4000);
		// identify a element using Id (3)
		WebElement obj_id = driver.findElement(By.id("delta--tab-link-0"));
		jse.executeScript("arguments[0].style.border='3px solid red'", obj_id);
		waitTime(7000);
		// obj_c.click();
		// identify a element using cssSelector (4)
		WebElement obj_css = driver
				.findElement(By.cssSelector(".left-nav > ol:nth-child(3) > li:nth-child(1) > a:nth-child(1)"));
		jse.executeScript("arguments[0].style.border='3px solid red'", obj_css);
		waitTime(7000);
		// identify a element using xpath (5)
		WebElement obj_xpath = driver.findElement(By.xpath("//*[@id=\"c1408854639665\"]/nav/ol/li[5]/a"));
		jse.executeScript("arguments[0].style.border='3px solid red'", obj_xpath);
		waitTime(7000);
		driver.get("https://tools.usps.com/go/ZipLookupAction_input");
		waitTime(2000);
		// identify a element using name (6)
		WebElement obj_name = driver.findElement(By.name("tCompany"));
		jse.executeScript("arguments[0].style.border='3px solid red'", obj_name);
		waitTime(7000);
		// identify a element using TagName (7)
		WebElement obj_TagName = driver.findElement(By.tagName("img"));
		jse.executeScript("arguments[0].style.border='3px solid red'", obj_TagName);
		waitTime(7000);
		// identify a element using partialLinkText (8)
		WebElement obj_partialLinkText = driver.findElement(By.partialLinkText("Browse our"));
		jse.executeScript("arguments[0].style.border='3px solid red'", obj_partialLinkText);
		waitTime(7000);
		// driver.close(); // closing the open window only
		driver.quit(); // closing the open window and killing the process of
						// webDriver
	}

	// Requirement 04: Capture The Stamps Count
	@Test(enabled = true)
	public void TC_O4_CaptureTheStampsCount() {
		String vBaseURL = "http://www.usps.com/";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver("CHROME", vBaseURL);
		waitTime(5000);
		// click on "Buy Stamps" link.
		driver.findElement(By.linkText("Buy Stamps")).click();
		waitTime(2000);
		// capture the count of available stamps to buy.
		String vSearchResults = driver.findElement(By.className("results-numerical")).getText();
		String ArrCount[] = vSearchResults.split(" "); // splitting the string
														// into an Array by one
														// space.
		String vCount = ArrCount[4]; // Retrieving the stamps count.
		Date date = new Date(); // creating instance so that system date can be
								// retrieve.
		System.out.println("Total " + vCount + " Stamps are available to buy as of" + date);
		driver.quit(); // killing the WebDriver process.
	}

	// Requirement 05: find out how many usps locations near a zipcode
	@Test(enabled = true)
	public void TC_05_FindOutUSPS_Locations() {
		String vBaseURL = "http://www.usps.com/";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver("CHROME", vBaseURL);
		waitTime(5000);
		// Mouseover on "mail & ship" tab
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.xpath("//*[@id=\"global-menu\"]/div/nav/ol/li[3]/a/span[1]"));
		action.moveToElement(we).build().perform();
		waitTime(2000);
		driver.findElement(By.linkText("Find USPS Locations")).click();
		waitTime(3000);
		driver.findElement(By.name("address")).sendKeys("08810");
		waitTime(1000);
		driver.findElement(By.className("buttons")).click();
		waitTime(2000);
		String vResult = driver.findElement(By.className("status")).getText();
		System.out.println(vResult);
		String[] arrResult = vResult.split("of"); // splitting string into array
													// by "of".
		String vPage = arrResult[1].trim(); // removing spaces from the string.
		int vPage1 = Integer.parseInt(vPage); // converting string to integer.
		System.out.println("Total " + vPage1 + " pages displayed");

	}

	// requirement 06: find out how many usps locations near a zipcode and
	// capturing results of all available radios.
	@Test(enabled = true)
	public void TC_O6_USPS_Locations_AllRadios() {
		String vBaseURL = "http://www.usps.com/";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver("CHROME", vBaseURL);
		waitTime(5000);
		// Mouseover on "mail & ship" tab
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.xpath("//*[@id=\"global-menu\"]/div/nav/ol/li[3]/a/span[1]"));
		action.moveToElement(we).build().perform();
		waitTime(2000);
		driver.findElement(By.linkText("Find USPS Locations")).click();
		waitTime(3000);
		driver.findElement(By.name("address")).sendKeys("08810");
		waitTime(1000);
		driver.findElement(By.className("buttons")).click();
		waitTime(2000);
		String vResult = driver.findElement(By.className("status")).getText();
		System.out.println(vResult);
		// capturing results of all available radios
		int i = 1;
		while (i < 101) {
			driver.findElement(By.xpath("//*[@id=\"sWithinList\"]/div[1]/span")).click();
			waitTime(1000);
			driver.findElement(By.partialLinkText("" + i + "")).click();
			waitTime(1000);
			driver.findElement(By.className("buttons")).click();
			waitTime(2000);
			String vResult_L = driver.findElement(By.className("status")).getText();
			System.out.println("'" + vResult_L + "'" + " when radias is " + i + " mile or miles");
			switch (i) {
			case 1:
				i = i + 4;
				break;
			case 5:
				i = i + 5;
				break;
			case 10:
				i = i + 5;
				break;
			case 15:
				i = i + 5;
				break;
			case 20:
				i = i + 20;
				break;
			case 40:
				i = i + 20;
				break;
			case 60:
				i = i + 20;
				break;
			case 80:
				i = i + 20;
				break;
			default:
				System.out.println("Ends");
				i = 101;
			}// ends switch
		} // ends while
	} // ends TestNG test

	// Requirement 07: Some Random clicks
	@Test(enabled = true)
	public void TC_07_RandomClicks() {
		String vBaseURL = "http://faq.usps.com/?searchString=find%20locations";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver("CHROME", vBaseURL);
		waitTime(5000);
		driver.findElement(By.id("dijit__TreeNode_7_label")).click();
		waitTime(1000);
		driver.findElement(By.id("dijit__TreeNode_18_label")).click();
		waitTime(1000);
		driver.findElement(By.id("dijit__TreeNode_25_label")).click();
		driver.quit();

	}

	// Requirement 08: "Not Trackable" error message displays if tracking number
	// is wrong.
	@Test(enabled = true)
	public void TC_08_ErrorMessageVerificationOnWrongTrackingNumber() {
		String vBaseURL = "http://www.usps.com/";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver("CHROME", vBaseURL);
		waitTime(9000);
		driver.findElement(By.cssSelector(".quickMenuInput")).click();
		driver.findElement(By.cssSelector(".quickMenuInput")).clear();
		driver.findElement(By.cssSelector(".quickMenuInput")).sendKeys("abc123");
		waitTime(2000);
		driver.findElement(By.id("trackButton")).click();
		waitTime(2000);
		String vErrorMessage = driver.findElement(By.tagName("strong")).getText();
		System.out.println(vErrorMessage);
		Assert.assertEquals(vErrorMessage, "Not Trackable"); // check point
		driver.quit();
	}

	// Requirement 09: verify validity of sign up eligibility of valid US
	// zipcode.
	@Test(enabled = true)
	public void TC_09_SignUpEligibility() {
		String vBaseURL = "http://www.usps.com/";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver("FIREFOX", vBaseURL);
		waitTime(9000);
		driver.findElement(By.partialLinkText("Sign Up for Free")).click();
		waitTime(2000);
		driver.findElement(By.name("zipcodeForm")).sendKeys("08810");
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
		waitTime(3000);
		scrolldown(driver, 300); // scroll down little bit
		waitTime(2000);
		String vOutput = driver.findElement(By.xpath("//*[@id=\"primary-content\"]/div/div/div/div[3]/div[5]/span"))
				.getText();
		System.out.println(vOutput);
		// Checkpoint
		Assert.assertEquals(vOutput,
				"Your ZIP Code™ is eligible. Sign up now to see if Informed Delivery™ is available for your address.");
		driver.quit();

	}

	// Requirement 10: "About USPS Home" link displays in USPS's homepage in
	// Firefox
	// browser.
	@Test(enabled = true)
	public void TC_10_VerifySignUpLinkInFirefoxBrowser() {
		TestSetJ TestSetJ = new TestSetJ();
		TestSetJ.VerifyAboutUSPSHomeLink_Presence("FIREFOX");
	}

	// Requirement 11: "About USPS Home" link displays in USPS's homepage in
	// Microsoft Edge
	// browser.
	@Test(enabled = true)
	public void TC_11_VerifySignUpLinkInMicrosoftEdgeBrowser() {
		TestSetJ TestSetJ = new TestSetJ();
		TestSetJ.VerifyAboutUSPSHomeLink_Presence("MICROSOFE EDGE");
	}

	// Requirement 12: "About USPS Home" link displays in USPS's homepage in
	// Google Chrome
	// browser.
	@Test(enabled = true)
	public void TC_12_VerifySignUpLinkInGoogleChromeBrowser() {
		TestSetJ TestSetJ = new TestSetJ();
		TestSetJ.VerifyAboutUSPSHomeLink_Presence("CHROME");
	}

	// Requirement 13: "About USPS Home" link displays in USPS's homepage in
	// Internet Explorer
	// browser.
	@Test(enabled = true)
	public void TC_13_VerifySignUpLinkInInternetExplorerBrowser() {
		TestSetJ TestSetJ = new TestSetJ();
		TestSetJ.VerifyAboutUSPSHomeLink_Presence("IE");
	}

	// this is not TestNG test. this is a reusable method which will be reused
	// in TestNG tests.
	public void VerifyAboutUSPSHomeLink_Presence(String wBrowser) {
		String vBaseURL = "http://www.usps.com/";
		CommonAPI CommonAPI = new CommonAPI();
		// Firefox Browser
		WebDriver driver = CommonAPI.getDriver(wBrowser, vBaseURL);
		waitTime(9000);
		scrolldown(driver, 500); // scroll down little bit
		waitTime(2000);
		boolean isPresent = driver.findElement(By.linkText("About USPS Home")).isDisplayed();
		Assert.assertEquals(isPresent, true);
		System.out.println(driver.findElement(By.linkText("About USPS Home")).getText());
		driver.quit(); // closing and killing Firefox browser process
	}
}
