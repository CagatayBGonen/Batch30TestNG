package tests.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C05_MouseActions03 extends TestBase {
    /*
    Yeni bir class olusturalim: C05_MouseActions3
1- https://www.amazon.com/ adresine gidelim
2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin
mouse’u bu menunun ustune getirelim
3- “Create a list” butonuna basalim
4- Acilan sayfada “Your Lists” yazisi oldugunu test edelim
     */
    @Test
    public void test01(){
        driver.get("https://www.amazon.com/");
        Actions actions = new Actions(driver);
        WebElement accountListsMenu = driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
        actions.moveToElement(accountListsMenu).perform();
        WebElement createList = driver.findElement(By.xpath("//*[text()='Create a List']"));
        createList.click();
        Assert.assertEquals(driver.findElement(By.xpath("//div[@role='heading']")).getText(),"Your Lists","Your Lists yazisi yok");
    }
}
