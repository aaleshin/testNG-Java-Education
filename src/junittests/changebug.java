package junittests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class changebug {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

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
		driver.findElement(By.linkText("Войти")).click();
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("547348");
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("aleshin");
		driver.findElement(By.name("login")).click();
		driver.findElement(By.linkText("High School: Test Automation")).click();
		driver.findElement(By.linkText("New issue")).click();
		new Select(driver.findElement(By.id("issue_tracker_id"))).selectByVisibleText("Bug");
		driver.findElement(By.id("issue_subject")).clear();
		driver.findElement(By.id("issue_subject")).sendKeys("new bag2");
		driver.findElement(By.id("issue_description")).clear();
		driver.findElement(By.id("issue_description")).sendKeys("123");
		driver.findElement(By.name("commit")).click();
		driver.findElement(By.linkText("Update")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("More")).click();
		new Select(driver.findElement(By.id("issue_priority_id"))).selectByVisibleText("Low");
		driver.findElement(By.id("issue_description")).clear();
		driver.findElement(By.id("issue_description")).sendKeys("1234");
		driver.findElement(By.cssSelector("#issue-form > input[name=\"commit\"]")).click();
		Assert.assertEquals("1234", driver.findElement(By.cssSelector("div.wiki > p")).getText());
		Assert.assertEquals("Low", driver.findElement(By.cssSelector("td.priority")).getText());
		driver.findElement(By.linkText("Sign out")).click();
	}

	@AfterClass
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			Assert.fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	protected boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
}