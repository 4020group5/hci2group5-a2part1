package hci2.group5.a2part3.recognize;

import hci2.group5.a2part3.shape.Circle;

/**
 * This algorithm recognize a rectangle using bounding box and corners.
 */
public class RecognizingCircle extends RecognizingByBoundingBoxAndCorners {

	@Override
	public void touchUp(float x, float y) {
		
		super.touchUp(x, y);
		
		if (areCornersAllClosed()) {
			float centerX = (left + right) / 2f;
			float centerY = (top + bottom) / 2f;
			float radius = ((right - left) / 2f + (top - bottom) / 2f) / 2f;
			doneRecognizing(new Circle(centerX, centerY, radius));
		}
	}
}