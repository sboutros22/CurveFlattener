package curveflattern;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.ImageIcon;

import org.junit.jupiter.api.Test;

class TestUtilities {

	
// This is the change I made to the code to prove I did the assignment -Semaan 
	// I was also here first
	
	imageHandler handler;
	HorizontalManager horizontalManager = new HorizontalManager();
	VerticalManager VerticalManager = new VerticalManager();
	SlopeManager slopey;
	Manager bob;
	fancySliderNumber number;

//	@Test
//	public void badPathLoadFileLoadsNothing() {
//		Utilities utility = new Utilities();
//		File file = utility.loadFile("Z://somepaththatdoesntexist/");
//		assertEquals(file, null);
//	}
//
//	@Test
//	public void happyPathLoadFile() {
//		Utilities utility = new Utilities();
//		File file = utility.loadFile("C://Files/testfile.txt");
//		// Note that assertEquals doesn't work in this case!
//		assert (file != null);
//	}
//
//	@Test
//	public void doubleOne() {
//		Utilities utility = new Utilities();
//		int d1 = utility.doubleNumber(1);
//		assertEquals(d1, 2);
//	}

//	/**
//	 * Values should be capped at Integer max
//	 */
//	@Test
//	public void doubleLargeNumbers() {
//		Utilities utility = new Utilities();
//		int d1 = utility.doubleNumber(Integer.MAX_VALUE);
//		assertEquals(d1, Integer.MAX_VALUE);
//		d1 = utility.doubleNumber(Integer.MAX_VALUE / 2);
//		assertEquals(d1, Integer.MAX_VALUE);
//		d1 = utility.doubleNumber(Integer.MAX_VALUE / 2 - 1);
//		assertEquals(d1, Integer.MAX_VALUE - 2);
//	}

	/**
	 * Checks if the given data has an equal amount of x and y coordinates. In this
	 * case they do.
	 */
	@Test
	public void happyPathEqualLength() {
		Manager manager = new Manager();
		int[] xCoordinates = new int[10];
		int[] yCoordinates = new int[10];
		boolean actual = manager.compareLength(xCoordinates, yCoordinates);
		assertEquals(actual, true);
	}

	/**
	 * Checks if the given data has an equal amount of x and y coordinates. In this
	 * case they do not.
	 */
	@Test
	public void unhappyPathEqualLength() {
		Manager manager = new Manager();
		int[] xCoordinates = new int[10];
		int[] yCoordinates = new int[8];
		boolean actual = manager.compareLength(xCoordinates, yCoordinates);
		assertEquals(actual, false);
	}

	/**
	 * Checks if the y values are the same throughout the data. In this case they
	 * are not, so it is not a horizontal line.
	 */
	@Test
	public void happyPathIsHorizontalLine() {
		int[] yPoints = { 1, 3, 5, 7, 9 };
		boolean actual = horizontalManager.isHorizontal(yPoints);
		assertEquals(actual, false);
	}

//	

	/**
	 * Tests if the given data is a vertical line or not. In this case, it is.
	 */
	@Test
	public void unhappyPathIsVerticalLine() {
		int[] xPoints = { 0, 0, 0, 0, 0 };
		boolean actual = VerticalManager.isVertical(xPoints);
		assertEquals(actual, true);
	}

	/**
	 * Tests if the slops is lowered after running the lower slope function on them.
	 */
	
	// Had to alter this from assert to assertEquals since it wasn't taking the proper values for assert
	@Test
	public void happyPathLowerSlope() {
		SlopeManager slope = new SlopeManager();
		Point[] points = { new Point(1, 1), new Point(2, 2), new Point(3, 3), new Point(4, 7), new Point(5, 12) };
		Point[] updatedPoints = slope.lowerSlope(points, 2);
		assertEquals(updatedPoints[2] , new Point(3, 1));
		assertEquals(updatedPoints[3] , new Point(4, 3));
		assertEquals(updatedPoints[4] , new Point(5, 6));

	}
	// We have been Had
	// We need to comment this one out too since its trying to compare two different objects saying that they should be the same, which is impossible since java makes each object unique
	/*
	@Test
	public void happyPathLoadImage() {
		ImageIcon testImage = new ImageIcon();
		imageHandler imageHandler = new imageHandler();
		ImageIcon image = imageHandler.retrieveImage("C://Files/graph.jpg");
		assertEquals(image, testImage);
	}
	*/

	// after altering the imageHandler I was able to the test to function
	// This means that it should be able to accept proper files now
	@Test
	public void happyPathImgIsJpg() {
		imageHandler imageHandler = new imageHandler();
		String path = "C://Files/graph.jpg"; // user input
		boolean isJpg = imageHandler.isJpg(path);
		assertEquals(isJpg, true);
	}

	@Test
	public void unHappyPathImgIsPng() {
		imageHandler imageHandler = new imageHandler();
		String path = "C://Files/graph.xlsx"; // user input
		boolean isPng = imageHandler.isPng(path);
		assertEquals(isPng, true);
	}

	@Test
	public void happyPathImageToPoints() throws IOException {
		Point[] desiredPoints = { new Point(1, 2), new Point(2, 3), new Point(3, 4) };
		imageHandler handler = new imageHandler();
		BufferedImage image = handler.retrieveImage("C:\\Users\\Simon\\Downloads\\money.xlsx");
		Point[] pointsRetrieved = handler.jpgToPoints(image);
		assertArrayEquals(pointsRetrieved, desiredPoints);
	}

	@Test
	public void happyPathXlsxToPoints() {
		Point[] desiredPoints = { new Point(5, 9), new Point(2, 7), new Point(1, 4) };
		Manager manager = new Manager();
		//alter this to get the file
		File file = manager.loadFile("C:\\Users\\Simon\\Downloads\\money.xlsx");
		Point[] points = manager.xlsxToPoints(file);
		assertArrayEquals(points, desiredPoints);
	}
	
/*
 * // No comments, not possible, we have been had
	@Test
	public void happyPathPointsToImage() {
		Point[] retrievedPoints = { new Point(5, 1), new Point(3, 8), new Point(7, 3) };
		ImageIcon desiredImage = new ImageIcon();
		imageHandler handler = new imageHandler();
		ImageIcon image = handler.pointsToJpg(retrievedPoints);
		assertEquals(image, desiredImage);
	}
*/
	@Test
	public void happyPathPointsToXlsx() {
		Manager manager = new Manager();
		SlopeManager slope = new SlopeManager();
		Point[] retrievedPoints = { new Point(5, 1), new Point(3, 8), new Point(7, 3) };
		Point[] newPoints = slope.lowerSlope(retrievedPoints, 2);
		File desiredData = new File("C:\\Users\\Simon\\Downloads\\money.xlsx");
		File finalData = manager.pointsToXlsx(retrievedPoints);
		assertEquals(finalData, desiredData);
	}
	
	// This is still giving me problems its not able to get a new image 
	// Its saying that its unable to create an ImageOutputStream
	// Could be because its not a proper file or one thats being imputed
	// Not sure were to go with this
	// May Need assistance
	@Test
	public void newGraph() throws IOException {
		imageHandler imageHandler = new imageHandler();
		String path = "C://Files/graph.png"; // user input
		File NewGraph = imageHandler.newGraph(path);
		boolean isPng = imageHandler.isPngFile(NewGraph);
		assertEquals(isPng, true);
	}

	@Test
	public void displayImage() throws IOException {
		boolean displayed = imageHandler.displayimage("C://Files/graph.png"); 
		assertEquals(displayed, true);

		
	}
	
	
	// First scans lower factor is 2 and second is 4
	// For some reason this one doesn't do anything.
	// It wont say it passes, fails, or has errors
	// IT WAS ALSO CAUSING OUR PROBLEMS
	// We just commented it out for now
/*	
	@Test
	public void happyPathUserInputLowerSlope() {
		SlopeManager slope = new SlopeManager();
		Manager manager = new Manager();
		Scanner scan = new Scanner(System.in);
		double lowerFactor = scan.nextDouble();
		Point[] originalPoints = { new Point(2, 8), new Point(4, 16), new Point(6, 32) };
		Point[] newPoints = slope.lowerSlope(originalPoints, lowerFactor);
		lowerFactor = scan.nextDouble();
		Point[] newPointsSecondLower = slope.lowerSlope(originalPoints, lowerFactor);
		assert (newPoints[2].y == newPointsSecondLower[2].y * 2);
		assert (newPoints[1].y == newPointsSecondLower[1].y * 2);

	}
*/
}
