package tests.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C04_MouseActions02 extends TestBase {
    /*
    Yeni bir class olusturalim: D14_MouseActions2
1- https://demoqa.com/droppable adresine gidelim
2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
     */
    @Test
    public void test01(){
        driver.get("https://demoqa.com/droppable");
        Actions actions = new Actions(driver);
        WebElement dragMe = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement dropHere = driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));
        actions.dragAndDrop(dragMe,dropHere).perform();
        Assert.assertEquals(dropHere.getText(),"Dropped!","Dropped! mesaji cikmadi");
    }
}
