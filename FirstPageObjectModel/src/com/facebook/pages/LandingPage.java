/**
 * 
 */
package com.facebook.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author imran
 *
 */
public class LandingPage {
	
	WebDriver driver;

	By LoginID=By.id("email");
	By LoginPassword=By.id("pass");
	By LoginButton=By.id("loginbutton");
	
	public LandingPage(WebDriver driver){
		this.driver=driver;
	}
	
	public void EnterID(String strID){
		driver.findElement(LoginID).sendKeys(strID);
	}
	
	public void EnterPassword(String strPassword){
		driver.findElement(LoginPassword).sendKeys(strPassword);
	}
	
	public void EnterBothPasswordAndID(String strID,String strPassword){
		driver.findElement(LoginID).sendKeys(strID);
		driver.findElement(LoginPassword).sendKeys(strPassword);
	}
	
	public void ClickLogInButton(){
		driver.findElement(LoginButton).click();
	}
	
	//method to wait a specific time
		public void waitTime(int a){
			try {
				Thread.sleep(a);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
