/**
 * 
 */
package Dow;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.os.WindowsUtils;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import afterLoginIn.CommonAPI;

/**
 * @author md shahajada imran
 *
 */
public class TestSet_Dow extends CommonAPI {
	@BeforeMethod
	public void SetUpPreDataMethod() {
		System.out.println("Before Each Test  executed");
		WindowsUtils.killByName("chromedriver.exe");
		WindowsUtils.killByName("iexplore.exe");
		WindowsUtils.killByName("geckodriver.exe");
		WindowsUtils.killByName("MicrosoftWebDriver.exe");
		WindowsUtils.killByName("MicrosoftEdge.exe");
	}

	// Technical Requirement 101:Find out how many links(a) and buttons(button)
	// in the page and Highlight all of those.
	@Test(enabled = true)
	public void TC_101_HighlightLinksAndButton() {
		String vBaseURL = "https://www.dow.com/en-us/markets-and-solutions/energy-and-water";
		String wBrowser = "FIREFOX";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver(wBrowser, vBaseURL);
		waitTime(4000);

		try {
			WebElement oAcceptButton = driver.findElement(By.xpath("/html/body/div[2]/div/button[1]"));
			HighLight_Element(driver, oAcceptButton);
			waitTime(2000);
			oAcceptButton.click();
		} catch (Exception e) {
		}

		// finding out how many links in the page
		List<WebElement> listOfLinks = driver.findElements(By.tagName("a"));
		// Highlight all of those links.
		HighLight_Elements(driver, listOfLinks);
		driver.navigate().refresh();
		// finding out how many buttons in the page
		List<WebElement> listOfButtons = driver.findElements(By.tagName("button"));
		// Highlight all of those Buttons.
		HighLight_Elements(driver, listOfButtons);
	}

	// Business Requirement 102: Users are able to mouseover and view data in
	// the given page.
	// Technical Requirement 102: Use wide range of CSSselectors for scripting.
	@Test(enabled = true)
	public void TC_102_WideRangeOfCSSselectors() {
		String vBaseURL = "https://www.dow.com/en-us";
		String wBrowser = "FIREFOX";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver(wBrowser, vBaseURL);
		waitTime(4000);

		// "try catch" block is used so that if the popup window does not show
		// up then also the script will continue.
		try {
			WebElement oAcceptButton = driver.findElement(By.xpath("/html/body/div[2]/div/button[1]"));
			HighLight_Element(driver, oAcceptButton);
			waitTime(2000);
			oAcceptButton.click();
		} catch (Exception e) {
		}

		ArrayList<WebElement> arrMyList = new ArrayList<WebElement>();
		// CSSSelector with "href" attribute and exact value.
		arrMyList.add(driver.findElement(By.cssSelector("a[href*='https://www.dow.com/en-us/markets-and-solutions']")));
		// standard CSSSelector.
		arrMyList.add(driver.findElement(By.cssSelector(".nav-level-1 > li:nth-child(3) > a:nth-child(1)")));
		arrMyList.add(driver.findElement(By.xpath("/html/body/header/div/div[2]/nav/ul/li[4]/a")));
		// CSSSelector with "title" attribute and exact value.
		arrMyList.add(driver.findElement(By.cssSelector("a[title*='Careers']")));
		// CSSselector with "class" attribute and "Starts with" value.
		arrMyList.add(driver.findElement(By.cssSelector("a[class^='cl-btn cl-btn--feature cl-btn']")));
		// CSSselector with "class" attribute and "Ends with" value.
		arrMyList.add(driver.findElement(By.cssSelector("a[class$='util-regions__icon util-icon']")));
		// CSSSelector with 3 attributes (href, title, target) and exact values.
		arrMyList.add(driver.findElement(By.cssSelector(
				"a[href*='http://www.dow-dupont.com/investors/default.aspx'][title*='Investors'][target*='_blank']")));
		// CSSSelector with 2 attributes and exact values.
		arrMyList.add(
				driver.findElement(By.cssSelector("a[href*='https://www.dow.com/en-us/events'][title*='Events']")));

		// Mouse Over.
		for (WebElement v : arrMyList) {
			HighLight_Element(driver, v);
			Actions action = new Actions(driver);
			action.moveToElement(v).build().perform();
			waitTime(2000);
		}

	}

	// Not a Requirement 103: Explore CSSselector
	@Test(enabled = true)
	public void TC_103_CSSselectorS() {
		String vBaseURL = "https://www.dow.com/en-us/search#t=All";
		String wBrowser = "FIREFOX";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver(wBrowser, vBaseURL);
		waitTime(4000);

		// "try catch" block is used so that if the popup window does not show
		// up then also the script will continue.
		try {
			WebElement oAcceptButton = driver.findElement(By.xpath("/html/body/div[2]/div/button[1]"));
			HighLight_Element(driver, oAcceptButton);
			waitTime(2000);
			oAcceptButton.click();
		} catch (Exception e) {
		}
		ArrayList<WebElement> arrMyList = new ArrayList<WebElement>();

		// CSSSelector with "data-id" attribute and exact value.
		arrMyList.add(driver.findElement(By.cssSelector("a[data-id*='Products']")));
		// CSSSelector with "data-caption" attribute and exact value.
		arrMyList.add(driver.findElement(By.cssSelector("a[data-caption*='Careers']")));
		// Standard CSSSelector generated by Firefox browser
		arrMyList.add(driver.findElement(By.cssSelector("a.CoveoTab:nth-child(4)")));
		// CSSSelector with "data-id" attribute and "Ends with" value.
		arrMyList.add(driver.findElement(By.cssSelector("a[data-id$='swers']")));
		// CSSSelector with "data-id" attribute and "Starts with" value.
		arrMyList.add(driver.findElement(By.cssSelector("a[data-id^='Even']")));
		// CSSSelector with "class" attribute and "Starts with" value.
		arrMyList.add(driver.findElement(By.cssSelector("a[class^='cl-btn  search-sds-']")));
		// CSSSelector with "class" attribute and exact value.
		arrMyList.add(driver.findElement(By.cssSelector("a[class*='CoveoTab coveo-selected']")));
		// CSSSelector with 3 attributes (href, title, target) and exact values.
		arrMyList.add(driver.findElement(By.cssSelector(
				"a[href*='http://www.dow-dupont.com/investors/default.aspx'][title*='Investors'][target*='_blank']")));
		// CSSSelector with 2 attributes(href,title) and exact values.
		arrMyList.add(
				driver.findElement(By.cssSelector("a[href*='https://www.dow.com/en-us/events'][title*='Events']")));

		// Mouse Over.
		for (WebElement v : arrMyList) {
			HighLight_Element(driver, v);
			Actions action = new Actions(driver);
			action.moveToElement(v).build().perform();
			waitTime(2000);
		}
	}

	// Requirement 104: N/A
	@Test(enabled = true)
	public void TC_104_NA() {
		String vBaseURL = "https://www.dow.com/en-us/search#t=All";
		String wBrowser = "FIREFOX";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver(wBrowser, vBaseURL);
		waitTime(4000);

		// "try catch" block is used so that if the popup window does not show
		// up then also the script will continue.
		try {
			WebElement oAcceptButton = driver.findElement(By.xpath("/html/body/div[2]/div/button[1]"));
			HighLight_Element(driver, oAcceptButton);
			waitTime(2000);
			oAcceptButton.click();
		} catch (Exception e) {
		}

		ArrayList<WebElement> arrMyList = new ArrayList<WebElement>();

		arrMyList.add(driver.findElement(By.cssSelector("div[class*='coveo-label']")));
		arrMyList.add(driver.findElement(By.cssSelector("div[class*='coveo-checkbox']")));
		arrMyList.add(driver.findElement(By.cssSelector("span[class*='coveo-caption']")));
		arrMyList.add(driver.findElement(By.cssSelector("span[class*='coveo-count']")));
		arrMyList.add(driver.findElement(By.cssSelector("span[class*='CoveoQuerySummary']")));
		arrMyList.add(driver.findElement(By.linkText("X Clear All")));
		arrMyList.add(driver.findElement(By.cssSelector("a[itemtype^='http://schema.org']")));
		arrMyList.add(driver.findElement(By.cssSelector("a[href*='javascript:'][class*='coveo-more coveo-active']")));

		// Mouse Over.
		for (WebElement v : arrMyList) {
			HighLight_Element(driver, v);
			Actions action = new Actions(driver);
			action.moveToElement(v).build().perform();
			waitTime(2000);
		}

	}

	// Requirement 105: TBD
	@Test(enabled = true)
	public void TC_105_TBD() {
		String vBaseURL = "https://www.dow.com/en-us/contact-us";
		String wBrowser = "FIREFOX";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver(wBrowser, vBaseURL);
		waitTime(4000);

		// "try catch" block is used so that if the popup window does not show
		// up then also the script will continue.
		try {
			WebElement oAcceptButton = driver.findElement(By.xpath("/html/body/div[2]/div/button[1]"));
			HighLight_Element(driver, oAcceptButton);
			waitTime(2000);
			oAcceptButton.click();
		} catch (Exception e) {
		}

		// Select all data from list one by one.
		for (int i = 1; i < 12; i++) {
			WebElement oDropDownList = driver.findElement(
					By.cssSelector("select[class*='notjs cl-drop-links-block__select'][name*='subject_Default']"));
			HighLight_Element(driver, oDropDownList);
			Select dropdown2 = new Select(oDropDownList);
			dropdown2.selectByIndex(i);
			waitTime(1000);
			scrolldown(driver, 300);
			waitTime(3000);
		}
	}

}
