package day14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C03_readExcel {
    @Test
    public void t1() throws IOException {
        // create method and return input cell data
        int row = 4;
        int col = 4;
        String expData = "Cezayir";

        String actData = returnCellData(row-1,col-1); // index olduğu için -1

        Assert.assertEquals(expData,actData); // passed
    }

    public static String returnCellData(int rowIndex, int colIndex) throws IOException {
        String cellData="";
        FileInputStream fis =new FileInputStream("src/resources/ulkeler.xlsx");
        Workbook workBook = WorkbookFactory.create(fis);
        cellData= workBook
                .getSheet("Sayfa1")
                .getRow(rowIndex)
                .getCell(colIndex)
                .toString();

        return cellData;
    }
}
