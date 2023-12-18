import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadOnly {
    @Test
    public static void readFromExcel() throws IOException {
        HSSFWorkbook myExcelBook = new HSSFWorkbook(new FileInputStream("Second test.xlsx"));
        HSSFSheet myExcelSheet = myExcelBook.getSheetAt(0);

        for (int k = 1; k <= 11; k++) {
            HSSFRow row = myExcelSheet.getRow(k);
            for (int i = 0; i < 8; i++) {
                String stringOfRow = row.getCell(i).getStringCellValue();
                System.out.println(stringOfRow);
            }
        }
        System.out.println(" ");
        myExcelBook.close();
    }
}
