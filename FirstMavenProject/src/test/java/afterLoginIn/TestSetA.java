package afterLoginIn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.os.WindowsUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestSetA extends CommonAPI{
	
	@BeforeTest
	public void SetUpPreData(){
		System.out.println("BeforeTest Method executed");
		WindowsUtils.killByName("chromedriver.exe");
		
	}
	
	@Test
	public void Login_And_LogOut(){
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

}
