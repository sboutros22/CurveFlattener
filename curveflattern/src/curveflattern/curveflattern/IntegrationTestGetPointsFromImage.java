package curveflattern;
// john was here
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Point;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class IntegrationTestGetPointsFromImage {

	imageHandler handler = new imageHandler();
	HorizontalManager horizontalManager = new HorizontalManager();
	VerticalManager VerticalManager = new VerticalManager();
	SlopeManager slopey = new SlopeManager();
	Manager bob = new Manager();
	fancySliderNumber number = new fancySliderNumber();

	/**
	 * Assumes that the points taken in are(in order) {(1,2), (2,4), (3,6), (4,8)}
	 * also assumes that the user inputs a 2 on the fancy slider as the factor to
	 * decrease the highest points.
	 * 
	 * tests if the second points y value is half of what it used to be after
	 * lowering the slope, demonstrating that the user now has a set of point that
	 * has a lower slope than before!
	 * 
	 * @param path
	 */
	@ParameterizedTest
	@ValueSource(strings = {"C://Files/graph1.jpg"})
	public void takeImageGetPoints(String path) {
		Point[] points = handler.pointsFromImage(path);
		int[] yCoordinates = bob.getYPoints(points);
		boolean isHorizontal = horizontalManager.isHorizontal(yCoordinates);
		assertEquals(isHorizontal, false);
		boolean isVertical = VerticalManager.isVertical(yCoordinates);
		assertEquals(isVertical, false);
		double lowerScale = number.getSliderNumber();
		assertEquals(points[1].y, 4);
		points = slopey.lowerSlope(points, lowerScale);
		assertEquals(points[1].y, 2);
	}

	@Test
	public void pointsToImage() {

	}

	public void pointsToGraph() {

	}
}
