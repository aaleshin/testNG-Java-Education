package webdrivertests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UpdateBugFirefox {
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.gecko.driver", "D:\\downloads\\avtotests\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();

		driver.get("http://redmine-train.dev.thumbtack.net:3000/");

		driver.findElement(By.className("login")).click();
		WebElement dynamicElement = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
		driver.findElement(By.id("username")).sendKeys("aleshin");
		driver.findElement(By.id("password")).sendKeys("547348");
		driver.findElement(By.name("login")).click();
		WebElement dynamicElement1 = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.presenceOfElementLocated(By.linkText("High School: Test Automation")));
		driver.findElement(By.linkText("High School: Test Automation")).click();
		WebElement dynamicElement2 = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.presenceOfElementLocated(By.className("new-issue")));
		driver.findElement(By.className("new-issue")).click();
		WebElement dynamicElement3 = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.presenceOfElementLocated(By.id("issue_tracker_id")));
		new Select(driver.findElement(By.id("issue_tracker_id"))).selectByVisibleText("Bug");
		driver.findElement(By.id("issue_subject")).sendKeys("Test bug");
		driver.findElement(By.name("commit")).click();
		WebElement dynamicElement4 = (new WebDriverWait(driver, 30))
				.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Update")));
		driver.findElement(By.linkText("Update")).click();
		new Select(driver.findElement(By.id("issue_priority_id"))).selectByVisibleText("Low");
		driver.findElement(By.xpath(".//*[@id='issue-form']/input[2]")).click();

		driver.quit();
	}
}