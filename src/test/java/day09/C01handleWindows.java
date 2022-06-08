package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;

import java.security.Key;
import java.time.Duration;

public class C01handleWindows {
    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown(){
        // driver.quit();
    }

    @Test
    public void test1(){
        driver.get("https://www.amazon.com");
        System.out.println(driver.getWindowHandle());
        String firstPage = driver.getWindowHandle();
        // açıan sayfanın unique hash kodunu yazdırır
        // sayfalar arası geçişte bu değer kullanılır
        // driver.switchTo().window() nameOrHandle değerleriyle sayfaya geçilir

        // ilk resmi yeni sekmede aç
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("blue light glasses"+ Keys.ENTER);
        WebElement firstPic = driver.findElement(By.xpath("(//img[@class='s-image'])[1]"));
        driver.switchTo().newWindow(WindowType.TAB); // boş yeni sekme açıldı

        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("blue light glasses"+ Keys.ENTER);
        driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();

        // ürün adını yazdır
        System.out.println(driver.findElement(By.id("productTitle")).getText());
        // ilk sayfaya geç ve url yazdır
        driver.switchTo().window(firstPage);
        System.out.println(driver.getCurrentUrl());
    }
}
