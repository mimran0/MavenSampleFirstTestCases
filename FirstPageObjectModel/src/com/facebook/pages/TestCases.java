/**
 * 
 */
package com.facebook.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.os.WindowsUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author imran
 *
 */
public class TestCases {
	
	
	//Requirement: Users are not able to login with wrong credentials
	@Test(enabled=true)
	public void FacebookLogin(){	
		WindowsUtils.killByName("chrome.exe");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\imran\\workspace6\\FirstPageObjectModel\\driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://facebook.com/");
		driver.manage().window().maximize();		
		LandingPage LandingPage=new LandingPage(driver); //Page object model is used
		LandingPage.EnterBothPasswordAndID("wrongEmailAddress@gmail.com","wongpassword");
		LandingPage.ClickLogInButton();	
		LandingPage.waitTime(5000);
		LoginFailPage LoginFailPage=new LoginFailPage(driver); //page object model is used
		boolean elementExisted=LoginFailPage.If_Exist();
		Assert.assertEquals( true, elementExisted);		
	}

}
