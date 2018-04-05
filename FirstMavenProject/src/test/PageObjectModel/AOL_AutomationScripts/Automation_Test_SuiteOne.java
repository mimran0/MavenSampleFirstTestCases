package AOL_AutomationScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.os.WindowsUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import AOL_ObjectRepositoryAndFunctionLibrary.AOL_HomePage;
import AOL_ObjectRepositoryAndFunctionLibrary.AOL_LogOutVerificationPage;
import AOL_ObjectRepositoryAndFunctionLibrary.LoginPage;
import AOL_ObjectRepositoryAndFunctionLibrary.LoginPasswordPage;
import afterLoginIn.CommonAPI;

/**
 * @author md shahajada imran
 *
 */
public class Automation_Test_SuiteOne extends afterLoginIn.CommonAPI {

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
		LoginPasswordPage.obj_Password().sendKeys("");
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

}
