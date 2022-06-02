package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class C01beforeAfterClass {

    static WebDriver driver;
    // beforeClass ve afterClass, before-after'dan farklı olarak
    // sadece static methodlarda çalışır
    // before after, her methoddan önce ve sonra çalışır
    // beforeClass afterClass ise en başta ve en sonda bir kez çalışır

    @BeforeClass
    public static void setUp(){
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
    public void test01() throws InterruptedException {
        driver.get("https://www.github.com");
    }
    @Test
    public void test02() {
        driver.get("https://www.amazon.com");
    }
}
