package hci2.group5.a2part3.shape;

import hci2.group5.a2part3.config.PaintFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

public class Circle extends StrokableShape {
	
	private float _centerX, _centerY;
	private float _radius;

	public Circle(float centerX, float centerY, float radius) {
		_centerX = centerX;
		_centerY = centerY;
		_radius = radius;
	}

	@Override
	public Paint getPaint() {
		return PaintFactory.defaultPaint;
	}

	@Override
	public void drawShape(Canvas canvas, Paint paint) {
		canvas.drawCircle(_centerX, _centerY, _radius, paint);
	}
}
