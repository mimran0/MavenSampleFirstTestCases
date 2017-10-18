/**
 * 
 */
package groupon;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.os.WindowsUtils;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import afterLoginIn.CommonAPI;

/**
 * @author imran
 *
 */
public class TestSet_E extends afterLoginIn.CommonAPI{
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
		WindowsUtils.killByName("MicrosoftEdge.exe");
		WindowsUtils.killByName("firefox.exe");
		WindowsUtils.killByName("iexplore.exe");
	}
	
	@AfterMethod (enabled=false)
	public void aftermethod(){				
		WindowsUtils.killByName("chromedriver.exe");	
		WindowsUtils.killByName("MicrosoftEdge.exe");
	    WindowsUtils.killByName("firefox.exe");
		WindowsUtils.killByName("iexplore.exe");
	}
	
	
	//801:Requirement: Users are able to search
	@Test (enabled=false)
	public void TC_801_testOne(){
		String vBaseURL = "https://www.groupon.com/";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver("FIREFOX",vBaseURL);
		waitTime(15000);		
		//driver.manage().window().maximize();
		//Optional Steps start here
		try {
			if (driver.findElement(By.id("nothx")).isDisplayed()){
				driver.findElement(By.id("nothx")).click(); //closing the PopUp window if opens
			}
		} catch (Exception e) {
			System.out.println("Sign Up Popup window did not open up or display");
		}
		//Optional Steps Ends here		
		driver.findElement(By.name("search")).sendKeys("full body message");
		driver.findElement(By.name("location")).sendKeys("08810");
		driver.findElement(By.id("ls-header-search-button")).click();
		driver.findElement(By.id("ls-header-search-button")).click();
		waitTime(14000);
		//Optional Steps start here
				try {
					if (driver.findElement(By.id("nothx")).isDisplayed()){
						driver.findElement(By.id("nothx")).click(); //closing the PopUp window if opens
					}
				} catch (Exception e) {
					System.out.println("Sign Up Popup window did not open up or display");
				}
				//Optional Steps Ends here
		driver.findElement(By.id("grpn-sorts-select")).click(); //displaying the list
		waitTime(4000);
		Select oSelect = new Select(driver.findElement(By.id("grpn-sorts-select")));
		oSelect.selectByValue("distance");
		driver.findElement(By.id("grpn-sorts-select")).click(); //not displaying the list		
		//Scroll down and up
		ScrollDownAndUp(driver); //calling a static method
	
	}
	
	
	//Requirement402: Find out how many links on a webpage and highlight all of those
	@Test(enabled=true)
	public void TC_402_LinkCount(){
		String vBaseURL = "https://www.groupon.com/";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver("FIREFOX",vBaseURL);
		waitTime(15000);		
		//driver.manage().window().maximize();
		//Optional Steps start here
		try {
			if (driver.findElement(By.id("nothx")).isDisplayed()){
				driver.findElement(By.id("nothx")).click(); //closing the PopUp window if opens
			}
		} catch (Exception e) {
			System.out.println("Sign Up Popup window did not open up or display");
		}
		//Optional Steps Ends here
		
		java.util.List<WebElement> links = driver.findElements(By.tagName("a"));
		 
		System.out.println(links.size());
		for(WebElement v:links){
			System.out.println(v.getText());
			//highlight those elements/(Links)
			JavascriptExecutor jse = (JavascriptExecutor) driver;
	        jse.executeScript("arguments[0].style.border='3px solid red'", v);
	        
		}
	}

}
