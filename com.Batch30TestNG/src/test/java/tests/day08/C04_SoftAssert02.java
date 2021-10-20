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

public class C04_SoftAssert02 {
    /*
    - "https://www.hepsiburada.com/" adresine git
    - baslik "Türkiye'nin En Buyuk Alisveris Sitesi" icerdigini verify
    - search box "araba"
    - sonuc sayisini print
    - sonuc yazisi "araba" icermek (verify)
    - sonuc yazisinin "oto" icermemek (verify)
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
        driver.get("https://www.hepsiburada.com/");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(driver.getTitle().contains("Türkiye'nin En Buyuk Alisveris Sitesi"),"baslik \"Türkiye'nin En Buyuk Alisveris Sitesi\" icermiyor");
        driver.findElement(By.xpath("//input[@class='desktopOldAutosuggestTheme-input']")).sendKeys("araba"+ Keys.ENTER);
        WebElement resultText = driver.findElement(By.xpath("//div[@class='category-suggestion-title']"));
        System.out.println(resultText.getText());
        softAssert.assertTrue(resultText.getText().contains("araba"),"Sonuc yazisi \"araba\" icermiyor");
        softAssert.assertFalse(resultText.getText().contains("oto"),"Sonuc yazisi \"oto\" iceriyor");

        softAssert.assertAll();
    }
    @AfterClass
    public void tearDown(){
        driver.close();
    }
}
