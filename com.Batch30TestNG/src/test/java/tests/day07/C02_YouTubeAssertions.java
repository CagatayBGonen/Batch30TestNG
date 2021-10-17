package tests.day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class C02_YouTubeAssertions {
    // 1) Bir class oluşturun: YoutubeAssertions
//
// 2) https://www.youtube.com adresine gidin
//
// 3) Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin
//
//      ○ titleTest
//          => Sayfa başlığının “YouTube” oldugunu test edin
//
//      ○ imageTest
//          => YouTube resminin görüntülendiğini (isDisplayed()) test edin
//
//      ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
//
//      ○ wrongTitleTest
//          => Sayfa basliginin “youtube” olmadigini dogrulayin
    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.youtube.com/");
    }

    @Test (priority = 4)
    public void titleTest01() {
        Assert.assertEquals(driver.getTitle(), "YouTube", "baslik \"YouTube\" degil");
    }

    @Test (priority = 1)
    public void imageTest01() {
        Assert.assertTrue(driver.findElement(By.xpath("(//yt-icon[@class='style-scope ytd-topbar-logo-renderer'])[1]")).isDisplayed(), "image goruntulenmiyor");
    }

    @Test (priority = 2)
    public void searchboxTest01() {
        Assert.assertTrue(driver.findElement(By.id("search")).isEnabled(), "searchbox kullanilmiyor");
    }

    @Test (priority = 3)
    public void wrongTitleTest01() {
        Assert.assertFalse(driver.getTitle().equals("youtube"), "baslik \"youtube\"'a esit");
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }
}
