package firstCourse;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\cbgon\\OneDrive\\Belgeler\\selenium\\driver\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://google.com");
    }
}
