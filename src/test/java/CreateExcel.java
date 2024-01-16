import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.testng.annotations.Test;
import java.io.FileOutputStream;
import java.io.IOException;

public class CreateExcel {
    @Test
    public void createExcel() throws IOException {
        Workbook book = new HSSFWorkbook();
        Sheet sheet = book.createSheet("Sheet1");   //Создаём лист экселя
        Row row = sheet.createRow(0);   //Создаём рядок в экселе

        //Создаём ячейки в экселе и сразу задаём значение в ячейке
        row.createCell(0).setCellValue("Значение 1");
        row.createCell(1).setCellValue("Значение 2");
        row.createCell(2).setCellValue("Значение 3");

        book.write(new FileOutputStream("Second test.xlsx"));   // Записываем всё в файл/ Когда всё будет готово, то название файла должно быть переменной className
        book.close();
    }
}
