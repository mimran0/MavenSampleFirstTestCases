package afterLoginIn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.os.WindowsUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestSetA extends CommonAPI{
	
	//Pre-requisite: Capcha must be disabled by developers else TC 401 and TC 402 will fail.
	
	//This method will be executed once before the test set that contains by this class "TestSetA"
	@BeforeTest
	public void SetUpPreData(){
		System.out.println("Before TestSet  executed");
		WindowsUtils.killByName("chromedriver.exe");
		
	}
	
	//this method will be executed before every test
	@BeforeMethod
	public void SetUpPreDataMethod(){
		System.out.println("Before Each Test  executed");
		WindowsUtils.killByName("chromedriver.exe");
		
	}
	
	//Requirement 401: Users are able to login and logout using valid login credential.
	@Test(enabled=true)
	public void TC_401_Login_And_LogOut(){
		String vBaseURL="https://www.amazon.com/ap/signin?_encoding=UTF8&ignoreAuthState=1&openid.assoc_handle=usflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2F%3Fref_%3Dnav_custrec_signin&switch_account=";
		CommonAPI CommonAPI=new CommonAPI();
		String vLandingPageActualTitle=CommonAPI.OpenChromeBrowser(vBaseURL);
		System.out.println(vLandingPageActualTitle);
		String vLandingPageExpectedTitle="Amazon Sign In";
		Assert.assertEquals(vLandingPageExpectedTitle, vLandingPageActualTitle);
		WebDriver driver=CommonAPI.getDriver(vBaseURL);
		waitTime(5000);
		driver.findElement(By.id("ap_email")).sendKeys("imranlimon00@gmail.com");
		driver.findElement(By.id("ap_password")).sendKeys("1234560y");
		driver.findElement(By.id("signInSubmit")).click();
		waitTime(4000);
		driver.manage().window().maximize();
		String vActualUserName=driver.findElement(By.id("nav-link-accountList")).getText();
		System.out.println(vActualUserName);
		Assert.assertEquals("Hello, limon", vActualUserName.substring(0, 12));
		//below 3 lines for mouseover
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.id("nav-link-accountList"));
		action.moveToElement(we).build().perform();
		waitTime(2000);
		//logout
		driver.findElement(By.id("nav-item-signout")).click();
		waitTime(2000);
		try {
			driver.findElement(By.id("nav-link-accountList")).isDisplayed();
		} catch (Exception e) {
			System.out.println("Logout successfull"); //because object/element in try block is not displayed.
		}	
	}
	//Requirement 402: Users are Not able to login and logout using invalid login credential.
	@Test(enabled=true)
	public void TC_402_Login_NegativeTest(){
		String vBaseURL="https://www.amazon.com/ap/signin?_encoding=UTF8&ignoreAuthState=1&openid.assoc_handle=usflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2F%3Fref_%3Dnav_custrec_signin&switch_account=";
		CommonAPI CommonAPI=new CommonAPI();
		WebDriver driver=CommonAPI.getDriver(vBaseURL);
		waitTime(5000);
		//valid email but wrong password
		driver.findElement(By.id("ap_email")).sendKeys("imranlimon00@gmail.com");
		driver.findElement(By.id("ap_password")).sendKeys("wrong password");
		driver.findElement(By.id("signInSubmit")).click();
		waitTime(4000);
		String vActualErrorMessage=driver.findElement(By.xpath("//*[@id=\"auth-error-message-box\"]/div/div/ul/li/span")).getText();
		System.out.println(vActualErrorMessage);
		Assert.assertEquals( vActualErrorMessage,"Your password is incorrect");
		//invalid email but valid one password
		driver.findElement(By.id("ap_email")).clear();
		driver.findElement(By.id("ap_password")).clear();
		driver.findElement(By.id("ap_email")).sendKeys("wrongpasswordimran@gmail.com");
		driver.findElement(By.id("ap_password")).sendKeys("1234560y");
		driver.findElement(By.id("signInSubmit")).click();
		waitTime(4000);
		String vActualErrorMessage2=driver.findElement(By.xpath("//*[@id=\"auth-error-message-box\"]/div/div/ul/li/span")).getText();
		System.out.println(vActualErrorMessage2);
		Assert.assertEquals( vActualErrorMessage2,"We cannot find an account with that email address");
		//invalid email and invalid password
		driver.findElement(By.id("ap_email")).clear();
		driver.findElement(By.id("ap_password")).clear();
		driver.findElement(By.id("ap_email")).sendKeys("wrongpasswordimran@gmail.com");
		driver.findElement(By.id("ap_password")).sendKeys("wrongpassword");
		driver.findElement(By.id("signInSubmit")).click();
		waitTime(4000);
		String vActualErrorMessage3=driver.findElement(By.xpath("//*[@id=\"auth-error-message-box\"]/div/div/ul/li/span")).getText();
		System.out.println(vActualErrorMessage3);
		Assert.assertEquals( vActualErrorMessage3,"We cannot find an account with that email address");
		// valid email but empty password
		driver.findElement(By.id("ap_email")).clear();
		driver.findElement(By.id("ap_password")).clear();
		driver.findElement(By.id("ap_email")).sendKeys("imranlimon00@gmail.com");		
		driver.findElement(By.id("signInSubmit")).click();
		waitTime(4000);
		String vActualErrorMessage4=driver.findElement(By.xpath("//*[@id=\"auth-password-missing-alert\"]/div/div")).getText();
		System.out.println(vActualErrorMessage4);
		Assert.assertEquals( vActualErrorMessage4,"Enter your password");
		//empty email and empty password
		driver.findElement(By.id("ap_email")).clear();
		driver.findElement(By.id("ap_password")).clear();			
		driver.findElement(By.id("signInSubmit")).click();
		waitTime(4000);
		String vActualErrorMessage5=driver.findElement(By.xpath("//*[@id=\"auth-password-missing-alert\"]/div/div")).getText();
		System.out.println(vActualErrorMessage5);
		Assert.assertEquals( vActualErrorMessage5,"Enter your password");
		String vActualErrorMessage6=driver.findElement(By.xpath("//*[@id=\"auth-email-missing-alert\"]/div/div")).getText();
		System.out.println(vActualErrorMessage6);
		Assert.assertEquals( vActualErrorMessage6,"Enter your email or mobile phone number");
		
	}
	
	//Requirement 403: Users are able to view all fields in login page
	@Test
	public void TC_403_VerifyFieldsInLoginPage(){
		String vBaseURL="https://www.amazon.com/ap/signin?_encoding=UTF8&ignoreAuthState=1&openid.assoc_handle=usflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2F%3Fref_%3Dnav_custrec_signin&switch_account=";
		CommonAPI CommonAPI=new CommonAPI();
		WebDriver driver=CommonAPI.getDriver(vBaseURL);
		waitTime(5000);
		//verify if the Amazon image displays or not
		WebElement ImageAmazon=driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[1]/div[1]/div/a/i"));
		Assert.assertEquals(true, ImageAmazon.isDisplayed());
		//verify if the "Sign In" web element displays or not
		WebElement WebElementSignIn=driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[1]/div[3]/div/div/form/div/div/div/h1"));
		Assert.assertEquals(true, WebElementSignIn.isDisplayed());
		//verify if the login ID displays or not
		WebElement WebEditLoginID=driver.findElement(By.name("email"));
		Assert.assertEquals(true, WebEditLoginID.isDisplayed());
		//verify if the login password displays or not
		WebElement WebEditLoginPassword=driver.findElement(By.name("password"));
		Assert.assertEquals(true, WebEditLoginPassword.isDisplayed());
		// verify if the login button displays or not
		WebElement ButtonLogin=driver.findElement(By.id("signInSubmit"));
		Assert.assertEquals(true, ButtonLogin.isDisplayed());		
		// verify if the login button displays or not
		WebElement ButtonCreatYourAmazonAccount=driver.findElement(By.id("createAccountSubmit"));
		Assert.assertEquals(true, ButtonCreatYourAmazonAccount.isDisplayed());
	}
	
	//Requirement 404: ToolTip is viewable of the object "Details" in the login page.
	@Test
	public void TC_404_ToolTip(){
		String vBaseURL="https://www.amazon.com/ap/signin?_encoding=UTF8&ignoreAuthState=1&openid.assoc_handle=usflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2F%3Fref_%3Dnav_custrec_signin&switch_account=";
		CommonAPI CommonAPI=new CommonAPI();
		WebDriver driver=CommonAPI.getDriver(vBaseURL);
		waitTime(5000);
		driver.findElement(By.id("remember_me_learn_more_link")).click();
		WebElement ObjToolTipText=driver.findElement(By.id("a-popover-content-1"));
		String vTootTipText=ObjToolTipText.getText();
		System.out.println(vTootTipText);
		String a="Choosing \"Keep me signed in\" reduces the number of times you're asked to sign in on this device.\n"
                 +"To keep your account secure, use this option only on your personal devices.";
		Assert.assertEquals(vTootTipText, a);
		waitTime(3000);
		driver.findElement(By.xpath("//*[@id=\"a-popover-1\"]/div/div[1]/button")).click();
	}
}
