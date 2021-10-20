package tests.day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class C03_DropDown {
    // ● Bir class oluşturun: DropDown


    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void Test() {
        // ● https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");
        //dropdown'nu locate ediyoruz.
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        //Select obj sini olusturmamiz lazim
        Select select = new Select(dropdown);
        //      1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());
        //      2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());
//      3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve
//        yazdırın
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());
        //      4.Tüm dropdown değerleri(value) yazdırın
        List<WebElement> allOptions = select.getOptions();
        System.out.println("All options :");
        for (WebElement each : allOptions) {
            System.out.println(each.getText());
        }

        //      5.Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True ,
//        degilse False yazdırın.
        System.out.println(allOptions.size());
        Assert.assertEquals(allOptions.size(), 4, "False");

    }


    @AfterMethod
    public void tearDown() {
        driver.close();
    }


}
