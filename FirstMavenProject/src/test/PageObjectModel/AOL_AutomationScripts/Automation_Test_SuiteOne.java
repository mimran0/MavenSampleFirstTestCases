package AOL_AutomationScripts;

import java.util.Random;

import org.openqa.selenium.WebDriver;
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
	@Test(enabled = false)
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
		LoginPasswordPage.obj_Password().sendKeys("selenium12345");
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
	@Test(enabled = false)
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
	@Test(enabled = false)
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
		AOL_MailPage.obj_Email_Send().click();
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
	}

}
