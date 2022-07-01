package day15;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C01_writeExcel {
    @Test
    public void t1() throws IOException {
        String filePath = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fis);
        // go to 1st row
        workbook.getSheet("Sayfa1").getRow(0)
                .createCell(4) // create new cell on 5th col
                .setCellValue("Nüfus"); // write "Nüfus" in new cell
        // Workbook kopyaya yazdı, aslına eklememiz gerekiyor
        workbook.getSheet("Sayfa1").getRow(1)
                .createCell(4) // create new cell on 5th col
                .setCellValue(1234567); // write "1234567" in new cell
        workbook.getSheet("Sayfa1").getRow(11)
                .createCell(4).setCellValue(2468);
        workbook.getSheet("Sayfa1").getRow(16)
                .createCell(4).setCellValue(13579);
        // save inputs in excel
        FileOutputStream fos = new FileOutputStream(filePath);
        workbook.write(fos);
        // close file
        fis.close(); //or fos.close(); workbook.colse(); PASSED
    }
}
