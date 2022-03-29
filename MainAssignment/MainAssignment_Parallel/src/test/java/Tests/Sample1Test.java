package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

public class Sample1Test extends SampleTest {
    private static Logger log = Logger.getLogger("Sample1Test");

    @Test
    public static void bm_login() throws InterruptedException, IOException {
        Thread.sleep(3000);
        WebElement e1 = SampleTest.driver.findElement(By.xpath("//*[@ng-click='manager()']"));
        e1.click();
        log.warning("Bank manager Login is Successful");
        log.info("Bank Manager Login");
        System.out.println("Logged in to Bank Manager Login");
        Thread.sleep(3000);
        WebElement e2 = SampleTest.driver.findElement(By.xpath("//*[@ng-class='btnClass1']"));
        e2.click();
        log.info("Add customer method");
        Thread.sleep(3000);

        SampleTest.driver.findElement(By.xpath("//*[@placeholder='First Name']")).sendKeys("Suhas");
        SampleTest.driver.findElement(By.xpath("//*[@placeholder='Last Name']")).sendKeys("MV");
        SampleTest.driver.findElement(By.xpath("//*[@placeholder='Post Code']")).sendKeys("560032");
        Thread.sleep(2000);
        SampleTest.driver.findElement(By.xpath("//*[@type='submit']")).click();
        driver.switchTo().alert().accept();
        SampleTest.driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/button[2]")).click();
        }

        //Open Account
        @Test
        public void openAccount() throws InterruptedException {
        SampleTest.driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/button[2]")).click();
        Thread.sleep(2000);
        Select se = new Select(driver.findElement(By.xpath("//*[@id=\"userSelect\"]")));
        List<WebElement> l = se.getOptions();
        se.selectByIndex(l.size() - 1);
        Thread.sleep(2000);
        Select sel = new Select(driver.findElement(By.xpath("//*[@id=\"currency\"]")));
        List<WebElement> l1 = sel.getOptions();
        sel.selectByIndex(3);
        Thread.sleep(2000);
        SampleTest.driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/button")).click();
        Thread.sleep(4000);
        driver.switchTo().alert().accept();
    }
}
