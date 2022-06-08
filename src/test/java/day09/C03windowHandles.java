package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;
import java.util.Set;

public class C03windowHandles {
    WebDriver driver;

    @Before
    public void setUop(){
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown(){
        //driver.quit();
    }

    @Test
    public void test1(){
        // switchTo() ile açılmayan sekmelerde driver eski sekmede kalır
        // (sayfada yapılan işlemler ile açılan yeni sekme)
        // driver yeni sayfaya gönderilmeli

        driver.get("https://the-internet.herokuapp.com/windows");
        String firstPage = driver.getWindowHandle();
        // sayfadaki text Opening a new window'mu kontrol et
        Assert.assertTrue(driver.findElement
                (By.tagName("h3")).getText().contains("Opening a new window"));
        // sayfa başlığını doğrula
        Assert.assertEquals("The Internet", driver.getTitle());
        // click to button
        driver.findElement(By.linkText("Click Here")).click();
        // is new tab title New Window // FALSE
        // Assert.assertEquals("New Window",driver.getTitle());
        // verify text  FALSE
        // Assert.assertEquals("New Window",driver.findElement(By.tagName("h3")));
        // return first page

        Set<String> setWH = driver.getWindowHandles();
        // sekmelerin hash kodlarını aldı

        String secPage ="";
        for (String each:setWH
             ) {
            if (!each.equals(firstPage)){
                 secPage= each; // ikinci sayfayı bulduk
            }
        }
        driver.switchTo().window(secPage);

         // is new tab title New Window
         Assert.assertEquals("New Window",driver.getTitle());
         // verify text
         Assert.assertEquals("New Window",driver.findElement(By.tagName("h3")).getText());

    }
}
