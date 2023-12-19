import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class TestCase_01_Test extends TestRunner {
    static int rowNumber;
    static int columnNumber;
    static String[][] testCases = new String[0][0];
    static String testCase_01 = "";
    @Test(priority = 1)
    public static void readFromExcel() throws IOException {
        HSSFWorkbook myExcelBook = new HSSFWorkbook(new FileInputStream("Second test.xlsx"));
        HSSFSheet myExcelSheet = myExcelBook.getSheetAt(0);

        rowNumber = myExcelSheet.getPhysicalNumberOfRows();
        columnNumber = myExcelSheet.getRow(0).getPhysicalNumberOfCells();
        System.out.println("Number of rows: " + rowNumber);
        System.out.println("Number of columns: " + columnNumber);

        testCases = new String[rowNumber-1][columnNumber];
        System.out.println("\nДвумерный массив:");

        for (int k = 1; k < rowNumber; k++) {
            HSSFRow row = myExcelSheet.getRow(k);
            for (int i = 0; i < columnNumber; i++) {
                String stringOfRow = row.getCell(i).getStringCellValue();
                    testCases[k-1][i] = stringOfRow;
            }
        }
        System.out.println(java.util.Arrays.deepToString(testCases));
        myExcelBook.close();
    }

    @Test(priority = 10)
    public void setConfigurationsAutomatically_TestCase_01() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        CsCart csCart = new CsCart();
        ColorScheme colorScheme = new ColorScheme();
        System.out.println("\nСписок наших тест-кейсов:");
        for(int i = 0; i < testCases.length; i++) {
            for(int k = 0; k < testCases[i].length; k++) {
                System.out.println(testCases[i][k]);
                colorScheme.getClass().getMethod(testCases[i][k]).invoke(colorScheme); //динамический вызов метода из класса по названию метода
            }
            csCart.button_Save.click(); //Здесь перечень шагов, которые нужно выполнить после настроек
            System.out.println();
        }
    }

/*    @Test(priority = 20)
    public void setConfigurationsManually_TestCase_01(){
        CsCart csCart = new CsCart();
        ColorScheme colorScheme = new ColorScheme();
        colorScheme.ColSch_RCFIE_Little();
        colorScheme.ColSch_DHICL_Off();
        colorScheme.ColSch_DTICL_Off();
        colorScheme.ColSch_FTPG_Without();
        colorScheme.ColSch_ABMFPI_Off();
        colorScheme.ColSch_UEA_Use();
        colorScheme.ColSch_EGIOH_On();
        colorScheme.ColSch_FWFPN_Bold();
        csCart.button_Save.click();
    }*/
}