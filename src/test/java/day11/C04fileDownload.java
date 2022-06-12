package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04fileDownload extends TestBase{
    @Test
    public void test1(){
        driver.get("https://the-internet.herokuapp.com/download");
        // download text.txt
        driver.findElement(By.xpath("//a[@href='download/text.txt']")).click();

        // check file in downloads

        String filePath= System.getProperty("user.home")+"\\Downloads\\text.txt";
        Assert.assertTrue(Files.exists(Paths.get(filePath)));
        // test passed
    }
}
