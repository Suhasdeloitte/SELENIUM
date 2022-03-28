package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import pages.LoginPage;
import static java.lang.Thread.sleep;
public class HightoLow {
    WebDriver driver;
    LoginPage login;
    @Test
    void filteringHightoLow() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mvsuhas\\Downloads\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        login = new LoginPage(this.driver);
        login.enterUsername();
        login.enterPassword();
        sleep(2000);
        login.clickLogin();
        sleep(2000);
        //Filtering High to Low
        List<WebElement> beforeFilterPrice = driver.findElements(By.className("inventory_item_price"));
        List<Double> beforeFilterPriceList = new ArrayList();
        for (WebElement p : beforeFilterPrice) {
            beforeFilterPriceList.add(Double.valueOf(p.getText().replace("$", "")));
        }
        Select dropdown = new Select(driver.findElement(By.className("product_sort_container")));
        dropdown.selectByVisibleText("Price (high to low)");
        List<WebElement> afterFilterPrice = driver.findElements(By.className("inventory_item_price"));
        List<Double> afterFilterPriceList = new ArrayList<>();
        for (WebElement p : afterFilterPrice) {
            beforeFilterPriceList.add(Double.valueOf(p.getText().replace("$", "")));
        }

        Collections.sort(beforeFilterPriceList);
        Collections.reverse(beforeFilterPriceList);
        sleep(2000);

        //adding
        String price = driver.findElement(By.className("inventory_item_price")).getText();
        int limit = 100;
        price = price.replace("$", "");
        Double priceValue = Double.parseDouble(price.substring(0, price.indexOf(".")));
        System.out.println("PriceValue : " + priceValue);
        if (limit > priceValue) {
            driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
        } else {
            driver.quit();
        }

        sleep(2000);

        //removing
        List<WebElement> removeProductBtnList = driver.findElements(By.id("remove-sauce-labs-fleece-jacket"));
        for (WebElement removeProductBtn : removeProductBtnList) {
            removeProductBtn.click();

        }
        sleep(2000);

        driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
        sleep(2000);

        driver.findElement(By.id("shopping_cart_container")).click();
        sleep(2000);

        driver.findElement(By.id("continue-shopping")).click();
        sleep(2000);

        //filtering low to high

        List<WebElement> bfp = driver.findElements(By.className("inventory_item_price"));
        List<Double> bfpl = new ArrayList();
        for (WebElement p : bfp) {
            bfpl.add(Double.valueOf(p.getText().replace("$", "")));
        }

        Select dd = new Select(driver.findElement(By.className("product_sort_container")));
        dd.selectByVisibleText("Price (low to high)");
        List<WebElement> afp = driver.findElements(By.className("inventory_item_price"));
        List<Double> afpl = new ArrayList<>();
        for (WebElement p : afp) {
            afpl.add(Double.valueOf(p.getText().replace("$", "")));
        }
        Collections.sort(bfpl);
        Assert.assertEquals(bfpl, afpl);

        sleep(2000);

        //adding least priced item
        price = driver.findElement(By.className("inventory_item_price")).getText();
        limit = 100;
        price = price.replace("$", "");
        priceValue = Double.parseDouble(price.substring(0, price.indexOf(".")));
        System.out.println("PriceValue : " + priceValue);
        if (limit > priceValue) {
            driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
        } else {
            driver.quit();
        }
        driver.findElement(By.id("shopping_cart_container")).click();
        sleep(2000);

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0,400)");

        //checking out
        sleep(2000);
        driver.findElement(By.id("checkout")).click();
        jse.executeScript("scroll(0,0)");
        sleep(2000);
        login = new LoginPage(this.driver);

        login.enterFirstName();
        sleep(2000);

        login.enterLastName();
        sleep(2000);

        login.enterPinCode();
        sleep(2000);


        jse.executeScript("scroll(0,150)");

        sleep(2000);

        driver.findElement(By.xpath("//*[@id=\'continue\']")).click();

        //jse.executeScript("scroll(0,-600)");

        sleep(2000);

        jse.executeScript("scroll(0,600)");

        sleep(2000);

        driver.findElement(By.xpath("//*[@id='finish']")).click();

        jse.executeScript("scroll(0,130)");

    }


}





