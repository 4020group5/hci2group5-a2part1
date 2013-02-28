package hci2.group5.a2part3.shape;

import hci2.group5.a2part3.util.PointMaster;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Circle implements Drawable {
	
	private float cx,cy,radius;

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
	
	public Circle(PointMaster point, float r){
		this.cx = point.x; this.cy = point.y; this.radius = r;
	}
	
	@Override
	public void draw(Canvas canvas) {
		// TODO Auto-generated method stub
		canvas.drawCircle(cx, cy, radius, _paint);
	}

}
