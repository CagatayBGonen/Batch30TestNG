package tests.day12;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C02_Faker extends TestBase {
    /*
      "https://facebook.com"  Adresine gidin
“create new account”  butonuna basin
“firstName” giris kutusuna bir isim yazin
“surname” giris kutusuna bir soyisim yazin
“email” giris kutusuna bir email yazin
“email” onay kutusuna emaili tekrar yazin
Bir sifre girin
Tarih icin gun secin
Tarih icin ay secin
Tarih icin yil secin
Cinsiyeti secin
Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
Sayfayi kapatin

     */
    @Test
    public void test() throws InterruptedException {
        driver.get("https://facebook.com");
        driver.findElement(By.linkText("Yeni Hesap Oluştur")).click();
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();
        Actions actions = new Actions(driver);
        WebElement firsNameBox = driver.findElement(By.xpath("//input[@name='firstname']"));
        actions.click(firsNameBox)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(email)
                .sendKeys(Keys.TAB)
                .sendKeys(email)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(String.valueOf(faker.number().numberBetween(1,31)))
                .sendKeys(Keys.TAB)
                .sendKeys("May")
                .sendKeys(Keys.TAB)
                .sendKeys(String.valueOf(faker.number().numberBetween(1,31)))
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT)
                .sendKeys(Keys.ARROW_LEFT)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .perform();
        Thread.sleep(5000);
        Assert.assertTrue(driver.findElement(By.xpath("(//input[@name='sex'])[1]")).isSelected(),"Cinsiyet secilmedi");
        actions.sendKeys(Keys.ENTER).perform();
    }
}
