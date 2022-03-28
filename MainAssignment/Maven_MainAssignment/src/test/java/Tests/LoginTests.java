package Tests;


import Pages.LoginPages;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

public class LoginTests extends LoginPages {
    private static Logger log = Logger.getLogger("LoginTests");

    @Test(priority = 1)
    public static void bm_login() throws InterruptedException {
        Thread.sleep(3000);
        WebElement e1 = LoginPages.driver.findElement(By.xpath("//*[@ng-click='manager()']"));
        e1.click();
        log.warning("Bank manager Login is Successful");
        log.info("Bank Manager Login");
        System.out.println("Logged in to Bank Manager Login");
        Thread.sleep(3000);
        WebElement e2 = LoginPages.driver.findElement(By.xpath("//*[@ng-class='btnClass1']"));
        e2.click();
        log.info("Add customer method");
        Thread.sleep(3000);
    }
    @Test(priority = 2)
    public static void add_customers() throws IOException, InterruptedException {
        String excelPath = "C:\\Users\\mvsuhas\\Maven_MainAssignment\\dataFiles\\InputDetails.xlsx";
        FileInputStream fis = new FileInputStream(excelPath);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0);
        XSSFRow row;
        XSSFCell cell;
        String FirstName = null;
        String LastName = null;
        int PostCode = 0;
        for (int i = 0; i <= sheet.getLastRowNum(); i++) {
            row = sheet.getRow(i);
            for (int j = 0; j < row.getLastCellNum(); j++) {
                cell = row.getCell(j);
                if (j == 0) {
                    FirstName = cell.getStringCellValue();
                }
                if (j == 1) {
                    LastName = cell.getStringCellValue();
                }
                if (j == 2) {
                    PostCode = (int) cell.getNumericCellValue();
                }
            }
            LoginTests.driver.findElement(By.xpath("//*[@placeholder='First Name']")).sendKeys(FirstName);
            LoginTests.driver.findElement(By.xpath("//*[@placeholder='Last Name']")).sendKeys(LastName);
            LoginTests.driver.findElement(By.xpath("//*[@placeholder='Post Code']")).sendKeys((Integer.toString(PostCode)));
            Thread.sleep(2000);
            LoginTests.driver.findElement(By.xpath("//*[@type='submit']")).click();
            Thread.sleep(2000);
            driver.switchTo().alert().accept();
            Thread.sleep(2000);
        }

    }
    @Test(priority = 3)
    public static void open_account() throws InterruptedException, IOException {
        LoginTests.driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/button[2]")).click();
        Thread.sleep(2000);
        Select se = new Select(driver.findElement(By.xpath("//*[@id=\"userSelect\"]")));
        List<WebElement> l = se.getOptions();
        se.selectByIndex(l.size() - 1);
        Thread.sleep(2000);
        Select sel = new Select(driver.findElement(By.xpath("//*[@id=\"currency\"]")));
        List<WebElement> l1 = sel.getOptions();
        sel.selectByIndex(3);
        Thread.sleep(2000);
        LoginTests.driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/button")).click();
        Thread.sleep(4000);
        driver.switchTo().alert().accept();

        Thread.sleep(2000);

    }

    @Test(priority = 4)
    public static void customer_login() throws InterruptedException, IOException {
        WebElement e1 = LoginPages.driver.findElement(By.xpath("//*[@ng-click='home()']"));
        e1.click();
        Thread.sleep(3000);
        WebElement e2 = LoginPages.driver.findElement(By.xpath("//*[@ng-click='customer()']"));
        e2.click();
        Thread.sleep(3000);
        Select se = new Select(driver.findElement(By.xpath("//*[@id='userSelect']")));
        List<WebElement> l = se.getOptions();
        int n = l.size() - 1;
        se.selectByIndex(n);
        Thread.sleep(3000);
        LoginPages LoginPage;
        LoginPages.driver.findElement(By.xpath("/html/body/div/div/div[2]/div/form/button")).click();
        Thread.sleep(3000);
        LoginPages.driver.findElement(By.xpath("//*[@ng-click='deposit()']")).click();
        Thread.sleep(2000);
        WebElement e3 = driver.findElement(By.xpath("//*[@ng-model='amount']"));
        String excelPath = "C:\\Users\\mvsuhas\\Maven_MainAssignment\\dataFiles\\DepositWithdraw.xlsx";
        FileInputStream fis = new FileInputStream(excelPath);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0);
        XSSFRow row;
        XSSFCell cell;
        int amount = 0;
        for (int i = 0; i <= sheet.getLastRowNum(); i++) {
            row = sheet.getRow(i);
            for (int j = 0; j < row.getLastCellNum(); j++) {
                cell = row.getCell(j);
                if (j == 0) {
                    amount = (int) cell.getNumericCellValue();
                }
            }
            e3.sendKeys(Integer.toString(amount));
            Thread.sleep(3000);
            driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();

            File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src,new File("C:\\Users\\mvsuhas\\Maven_MainAssignment\\deposit.png"));

            Thread.sleep(3000);
        }
    }

    @Test(priority = 5)
    public static void withdraw() throws InterruptedException, IOException {
        driver.findElement(By.xpath("//button[@ng-click='withdrawl()']")).click();
        Thread.sleep(2000);
        WebElement e3 = driver.findElement(By.xpath("//*[@ng-model='amount']"));
        String excelPath = "C:\\Users\\mvsuhas\\Maven_MainAssignment\\dataFiles\\DepositWithdraw.xlsx";
        FileInputStream fis = new FileInputStream(excelPath);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0);
        XSSFRow row ;
        XSSFCell cell;
        int amount = 0;
        for (int i = 0; i <= sheet.getLastRowNum(); i++) {
            row = sheet.getRow(i);
            for (int j = 1; j < row.getLastCellNum(); j++) {
                cell = row.getCell(j);
                if (j == 1) {
                    amount = (int) cell.getNumericCellValue();
                }
            }
        }

        e3.sendKeys(Integer.toString(amount));
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();

        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src,new File("C:\\Users\\mvsuhas\\Maven_MainAssignment\\withdraw.png"));
    }
    @Test(priority = 6)
    public static void withdrawError() throws InterruptedException, IOException {
        driver.findElement(By.xpath("//button[@ng-click='withdrawl()']")).click();
        Thread.sleep(2000);
        WebElement e3 = driver.findElement(By.xpath("//*[@ng-model='amount']"));
        String excelPath = "C:\\Users\\mvsuhas\\Maven_MainAssignment\\dataFiles\\DepositWithdraw.xlsx";
        FileInputStream fis = new FileInputStream(excelPath);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0);
        XSSFRow row ;
        XSSFCell cell;
        int amount = 0;
        for (int i = 0; i <= sheet.getLastRowNum(); i++) {
            row = sheet.getRow(i);
            for (int j = 2; j < row.getLastCellNum(); j++) {
                cell = row.getCell(j);
                if (j == 2) {
                    amount = (int) cell.getNumericCellValue();
                }
            }
        }

        e3.sendKeys(Integer.toString(amount));
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src,new File("C:\\Users\\mvsuhas\\Maven_MainAssignment\\withdrawerror.png"));
        Thread.sleep(3000);

    }

}
    

