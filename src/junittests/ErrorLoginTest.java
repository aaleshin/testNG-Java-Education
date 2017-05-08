package junittests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ErrorLoginTest {
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
	public void testErrorLogin() throws Exception {
		driver.get(baseUrl + "/");
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.login("aleshina", "547348a");
		
		Assert.assertEquals("Неправильное имя пользователя или пароль",
				driver.findElement(By.cssSelector("div.flash.error")).getText());
	}

	@AfterClass
	public void tearDown() throws Exception {
		driver.quit();
	}
}