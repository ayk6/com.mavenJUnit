package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02actions extends TestBase {
    @Test
    public void test1() throws InterruptedException {
        driver.get("https://html.com/tags/iframe/");
            // iFrame video görünür olmadığı için pageDown
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        // locate iframe
        WebElement iframe = driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        driver.switchTo().frame(iframe);

        Thread.sleep(3000);

        // locate play button nd click
        driver.findElement(By.xpath("//button[@aria-label='Oynat']")).click();

        // video çalıştı mı kontrol et - video açıldığında görünen linklerden
        WebElement isDisplayed = driver.findElement(By.xpath("//a[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']"));

        Assert.assertTrue(isDisplayed.isDisplayed());


    }
}
