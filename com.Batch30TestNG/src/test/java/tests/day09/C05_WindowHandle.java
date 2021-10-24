package tests.day09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class C05_WindowHandle extends TestBase {
@Test
    public void test01(){
    //    ● Tests package’inda yeni bir class olusturun: D13_WindowHandle2
//    ● https://the-internet.herokuapp.com/windows adresine gidin.
    driver.get("https://the-internet.herokuapp.com/windows");
//    ● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
    WebElement text01 = driver.findElement(By.tagName("h3"));
    SoftAssert softAssert = new SoftAssert();
    softAssert.assertEquals(text01.getText(),"Opening a new window","baslik uyusmuyor");
//    ● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
    softAssert.assertEquals(driver.getTitle(),"The Internet","Title uyusmuyor");
//    ● Click Here butonuna basın.
    driver.findElement(By.linkText("Click Here")).click();
//    ● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
    driver.switchTo().window("");
    softAssert.assertEquals(driver.getTitle(),"New Window","yeni penceredeki title uyusmuyor");
//    ● Sayfadaki textin “New Window” olduğunu doğrulayın.
    WebElement newText = driver.findElement(By.tagName("h3"));
    softAssert.assertEquals(newText,"New Window","Yeni penceredeki text uyusmuyor");
//    ● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu
//        doğrulayın.
    softAssert.assertAll();
}

}
