import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Chrome {

    public static void main(String[] args) {
        String baseUrl= "https://opensource-demo.orangehrmlive.com/";
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get(baseUrl);

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        String title = driver.getTitle();
        System.out.println("Titlte : "+title);

        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL: "+currentUrl);

        String source = driver.getPageSource();
        System.out.println("Page source: "+source);

        WebElement emailfield = driver.findElement(By.id("txtUsername"));
        emailfield.sendKeys("pvaland@gmail.com");

        WebElement passwordfield = driver.findElement(By.name("txtPassword"));
        passwordfield.sendKeys("123456789");

        driver.close();
    }
}
