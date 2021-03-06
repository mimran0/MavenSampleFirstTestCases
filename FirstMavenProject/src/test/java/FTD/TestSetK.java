package FTD;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.os.WindowsUtils;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import afterLoginIn.CommonAPI;
import junit.framework.Assert;

/**
 * @author md shahajada imran
 *
 */
public class TestSetK extends afterLoginIn.CommonAPI {

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

	// Requirement 101: select a red rose in Google Chrome
	@Test(enabled = true)
	public void SelectA_Rose_GoogleChrome() {
		String wBrowser = "CHROME";
		TestSetK TestSetK = new TestSetK();
		TestSetK.SelectARedRose_Baby(wBrowser);
	}

	// Requirement 102: select a red rose in Firefox Browser
	@Test(enabled = true)
	public void SelectA_Rose_FireFox() {
		String wBrowser = "FIREFOX";
		TestSetK TestSetK = new TestSetK();
		TestSetK.SelectARedRose_Baby(wBrowser);

	}

	// Requirement 103: select a red rose in Microsoft Edge
	@Test(enabled = true)
	public void SelectA_Rose_MicorsoftEdge() {
		String wBrowser = "MICROSOFE EDGE";
		TestSetK TestSetK = new TestSetK();
		TestSetK.SelectARedRose_Baby(wBrowser);
	}

	// Requirement 104: select a red rose in Internet Explorer
	@Test(enabled = true)
	public void SelectA_Rose_InternetExplorer() {
		String wBrowser = "IE";
		TestSetK TestSetK = new TestSetK();
		TestSetK.SelectARedRose_Baby(wBrowser);
	}

	// This is not a TestNG test. It is a regular method which will be reuse in
	// TestNG test.
	public void SelectARedRose_Baby(String wBrowser) {
		String vBaseURL = "https://www.ftd.com/roses-ctg/product-roses-alt4";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver(wBrowser, vBaseURL);
		waitTime(4000);
		// Mouseover on "mail & ship" tab
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.partialLinkText("COLORS"));
		action.moveToElement(we).build().perform();
		waitTime(4000);
		driver.findElement(By.linkText("Red")).click();
		waitTime(10000);
		// pop up window starts here (If exist)
		try {
			driver.findElement(By.id("dropdown_delDate")).click();
			waitTime(4000);
			// driver.findElement(By.xpath("/html/body/div[8]/table/thead/tr[1]/td[3]")).click();
			waitTime(4000);
			driver.findElement(By.xpath("//*[@id=\"modalContent\"]/button")).click();
			waitTime(4000);
		} catch (Exception e1) {
		}
		// Pop up window ends here
		driver.findElement(By.id("cat_prod_image_FRR4")).click();
		waitTime(3000);
		driver.findElement(By.xpath("//*[@id=\"prod_step\"]/div[2]/div[1]/div[1]/div/div[1]/img")).click();
		waitTime(3000);
		driver.findElement(By.id("zip_step")).click();
		waitTime(3000);
		driver.findElement(By.name("STZIP")).sendKeys("08810");
		waitTime(4000);
		if (wBrowser == "IE") {
			driver.findElement(By.id("ppDelLoc")).click();
			waitTime(3000);
			driver.findElement(By.xpath("//*[@id=\"ppDelLoc\"]/option[2]")).click();
		} else if (wBrowser == "FIREFOX") {
			driver.findElement(By.id("pp_del_overlay")).click();
			waitTime(3000);
			driver.findElement(By.xpath("//*[@id=\"ppDelLoc\"]/option[2]")).click();
		} else {
			Select dropdown2 = new Select(driver.findElement(By.id("ppDelLoc")));
			dropdown2.selectByVisibleText("Residence");
			waitTime(1000);
		}
		driver.findElement(By.id("deldate_step")).click();
		waitTime(3000);
		driver.findElement(By.id("addon_step")).click();
		waitTime(3000);
		driver.findElement(By.xpath("//*[@id=\"callToAction_btn\"]/span[2]/img")).click();
		waitTime(7000);
		boolean isCheckOutNowDisplay = driver.findElement(By.partialLinkText("CHECKOUT NOW")).isDisplayed();
		Assert.assertEquals(isCheckOutNowDisplay, true);
		// dealing with popup window starts here. (It is 'Optional Steps' if
		// compared with UFT or QTP)
		try {
			WebElement PopUpWindow = driver.findElement(By.partialLinkText("I PREFER TO PAY FULL PRICE"));
			boolean IsPopUpWindowDisplayed = PopUpWindow.isDisplayed();
			if (IsPopUpWindowDisplayed) {
				PopUpWindow.click();
			}
		} catch (Exception e) {
		}
		// dealing with popup wind ends here.
	}

	// Requirement 105: Mouseover all links
	@Test(enabled = true)
	public void MousOverAllLinks() {
		String vBaseURL = "https://www.ftd.com/roses-ctg/product-roses-alt4";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver("MICROSOFE EDGE", vBaseURL);
		waitTime(4000);
		// declaring and initialization of an array in one line.
		String[] ImranARRAY = new String[] { "OCCASION", "FLOWERS", "PLANTS & GIFTS", "COLORS", "DEALS", "SAME DAY" };
		// MouseOver on 6 different fields
		for (String v : ImranARRAY) {
			Actions action = new Actions(driver);
			WebElement we = driver.findElement(By.partialLinkText(v));
			action.moveToElement(we).build().perform();
			waitTime(4000);
		}

	}

	// Requirement 106: Users are able to search on the home page.
	@Test(enabled = true)
	public void SearchAbility() {
		String vBaseURL = "https://www.ftd.com/roses-ctg/product-roses-alt4";
		String wBrowser = "MICROSOFE EDGE";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver(wBrowser, vBaseURL);
		waitTime(4000);
		// declaring and initialization of an array in one line.
		String[] ImranARRAY = new String[] { "Red", "Yellow", "Green", "Black", "Pink", "Purple" };

		for (String v : ImranARRAY) {
			driver.findElement(By.id("toolbar_search_box")).clear();
			driver.findElement(By.id("toolbar_search_box")).sendKeys(v);
			driver.findElement(By.id("Search")).click();
			waitTime(5000); // Synchronization
			CAPTURESCREEN(driver, "FTD" + v);
			ProcessCheckOut(driver, wBrowser);
		}

	}

	public static void ProcessCheckOut(WebDriver driver, String wBrowser) {
		// pop up window starts here (If exist)
		try {
			driver.findElement(By.id("dropdown_delDate")).click();
			waitTime(4000);
			// driver.findElement(By.xpath("/html/body/div[8]/table/thead/tr[1]/td[3]")).click();
			waitTime(4000);
			driver.findElement(By.xpath("//*[@id=\"modalContent\"]/button")).click();
			waitTime(4000);
		} catch (Exception e1) {
		}
		// Pop up window ends here
		driver.findElement(By.xpath("//*[@id=\"c1\"]/div/a/img")).click();
		waitTime(3000);
		// Optional Steps
		try {
			boolean IsImageExist = driver
					.findElement(By.xpath("//*[@id=\"prod_step\"]/div[2]/div[1]/div[1]/div/div[1]/img")).isDisplayed();
			if (IsImageExist == true) {
				driver.findElement(By.xpath("//*[@id=\"prod_step\"]/div[2]/div[1]/div[1]/div/div[1]/img")).click();
				waitTime(3000);
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		driver.findElement(By.id("zip_step")).click();
		waitTime(3000);
		driver.findElement(By.name("STZIP")).sendKeys("08810");
		waitTime(4000);
		if (wBrowser == "IE") {
			driver.findElement(By.id("ppDelLoc")).click();
			waitTime(3000);
			driver.findElement(By.xpath("//*[@id=\"ppDelLoc\"]/option[2]")).click();
		} else {
			Select dropdown2 = new Select(driver.findElement(By.id("ppDelLoc")));
			dropdown2.selectByVisibleText("Residence");
			waitTime(3000);
		}
		driver.findElement(By.id("deldate_step")).click();
		waitTime(7000);
		// Optional Steps
		try {
			boolean IsAddonExist = driver.findElement(By.id("addon_step")).isDisplayed();
			if (IsAddonExist) {
				driver.findElement(By.id("addon_step")).click();
				waitTime(7000);
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		driver.findElement(By.xpath("//*[@id=\"callToAction_btn\"]/span[2]/img")).click();
		waitTime(10000);
		boolean isCheckOutNowDisplay = driver.findElement(By.partialLinkText("CHECKOUT NOW")).isDisplayed();
		Assert.assertEquals(isCheckOutNowDisplay, true);
		// dealing with popup window starts here. (It is 'Optional Steps' if
		// compared with UFT or QTP)
		try {
			WebElement PopUpWindow = driver.findElement(By.partialLinkText("I PREFER TO PAY FULL PRICE"));
			boolean IsPopUpWindowDisplayed = PopUpWindow.isDisplayed();
			if (IsPopUpWindowDisplayed) {
				PopUpWindow.click();
			}
		} catch (Exception e) {
		}
		// dealing with popup wind ends here.
	}

	// Requirement 107: Verify Error message displays for login attempt with
	// wrong credentials. Use all 8 selectors to identify objects or elements.
	@Test(enabled = true)
	public void TC_107_All8selectors_EMWRLA() {
		// 1. ClassName selector
		// 2. cssSelector selector
		// 3. name selector
		// 4. id selector
		// 5. xpath selector
		// 6. TagName selector
		// 7. LinkTest selector
		// 8. PartialLinkTest selector
		String vBaseURL = "https://www.ftd.com/roses-ctg/product-roses-alt4";
		String wBrowser = "FIREFOX";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver(wBrowser, vBaseURL);
		waitTime(4000);

		// 1. Identify object using class selector.
		// dealing with popup window.
		try {
			WebElement obj_X = driver.findElement(By.className("bx-close-x-adaptive-2"));
			boolean IsXdisplay = obj_X.isDisplayed();
			// System.out.println(IsXdisplay);
			// System.out.println(obj_X.getTagName());
			if (IsXdisplay) {
				obj_X.click();
			}
		} catch (Exception e) {
			Assert.fail(" Pop up window did not display.");
		}

		waitTime(3000);
		// 2. Identify object using cssSelector selector
		WebElement obj_SignIn = driver.findElement(By.cssSelector(".sign-in"));
		obj_SignIn.click();
		waitTime(3000); // Synchronization 3 seconds.

		// 3. Identify object usnig name selector
		WebElement obj_emailAddress = driver.findElement(By.name("email"));
		obj_emailAddress.sendKeys("wrongEmail@love.com");
		waitTime(3000);

		// 4. Identify object using id selector
		WebElement obj_Password = driver.findElement(By.id("lm_password"));
		obj_Password.sendKeys("wrongPassword");
		waitTime(3000);

		// 5. Identify object using xpath selector
		WebElement obj_SignIn2 = driver
				.findElement(By.xpath("//*[@id=\"purchasepath_FTDsignin\"]/div[6]/div[2]/button"));
		obj_SignIn2.click();
		waitTime(3000);

		// checkpoint starts here
		WebElement obj_ErrorMessage = driver.findElement(By.cssSelector("div.pplm_error:nth-child(1)"));
		String v_ErrorMessage = obj_ErrorMessage.getText();
		System.out.println(v_ErrorMessage);
		Assert.assertEquals("Email address and password do not match. Please review and re-submit.", v_ErrorMessage);
		// checkpoint ends here

		waitTime(3000);
		// 6. Identify object using tagName selector
		WebElement obj_X = driver.findElement(By.tagName("button"));
		obj_X.click();

		waitTime(3000);
		// 7. Identify object using LinkText selector
		WebElement obj_CustomerService = driver.findElement(By.linkText("CUSTOMER SERVICE"));
		obj_CustomerService.click();
		waitTime(3000);

		// 8. Identify object using PartialLinkText selector
		WebElement obj_ChangeMyOrder = driver.findElement(By.partialLinkText("Change My O"));
		obj_ChangeMyOrder.click();
		waitTime(3000);

		// Checkpoint starts here
		WebElement obj_OrderInformation = driver.findElement(By.cssSelector(
				"table.custserv_text:nth-child(6) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > font:nth-child(1) > b:nth-child(1)"));
		String v_OrderInformation = obj_OrderInformation.getText();
		System.out.println(v_OrderInformation);
		Assert.assertEquals("Order Information", v_OrderInformation);
		// Checkpoinnt ends here
	}

	// Requirement 108: Users are able to search on the home page based on
	// flower type.
	@Test(enabled = true)
	public void SearchAbility_FlowerType() {
		String vBaseURL = "https://www.ftd.com/roses-ctg/product-roses-alt4";
		String wBrowser = "MICROSOFE EDGE";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver(wBrowser, vBaseURL);
		waitTime(4000);
		// declaring and initialization of an array in one line.
		String[] ImranARRAY = new String[] { "Rose", "Lily", "Freesia", "Peony", "Orchids", "Tulip" };

		for (String v : ImranARRAY) {
			driver.findElement(By.id("toolbar_search_box")).clear();
			driver.findElement(By.id("toolbar_search_box")).sendKeys(v);
			driver.findElement(By.id("Search")).click();
			waitTime(5000); // Synchronization
			CAPTURESCREEN(driver, "FTD_" + v);
			ProcessCheckOut(driver, wBrowser);
		}

	}

	// Requirement 109: Users are able to search on the home page based on
	// Keyword.
	@Test(enabled = true)
	public void SearchAbility_Keyword() {
		String vBaseURL = "https://www.ftd.com/roses-ctg/product-roses-alt4";
		String wBrowser = "MICROSOFE EDGE";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver(wBrowser, vBaseURL);
		waitTime(4000);
		// declaring and initialization of an array in one line.
		String[] ImranARRAY = new String[] { "Birthday", "Love", "Love & Romance", "Thank You", "Anniversary" };

		for (String v : ImranARRAY) {
			driver.findElement(By.id("toolbar_search_box")).clear();
			driver.findElement(By.id("toolbar_search_box")).sendKeys(v);
			driver.findElement(By.id("Search")).click();
			waitTime(5000); // Synchronization
			CAPTURESCREEN(driver, "FTD_" + v);
			ProcessCheckOut(driver, wBrowser);
		}

	}

	// Requirement 110: Verify that Social Networking images display on homepage
	// and works.
	@Test(enabled = true)
	public void Tc_110_SNI() {
		String vBaseURL = "https://www.ftd.com/roses-ctg/product-roses-alt4";
		String wBrowser = "FIREFOX";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver(wBrowser, vBaseURL);
		waitTime(10000);

		// Checking if Facebook image display or not and Clicking on the image
		// open new tab or not.
		WebElement obj_Facebook = driver.findElement(By.cssSelector(".sprite-icon-facebook"));
		String vPageTytle = "FTD Flowers - Home | Facebook";
		SocialNetworkingImageCheck(driver, obj_Facebook, vPageTytle);

		// Checking if Twitter image display or not and Clicking on the image
		// open new tab or not.
		WebElement obj_Twitter = driver.findElement(By.cssSelector(".sprite-icon-twitter"));
		String vPageTytle_Twitter = "FTD Flowers (@ftdflowers) | Twitter";
		SocialNetworkingImageCheck(driver, obj_Twitter, vPageTytle_Twitter);

		// Checking if Pign image display or not and Clicking on the image
		// open new tab or not.
		WebElement obj_Pign = driver.findElement(By.cssSelector(".sprite-icon-pinterest"));
		String vPageTytle_Pign = "FTD Flowers (ftdflowers) on Pinterest";
		SocialNetworkingImageCheck(driver, obj_Pign, vPageTytle_Pign);

		// Checking if Youtube image display or not and Clicking on the image
		// open new tab or not.
		WebElement obj_Youtube = driver.findElement(By.cssSelector(".sprite-icon-youtube"));
		String vPageTytle_Youtube = "FTD Flowers - YouTube - YouTube";
		SocialNetworkingImageCheck(driver, obj_Youtube, vPageTytle_Youtube);

		// Checking if Google image display or not and Clicking on the image
		// open new tab or not.
		WebElement obj_Google = driver.findElement(By.cssSelector(".sprite-icon-google"));
		String vPageTytle_Google = "FTD Flowers - Google+";
		SocialNetworkingImageCheck(driver, obj_Google, vPageTytle_Google);

		// Checking if Instagram image display or not and Clicking on the image
		// open new tab or not.
		WebElement obj_Instagram = driver.findElement(By.cssSelector(".sprite-icon-instagram"));
		String vPageTytle_Instagram = "FTD Flowers (@ftdflowers) � Instagram photos and videos";
		SocialNetworkingImageCheck(driver, obj_Instagram, vPageTytle_Instagram);

		// Checking if FTD_Blog image display or not and Clicking on the image
		// open new tab or not.
		WebElement obj_FTD_Blog = driver.findElement(By.cssSelector(".sprite-icon-blog"));
		String vPageTytle_FTD_Blog = "FTD.com - Floral tips, design, inspiration, and ideas from FTD";
		SocialNetworkingImageCheck(driver, obj_FTD_Blog, vPageTytle_FTD_Blog);
	}

	// this is a reusable method which is reused to create TestNG test.
	public static void SocialNetworkingImageCheck(WebDriver driver, WebElement obj_Facebook, String vPageTytle) {
		try {
			// obj_Facebook =
			// driver.findElement(By.cssSelector(".sprite-icon-facebook"));
			boolean v_Facebook = obj_Facebook.isDisplayed();
			System.out.println(v_Facebook);
			if (v_Facebook) {
				// making the image click able (below 2 lines)
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("arguments[0].scrollIntoView()", obj_Facebook);
				obj_Facebook.click();
				waitTime(3000);
				// dealing with 2 tabs
				ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
				driver.switchTo().window(tabs2.get(1));
				waitTime(5000);
				System.out.println(driver.getTitle());
				// checkpoint: checking the new tab opens facebook home page
				// (below 1 line).
				Assert.assertEquals(vPageTytle, driver.getTitle());
				driver.close(); // closing the 2nd Tab that contains Facebook
				driver.switchTo().window(tabs2.get(0));
			}
		} catch (Exception e) {
			Assert.fail("FaceBook image did not work properly");
		}
	}

	// Requirement 111: Verify that Analyst Coverage of Investor relation
	// displays.
	@Test(enabled = true)
	public void TC_111_AnalystCoverage() {
		String vBaseURL = "https://www.ftd.com/roses-ctg/product-roses-alt4";
		String wBrowser = "CHROME";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver(wBrowser, vBaseURL);
		waitTime(10000);

		WebElement obj_InvestorRelations = driver.findElement(By.linkText("Investor Relations"));
		boolean v_InvestorRelations = obj_InvestorRelations.isDisplayed();
		if (v_InvestorRelations == true) {
			// making the image click able (below 2 lines)
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].scrollIntoView()", obj_InvestorRelations);
			obj_InvestorRelations.click();
			waitTime(3000);
		} else {
			Assert.fail("Investor Relations link was not clicked.");
		}
		// dealing with 2 tabs
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1)); // getting the 2nd browser tab.
		waitTime(5000);
		// System.out.println(driver.getTitle());
		String v_StockPrice = driver.findElement(By.className("price")).getText();
		System.out.println("Today's stock price is " + v_StockPrice);
		WebElement obj_InvestorRelationTab = driver.findElement(By.id("current"));
		// mouseover on the tab
		Actions action = new Actions(driver);
		action.moveToElement(obj_InvestorRelationTab).build().perform();
		waitTime(4000);
		WebElement obj_StockInfo = driver.findElement(By.linkText("Stock Information"));
		// mouseover on the tab
		action.moveToElement(obj_StockInfo).build().perform();
		waitTime(4000);
		WebElement obj_AnalyseCoverage = driver.findElement(By.linkText("Analyst Coverage"));
		obj_AnalyseCoverage.click();
		WebElement obj_AnalystCoverageTable = driver.findElement(By.xpath(
				"//*[@id=\"block-nir-pid1451-content\"]/article/div/div/div/div/div/div/div/div[1]/div/div/div[2]/table/tbody"));
		System.out.println(obj_AnalystCoverageTable.getText());
		driver.close(); // closing 2nd Browser tab.
		driver.switchTo().window(tabs2.get(0)); // getting 1st browser tab.
		System.out.println(driver.getTitle()); // checking first Browser tab is
												// open.
		Assert.assertEquals("Roses", driver.getTitle()); // checkpoint.
		driver.quit(); // closing 1st tab and killing the process.
	}

	// Requirement 111: Verify that Social Networking images display on homepage
	// and works using Page Factory.
	@FindBy(how = How.CSS, using = ".sprite-icon-facebook")
	private WebElement obj_Facebook;
	@FindBy(how = How.CSS, using = ".sprite-icon-twitter")
	private WebElement obj_Twitter;
	@FindBy(how = How.CSS, using = ".sprite-icon-pinterest")
	private WebElement obj_Pign;
	@FindBy(how = How.CSS, using = ".sprite-icon-youtube")
	private WebElement obj_Youtube;
	@FindBy(how = How.CSS, using = ".sprite-icon-google")
	private WebElement obj_Google;
	@FindBy(how = How.CSS, using = ".sprite-icon-instagram")
	private WebElement obj_Instagram;
	@FindBy(how = How.CSS, using = ".sprite-icon-blog")
	private WebElement obj_FTD_Blog;

	@Test(enabled = true)
	public void Tc_110_SNI_UsingFindBy() {
		String vBaseURL = "https://www.ftd.com/roses-ctg/product-roses-alt4";
		String wBrowser = "FIREFOX";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver(wBrowser, vBaseURL);
		waitTime(10000);
		PageFactory.initElements(driver, this); // initializing elements inside
												// this testNG which were
												// created class level using
												// FindBy or Page Factory.
		// Checking if Facebook image display or not and Clicking on the image
		// open new tab or not.
		System.out.println(obj_Facebook.getTagName());
		String vPageTytle = "FTD Flowers - Home | Facebook";
		SocialNetworkingImageCheck(driver, obj_Facebook, vPageTytle);

		// Checking if Twitter image display or not and Clicking on the image
		// open new tab or not.
		String vPageTytle_Twitter = "FTD Flowers (@ftdflowers) | Twitter";
		SocialNetworkingImageCheck(driver, obj_Twitter, vPageTytle_Twitter);

		// Checking if Pign image display or not and Clicking on the image
		// open new tab or not.
		String vPageTytle_Pign = "FTD Flowers (ftdflowers) on Pinterest";
		SocialNetworkingImageCheck(driver, obj_Pign, vPageTytle_Pign);

		// Checking if Youtube image display or not and Clicking on the image
		// open new tab or not.
		String vPageTytle_Youtube = "FTD Flowers - YouTube - YouTube";
		SocialNetworkingImageCheck(driver, obj_Youtube, vPageTytle_Youtube);

		// Checking if Google image display or not and Clicking on the image
		// open new tab or not.
		String vPageTytle_Google = "FTD Flowers - Google+";
		SocialNetworkingImageCheck(driver, obj_Google, vPageTytle_Google);

		// Checking if Instagram image display or not and Clicking on the image
		// open new tab or not.
		String vPageTytle_Instagram = "FTD Flowers (@ftdflowers) � Instagram photos and videos";
		SocialNetworkingImageCheck(driver, obj_Instagram, vPageTytle_Instagram);

		// Checking if FTD_Blog image display or not and Clicking on the image
		// open new tab or not.
		String vPageTytle_FTD_Blog = "FTD.com - Floral tips, design, inspiration, and ideas from FTD";
		SocialNetworkingImageCheck(driver, obj_FTD_Blog, vPageTytle_FTD_Blog);
	}

}
