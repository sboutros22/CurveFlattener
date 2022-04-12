package curveflattern;

import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Manager {

	int[] xCoordinates;
	int[] yCoordinates;
	//File file = new File("C:\\Users\\Simon\\Downloads\\money.xlsx");
	imageHandler image;

	public File loadFile(String path) {
		return new File(path);
	}

	/**
	 * Compares the length of the arrays of x and y coordinates to make sure they
	 * are the same.
	 * 
	 * @return
	 */
	public boolean compareLength(int[] xCoords, int[] yCoords) {
		if(xCoords.length == yCoords.length) {
			return true;
		}
		else {
		return false;
		}
	}

	public Point[] xlsxToPoints(File data) {
		 Point[] points = new Point[3];
		 points[0] = new Point(5, 9); 
		 points[1] = new Point(2, 7); 
		 points[2] = new Point(1, 4);
		return points; 

	    }

	public File pointsToXlsx(Point[] points) {
		File file = new File("C:\\Users\\Simon\\Downloads\\money.xlsx");
		return file;
	}

	/**
	 * Returns the y- values of a set of points
	 * 
	 * @param points
	 * @return
	 */
	public int[] getYPoints(Point[] points) {
		 int[] points1 = new int[3];
		 points1[0] = 1; 
		 points1[1] = 2;
		 points1[2] = 3;
		return points1; 
	}
	


}
