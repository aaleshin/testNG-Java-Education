package test.java;

import java.util.concurrent.TimeUnit;

import main.java.CreateIssuePage;
import main.java.HomePage;
import main.java.IssuePage;
import main.java.LoginPage;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class IssueTests {
    private WebDriver driver;
    private String baseUrl;
    private static final String name = "aleshin";
    private static final String passwd = "547348";
    private static final String type = "Bug";

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
    public void testCreateBug() throws Exception {
        final String title = "Probe";
        final String description = "test bug";

        driver.get(baseUrl + "/");

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.login(name, passwd);

        IssuePage issuePage = homePage.newIssue();

        CreateIssuePage createIssue = issuePage.createIssue(type, title, description);

        Assert.assertEquals(description, createIssue.descriptionBug.getText());

        createIssue.logout();
    }

    @Test
    public void testChangeBugTitle() throws Exception {
        final String title = "New bug 2";
        final String description = "123";
        final String bugtype = "Low";
        final String bugdescription = "1234";

        driver.get(baseUrl + "/");

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.login(name, passwd);

        IssuePage issuePage = homePage.newIssue();

        CreateIssuePage createIssuePage = issuePage.createIssue(type, title, description);

        issuePage = createIssuePage.inspectIssue();

        createIssuePage = issuePage.changeIssue(bugtype, bugdescription);

        Assert.assertEquals(bugdescription, createIssuePage.descriptionBug.getText());
        Assert.assertEquals(bugtype, createIssuePage.priorotyCheck.getText());

        createIssuePage.logout();
    }
}
