package levis;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.os.WindowsUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import afterLoginIn.CommonAPI;

public class TestSetH extends afterLoginIn.CommonAPI {
	// this method will be executed before every test
	@BeforeMethod
	public void SetUpPreDataMethod() {
		System.out.println("Before Each Test  executed");
		WindowsUtils.killByName("chromedriver.exe");
		WindowsUtils.killByName("MicrosoftEdge.exe");
		WindowsUtils.killByName("firefox.exe");
		WindowsUtils.killByName("iexplore.exe");
	}

	// Requirement 101: Users are able to mouse over on major web elements on
	// the home page
	@Test(enabled = true)
	public void TC101_MouseOver_OnMajorElements() {
		String vBaseURL = "http://www.levi.com/US/en_US/";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver("FIREFOX", vBaseURL);
		waitTime(25000);

		// taking care of pop up wind starts here
		try {
			boolean isPopUpWindowExist = driver.findElement(By.id("EmailSignupForm")).isDisplayed();
			// System.out.println(isPopUpWindowExist);
			if (!isPopUpWindowExist) {
				// finding object using XPATH
				WebElement obj = driver.findElement(By.xpath("/html/body/div[18]/div[2]/div/span"));
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("arguments[0].style.border='3px solid red'", obj);
				waitTime(5000);
				obj.click();
			}
		} catch (Exception e) {
			System.out.println("Script is unable to find popup window or popup window did not displayed");
		}
		// taking care of pop up window ends here
		// mouse over on major web elements
		String[] list = new String[7];
		list[0] = "Levi_Men_Nav_US";
		list[1] = "Levi_Women_Nav_US";
		list[2] = "Levi_Kids_Nav_US";
		list[3] = "Levi_501_Nav_US";
		list[4] = "Levis_US_511";
		list[5] = "Levi_US_SpecialSizes";
		list[6] = "Levi_Sale_Nav_US";
		// mouseover
		for (String v : list) {
			Actions action = new Actions(driver);
			WebElement we = driver.findElement(By.id(v));
			action.moveToElement(we).build().perform();
			waitTime(2000);
		}
	}

	// Requirement 102: scroll down and up on homepage
	@Test(enabled = true)
	public void TC_102_scrollUpAndDown() {
		String vBaseURL = "http://www.levi.com/US/en_US/";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver("FIREFOX", vBaseURL);
		waitTime(25000);
		// taking care of pop up wind starts here
		try {
			boolean isPopUpWindowExist = driver.findElement(By.id("EmailSignupForm")).isDisplayed();
			// System.out.println(isPopUpWindowExist);
			if (!isPopUpWindowExist) {
				// finding object using XPATH
				WebElement obj = driver.findElement(By.xpath("/html/body/div[18]/div[2]/div/span"));
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("arguments[0].style.border='3px solid red'", obj);
				waitTime(5000);
				obj.click();
			}
		} catch (Exception e) {
			System.out.println("Script is unable to find popup window or popup window did not displayed");
		}
		// taking care of pop up window ends here
		ScrollDownAndUp(driver, 1000);
	}

	// Requirement 103: Users are able to view womens dress
	@Test(enabled = true)
	public void TC_103_womens_dress() {
		String vBaseURL = "http://www.levi.com/US/en_US/";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver("FIREFOX", vBaseURL);
		waitTime(25000);
		// taking care of pop up wind starts here
		try {
			boolean isPopUpWindowExist = driver.findElement(By.id("EmailSignupForm")).isDisplayed();
			// System.out.println(isPopUpWindowExist);
			if (!isPopUpWindowExist) {
				// finding object using XPATH
				WebElement obj = driver.findElement(By.xpath("/html/body/div[18]/div[2]/div/span"));
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("arguments[0].style.border='3px solid red'", obj);
				waitTime(5000);
				obj.click();
			}
		} catch (Exception e) {
			System.out.println("Script is unable to find popup window or popup window did not displayed");
		}
		// taking care of pop up window ends here
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.id("Levi_Women_Nav_US"));
		action.moveToElement(we).build().perform();
		waitTime(2000);
		driver.findElement(By.id("Levi_Women_Dresses")).click();
		waitTime(2000);
		ScrollDownAndUp(driver, 1000);
	}

	// Requirement 104: Find stores map in 2nd tab
	@Test(enabled = true)
	public void TC_104_FindStoresMap() {
		String vBaseURL = "http://www.levi.com/US/en_US/";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver("FIREFOX", vBaseURL);
		waitTime(25000);
		// taking care of pop up wind starts here
		try {
			boolean isPopUpWindowExist = driver.findElement(By.id("EmailSignupForm")).isDisplayed();
			// System.out.println(isPopUpWindowExist);
			if (!isPopUpWindowExist) {
				// finding object using XPATH
				WebElement obj = driver.findElement(By.xpath("/html/body/div[18]/div[2]/div/span"));
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("arguments[0].style.border='3px solid red'", obj);
				waitTime(5000);
				obj.click();
				waitTime(2000);
			}
		} catch (Exception e) {
			System.out.println("Script is unable to find popup window or popup window did not displayed");
		}
		// taking care of pop up window ends here
		driver.findElement(By.id("storeTopNav")).click();
		waitTime(2000);
		// dealing with 2 tabs
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		scrolldown(driver, 700);
		driver.close(); // closing the 2nd Tab
		driver.switchTo().window(tabs2.get(0));
		scrolldown(driver, 900);
	}

	// Technical Requirement 105: Display link count in console and highlight
	// all links
	@Test(enabled = true)
	public void TC_105_HighlightAllLinks() {
		String vBaseURL = "http://www.levi.com/US/en_US/";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver("FIREFOX", vBaseURL);
		waitTime(25000);
		// taking care of pop up wind starts here
		try {
			boolean isPopUpWindowExist = driver.findElement(By.id("EmailSignupForm")).isDisplayed();
			// System.out.println(isPopUpWindowExist);
			if (!isPopUpWindowExist) {
				// finding object using XPATH
				WebElement obj = driver.findElement(By.xpath("/html/body/div[18]/div[2]/div/span"));
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("arguments[0].style.border='3px solid red'", obj);
				waitTime(5000);
				obj.click();
				waitTime(2000);
			}
		} catch (Exception e) {
			System.out.println("Script is unable to find popup window or popup window did not displayed");
		}
		// taking care of pop up window ends here

		java.util.List<WebElement> links = driver.findElements(By.tagName("a"));

		System.out.println(links.size());
		for (WebElement v : links) {
			System.out.println(v.getText()); // printing out the text property
												// value of those links
			// highlight those elements/(Links)
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].style.border='3px solid red'", v);
		}
		scrolldown(driver, 900);
		CAPTURESCREEN (driver);
	}

}
