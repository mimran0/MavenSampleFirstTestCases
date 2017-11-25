package afterLoginIn;

import org.openqa.selenium.JavascriptExecutor;
//import org.junit.Assert;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.os.WindowsUtils;
import org.testng.annotations.BeforeMethod;

public class CommonAPI {

	// method to wait a specific time
	public static void waitTime(int a) {
		try {
			Thread.sleep(a);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// method that checks if a string contains a numeric number
	public static boolean isContainNewMeric(String a) {
		boolean result = false;
		for (int i = 0; i <= a.length() - 1; i++) {
			char b = a.charAt(i);
			boolean isNM = Character.isDigit(b);
			// System.out.println(isNM);
			// System.out.println(b);
			if (isNM == true) {
				result = true;
				break;
			}
		}
		return result;
	}

	@BeforeMethod(enabled = false)
	public void doBeforeEveryMethod() {
		// CLOSING ALL OPEN BROWSERS before every method/(@test) executed
		WindowsUtils.killByName("chromedriver.exe");
		WindowsUtils.killByName("chrome.exe");
	}

	public int add(int a, int b) {
		int result;
		result = a + b;
		return result;
	}

	// OpenChromeBrowser (09/28/17)
	// This function/method will open GoogleChrome Browser and navigate to the
	// URL given during calling the method
	// Output: this function/method will return page title
	// Input: this function/method takes string URL of the page as input
	// argument
	WebDriver driver;

	public String OpenChromeBrowser(String url) {
		String result = null;
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\imran\\workspace6\\FirstMavenProject\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		waitTime(5000);
		result = driver.getTitle();
		return result;
	}

	public WebDriver getDriver(String url) {
		WindowsUtils.killByName("chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\imran\\workspace6\\FirstMavenProject\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		return driver;
	}

	// Open Specific browser (Developed by Imran on 10/13/2017)(Anyone can
	// Re-use now or 40 years later for any client)
	// Getting webDriver and navigate the provided URL
	// Input: URL of the webpage, Browser Name.
	// Output: driver
	// Drawback: It opens few browsers. (This is the overloaded method to cover
	// more browsers)
	public WebDriver getDriver(String BrowserName, String url) {

		BrowserName = BrowserName.toUpperCase();
		switch (BrowserName) {
		case "CHROME":
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\imran\\workspace6\\FirstMavenProject\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "FIREFOX":
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\imran\\workspace6\\FirstMavenProject\\driver\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "MICROSOFE EDGE":
			System.setProperty("webdriver.edge.driver",
					"C:\\Users\\imran\\workspace6\\FirstMavenProject\\driver\\MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
			break;
		case "IE":
			System.setProperty("webdriver.ie.driver",
					"C:\\Users\\imran\\workspace6\\FirstMavenProject\\driver\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;
		}
		driver.get(url);
		return driver;
	}

	public static void ScrollDownAndUp(WebDriver driver) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		// ScrollDown
		jse.executeScript("window.scrollBy(0,250)", "");
		waitTime(2000);
		jse.executeScript("window.scrollBy(0,500)", "");
		waitTime(2000);
		jse.executeScript("window.scrollBy(0,750)", "");
		waitTime(2000);
		jse.executeScript("window.scrollBy(0,1000)", "");
		// ScrollUp
		int j, m;
		j = 0;
		m = -250;
		while (j < 4) {
			// System.out.println(m);
			waitTime(2000);
			jse.executeScript("window.scrollBy(0," + m + ")", "");
			m = m - 250;
			j++;
		}
	}

	// Method overloading (Updated on 11/13/2017)
	public static void ScrollDownAndUp(WebDriver driver, int UpperBound) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		// ScrollDown
		int count = UpperBound / 100;
		count = Math.round(count);
		int k;
		k = 100;
		for (int i = 0; i < count - 1; i++) {
			jse.executeScript("window.scrollBy(0," + k + ")", "");
			waitTime(2000);
			k = k + 100;
		}
		// ScrollUp
		int j, m;
		j = 0;
		m = -100;
		while (j < count) {
			// System.out.println(m);
			waitTime(2000);
			jse.executeScript("window.scrollBy(0," + m + ")", "");
			m = m - 100;
			j++;
		}
	}

	// Developed BY "MD SHAHAJADA IMRAN" on 11/23/17
	public static void scrolldown(WebDriver driver, int UpperBound) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		// ScrollDown
		int count = UpperBound / 100;
		count = Math.round(count);
		int k;
		k = 100;
		for (int i = 0; i < count; i++) {
			jse.executeScript("window.scrollBy(0," + k + ")", "");
			waitTime(2000);
			k = k + 50;
		}
	}

}
