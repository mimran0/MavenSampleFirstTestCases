package com.facebook.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginFailPage {

	 WebDriver driver;
	 By RecoverYourAccount=By.xpath("//*[@id=\"login_link\"]/div[1]/a");

	public LoginFailPage (WebDriver driver){
		this.driver=driver;
	}
	
	//method to check if the "Recover Your Account" object/WebElement displayed in the page or not.
	public boolean If_Exist(){
		boolean result;
		result=driver.findElement(RecoverYourAccount).isDisplayed();		
		return result;
	}
}
