package base;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class BasePage {

    public static Faker faker = new Faker();
    public static WebDriverWait wait;
    private static WebDriver driver;

    protected static final String URL = "https://parabank.parasoft.com/parabank/index.htm";
    public BasePage(){
        if (driver == null){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        if (wait == null){
            wait = new WebDriverWait(BasePage.getDriver(), Duration.ofMillis(800));
        }
    }
    public void openApp(){
        driver.get(URL);
    }
    public static WebDriver getDriver() {
        return driver;
    }
    public WebElement getWebElement(By locator){
        WebElement element = null;
        try {
            element = driver.findElement(locator);
        }catch (RuntimeException exception){
            System.out.println("There is not such element: "+ locator);
            System.out.println("Exception manager " + exception);
        }
        return element;
    }
}
