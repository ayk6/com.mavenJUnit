package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02explicitlyWait extends TestBase {
    @Test
    public void enableTest() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        // locate textBox
        WebElement textBox = driver.findElement(By.xpath("//input[@type='text']"));
        // isn't textBox enable
        Assert.assertFalse(textBox.isEnabled());
        // click button nd wait until textBox is enabled
        driver.findElement(By.xpath("//button[@onclick='swapInput()']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(textBox));
        // check message
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()=\"It's enabled!\"]")).isDisplayed());
        // test passed
    }
}
