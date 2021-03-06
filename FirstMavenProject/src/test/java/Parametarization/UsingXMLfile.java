/**
 * 
 */
package Parametarization;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.os.WindowsUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import afterLoginIn.CommonAPI;

/**
 * @author md shahajada imran
 *
 */
public class UsingXMLfile extends CommonAPI {
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

	// Requirement 601: Users are able to calculate mortgage payment
	// This is data driven test but not parameterized as only one set of data
	// can be passed via XML file.
	@Test(enabled = true)
	@Parameters({ "vHomevalue", "vPrincipal", "vInterest_rate", "vTerm", "vProperty_tax", "vPmi", "vHoi",
			"vExpectedPayment" })
	public void CalculateMortgatePayment(String vHomevalue, String vPrincipal, String vInterest_rate, String vTerm,
			String vProperty_tax, String vPmi, String vHoi, String vExpectedPayment) {
		WindowsUtils.killByName("chromedriver.exe");
		String vBaseURL = "https://www.mortgagecalculator.org/";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver("CHROME", vBaseURL);
		waitTime(15000);
		driver.manage().window().maximize();
		scrolldown(driver, 300);
		driver.findElement(By.name("param[homevalue]")).clear();
		driver.findElement(By.name("param[homevalue]")).sendKeys(vHomevalue);
		driver.findElement(By.name("param[principal]")).clear();
		driver.findElement(By.name("param[principal]")).sendKeys(vPrincipal);
		driver.findElement(By.name("param[interest_rate]")).clear();
		driver.findElement(By.name("param[interest_rate]")).sendKeys(vInterest_rate);
		driver.findElement(By.name("param[term]")).clear();
		driver.findElement(By.name("param[term]")).sendKeys(vTerm);
		driver.findElement(By.name("param[property_tax]")).clear();
		driver.findElement(By.name("param[property_tax]")).sendKeys(vProperty_tax);
		driver.findElement(By.name("param[pmi]")).clear();
		driver.findElement(By.name("param[pmi]")).sendKeys(vPmi);
		driver.findElement(By.name("param[hoi]")).clear();
		driver.findElement(By.name("param[hoi]")).sendKeys(vHoi);
		waitTime(2000);
		driver.findElement(By.name("cal")).click();
		waitTime(7000);
		scrolldown(driver, 300);
		// Highlighting the object that will be used for checkpoint (updated on
		// 1/17/2018)
		WebElement v = driver.findElement(By.xpath(
				"//*[@id=\"calc\"]/form/section/section[2]/div/div/div[1]/div/div/div[3]/div[2]/div[2]/div[1]/div[1]/h3"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].style.border='3px solid red'", v);
		waitTime(7000);
		// putting check point
		String vOutput = driver
				.findElement(By
						.xpath("//*[@id=\"calc\"]/form/section/section[2]/div/div/div[1]/div/div/div[3]/div[2]/div[2]/div[1]/div[1]/h3"))
				.getText();
		System.out.println(vOutput);
		try {
			Assert.assertEquals(vOutput, vExpectedPayment);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed because" + e);
		}
	}

}
