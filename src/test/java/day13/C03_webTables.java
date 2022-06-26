package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Scanner;

public class C03_webTables extends TestBase {
    @Test
    public void test1(){
        // use login method
        // print cell text

        int row = 4;
        int col = 5;
        login();

        WebElement cell = driver.findElement(By.xpath(
                "//tbody//tr["+row+"]//td["+col+"]"));
        System.out.println(cell.getText());
    }


    public void login(){
        driver.get("https://www.hotelmycamp.com");
        driver.findElement(By.linkText("Log in")).click();
        Actions actions= new Actions(driver);
        WebElement userName = driver.findElement(By.id("UserName"));
        actions.click(userName)
                .sendKeys("manager")
                .sendKeys(Keys.TAB)
                .sendKeys("Manager1!")
                .sendKeys(Keys.ENTER)
                .perform();
    }
}
