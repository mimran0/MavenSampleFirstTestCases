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
		driver.get("https://www.mcdonalds.com/");
		// CAPTURESCREEN(driver);
		//String vFolderPath = "C:\\Users\\imran\\workspace6\\FirstMavenProject\\ScreenShots";
		//DeletAllFilesFromTheFolder(vFolderPath);
	}

	// CAPTURESCREEN ((Developed by Imran on 12/16/2017)(Anyone can Re-use now
	// or 40 years later for any client)).
	// This function/method will capture screen shot of current page and save in
	// C:\\temp\\ folder.
	// Output: This function/method will not return anything. it will save a png
	// file in the mentioned location.
	// Input: WebDriver driver.
	// drawback: Location where files will be saved is Hard coded.

	public static void CAPTURESCREEN(WebDriver driver) {
		// Take screenshot and store as a file format
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		if (src.exists()) {
			System.out.println("src has value");
		}
		// System.out.println(src.exists());
		// now copy the screenshot to desired location using copyFile method
		try {
			// FileUtils.copyFile(src, new File("c:\\tmp\\screenshot" +
			// System.currentTimeMillis() + ".png"));
			FileUtils.copyFile(src, new File("C:\\Users\\imran\\workspace6\\FirstMavenProject\\ScreenShots\\screenshot"
					+ System.currentTimeMillis() + ".png"));
			System.out.println("Try block executed");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// DeletAllFilesFromTheFolder ((Developed by Imran on 12/17/2017)(Anyone can Re-use now
	// or 40 years later for any client)).
	// This method will delete all files from a given folder.
	// Output: This method will not return anything. it will delete all files from a folder.
	// Input: String FolderPath. The path of the folder that contains all the files.
	public static void DeletAllFilesFromTheFolder(String FolderPath) {
		// Set the path of the folder that contains all the files
		File file = new File(FolderPath);
		// Creating the list of files and store in the "files" variable.
		File[] files = file.listFiles();
		int len = files.length;
		if (len == 0) {
			System.out.println("The folder '"+FolderPath+"' is already empty. Therefore nothing to delete");
		}
		// System.out.println(len);
		// For each file in the folder, first print the name in the console then
		// delete it.
		int i = 0;
		for (File f : files) {
			if (i == 0) {
				System.out.println("Total " + len + " files have been deleted");
				System.out.println("Below is the list of files that have been deleted");
			}
			System.out.println(f.getName());
			f.delete();
			i++;
		}
	}

}
