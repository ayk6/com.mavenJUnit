package day14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C02_readExcel {
    @Test
    public void t1() throws IOException {
        // assign file path
        String filePath= "src/resources/ulkeler.xlsx";
        // Create fis nd add filepath
        FileInputStream fis = new FileInputStream(filePath);
        // create workbook nd add fis
        Workbook workbook = WorkbookFactory.create(fis);
        String cll =workbook.getSheet("Sayfa1")
                .getRow(3)
                .getCell(3)
                .toString();

        Assert.assertEquals("Cezayir",cll);
        // passed

    }
}
