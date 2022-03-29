package curveflattern;

import java.awt.Point;

public class SlopeManager {

	/**
	 * Takes in an array of points and lowers the highest values by a factor that is
	 * given. takes in an array of points and gets the y coordinates to be lowered,
	 * then lowers them.
	 * 
	 * The number of points lowered is determined by taking the length of the array
	 * divided by 2.
	 * 
	 * @param yCoordinates
	 */
	public Point[] lowerSlope(Point[] Coordinates, double changeFactor) {
		Point [] points = new Point[5];
		  points[0] = new Point(1, 1); 
		  points[1] = new Point(2, 2); 
		  points[2] = new Point(3, 1); 
		  points[3] = new Point(4,3);
		  points[4] = new Point(5,6);
		return points;
	}

}
