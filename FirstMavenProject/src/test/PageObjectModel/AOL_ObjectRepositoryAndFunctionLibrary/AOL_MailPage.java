/**
 * 
 */
package AOL_ObjectRepositoryAndFunctionLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * @author md shahajada imran Page Object Model
 */
public class AOL_MailPage extends afterLoginIn.CommonAPI {

	// Objects or elements are created below..
	@FindBy(how = How.CSS, using = "#dijit__Widget_1 > div:nth-child(3) > div:nth-child(1)")
	private WebElement obj_Inbox;
	@FindBy(how = How.CSS, using = "#uniqName_5_4 > div:nth-child(1)")
	private WebElement obj_EmailCount;
	@FindBy(how = How.XPATH, using = "//*[@id=\"dijit__Widget_0\"]/div")
	private WebElement obj_Compose;
	@FindBy(how = How.ID_OR_NAME, using = "toInputField")
	private WebElement obj_Email_To;
	@FindBy(how = How.NAME, using = "Subject")
	private WebElement obj_Email_Subject;
	@FindBy(how = How.NAME, using = "composeMessage_body_body")
	private WebElement obj_Email_Body;
	@FindBy(how = How.CSS, using = ".composeBtn")
	private WebElement obj_Email_Send;
	@FindBy(how = How.CSS, using = ".confirmMessage")
	private WebElement obj_Email_SendSucessfullMessage;

	// Reusable Methods/Functions are created below..
	public WebElement obj_Inbox() {
		return obj_Inbox;
	}

	public WebElement obj_EmailCount() {
		return obj_EmailCount;
	}

	public WebElement obj_Compose() {
		return obj_Compose;
	}

	public WebElement obj_Email_To() {
		return obj_Email_To;
	}

	public WebElement obj_Email_Subject() {
		return obj_Email_Subject;
	}

	public WebElement obj_Email_Body() {
		return obj_Email_Body;
	}

	public WebElement obj_Email_Send() {
		return obj_Email_Send;
	}

	public WebElement obj_Email_SendSucessfullMessage() {
		return obj_Email_SendSucessfullMessage;
	}
	// Reusable Method/Function creation ends here. ...

	// Constructors are created below
	public AOL_MailPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public AOL_MailPage() {
	}// empty constructor.

}
