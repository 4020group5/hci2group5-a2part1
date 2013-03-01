package hci2.group5.a2part3.shape;

import hci2.group5.a2part3.config.PaintFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;

public class Triangle extends StrokableShape {

	private Path _path; 
	
	public Triangle(PointF p1, PointF p2, PointF p3){
		_path = new Path();
		_path.moveTo(p1.x, p1.y);
		_path.lineTo(p2.x, p2.y);
		_path.lineTo(p3.x, p3.y);
		_path.lineTo(p1.x, p1.y);
	}
	
	@Override
	public Paint getPaint() {
		return PaintFactory.defaultPaint;
	}
	
	@Override
	public void drawShape(Canvas canvas, Paint paint) {
		canvas.drawPath(_path, getPaint());
	}
}