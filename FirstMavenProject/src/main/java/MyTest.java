import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.os.WindowsUtils;

public class MyTest {

	public static void main(String[] args) {
	
		
	/*	boolean vOutput=isContainNewMeric(";vjon876evouw");
		if (vOutput==true){
			System.out.println("The String contains newmeric number");		
		}else{
			System.out.println("The string doesn't contain any newmeric number");
		}*/
			
		MyTest MyTest=new MyTest();
		WebDriver driver;
		driver=MyTest.getDriver("IE", "http://www.hsbc.com/");

	}
    
	public static boolean isContainNewMeric(String a){
		boolean result = false;
	  // String a="fjwne;uoe5847iavwnij";
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
	
	
	//OpenBrowser
	WebDriver driver;	
	public String OpenChromeBrowser(String url){
		String result=null;
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\imran\\workspace6\\FirstMavenProject\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(url);
		waitTime(5000);
		result=driver.getTitle();	
		return result;
	}
	
	
       //Open Specific browser (Developed by Imran on 10/13/2017)(Anyone can Re-use now or 40 years later for any client)
	   //Getting webDriver and navigate the provided URL 
	   //Input: URL of the webpage, Browser Name.
	   //Output: driver
	   //Drawback: It opens few browsers. (This is the overloaded method to cover more browsers)
	public WebDriver getDriver(String BrowserName,String url) {
		WindowsUtils.killByName("chromedriver.exe");
		BrowserName=BrowserName.toUpperCase();
	    switch (BrowserName){
	    case "CHROME":
	    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\imran\\workspace6\\FirstMavenProject\\driver\\chromedriver.exe");
			driver=new ChromeDriver();
	    	break;
	    case "FIREFOX":	    	
	    	System.setProperty("webdriver.gecko.driver", "C:\\Users\\imran\\workspace6\\FirstMavenProject\\driver\\geckodriver.exe");
			driver=new FirefoxDriver();			
	    	break;	
	    case "MICROSOFE EDGE":	    	
	    	System.setProperty("webdriver.edge.driver", "C:\\Users\\imran\\workspace6\\FirstMavenProject\\driver\\MicrosoftWebDriver.exe");
	    	driver = new EdgeDriver();			
	    	break;
	    case "IE":	    	
	    	System.setProperty("webdriver.ie.driver", "C:\\Users\\imran\\workspace6\\FirstMavenProject\\driver\\IEDriverServer.exe");
	    	driver = new InternetExplorerDriver();			
	    	break;		
	    }
	    driver.get(url);
	    return driver;
	}
	
	//Getting webDriver and navigate the provided URL 
	//Input: URL of the webpage.
	//Output: driver
	//Drawback: It opens only GoogleChrome Browser. (This method is overloaded to cover more browsers)
	public WebDriver getDriver(String url) {
		WindowsUtils.killByName("chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\imran\\workspace6\\FirstMavenProject\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(url);			
	    return driver;
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
}
