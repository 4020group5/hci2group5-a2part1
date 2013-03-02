package hci2.group5.a2part3.recognize;

import hci2.group5.a2part3.util.PointMaster;

import java.util.ArrayList;
import java.util.List;

/**
 * This class encapsulates shape recognizing algorithm using bounding box and open/close corners. 
 */
public class RecognizingByBoundingBoxAndCorners extends Recognizing {

	protected float left = Integer.MAX_VALUE, right = 0, top = 0, bottom = Integer.MAX_VALUE; // initial bound values
	
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
	}
	
	protected boolean areCornersAllClosed() {
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

	protected void updateBounds(float x, float y) {
		left = Math.min(left, x);
		right = Math.max(right, x);
		top = Math.max(top, y);
		bottom = Math.min(bottom, y);
	}
}
