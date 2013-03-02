package hci2.group5.a2part3.recognize;

import hci2.group5.a2part3.shape.Triangle;
import hci2.group5.a2part3.util.PointMaster;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class RecognizingTriangle extends RecognizingByBoundingBoxAndCorners {
	
	private float leftY, rightY;
	private float topX, bottomX;

	@Override
	public void touchUp(float x, float y) {
		
		super.touchUp(x, y);
		
		if (areCornersAllClosed()) {
			List<PointMaster> trianglePoints = getTrianglePoints();
			
			if (trianglePoints.size() < 3) {
				return;
			}
			
			doneRecognizing(new Triangle(trianglePoints.get(0), trianglePoints.get(1), trianglePoints.get(2)));
		}
	}
	
	private List<PointMaster> getTrianglePoints() {
		List<PointMaster> trianglePoints = new ArrayList<PointMaster>();

		PointMaster leftPoint = new PointMaster(left, leftY);
		PointMaster rightPoint = new PointMaster(right, rightY);
		PointMaster topPoint = new PointMaster(topX, top);
		PointMaster bottomPoint = new PointMaster(bottomX, bottom);
		
		trianglePoints.addAll(Arrays.asList(leftPoint, rightPoint, topPoint, bottomPoint));
		
		// this is for the case that user drawed the round corner
		// we calculate the average point
		for (int i = 0; i < trianglePoints.size(); i++) {
			PointMaster p1 = trianglePoints.get(i);
			for (int j = i; j < trianglePoints.size(); j++) {
				PointMaster p2 = trianglePoints.get(j);

				if (p1 != p2 && p1.isRoughlyTheSame(p2)) { 
					// add median point
					trianglePoints.add(p1.getMidianPointWith(p2));
					// remove those 2 points
					trianglePoints.removeAll(Arrays.asList(p1, p2));
					// exit loop
					break;
				}
			}
		}
		return trianglePoints;
	}
	
	@Override
	protected void updateBounds(float x, float y) {
		
		if (Math.min(left, x) == x) {
			left = x;
			leftY = y;
		}
		
		if (Math.max(right, x) == x) {
			right = x;
			rightY = y;
		}
		
		if (Math.max(top, y) == y) {
			top = y;
			topX = x;
		}
		
		if (Math.min(bottom, y) == y) {
			bottom = y;
			bottomX = x;
		}
	}
}
