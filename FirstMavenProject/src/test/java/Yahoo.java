
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.os.WindowsUtils;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

/**
 * 
 */

/**
 * @author md shahajada imran
 *
 */
public class Yahoo extends afterLoginIn.CommonAPI {

	
	@Test(enabled=true)
	public void TC_Synchronizations() throws InterruptedException{
		WindowsUtils.killByName("chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\imran\\workspace6\\FirstMavenProject\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.yahoo.com/");		
		
		//Implicit wait
		Thread.sleep(5000);	
		HighLight_Element(driver,driver.findElement(By.linkText("Finance")));
		driver.findElement(By.linkText("Finance")).click();
		
		//Implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		driver.findElement(By.linkText("Entertainment")).click();		
		//Explicit wait		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("uh-logo")));
		
		
		
	}

	
	
}
