package amazon;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.os.WindowsUtils;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import afterLoginIn.CommonAPI;

public class TestSetAmazon extends afterLoginIn.CommonAPI {
	
	//this method will be executed before every test
			@BeforeMethod
			public void SetUpPreDataMethod(){
				System.out.println("Before Each Test  executed");
				WindowsUtils.killByName("chromedriver.exe");			
			}
			
			//Requirement 101: Users are able to search in amazon website
			@Test(enabled=true)
			public void SearchOnLandingPage(){
				String[] list = new String[10];
				list[0] = "T-shart";
				list[1] = "panty";
				list[2] = "cap";
				list[3] = "tie";
				list[4] = "belt";
				list[5] = "bra";
				list[6] = "watch";
				list[7] = "Phone";
				list[8] = "Computer";
				list[9] = "Candle";
				String vBaseURL = "https://www.amazon.com";
				CommonAPI CommonAPI = new CommonAPI();
				WebDriver driver = CommonAPI.getDriver(vBaseURL);
				waitTime(5000);
				//driver.manage().window().maximize(); //commenting out as Google Chrome version 62 is not supported
				
				for(int i=0;i<list.length;i++){
					driver.findElement(By.id("twotabsearchtextbox")).sendKeys(list[i]);					
					waitTime(3000);
					//Hit enter from the keyboard starts here
					Robot r = null;
					try {
						r = new Robot();
					} catch (AWTException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					r.keyPress(KeyEvent.VK_ENTER);
					r.keyRelease(KeyEvent.VK_ENTER);
					//Hit enter from the keyboard Ends here					
					waitTime(5000);
					driver.findElement(By.id("twotabsearchtextbox")).clear();
				}
				
			}
			
			//Requirement 102: Select all values from the search drop down list
			@Test(enabled=true)
			public void TC_102(){
				String vBaseURL = "https://www.amazon.com";
				CommonAPI CommonAPI = new CommonAPI();
				WebDriver driver = CommonAPI.getDriver(vBaseURL);
				waitTime(5000);			
								
				int i;
				i=0;
				while(i<=50){
					Select dropdown2 = new Select(driver.findElement(By.id("searchDropdownBox")));
					dropdown2.selectByVisibleText("All Departments");
					//Hit enter from the keyboard starts here
					Robot r = null;
					try {
						r = new Robot();
					} catch (AWTException e) {
						
					}
					r.keyPress(KeyEvent.VK_ENTER);
					r.keyRelease(KeyEvent.VK_ENTER);
					//Hit enter from the keyboard Ends here	
					waitTime(2000);
					Select dropdown = new Select(driver.findElement(By.id("searchDropdownBox")));
					dropdown.selectByIndex(i);				
					waitTime(1000);
					driver.findElement(By.id("twotabsearchtextbox")).sendKeys("bra");					
					waitTime(3000);
					//Hit enter from the keyboard starts here
					//Robot r = null;
					try {
						r = new Robot();
					} catch (AWTException e) {
						
					}
					r.keyPress(KeyEvent.VK_ENTER);
					r.keyRelease(KeyEvent.VK_ENTER);
					//Hit enter from the keyboard Ends here					
					waitTime(5000);
					driver.findElement(By.id("twotabsearchtextbox")).clear();
					i++;
				}
			}

}
