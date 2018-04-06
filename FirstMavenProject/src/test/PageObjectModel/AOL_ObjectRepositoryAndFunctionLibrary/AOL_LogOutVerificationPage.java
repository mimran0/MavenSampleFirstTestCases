package AOL_ObjectRepositoryAndFunctionLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AOL_LogOutVerificationPage extends afterLoginIn.CommonAPI {

	// Objects are created below..
	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "Yes, sign me out")
	private WebElement obj_Yes_sign_me_out;

	// Reusable Methods/Functions are created below..
	public WebElement obj_Yes_sign_me_out() {
		return obj_Yes_sign_me_out;
	}

	// Constructors are created below
	public AOL_LogOutVerificationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public AOL_LogOutVerificationPage() {
	}// empty constructor.
		// Constructor creation ends here

	// Below is the temporary method. Will be deleted.
	@Test(enabled = true)
	public void TemporaryMethod_LogOutVerification() {
		AOL_HomePage AOL_HomePage = new AOL_HomePage();
		WebDriver driver = AOL_HomePage.TemporaryMethod_HomePage();
		PageFactory.initElements(driver, this);
		HighLight_Element(driver, obj_Yes_sign_me_out);
		waitTime(3000);
		obj_Yes_sign_me_out.click();
		waitTime(3000);
		HighLight_Element(driver, AOL_HomePage.obj_LoginOrJoin());
		boolean isLoginOrJoinDisplayed = AOL_HomePage.obj_LoginOrJoin().isDisplayed();
		if (isLoginOrJoinDisplayed) {
			System.out.println("Log Out Successfull");
		} else {
			Assert.fail("LogOut Failed.");
		}
		driver.close();
		driver.quit();
	}

}
