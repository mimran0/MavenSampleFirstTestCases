package FTD;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.os.WindowsUtils;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import afterLoginIn.CommonAPI;
import junit.framework.Assert;

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
			CAPTURESCREEN( driver, "FTD"+v);
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

}
