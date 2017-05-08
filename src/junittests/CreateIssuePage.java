package junittests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateIssuePage {
	
	@FindBy(linkText="Update") 
	private WebElement updateIssue;

	public void inspectIssue(){
		updateIssue.click();
	
	}
}
