package tests;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.LoginPage;


import static java.lang.Thread.sleep;

public class LoginTest {
    LoginPage login;
    WebDriver driver;
    String url = "https://www.saucedemo.com/";

    @BeforeSuite
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mvsuhas\\Downloads\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
    }

    @Test(priority = 1)
    public void validateLogin() throws InterruptedException {
        login = new LoginPage(this.driver);
        login.enterUsername();
        login.enterPassword();
        login.clickLogin();
        sleep(3000);
    }
}










