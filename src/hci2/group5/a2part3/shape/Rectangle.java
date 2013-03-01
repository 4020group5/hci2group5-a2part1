package hci2.group5.a2part3.shape;

import hci2.group5.a2part3.config.PaintFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

public class Rectangle extends StrokableShape {

	private RectF rect;

	public Rectangle(float left, float top, float right, float bottom) {
		rect = new RectF(left, top, right, bottom);
	}

	@Override
	public Paint getPaint() {
		return PaintFactory.defaultPaint;
	}

	@Override
	public void drawShape(Canvas canvas, Paint paint) {
		canvas.drawRect(rect, paint);
	}
}
