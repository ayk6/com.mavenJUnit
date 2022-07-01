package day15;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class C02_screenShot extends TestBase {
    @Test
    public void ssTest() throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        driver.get("https://www.amazon.com");
        // File ssPic = new File("target/screenshot/amazonPage.jpeg");
        // filePath is static. so new pic override old pic
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYMMddHHmmss");
        String dateTime = date.format(dtf);
        File ssPic = new File("target/screenshot/"+dateTime+".jpeg");

        File tempFile = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(tempFile,ssPic);
    }
}
