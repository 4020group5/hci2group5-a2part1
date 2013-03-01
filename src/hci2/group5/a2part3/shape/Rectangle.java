package hci2.group5.a2part3.shape;

import hci2.group5.a2part3.config.PaintFactory;
import android.graphics.Canvas;
import android.graphics.RectF;

public class Rectangle implements Drawable {

	private RectF rect;

	public Rectangle(float left, float top, float right, float bottom) {
		rect = new RectF(left, top, right, bottom);
	}
	
	@Override
	public void draw(Canvas canvas) {
		canvas.drawRect(rect, PaintFactory.defaultPaint);
	}
}
