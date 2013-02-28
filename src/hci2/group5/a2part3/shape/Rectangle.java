package hci2.group5.a2part3.shape;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

public class Rectangle implements Drawable {

	private RectF rect;

	public static Paint _paint;
	static {
		_paint = new Paint();
		_paint.setAntiAlias(true);
		_paint.setColor(Color.BLACK);
		_paint.setStyle(Paint.Style.STROKE);
		_paint.setStrokeJoin(Paint.Join.ROUND);
		_paint.setStrokeCap(Paint.Cap.ROUND);
		_paint.setStrokeWidth(2);
	}
	
	public Rectangle(float left, float top, float right, float bottom) {
		rect = new RectF(left, top, right, bottom);
	}
	
	@Override
	public void draw(Canvas canvas) {
		canvas.drawRect(rect, _paint);
	}
}
