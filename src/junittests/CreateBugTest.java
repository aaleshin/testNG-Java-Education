package junittests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateBugTest {
	private WebDriver driver;
	private String baseUrl;

	@BeforeClass
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\downloads\\avtotests\\chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "http://redmine-train.dev.thumbtack.net:3000/";
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	public void testCreateBug() throws Exception {
		driver.get(baseUrl + "/");
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.login("aleshin", "547348");
		
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.newIssue();
		
		IssuePage issuePage = PageFactory.initElements(driver, IssuePage.class);
		issuePage.createIssue("Bug", "Probe", "test bug");
		
		HomePage homePageIssue = PageFactory.initElements(driver, HomePage.class);
		homePageIssue.createdIssue();
		
		Assert.assertEquals("test bug", driver.findElement(By.cssSelector("div.wiki > p")).getText());

		loginPage.logout();
	}

	@AfterClass
	public void tearDown() throws Exception {
		driver.quit();
	}
}
