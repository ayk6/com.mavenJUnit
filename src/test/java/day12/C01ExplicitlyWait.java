package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C01ExplicitlyWait extends TestBase {
    @Test
    public void test1(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        // click remove
        driver.findElement(By.xpath("//*[text()='Remove']")).click();
        // check message
        WebElement message = driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(message.isDisplayed());
        // click Add
        driver.findElement(By.xpath("//*[text()='Add']")).click();
        // check its back message
        WebElement message2 = driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(message2.isDisplayed());
        // test passed
        // parent class'ta oluşturulan implicitly wait süresi yeterli
    }
    @Test
    public void test2(){
        // implicitly wait süresi kısaltılınca fail
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        // click remove
        driver.findElement(By.xpath("//*[text()='Remove']")).click();
        // check message
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // bekletirken locate etmeye çalışmak hata verdi
        // bekleme ve locate birlikte yapılacak
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        wait.until(ExpectedConditions.visibilityOf(message));
        Assert.assertTrue(message.isDisplayed()); // passed
        // click Add
        driver.findElement(By.xpath("//*[text()='Add']")).click();
        // check its back message
        WebElement message2 =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        wait.until(ExpectedConditions.visibilityOf(message2));
        Assert.assertTrue(message2.isDisplayed()); // passed
    }
}
