package dd;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;


public class Tests {
    
	static WebDriver driver;

    // Set up ChromeDriver before each test method
    @BeforeMethod
    public void setUp() {
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\hi\\Downloads\\chromedriver-win32\\chromedriver.exe");

        // Initialize the WebDriver instance
        driver = new ChromeDriver();
        driver.get("https://practice.automationtesting.in/");
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(org.openqa.selenium.PageLoadStrategy.NORMAL);
    }

    // Launch Website Test
    @Test(enabled=false)
    public void serachBarFunctionality() throws InterruptedException {
        
        Thread.sleep(3000);
    
    	 WebElement searchBar = driver.findElement(By.cssSelector("input#s:nth-of-type(1)"));
    	 Thread.sleep(3000);
		    searchBar.sendKeys("Test cases");
		    Thread.sleep(1000);
		    searchBar.submit();
    }
    
    @Test(enabled=false)
    public void sliderCount() {
    
    	
         List<WebElement> sliders = driver.findElements(By.cssSelector(".n2-ss-slide"));
    	 
         Assert.assertEquals(sliders.size(), 3);
    	
    	 for(WebElement i : sliders) {
    		 
    		 System.out.println(i.isDisplayed());
    	 }
    	
    }
    
    @Test
    public void HeaderMenu() throws InterruptedException {
    
    	
    	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    	    // Get the menu items
    	    List<WebElement> menuItems = driver.findElements(By.cssSelector("ul#main-nav a"));
    	    Assert.assertEquals(menuItems.size(), 6);

    	    for(WebElement j : menuItems) {
    	        // Refetch the menu items after each navigation
    	        menuItems = driver.findElements(By.cssSelector("ul#main-nav a"));
    	        wait.until(ExpectedConditions.visibilityOf(j));
    	        j.click();
    	        driver.navigate().back();
    	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul#main-nav a")));
    	    }
    	}

    @AfterMethod
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}

