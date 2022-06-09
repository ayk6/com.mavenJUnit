package day10;

import org.checkerframework.checker.units.qual.K;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C06keyboardActions extends TestBase {
    @Test
    public void test1(){
     driver.get("https://hi5.com/");
     // locate name bar
        Actions actions = new Actions(driver);
        actions.click(driver.findElement(By.id("display_name")))
                .sendKeys("fName")
                .sendKeys(Keys.TAB) // tab ile sonraki bara geçti
                .sendKeys("surName")
                .sendKeys(Keys.TAB)
                .sendKeys("passw")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).perform();

    }
}
