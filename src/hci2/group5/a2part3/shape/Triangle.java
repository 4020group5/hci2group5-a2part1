package hci2.group5.a2part3.shape;

import hci2.group5.a2part3.util.PointMaster;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Triangle implements Drawable {

	private PointMaster _p1,_p2,_p3; 
	
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
	
	public Triangle(PointMaster p1, PointMaster p2, PointMaster p3){
		this._p1 = p1;this._p2 = p2;this._p3 = p3;
	}
	
	@Override
	public void draw(Canvas canvas) {
		// TODO Auto-generated method stub
		canvas.drawLine(_p1.x,_p1.y,_p2.x,_p2.y,_paint);
		canvas.drawLine(_p2.x,_p2.y,_p3.x,_p3.y,_paint);
		canvas.drawLine(_p3.x,_p3.y,_p1.x,_p1.y,_paint);
		
	}

}