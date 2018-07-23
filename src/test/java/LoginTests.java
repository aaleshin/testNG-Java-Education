package test.java;

import java.util.concurrent.TimeUnit;

import main.java.HomePage;
import main.java.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTests {
    private WebDriver driver;
    private String baseUrl;
    private static final String name = "***";
    private static final String passwd = "***";
    private static final String client = "Aleshin";
    private static final String login = "Войти";

    @BeforeClass
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "D:\\downloads\\avtotests\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "http://";
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void testLogin() throws Exception {
        driver.get(baseUrl + "/login");

        LoginPage loginPage = new LoginPage(driver);
        HomePage page = loginPage.login(name, passwd);

        Assert.assertTrue(page.isLinkPresent(client));
        page.logout();
    }

    @Test
    public void testLogout() throws Exception {
        driver.get(baseUrl + "/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage = loginPage.login(name, passwd).logout();

        Assert.assertTrue(loginPage.isLinkPresent(login));
    }

    @Test
    public void testErrorLogin() throws Exception {
        final String wrongName = "***";
        final String wrongPasswd = "***";
        final String exept = "Неправильное имя пользователя или пароль";

        driver.get(baseUrl + "/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage = loginPage.notLogin(wrongName, wrongPasswd);

        Assert.assertEquals(exept, loginPage.error.getText());
    }
}