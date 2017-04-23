package webdrivertests;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.support.ui.ExpectedCondition;
	import org.openqa.selenium.support.ui.WebDriverWait;

	public class Selenium2Example  {
	    public static void main(String[] args) {
	    	System.setProperty("webdriver.chrome.driver", "D:\\downloads\\avtotests\\chromedriver.exe");
	        WebDriver driver = new ChromeDriver();

//	    	System.setProperty("webdriver.gecko.driver", "D:\\downloads\\avtotests\\geckodriver.exe");
//	    	WebDriver driver = new FirefoxDriver();     
	        
	        driver.get("http://www.google.com");
	        WebElement element = driver.findElement(By.name("q"));
	        
	        element.sendKeys("Cheese!");
	        element.submit();
	        
	        System.out.println("Page title is: " + driver.getTitle());
	        
	        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
	            public Boolean apply(WebDriver d) {
	                return d.getTitle().toLowerCase().startsWith("cheese!");
	            }
	        });
	        
	        System.out.println("Page title is: " + driver.getTitle());
	        driver.quit();
	    }

}
