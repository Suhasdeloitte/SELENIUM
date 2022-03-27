package miniassignment3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.By.linkText;

    public class Scenario1 {
        public static void main(String[] args) throws InterruptedException {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\mvsuhas\\Downloads\\chromedriver.exe");

            //Creating the driver
            WebDriver driver = new ChromeDriver();
            Scenario1exe(driver);
        }

        public static void Scenario1exe(WebDriver driver) throws InterruptedException {
            driver.get("https://www.google.com");
            driver.manage().window().maximize();
            Thread.sleep(2000);
            driver.navigate().to("https://the-internet.herokuapp.com/");
            driver.findElement(linkText("Frames")).click();
            driver.findElement(linkText("Nested Frames")).click();
            driver.switchTo().frame("frame-top");
            driver.switchTo().frame("frame-left");
            String title = driver.findElement(By.xpath("/html/body")).getText();
            System.out.println(title);
        }

    }


