import org.testng.annotations.Test;

public class ApplyFirst extends afterLoginIn.CommonAPI {

	
	@Test(enabled=true)
	public void doThisBeforeAllTestsExecution(){
		//Delete all files from the Screen Shot folder at the beginning of the test execution
		String vFolderPath = "C:\\Users\\imran\\workspace6\\FirstMavenProject\\ScreenShots";
		DeletAllFilesFromTheFolder(vFolderPath);
	}
}
