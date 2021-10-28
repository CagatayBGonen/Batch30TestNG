package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class C03_EnableTest extends TestBase {
    /*
    1. Bir class olusturun : EnableTest
2. Bir metod olusturun : isEnabled()
3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
4. Textbox’in etkin olmadigini(enabled) dogrulayın
5. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
6. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
7. Textbox’in etkin oldugunu(enabled) dogrulayın.
     */
    @Test
    public void isEnabledTest(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement textBoxElement = driver.findElement(By.xpath("//input[@type='text']"));
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(textBoxElement.isEnabled(),"Text Box enabled");
        driver.findElement(By.xpath("//*[text()='Enable']")).click();
        WebDriverWait wait = new WebDriverWait(driver,20);
        WebElement enabledTextBoxElement = wait.until(ExpectedConditions.elementToBeClickable(textBoxElement));
        softAssert.assertTrue(driver.findElement(By.id("message")).isDisplayed(),"mesaj goruntulenmiyor");
        softAssert.assertTrue(enabledTextBoxElement.isEnabled(),"text box kullanilamiyor");
        softAssert.assertAll();
    }
}
