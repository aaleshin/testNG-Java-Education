package junittests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class logout {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	System.setProperty("webdriver.gecko.driver", "D:\\downloads\\avtotests\\geckodriver.exe");
    driver = new FirefoxDriver();
    baseUrl = "http://redmine-train.dev.thumbtack.net:3000/";
//    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  }

  @Test
  public void testLogout() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.linkText("Войти")).click();
    Thread.sleep(2000);
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("547348");
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("aleshin");
    driver.findElement(By.name("login")).click();
    driver.findElement(By.linkText("Sign out")).click();
    assertTrue(isElementPresent(By.linkText("Войти")));
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
