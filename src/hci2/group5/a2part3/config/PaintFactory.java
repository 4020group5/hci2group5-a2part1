package hci2.group5.a2part3.config;

import android.graphics.Color;
import android.graphics.Paint;

public class PaintFactory {

	public static Paint defaultPaint;
	static {
		defaultPaint = new Paint();
		defaultPaint.setColor(Color.YELLOW);
		defaultPaint.setStyle(Paint.Style.STROKE);
		defaultPaint.setAntiAlias(true);
		defaultPaint.setStrokeJoin(Paint.Join.ROUND);
		defaultPaint.setStrokeCap(Paint.Cap.ROUND);
		defaultPaint.setStrokeWidth(2);
	}
}
