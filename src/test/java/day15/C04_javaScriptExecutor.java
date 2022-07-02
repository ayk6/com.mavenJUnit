package day15;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Javascript;
import utilities.TestBase;

public class C04_javaScriptExecutor extends TestBase {
    @Test
    public void jse() throws InterruptedException {
        driver.get("https://www.amazon.com");
        // scroll until last sign in button is display
        Thread.sleep(3000);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement lastSignIn = driver.findElement(By.xpath("(//span[text()='Sign in'])[2]"));

        // scroll
        jse.executeScript("arguments[0].scrollIntoView(true);",lastSignIn);

        // click
        jse.executeScript("arguments[0].click();",lastSignIn);

    }
}
