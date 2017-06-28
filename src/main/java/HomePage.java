package main.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends CommonPage {
    @FindBy(linkText = "My page")
    private WebElement myPageLink;

    @FindBy(linkText = "High School: Test Automation")
    private WebElement highSchoolLink;

    @FindBy(linkText = "New issue")
    private WebElement issueLink;

    @FindBy(linkText = "Issues")
    private WebElement newIssue;

    @FindBy(linkText = "Probe")
    private WebElement createdBug;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public IssuePage newIssue() {
        myPageLink.click();
        highSchoolLink.click();
        issueLink.click();
        return new IssuePage(driver);
    }

    public HomePage createdIssue() {
        newIssue.click();
        createdBug.click();
        return new HomePage(driver);
    }
}

