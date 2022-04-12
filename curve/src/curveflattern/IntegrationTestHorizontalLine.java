package curveflattern;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Point;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class IntegrationTestHorizontalLine {
	
	imageHandler handler = new imageHandler();
	HorizontalManager horizontalManager = new HorizontalManager();
	VerticalManager VerticalManager = new VerticalManager();
	SlopeManager slopey = new SlopeManager();
	Manager bob = new Manager();
	fancySliderNumber number = new fancySliderNumber();
	
	/**
	 * * Assumes that the points taken in are(in order) {(1,2), (2,2), (3,2), (4,2)}
	 * 
	 * Tests that the given points are a horizontal line and then stops all action and prints an error./
	 * @param path
	 */
	@ParameterizedTest
	@ValueSource(strings = {"C://Files/graph.jpg"})

	public void happyPathHorizontalLine(String path) {
		Point[] points = handler.pointsFromImage(path);
		int[] yCoordinates = bob.getYPoints(points);
		if (horizontalManager.isHorizontal(yCoordinates)) {
			System.err.println("Horizontal line: action stopped");
			points = null;
			return;
		}
		if (VerticalManager.isVertical(yCoordinates)) {
			System.err.println("Vertical line: action stopped");
			points = null;
			return;
		}
		assertEquals(points, null);
		
	}
}
