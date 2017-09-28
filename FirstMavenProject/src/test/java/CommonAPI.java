import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.os.WindowsUtils;
import org.testng.annotations.BeforeMethod;

public class CommonAPI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
  
		//below 3 lines to check if the junit jar file is configured via POM file
		int a=4; 
		int b=4;		
		Assert.assertEquals(a, b);
		
		WindowsUtils.killByName("chromedriver.exe"); //closing chromedriver browser if open any. 
		//setting the path of chrome driver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\imran\\workspace6\\FirstMavenProject\\driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver(); // creating an instance of ChromeDriver.
		driver.get("https://www.amazon.com/"); //Navigating to Amazon home page after launching Google Chrome browser(driver).
		driver.manage().window().maximize();	//Maximizing the browser	
		String[] arr=new String[4]; //declaring an array of string with 4 elements.
		//initializing 4 values into the 4 elements
		arr[0]="black hair";arr[1]="red eyes";arr[2]="pink Lips";arr[3]="T-Shartviuawebby9ipvvvvvvvvpiyru";
		System.out.println(arr.length); //printing out the array length
		//below for loop will search texts and capture search result.
		// it will also show pass if the result contains numbers.
		for(int i=0;i<arr.length;i++){
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys(arr[i]);
			waitTime(5000);
			driver.findElement(By.id("nav-search-submit-text")).submit();
			waitTime(5000);
			if(driver.findElements(By.id("s-result-count")).size()==0){ //Checking if the result element is exist or not
				System.out.println("There is no result for \""+arr[i]+"\"");			
			}else{		
				String vOutput=driver.findElement(By.id("s-result-count")).getText(); //getting the output and storing in a variable
				vOutput=vOutput.substring(8); //removing few words from the beginning of the string
				System.out.println(vOutput);
				boolean isContainNM=isContainNewMeric(vOutput);
				if(isContainNM==true){
					System.out.println("Passed because \""+vOutput+"\" contains newmeric number");
				}else{
					System.out.println("Failed because \""+vOutput+"\" does not contain any newmeric number");
				}		
				driver.findElement(By.id("twotabsearchtextbox")).clear();
			}
			}
	}
	//method to wait a specific time
	public static void waitTime(int a){
		try {
			Thread.sleep(a);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//method that checks if a string contains a numeric number
	public static boolean isContainNewMeric(String a){
		boolean result = false;	 
		for(int i=0;i<=a.length()-1;i++){			
			char b=a.charAt(i);
			boolean isNM=Character.isDigit(b);
			// System.out.println(isNM);			  
			//System.out.println(b);
			if(isNM==true){
				result=true;
				break;
			}		  
		}		
		return result;
	}
	
	@BeforeMethod
	public void doBeforeEveryMethod(){
		//CLOSING ALL OPEN BROWSERS before every method/(@test) executed
				WindowsUtils.killByName("chromedriver.exe");
				WindowsUtils.killByName("chrome.exe");
	}
}
