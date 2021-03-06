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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import afterLoginIn.CommonAPI;

/**
 * @author md shahajada imran
 *
 */
public class UsingDataProvider extends CommonAPI {
	// this method will be executed before every test
	@BeforeMethod
	public void SetUpPreDataMethod() {
		System.out.println("Before Each Test  executed");
		WindowsUtils.killByName("chromedriver.exe");
		WindowsUtils.killByName("MicrosoftEdge.exe");
		WindowsUtils.killByName("firefox.exe");
		WindowsUtils.killByName("iexplore.exe");
	}

	// Requirement 101: Verify that users are able to fill mortgage calculator
	// form and upon clicking on submit button payment amount displays and
	// validate the amount.
	// DataDriven Test with parameterization.
	//@Test(enabled = true,dataProvider="testData")
	@Test(enabled = true,dataProvider="testData_2")
	public void TC_101_TBD(String wBrowser, String vHomevalue,String vPrincipal,String vInterest_rate,String vTerm,String vProperty_tax,String vPmi,String vHoi,String vExpectedPayment) {
		String vBaseURL = "https://www.mortgagecalculator.org/";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver(wBrowser, vBaseURL);
		waitTime(15000);
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

	//This is Global DataSheet of UFT or QTP if compared.
	@DataProvider
	public Object[][] testData() {
		return new Object[][] {
			    //wBrowser, vHomevalue ,vPrincipal, vInterest_rate, vTerm, vProperty_tax,vPmi,vHoi,vExpectedPayment
			    new Object[] { "CHROME", "350000", "300000", "2.25","15",".5","1.3", "2000","$2,602.75"},
				new Object[] { "FIREFOX", "350000", "300000", "2.25","15",".5","1.3", "2000","$2,602.75" }, 
				new Object[] { "IE", "350000", "300000", "2.25","15",".5","1.3", "2000","$2,602.75" },
				new Object[] { "MICROSOFE EDGE", "350000", "300000", "2.25","15",".5","1.3", "2000","$2,602.75" }, 
				new Object[] { "MICROSOFE EDGE", "750000", "500000", "1.75","15",".5","1.3", "2000","$2,602.75" },
				};
	}
	
	
	
		@DataProvider
		public Object[][] testData_2() {
			return new Object[][] {
				    //wBrowser, vHomevalue ,vPrincipal, vInterest_rate, vTerm, vProperty_tax,vPmi,vHoi,vExpectedPayment
				    new Object[] { "CHROME", "350000", "300000", "2.25","15",".5","1.3", "2000","$2,602.75"},
					new Object[] { "FIREFOX", "350000", "300000", "2.25","15",".5","1.3", "2000","$2,602.75" }, 
					new Object[] { "IE", "350000", "300000", "2.25","15",".5","1.3", "2000","$2,602.75" },
					new Object[] { "MICROSOFE EDGE", "350000", "300000", "2.25","15",".5","1.3", "2000","$2,602.75" }, 
					new Object[] { "MICROSOFE EDGE", "750000", "500000", "1.75","15",".5","1.3", "2000","$2,602.75" },
					};
		}

}
