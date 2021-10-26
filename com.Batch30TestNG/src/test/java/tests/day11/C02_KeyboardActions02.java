package tests.day11;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C02_KeyboardActions02 extends TestBase {
    /*
    1- Bir Class olusturalim C02_KeyboardActions2
    2- https://html.com/tags/iframe/ sayfasina gidelim
    3- video’yu gorecek kadar asagi inin
    4- videoyu izlemek icin Play tusuna basin
    5- videoyu calistirdiginizi test edin
     */
    @Test
    public void videoTest(){
        driver.get("https://html.com/tags/iframe/");
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .perform();
        WebElement iframVideo = driver.findElement(By.className("lazy-loaded"));
        driver.switchTo().frame(iframVideo);
        WebElement playButton = driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']"));
        playButton.click();
        Assert.assertFalse(playButton.isDisplayed(),"video baslamadi");
    }
}
