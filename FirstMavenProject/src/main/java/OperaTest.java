import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class OperaTest {

	public static void main(String[] args) {

		/// Experiment. Not Valid Code.

		/*
		 * WebDriver driver=null; System.setProperty("webdriver.opera.driver",
		 * "C:\\Users\\imran\\workspace6\\FirstMavenProject\\driver\\operadriver.exe"
		 * ); driver = new OperaDriver(); driver.get("https://www.google.com/");
		 */

		/*
		 * System.setProperty("webdriver.opera.driver",
		 * "C:\\Users\\imran\\workspace6\\FirstMavenProject\\driver\\operadriver.exe"
		 * ); OperaOptions op = new OperaOptions(); //op.setBinary(
		 * "C:\\Program Files\\Opera\\53.0.2907.106\\opera.exe");
		 * //op.setBinary(new File(
		 * "C:\\Program Files\\Opera\\53.0.2907.106\\opera.exe")); WebDriver
		 * driver = new OperaDriver(op); driver.manage().window().maximize();
		 * driver.get("https://www.google.com/");
		 */

		/*
		 * DesiredCapabilities c = DesiredCapabilities.opera();
		 * c.setCapability("opera.binary",
		 * "C:\\Program Files\\Opera\\53.0.2907.106\\opera.exe");
		 * System.setProperty("webdriver.opera.driver",
		 * "C:\\Users\\imran\\workspace6\\FirstMavenProject\\driver\\operadriver.exe"
		 * ); WebDriver driver = new OperaDriver(c);
		 * driver.get("https://www.google.com/");
		 */

		System.setProperty("webdriver.opera.driver",
				"C:\\Users\\imran\\workspace6\\FirstMavenProject\\driver\\operadriver.exe");
		System.setProperty("opera.binary", "C:\\Program Files\\Opera\\53.0.2907.106\\opera.exe");
		WebDriver driver = new OperaDriver();
		driver.get("https://www.google.com/");
	}

}
