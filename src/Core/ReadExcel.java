package Core;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

public class ReadExcel {
    @SuppressWarnings({ "unchecked", "unchecked" })
    public static List ReadExcel(String fileName) throws Exception {
        /** An excel file name. You can create a file name with a full path information. */
        String filename = "E:\\Programming\\CSC 202 Work\\Assignment3\\src\\restaurants.xls";

        /** Create an ArrayList to store the data read from excel sheet */
        List sheetData = new ArrayList();
        FileInputStream file = null;
        try {
            /** Create a FileInputStream that will be use to read the excel file */
            file = new FileInputStream(filename);

            /** Create an excel workbook from the file system */
            HSSFWorkbook workbook = new HSSFWorkbook(file);

            /** Get the first sheet on the workbook */
            HSSFSheet sheet = workbook.getSheetAt(0);

            /** When we have a sheet object in hand we can iterator on each sheet's rows and on each row's
             * cells. We store the data read on an ArrayList so that we can printed the content of the excel
             * to the console.*/
            Iterator rows = sheet.rowIterator();
            while (rows.hasNext()) {
                HSSFRow row = (HSSFRow) rows.next();
                Iterator cells = row.cellIterator();

                List data = new ArrayList();
                while (cells.hasNext()) {
                    HSSFCell cell = (HSSFCell) cells.next();
                    data.add(cell);
                }

                sheetData.add(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (file != null) {
                file.close();
            }
        }

        sheetData.remove(0); //remove header row
        return sheetData; // Which is a List
    }

    /** Iterates the data and print it out to the console */
    public static void showExcelData(List sheetData) {

        for (int i = 0; i < sheetData.size(); i++) {
            List list = (List) sheetData.get(i);
            for (int j = 0; j < list.size(); j++) {
                Cell cell = (Cell) list.get(j);
                if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                    System.out.print(cell.getNumericCellValue());
                } else if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                    System.out.print(cell.getRichStringCellValue());
                } else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
                    System.out.print(cell.getBooleanCellValue());
                }
                if (j < list.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("");
        }
    }
}
