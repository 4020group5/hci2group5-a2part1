package hci2.group5.a2part3.util;

import hci2.group5.a2part3.config.PointConfig;
import android.graphics.PointF;

/**
 * Pointer utility class: for example, compare 2 pointers' position, etc.
 *
 */
public class PointMaster extends PointF {

	public PointMaster(float x, float y) {
		super(x, y);
	}

	/**
	 * Used to check if a corner of, say rectangle, is closed.
	 * 
	 * @param p If the corner is isRoughlyTheSame as p
	 */
	public boolean isRoughlyTheSame(PointF p) {
		float roughValue = PointConfig.TWO_POINTS_ROUGHLY_THE_SAME_VALUE_IN_PX;
		return Math.abs(this.x - p.x) < roughValue && Math.abs(this.y - p.y) < roughValue;
	}
	
	public boolean isTopLeft(PointF p) {
		return p.x <= this.x && p.y >= this.y;
	}

	public boolean isBottomLeft(PointF p) {
		return p.x <= this.x && p.y <= this.y;
	}

	public boolean isTopRight(PointF p) {
		return p.x >= this.x && p.y >= this.y;
	}

	public boolean isBottomRight(PointF p) {
		return p.x >= this.x && p.y <= this.y;
	}
	
	public PointMaster getMidianPointWith(PointMaster p2) {
		return new PointMaster((this.x + p2.x) / 2f, (this.y + p2.y) / 2f);
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof PointMaster) {
			PointMaster p2 = (PointMaster) o;
			return this.hasTheSameXY(p2);
		}
		return false;
	}

	private boolean hasTheSameXY(PointMaster p2) {
		return this.x == p2.x && this.y == p2.y;
	}
	
	@Override
	public String toString() {
		return String.format("Point (%.0f, %.0f)", x, y);
	}
}
