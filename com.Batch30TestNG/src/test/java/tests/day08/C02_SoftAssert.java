package tests.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class C02_SoftAssert {
    /*
    amazon sayfasina git
    url amazon icerdigini test edin.
    title'in amazon icerdigini test edin.
    java kelimesini aratin ve listedeki ik urunun java kelimesi icerdigini test edin.
     */
    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    @Test
    public void test01(){
        SoftAssert softAssert = new SoftAssert();
        driver.get("https://www.amazon.com/");
        softAssert.assertTrue(driver.getCurrentUrl().contains("amazon"),"URL \"amazon\" icermiyor");
        softAssert.assertTrue(driver.getTitle().contains("amazon"),"Title \"amazon\" icermiyor");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java"+ Keys.ENTER);
        WebElement firstProduct = driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]"));
        softAssert.assertTrue(firstProduct.getText().contains("java"),"Ilk urun \"java\" kelimesini icermiyor");
        softAssert.assertAll("Test Tamamlandi");

    }


    @AfterClass
    public void tearDown(){
        driver.close();
    }
}
