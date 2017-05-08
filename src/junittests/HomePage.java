package junittests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	@FindBy(linkText="High School: Test Automation")
	private WebElement highSchoolLink;
	
	@FindBy(linkText="New issue")
	private WebElement issueLink;
	
	@FindBy(linkText="Issues")
	private WebElement newIssue;
	
	@FindBy(linkText="probe")
	private WebElement createdBug;
	
	public void newIssue() {
		highSchoolLink.click();
		issueLink.click();
	}
	
	public void createdIssue(){
		newIssue.click();
		createdBug.click();
	}
}
	
