package tests.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class C01_HardAssertion {
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
        driver.get("https://www.amazon.com/");
        Assert.assertTrue(driver.getCurrentUrl().contains("amazon"),"amazon icermiyor");
        Assert.assertTrue(driver.getTitle().contains("Amazon"),"Amazon icermiyor");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java"+ Keys.ENTER);
        WebElement firstProduct = driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]"));
        Assert.assertTrue(firstProduct.getText().contains("Java"));


    }
    @AfterClass
    public void tearDown(){
        driver.close();
    }
}
