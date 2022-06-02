package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class C03radioButton {
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
        driver.close();
    }

    @Test
    public void  radioButton() throws InterruptedException {
        // facebook adresine git
        driver.get("https://www.facebook.com");
        // creat account tıkla
        driver.findElement(By.cssSelector("*[class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy'")).click();
        // radio buttonları locate et
        WebElement female = driver.findElement(By.xpath("//input[@value='1']"));
        WebElement male = driver.findElement(By.xpath("//input[@value='2']"));
        WebElement spec = driver.findElement(By.xpath("//input[@value='-1']"));
        // seçili değilse uygun olanı seç
        if (!male.isSelected()){
            male.click();
        }
        Thread.sleep(5000);
    }

}
