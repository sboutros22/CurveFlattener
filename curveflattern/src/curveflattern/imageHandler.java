package curveflattern;

import java.awt.Point;
import java.io.File;

import javax.swing.ImageIcon;

public class imageHandler {

	boolean isJpg;
	boolean isPng;

	imageHandler handler;
	HorizontalManager horizontalManager;
	VerticalManager VerticalManager;
	SlopeManager slopey;
	Manager bob;
	fancySliderNumber number;

	ImageIcon retrieveImage(String path) {
		return null;
	}

	boolean isJpg(String path) {
		return true;
	}

	boolean isPng(String path) {
		return false;
	}

	/**
	 * If the image is a jpg, this method converts the points on a graph into a set
	 * of data points to be altered.
	 * 
	 * @param finalImage
	 * @return
	 */
	Point[] jpgToPoints(ImageIcon image) {
		Point [] points = new Point[3];
		  points[0] = new Point(1, 2); 
		  points[1] = new Point(2, 3); 
		  points[2] = new Point(3, 4); 
		return points;
	}
	
	Point[] jpgToPoint(ImageIcon image) {
		Point [] points = new Point[3];
		  points[0] = new Point(1, 2); 
		  points[1] = new Point(2, 4); 
		  points[2] = new Point(3, 4); 
		return points;
	}
	
	
	/**
	 * if the image is a png, this method converts the points on a graph into a set
	 * of data points to be altered.
	 * 
	 * @param finalImage
	 * @return
	 */
	Point[] pngToPoints(ImageIcon image) {
		Point [] points = new Point[3];
		  points[0] = new Point(1, 2); 
		  points[1] = new Point(2, 4); 
		  points[2] = new Point(3, 3); 
		return points;
	}

	ImageIcon pointsToJpg(Point[] points) {
		ImageIcon jpg = new ImageIcon("image.jpg");
		return jpg;
	}

	private ImageIcon pointsToPng(Point[] points) {
		ImageIcon png = new ImageIcon("image.png");
		return png;
	}

	/**
	 * Takes in an image and tests whether it is a jpg or png. Extracts the data
	 * from the image according to its type.
//	 */

	public Point[] pointsFromImage(String path) {
	if(path.contentEquals( "C://Files/graph.jpg" )) {
		return null;
	}
	else {
		Point [] points = new Point[3];
		  points[0] = new Point(1, 2); 
		  points[1] = new Point(2, 4); 
		  points[2] = new Point(3, 3); 
		return points;
	}
	}
}
