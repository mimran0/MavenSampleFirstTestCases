package AOL_AutomationScripts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.os.WindowsUtils;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import AOL_ObjectRepositoryAndFunctionLibrary.AOL_HomePage;
import AOL_ObjectRepositoryAndFunctionLibrary.AOL_LogOutVerificationPage;
import AOL_ObjectRepositoryAndFunctionLibrary.AOL_MailPage;
import AOL_ObjectRepositoryAndFunctionLibrary.LoginPage;
import AOL_ObjectRepositoryAndFunctionLibrary.LoginPasswordPage;
import afterLoginIn.CommonAPI;

/**
 * @author md shahajada imran
 *
 */
public class Automation_Test_SuiteOne extends afterLoginIn.CommonAPI {

	private String vMyPassword = "selenium54321"; // Always delete password
													// before make code public

	@BeforeMethod
	public void SetUpPreDataMethod() {
		System.out.println("Before Each Test  executed");
		WindowsUtils.killByName("chromedriver.exe");
		WindowsUtils.killByName("iexplore.exe");
		WindowsUtils.killByName("geckodriver.exe");
		WindowsUtils.killByName("MicrosoftWebDriver.exe");
		WindowsUtils.killByName("MicrosoftEdge.exe");
	}

	// Requirement 101: Users are able to login into AOL web site using Valid
	// Login Credentials.
	@Test(enabled = true)
	public void TC_101_LoginCheck_AutomationObjectModel() {
		String vBaseURL = "https://login.aol.com/";
		String wBrowser = "CHROME";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver(wBrowser, vBaseURL);
		waitTime(4000);
		LoginPage LoginPage = new LoginPage();
		LoginPage.ActivateAllObjectsAndMethodsOfThisPage(driver);
		waitTime(2000);
		LoginPage.obj_UserName().sendKeys("mdshahajadaimran");
		waitTime(2000);
		LoginPage.obj_NextButton().click();
		waitTime(2000);
		LoginPasswordPage LoginPasswordPage = new LoginPasswordPage();
		LoginPasswordPage.ActivateAllObjectsAndMethodsOfThisPage(driver);
		LoginPasswordPage.obj_Password().sendKeys(vMyPassword);
		waitTime(2000);
		LoginPasswordPage.obj_SignInButton().click();
		waitTime(2000);
		AOL_HomePage AOL_HomePage = new AOL_HomePage(driver);
		String vMyName = AOL_HomePage.obj_UserName().getText();
		if (vMyName.equals("mdshahajadaimran")) {
			System.out.println("Passed");
		} else {
			Assert.fail("Login Failed");
		}
		AOL_HomePage.obj_LogOut().click();
		waitTime(3000);
		AOL_LogOutVerificationPage AOL_LogOutVerificationPage = new AOL_LogOutVerificationPage(driver);
		AOL_LogOutVerificationPage.obj_Yes_sign_me_out().click();
		waitTime(2000);
		boolean isLoginOrJoinDisplayed = AOL_HomePage.obj_LoginOrJoin().isDisplayed();
		if (isLoginOrJoinDisplayed) {
			System.out.println("Log Out successfull");
		} else {
			Assert.fail("Log Out Failed");
		}
		driver.close();
		driver.quit();
	}

	// Requirement 102: Users are able to scroll down on Personal Finance news
	// page.
	@Test(enabled = true)
	public void TC_102_POM_ScrollDownOnPersonalFinancePage() {
		String vBaseURL = "https://login.aol.com/";
		String wBrowser = "CHROME";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver(wBrowser, vBaseURL);
		waitTime(4000);
		LoginPage LoginPage = new LoginPage();
		LoginPage.ActivateAllObjectsAndMethodsOfThisPage(driver);
		waitTime(2000);
		LoginPage.obj_UserName().sendKeys("mdshahajadaimran");
		waitTime(2000);
		LoginPage.obj_NextButton().click();
		waitTime(2000);
		LoginPasswordPage LoginPasswordPage = new LoginPasswordPage();
		LoginPasswordPage.ActivateAllObjectsAndMethodsOfThisPage(driver);
		LoginPasswordPage.obj_Password().sendKeys(vMyPassword);
		waitTime(2000);
		LoginPasswordPage.obj_SignInButton().click();
		waitTime(2000);
		driver.manage().window().maximize();
		AOL_HomePage AOL_HomePage = new AOL_HomePage(driver);
		HighLight_Element(driver, AOL_HomePage.obj_Finance());
		waitTime(1000);
		AOL_HomePage.obj_Finance().click();
		waitTime(2000);
		HighLight_Element(driver, AOL_HomePage.obj_PersonalFinance());
		AOL_HomePage.obj_PersonalFinance().click();
		waitTime(1000);
		scrolldown(driver, 1000);
		driver.close();
		driver.quit();
	}

	// Requirement 103: Users are able to view email count in the inbox.
	@Test(enabled = true)
	public void TC_103_POM_EmailCountInTheInbox() {
		String vBaseURL = "https://login.aol.com/";
		String wBrowser = "FIREFOX";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver(wBrowser, vBaseURL);
		waitTime(4000);
		LoginPage LoginPage = new LoginPage();
		LoginPage.ActivateAllObjectsAndMethodsOfThisPage(driver);
		waitTime(2000);
		LoginPage.obj_UserName().sendKeys("mdshahajadaimran");
		waitTime(2000);
		LoginPage.obj_NextButton().click();
		waitTime(2000);
		LoginPasswordPage LoginPasswordPage = new LoginPasswordPage();
		LoginPasswordPage.ActivateAllObjectsAndMethodsOfThisPage(driver);
		LoginPasswordPage.obj_Password().sendKeys(vMyPassword);
		waitTime(2000);
		LoginPasswordPage.obj_SignInButton().click();
		waitTime(2000);
		driver.manage().window().maximize();
		AOL_HomePage AOL_HomePage = new AOL_HomePage(driver);
		HighLight_Element(driver, AOL_HomePage.obj_Mail());
		waitTime(1000);
		AOL_HomePage.obj_Mail().click();
		waitTime(3000);
		AOL_MailPage AOL_MailPage = new AOL_MailPage(driver);
		HighLight_Element(driver, AOL_MailPage.obj_Inbox());
		waitTime(1000);
		AOL_MailPage.obj_Inbox().click();
		waitTime(2000);
		HighLight_Element(driver, AOL_MailPage.obj_EmailCount());
		waitTime(1000);
		String vEmailCount = AOL_MailPage.obj_EmailCount().getText();
		System.out.println(vEmailCount);
		vEmailCount = vEmailCount.substring(8);
		System.out.println("There are total " + vEmailCount + " emails in the inbox");

	}

	// Requirement 104: Users are able to send email.
	@Test(enabled = true)
	public void TC_104_POM_SendEmailAutomatically() {
		String vBaseURL = "https://login.aol.com/";
		String wBrowser = "FIREFOX";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver(wBrowser, vBaseURL);
		waitTime(4000);
		LoginPage LoginPage = new LoginPage();
		LoginPage.ActivateAllObjectsAndMethodsOfThisPage(driver);
		waitTime(2000);
		LoginPage.obj_UserName().sendKeys("mdshahajadaimran");
		waitTime(2000);
		LoginPage.obj_NextButton().click();
		waitTime(2000);
		LoginPasswordPage LoginPasswordPage = new LoginPasswordPage();
		LoginPasswordPage.ActivateAllObjectsAndMethodsOfThisPage(driver);
		LoginPasswordPage.obj_Password().sendKeys(vMyPassword);
		waitTime(2000);
		LoginPasswordPage.obj_SignInButton().click();
		waitTime(2000);
		driver.manage().window().maximize();
		AOL_HomePage AOL_HomePage = new AOL_HomePage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		HighLight_Element(driver, AOL_HomePage.obj_Mail());
		waitTime(1000);
		AOL_HomePage.obj_Mail().click();
		waitTime(3000);
		AOL_MailPage AOL_MailPage = new AOL_MailPage(driver);
		HighLight_Element(driver, AOL_MailPage.obj_Inbox());
		waitTime(1000);
		AOL_MailPage.obj_Inbox().click();
		waitTime(2000);
		AOL_MailPage.obj_Compose().click();
		waitTime(2000);
		AOL_MailPage.obj_Email_To().sendKeys("mdshahajadaimran@aol.com");
		Random rm = new Random();
		AOL_MailPage.obj_Email_Subject().sendKeys(rm.nextInt(10000000) + "Imran Test");
		AOL_MailPage.obj_Email_Body().sendKeys("test");
		// AOL_MailPage.obj_Email_Send().click();
		// Sending email starts here.
		Robot r = null;
		try {
			r = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_ENTER);
		// Sending email ends here.
		waitTime(5000);
		// Checkpoint
		for (int i = 0; i < 10; i++) {
			waitTime(3000);
			boolean vCheckpoint = false;
			try {
				vCheckpoint = AOL_MailPage.obj_Email_SendSucessfullMessage().isDisplayed();
			} catch (Exception e) {
			}
			if (vCheckpoint == true) {
				System.out.println("Test Passed");
				break;
			} else {
				AOL_MailPage.obj_Email_Send().click();
				if (i == 9) {
					Assert.fail("Email was not send successfully");
				}
			}
		}
		driver.close();
		WindowsUtils.killByName("geckodriver.exe");
	}

	// Requirement 105: Users are able to search after login into AOL with valid
	// credentials.
	@Test(enabled = true)
	public void TC_105_SearchCheckAfterLogin() {
		// Storing 5 string values into a LinkedList
		LinkedList<String> dsMyList = new LinkedList<String>();
		dsMyList.add(0, "red rose");
		dsMyList.add(1, "md shahajada imran");
		dsMyList.add(2, "My Pen");
		dsMyList.add(3, "Today's news");
		dsMyList.add(4, "My Love");

		String vBaseURL = "https://login.aol.com/";
		String wBrowser = "CHROME";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver(wBrowser, vBaseURL);
		waitTime(4000);
		LoginPage LoginPage = new LoginPage();
		LoginPage.ActivateAllObjectsAndMethodsOfThisPage(driver);
		waitTime(2000);
		LoginPage.obj_UserName().sendKeys("mdshahajadaimran");
		waitTime(2000);
		LoginPage.obj_NextButton().click();
		waitTime(2000);
		LoginPasswordPage LoginPasswordPage = new LoginPasswordPage();
		LoginPasswordPage.ActivateAllObjectsAndMethodsOfThisPage(driver);
		LoginPasswordPage.obj_Password().sendKeys(vMyPassword);
		waitTime(2000);
		LoginPasswordPage.obj_SignInButton().click();
		waitTime(2000);
		// driver.manage().window().maximize();
		AOL_HomePage AOL_HomePage = new AOL_HomePage(driver);
		int i = 0;
		while (i <= dsMyList.size() - 1) {
			AOL_HomePage.obj_SearchBox().clear();
			AOL_HomePage.obj_SearchBox().sendKeys(dsMyList.get(i));
			waitTime(3000);
			AOL_HomePage.obj_SearchButton().click();
			waitTime(5000);
			System.out.println(AOL_HomePage.obj_SearchResult().getText() + " found for " + dsMyList.get(i));
			HighLight_Element(driver, AOL_HomePage.obj_SearchResult());
			i++;
			driver.get("https://www.aol.com/");
		}
	}

	// Requirement 106: Users are able to search and view search result in Image
	// format.
	@Test(enabled = true)
	public void TC_106_SearchResultInImageFormate() {
		// Storing 5 string values into a LinkedList
		LinkedList<String> dsMyList = new LinkedList<String>();
		dsMyList.add(0, "red rose");
		dsMyList.add(1, "md shahajada imran");
		dsMyList.add(2, "My Pen");
		dsMyList.add(3, "Today's news");
		dsMyList.add(4, "My Love");

		String vBaseURL = "https://login.aol.com/";
		String wBrowser = "CHROME";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver(wBrowser, vBaseURL);
		waitTime(4000);
		LoginPage LoginPage = new LoginPage();
		LoginPage.ActivateAllObjectsAndMethodsOfThisPage(driver);
		waitTime(2000);
		LoginPage.obj_UserName().sendKeys("mdshahajadaimran");
		waitTime(2000);
		LoginPage.obj_NextButton().click();
		waitTime(2000);
		LoginPasswordPage LoginPasswordPage = new LoginPasswordPage();
		LoginPasswordPage.ActivateAllObjectsAndMethodsOfThisPage(driver);
		LoginPasswordPage.obj_Password().sendKeys(vMyPassword);
		waitTime(2000);
		LoginPasswordPage.obj_SignInButton().click();
		waitTime(2000);
		// driver.manage().window().maximize();
		AOL_HomePage AOL_HomePage = new AOL_HomePage(driver);
		int i = 0;
		while (i <= dsMyList.size() - 1) {
			AOL_HomePage.obj_SearchBox().clear();
			AOL_HomePage.obj_SearchBox().sendKeys(dsMyList.get(i));
			waitTime(3000);
			AOL_HomePage.obj_SearchButton().click();
			waitTime(5000);
			AOL_HomePage.obj_Images().click();
			waitTime(5000);
			scrolldown(driver, 500);
			i++;
			driver.get("https://www.aol.com/");
		}
	}

	// Requirement 107: TBD
	@Test(enabled = true)
	public void TC_107_TBD() {
		String vBaseURL = "https://login.aol.com/";
		String wBrowser = "CHROME";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver(wBrowser, vBaseURL);
		waitTime(4000);
		LoginPage LoginPage = new LoginPage();
		LoginPage.ActivateAllObjectsAndMethodsOfThisPage(driver);
		waitTime(2000);
		LoginPage.obj_UserName().sendKeys("mdshahajadaimran");
		waitTime(2000);
		LoginPage.obj_NextButton().click();
		waitTime(2000);
		LoginPasswordPage LoginPasswordPage = new LoginPasswordPage();
		LoginPasswordPage.ActivateAllObjectsAndMethodsOfThisPage(driver);
		LoginPasswordPage.obj_Password().sendKeys(vMyPassword);
		waitTime(2000);
		LoginPasswordPage.obj_SignInButton().click();
		waitTime(2000);
		AOL_HomePage AOL_HomePage = new AOL_HomePage(driver);
		AOL_HomePage.obj_UserName().click();
		waitTime(2000);
		// Highlight all links from the Personal info page.
		List<WebElement> obj_All_Links = driver.findElements(By.tagName("a"));
		HighLight_Elements(driver, obj_All_Links);
	}

}
