import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.os.WindowsUtils;

public class ScreenShots {

	public static void main(String[] args) {
		WindowsUtils.killByName("chromedriver.exe");
		WebDriver driver = null;
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\imran\\workspace6\\FirstMavenProject\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.walmart.com/");
		CAPTURESCREEN(driver);

	}
	
	  
	    // CAPTURESCREEN ((Developed by Imran on 12/16/2017)(Anyone can Re-use now or 40 years later for any client))
		// This function/method will capture screen shot of current page and save in C:\\temp\\ folder.
		// Output: This function/method will not return anything. it will save a png file in the mentioned location.
		// Input: WebDriver driver
	    //drawback: Location where files will be saved is Hard coded. 
		
	public static void CAPTURESCREEN(WebDriver driver) {
		// Take screenshot and store as a file format
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		if (src.exists()) {
			System.out.println("src has value");
		}
		//System.out.println(src.exists());
		// now copy the screenshot to desired location using copyFile method
		try {
			FileUtils.copyFile(src, new File("c:\\tmp\\screenshot" + System.currentTimeMillis() + ".png"));
			System.out.println("Try block executed");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
