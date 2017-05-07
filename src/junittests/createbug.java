package junittests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class createbug {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	System.setProperty("webdriver.gecko.driver", "D:\\downloads\\avtotests\\geckodriver.exe");  
    driver = new FirefoxDriver();
    baseUrl = "http://redmine-train.dev.thumbtack.net:3000/";
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  }

  @Test
  public void testCreateBug() throws Exception {
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
    driver.findElement(By.id("issue_subject")).sendKeys("probe");
    driver.findElement(By.id("issue_description")).clear();
    driver.findElement(By.id("issue_description")).sendKeys("test bug");
    driver.findElement(By.xpath("(//input[@id='issue_watcher_user_ids_'])[@value=\"168\"]")).click();
    driver.findElement(By.name("commit")).click();
    driver.findElement(By.linkText("Issues")).click();
    driver.findElement(By.linkText("probe")).click();
    assertEquals("test bug", driver.findElement(By.cssSelector("div.wiki > p")).getText());
    driver.findElement(By.linkText("Sign out")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
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

  private boolean isAlertPresent() {
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