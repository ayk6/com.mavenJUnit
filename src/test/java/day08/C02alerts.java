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

public class C02alerts {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void acceptTest() {
        // çıkan uyarıda ok ve cancel var ise : JS Confirm
        // switchTo().alert().accept ya da dismiss yapılabilir

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        driver.switchTo().alert().accept();
        Assert.assertEquals("You clicked: Ok",driver.findElement(By.id("result")).getText());
    }

    @Test
    public void dismissTest() {
        // çıkan uyarıda ok ve cancel var ise : JS Confirm
        // switchTo().alert().accept ya da dismiss yapılabilir

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        driver.switchTo().alert().dismiss();
        Assert.assertEquals("You clicked: Cancel",driver.findElement(By.id("result")).getText());
    }
}
