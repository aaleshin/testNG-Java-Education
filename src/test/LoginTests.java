package test;

import java.util.concurrent.TimeUnit;

import main.HomePage;
import main.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTests {
    private WebDriver driver;
    private String baseUrl;
    private static final String name = "aleshin";
    private static final String passwd = "547348";
    private static final String client = "Aleshin";
    private static final String login = "Войти";


    @BeforeClass
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "D:\\downloads\\avtotests\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "http://redmine-train.dev.thumbtack.net:3000/";
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

        Assert.assertTrue(page.isElementPresent(By.linkText(client)));
        page.logout();
    }

    @Test
    public void testLogout() throws Exception {
        driver.get(baseUrl + "/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage = loginPage.login(name, passwd).logout();

        Assert.assertTrue(loginPage.isElementPresent(By.linkText(login)));
    }

    @Test
    public void testErrorLogin() throws Exception {
        final String wrongname = "aleshina";
        final String wrongpasswd = "547348a";
        final String exept = "Неправильное имя пользователя или пароль";
        driver.get(baseUrl + "/");

        LoginPage loginPage = new LoginPage(driver);
        HomePage page = loginPage.login(wrongname, wrongpasswd);

        Assert.assertEquals(exept, page.error.getText());
    }
}