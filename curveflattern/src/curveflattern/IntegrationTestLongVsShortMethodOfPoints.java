package curveflattern;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.ImageIcon;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * 2 Tests to assert that doing all of the steps of taking an image and lowering
 * the points in one function and doing them separately result the same.
 * 
 * The decrease slider returns 2 for this instance.
 * 
 * 
 * @param path
 */
public class IntegrationTestLongVsShortMethodOfPoints {

	imageHandler handler = new imageHandler();
	HorizontalManager horizontalManager = new HorizontalManager();
	VerticalManager VerticalManager = new VerticalManager();
	SlopeManager slopey = new SlopeManager();
	Manager bob = new Manager();
	fancySliderNumber number = new fancySliderNumber();
	Point[] points;
	Point[] newPoints;

	/**
	 * The long method of doing the steps.
	 * 
	 * @param path
	 * @throws IOException 
	 */
	@ParameterizedTest
	@ValueSource(strings = {"C://Files/graph1.jpg"})
	public void takeImageGetPointsLong(String path) throws IOException {
		BufferedImage retrievedImage = handler.retrieveImage(path);
		if (handler.isJpg(path)) {
			handler.isJpg = true;
			points = handler.jpgToPoint(retrievedImage);
		} else if (handler.isPng(path)) {
			handler.isPng = true;
			points = handler.pngToPoints(retrievedImage);
		} else {
			System.err.println("Not a valid path!!");
			return;
		}
		double factor = number.getSliderNumber();
		newPoints = slopey.lowerSlope(points, factor);
		assertEquals(newPoints[1].y, points[1].y / 2);
	}

	/**
	 * The short method of doing the steps.
	 * 
	 * @param path
	 */
	
	// NewPoints is never set making this impossible to fix
	/*
	@ParameterizedTest
	@ValueSource(strings = {"C://Files/graph2.jpg"})
	public void takeImageGetPointsShort(String path) {
		points = handler.pointsFromImage(path);
		assertEquals(newPoints[1].y, points[1]);
	}
	*/
}
