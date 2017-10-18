/**
 * 
 */
package facebook;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.os.WindowsUtils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import afterLoginIn.CommonAPI;

/**
 * @author imran
 *
 */
public class testSetD extends afterLoginIn.CommonAPI{
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
				WindowsUtils.killByName("MicrosoftEdge.exe");
				WindowsUtils.killByName("firefox.exe");
				WindowsUtils.killByName("iexplore.exe");
			}
			
			@AfterMethod
			public void aftermethod(){				
				WindowsUtils.killByName("chromedriver.exe");	
				WindowsUtils.killByName("MicrosoftEdge.exe");
			    WindowsUtils.killByName("firefox.exe");
				WindowsUtils.killByName("iexplore.exe");
			}
			
			//Requirement 701: Users are able to login into facebook (CrossBrowser Testing)(Positive Testing)
			@Test (enabled=true)
			public void LoginAndLogout_4Browses(){
				
				ArrayList<String> list=new ArrayList<String>();
				list.add("CHROME");list.add("MICROSOFE EDGE");//list.add("FIREFOX");//list.add("IE");
				for(String v:list){
					String vBaseURL = "http://www.facebook.com";
					CommonAPI CommonAPI = new CommonAPI();
					WebDriver driver = CommonAPI.getDriver(v,vBaseURL);
					waitTime(5000);
					driver.manage().window().maximize();
					driver.findElement(By.id("email")).sendKeys("imranlimon00@gmail.com");
					driver.findElement(By.id("pass")).sendKeys("1234560y");
					driver.findElement(By.id("loginbutton")).click();				
					waitTime(6000);
					try {
						Boolean checkpoint= driver.findElement(By.xpath("//*[@id=\"u_0_b\"]/div[1]/div[1]/div/a")).isDisplayed();
						Assert.assertTrue(checkpoint);
						waitTime(2000);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					driver.findElement(By.id("pageLoginAnchor")).click();
					waitTime(4000);
					
					//driver.findElement(By.xpath("//*[@id=\"js_c\"]/div/div/ul/li[14]/a/span/span")).click();
					driver.findElement(By.xpath("/html/body/div[8]/div/div/div/div/div[1]/div/div/ul/li[14]/a/span/span")).click();
					waitTime(2000);
					Boolean LogoutCheckpoint=driver.findElement(By.id("email")).isDisplayed();
					Assert.assertTrue(LogoutCheckpoint);
				}
				
			}

			//Requirement 701: Users are able to login into facebook 
			@Test (enabled=true)
			public void LoginAndLogout_Chrome(){				
				ArrayList<String> list=new ArrayList<String>();
				list.add("CHROME");
				for(String v:list){
					String vBaseURL = "http://www.facebook.com";
					CommonAPI CommonAPI = new CommonAPI();
					WebDriver driver = CommonAPI.getDriver(v,vBaseURL);
					waitTime(5000);
					driver.manage().window().maximize();
					driver.findElement(By.id("email")).sendKeys("imranlimon00@gmail.com");
					driver.findElement(By.id("pass")).sendKeys("1234560y");
					driver.findElement(By.id("loginbutton")).click();				
					waitTime(6000);
					try {
						Boolean checkpoint= driver.findElement(By.xpath("//*[@id=\"u_0_b\"]/div[1]/div[1]/div/a")).isDisplayed();
						Assert.assertTrue(checkpoint);
						waitTime(2000);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					driver.findElement(By.id("pageLoginAnchor")).click();
					waitTime(4000);
					driver.findElement(By.xpath("/html/body/div[8]/div/div/div/div/div[1]/div/div/ul/li[14]/a/span/span")).click();
					waitTime(2000);
					Boolean LogoutCheckpoint=driver.findElement(By.id("email")).isDisplayed();
					Assert.assertTrue(LogoutCheckpoint);
				}
				
			}
			//Requirement 701: Users are able to login into facebook 
			@Test (enabled=true)
			public void LoginAndLogout_MicrosoftEdge(){				
				ArrayList<String> list=new ArrayList<String>();
				list.add("MICROSOFE EDGE");
				for(String v:list){
					String vBaseURL = "http://www.facebook.com";
					CommonAPI CommonAPI = new CommonAPI();
					WebDriver driver = CommonAPI.getDriver(v,vBaseURL);
					waitTime(5000);
					driver.manage().window().maximize();
					driver.findElement(By.id("email")).sendKeys("imranlimon00@gmail.com");
					driver.findElement(By.id("pass")).sendKeys("1234560y");
					driver.findElement(By.id("loginbutton")).click();				
					waitTime(6000);
					try {
						Boolean checkpoint= driver.findElement(By.xpath("//*[@id=\"u_0_b\"]/div[1]/div[1]/div/a")).isDisplayed();
						Assert.assertTrue(checkpoint);
						waitTime(2000);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					driver.findElement(By.id("pageLoginAnchor")).click();
					waitTime(4000);
					driver.findElement(By.xpath("/html/body/div[8]/div/div/div/div/div[1]/div/div/ul/li[14]/a/span/span")).click();
					waitTime(2000);
					Boolean LogoutCheckpoint=driver.findElement(By.id("email")).isDisplayed();
					Assert.assertTrue(LogoutCheckpoint);
				}
				
			}
			//Requirement 701: Users are able to login into facebook 
			@Test (enabled=true)
			public void LoginAndLogout_Firefox(){				
				ArrayList<String> list=new ArrayList<String>();
				list.add("FIREFOX");
				for(String v:list){
					String vBaseURL = "http://www.facebook.com";
					CommonAPI CommonAPI = new CommonAPI();
					WebDriver driver = CommonAPI.getDriver(v,vBaseURL);
					waitTime(5000);
					driver.manage().window().maximize();
					driver.findElement(By.id("email")).sendKeys("imranlimon00@gmail.com");
					driver.findElement(By.id("pass")).sendKeys("1234560y");
					driver.findElement(By.id("loginbutton")).click();				
					waitTime(6000);
					try {
						Boolean checkpoint= driver.findElement(By.xpath("//*[@id=\"u_0_b\"]/div[1]/div[1]/div/a")).isDisplayed();
						Assert.assertTrue(checkpoint);
						waitTime(4000);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}					
					//optional steps start here						
						try {
							boolean a=driver.findElement(By.xpath("/html/body/div[8]/div[2]/div/div/div/div/div[3]/div/div/div[2]/div/a[1]")).isDisplayed();
							if (a){
								System.out.println("try block got executed");
								driver.findElement(By.xpath("/html/body/div[8]/div[2]/div/div/div/div/div[3]/div/div/div[2]/div/a[1]")).click();
							}
						} catch (Exception e) {
							System.out.println("popup window did not display"+e);
						}					         
					//Optional steps end here
					driver.findElement(By.id("pageLoginAnchor")).click();
					waitTime(4000);					
					driver.findElement(By.xpath("/html/body/div[8]/div/div/div/div/div[1]/div/div/ul/li[14]/a/span/span")).click();
					waitTime(2000);
					Boolean LogoutCheckpoint=driver.findElement(By.id("email")).isDisplayed();
					Assert.assertTrue(LogoutCheckpoint);
				}
				
			}
			@Test ( enabled=true)
			public void LoginAndLogout_IE(){				
				ArrayList<String> list=new ArrayList<String>();
				list.add("IE");
				for(String v:list){
					String vBaseURL = "https://www.facebook.com";
					CommonAPI CommonAPI = new CommonAPI();
					WebDriver driver = CommonAPI.getDriver(v,vBaseURL);
					waitTime(5000);
					driver.manage().window().maximize();
					driver.findElement(By.id("email")).sendKeys("imranlimon00@gmail.com");
					driver.findElement(By.id("pass")).sendKeys("1234560y");
					driver.findElement(By.id("loginbutton")).click();				
					waitTime(6000);
					try {
						Boolean checkpoint= driver.findElement(By.xpath("//*[@id=\"u_0_b\"]/div[1]/div[1]/div/a")).isDisplayed();
						Assert.assertTrue(checkpoint);
						waitTime(2000);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					driver.findElement(By.id("pageLoginAnchor")).click();
					waitTime(4000);
					driver.findElement(By.xpath("/html/body/div[8]/div/div/div/div/div[1]/div/div/ul/li[14]/a/span/span")).click();
					waitTime(2000);
					Boolean LogoutCheckpoint=driver.findElement(By.id("email")).isDisplayed();
					Assert.assertTrue(LogoutCheckpoint);
				}
				
			}
}
