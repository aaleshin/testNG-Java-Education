package junittests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
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
	public void testLogin() throws Exception {
		driver.get(baseUrl + "/login");
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.login("aleshin", "547348");
		
		Assert.assertTrue(loginPage.isElementPresent(By.linkText("Aleshin")));
		
		loginPage.logout();
	}

	@AfterClass
	public void tearDown() throws Exception {
		driver.quit();
	}
}