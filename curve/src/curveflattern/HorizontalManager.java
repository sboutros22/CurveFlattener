package curveflattern;

public class HorizontalManager {

	public static boolean isStraightLine(int[] yCoordinates) {
		for (int i = 1; i < yCoordinates.length; i++) {
            if (yCoordinates[0] != yCoordinates[i]) {
                return false;
            }
        }
        return true;
    }

	/**
	 * Takes in a set of y coordinates and returns true if the line is horizontal,
	 * false if it is not.
	 * 
	 * @return
	 */
	public boolean isHorizontal(int[] yCoordinates) {
		if (isStraightLine(yCoordinates)) {
			return true;
		}
		else {
		return false;
	}
	}
}
