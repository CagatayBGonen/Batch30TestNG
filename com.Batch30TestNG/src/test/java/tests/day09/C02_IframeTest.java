package tests.day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class C02_IframeTest {
    /*
    ● Bir class olusturun: D12_IframeTest
    ● https://the-internet.herokuapp.com/iframe adresine gidin.
    ● Bir metod olusturun: iframeTest
        ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda
            yazdirin.
        ○ Text Box’a “Merhaba Dunya!” yazin.
        ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
            dogrulayin ve konsolda yazdirin.
     */
    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/iframe");
    }
    @Test
    public void iframeTest(){
        WebElement titleText = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(titleText.isEnabled(),"titleText erisilebilir degi");
        System.out.println(titleText.getText());
        driver.switchTo().frame("mce_0_ifr");
        driver.findElement(By.xpath("//*[@id='tinymce']")).clear();
        driver.findElement(By.xpath("//*[@id='tinymce']")).sendKeys("Merhaba Dunya!");
        //driver.switchTo().parentFrame(); --> bir üstteki frame cikartir.
        driver.switchTo().defaultContent(); // --> en ustteki frame cikartir.
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(driver.findElement(By.linkText("Elemental Selenium")).isDisplayed());
        System.out.println(driver.findElement(By.linkText("Elemental Selenium")).getText());
        softAssert.assertAll();
    }
    @AfterClass
    public void tearDown(){

        driver.close();
    }
}
