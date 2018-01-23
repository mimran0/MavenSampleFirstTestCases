package usps;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.os.WindowsUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import afterLoginIn.CommonAPI;

public class TestSetJ extends afterLoginIn.CommonAPI {

	// this method will be executed before every test
	@BeforeMethod
	public void SetUpPreDataMethod() {
		System.out.println("Before Each Test  executed");
		WindowsUtils.killByName("chromedriver.exe");
		WindowsUtils.killByName("iexplore.exe");
		WindowsUtils.killByName("geckodriver.exe");
		WindowsUtils.killByName("MicrosoftWebDriver.exe");
		WindowsUtils.killByName("MicrosoftEdge.exe");
	}

	// Requirement: Users are able to find ZIPCode using address in USPS web
	// site.
	@Test(enabled = true)
	public void TC_01_FindZipCode() {
		String vBaseURL = "http://www.usps.com/";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver("CHROME", vBaseURL);
		waitTime(5000);
		// Mouseover on "mail & ship" tab
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.xpath("//*[@id=\"global-menu\"]/div/nav/ol/li[3]/a/span[1]"));
		action.moveToElement(we).build().perform();
		waitTime(2000);
		// highlight the "look up a ZIP code" for visual pleasure
		WebElement obj_LookUpAZipCode = driver
				.findElement(By.xpath("//*[@id=\"global-menu\"]/div/nav/ol/li[3]/ol/li[6]/a"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].style.border='3px solid red'", obj_LookUpAZipCode);
		waitTime(7000);
		// Click on "Look up a ZIP Code" link from the drop down list
		obj_LookUpAZipCode.click();
		// Enter address in the edit fields
		driver.findElement(By.name("tCompany")).sendKeys("I love you Company");
		driver.findElement(By.name("tAddress")).sendKeys("36 breeze dr");
		driver.findElement(By.name("tApt")).sendKeys("F1");
		driver.findElement(By.name("tCity")).sendKeys("dayton");
		driver.findElement(By.xpath("//*[@id=\"sStateList\"]/div[1]/span")).click();
		waitTime(2000);
		driver.findElement(By.xpath("//*[@id=\"select-frame\"]/div[5]/div[9]/ul/li[36]/a")).click();
		waitTime(2000);
		// Click on "Find" button
		driver.findElement(By.id("lookupZipFindBtn")).click();
		waitTime(2000);
		// capturing the ZIPCODE
		WebElement objZipCode = driver.findElement(By.xpath("//*[@id=\"result-list\"]/ul/li/div/p[1]/span[5]"));
		String vZIPCode = objZipCode.getText();
		System.out.println("The ZIP Code is :" + vZIPCode);
		// highlight the ZIPcode for visual pleasure
		jse.executeScript("arguments[0].style.border='3px solid red'", objZipCode);
		waitTime(7000);
		// putting a checkpoint. (if web site tells the ZIPcode is not 08810
		// then test fail.)
		Assert.assertEquals("08810", vZIPCode);
		// Capture screenshot of the automation test
		CAPTURESCREEN(driver, "USPC_FindZipCode_");
	}
}
