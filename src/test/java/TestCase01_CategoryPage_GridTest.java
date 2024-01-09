import com.codeborne.selenide.Selenide;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class TestCase01_CategoryPage_GridTest extends TestRunner {
    static int rowNumber;
    static int columnNumber;
    static String[][] testCases = new String[0][0];

    @Test(priority = 1)
    public void preconditions(){
        CsCart csCart = new CsCart();
        csCart.navigateToSection_DesignLayouts();
        csCart.navigateTo_ColorSchemeSettings();
    }

    @Test(priority = 2)
    public void readFromExcel() throws IOException {
        String className = this.getClass().getSimpleName();
        HSSFWorkbook myExcelBook = new HSSFWorkbook(new FileInputStream(className + ".xlsx"));
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
    public void check_TestCase01_CategoryPage_Grid() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        CsCart csCart = new CsCart();
        ColorScheme colorScheme = new ColorScheme();
        for(int i = 0; i < testCases.length; i++) {
            System.out.println("\n  Тест-кейс №" + (i));
            for(int k = 0; k < testCases[i].length; k++) {
                System.out.println(testCases[i][k]);
                colorScheme.getClass().getMethod(testCases[i][k]).invoke(colorScheme); //динамический вызов метода из класса по названию метода
            }
            csCart.button_Save.click();

            //Здесь перечень шагов, которые нужно выполнить после настроек
            csCart.storefrontMainPage.click();
            shiftBrowserTab(1 + i);
            Storefront storefront = new Storefront();
            if(storefront.cookie.exists()) {storefront.cookie.click();  }
            storefront.blockWithProducts.scrollIntoView("{behavior: \"instant\", block: \"center\", inline: \"center\"}");
            Selenide.screenshot("Test-case 01." + i + " Block with products");
            storefront.navigateToHorizontalMenu_Phones();
            Selenide.screenshot("Test-case 01." + i + " Category page 'Grid'");
            storefront.navigateToProductListView_ListWithoutOptions();
            Selenide.screenshot("Test-case 01." + i + " Category page 'ListWithoutOptions'");
            storefront.navigateToProductListView_CompactList();
            Selenide.screenshot("Test-case 01." + i + " Category page 'CompactList'");
            storefront.selectLanguage_RTL();
            Selenide.screenshot("Test-case 01." + i + " Category page 'CompactList' (RTL)");
            storefront.navigateToProductListView_ListWithoutOptions();
            Selenide.screenshot("Test-case 01." + i + " Category page 'ListWithoutOptions' (RTL)");
            storefront.navigateToProductListView_Grid();
            Selenide.screenshot("Test-case 01." + i + " Category page 'Grid' (RTL)");

            shiftBrowserTab(0);
        }
    }
}