package tests.day10;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Set;


public class C03_MouseActions01 extends TestBase {
    /*
    1- Yeni bir class olusturalim: C03_MouseActions1
    2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
    3- Cizili alan uzerinde sag click yapalim
    4- Alert’te cikan yazinin “You selected a context menu” oldugunu
        test edelim.
    5- Tamam diyerek alert’I kapatalim
    6- Elemental Selenium linkine tiklayalim
    7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
     */
    @Test
    public void test01(){
        driver.get("https://the-internet.herokuapp.com/context_menu");
        Actions actions = new Actions(driver);
        WebElement ciziliAlan = driver.findElement(By.id("hot-spot"));
        actions.contextClick(ciziliAlan).perform();
        Assert.assertEquals(driver.switchTo().alert().getText(),"You selected a context menu","Alert Text uyusmuyor");
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();
        String mainPageHandle = driver.getWindowHandle();
        driver.findElement(By.linkText("Elemental Selenium")).click();
        Set<String> allPageHandles = driver.getWindowHandles();
        String elementalSelHandle = " ";
        for(String each : allPageHandles){
            if (!each.equals(mainPageHandle)){
                elementalSelHandle = each;
            }
        }
        driver.switchTo().window(elementalSelHandle);
        Assert.assertEquals(driver.findElement(By.tagName("h1")).getText(),"Elemental Selenium","Elemental Selenium Page'inde h1 tagi texti uyusmuyor");

    }
}
