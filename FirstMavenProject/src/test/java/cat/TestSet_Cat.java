/**
 * 
 */
package cat;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.os.WindowsUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sun.glass.events.KeyEvent;

import afterLoginIn.CommonAPI;

/**
 * @author md shahajada imran
 *
 */
public class TestSet_Cat extends CommonAPI {

	@BeforeMethod
	public void SetUpPreDataMethod() {
		System.out.println("Before Each Test  executed");
		WindowsUtils.killByName("chromedriver.exe");
		WindowsUtils.killByName("MicrosoftEdge.exe");
		WindowsUtils.killByName("firefox.exe");
		WindowsUtils.killByName("iexplore.exe");
	}

	// Requirement 801: Green
	@Test(enabled = true, priority = 3)
	public void TC_801_Green() throws InterruptedException {
		// Data driven Test where testdata was read from external Excel file.
		int vRow = 3;
		int vColumn = 1;
		String vExcelPath = "C:\\Users\\imran\\workspace6\\FirstMavenProject\\src\\test\\java\\cat\\HyBridFramework.xlsx";
		String vColor = ReadCellData(vRow, vColumn, vExcelPath);
		Search(vColor);
	}

	// Requirement 802: Red
	@Test(priority = 1, enabled = true)
	public void TC_802_Red() throws InterruptedException {
		// Data driven Test where testdata was read from external Excel file.
		int vRow = 4;
		int vColumn = 1;
		String vExcelPath = "C:\\Users\\imran\\workspace6\\FirstMavenProject\\src\\test\\java\\cat\\HyBridFramework.xlsx";
		String vColor = ReadCellData(vRow, vColumn, vExcelPath);
		Search(vColor);
	}

	// Requirement 803: Pink
	@Test(priority = 0, enabled = true)
	public void TC_803_Pink() throws InterruptedException {
		Search("Pink");
	}
	
	// Requirement 804: Yellow
		@Test(priority = 0, enabled = true)
		public void TC_804_Yellow() throws InterruptedException {
			Search("Yellow");
		}

	// Not a TestNG test.
	public static void Search(String vSearchString) throws InterruptedException {
		String vBaseURL = "http://www.vetstreet.com/cats/";
		String vBrowser = "FIREFOX";
		// String vSearchString = "Green";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver(vBrowser, vBaseURL);
		waitTime(5000);
		driver.manage().window().maximize();
		List<WebElement> oEditBox = driver.findElements(By.cssSelector("#site-search > input:nth-child(1)"));
		HighLight_Elements(driver, oEditBox);
		for (WebElement v : oEditBox) {
			v.sendKeys(vSearchString);
			break;
		}
		Robot r = null;
		try {
			r = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		String vResult = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/p[1]/span[1]")).getText();
		HighLight_Element(driver, driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/p[1]/span[1]")));
		System.out.println("There are " + vResult + " results for " + vSearchString);
	}
}
