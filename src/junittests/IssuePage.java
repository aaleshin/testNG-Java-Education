package junittests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class IssuePage {

	@FindBy(id="issue_tracker_id")
	private WebElement issueType;
	
	@FindBy(id="issue_subject")
	private WebElement issueTitle;
	
	@FindBy(id="issue_description")
	private WebElement issueDescription;
	
	@FindBy(name="commit")
	private WebElement createBug;
	
	@FindBy(linkText="More")
	private WebElement inspectBug;
	
	@FindBy(id="issue_priority_id")
	private WebElement changeBugType;
	
	@FindBy(id="issue_description")
	private WebElement changeDescription;
	
	@FindBy(css="#issue-form > input[name=\"commit\"]")
	private WebElement commit;
	
	public void createIssue(String type, String title, String description) {
		new Select(issueType).selectByVisibleText(type);
		issueTitle.clear();
		issueTitle.sendKeys(title);
		issueDescription.clear();
		issueDescription.sendKeys(description);
		createBug.click();
	}
	
	public void changeIssue(String bugType, String bugdescription){
	inspectBug.click();
	new Select(changeBugType).selectByVisibleText(bugType);
	changeDescription.clear();
	changeDescription.sendKeys(bugdescription);
	commit.click();
	}
}
