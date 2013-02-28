package hci2.group5.a2part3.recognize;

import hci2.group5.a2part3.shape.Rectangle;

/**
 * This algorithm recognize a rectangle using bounding box and corners.
 */
public class RecognizingRectangle extends RecognizingByBoundingBoxAndCorners {

	@Override
	public void touchUp(float x, float y) {
		
		super.touchUp(x, y);
		
		if (areCornersAllClosed()) {
			doneRecognizing(new Rectangle(left, top, right, bottom));
		}
	}
	
}