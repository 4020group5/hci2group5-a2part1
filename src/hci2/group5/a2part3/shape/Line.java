package hci2.group5.a2part3.shape;

import hci2.group5.a2part3.config.PaintFactory;
import android.graphics.Canvas;
import android.graphics.PointF;

public class Line implements Drawable {

	private PointF _p1, _p2;
	
	public Line (PointF p1, PointF p2){
		this._p1 = p1; this._p2 = p2;
	}
	
	@Override
	public void draw(Canvas canvas) {
		canvas.drawLine(_p1.x, _p1.y, _p2.x, _p2.y, PaintFactory.defaultPaint);
	}
}