package main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CommonPage extends BasePage {
    @FindBy(linkText="Sign out")
    private WebElement logoutButton;

    public CommonPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage logout() {
        logoutButton.click();
        return new LoginPage(driver);
    }
}
