<<<<<<< HEAD
package curveflattern;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

public class XlsxHandler {
    String fileLocation;
    FileInputStream file = new FileInputStream(new File(fileLocation));
    XSSFWorkbook workbook = new XSSFWorkbook(file);
    public ArrayList readXlsx(String path)
    {
        ArrayList data = new ArrayList<>();
        FileInputStream file = new FileInputStream(new File("howtodoinjava_demo.xlsx"));
 
            //Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);
 
            //Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);
 
            //Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) 
            {
                Row row = rowIterator.next();
                //For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();
                 
                while (cellIterator.hasNext()) 
                {
                    Cell cell = cellIterator.next();
                    //Check the cell type and format accordingly
                    switch (cell.getCellType()) 
                    {
                        case Cell.CELL_TYPE_NUMERIC:
                            data.add(cell.getNumericCellValue());
                            break;
                        case Cell.CELL_TYPE_STRING:
                            data.add(cell.getStringCellValue());
                            break;
                    }
                }
                System.out.println("");
            }
            file.close();
            return data;
        } 

@Test
	public void happyXlsxFound() throws FileNotFoundException {
		ArrayList ReadXlsData =  readXlsx("test.csv");
        ArrayList expectedData = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        assert(expectedData.equals(ReadXlsData));
	}
}
=======
package curveflattern;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc.Role;
import org.junit.jupiter.api.Test;

public class XlsxHandler {
    String fileLocation;
    FileInputStream file = new FileInputStream(new File(fileLocation));
    XSSFWorkbook workbook = new XSSFWorkbook(file);
    public void readXlsx()
    {
        XSSFSheet sheet = workbook.getSheetAt(0);
        Map<Integer, List<String>> data = new HashMap<>();
        int i = 0;
        for (Role row : sheet) {
        data.put(i, new ArrayList<String>());
        for (Cell cell : row) {
            data.put(i, new ArrayList<String>());
            }
        }
        i++;
    }

@Test
	public void happyXlsxFound() throws FileNotFoundException {
		ArrayList ReadXlsData =  readXlsx("C://Code/test.csv");
        ArrayList expectedData = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        boolean equal = expectedData.equals(ReadCsvData);
        assertTrue(equal);
	}
}
>>>>>>> 1de47fea9bb808fcd7ce01c95444f953378ed393
