package tests.day11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C06_ActionsClassHomeWork extends TestBase {
    /*
    Yeni Class olusturun ActionsClassHomeWork
1- "http://webdriveruniversity.com/Actions" sayfasina gidin
2- Hover over Me First" kutusunun ustune gelin
3- Link 1" e tiklayin
4- Popup mesajini yazdirin
5- Popup'i tamam diyerek kapatin
6- “Click and hold" kutusuna basili tutun
7-“Click and hold" kutusunda cikan yaziyi yazdirin
8- “Double click me" butonunu cift tiklayin

     */
    @Test
    public void actionsTest() throws InterruptedException {
        driver.get("http://webdriveruniversity.com/Actions");
        Actions actions = new Actions(driver);
        WebElement hoverOverMeFirstElement = driver.findElement(By.xpath("//button[text()='Hover Over Me First!']"));
        WebElement clickBox = driver.findElement(By.id("click-box"));
        WebElement doubleClick = driver.findElement(By.tagName("h2"));
        actions.moveToElement(hoverOverMeFirstElement)
                .click(driver.findElement(By.xpath("(//a[text()='Link 1'])[1]")))
                .perform();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        actions.clickAndHold(clickBox).perform();
        System.out.println(clickBox.getText());
        actions.release()
                .doubleClick(doubleClick)
                .perform();
    }
}
