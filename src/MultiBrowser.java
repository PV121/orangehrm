import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class MultiBrowser {
    static WebDriver driver;
    static String baseUrl = "https://opensource-demo.orangehrmlive.com/";
    static String browser= "edGe";

    public static void main(String[] args) {
        if (browser.equalsIgnoreCase("Chrome")){
            System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
            driver= new ChromeDriver();
        }else if (browser.equalsIgnoreCase("Edge")) {
            System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
            driver = new EdgeDriver();
        }else if (browser.equalsIgnoreCase("Firefox")) {
            System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        }else {
            System.out.println("Browser not found");
        }

        driver.get(baseUrl);
        //to maximize window
        driver.manage().window().maximize();
        //give implicit time
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // to get title of the page
        String title =driver.getTitle();
        System.out.println("Title: "+title);
        // to get current URL
        String currentUrl= driver.getCurrentUrl();
        System.out.println("Current URL: "+currentUrl);
        // to get page source
        String source= driver.getPageSource();
        System.out.println("Page source: "+source);

        // to find id element
        WebElement emailfield= driver.findElement(By.id("txtUsername"));
        //sending email to emai field element
        emailfield.sendKeys("pvaland@gmail.com");
        //to find name element
        WebElement passwordfield = driver.findElement(By.name("txtPassword"));
        //sending password to passwordfield element
        passwordfield.sendKeys("123456789");


        driver.close();

    }
}
