package day14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C06_readExcel {
    @Test
    public void t1() throws IOException {
        FileInputStream fis = new FileInputStream("src/resources/ulkeler.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        int lastRow = workbook.getSheet("Sayfa1").getLastRowNum();

        // assign all excel datas in this class nd use from here anymore

        // create a map for assign excel data

        Map<String,String> excelMap = new HashMap<>();

        for (int i=0;i<= lastRow;i++){
            String key = C03_readExcel.returnCellData(i,0);
            String value = C03_readExcel.returnCellData(i,1)+
                    ", "+ C03_readExcel.returnCellData(i,2)+
                    ", "+ C03_readExcel.returnCellData(i,3);
            excelMap.put(key,value);
        }
        System.out.println(excelMap);

    }
}
