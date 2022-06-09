package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;
import java.util.Set;

public class C03actions extends TestBase {

    @Test
    public void test1(){
        driver.get("https://the-internet.herokuapp.com/context_menu");
        String firstPage = driver.getWindowHandle();
        // çizgili alana sağ click yap
        Actions actions = new Actions(driver);
        WebElement area = driver.findElement(By.id("hot-spot"));
        actions.contextClick(area).perform();
        // uyarı yazısını test et
        String alert = driver.switchTo().alert().getText();
        Assert.assertEquals("You selected a context menu",alert);

        driver.switchTo().alert().accept(); // alerti onayla

        // elemental selenium'a tıkla
        driver.findElement(By.xpath("//a[@target='_blank']")).click();

        // yeni sekme açıldı, driver'ı yeni sekmeye taşı

        Set<String> handleSet= driver.getWindowHandles();
        String secPage = "";

        for (String each:handleSet
             ) {
            if (!each.equals(firstPage)){
                secPage = each;
            }
        }
        driver.switchTo().window(secPage);

        // elemental selenium yazısını kontrol et
        Assert.assertTrue(driver.findElement(By.tagName("h1")).isDisplayed());
    }
}
