import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.os.WindowsUtils;

/**
 * 
 */

/**
 * @author md shahajada imran
 *
 */
public class EmtpyMainMethod {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    WindowsUtils.killByName("chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\imran\\workspace6\\FirstMavenProject\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.linkedin.com/in/md-shahajada-imran");

	}

}
