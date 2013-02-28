package hci2.group5.a2part3.shape;

import hci2.group5.a2part3.recognize.TouchInputListener;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;

public class DraftShape implements Drawable, TouchInputListener {
	
	private Path _path;

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
	
	public DraftShape() {
		_path = new Path();
	}
	
	@Override
	public void draw(Canvas canvas) {
		canvas.drawPath(_path, _paint);
	}

	@Override
	public void touchDown(float x, float y) {
		_path.moveTo(x, y);
	}

	@Override
	public void touchMove(float x, float y) {
		_path.lineTo(x, y);
		_path.moveTo(x, y);
	}

	@Override
	public void touchUp(float x, float y) {
		_path.lineTo(x, y);
		_path.moveTo(x, y);
	}

	public void reset() {
		_path.reset();
	}

}
