package miniassignment3;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

    public class Scenario4 {


        public static void main(String[] args) throws InterruptedException {
            System.setProperty("webdriver.chrome.driver","C:\\Users\\mvsuhas\\Downloads\\chromedriver.exe");
            WebDriver driver=new ChromeDriver();
            driver.manage().window().maximize();
            launchUrl(driver);
        }

        private static void launchUrl(WebDriver driver) throws InterruptedException {
            driver.get("https://www.goibibo.com/");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@class='sc-gsNilK dImRia'][text()='Round-trip']")).click();
            Thread.sleep(2000);
            WebElement from=driver.findElement(By.xpath("//*[@class='sc-iJKOTD iipKRx fswWidgetPlaceholder'][text()='Enter city or airport']"));
            from.click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[2]/div/div[1]/div[1]/div/div[2]/div/input")).sendKeys("New York");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id='autoSuggest-list']/li[1]/div")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Seattle");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id='autoSuggest-list']/li[1]/div")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[2]/div/div[1]/div[3]/div[2]/div[2]/div/div/div[1]/span[2]")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[2]/div/div[1]/div[3]/div[2]/div[2]/div/div/div[1]/span[2]")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[2]/div/div[1]/div[3]/div[2]/div[2]/div/div/div[2]/div[2]/div[3]/div[4]/div[6]")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[2]/div/div[1]/div[3]/div[2]/div[2]/div/div/div[1]/span[2]")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[2]/div/div[1]/div[3]/div[2]/div[2]/div/div/div[2]/div[2]/div[3]/div[2]/div[6]")).click();
            Thread.sleep(2000);
            JavascriptExecutor js=(JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,200)");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[2]/div/div[1]/div[3]/div[2]/div[3]/span[2]")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[2]/div/div[1]/div[5]/div[2]/div[3]/a[2]")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[2]/div/div[3]/span")).click();
            Thread.sleep(2000);
            js.executeScript("window.scrollBy(0,250)");


            Thread.sleep(2000);File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);try {FileUtils.copyFile(src, new File("src/Screenshot.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id='root']/div[2]/div/div[2]/div/div[2]/div/div[2]/div[2]/div[2]/div/button")).click();Thread.sleep(3000);js.executeScript("window.scrollBy(0,10000)");
        }
        public static void Scenario4exe(WebDriver driver) throws InterruptedException {
            driver.get("https://www.google.com");
            driver.manage().window().maximize();Thread.sleep(2000);
            driver.navigate().to("https://www.goibibo.com/");Thread.sleep(2000);JavascriptExecutor js = (JavascriptExecutor) driver;js.executeScript("document.getElement(By.xpath('//*[@id=\"root\"]/div/div[2]/div[2]/div/div[1]/div[1]/div/div/p)).value='New York'");
        }
    }



