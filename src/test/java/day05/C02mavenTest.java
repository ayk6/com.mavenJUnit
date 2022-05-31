package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class C02mavenTest {
    public static void main(String[] args) {

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("http://zero.webappsecurity.com");
        // sign in butonuna tıkla
        driver.findElement(By.id("signin_button")).click();
        // username yaz
        driver.findElement(By.xpath("//input[@id='user_login']"))
                .sendKeys("username");
        // şifre gir
        driver.findElement(By.xpath("//input[@id='user_password']"))
                .sendKeys("password");
        // sign tıkla
        driver.findElement(By.xpath("//input[@name='submit']")).click();
        // hata verdiği için önceki sayfaya geç
        driver.navigate().back();
        // online banking tıkla
        driver.findElement(By.xpath("(//*[text()='Online Banking'])[1]")).click();
        //pay bills tıkla
        driver.findElement(By.id("pay_bills_link")).click();
        // amount kısmına yatırılacak miktarı yaz
        driver.findElement(By.xpath("//input[@id='sp_amount']"))
                .sendKeys("100");
        // tarih yaz
        driver.findElement(By.id("sp_date")).sendKeys("2020-09-10");
        // pay butonuna tıkla
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        // sonuç yazısını kontrol et
        WebElement result = driver.findElement(By.xpath("//*[text()='The payment was successfully submitted.']"));

        if (result.isDisplayed()){
            System.out.println("test passed");
        }else System.out.println("test failed");


    }
}
