package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends CommonPage {
	@FindBy(linkText="High School: Test Automation")
	private WebElement highSchoolLink;
	
	@FindBy(linkText="New issue")
	private WebElement issueLink;
	
	@FindBy(linkText="Issues")
	private WebElement newIssue;
	
	@FindBy(linkText="Probe")
	private WebElement createdBug;

	@FindBy(css="div.flash.error")
	public WebElement error;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public IssuePage newIssue() {
		highSchoolLink.click();
		issueLink.click();
        return new IssuePage(driver);
    }
	
	public HomePage createdIssue(){
		newIssue.click();
		createdBug.click();
		return new HomePage(driver);
	}
}

