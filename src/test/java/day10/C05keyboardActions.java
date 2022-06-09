package day10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C05keyboardActions extends TestBase {
    @Test
    public void test1(){
        driver.get("https://www.amazon.com");
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));

        // arama kutusuna tıkla, Ship kelimesini harf harf yazdır ve enter

        searchBox.click();
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.SHIFT) // shift'e basıldı
                .sendKeys("s") // büyük harf yazdı
                .keyUp(Keys.SHIFT) // shift tuşu bırakıldı
                .sendKeys("h")
                .sendKeys("i")
                .sendKeys("p")
                .sendKeys(Keys.ENTER).perform();


    }
}
