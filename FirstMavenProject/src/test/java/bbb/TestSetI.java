package bbb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.os.WindowsUtils;
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
	@Test(enabled=true)
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
		ScrollDownAndUp( driver, 500);

	}
}
