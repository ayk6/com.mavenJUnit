package day15;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.security.Key;

public class C03_screenShot extends TestBase {
    @Test
    public void t1() throws IOException {
        driver.get("https://www.amazon.com.tr");
        driver.findElement(By.id("twotabsearchtextbox"))
                .sendKeys("pcıe 4.0 ssd"+ Keys.ENTER);

        WebElement resultText = driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));
        File resultSS = new File("target/screenshot/resultSS.jpeg");
        File temp = resultText.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(temp,resultSS);
    }
}
