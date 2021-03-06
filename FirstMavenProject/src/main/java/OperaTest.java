import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class OperaTest {

	public static void main(String[] args) throws Exception {

		/// Experiment. Not Valid Code.
		/// Below code is not valid code. It is experiment only.

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
		// System.setProperty("opera.binary", "C:\\Program
		// Files\\Opera\\54.0.2952.64\\opera.exe");

		/*
		 * OperaOptions op = new OperaOptions(); op.setBinary(new File(
		 * "C:\\Program Files\\Opera\\55.0.2994.47\\opera.exe")); OperaDriver
		 * driver = new OperaDriver(op);
		 * 
		 * //WebDriver driver = new OperaDriver();
		 * driver.get("https://www.google.com/");
		 */

		DesiredCapabilities capabilities = DesiredCapabilities.opera();
		capabilities.setCapability("opera.binary", "C:\\Program Files\\Opera\\55.0.2994.47\\opera.exe");
		OperaDriver driver = new OperaDriver(capabilities);
		driver.get("https://www.linkedin.com/in/md-shahajada-imran");

	}

}
