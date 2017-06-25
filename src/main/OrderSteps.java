package main;

import cucumber.api.java.Before;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class OrderSteps {
    private WebDriver driver;
    private String baseUrl;
    LoginPage loginPage;
    HomePage homePage;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "D:\\downloads\\avtotests\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "http://redmine-train.dev.thumbtack.net:3000/";
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    @After
    public void logOut() throws Exception {
        homePage.logout();
        driver.close();
    }

    @Given("^go to login page")
    public void goToLoginPage() {
        driver.get(baseUrl + "/login");
    }

    @When("^enter user name (\\w+)$")
    public void enterUserName(String username) {
        loginPage.getNameInput().clear();
        loginPage.getNameInput().sendKeys(username);
    }

    @When("^enter password (\\w+)$")
    public void enterPassword(String password) {
        loginPage.getPasswdInput().clear();
        loginPage.getPasswdInput().sendKeys(password);
    }

    @When("^click submit")
    public void clickSubmit() {
        loginPage.getLoginButton().click();
    }

    @Then("^successfully logged in as (\\w+)$")
    public void checkLogin(String client) {
        Assert.assertTrue(homePage.isLinkPresent(client));
    }
}



