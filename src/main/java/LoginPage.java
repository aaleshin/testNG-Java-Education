package main.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(linkText = "Войти")
    private WebElement loginLink;

    @FindBy(name = "login")
    private WebElement loginButton;

    @FindBy(id = "username")
    private WebElement nameInput;

    @FindBy(id = "password")
    private WebElement passwdInput;

    @FindBy(css = "div.flash.error")
    public WebElement error;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public HomePage login(String name, String passwd) {
        loginLink.click();
        passwdInput.clear();
        passwdInput.sendKeys(passwd);
        nameInput.clear();
        nameInput.sendKeys(name);
        loginButton.click();
        return new HomePage(driver);
    }
    public LoginPage notLogin(String name, String passwd) {
        loginLink.click();
        passwdInput.clear();
        passwdInput.sendKeys(passwd);
        nameInput.clear();
        nameInput.sendKeys(name);
        loginButton.click();
        return new LoginPage(driver);
    }
}
