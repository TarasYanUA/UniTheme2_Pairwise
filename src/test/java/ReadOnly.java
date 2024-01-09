import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadOnly {
    @Test
    public void readFromExcel() throws IOException {
        HSSFWorkbook myExcelBook = new HSSFWorkbook(new FileInputStream("TestCase01_CategoryPage_GridTest.xlsx"));
        HSSFSheet myExcelSheet = myExcelBook.getSheetAt(0);

        int rowNumber = myExcelSheet.getPhysicalNumberOfRows();
        int columnNumber = myExcelSheet.getRow(0).getPhysicalNumberOfCells();
        System.out.println("Number of rows: " + rowNumber);
        System.out.println("Number of columns: " + columnNumber);

        String[][] testCases = new String[rowNumber-1][columnNumber];

        for (int k = 1; k < rowNumber; k++) {
            HSSFRow row = myExcelSheet.getRow(k);
                for (int i = 0; i < columnNumber; i++) {
                    String stringOfRow = row.getCell(i).getStringCellValue();
                    testCases[k-1][i] = stringOfRow;
            }
        }
        System.out.println(java.util.Arrays.deepToString(testCases));
        //System.out.println(testCases[1][0]);
        myExcelBook.close();

        //Пробуем работать с массивом
        String testCase_01 = "colorScheme." + testCases[0][0] + "();";
        System.out.println(testCase_01);
    }
}