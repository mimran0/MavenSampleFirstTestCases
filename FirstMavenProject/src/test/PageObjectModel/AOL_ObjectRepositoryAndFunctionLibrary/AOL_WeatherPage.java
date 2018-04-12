/**
 * 
 */
package AOL_ObjectRepositoryAndFunctionLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import afterLoginIn.CommonAPI;

/**
 * @author md shahajada imran
 *
 */
public class AOL_WeatherPage extends CommonAPI {
	// reusable elements or objects are created below
	@FindBy(how = How.NAME, using = "locationsearch")
	private WebElement obj_WeatherSearch;
	
	// reusable methods are created below
	public WebElement obj_WeatherSearch(){
		return obj_WeatherSearch;
	}
	
	// constructors are created below
	public AOL_WeatherPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	public AOL_WeatherPage(){} //Empty Constructor.
}
