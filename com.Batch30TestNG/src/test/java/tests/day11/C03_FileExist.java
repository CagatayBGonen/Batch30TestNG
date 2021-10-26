package tests.day11;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist {
    @Test
    public void test(){
        System.out.println(System.getProperty("user.home"));
        //"C:\Users\cbgon\Desktop\test.png"

        // masaüstündeki bir dosya yolunun tum bilgisayarlarda sorunsuz calismasi icin
        // dosya yolunun ikiye ayiracaz
        // 1- Herkesin bilgisayarinda farkli olan kisim
        //         bu kismi bilgisayardan System.getProperty("user.home") kodu ile alabiliriz
        // 2- Herkes ile ayni olan kisim
        //          bu kisim 1. maddedeki yolun devami seklinde olur.

        //masaüstündeki test dosyasi icin yol kaydedelim

        String filePath = System.getProperty("user.home")+"\\Desktop\\test.png";
        System.out.println("Dosyanin yolu : "+filePath);
        System.out.println(Files.exists(Paths.get(filePath)));
        Assert.assertTrue(Files.exists(Paths.get(filePath)),"Dosya yok");
    }
}
