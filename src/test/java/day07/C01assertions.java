package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class C01assertions {

    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.amazon.com");
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    @Test
    public void test1(){
        // amazona git ve url amazon içeriyor mu kontrol et
        String actUrl = driver.getCurrentUrl();
        String expWord = "amazon";
        Assert.assertTrue(actUrl.contains(expWord));
    }

    @Test
    public void test2(){
        // site başlığının zamazor olmadığını kontrol et
        String unExpWord = "zamazor";
        String actTitle = driver.getTitle();
        Assert.assertFalse(actTitle.contains(unExpWord));
    }

    @Test
    public void test3(){
        // amazon logosu var mı kontrol et
        WebElement logo = driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(logo.isDisplayed());
    }
}
