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

public class C06dropDown {
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
    public void test1() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        // choose op1 with index + print
        WebElement dDown = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select = new Select(dDown);
        select.selectByIndex(1);
        System.out.println("first : "+select.getFirstSelectedOption().getText());
        // choose op2 w value + print
        select.selectByValue("2");
        System.out.println("second : "+ select.getFirstSelectedOption().getText());
        // choose op1 w text + print
        select.selectByVisibleText("Option 1");
        System.out.println("3rd : "+select.getFirstSelectedOption().getText());
        // print all options
        select.getOptions().stream().forEach(t-> System.out.print(t.getText()+" , "));
        // seçenekler 3 tane mi kontrol et
        Assert.assertTrue(select.getOptions().size()==3);

    }
}
