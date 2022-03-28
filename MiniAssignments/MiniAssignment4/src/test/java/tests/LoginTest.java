package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.Thread.sleep;

public class LoginTest {
        LoginPage login;
        WebDriver driver;
        String url="https://www.saucedemo.com/";

        @BeforeSuite
        public void setup(){
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\mvsuhas\\Downloads\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(url);
        }

        @Test(priority = 1)
        public void validateLogin() throws InterruptedException {
            login=new LoginPage(this.driver);
            login.enterUsername();
            login.enterPassword();
            login.clickLogin();
            sleep(3000);
        }

        @Test(priority = 2)
        public void HighToLow() throws InterruptedException {
            List<WebElement> beforeFilterPrice = driver.findElements(By.className("inventory_item_price"));
            List<Double> beforeFilterPriceList = new ArrayList();
            for (WebElement p : beforeFilterPrice) {
                beforeFilterPriceList.add(Double.valueOf(p.getText().replace("$", "")));
            }
            Select dropdown = new Select(driver.findElement(By.className("product_sort_container")));
            dropdown.selectByVisibleText("Price (high to low)");
            List<WebElement> afterFilterPrice = driver.findElements(By.className("inventory_item_price"));
            List<Double>afterFilterPriceList = new ArrayList<>();
            for(WebElement p: afterFilterPrice){
                beforeFilterPriceList.add(Double.valueOf(p.getText().replace("$","")));
            }

            Collections.sort(beforeFilterPriceList);
            Collections.reverse(beforeFilterPriceList);
            sleep(3000);
        }

        @Test(priority = 3)
        public void testAddToCart() throws InterruptedException {
            String price = driver.findElement(By.className("inventory_item_price")).getText();
            int limit = 100;
            price = price.replace("$","");
            Double priceValue = Double.parseDouble(price.substring(0,price.indexOf(".")));
            System.out.println("PriceValue : "+priceValue);
            if( limit > priceValue) {
                driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
                sleep(3000);
            }
            else {
                driver.quit();
            }

        }
        @Test(priority = 4)
        public void removeProducts() throws InterruptedException {
            List<WebElement> removeProductBtnList = driver.findElements(By.id("remove-sauce-labs-fleece-jacket"));
            for (WebElement removeProductBtn : removeProductBtnList ) {
            //driver.findElement(By.id("remove-sauce-labs-backpack")).click();
                removeProductBtn.click();
                sleep(3000);//you can also use this line instead of the above,
            //but it will probably return a StaleElementReferenceException after the first click.
            }
            driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
            sleep(3000);
            driver.findElement(By.id("shopping_cart_container")).click();
            sleep(3000);
            driver.findElement(By.id("continue-shopping")).click();
            sleep(3000);
        }
        @Test(priority = 5)
        public void LowToHigh() throws InterruptedException {
            List<WebElement> beforeFilterPrice = driver.findElements(By.className("inventory_item_price"));
            List<Double>beforeFilterPriceList = new ArrayList();
            for(WebElement p: beforeFilterPrice){
                beforeFilterPriceList.add(Double.valueOf(p.getText().replace("$","")));
            }

            Select dropdown = new Select(driver.findElement(By.className("product_sort_container")));
            dropdown.selectByVisibleText("Price (low to high)");
            List<WebElement> afterFilterPrice = driver.findElements(By.className("inventory_item_price"));
            List<Double>afterFilterPriceList = new ArrayList<>();
            for(WebElement p: afterFilterPrice){
                afterFilterPriceList.add(Double.valueOf(p.getText().replace("$","")));
            }
            Collections.sort(beforeFilterPriceList);
            Assert.assertEquals(beforeFilterPriceList,afterFilterPriceList);

            sleep(3000);


            }
            @Test(priority = 6)
            public void testAddToCartAgain() throws InterruptedException {
                String price = driver.findElement(By.className("inventory_item_price")).getText();
                int limit = 100;
                price = price.replace("$","");
                double priceValue = Double.parseDouble(price.substring(0,price.indexOf(".")));
                System.out.println("PriceValue : "+priceValue);
                if( limit > priceValue) {
                    driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
                    sleep(3000);
                }
                else {
                    driver.quit();
                }
                driver.findElement(By.id("shopping_cart_container")).click();
                sleep(3000);

            }

            @Test(priority = 7)
            public void checkout() throws InterruptedException {
                driver.findElement(By.id("checkout")).click();
                sleep(3000);

            }

            @Test(priority = 8)
                public void enterCredentials() throws InterruptedException {
                    login=new LoginPage(this.driver);
                    login.enterFirstName();
                    login.enterLastName();
                    login.enterPinCode();
                    sleep(3000);
                    driver.findElement(By.xpath("//*[@id=\'continue\']")).click();
                    sleep(3000);
                    driver.findElement(By.xpath("//*[@id='finish']")).click();
                }

                @AfterSuite
                public void backToHome(){
                    driver.findElement(By.xpath("//*[@id=\'back-to-products\']")).click();
                }
            }












