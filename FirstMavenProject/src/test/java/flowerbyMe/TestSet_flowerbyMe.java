/**
 * 
 */
package flowerbyMe;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.os.WindowsUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import afterLoginIn.CommonAPI;

/**
 * @author md shahajada imran
 *
 */
public class TestSet_flowerbyMe extends CommonAPI {
	// this method will be executed before every test
	@BeforeMethod
	public void SetUpPreDataMethod() {
		System.out.println("Before Each Test  executed");
		WindowsUtils.killByName("chromedriver.exe");
		WindowsUtils.killByName("MicrosoftEdge.exe");
		WindowsUtils.killByName("firefox.exe");
		WindowsUtils.killByName("iexplore.exe");
	}

	// Requirement 101: TBD
	@Test(enabled = false)
	public void TC_101_TBD() {
		String vBaseURL = "https://www.flowersbypeter.net/";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver("FIREFOX", vBaseURL);
		waitTime(5000);

		List<WebElement> myList = new ArrayList<WebElement>();
	

		List<WebElement> myOccasionList = new ArrayList<WebElement>();
		driver.findElement(By.cssSelector("li.has-dropdown:nth-child(3)")).click();
		for (int i = 2; i < 15; i++) {
			myOccasionList.add(driver.findElement(
					By.xpath("/html/body/main/header/div[3]/div/nav/section/ul[2]/li[3]/ul/li[" + i + "]/a")));
		}
		myList.addAll(myOccasionList);
	

		
		// Mouse Over.
		waitTime(3000);
		for (WebElement v : myList) {
			HighLight_Element(driver, v);
			Actions action = new Actions(driver);
			action.moveToElement(v).build().perform();
			waitTime(2000);
			if (v.getText().equals("New Baby")) {
				scrolldown(driver, 200);
			}
		}
		myList.removeAll(myList);

		// 2nd column
		List<WebElement> myBirthdayList = new ArrayList<WebElement>();
		driver.findElement(By.cssSelector("li.has-dropdown:nth-child(4)")).click();
		waitTime(3000);
		for (int j = 2; j < 8; j++) {
			myBirthdayList.add(driver.findElement(By.cssSelector(
					"li.has-dropdown:nth-child(4) > ul:nth-child(2) > li:nth-child(" + j + ") > a:nth-child(1)")));
		}
		myList.addAll(myBirthdayList);
		// Mouse Over.
		waitTime(3000);
		for (WebElement v : myList) {
			HighLight_Element(driver, v);
			Actions action = new Actions(driver);
			action.moveToElement(v).build().perform();
			waitTime(2000);
		}
		myList.removeAll(myList);

		// 3rd column
		List<WebElement> myPriceList = new ArrayList<WebElement>();
		driver.findElement(By.cssSelector("li.has-dropdown:nth-child(5)")).click();
		waitTime(3000);
		for (int k = 2; k < 6; k++) {
			myPriceList.add(driver.findElement(By.cssSelector(
					"li.has-dropdown:nth-child(5) > ul:nth-child(2) > li:nth-child("+k+") > a:nth-child(1)")));
		}
		myList.addAll(myPriceList);
		System.out.println(myList.size());
		// Mouse Over.
		waitTime(3000);
		for (WebElement v : myList) {
			HighLight_Element(driver, v);
			Actions action = new Actions(driver);
			action.moveToElement(v).build().perform();
			waitTime(2000);
		}
		myList.removeAll(myList);
		myPriceList.removeAll(myPriceList);
		myBirthdayList.removeAll(myBirthdayList);
		myOccasionList.removeAll(myOccasionList);
		
	}
	
	//Requirement 102: TBD
	@Test(enabled = true,dataProvider="testData")
	public void TC_102_TBD(String wBrowser,String vColor,String vTextMessage,String vName,String vAddressOne,String vAddressTwo,String vCity,String vZipcode){
		String vBaseURL = "https://www.flowersbypeter.net/";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver(wBrowser, vBaseURL);
		waitTime(5000);
		driver.findElement(By.id("search-input")).clear();
		driver.findElement(By.id("search-input")).sendKeys(vColor);
		driver.findElement(By.id("search-input")).submit();
		waitTime(3000);
		driver.findElement(By.xpath("/html/body/main/section/div/div[2]/div[1]/div/a/img")).click();
		waitTime(3000);
		driver.findElement(By.xpath("/html/body/main/section/div[2]/div[2]/form/fieldset/ul/li[1]/div")).click();
		driver.findElement(By.id("multistepRedirectSubmit")).click();
		waitTime(4000);
		List<WebElement> arrCheckBoxes=driver.findElements(By.tagName("md-checkbox"));
		//HighLight_Elements(driver,arrCheckBoxes);
		if(arrCheckBoxes.size()>0){
			arrCheckBoxes.get(0).click();
			waitTime(3000);
		}
		driver.findElement(By.cssSelector("button[type*='submit']")).click();
		waitTime(2000);
		driver.findElement(By.id("ms_card_message_message")).sendKeys(vTextMessage);
		driver.findElement(By.cssSelector("button[type*='submit']")).click();
		
		driver.findElement(By.name("order.recipient.name")).sendKeys(vName);
		driver.findElement(By.id("ms_recipient_address_street_1")).sendKeys(vAddressOne);
		driver.findElement(By.name("address-line2")).sendKeys(vAddressTwo);
		driver.findElement(By.name("order.recipient_address.city")).sendKeys(vCity);
		driver.findElement(By.id("ms_recipient_address_postal")).sendKeys(vZipcode);
		driver.findElement(By.cssSelector("button[type*='submit']")).click();
		waitTime(3000);
		boolean isPresent=driver.findElement(By.cssSelector("h2.card--heading:nth-child(1)")).isDisplayed();
		Assert.assertTrue(isPresent);
	}
	
	@DataProvider
	public Object[][] testData() {
		return new Object[][] {
			    //wBrowser, vColor ,vTextMessage, vName, vAddressOne, vAddressTwo,vCity,vZipcode,vExpectedPayment
			    new Object[] { "CHROME", "Red", "Hello", "md shahajada imran","9018 172nd St","b1","Jamaica", "11432"},
				new Object[] { "FIREFOX", "Green", "Hi", "md shahajada imran","7035 broadway","d16","jackson heights", "11372" }, 
				new Object[] { "IE", "Yellow", "Yellow", "md shahajada imran","9018 172nd St","b1","Jamaica", "11432"},
				new Object[] { "MICROSOFE EDGE", "Pink", "WHAT'S UP", "md shahajada imran","9018 172nd St","b1","Jamaica", "11432" }, 
				new Object[] { "MICROSOFE EDGE", "Black", "Hi yo doing", "md shahajada imran","9018 172nd St","b1","Jamaica", "11432" },
				};
	}
}
