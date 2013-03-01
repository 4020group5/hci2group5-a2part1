package hci2.group5.a2part3.shape;

import hci2.group5.a2part3.config.PaintFactory;
import android.graphics.Canvas;
import android.graphics.PointF;

public class Triangle implements Drawable {

	private PointF _p1,_p2,_p3; 
	
	public Triangle(PointF p1, PointF p2, PointF p3){
		this._p1 = p1;this._p2 = p2;this._p3 = p3;
	}
	
	@Override
	public void draw(Canvas canvas) {
		canvas.drawLine(_p1.x,_p1.y,_p2.x,_p2.y,PaintFactory.defaultPaint);
		canvas.drawLine(_p2.x,_p2.y,_p3.x,_p3.y,PaintFactory.defaultPaint);
		canvas.drawLine(_p3.x,_p3.y,_p1.x,_p1.y,PaintFactory.defaultPaint);
	}
}