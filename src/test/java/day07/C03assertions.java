package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class C03assertions {
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
    public void test1(){
        driver.get("http://automationpractice.com/index.php");
        // click sign in
        driver.findElement(By.xpath("//a[@class='login']")).click();
        // send wrong e-mail
        WebElement mailBar = driver.findElement(By.xpath("//input[@id='email']"));
        mailBar.sendKeys("wrong.mail"+ Keys.ENTER);
        // hata mesajını test et
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Invalid email address.']"))
                .isDisplayed());
    }
    
}
