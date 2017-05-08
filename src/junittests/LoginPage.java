package junittests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	private final WebDriver driver;
	
	@FindBy(linkText="Войти")
	private WebElement loginLink;

	@FindBy(name="login")
	private WebElement loginButton;

	@FindBy(id="username")
	private WebElement nameInput;

	@FindBy(id="password")
	private WebElement passwdInput;
	
	@FindBy(linkText="Sign out")
	private WebElement logoutButton;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void login(String name, String passwd) {
		loginLink.click();
		passwdInput.clear();
		passwdInput.sendKeys(passwd);
		nameInput.clear();
		nameInput.sendKeys(name);
		loginButton.click();
	}
	
	public void logout() {
		logoutButton.click();
	}
	
	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}
