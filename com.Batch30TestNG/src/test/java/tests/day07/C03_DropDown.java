package tests.day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class C03_DropDown {
// ● Bir class oluşturun: DropDown
//
// ● https://the-internet.herokuapp.com/dropdown adresine gidin.
//
//      1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
//
//      2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
//
//      3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve
//        yazdırın
//
//      4.Tüm dropdown değerleri(value) yazdırın
//
//      5.Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True ,
//        degilse False yazdırın.
    static WebDriver driver;
    static WebElement selectElement = driver.findElement(By.id("dropdown"));
    static Select options = new Select(selectElement);

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }
    @Test
    public void Test(){
        System.out.println("Begining of Test");
    }



    @Ignore
    public static void tearDown(){
        driver.close();
    }


}
