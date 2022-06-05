package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C05dropDown {
    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown (){
        driver.quit();
    }
    @Test
    public void test1(){
        driver.get("https://www.amazon.com");
        WebElement categories = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(categories);
        // books seç ve yazdır
        select.selectByVisibleText("Books");
        System.out.println("seçilen kategori : "+select.getFirstSelectedOption().getText());
        // kategori sayısını yazdır
        System.out.println("kategori sayısı : "+ select.getOptions().size());
        // kategori sayısı 28 mi kontrol et
        Assert.assertTrue(select.getOptions().size()==28);
    }
}
