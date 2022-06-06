package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class C03alerts {
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
    public void sendKeys(){
        // alert veri girişi istiyorsa : JS prompt

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();

        // js prompt - switchTo().alert().sendKeys() ile veri gönderilir
        driver.switchTo().alert().sendKeys("sending message");
        driver.switchTo().alert().accept();
        System.out.println(driver.findElement(By.id("result")).getText());
        Assert.assertEquals("You entered: sending message",
                driver.findElement(By.id("result")).getText());
        // test passed
    }
    @Test
    public void sendKeysDismiss() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();

        driver.switchTo().alert().dismiss();
        System.out.println(driver.findElement(By.id("result")).getText());
        Assert.assertEquals("You entered: null",
                driver.findElement(By.id("result")).getText());
        // test passed
    }
}
