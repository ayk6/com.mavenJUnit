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

public class C02checkBoxTest {
    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    //@After
    //public void tearDown(){
      //  driver.close();
    //}

    @Test
    public void test1() {
        // herokuapp.com/checkboxes'a git
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        // checkbox 1 ve 2 locate
        WebElement cb1 = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
        WebElement cb2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));
        // checkbox1 ve 2 seçili değilse onay kutusuna tıkla
        if (!cb1.isSelected()){
            cb1.click();
        }
        if (!cb2.isSelected()){
            cb2.click();
        }
    }
}
