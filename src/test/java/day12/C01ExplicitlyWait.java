package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01ExplicitlyWait extends TestBase {
    @Test
    public void test1(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        // click remove
        driver.findElement(By.xpath("//*[text()='Remove']")).click();
        // check message
        WebElement message = driver.findElement(By.id("message"));
        Assert.assertTrue(message.isDisplayed());
        // click Add
        driver.findElement(By.xpath("//*[text()='Add']")).click();
        // check its back message
        WebElement message2 = driver.findElement(By.id("message"));
        Assert.assertTrue(message2.isDisplayed());
        // test passed

    }
}
