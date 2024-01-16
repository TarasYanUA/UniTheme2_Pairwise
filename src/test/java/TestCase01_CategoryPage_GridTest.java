import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import static com.codeborne.selenide.Selenide.*;

public class TestCase01_CategoryPage_GridTest extends TestRunner {
    static int rowNumber;
    static int columnNumber;
    static String[][] testCases = new String[0][0];
    String className = this.getClass().getSimpleName();

    @Test(priority = 1)
    public void preconditions() {
        CsCart csCart = new CsCart();
        csCart.navigateToSection_DesignLayouts();   //Устанавливаем макет Light v2
        ThemeSettings_ProductLists themeSettings_productLists = new ThemeSettings_ProductLists();
        themeSettings_productLists.ThemeProductLists_SSOCP_Off();   //Выкл. отображение подкатегорий на странице категории
        themeSettings_productLists.ThemeProductLists_DCD_Dont();    //Выкл. отображение описания категории на странице категории
        //Настраиваем характеристику Бренд для отображения на странице категории
        csCart.menu_Products.hover();
        csCart.section_Features.click();
        csCart.featureBrand.click();
        if (!csCart.setting_showInProductList.isSelected()) {
            csCart.setting_showInProductList.click();
        }
        //Настраиваем товар без наличия
        csCart.searchProductByCode("O0071FR7HZ");
        csCart.setOutOfStock();
        csCart.button_Save.click();
        //Настраиваем товар без наличия и с действием “Предзаказ”
        csCart.searchProductByCode("Y0070SQYFT");
        csCart.setOutOfStock();
        csCart.action_outOfStock.selectOptionByValue("B");
        csCart.button_Save.click();
        //Настраиваем товар без цены
        csCart.searchProductByCode("U00684Y11J");
        csCart.setZeroPrice();
        csCart.button_Save.click();
        //Настраиваем товар без цены и с действием “Попросить покупателя ввести цену"
        csCart.searchProductByCode("U0069R50SC");
        csCart.setZeroPrice();
        csCart.action_ZeroPrice.selectOptionByValue("A");
        csCart.button_Save.click();
        //Настраиваем товар со скидкой
        csCart.searchProductByCode("J00670N9NC");
        csCart.setRecommendedPrice("19000");
        csCart.button_Save.click();
    }

    @Test(priority = 2, dependsOnMethods = "preconditions")
    public void readFromExcel() throws IOException {
        HSSFWorkbook myExcelBook = new HSSFWorkbook(new FileInputStream(className + ".xlsx"));
        HSSFSheet myExcelSheet = myExcelBook.getSheetAt(0);

        rowNumber = myExcelSheet.getPhysicalNumberOfRows();
        columnNumber = myExcelSheet.getRow(0).getPhysicalNumberOfCells();
        System.out.println("Number of rows: " + rowNumber);
        System.out.println("Number of columns: " + columnNumber);

        testCases = new String[rowNumber - 1][columnNumber];
        System.out.println("\nДвумерный массив:");

        for (int k = 1; k < rowNumber; k++) {
            HSSFRow row = myExcelSheet.getRow(k);
            for (int i = 0; i < columnNumber; i++) {
                String stringOfRow = row.getCell(i).getStringCellValue();
                testCases[k - 1][i] = stringOfRow;
            }
        }
        System.out.println(java.util.Arrays.deepToString(testCases));
        myExcelBook.close();
    }

    @Test(priority = 3, dependsOnMethods = "preconditions")
    public void check_TestCase01_CategoryPage_Grid() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        CsCart csCart = new CsCart();
        ColorScheme colorScheme = new ColorScheme();
        ThemeSettings_ProductLists themeSettings_productLists = new ThemeSettings_ProductLists();
        for (int i = 0; i < testCases.length; i++) {
            System.out.println("\n  Тест-кейс №" + (1 + i));
            for (int k = 0; k < testCases[i].length; k++) {
                System.out.println(testCases[i][k]);

                if (testCases[i][k].startsWith("ColSch_")) {
                    colorScheme.getClass().getMethod(testCases[i][k]).invoke(colorScheme); //динамический вызов метода из класса по названию метода
                }
                if (testCases[i][k].startsWith("ThemeProductLists_")) {
                    themeSettings_productLists.getClass().getMethod(testCases[i][k]).invoke(themeSettings_productLists); //динамический вызов метода из класса по названию метода
                }
            }
            csCart.button_Save.click();

            //Здесь перечень шагов, которые нужно выполнить после настроек
            csCart.storefrontMainPage.click();
            shiftBrowserTab(1);
            String linkAddress = WebDriverRunner.getWebDriver().getCurrentUrl();
            String linkToHTCCategory = linkAddress + "elektronika/telefony/htc-ru/";
            Storefront storefront = new Storefront();
            if (storefront.cookie.exists()) {
                storefront.cookie.click();
            }
            storefront.blockWithProducts.scrollIntoView("{behavior: \"instant\", block: \"center\", inline: \"center\"}");
            Selenide.screenshot("Test-case 01." + i + " Block with products");
            Selenide.open(linkToHTCCategory);
            //storefront.navigateToHorizontalMenu_HTC();
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

            switchTo().window(1).close();
            switchTo().window(0);
        }
    }
}