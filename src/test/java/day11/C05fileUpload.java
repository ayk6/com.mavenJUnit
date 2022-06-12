package day11;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.theories.Theories;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05fileUpload extends TestBase {
    @Test
    public void test1() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/upload");
        // click choose file
        WebElement chooseFile = driver.findElement(By.id("file-upload"));
        String filePath = System.getProperty("user.home")+"\\Downloads\\text.txt";

        // dosya seç butonuna path gönderilebilir
        chooseFile.sendKeys(filePath);
        Thread.sleep(3000);

        // click upload
        driver.findElement(By.id("file-submit")).click();
        // check
        Assert.assertTrue(driver.findElement(By.tagName("h3")).isDisplayed());

        // tesst passed
    }
}
