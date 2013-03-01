package hci2.group5.a2part3.shape;

import hci2.group5.a2part3.config.PaintFactory;
import android.graphics.Canvas;

public class Circle implements Drawable {
	
	private float _centerX, _centerY;
	private float _radius;

	public Circle(float centerX, float centerY, float radius) {
		_centerX = centerX;
		_centerY = centerY;
		_radius = radius;
	}

	@Override
	public void draw(Canvas canvas) {
		canvas.drawCircle(_centerX, _centerY, _radius, PaintFactory.defaultPaint);
	}
}
