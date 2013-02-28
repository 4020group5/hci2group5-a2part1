package hci2.group5.a2part3.shape;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Circle implements Drawable {
	
	private float _centerX, _centerY;
	private float _radius;

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
	
	public Circle(float centerX, float centerY, float radius) {
		_centerX = centerX;
		_centerY = centerY;
		_radius = radius;
	}

	@Override
	public void draw(Canvas canvas) {
		canvas.drawCircle(_centerX, _centerY, _radius, _paint);
	}
}
