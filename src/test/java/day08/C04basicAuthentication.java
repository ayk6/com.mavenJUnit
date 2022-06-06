package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class C04basicAuthentication {
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/basic_auth");
    }

    @Test
    public void test1(){
        // https://the-internet.herokuapp.com/basic_auth
        // adresine gittiğimizde alert olarak username ve şifre istiyor
        // bu aşamayı atalamak için username ve password içeren link hazırlanır
        // doğrudan otomasyon girişi sağlanır : basic authentication
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
    }
}
