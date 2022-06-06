package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class C01alerts {
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
        driver.quit();
    }

    @Test
    public void test1(){
        // sitelerde karşımıza çıkan uyarılar : allert
        // allert right click+ inspect yapılabilirse : html allert
        // inspect yapılamazsa : jsAllert (javaScript Allert)
        // switchTo() ile çözülür

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        // çıkan uyarıda yalnızca ok butonu var, inspect edilemez
        // js allert - switchTo().alert().accept() ile geçilir
        driver.switchTo().alert().accept();
        System.out.println(driver.findElement(By.id("result")).getText());
        Assert.assertEquals("You successfully clicked an alert",
                driver.findElement(By.id("result")).getText());
        // test passed
    }
}
