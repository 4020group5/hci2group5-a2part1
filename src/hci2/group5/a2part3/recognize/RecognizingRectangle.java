package hci2.group5.a2part3.recognize;

import hci2.group5.a2part3.shape.Rectangle;

/**
 * This algorithm recognize a rectangle using bounding box and corners.
 */
<<<<<<< HEAD
public class RecognizingRectangle extends RecognizingByBoundingBoxAndCorners {

	@Override
	public void touchUp(float x, float y) {
=======
public class RecognizingRectangle extends Recognizing {
	
	private float left = Integer.MAX_VALUE, right = 0, top = 0, bottom = Integer.MAX_VALUE; // initial bound values
	
	private List<PointMaster> openCorners = new ArrayList<PointMaster>();
	
	private boolean initialDraw = true;
	
	@Override
	public void touchDown(float x, float y) {
		if (initialDraw ) {
			// add first corner
			openCorners.add(new PointMaster(x, y));
			return;
		}
		
		closeOrAddCorner(x, y);
		updateBounds(x, y);
	}

	@Override
	public void touchMove(float x, float y) {
		updateBounds(x, y);
	}

	@Override
	public void touchUp(float x, float y) {
		if (initialDraw ) {
			// not initial draw anymore, make "touchDown" work normally
			initialDraw = false;
		}
>>>>>>> minor changes
		
		super.touchUp(x, y);
		
		if (areCornersAllClosed()) {
			doneRecognizing(new Rectangle(left, top, right, bottom));
		}
<<<<<<< HEAD
=======

	}
	
	private boolean areCornersAllClosed() {
		return ! initialDraw && openCorners.isEmpty();
		
>>>>>>> minor changes
	}
	
}