package miniassignment3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scenario2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mvsuhas\\Downloads\\chromedriver.exe");

        //Creating the driver
        WebDriver driver = new ChromeDriver();
        Scenario2exe(driver);
    }
    public static void Scenario2exe(WebDriver driver) throws InterruptedException
    {
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.navigate().to("https://jqueryui.com/droppable/");
        Thread.sleep(2000);
        Actions act = new Actions(driver);
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
        WebElement source = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement destination = driver.findElement(By.xpath("//div[@id='droppable']"));
        act.dragAndDrop(source,destination).build().perform();
        Thread.sleep(2000);
        driver.switchTo().defaultContent();
        driver.close();
        System.out.println("Successfully Done");
    }
}

