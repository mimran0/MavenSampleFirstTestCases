package amazon;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.os.WindowsUtils;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import afterLoginIn.CommonAPI;
import junit.framework.Assert;

public class TestSetAmazon extends afterLoginIn.CommonAPI {

	// this method will be executed before every test
	@BeforeMethod
	public void SetUpPreDataMethod() {
		System.out.println("Before Each Test  executed");
		WindowsUtils.killByName("chromedriver.exe");
	}

	// Requirement 101: Users are able to search in amazon website
	@Test(enabled = true)
	public void SearchOnLandingPage() {
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
		String vBaseURL = "https://www.amazon.com";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver(vBaseURL);
		waitTime(5000);
		// driver.manage().window().maximize(); //commenting out as Google
		// Chrome version 62 is not supported

		for (int i = 0; i < list.length; i++) {
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys(list[i]);
			waitTime(3000);
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
			driver.findElement(By.id("twotabsearchtextbox")).clear();
		}

	}

	// Requirement 102: Select all values from the search drop down list
	@Test(enabled = true)
	public void TC_102() {
		String vBaseURL = "https://www.amazon.com";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver(vBaseURL);
		waitTime(5000);

		int i;
		i = 0;
		while (i <= 50) {
			Select dropdown2 = new Select(driver.findElement(By.id("searchDropdownBox")));
			dropdown2.selectByVisibleText("All Departments");
			// Hit enter from the keyboard starts here
			Robot r = null;
			try {
				r = new Robot();
			} catch (AWTException e) {

			}
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			// Hit enter from the keyboard Ends here
			waitTime(2000);
			Select dropdown = new Select(driver.findElement(By.id("searchDropdownBox")));
			dropdown.selectByIndex(i);
			waitTime(1000);
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys("bra");
			waitTime(3000);
			// Hit enter from the keyboard starts here
			// Robot r = null;
			try {
				r = new Robot();
			} catch (AWTException e) {

			}
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			// Hit enter from the keyboard Ends here
			waitTime(5000);
			driver.findElement(By.id("twotabsearchtextbox")).clear();
			i++;
		}
	}

	// Requirement 103: Random Clicks
	@SuppressWarnings("deprecation")
	@Test(enabled = true)
	public void TestCase_103() {
		String vBaseURL = "https://www.amazon.com";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver(vBaseURL);
		waitTime(5000);
		// Clicking on "Countdown to Black Friday Free Shipping"
		driver.findElement(By.xpath("//*[@id=\"navSwmHoliday\"]/a")).click();
		System.out.println(driver.findElement(By.id("top")).getText());
		String vCheckpointValue = driver.findElement(By.id("top")).getText();
		String vResult;
		if (vCheckpointValue.contains("Countdown to Black Friday")) {
			vResult = "Pass";
			System.out.println("Passed");
		} else {
			vResult = "Fail";
		}
		Assert.assertEquals("Pass", vResult);
		// go back to homepage
		driver.findElement(By.id("nav-logo")).click();
		// ******************************************************************************************
		driver.findElement(By.xpath("//*[@id=\"nav-orders\"]/span[2]")).click();
		waitTime(2000);
		driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[1]/div[1]/div/a/i")).click();
		// ******************************************************************************************
		driver.findElement(By.id("nav-recently-viewed")).click();
		String vCheckpointValue2 = driver.findElement(By.id("ybh_center")).getText();
		String vResult2 = null;
		if (vCheckpointValue2.contains("Browsing history")) {
			vResult2 = "Pass";
			System.out.println("Passed");
		} else {
			vResult2 = "Fail";
		}
		Assert.assertEquals("Pass", vResult2);
		// go back to homepage
		driver.findElement(By.id("nav-logo")).click();
		// *****************************************************************************************
		driver.findElement(By.id("nav-your-amazon")).click();
		waitTime(2000);
		driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[1]/div[1]/div/a/i")).click();
		// go back to homepage
		driver.findElement(By.id("nav-logo")).click();
		// **********************************************************************************
		driver.findElement(By.xpath("//*[@id=\"nav-cart\"]/span[3]")).click();
		String vOutput = driver.findElement(By.id("sc-active-cart")).getText();
		boolean isExist = vOutput.contains("Your Shopping Cart is empty.");
		Assert.assertEquals(true, isExist);
		// go back to homepage
		driver.findElement(By.id("nav-logo")).click();
	}

	// Requirement 104: scroll down and up on the homepage
	@Test(enabled = true)
	public void TestCase_104() {
		String vBaseURL = "https://www.amazon.com";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver(vBaseURL);
		waitTime(5000);
		ScrollDownAndUp(driver, 1000); // scroll down and up
	}

	// Requirement 105: Highlight all links on the home page
	@Test(enabled = true)
	public void TestCase_105() {
		String vBaseURL = "https://www.amazon.com";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver("CHROME", vBaseURL);
		waitTime(5000);
		java.util.List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		for (WebElement v : links) {
			System.out.println(v.getText()); // printing out the text property
												// value of those links
			// highlight those elements/(Links)
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].style.border='3px solid red'", v);

		}
		ScrollDownAndUp(driver, 1000); // scroll down and up
	}

	// Requirement 106: drop down and up on the home page
	@Test(enabled = true)
	public void TestCase_106_UpAndDown() {
		String vBaseURL = "https://www.amazon.com";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver(vBaseURL);
		waitTime(5000);
		ScrollDownAndUp(driver, 1000);
	}

}
