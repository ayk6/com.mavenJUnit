package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class C02handleWindows {
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
         driver.close(); // açık sekme
         driver.quit(); // tüm sekmeler
    }

    @Test
    public void test1() {
        driver.get("https://www.amazon.com");
        String firstPage = driver.getWindowHandle();
        // url amazon içeriyor mu kontrol et
        Assert.assertTrue(driver.getCurrentUrl().contains("amazon"));
        // yeni pencere aç
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.bestbuy.com/");
        String secPage= driver.getWindowHandle();
        // title BestBuy içeriyor mu kontrol et
        Assert.assertTrue(driver.getTitle().contains("Best Buy"));
        // ilk sayfaya dön ve java ara
        driver.switchTo().window(firstPage);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java"+ Keys.ENTER);
        // arama sonuçlarında java var mı kontrol et
        WebElement res = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(res.getText().contains("java"));
        // best buy'a dön
        driver.switchTo().window(secPage);
        Assert.assertTrue(driver.findElement(By.xpath("(//img[@class='logo'])[1]")).isDisplayed());


    }
}
