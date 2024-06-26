import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.Objects;

public class WorkWithExcel {
    @Test(priority = 1)
    public static void writeIntoExcel() throws IOException {
        Workbook book = new HSSFWorkbook();
        Sheet sheet = book.createSheet("Birthdays");

        // Нумерация начинается с нуля
        Row row = sheet.createRow(0);

        // Мы запишем имя и дату в два столбца
        // имя будет String, а дата рождения --- Date,
        // формата dd.mm.yyyy
        Cell name = row.createCell(0);
        name.setCellValue("John");

        Cell birthdate = row.createCell(1);

        DataFormat format = book.createDataFormat();
        CellStyle dateStyle = book.createCellStyle();
        dateStyle.setDataFormat(format.getFormat("dd.mm.yyyy"));
        birthdate.setCellStyle(dateStyle);


        // Нумерация лет начинается с 1900-го
        birthdate.setCellValue(new Date(110, 10, 10));

        // Меняем размер столбца
        sheet.autoSizeColumn(1);

        // Записываем всё в файл
        book.write(new FileOutputStream("First test.xlsx"));
        book.close();
    }

    @Test(priority = 2)
    public static void readFromExcel() throws IOException {
        HSSFWorkbook myExcelBook = new HSSFWorkbook(new FileInputStream("First test.xlsx"));
        HSSFSheet myExcelSheet = myExcelBook.getSheet("Birthdays");
        HSSFRow row = myExcelSheet.getRow(0);

        if(row.getCell(0).getCellType() == CellType.STRING){
            String name = row.getCell(0).getStringCellValue();
            System.out.println("name : " + name);
        }

        if(row.getCell(1).getCellType() == CellType.NUMERIC){
            Date birthdate = row.getCell(1).getDateCellValue();
            System.out.println("birthdate :" + birthdate);
        }

        myExcelBook.close();
    }

    @Test(priority = 3)
        public void readExcel_Iterator() throws IOException{
        HSSFWorkbook myExcelBook = new HSSFWorkbook(new FileInputStream("03 TestCase01_CategoryPage_GridTest.xlsx"));
        HSSFSheet myExcelSheet = myExcelBook.getSheetAt(0);
        int rowNumbers = myExcelSheet.getPhysicalNumberOfRows();

                Iterator<Row> rowIterator = myExcelSheet.rowIterator();
                HSSFRow row = null;
                while (rowIterator.hasNext()) {
                    row = (HSSFRow) rowIterator.next();
                }

                Iterator<Cell> cellIterator = Objects.requireNonNull(row).cellIterator();
                while (cellIterator.hasNext()) {
                    HSSFCell cell = (HSSFCell) cellIterator.next();
                    System.out.println(cell);
            }
            System.out.println(" ");

        System.out.println(" ");
        myExcelBook.close();
    }
}