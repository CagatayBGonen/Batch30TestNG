package tests.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import java.util.Set;

public class C01_WindowHandle extends TestBase {
    @Test
    public void test01() {
        //    ● Tests package’inda yeni bir class olusturun: D13_WindowHandle2
//    ● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
//    ● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement text01 = driver.findElement(By.tagName("h3"));
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(text01.getText(), "Opening a new window", "baslik uyusmuyor");
//    ● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        softAssert.assertEquals(driver.getTitle(), "The Internet", "Title uyusmuyor");
        System.out.println("ilk sayfanin handle degeri : "+driver.getWindowHandle());
        //  1- window handle ederken ilk adim bir sayfa acik iken o sayfanin handle degerini alip bir stringe atamak.
        String mainPageHandle = driver.getWindowHandle();
//    ● Click Here butonuna basın.
        //bu satirda 2. window acildi.
        driver.findElement(By.linkText("Click Here")).click();
        //  2- iki sayfa acildiginda, her iki sayfanin handle degerlerini koymak icin bir set olusturup
        //        getWindowhandles methodu ile bu degerleri elde etmek
        Set<String> allWindowhandles = driver.getWindowHandles();
        System.out.println("tum handle'lar : "+allWindowhandles);
        //  3- set icerisinde birinci sayfanin handle degerini esit olmayan handle degerini bulup
        //         bir String degiskenine atamak.
        String secondPagehandle = " ";
        for(String each : allWindowhandles){
            if(!each.equals(mainPageHandle)){
                secondPagehandle = each;
            }
        }
        // bu satira geldigimizde elimizde ikinci sayafanin handle degeri var.
//    ● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        driver.switchTo().window(secondPagehandle);
        //switchTo() ile window degistireceksek gidecegimiz window'un windowhandle degerine ihtiyacimiz var...
        softAssert.assertEquals(driver.getTitle(), "New Window", "yeni penceredeki title uyusmuyor");
//    ● Sayfadaki textin “New Window” olduğunu doğrulayın.
        WebElement newText = driver.findElement(By.tagName("h3"));
        softAssert.assertEquals(newText.getText(), "New Window", "Yeni penceredeki text uyusmuyor");
//    ● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu
//        doğrulayın.
        driver.switchTo().window(mainPageHandle);
        softAssert.assertEquals(driver.getTitle(),"The Internet","MainPage title uyusmuyor");
        softAssert.assertAll();
    }
}
