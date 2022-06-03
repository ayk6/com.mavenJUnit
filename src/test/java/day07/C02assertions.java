package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class C02assertions {
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.bestbuy.com/");
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    @Test
    public void test1() {
        // url https://www.bestbuy.com/ ile eşit mi kontrol et
        Assert.assertEquals("https://www.bestbuy.com/",
                driver.getCurrentUrl());
    }

    @Test
    public void test2() {
        // başlık Rest içermediğini kontrol et
        Assert.assertFalse(driver.getTitle().contains("Rest"));
    }

    @Test
    public void test3() {
        // logo görünüyor mu kontrol et
        Assert.assertTrue(driver.findElement(By.xpath("(//img[@class='logo'])[1]"))
                .isDisplayed());
    }

    @Test
    public void test4() {
        // fransızca linkini kontrol et
        Assert.assertTrue(driver.findElement(By.xpath("//button[@lang='fr']"))
                .isDisplayed());
    }
}
