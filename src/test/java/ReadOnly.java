import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Date;

public class ReadOnly {
    @Test
    public static void readFromExcel() throws IOException {
        HSSFWorkbook myExcelBook = new HSSFWorkbook(new FileInputStream("Second test.xlsx"));
        HSSFSheet myExcelSheet = myExcelBook.getSheet("Sheet1");
        //HSSFRow row = myExcelSheet.getRow(1);

        // Цикл по строкам
        for (int i = 1; i < 12; i++) {
            HSSFRow row = myExcelSheet.getRow(i);
            System.out.println(row);
        }
        System.out.println(" ");

        myExcelBook.close();


           /* // Перебрать каждый столбец в выбранной строке
            for (int j = 0; j < cols; j++) {
                // Значение ячейки Pring
                System.out.print(worksheet.getCells().get(i, j).getValue() + " | ");
            }
            // Распечатать разрыв строки*/







/*        if(row.getCell(0).getCellType() == CellType.STRING){
            String name = row.getCell(0).getStringCellValue();
            System.out.println("name : " + name);
        }

        if(row.getCell(1).getCellType() == CellType.NUMERIC){
            Date birthdate = row.getCell(1).getDateCellValue();
            System.out.println("birthdate :" + birthdate);
        }*/


    }
}
