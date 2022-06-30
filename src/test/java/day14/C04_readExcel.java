package day14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C04_readExcel {
    @Test
    public void t1() throws IOException {
        // print ing capital col
        FileInputStream fis = new FileInputStream("src/resources/ulkeler.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        int countRow = workbook.getSheet("Sayfa1").getLastRowNum();

        for (int i = 0; i <= countRow; i++) {
            System.out.println(C03_readExcel.returnCellData(i, 1));
        }
    }
}
