package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class C02_webTables extends TestBase {
    @Test
    public void test1(){
        // create login method
        login();
        // create table method
        table();
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
    public void table(){
        // count columns
        List <WebElement> cols = driver.findElements(By.xpath("//thead//tr[1]//th"));
        System.out.println("cols : "+cols.size());
        // print table bodies // get text ile bod yazdırılabilir
        System.out.println(driver.findElement(By.xpath("" +
                "//tbody")).getText());
        // count rows
        List <WebElement> rows = driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("rows : "+rows.size());
        // print rows
        for (WebElement each: rows
             ) {
            System.out.println(each.getText());
        }
        // print all datas
        List <WebElement> dataList = driver.findElements(By.xpath("//tbody//td"));
        for (WebElement each:dataList
             ) {
            System.out.println(each.getText());
        }
        // print e-mail cols elements
        List <WebElement> eMailElements = driver.findElements(By.xpath("//tbody//td[3]"));
        for (WebElement each: eMailElements
             ) {
            System.out.println(each.getText());
        }

    }
}
