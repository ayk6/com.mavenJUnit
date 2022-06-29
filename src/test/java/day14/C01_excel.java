package day14;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.IOException;

public class C01_excel {
    @Test
    public void readExcel() throws IOException {
        // assign file path
        String filePath = "src/resources/ulkeler.xlsx";
        // create file input stream nd add file path
        FileInputStream fis = new FileInputStream(filePath);
        // create workbook nd add parameter
        Workbook workbook = WorkbookFactory.create(fis);
        // create worksheet nd add page index
        Sheet sheet = workbook.getSheet("Sayfa1");
        // create row
        Row row = sheet.getRow(3);
        // create cell
        Cell cell = row.getCell(3);

        System.out.println(cell);
        // is 3,3 cell Cezayir?

        String actualData = cell.toString();
        Assert.assertEquals("Cezayir",actualData);
        Assert.assertEquals("Cezayir",cell.getStringCellValue());
    }
}
