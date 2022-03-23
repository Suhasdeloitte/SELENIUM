import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumTest {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mvsuhas\\Downloads\\chromedriver.exe");

        WebDriver driver;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("Headless");
        driver = new ChromeDriver(options);
        launchingUrl(driver);
    }
    public static void launchingUrl(WebDriver driver) throws InterruptedException {
        driver.get("https://www.google.com");
        driver.manage().window().maximize();

        Thread.sleep(3000);

        driver.navigate().to("https://phptravels.com/demo");
        String Actual = driver.getTitle();
        String Expected = "Demo Script Test drive - PHPTRAVELS";
        if(Actual.equals(Expected))
        {
            System.out.println("PASS");
        }
        else
        {
            System.out.println("FAIL");
        }

        Thread.sleep(3000);

        driver.navigate().to("https://phptravels.org/login");
        String Act = driver.getTitle();
        String Exp = "Login";
        if(Act.equals(Exp))
        {
            System.out.println("PASS");
        }
        else
        {
            System.out.println("FAIL");
        }
        Thread.sleep(3000);
        driver.navigate().back();
        String Act1 = driver.getTitle();
        String Exp1 = "Demo Script Test drive - PHPTRAVELS";
        if(Act1.equals(Exp1))
        {
            System.out.println("https://phptravels.com/demo");
        }
        else
        {
            System.out.println("FAIL");
        }

        Thread.sleep(3000);

        driver.findElement(By.linkText("Pricing")).click();
        System.out.println("PASS");

        Thread.sleep(3000);

        driver.navigate().back();
        System.out.println("PASS");

        Thread.sleep(3000);

        driver.navigate().refresh();
        System.out.println("PASS");

        Thread.sleep(3000);

        driver.close();

    }

}


