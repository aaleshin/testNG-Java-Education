package webdrivertests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

	public class UpdateBugGoogle  {
	    public static void main(String[] args) {
	    	
	    	System.setProperty("webdriver.chrome.driver", "D:\\downloads\\avtotests\\chromedriver.exe");
	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();

	        driver.get("http://redmine-train.dev.thumbtack.net:3000/");
	  
	        driver.findElement(By.className("login")).click();
	        driver.findElement(By.id("username")).sendKeys("aleshin");
	        driver.findElement(By.id("password")).sendKeys("547348");
	        driver.findElement(By.name("login")).click();
	        driver.findElement(By.linkText("High School: Test Automation")).click();
	        driver.findElement(By.className("new-issue")).click();
	        new Select(driver.findElement(By.id("issue_tracker_id"))).selectByVisibleText("Bug");
	        driver.findElement(By.id("issue_subject")).sendKeys("Test bug");
	        driver.findElement(By.name("commit")).click();
	        WebElement dynamicElement = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Update")));
	        driver.findElement(By.linkText("Update")).click();
	        new Select(driver.findElement(By.id("issue_priority_id"))).selectByVisibleText("Low");
	        driver.findElement(By.xpath(".//*[@id='issue-form']/input[2]")).click();
	  
	        
        driver.quit();
    }
}
