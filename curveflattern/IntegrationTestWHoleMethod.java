package curveflattern;

import java.awt.Point;

import org.junit.jupiter.api.Test;

public class IntegrationTestWHoleMethod {

	imageHandler handler;
	HorizontalManager horizontalManager;
	VerticalManager VerticalManager;
	SlopeManager slopey;
	Manager bob;
	fancySliderNumber number;

	// This doesn't assert anything
	// So does this count as a test then
	@Test
	public void jpgToPointsLoweredToImage(String path) {
		Point[] points = handler.pointsFromImage(path);
	}
}
