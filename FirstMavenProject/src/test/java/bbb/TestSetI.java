package bbb;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.os.WindowsUtils;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import afterLoginIn.CommonAPI;

public class TestSetI extends afterLoginIn.CommonAPI {

	// this method will be executed before every test
	@BeforeMethod
	public void SetUpPreDataMethod() {
		System.out.println("Before Each Test  executed");
		WindowsUtils.killByName("chromedriver.exe");
		WindowsUtils.killByName("MicrosoftEdge.exe");
		WindowsUtils.killByName("firefox.exe");
		WindowsUtils.killByName("iexplore.exe");
	}

	// Requirement 901: Users are able to search on BBB home page
	@Test(enabled = true)
	public void TC_901() {
		String vBaseURL = "https://www.bedbathandbeyond.com/";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver("FIREFOX", vBaseURL);
		waitTime(25000);
		// taking care of PopUp window starts here
		try {
			boolean isPopUoOpensUp = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/span[1]"))
					.isDisplayed();
			if (isPopUoOpensUp) {
				CAPTURESCREEN(driver, "BBB_TC_901_");
				driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/span[1]")).click();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// taking care of PopUp window ends here
		driver.findElement(By.name("searchBox")).sendKeys("panty");
		waitTime(2000);
		driver.findElement(By.name("submit your search")).click();
		waitTime(2000);
		CAPTURESCREEN(driver, "BBB_TC_901_");
		String vSearchResult = driver.findElement(By.xpath("/html/body/div[1]/div[4]/div[1]/div/div[2]/h2[1]"))
				.getText();
		System.out.println("Search result is " + vSearchResult);

	}

	// Requirement 902: Find a store
	@Test(enabled = true)
	public void TC_902() {
		String vBaseURL = "https://www.bedbathandbeyond.com/";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver("FIREFOX", vBaseURL);
		waitTime(25000);
		driver.findElement(By.xpath("//*[@id=\"linkArea\"]/ul/li[1]/a")).click();
		waitTime(2000);
		driver.findElement(By.id("storeLocatorOmnibarInput")).sendKeys("08810");
		waitTime(4000);
		driver.findElement(By.id("findStoreSubmitButton")).click();
		waitTime(2000);
		CAPTURESCREEN(driver, "BBB_TC_902_");
		ScrollDownAndUp(driver, 500);

	}

	// Requirement 903: MouseOver
	@Test(enabled = true)
	public void TC_903_MouseOver() {
		String vBaseURL = "https://www.bedbathandbeyond.com/";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver("FIREFOX", vBaseURL);
		waitTime(25000);
		// list of xpath's
		String[] list = new String[5];
		list[0] = "//*[@id=\"collegeBridalArea\"]/div[1]/a";
		list[1] = "//*[@id=\"giftsNavSS\"]/a";
		list[2] = "//*[@id=\"collegeBridalArea\"]/div[2]/a";
		list[3] = "//*[@id=\"shopMoverLink\"]/a";
		list[4] = "//*[@id=\"bridalGiftRegistryAnchor\"]";
		// mouseover
		for (String v : list) {
			Actions action = new Actions(driver);
			WebElement we = driver.findElement(By.xpath(v));
			action.moveToElement(we).build().perform();
			waitTime(2000);
		}
	}

	// Requirement 904: System doesn't allow to login using wrong facebook credentials.
	@Test(enabled=true)
	public void TC_904() {
		String vBaseURL = "https://www.bedbathandbeyond.com/";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver("FIREFOX", vBaseURL);
		waitTime(25000);
		driver.findElement(By.xpath("//*[@id=\"topNavMenu\"]/ul/li/a")).click();
		waitTime(2000);
		driver.findElement(By.xpath("//*[@id=\"newCustomer\"]/div/a/img")).click();
		waitTime(2000);
		// dealing with 2 tabs
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		driver.findElement(By.id("email")).sendKeys("wrongID");
		driver.findElement(By.id("pass")).sendKeys("Wrong Password");
		driver.findElement(By.name("login")).click();
		CAPTURESCREEN(driver, "BBB_TC_904_");
		// Putting ChekcPoint.
		try {
			boolean isErrorPresnt = driver.findElement(By.id("error_box")).isDisplayed();
			Assert.assertTrue(isErrorPresnt);
		} catch (Exception e) {
			Assert.fail();
		}
		driver.close(); // closing the 2nd Tab
		driver.switchTo().window(tabs2.get(0));
	}
	
	
	// Requirement 905: System ask for registration if login attempt is done with valid non registered facebook credentials.
		@Test(enabled=true)
		public void TC_905() {
			String vBaseURL = "https://www.bedbathandbeyond.com/";
			CommonAPI CommonAPI = new CommonAPI();
			WebDriver driver = CommonAPI.getDriver("FIREFOX", vBaseURL);
			waitTime(25000);
			driver.findElement(By.xpath("//*[@id=\"topNavMenu\"]/ul/li/a")).click();
			waitTime(3000);
			driver.findElement(By.xpath("//*[@id=\"newCustomer\"]/div/a/img")).click();
			waitTime(2000);
			// dealing with 2 tabs
			ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs2.get(1)); // Going to Pop-up window as second browser.
			driver.findElement(By.id("email")).sendKeys("imranlimon00@gmail.com");
			driver.findElement(By.id("pass")).sendKeys("1234560y");
			System.out.println(driver.getTitle());
			driver.findElement(By.name("login")).click();					
			waitTime(8000);		
			driver.switchTo().window(tabs2.get(0)); //Going back to original browser.
			System.out.println(driver.getTitle());
			//checkpoint (if system ask for registration instead of login then pass"
			try {
				boolean isRegistrationPresnt = driver.findElement(By.xpath("//*[@id=\"content\"]/div/h1")).isDisplayed();
				Assert.assertTrue(isRegistrationPresnt);	
			} catch (Exception e) {
				Assert.fail();
			}		
			CAPTURESCREEN(driver, "BBB_TC_905_");
			
		}
		
		//Requirement 906: Users are able to fill up registration form.
		@Test(enabled=true)
		public void TC_906_RegistrationFormFillUp(){
			String vBaseURL = "https://www.bedbathandbeyond.com/";
			CommonAPI CommonAPI = new CommonAPI();
			WebDriver driver = CommonAPI.getDriver("FIREFOX", vBaseURL);
			waitTime(5000);
			driver.findElement(By.xpath("//*[@id=\"topNavMenu\"]/ul/li/a")).click();
			waitTime(3000);
			driver.findElement(By.id("newEmail")).sendKeys("imranlimon00@gmail.com");
			driver.findElement(By.id("newEmailBtn")).click();
			waitTime(5000);
			driver.findElement(By.id("firstName")).sendKeys("md");
			driver.findElement(By.id("lastName")).sendKeys("Imran");
			driver.findElement(By.id("basePhoneFull")).sendKeys("9119111876");
			driver.findElement(By.id("cellPhoneFull")).sendKeys("7865432145");
			
			Select dropdown_ChallengeQuestions1 = new Select(driver.findElement(By.id("challengeQuestion1")));
			dropdown_ChallengeQuestions1.selectByVisibleText("What is the name of your first crush?");
			driver.findElement(By.id("challengeAnswer1")).sendKeys("Don't remember");
			//waitTime(2000);
			Select dropdown_ChallengeQuestions2 = new Select(driver.findElement(By.id("challengeQuestion2")));
			dropdown_ChallengeQuestions2.selectByVisibleText("What is your nickname?");
			driver.findElement(By.id("challengeAnswer2")).sendKeys("Love");
			
			driver.findElement(By.id("password")).sendKeys("Ilove100");
			driver.findElement(By.id("cPassword")).sendKeys("Ilove100");
			//canceling instead of creating
			driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/form/div[14]/a")).click();
			
		}
}
