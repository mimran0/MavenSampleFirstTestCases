/**
 * 
 */
package MarriottAll;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.os.WindowsUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import afterLoginIn.CommonAPI;
import junit.framework.Assert;

/**
 * @author md shahajada imran
 *
 */
public class MarriottAllTestSet extends CommonAPI {
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

	// Requirement 101: Verify that users are able to select "Our Brands" tab
	// using Keyboard inputs in homepage.
	@Test(enabled = false)
	public void TC_101_SelectByKeybordInput() {
		String vBaseURL = "https://www.marriott.com/default.mi";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver("FIREFOX", vBaseURL);
		waitTime(4000);
		// dealing PopUp window One
		try {
			WebElement obj_PopUpWindowOne = driver
					.findElement(By.xpath("//button[@class='mtaCoachMarkClose m-modal-close mfp-close is-hover-fix']"));
			HighLight_Element(driver, obj_PopUpWindowOne);
			obj_PopUpWindowOne.click();
			waitTime(3000);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// Hit 3 TABS and 1 enter from the keyboard starts here
		Robot r = null;
		try {
			r = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		// Hit 3 TABS and 1 enter from the keyboard Ends here
		CAPTURESCREEN(driver, "Marriott Brands");

		// Checkpoint starts here
		List<String> myList = new ArrayList<String>();
		myList.add("RZ");
		myList.add("XR");
		myList.add("EB");
		myList.add("LC");
		myList.add("BG");
		myList.add("WH");
		myList.add("JW");
		myList.add("MC");
		myList.add("SI");
		myList.add("MV");
		myList.add("DE");
		myList.add("MD");
		myList.add("WI");
		myList.add("AK");
		myList.add("DS");
		myList.add("BR");
		for (String v : myList) {
			WebElement MyB = driver.findElement(By.cssSelector("li[class$='" + v + "']"));
			HighLight_Element(driver, MyB);
			boolean isDisplayed = MyB.isDisplayed();
			if (isDisplayed == true) {
				System.out.println(v + " passed");
			} else {
				System.out.println(v + " did not displayed");
				// Assert.fail(v);
			}
		}
		// Checkpoint Ends here
	}

	// Requirement 102: Verify that users are able to select "Our Brands" tab.
	@Test(enabled = false)
	public void TC_102_TBD() {
		String vBaseURL = "https://www.marriott.com/default.mi";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver("IE", vBaseURL);
		waitTime(4000);

		// dealing PopUp window One
		try {
			WebElement obj_PopUpWindowOne = driver
					.findElement(By.xpath("//button[@class='mtaCoachMarkClose m-modal-close mfp-close is-hover-fix']"));
			HighLight_Element(driver, obj_PopUpWindowOne);
			obj_PopUpWindowOne.click();
			waitTime(3000);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// Clicking on the "Our Brands" tab
		WebElement myObject = driver
				.findElement(By.xpath("/html/body/div[5]/header/div/div[2]/div/div[4]/div/div[2]/ul/li[4]/a/p"));
		HighLight_Element(driver, myObject);
		myObject.click();

		// Checkpoint starts here
		List<String> myList = new ArrayList<String>();
		myList.add("RZ");
		myList.add("XR");
		myList.add("EB");
		myList.add("LC");
		myList.add("BG");
		myList.add("WH");
		myList.add("JW");
		myList.add("MC");
		myList.add("SI");
		myList.add("MV");
		myList.add("DE");
		myList.add("MD");
		myList.add("WI");
		myList.add("AK");
		myList.add("DS");
		myList.add("BR");
		for (String v : myList) {
			WebElement MyB = driver.findElement(By.cssSelector("li[class$='" + v + "']"));
			HighLight_Element(driver, MyB);
			boolean isDisplayed = MyB.isDisplayed();
			if (isDisplayed == true) {
				System.out.println(v + " passed");
			} else {
				System.out.println(v + " did not displayed");
				// Assert.fail(v);
			}
		}
		// Checkpoint Ends here
	}

	@Test(enabled = true, dataProvider = "testData_L")
	public void TC_102_ParametarizationViaDataProvider(String wBrowser) {
		String vBaseURL = "https://www.marriott.com/default.mi";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver(wBrowser, vBaseURL);
		waitTime(4000);

		// dealing PopUp window One
		try {
			WebElement obj_PopUpWindowOne = driver
					.findElement(By.xpath("//button[@class='mtaCoachMarkClose m-modal-close mfp-close is-hover-fix']"));
			HighLight_Element(driver, obj_PopUpWindowOne);
			obj_PopUpWindowOne.click();
			waitTime(3000);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// Clicking on the "Our Brands" tab
		WebElement myObject = driver
				.findElement(By.xpath("/html/body/div[5]/header/div/div[2]/div/div[4]/div/div[2]/ul/li[4]/a/p"));
		HighLight_Element(driver, myObject);
		myObject.click();

		// Checkpoint starts here
		List<String> myList = new ArrayList<String>();
		myList.add("RZ");
		myList.add("XR");
		myList.add("EB");
		myList.add("LC");
		myList.add("BG");
		myList.add("WH");
		myList.add("JW");
		myList.add("MC");
		myList.add("SI");
		myList.add("MV");
		myList.add("DE");
		myList.add("MD");
		myList.add("WI");
		myList.add("AK");
		myList.add("DS");
		myList.add("BR");
		for (String v : myList) {
			WebElement MyB = driver.findElement(By.cssSelector("li[class$='" + v + "']"));
			HighLight_Element(driver, MyB);
			boolean isDisplayed = MyB.isDisplayed();
			if (isDisplayed == true) {
				System.out.println(v + " passed");
			} else {
				System.out.println(v + " did not displayed");
				// Assert.fail(v);
			}
		}
		// Checkpoint Ends here
	}

	@DataProvider
	public Object[][] testData_L() {
		return new Object[][] {
				               // wBrowser
				new Object[] { "CHROME" }, 
				new Object[] { "FIREFOX" },
				new Object[] { "IE", },
				new Object[] { "MICROSOFE EDGE", },
				new Object[] { "MICROSOFE EDGE", }, 
				};
	}

}
