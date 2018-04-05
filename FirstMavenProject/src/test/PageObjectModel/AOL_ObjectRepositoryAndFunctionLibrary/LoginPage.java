package AOL_ObjectRepositoryAndFunctionLibrary;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.os.WindowsUtils;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import afterLoginIn.CommonAPI;

public class LoginPage extends afterLoginIn.CommonAPI {
	
	

	// By obj_UserName=By.id("login-username");

	// Objects are created below..
	@FindBy(how = How.ID, using = "login-username")
	private WebElement obj_UserName;
	@FindBy(how = How.NAME, using = "signin")
	private WebElement obj_NextButton;

	// Reusable Methods/Functions are created below..
	public WebElement obj_UserName(){
		return obj_UserName;
	}
	public WebElement obj_NextButton(){
		return obj_NextButton;
	}
	public void ActivateAllObjectsAndMethodsOfThisPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	/* Commented Out instead of delete. 
	// Temporary Method will be deleted once Framework is Up and Running.
	//@Test(enabled = true)
	public WebDriver TemporaryMethod() {
		WindowsUtils.killByName("chromedriver.exe");
		String vBaseURL = "https://login.aol.com/";
		String wBrowser = "CHROME";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver(wBrowser, vBaseURL);
		waitTime(10000);
		PageFactory.initElements(driver, this);
		// WebElement object = driver.findElement(By.id("login-username"));
		HighLight_Element(driver, obj_UserName);
		HighLight_Element(driver, obj_NextButton);
		// List<WebElement> links = driver.findElements(By.tagName("a"));
		// HighLight_Elements(driver, links);
		obj_UserName.sendKeys("mdshahajadaimran");
		waitTime(3000);
		obj_NextButton.click();
        return driver;
	}*/

}