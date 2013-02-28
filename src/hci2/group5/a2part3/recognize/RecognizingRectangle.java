package hci2.group5.a2part3.recognize;

import hci2.group5.a2part3.shape.Rectangle;
import hci2.group5.a2part3.util.PointMaster;

import java.util.ArrayList;
import java.util.List;

/**
 * This algorithm recognize a rectangle as long as a shape is closed. This algorithm checks
 * the shape's bound values to determine rectangle's size.
 *
 */
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
		
		closeOrAddCorner(x, y);
		updateBounds(x, y);
		
		if (areCornersAllClosed()) {
			doneRecognizing(new Rectangle(left, top, right, bottom));
		}
	}
	
	private boolean areCornersAllClosed() {
		return ! initialDraw && openCorners.isEmpty();
	}
	
	private void closeOrAddCorner(float x, float y) {
		PointMaster p = new PointMaster(x, y);
		for (PointMaster corner : openCorners) {
			if ( corner.isRoughlyTheSame(p)) {
				openCorners.remove(corner); // close corner
				return;
			}
		}
		
		// failed to close a coner, add another open corner
		openCorners.add(new PointMaster(x, y));
	}

	private void updateBounds(float x, float y) {
		left = Math.min(left, x);
		right = Math.max(right, x);
		top = Math.max(top, y);
		bottom = Math.min(bottom, y);
	}
}