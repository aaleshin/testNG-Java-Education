package main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateIssuePage extends CommonPage {
	@FindBy(linkText="Update")
	private WebElement updateIssue;

	@FindBy(css="div.wiki > p")
	public  WebElement descriptionbug;

	@FindBy(css="td.priority")
	public  WebElement priorotycheck;

	public CreateIssuePage(WebDriver driver) {
		super(driver);
	}

	public IssuePage inspectIssue() throws InterruptedException {
		updateIssue.click();
		Thread.sleep(1000);
		return new IssuePage(driver);
	}
}
