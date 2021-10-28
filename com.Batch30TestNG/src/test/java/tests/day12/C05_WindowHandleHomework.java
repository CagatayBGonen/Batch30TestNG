package tests.day12;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Set;

public class C05_WindowHandleHomework extends TestBase {
    /*
    1."http://webdriveruniversity.com/" adresine gidin
2."Login Portal" a  kadar asagi inin
3."Login Portal" a tiklayin
4.Diger window'a gecin
5."username" ve  "password" kutularina deger yazdirin
6."login" butonuna basin
7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
8.Ok diyerek Popup'i kapatin
9.Ilk sayfaya geri donun
10.Ilk sayfaya donuldugunu test edin
     */
    @Test
    public void windowTest(){
        driver.get("http://webdriveruniversity.com/");
        String mainPageHandle = driver.getWindowHandle();
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN)
                .click(driver.findElement(By.xpath("//*[text()='LOGIN PORTAL']")))
                .perform();
        String loginPortalPageHandle = " ";
        Set<String> allPagehandles = driver.getWindowHandles();
        for (String each : allPagehandles){
            if (!each.equals(mainPageHandle)){
                loginPortalPageHandle = each;
            }
        }
        driver.switchTo().window(loginPortalPageHandle);
        Faker faker = new Faker();
        WebDriverWait wait = new WebDriverWait(driver,20);
        WebElement usernameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("text")));
        actions.sendKeys(usernameElement,faker.name().username())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.ENTER)
                .perform();
        String validationFailedText = driver.switchTo().alert().getText();
        Assert.assertTrue(validationFailedText.contains("validation failed"));
        driver.switchTo().alert().accept();
        driver.switchTo().window(mainPageHandle);
        Assert.assertEquals(driver.getWindowHandle(),mainPageHandle,"ilk sayfaya donulmedi");

    }
}
