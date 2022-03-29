package curveflattern;

import java.io.File;
import java.io.FileInputStream;

public class XlsxHandler {
    FileInputStream file = new FileInputStream(new File(fileLocation));
    Workbook workbook = new XSSFWorkbook(file);
}
