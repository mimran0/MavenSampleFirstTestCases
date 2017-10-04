package walmart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.os.WindowsUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import afterLoginIn.CommonAPI;

public class TestSetB extends afterLoginIn.CommonAPI {
	
	//This method will be executed once before the test set that contains by this class "TestSetA"
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
		}
	
	//Requirement 501: Users are able to search text in walmart website
		@Test(enabled=true)
		public void TC_501_UsersAreAbleToSearch(){
		String[] list = new String[10];
		list[0] = "T-shart";
		list[1] = "panty";
		list[2] = "cap";
		list[3] = "tie";
		list[4] = "belt";
		list[5] = "bra";
		list[6] = "watch";
		list[7] = "Phone";
		list[8] = "Computer";
		list[9] = "Candle";
		String vBaseURL = "http://www.walmart.com";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver(vBaseURL);
		waitTime(5000);
		driver.manage().window().maximize();
		for (int i = 0; i < list.length; i++) {
			driver.findElement(By.id("listboxActive")).click();
			driver.findElement(By.id("header-SearchDropdown-option-0")).click();
			waitTime(2000);
			driver.findElement(By.id("global-search-input")).sendKeys(list[i]);
			driver.findElement(By.xpath("//*[@id=\"global-search-form\"]/div/div[3]/button/span[1]")).click();
			waitTime(6000);
			driver.findElement(By.xpath("//*[@id=\"global-search-clear\"]/span[1]")).click();
			String vSearchResult1ST = driver
					.findElement(By.xpath("//*[@id=\"SearchContainer\"]/div/div[1]/div[1]/span[1]")).getText();
			String vSearchResult2ND = driver
					.findElement(By.xpath("//*[@id=\"SearchContainer\"]/div/div[1]/div[1]/span[2]")).getText();
			System.out.println(vSearchResult1ST + vSearchResult2ND);
		}
	}
		
	//Requirement 502: Users are able to select all values from search dropdown list
	@Test(enabled=true)
	public void TC_502_SelectDropdownValue(){
		String vBaseURL = "http://www.walmart.com";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver(vBaseURL);
		waitTime(5000);
		for (int i = 0; i <= 25; i++) {
			driver.findElement(By.id("listboxActive")).click();
			driver.findElement(By.id("header-SearchDropdown-option-" + i)).click();
			waitTime(2000);
		}
	}
	
	//Requirement 503: Users are able to view list after mouseover on elements.
	@Test(enabled=true)
	public void TC_503_mouseOver(){
		String[] ids = new String[15];
		ids[0] = "header-GlobalEyebrowNav-button-0";
		ids[1] = "header-GlobalEyebrowNav-button-1";
		ids[2] = "header-GlobalLefthandNav-toggle-1";
		ids[3] = "superDeptId-0";ids[4] = "superDeptId-1";ids[5] = "superDeptId-2";ids[6] = "superDeptId-3";ids[7] = "superDeptId-4";ids[8] = "superDeptId-5";ids[9] = "superDeptId-6";ids[10] = "superDeptId-7";ids[11] = "superDeptId-8";ids[12] = "superDeptId-9";ids[13] = "superDeptId-10";ids[14] = "superDeptId-11";
		
		String vBaseURL = "http://www.walmart.com";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver(vBaseURL);
		waitTime(5000);
		driver.manage().window().maximize();
		for (String v : ids) {
			Actions action = new Actions(driver);
			WebElement we = driver.findElement(By.id(v));
			action.moveToElement(we).build().perform();
			waitTime(2000);		
		}
	}

}
