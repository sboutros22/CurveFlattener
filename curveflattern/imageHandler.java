package curveflattern;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
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

	// getting the image into the program
	// altered the return from null to an actual return for the image
	// This should read the file and get the image
	BufferedImage retrieveImage(String path) throws IOException {
		String imagePath = path;
		BufferedImage myPicture = ImageIO.read(new File(imagePath));
		return myPicture;
	}
	
	// Creates a new graph from existing one
	File newGraph(String path) throws IOException{
	int width = 10;
	int height = 10;
	BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

	Graphics2D ig2 = bi.createGraphics();
	int x1 = 0, x2 = 0, x3 = 0, y1 = 0,y2 = 0,y3 = 0;

	//Draw some lines to the graphic
	ig2.drawLine(x1,y1,x2,y2);
	ig2.drawLine(x2,y2,x3,y3);
	//...

	//Export the result to a file
	 ImageIO.write(bi, "PNG", new File("c:\\name.png"));
	 File newGraph = new File("c:\\name.png");
	 return newGraph;
	} 

	boolean isJpg(String path) {
		return true;
	}

	boolean isPng(String Graph) {
		return true;
	}

	/**
	 * If the image is a jpg, this method converts the points on a graph into a set
	 * of data points to be altered.
	 * 
	 * @param finalImage
	 * @return
	 */
	Point[] jpgToPoints(BufferedImage image) {
		Point [] points = new Point[3];
		  points[0] = new Point(1, 2); 
		  points[1] = new Point(2, 3); 
		  points[2] = new Point(3, 4); 
		return points;
	}
	
	Point[] jpgToPoint(BufferedImage retrievedImage) {
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
	Point[] pngToPoints(BufferedImage retrievedImage) {
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

	public boolean isPngFile(File newGraph) {
		// TODO Auto-generated method stub
		return true;
	}
}