package AOL_ObjectRepositoryAndFunctionLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class AOL_HomePage extends afterLoginIn.CommonAPI {

	// Objects are created below..
	@FindBy(how = How.LINK_TEXT, using = "mdshahajadaimran")
	private WebElement obj_UserName;
	@FindBy(how = How.LINK_TEXT, using = "Logout")
	private WebElement obj_LogOut;
	@FindBy(how = How.LINK_TEXT, using = "Login / Join")
	private WebElement obj_LoginOrJoin;
	@FindBy(how = How.XPATH, using = "//*[@id=\"container\"]/div[1]/div[2]/div[3]/div/div[2]/div/div/ul/li[6]/a/span[2]")
	private WebElement obj_Finance;
	@FindBy(how = How.XPATH, using = "//*[@id=\"container\"]/div[1]/div[2]/div[3]/div/div[2]/div/div/ul/li[6]/ul/li[3]/a/span")
	private WebElement obj_PersonalFinance;
	@FindBy(how = How.CSS, using = "li.channel:nth-child(2) > a:nth-child(1) > span:nth-child(3)")
	private WebElement obj_Mail;
	@FindBy(how = How.NAME, using = "q")
	private WebElement obj_SearchBox;
	@FindBy(how = How.CLASS_NAME, using = "navigation-search-btn-text")
	private WebElement obj_SearchButton;
	@FindBy(how = How.CLASS_NAME, using = " fz-13")
	private WebElement obj_SearchResult;
	@FindBy(how = How.LINK_TEXT, using = "Images")
	private WebElement obj_Images;
	@FindBy(how = How.CSS, using = ".navicon-weather-new")
	private WebElement obj_WeatherLink;
	

	// Object Creation Ends here..

	// Reusable Methods/Functions are created below..
	public WebElement obj_UserName() {
		return obj_UserName;
	}

	public WebElement obj_LogOut() {
		return obj_LogOut;
	}

	public WebElement obj_LoginOrJoin() {
		return obj_LoginOrJoin;
	}

	public WebElement obj_Finance() {
		return obj_Finance;
	}

	public WebElement obj_PersonalFinance() {
		return obj_PersonalFinance;
	}

	public WebElement obj_Mail() {
		return obj_Mail;
	}

	public WebElement obj_SearchBox() {
		return obj_SearchBox;
	}

	public WebElement obj_SearchButton() {
		return obj_SearchButton;
	}

	public WebElement obj_SearchResult() {
		return obj_SearchResult;
	}

	public WebElement obj_Images() {
		return obj_Images;
	}

	public WebElement obj_WeatherLink(){
		return obj_WeatherLink;
	}
	// Reusable Method/Function creation ends here. ...

	// Constructors are created below
	public AOL_HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public AOL_HomePage() {
	}// empty constructor.
		// Constructor creation ends here

	// Temporary Method.
	public WebDriver TemporaryMethod_HomePage() {
		LoginPasswordPage LoginPasswordPage = new LoginPasswordPage();
		WebDriver driver = LoginPasswordPage.TemporaryMethod_LoginPasswordPage();
		PageFactory.initElements(driver, this);
		waitTime(3000);
		// HighLight_Element(driver, obj_UserName);
		// HighLight_Element(driver, obj_LogOut);
		waitTime(3000);
		obj_LogOut.click();
		return driver;
	}

	// Temporary method is used to check if created elements are getting
	// highlighted or not.
	@Test(enabled = true)
	public void TemporaryMethod_HomePage2() {
		LoginPasswordPage LoginPasswordPage = new LoginPasswordPage();
		WebDriver driver = LoginPasswordPage.TemporaryMethod_LoginPasswordPage();
		PageFactory.initElements(driver, this);
		waitTime(3000);
		HighLight_Element(driver, obj_UserName);
		HighLight_Element(driver, obj_LogOut);
	}

}
