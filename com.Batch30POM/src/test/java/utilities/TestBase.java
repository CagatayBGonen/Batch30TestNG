package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {
    //abstract yapmak sart degil ama bu sayede bu classtan obj olusturulmasini onluyoruz.
    protected WebDriver driver;
    //extends ile inherit ettigimiz icin, protected kullanabiliriz. (olablidigince dar tutmaya calismaliyiz)
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
