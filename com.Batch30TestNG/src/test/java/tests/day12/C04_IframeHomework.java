package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Set;

public class C04_IframeHomework extends TestBase {
    /*
    “http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
“Our Products” butonuna basin
“Cameras product”i tiklayin
Popup mesajini yazdirin
“close” butonuna basin
"WebdriverUniversity.com (IFrame)" linkini tiklayin
"http://webdriveruniversity.com/index.html" adresine gittigini test edin
     */
    @Test
    public void iframTest(){
        driver.get("http://webdriveruniversity.com/IFrame/index.html");
        driver.switchTo().frame(0);
        driver.findElement(By.linkText("Our Products")).click();
        driver.findElement(By.id("camera-img")).click();
        driver.findElement(By.xpath("//*[text()='Close']")).click();
        String page01Handle = driver.getWindowHandle();
        driver.switchTo().parentFrame();
        driver.findElement(By.linkText("WebdriverUniversity.com (IFrame)")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"http://webdriveruniversity.com/index.html","istenilen adrese gitmedi");
    }
}
