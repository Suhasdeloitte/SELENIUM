package Tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.Test;


import java.io.IOException;
import java.util.List;



public class Sample2Test {


    @Test
    public static void customer_login() throws InterruptedException, IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mvsuhas\\Downloads\\chromedriver.exe");
        WebDriver driver;
        driver = new ChromeDriver();
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");

        //WebElement e1 = driver.findElement(By.xpath("//*[@ng-click='home()']"));
        //e1.click();

        Thread.sleep(3000);
        WebElement e2 = driver.findElement(By.xpath("//*[@ng-click='customer()']"));
        e2.click();
        Thread.sleep(3000);
        Select se = new Select(driver.findElement(By.xpath("//*[@id='userSelect']")));
        List<WebElement> l = se.getOptions();
        int n = l.size() - 1;
        se.selectByIndex(n);
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/form/button")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@ng-click='deposit()']")).click();
        Thread.sleep(2000);
        WebElement e3 = driver.findElement(By.xpath("//*[@ng-model='amount']"));

        e3.sendKeys("2000");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();
        Thread.sleep(3000);

        //withdraw
        driver.findElement(By.xpath("//button[@ng-click='withdrawl()']")).click(); //click on withdraw
        Thread.sleep(2000);
        WebElement e31 = driver.findElement(By.xpath("//*[@ng-model='amount']")); //click amount
        e31.sendKeys("1000");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();

        //withdrawAgain
        driver.findElement(By.xpath("//button[@ng-click='withdrawl()']")).click();
        Thread.sleep(2000);
        WebElement e32 = driver.findElement(By.xpath("//*[@ng-model='amount']"));
        e32.sendKeys("2000");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();

    }


    }



