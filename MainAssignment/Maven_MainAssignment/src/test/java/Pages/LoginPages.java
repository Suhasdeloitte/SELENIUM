package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class LoginPages {

    public static WebDriver driver;

    @BeforeTest
    public static WebDriver initial_set()  {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mvsuhas\\Downloads\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        driver.manage().window().maximize();
        return driver;
    }



    @AfterTest
    public void CloseBrowser()
    {

        driver.quit();
    }
}
