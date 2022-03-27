package miniassignment3;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scenario3 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mvsuhas\\Downloads\\chromedriver.exe");

        //Creating the driver
        WebDriver driver = new ChromeDriver();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("https://the-internet.herokuapp.com/");
        Thread.sleep(2000);
        WebElement link = driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[29]/a"));
        js.executeScript("arguments[0].click();",link );
        Thread.sleep(2000);
        WebElement button = driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button"));
        js.executeScript("arguments[0].click();",button );
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        driver.switchTo().alert().sendKeys("Test");
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
        driver.quit();
    }


}
