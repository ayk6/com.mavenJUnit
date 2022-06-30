package day14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C05_readExcel {
    @Test
    public void t1() throws IOException {
        FileInputStream fis = new FileInputStream("src/resources/ulkeler.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        // return Sayfa2 rows and used rows
        int lastRow = workbook.getSheet("Sayfa2")
                .getLastRowNum();
        int usedRow = workbook.getSheet("Sayfa2")
                .getPhysicalNumberOfRows();

        System.out.println("Rows : " + lastRow+ //28
                "\nUsed rows : " + usedRow); //16
    }
}
