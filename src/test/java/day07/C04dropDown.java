package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C04dropDown {
    static WebDriver driver;

    @BeforeClass
    public static void setUp () {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }

    @Test
    public void test1() {
        // go to amazon
        driver.get("https://www.amazon.com");
        // locate categories
        WebElement categories = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        // assign categories to a new select variable
        Select select = new Select(categories);
        // choose books
        select.selectByIndex(5);
        // select.selectByValue("search-alias=stripbooks-intl-ship");
        // select.selectByVisibleText("Books");
        // search java
        WebElement searchBar = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBar.sendKeys("java"+ Keys.ENTER);
        // write result
        WebElement result = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        System.out.println(result.getText());
        Assert.assertTrue(result.getText().contains("java"));
    }
}
