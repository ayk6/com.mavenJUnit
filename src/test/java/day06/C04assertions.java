package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class C04assertions {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public  void tearDown(){
        driver.close();
    }

    @Test
    public void test1(){
        // test metodunda test yoksa test çalıştı mı kontrol eder test passed verir
        // if ile test yapılırsa sonuç olumsuz olsa da sol altta test passed yazar
        // testin tamamlandığını gösterir
        // fail sonucu alabilmek için assert kullanılır
        driver.get("https://www.amazon.com");
        String actUrl= driver.getCurrentUrl();
        String expUrl= "https://www.github.com/";

        Assert.assertEquals("url farklı",expUrl,actUrl);

        // asssert içine hata mesajı da yazılabilir
        // test tamamlandı ama failed sonucu verdi
        // sonuç : Expected :https://www.github.com
        //         Actual   :https://www.amazon.com/
    }
}
