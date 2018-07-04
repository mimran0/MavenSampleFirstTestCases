/**
 * 
 */
package Google;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.os.WindowsUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import afterLoginIn.CommonAPI;
import sun.util.calendar.BaseCalendar.Date;

/**
 * @author md shahajada imran
 *
 */
public class TestSet_Google extends afterLoginIn.CommonAPI {
	// this method will be executed before every test
	@BeforeMethod
	public void SetUpPreDataMethod() {
		System.out.println("Before Each Test  executed");
		WindowsUtils.killByName("chromedriver.exe");
		WindowsUtils.killByName("MicrosoftEdge.exe");
		WindowsUtils.killByName("firefox.exe");
		WindowsUtils.killByName("iexplore.exe");
	}

	// Requirement 101: Users are able to search and get search result count.
	@Test(enabled = true)
	public void TC_101_SearchResultCount() {
		String vBaseURL = "https://www.Google.com/";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver("FIREFOX", vBaseURL);
		waitTime(5000);
		driver.findElement(By.id("lst-ib")).sendKeys("md shahajada imran");
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
		waitTime(4000);
		String vResult = driver.findElement(By.id("resultStats")).getText();
		HighLight_Element(driver, driver.findElement(By.id("resultStats")));
		System.out.println("Total Result is " + vResult);

		driver.findElement(By.linkText("Images")).click();
		waitTime(2000);
		driver.findElement(By.cssSelector("#-RuDDh1zOE1eKM\\:")).click();
		waitTime(1000);
		driver.findElement(By.id("irc_cb")).click();
		driver.quit();
	}

	// requirement 102: Users are able to mouseover and see Lucky texts.
	@Test(enabled = true)
	public void TC_102_LuckyTexts() {
		String vBaseURL = "https://www.Google.com/";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver("FIREFOX", vBaseURL);
		waitTime(5000);

		// mouseover
		Actions action = new Actions(driver);
		WebElement obj_Lucky_Text = driver.findElement(By.id("gbqfbb"));
		action.moveToElement(obj_Lucky_Text).build().perform();
		waitTime(2000);

		String My_Lucky_Text = obj_Lucky_Text.getText();
		System.out.println(My_Lucky_Text + " is my Lucky Test at " + java.time.LocalDate.now());
		CAPTURESCREEN(driver, "Google" + java.time.LocalDate.now());
	}

	// Requirement 103: Users are able to navigate to Hangout page and scroll
	// down on the page.
	@Test(enabled = true)
	public void TC_103_HangOut() {
		String vBaseURL = "https://www.Google.com/";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver("FIREFOX", vBaseURL);
		waitTime(5000);
		WebElement apps = driver.findElement(By.cssSelector(".gb_b"));
		HighLight_Element(driver, apps);
		apps.click();
		waitTime(2000);
		driver.findElement(By.linkText("More")).click();
		waitTime(3000);
		driver.findElement(By.cssSelector("#gb300 > span:nth-child(5)")).click();
		scrolldown(driver, 900);
		driver.findElement(By.cssSelector(".g-Ue-oj-fj-Ab-f")).click();
		waitTime(2000);
		driver.quit();
	}

	// requirement 104: tbd
	@Test(enabled = true)
	public void TC_104_TBD() {
		String vBaseURL = "https://www.Google.com/";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver("FIREFOX", vBaseURL);
		waitTime(5000);
	}

}
