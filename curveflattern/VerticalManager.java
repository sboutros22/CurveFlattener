package curveflattern;

public class VerticalManager {

	public static boolean isStraightLine(int[] xCoordinates) {
		for (int i = 1; i < xCoordinates.length; i++) {
		    if (xCoordinates[0] != xCoordinates[i]) {
		        return false;
		    }
		}
		return true;
		}
	/**
	 * Takes a set of x coordinates and determines whether or not they are a
	 * vertical line
	 * 
	 * @param xCoordinates
	 * @return
	 */
	public boolean isVertical(int[] xCoordinates) {
		if (isStraightLine(xCoordinates)) {
			return true;
		}
		else {
		return false;
	}
	}
}