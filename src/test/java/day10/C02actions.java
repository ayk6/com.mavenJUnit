package day10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase ;

import javax.swing.*;

public class C02actions extends TestBase {

    @Test
    public void test1(){

        Actions actions = new Actions(driver);
        driver.get("https://www.amazon.com");
        // account menüsünü locate et
        WebElement account = driver.findElement(By.xpath("//*[text()='Account & Lists']"));
        // menüden create a list'e tıkla
        actions.moveToElement(account).perform();
        // elemente gitti ve üzerinde bekleyip menüyü açtı

        driver.findElement(By.xpath("//*[text()='Create a List']")).click();
    }
}
