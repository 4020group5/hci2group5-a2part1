package hci2.group5.a2part3.shape;

import hci2.group5.a2part3.config.PaintFactory;
import hci2.group5.a2part3.recognize.TouchInputListener;
import android.graphics.Canvas;
import android.graphics.Path;

public class DraftShape implements Drawable, TouchInputListener {
	
	private Path _path;

	public DraftShape() {
		_path = new Path();
	}
	
	@Override
	public void draw(Canvas canvas) {
		canvas.drawPath(_path, PaintFactory.draftPaint);
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
