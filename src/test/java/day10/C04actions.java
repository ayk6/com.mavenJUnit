package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;

public class C04actions extends TestBase {
    @Test
    public void test1(){
        driver.get("https://demoqa.com/droppable");
        // move drag me to drop me
        Actions actions = new Actions(driver);
        WebElement object = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement target = driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));

        actions.dragAndDrop(object,target).perform();

        // is Dropped! is displayed?

        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Dropped!']")).isDisplayed());
    }
}
