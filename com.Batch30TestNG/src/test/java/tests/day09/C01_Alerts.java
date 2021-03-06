package tests.day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class C01_Alerts {
    /*
    ● Bir class olusturun: D12_Alerts
    ● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    ● Bir metod olusturun: acceptAlert
        ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
            “You successfully clicked an alert” oldugunu test edin.
    ● Bir metod olusturun: dismissAlert
        ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
            “successfuly” icermedigini test edin.
    ● Bir metod olusturun: sendKeysAlert
        ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
            tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
     */
    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }
    @Test
    public void acceptAlert(){
//○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
//            “You successfully clicked an alert” oldugunu test edin.
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        driver.switchTo().alert().accept();
        Assert.assertTrue(driver.findElement(By.id("result")).getText().equals("You successfully clicked an alert"),"Sonuc yazidi expected ile uyusmuyor");
    }
    @Test
    public void dismissAlert(){
//○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
//            “successfuly” icermedigini test edin.
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        driver.switchTo().alert().dismiss();
        Assert.assertFalse(driver.findElement(By.id("result")).getText().contains("successfuly"),"result \"successfuly\" mesajini iceriyor");
    }
    @Test
    public void sendKeysAlert(){
//○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
//            tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        driver.switchTo().alert().sendKeys("cagatay");
        driver.switchTo().alert().accept();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.findElement(By.id("result")).getText(),"cagatay","sonuc yazisi adi icermiyor");
        softAssert.assertAll();
    }
    @AfterClass
    public void tearDown(){
        driver.close();
    }
}
