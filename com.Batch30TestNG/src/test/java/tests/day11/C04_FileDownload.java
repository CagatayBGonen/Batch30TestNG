package tests.day11;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileDownload extends TestBase {
    /*
    1. Tests packagenin altina bir class oluşturalim : C04_FileDownload
    2. Iki tane metod oluşturun : isExist() ve downloadTest()
    3. downloadTest () metodunun icinde aşağıdaki testi yapalim:
		- https://the-internet.herokuapp.com/download adresine gidelim.
		- file_to_download.txt dosyasını indirelim
    4. Ardından isExist()  methodunda dosyanın başarıyla indirilip indirilmediğini test edelim
     */

    @Test (priority = 2,dependsOnMethods = "downloadTest")
    public void isExist(){
        String file_to_download_path = "\\Downloads\\file_to_download.txt";
        String filePath = System.getProperty("user.home")+file_to_download_path;
        Assert.assertTrue(Files.exists(Paths.get(filePath)),"Dosya indirilmemis/bulunamiyor");
    }
    @Test (priority = 1)
    public void downloadTest(){
        driver.get("https://the-internet.herokuapp.com/download");
        driver.findElement(By.linkText("file_to_download.txt")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Test (priority = 3,dependsOnMethods = "isExist")
    public void fileDeleteTest() throws IOException {
        String file_to_download_path = "\\Downloads\\file_to_download.txt";
        String filePath = System.getProperty("user.home")+file_to_download_path;
        System.out.println("Dosya silindi mi : " + Files.deleteIfExists(Paths.get(filePath)));
    }
}
