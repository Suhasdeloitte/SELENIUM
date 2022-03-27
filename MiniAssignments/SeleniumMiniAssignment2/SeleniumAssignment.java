import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.sleep;

public class SeleniumAssignment {
        public static void main(String[] args) throws InterruptedException {
                System.setProperty("webdriver.chrome.driver","C:\\Users\\mvsuhas\\Downloads\\chromedriver.exe");
                WebDriver driver=new ChromeDriver();

                launchUrl(driver);



        }

        private static void launchUrl(WebDriver driver) throws InterruptedException {
                driver.get("https://www.google.com");
                driver.manage().window().maximize();
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

                String Act2 = driver.getTitle();
                String Exp2 = "Demo Script Test drive - PHPTRAVELS";
                if(Act2.equals(Exp2))
                {
                        System.out.println("https://phptravels.com/demo");
                }
                else
                {
                        System.out.println("FAIL");
                }
                Thread.sleep(3000);

                driver.findElement(By.linkText("Pricing")).click();

                Thread.sleep(3000);

                driver.navigate().back();

                driver.navigate().refresh();

                Thread.sleep(3000);

                driver.close();



        }
}
