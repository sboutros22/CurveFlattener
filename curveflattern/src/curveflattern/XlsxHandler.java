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
