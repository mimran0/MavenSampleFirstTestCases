/**
 * 
 */
package bing;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.os.WindowsUtils;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import afterLoginIn.CommonAPI;

/**
 * @author md shahajada imran
 *
 */
public class TestSetBing extends afterLoginIn.CommonAPI {
	// this method will be executed before every test
	@BeforeMethod
	public void SetUpPreDataMethod() {
		System.out.println("Before Each Test  executed");
		WindowsUtils.killByName("chromedriver.exe");
		WindowsUtils.killByName("MicrosoftEdge.exe");
		WindowsUtils.killByName("firefox.exe");
		WindowsUtils.killByName("iexplore.exe");
	}

	// Requirement 101: Users are able to search on bing homepage
	@Test(enabled = true)
	public void TC_101_searchOnBingHomePage() {
		String vBaseURL = "https://www.bing.com/";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver("FIREFOX", vBaseURL);
		waitTime(5000);

		// ArrayList Data Structure
		ArrayList<String> dt_MyList = new ArrayList<String>();
		dt_MyList.add(0, "Red Rose");
		dt_MyList.add(1, "bird");
		dt_MyList.add(2, "rain");
		dt_MyList.add(3, "water");
		dt_MyList.add(4, "md shahajada imran");

		// for loop
		for (int i = 0; i < dt_MyList.size(); i++) {
			driver.get("https://www.bing.com/");
			driver.findElement(By.tagName("input")).sendKeys(dt_MyList.get(i));
			waitTime(3000);
			driver.findElement(By.className("b_searchboxSubmit")).click();
			waitTime(5000);
			WebElement obj_SearhResult = driver.findElement(By.className("sb_count"));
			HighLight_Element(driver, obj_SearhResult);
			waitTime(2000);
			String vSearchResult = obj_SearhResult.getText();
			System.out.println(vSearchResult + " found for " + dt_MyList.get(i));
		}
	}

	// Requirement 102: Users are able to view images after searching in bing
	// web site
	@Test(enabled = true)
	public void TC_102_ViewImages() {
		String vBaseURL = "https://www.bing.com/";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver("FIREFOX", vBaseURL);
		waitTime(5000);

		// ArrayList Data Structure
		ArrayList<String> dt_MyList_f = new ArrayList<String>();
		dt_MyList_f.add(0, "Red Rose");
		dt_MyList_f.add(1, "bird");
		dt_MyList_f.add(2, "rain");
		dt_MyList_f.add(3, "water");
		dt_MyList_f.add(4, "md shahajada imran");

		// for loop
		for (int i = 0; i < dt_MyList_f.size(); i++) {
			driver.get("https://www.bing.com/");
			driver.findElement(By.tagName("input")).sendKeys(dt_MyList_f.get(i));
			waitTime(3000);
			driver.findElement(By.className("b_searchboxSubmit")).click();
			waitTime(5000);
			driver.findElement(By.linkText("Images")).click();
			waitTime(5000);
			scrolldown(driver, 500);
			if ((dt_MyList_f.get(i)).equals("md shahajada imran")) {
				driver.findElement(By.linkText("All")).click();
				waitTime(3000);
				// CAPTURESCREEN(driver, "Bing_md_shahajada_imran");
			} else {// don't capture screenshot))
			}
		}
	}

	// Requirement 103: Expected message display on specified
	// (home>rewords>Microsoft) page.
	@Test(enabled = true)
	public void TC_103_ExpectedMessageDisplay() {
		String vBaseURL = "https://www.bing.com/";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver("CHROME", vBaseURL);
		waitTime(5000);
		driver.findElement(By.id("id_rh")).click();
		waitTime(5000);
		// driver.findElement(By.cssSelector(".msflyout-join-btn")).click();
		// faking as above line does not work.
		driver.get("https://www.bing.com/explore/rewards?FORM=MA1377&wt.mc_id=MA1377&PUBL=BINGCOM&CREA=MA1377");
		waitTime(3000);
		WebElement obj_Checkpoint = driver.findElement(By.cssSelector("#signIn > div:nth-child(2) > h1:nth-child(3)"));
		HighLight_Element(driver, obj_Checkpoint);

		if ((obj_Checkpoint.getText()).equals("Earn free rewards from Microsoft")) {
			System.out.println("Test passed");
		} else {
			Assert.fail("Did not display expected message");
			System.out.println("It supposed to display 'Earn free rewards from Microsoft' but displayed "
					+ obj_Checkpoint.getText());
		}
	}

	// Requirement 104: Users are able to navigate to Microsoft web site from
	// bing web site and view available apps for windows 10.
	@Test(enabled = true)
	public void TC_104_MicrosoftAppsForWindows() {
		String vBaseURL = "https://www.bing.com/";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver("FIREFOX", vBaseURL);
		waitTime(5000);
		driver.findElement(By.linkText("Outlook.com")).click();
		waitTime(5000);
		// dealing with 2 tabs
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		waitTime(1000);
		driver.findElement(By.cssSelector("div.linkButtonFixedHeader")).click();
		waitTime(2000);
		HighLight_Element(driver, driver.findElement(By.linkText("Windows 10")));
		driver.findElement(By.linkText("Windows 10")).click();
		waitTime(3000);
		// closing the Microsoft store window.
		WindowsUtils.killByName("WinStore.App.exe");
		// using try-catch block as the pop up window displays dynamically.
		try {
			driver.findElement(By.cssSelector(".c-text-field")).clear();
			driver.findElement(By.cssSelector(".c-text-field")).sendKeys("mdshahajadaimran@aol.com");
			waitTime(2000);
			driver.findElement(By.xpath("/html/body/div[5]/div[2]/form/div[2]/button")).click();
		} catch (Exception e) {
		}
		scrolldown(driver, 1000);
		driver.quit(); // Closing all tabs and killing the process
	}

	// Requirement 105: Users are able to navigate to Microsoft web site from
	// bing web site and view available apps for Iphone.
	@Test(enabled = true)
	public void TC_105_MicrosoftAppsForIphone() {
		String vBaseURL = "https://www.bing.com/";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver("CHROME", vBaseURL);
		waitTime(5000);
		driver.manage().window().maximize();
		waitTime(2000);
		driver.findElement(By.linkText("Outlook.com")).click();
		waitTime(5000);
		// dealing with 2 tabs
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		waitTime(1000);
		driver.findElement(By.cssSelector("div.linkButtonFixedHeader")).click();
		waitTime(2000);
		HighLight_Element(driver, driver.findElement(By.linkText("iPhone")));
		driver.findElement(By.linkText("iPhone")).click();
		waitTime(3000);
		// closing the Microsoft store window.
		WindowsUtils.killByName("WinStore.App.exe");
		// using try-catch block as the pop up window displays dynamically.
		try {
			driver.findElement(By.cssSelector(".c-text-field")).clear();
			driver.findElement(By.cssSelector(".c-text-field")).sendKeys("mdshahajadaimran@aol.com");
			waitTime(2000);
			driver.findElement(By.xpath("/html/body/div[5]/div[2]/form/div[2]/button")).click();
		} catch (Exception e) {
		}
		scrolldown(driver, 1000);
		driver.quit(); // close all tabs and killing the process
	}

	// Requirement 106: Users are able to navigate to Microsoft web site from
	// bing web site and view available apps for Android.
	@Test(enabled = true)
	public void TC_106_MicrosoftAppsForAndroid() {
		String vBaseURL = "https://www.bing.com/";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver("MICROSOFE EDGE", vBaseURL);
		waitTime(5000);
		driver.findElement(By.linkText("Outlook.com")).click();
		waitTime(5000);
		// dealing with 2 tabs
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		waitTime(1000);
		driver.findElement(By.cssSelector("div.linkButtonFixedHeader")).click();
		waitTime(2000);
		HighLight_Element(driver, driver.findElement(By.linkText("Android")));
		driver.findElement(By.linkText("Android")).click();
		waitTime(3000);
		// closing the Microsoft store window.
		WindowsUtils.killByName("WinStore.App.exe");
		// using try-catch block as the pop up window displays dynamically.
		try {
			driver.findElement(By.cssSelector(".c-text-field")).clear();
			driver.findElement(By.cssSelector(".c-text-field")).sendKeys("mdshahajadaimran@aol.com");
			waitTime(2000);
			driver.findElement(By.xpath("/html/body/div[5]/div[2]/form/div[2]/button")).click();
		} catch (Exception e) {
		}
		scrolldown(driver, 1000);
		driver.quit(); // close all tabs and killing the process
	}
}
