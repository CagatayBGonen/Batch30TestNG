package tests.day11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C05_UploadFile extends TestBase {
    /*
    1- Tests packagenin altina bir class oluşturun : C05_UploadFile
    2- https://the-internet.herokuapp.com/upload adresine gidelim
    3- chooseFile butonuna basalim
    4- Yuklemek istediginiz dosyayi secelim.
    5- Upload butonuna basalim.
    6- “File Uploaded!” textinin goruntulendigini test edelim.
     */
    @Test
    public void fileUploadTest(){
        driver.get("https://the-internet.herokuapp.com/upload");

        String filePath = System.getProperty("user.home")+"\\Desktop\\test.png";
        WebElement fileUpload = driver.findElement(By.id("file-upload"));
        fileUpload.sendKeys(filePath);
        WebElement uploadButton = driver.findElement(By.id("file-submit"));
        uploadButton.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(driver.findElement(By.tagName("h3")).getText(),"File Uploaded!","text goruntulenmiyor");
    }
}
