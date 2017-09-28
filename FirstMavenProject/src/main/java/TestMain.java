
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.os.WindowsUtils;


public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WindowsUtils.killByName("chromedriver.exe");
		//String vURL="https://www.amazon.com/ap/signin?_encoding=UTF8&ignoreAuthState=1&openid.assoc_handle=usflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2F%3Fref_%3Dnav_signin&switch_account=";
		String vURL="http://www.ienjoybeauty.com/";
		WebDriver driver;
		MyTest LimonTest=new MyTest();		
		String vLoginPageCheckPoint=LimonTest.OpenChromeBrowser(vURL);
		System.out.println(vLoginPageCheckPoint);	
		String vActualPageCheckPoint="ienjoybeauty -Hair Care Products and Skin Care Products Sale in ienjoybeauty.com";		
		if(vLoginPageCheckPoint.equals(vActualPageCheckPoint)==true){
			System.out.println("pass");
		}else{
			System.out.println("Expected: "+"\""+vActualPageCheckPoint+"\""+" But Actualy showed "+"\""+vLoginPageCheckPoint+"\"");
		}	
		
	}
}
