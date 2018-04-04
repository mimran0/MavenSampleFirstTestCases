package hsbc;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.os.WindowsUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import afterLoginIn.CommonAPI;
/**
 * @author md shahajada imran
 *
 */
public class TestSetC extends afterLoginIn.CommonAPI{
	        //This method will be executed once before the test set that contains by this class "TestSetA"
			@BeforeTest
			public void SetUpPreData(){
				System.out.println("Before TestSet  executed");
				WindowsUtils.killByName("chromedriver.exe");			
			}
			
			//this method will be executed before every test
			@BeforeMethod
			public void SetUpPreDataMethod(){
				System.out.println("Before Each Test  executed");
				WindowsUtils.killByName("chromedriver.exe");			
			}
			
       //Requirement 601: Users are able to view drop down lists of those 5 web elements. 
			@Test(enabled=true)
			public void displayMousOverDropdownList(){
				String vBaseURL = "http://www.hsbc.com";
				CommonAPI CommonAPI = new CommonAPI();
				WebDriver driver = CommonAPI.getDriver(vBaseURL);
				waitTime(3000);
				//driver.manage().window().maximize();
				waitTime(2000);
				//list of id's
				String[] list = new String[5];
				list[0] = "//*[@id=\"navigation\"]/li[1]/a";
				list[1] = "//*[@id=\"navigation\"]/li[2]/a";
				list[2] = "//*[@id=\"navigation\"]/li[3]/a";
				list[3] = "//*[@id=\"navigation\"]/li[4]/a";
				list[4] = "//*[@id=\"navigation\"]/li[5]/a";
				//mouseover
				for (String v : list) {
					Actions action = new Actions(driver);
					WebElement we = driver.findElement(By.xpath(v));
					action.moveToElement(we).build().perform();
					waitTime(2000);		
				}
			}
			
		//Note: Below Script covers 3 requirements. 
		//Requirement 602: Users are able to select all countries from online banking page and cancel pop-up window on the next page.
		//Requirement 603: Pop up Window opens up for each country selected with valid expected texts. 
		//Requirement 604: Users are able to close pop up window for each country selected. 	
			@Test(enabled=true)
			public void CountryListOnOnlineBanking(){
				String vBaseURL = "http://www.hsbc.com";
				CommonAPI CommonAPI = new CommonAPI();
				WebDriver driver = CommonAPI.getDriver(vBaseURL);
				waitTime(3000);
				//driver.manage().window().maximize();
				waitTime(2000);
				driver.findElement(By.id("GoToInternetBanking")).click();
				waitTime(5000);
				for(int i=2;i<40;i++){
					driver.findElement(By.xpath("//*[@id=\"Form1\"]/div[3]/div[5]/div/div[2]/div/article[3]/section[1]/fieldset/div/div/div[1]/div[2]/span")).click();
					waitTime(2000);
					driver.findElement(By.xpath("//*[@id=\"Form1\"]/div[3]/div[5]/div/div[2]/div/article[3]/section[1]/fieldset/div/div/div[2]/div[1]/a["+i+"]")).click();
					waitTime(2000);
					driver.findElement(By.xpath("//*[@id=\"Form1\"]/div[3]/div[5]/div/div[2]/div/article[3]/section[1]/fieldset/div/a/span")).click();
					waitTime(2000);
					String vCheckPointText_Actual=driver.findElement(By.id("externalLink")).getText();
					System.out.println(vCheckPointText_Actual);
			        String vCheckPointText_Expected = "You are leaving HSBC.com\n"
					+ "Please be aware that the external site policies, or those of another HSBC Group website, may differ from our website terms and conditions and privacy policy. The next site will open in a new browser window or tab.\n"
					+ "Cancel\n" + "I understand, let’s proceed\n"
					+ "Note: HSBC is not responsible for any content on third party sites, nor does a link suggest endorsement of those sites and/or their content.";
				    Assert.assertEquals(vCheckPointText_Expected, vCheckPointText_Actual);				   
				    driver.findElement(By.id("contentplaceholder_0_CloseWindow")).click();
				    waitTime(2000);
				}
				
			}
			
			//Requirement 605: Scroll up & down moves the page from top to button and button to top. (HSBC Home page)
			@Test(enabled=true)
			public void scrollUpAndDown(){
				String vBaseURL = "http://www.hsbc.com";
				CommonAPI CommonAPI = new CommonAPI();
				WebDriver driver = CommonAPI.getDriver(vBaseURL);
				waitTime(3000);
				//driver.manage().window().maximize();			
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				//ScrollDown
				jse.executeScript("window.scrollBy(0,250)", "");
				waitTime(2000);
				jse.executeScript("window.scrollBy(0,500)", "");
				waitTime(2000);
				jse.executeScript("window.scrollBy(0,750)", "");
				waitTime(2000);
				jse.executeScript("window.scrollBy(0,1000)", "");
				//ScrollUp
				int j,m;
				j=0;
				m=-250;
				while(j<4){					
					//System.out.println(m);
					waitTime(2000);
					jse.executeScript("window.scrollBy(0,"+m+")", "");
					m=m-250;
					j++;
				}
			}
			
			//Note: Below Script covers 3 test requirements in 3 different browsers.Total 9 test cases.
			//Requirement 602: Users are able to select all countries from online banking page and cancel pop-up window on the next page.
			//Requirement 603: Pop up Window opens up for each country selected with valid expected texts. 
			//Requirement 604: Users are able to close pop up window for each country selected. 	
				@Test(enabled=false)// disabling because different browser has different locator for each webElement or object. Therefore need separate script for each browser. Because of this 1 automation script can't cover these 9 manual test cases.
				public void CountryListOnOnlineBanking3Browsers(){
					String[] BrowserName=new String[3];
					BrowserName[0]="firefox";BrowserName[1]="MICROSOFE EDGE";BrowserName[2]="IE";					
					for(String v:BrowserName){
						String vBaseURL = "http://www.hsbc.com";
						CommonAPI CommonAPI = new CommonAPI();
						WebDriver driver = CommonAPI.getDriver(v,vBaseURL);
						waitTime(3000);
						//driver.manage().window().maximize();
						waitTime(2000);
						driver.findElement(By.id("GoToInternetBanking")).click();
						waitTime(5000);
						for(int i=2;i<40;i++){
							driver.findElement(By.xpath("//*[@id=\"Form1\"]/div[3]/div[5]/div/div[2]/div/article[3]/section[1]/fieldset/div/div/div[1]/div[2]/span")).click();
							waitTime(2000);
							driver.findElement(By.xpath("//*[@id=\"Form1\"]/div[3]/div[5]/div/div[2]/div/article[3]/section[1]/fieldset/div/div/div[2]/div[1]/a["+i+"]")).click();
							waitTime(2000);
							driver.findElement(By.xpath("//*[@id=\"Form1\"]/div[3]/div[5]/div/div[2]/div/article[3]/section[1]/fieldset/div/a/span")).click();
							waitTime(2000);
							String vCheckPointText_Actual=driver.findElement(By.id("externalLink")).getText();
							System.out.println(vCheckPointText_Actual);
					        String vCheckPointText_Expected = "You are leaving HSBC.com\n"
							+ "Please be aware that the external site policies, or those of another HSBC Group website, may differ from our website terms and conditions and privacy policy. The next site will open in a new browser window or tab.\n"
							+ "Cancel\n" + "I understand, let’s proceed\n"
							+ "Note: HSBC is not responsible for any content on third party sites, nor does a link suggest endorsement of those sites and/or their content.";
						    Assert.assertEquals(vCheckPointText_Expected, vCheckPointText_Actual);				   
						    driver.findElement(By.id("contentplaceholder_0_CloseWindow")).click();
						    waitTime(2000);
						}												
					}					
				}
}
