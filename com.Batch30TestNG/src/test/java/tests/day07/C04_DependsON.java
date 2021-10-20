package tests.day07;

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

public class C04_DependsON {
    /*
    ● Bir class oluşturun: DependsOnTest
    ● https://www.amazon.com/ adresine gidin.
     */

    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com/");
    }

    //1. Test : Amazon ana sayfaya gittiginizi test edin
    @Test
    public void testGet() {
        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.amazon.com/"), "Sayfaya gidilmedi");
    }

    //2. Test : 1.Test basarili ise search Box’i kullanarak “Nutella” icin
    //            arama yapin ve aramanizin gerceklestigini Test edin
    @Test(dependsOnMethods = "testGet")
    public void searchBoxTest() {
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Nutella" + Keys.ENTER);
        Assert.assertTrue(driver.getCurrentUrl().contains("Nutella"), "\"Nutella\" aramasi gerceklesmedi");
    }

    //3.Test : “Nutella” icin arama yapildiysa ilk urunu tiklayin ve fiyatinin
    //            $16.83 oldugunu test edin
    @Test(dependsOnMethods = "searchBoxTest")
    public void firstProductPriceTest() {
        driver.findElement(By.xpath("//span[text()='Nutella Chocolate Hazelnut Spread, Perfect Topping for Halloween Treats, 35.2 Oz Jar']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//span[text()='$13.20']")).getText(), "$16.83", "Fiyat expected ile ortusmuyor");
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }
}
