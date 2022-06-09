package day11;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01faker extends TestBase {
    @Test
    public void test1 (){
        // pom.xml 'e faker repo'su eklendi
        // rastgele veri üretmek için kullanılır

        driver.get("https://hi5.com/");
        // locate name bar
        Actions actions = new Actions(driver);
        Faker faker = new Faker();
        actions.click(driver.findElement(By.id("display_name")))
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB) // tab ile sonraki bara geçti
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.country().capital())
                .sendKeys(Keys.TAB)
                .sendKeys("10").sendKeys(Keys.TAB)
                .sendKeys("o").sendKeys(Keys.TAB)
                .sendKeys("2000").sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_LEFT)
                .sendKeys(Keys.ENTER).perform();
    }
}
