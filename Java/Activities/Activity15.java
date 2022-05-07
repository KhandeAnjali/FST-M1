package activities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Activity15 {
    public static String FILENAME = "src/main/resources/TestSheet1.xslx";

    public static void main(String[] args) throws FileNotFoundException {
        XSSFWorkbook workbook1 = new XSSFWorkbook();
        XSSFSheet sheet1 = workbook1.createSheet("Person Details");
        Object details[][] = {
                {"Name", "Hobby", "Hours spend on hobby"},
                {"Anjali", "Playing instrument", 1},
                {"Manasa","Painting", 2}
        };
        int rowNum = 0;
        for(Object[] rowItem : details){
            Row row = sheet1.createRow(rowNum++);
            int colNum = 0;
            for(Object colItem : rowItem ){
                Cell cell = row.createCell(colNum++);
                if(colItem instanceof String){
                    cell.setCellValue((String) colItem);
                }else if(colItem instanceof Integer){
                    cell.setCellValue((Integer) colItem);
                }
            }
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(FILENAME);
            workbook1.write(fileOutputStream);
            workbook1.close();
        }catch (IOException ioException){
            ioException.printStackTrace();
        }
        System.out.println("Successful creation of Workbook");
    }
}
