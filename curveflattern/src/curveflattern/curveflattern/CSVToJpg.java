package curveflattern;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import org.junit.jupiter.api.Test;

class CSVToJpg {

public ArrayList ReadCSV(String path) throws FileNotFoundException
{

    Scanner sc = new Scanner(new File(path));  
    sc.useDelimiter(",");   //sets the delimiter pattern  
    ArrayList data = new ArrayList<>();
    while (sc.hasNext())  //returns a boolean value  
    {  
       data.add(sc.next());  //find and returns the next complete token from this scanner  
    }   
    sc.close();  //closes the scanner  
    return data;

}

@Test
	public void happyCSVFound() throws FileNotFoundException {
		ArrayList ReadCsvData =  ReadCSV("C://Code/test.csv");
        ArrayList expectedData = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        boolean equal = expectedData.equals(ReadCsvData);
        assertTrue(equal);
	}
}