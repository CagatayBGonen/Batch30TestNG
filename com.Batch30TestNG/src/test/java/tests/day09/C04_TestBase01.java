package tests.day09;

import org.testng.annotations.Test;
import utilities.TestBase;

public class C04_TestBase01 extends TestBase {
    @Test
    public void test01(){
        driver.get("https://www.youtube.com/");
        System.out.println(driver.getTitle());
    }
}
