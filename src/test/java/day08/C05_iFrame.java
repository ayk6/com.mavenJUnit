package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class C05_iFrame {
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
        driver.get("https://the-internet.herokuapp.com/iframe");
        // an iframe containing ... erişilebilir mi kontrol et
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());
        // test passed
        // sitedeki testBox'a deneme cümlesi yaz
        // driver.findElement(By.cssSelector("body[id='tinymce']"))
        //        .sendKeys("deneme cümlesi");

        // iFrame olduğu için elementi bulamadı
        // switchTo() ile box'ın bulunduğu iFrame'e geçebiliriz
        driver.switchTo().frame("mce_0_ifr");
        WebElement textBox = driver.findElement(By.cssSelector("body[id='tinymce']"));
        textBox.clear();
        textBox.sendKeys("deneme cümlesi");
        // iFrame'den çık (ana siteye dön) ve elementan selenium'a tıkla
        driver.switchTo().defaultContent(); // en üst frame'e çıkar
        // parentFrame bir üste çıkar
        driver.findElement(By.linkText("Elemental Selenium")).click();
    }
}
