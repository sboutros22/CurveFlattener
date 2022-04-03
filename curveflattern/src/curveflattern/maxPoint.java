package curveflattern;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class maxPoint{
	public int maxPoint(int[] mynumbers){
		int mylargest = mynumbers[0];

		for (int i = 0; i < mynumbers.length; i++)
        {
            if (mynumbers[i] > mylargest) {
            	mylargest = mynumbers[i];
            }
        }
		return mylargest;
	}

	@Test								
	public void maxPoints() {
	
		int[] myarray = { 3, 5, 1, 7, 3, 8 };   
	    int expected = 8;                             
	    int actual = maxPoint(myarray); 
	 
		assertEquals(expected, actual); 
		

			}

	}
