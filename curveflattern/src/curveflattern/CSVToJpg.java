import org.junit.jupiter.api.Test;

class CSVToJpg {

public String ReadCSV(String path)
{


Scanner sc = new Scanner(new File(path));  
sc.useDelimiter(",");   //sets the delimiter pattern  
String CSV;
while (sc.hasNext())  //returns a boolean value  
{  
    CSV += sc.next());  //find and returns the next complete token from this scanner  
}   
sc.close();  //closes the scanner  
}  
return CSV;
}
}

@Test
	public void happyCSVFound() {
		String ReadCsv =  ReadCSV("C://test.csv")
        String expectedString = "1, 2, 3, 4, 5"
        assertEquals(ReadCsv, expectedString);
	}


