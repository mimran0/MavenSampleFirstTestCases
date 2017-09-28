import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyTest {

	public static void main(String[] args) {
	
		
		boolean vOutput=isContainNewMeric(";vjon876evouw");
		if (vOutput==true){
			System.out.println("The String contains newmeric number");		
		}else{
			System.out.println("The string doesn't contain any newmeric number");
		}
			
		

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
