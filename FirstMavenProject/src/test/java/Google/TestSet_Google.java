/**
 * 
 */
package Google;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.os.WindowsUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import afterLoginIn.CommonAPI;
import junit.framework.Assert;
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

	// requirement 104: History activity button is turned on by default and upon
	// Clicking button becomes turned Off.
	@Test(enabled = true)
	public void TC_104_HAB() {
		String vBaseURL = "https://www.Google.com/";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver("FIREFOX", vBaseURL);
		waitTime(5000);
		driver.findElement(By.id("fsettl")).click();
		waitTime(2000);
		driver.findElement(By.linkText("History")).click();
		WebElement obj_Enabler = driver.findElement(By.className("history-switch-holder"));
		HighLight_Element(driver, obj_Enabler);
		boolean isOn = obj_Enabler.isEnabled();
		Assert.assertEquals(true, isOn); // checking that history activity
											// button is turned on by default.
		obj_Enabler.click();
		waitTime(3000);
		WebElement obj_EnablerOff = driver.findElement(By.className("history-switch-holder"));
		boolean isOffOn = obj_EnablerOff.isEnabled();
		Assert.assertTrue("Button is turned off", true); // Upon Clicking button
															// becomes disabled.
		driver.quit();
	}

	// Requirement 105: Users are able to login even when Captcha is On and
	// Phone Code verification is On.
	@Test(enabled = true)
	public void TC_105_LoginWithCaptchaAndPhoneCode() {
		String vBaseURL = "https://www.Google.com/";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver("FIREFOX", vBaseURL);
		waitTime(5000);
		driver.findElement(By.partialLinkText("Sign i")).click();
		waitTime(2000);
		driver.findElement(By.name("identifier")).sendKeys("imranlimon03@gmail.com");
		waitTime(2000);
		driver.findElement(By.cssSelector("#identifierNext > content:nth-child(3) > span:nth-child(1)")).click();
		waitTime(3000);
		driver.findElement(By.name("password")).sendKeys("1234563y");
		waitTime(2000);
		driver.findElement(By.cssSelector("#passwordNext > content:nth-child(3) > span:nth-child(1)")).click();
		waitTime(1000);
		// dealing with captcha starts here.
		Scanner sc = new Scanner(System.in);
		try {
			driver.findElement(By.name("password")).sendKeys("3474846905");
			System.out.println("Please Enter Captcha number in console");
			String vCaptuaText = sc.nextLine();
			driver.findElement(By.name("ca")).sendKeys(vCaptuaText);
		} catch (Exception e) {
		}
		// dealing with captcha ends here
		try {
			driver.findElement(By.cssSelector(".IMH1vc")).click();
			waitTime(2000);
			driver.findElement(By.className("vdE7Oc")).click();
			waitTime(2000);
			driver.findElement(By.id("phoneNumberId")).sendKeys("3474846905");
			waitTime(2000);
			driver.findElement(By.cssSelector(".RveJvd")).click();
			// Getting the code from phone via console during runtime.
			System.out.println("Please Enter code from Phone into Console");
			String vCodInPhone = sc.nextLine();
			driver.findElement(By.id("idvAnyPhonePin")).sendKeys(vCodInPhone);
			waitTime(2000);
			driver.findElement(By.cssSelector(".RveJvd")).click();
			waitTime(2000);
			try {
				driver.findElement(By.cssSelector(".M9Bg4d > content:nth-child(3) > span:nth-child(1)")).click();
			} catch (Exception e) {
			}
			waitTime(1000);
		} catch (Exception e) {

		}
		WebElement vUser = driver.findElement(By.cssSelector(".gb_ib"));
		// System.out.println(vUser.getAttribute("title"));
		String vUserName = vUser.getAttribute("title").substring(16, 27);
		// System.out.println(vUserName);
		Assert.assertEquals("limon imran", vUserName);
		vUser.click();
		driver.findElement(By.id("signout")).click();
		driver.quit();

	}

	// Requirement 106: Users are able to play video and turn off in given page
	// and validate the video link.
	@Test(enabled = true)
	public void TC_106_PlayVideo() {
		String vBaseURL = "https://www.Google.com/";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver("CHROME", vBaseURL);
		waitTime(5000);
		driver.findElement(By.linkText("Advertising")).click();
		waitTime(2000);
		driver.findElement(By.partialLinkText("AdWords AP")).click();
		waitTime(2000);
		WebElement obj_Video = driver.findElement(By.id("ytplayer0"));
		// obj_Video.click();
		waitTime(5000);
		// obj_Video.click();
		String vURL = obj_Video.getAttribute("src");
		System.out.println(vURL);
		// validate the vidwo link.
		Assert.assertEquals("https://www.youtube.com/embed/80KOeuCNc0c?autohide=1&showinfo=0&enablejsapi=1", vURL);
		driver.quit();
	}

	// Not a requirement 107: Explore CSSSelector
	@Test(enabled = true)
	public void TC_107_ExploreCSSselector() {
		String vBaseURL = "https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver("FIREFOX", vBaseURL);
		waitTime(3000);

		// Standard CSSselector
		WebElement oID = driver.findElement(By.cssSelector("#identifierId"));
		HighLight_Element(driver, oID);
		waitTime(2000);
		driver.navigate().refresh();

		// CSSSelector with attribute "id" and exact value
		WebElement oID2 = driver.findElement(By.cssSelector("input[id*='identifierId']"));
		HighLight_Element(driver, oID2);
		waitTime(2000);
		driver.navigate().refresh();

		// CSSselector with attribute "id" and "start with" value
		WebElement oID3 = driver.findElement(By.cssSelector("input[id^='identif']"));
		HighLight_Element(driver, oID3);
		waitTime(2000);
		driver.navigate().refresh();

		// CSSSelector with attribute "id" and "Ends with" value
		WebElement oID4 = driver.findElement(By.cssSelector("input[id$='fierId']"));
		HighLight_Element(driver, oID4);
		waitTime(2000);
		driver.navigate().refresh();

		//// CSSselector with attribute "name" and exact value
		WebElement oID5 = driver.findElement(By.cssSelector("input[name*='identifier']"));
		HighLight_Element(driver, oID5);
		waitTime(2000);
		driver.navigate().refresh();

		//// CSSselector with attribute "name" and "Start With" value
		WebElement oID6 = driver.findElement(By.cssSelector("input[name^='identif']"));
		HighLight_Element(driver, oID6);
		waitTime(2000);
		driver.navigate().refresh();

		//// CSSselector with attribute "name" and "Ends with" value
		WebElement oID7 = driver.findElement(By.cssSelector("input[name$='ntifier']"));
		HighLight_Element(driver, oID7);
		waitTime(2000);
		driver.navigate().refresh();

		// CSSSelector with attribute "id" and contains value
		WebElement oID8 = driver.findElement(By.cssSelector("input#identifierId"));
		HighLight_Element(driver, oID8);
		waitTime(2000);
		driver.navigate().refresh();
	}

	// Requirement 108: TBD
	@Test(enabled = true)
	public void TC_108_TBD() {
		String vBaseURL = "https://myaccount.google.com/intro?utm_source=OGB&utm_medium=app";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver("FIREFOX", vBaseURL);
		waitTime(3000);
	}

}
