package tests.day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class C01_Priority {
    // 3 test methodu olusturualim
    //  1. amazon ana sayfasina
    //  2. techproeducation ana sayfaya
    //  3. facebook ana sayfa gitsin
    // ve sayfa titlerini yazdirsin.
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    @Test (priority = 2)
    public void amazonTest01(){
        driver.get("https://www.amazon.com/");
        System.out.println(driver.getTitle());
    }
    @Test (priority = 3)
    public void techproeducationTest01(){
        driver.get("https://www.techproeducation.com/");
        System.out.println(driver.getTitle());
    }
    @Test (priority = 1)
    public void facebookTest01(){
        driver.get("https://www.facebook.com/");
        System.out.println(driver.getTitle());
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
