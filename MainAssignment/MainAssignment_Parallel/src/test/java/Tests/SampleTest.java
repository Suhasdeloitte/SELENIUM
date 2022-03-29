package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;

public class SampleTest {
    public static WebDriver driver;
    String url = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login";

    @BeforeSuite
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mvsuhas\\Downloads\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
    }
}

