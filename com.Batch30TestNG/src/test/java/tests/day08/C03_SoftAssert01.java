package tests.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class C03_SoftAssert01 {
    /*
    Yeni bir Class Olusturun : C03_SoftAssert
    1. “http://zero.webappsecurity.com/” Adresine gidin
    2. Sign in butonuna basin
    3. Login kutusuna “username” yazin
    4. Password kutusuna “password” yazin
    5. Sign in tusuna basin
    6. Pay Bills sayfasina gidin
    7. “Purchase Foreign Currency” tusuna basin
    8. “Currency” drop down menusunden Eurozone’u secin
    9. soft assert kullanarak "Eurozone (Euro)" secildigini test edin
    10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin "Select
        One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China
        (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong
        (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand
        (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"
     */
    WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @Test
    public void test01() {
        SoftAssert softAssert = new SoftAssert();
        driver.get("http://zero.webappsecurity.com/");
        WebElement signInButton = driver.findElement(By.id("signin_button"));
        signInButton.click();
        WebElement loginBox = driver.findElement(By.id("user_login"));
        loginBox.sendKeys("username" + Keys.TAB + "password" + Keys.ENTER);
        driver.navigate().back();
        driver.findElement(By.id("onlineBankingMenu")).click();
        driver.findElement(By.id("pay_bills_link")).click();
        driver.findElement(By.linkText("Purchase Foreign Currency")).click();
        WebElement currencyDropDownMenu = driver.findElement(By.id("pc_currency"));
        Select select = new Select(currencyDropDownMenu);
        select.selectByIndex(6);
        System.out.println(select.getFirstSelectedOption().getText());
        softAssert.assertTrue(select.getFirstSelectedOption().isSelected(), "\"Eurozone (Euro)\" secili degil");
        List<WebElement> allOptions = select.getOptions();
        List<String> allOptionsString = new ArrayList<>();
        for (WebElement each : allOptions) {
            allOptionsString.add(each.getText());
        }
        List<String> expectedAllOptions = Arrays.asList("Select One","Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)");
        softAssert.assertEquals(allOptionsString,expectedAllOptions,"Options'lar farkli");

        softAssert.assertAll();
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }
}
