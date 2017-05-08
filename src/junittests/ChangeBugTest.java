package junittests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ChangeBugTest {
	private WebDriver driver;
	private String baseUrl;

	@BeforeClass
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\downloads\\avtotests\\chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "http://redmine-train.dev.thumbtack.net:3000/";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void testChangeBugTitle() throws Exception {
		driver.get(baseUrl + "/");

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.login("aleshin", "547348");

		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.newIssue();
		
		IssuePage issuePage = PageFactory.initElements(driver, IssuePage.class);
		issuePage.createIssue("Bug", "New bug 2", "123");

	    CreateIssuePage createIssuePage = PageFactory.initElements(driver, CreateIssuePage.class);
	    createIssuePage.inspectIssue();
	    Thread.sleep(1000);
	    
	    IssuePage changeissuePage = PageFactory.initElements(driver, IssuePage.class);
	    changeissuePage.changeIssue("Low", "1234");
		
		Assert.assertEquals("1234", driver.findElement(By.cssSelector("div.wiki > p")).getText());
		Assert.assertEquals("Low", driver.findElement(By.cssSelector("td.priority")).getText());
		
		loginPage.logout();
	}

	@AfterClass
	public void tearDown() throws Exception {
		driver.quit();
	}

	protected boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}
}