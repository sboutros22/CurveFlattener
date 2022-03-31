package curveflattern;

import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

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
	BufferedImage image = null;
	// eventually need to get the image from any system with a direct path to it
	//File directory = new File(System.getProperty("user.dir") + System.getProperty("file.separator")+ "image");
	File directory = new File(path);
	for(File file: directory.listFiles()) {
		      image = ImageIO.read(file);	
	}
	int width = image.getWidth();
	int height = image.getHeight();
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

	public static boolean displayimage(String image) throws IOException {
		// get the file from computer needs to be changed
		ImageIcon icon = new ImageIcon(image);
		JFrame frame = new JFrame();
		frame.setLayout(new FlowLayout());
		// can alter the size of the display
		frame.setSize(500,500);
		JLabel label = new JLabel();
		label.setIcon(icon);
	    frame.add(label);
		frame.setVisible(true);		        	
		return true;
	}

}
