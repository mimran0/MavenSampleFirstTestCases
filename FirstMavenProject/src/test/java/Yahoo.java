
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.os.WindowsUtils;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

/**
 * 
 */

/**
 * @author md shahajada imran
 *
 */
public class Yahoo extends afterLoginIn.CommonAPI {

	@BeforeTest
	public void BeforeTest() {
		System.out.println("Before Each Test method  executed");
		WindowsUtils.killByName("chromedriver.exe");
		WindowsUtils.killByName("MicrosoftEdge.exe");
		WindowsUtils.killByName("firefox.exe");
		WindowsUtils.killByName("iexplore.exe");
		WindowsUtils.killByName("operadriver.exe");
	}

	@Test(enabled = true)
	public void TC_Synchronizations() throws InterruptedException {
		WindowsUtils.killByName("chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\imran\\workspace6\\FirstMavenProject\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.yahoo.com/");

		// Implicit wait
		Thread.sleep(5000);
		HighLight_Element(driver, driver.findElement(By.linkText("Finance")));
		driver.findElement(By.linkText("Finance")).click();

		// Implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.linkText("Entertainment")).click();
		// Explicit wait
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("uh-logo")));

	}

	// Requirement 102: Validate the error message that displayed upon clicking
	// on submit button with empty userid.
	@Test(enabled = true)
	public void TC_102_ValidateErrorMessage() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\imran\\workspace6\\FirstMavenProject\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.yahoo.com/");
		driver.manage().window().maximize();
		waitTime(5000);
		List<WebElement> objMail = driver.findElements(By.tagName("span"));
		// HighLight_Elements (driver, objMail);

		// Clicking on the Mail button starts here
		int i = 0;
		for (WebElement v : objMail) {
			String vTest = v.getText();
			System.out.println(vTest);
			System.out.println(i);
			if (i == 2) {
				HighLight_Element(driver, v);
				v.click();
				waitTime(4000);
				break;
			}
			i++;
		}
		// Clicking on the Mail button ends here

		WebElement objNext = driver.findElement(By.cssSelector("input[value='Next'][type='submit']"));
		HighLight_Element(driver, objNext);
		objNext.click();
		waitTime(4000);

		WebElement objErrorMessage = driver
				.findElement(By.cssSelector("p[data-error='messages.ERROR_INVALID_USERNAME'][role='alert']"));
		HighLight_Element(driver, objErrorMessage);
		String vErrorMessage = objErrorMessage.getText();
		System.out.println(vErrorMessage);
		Assert.assertEquals("Sorry, we don't recognize this email.", vErrorMessage);
	}

}