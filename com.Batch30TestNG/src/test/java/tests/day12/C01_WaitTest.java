package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class C01_WaitTest extends TestBase {
    /*
    1. Bir class olusturun : WaitTest
    2. Iki tane metod olusturun : implicitWait() , explicitWait()
	    Iki metod icin de asagidaki adimlari test edin.
    3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    4. Remove butonuna basin.
    5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
    6. Add buttonuna basin
    7. It’s back mesajinin gorundugunu test edin
     */
    @Test
    public void implicitlyWaitTest(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("//*[text()='Remove']")).click();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(driver.findElement(By.id("message")).isDisplayed(),"mesaj goruntulenmiyor");
        softAssert.assertAll();
        driver.findElement(By.xpath("//*[text()='Add']")).click();
        Assert.assertTrue(driver.findElement(By.id("message")).isDisplayed(),"mesaj goruntulenmiyor");
    }
    @Test
    public void explicitlyWaitTest(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("//*[text()='Remove']")).click();
        WebDriverWait wait = new WebDriverWait(driver,20);
        WebElement withTextLocate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(withTextLocate.isDisplayed(),"mesaj goruntulenmiyor");
        softAssert.assertAll();
        driver.findElement(By.xpath("//*[text()='Add']")).click();
        WebElement addMessageLocate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        Assert.assertTrue(addMessageLocate.isDisplayed(),"mesaj goruntulenmiyor");
    }

}
