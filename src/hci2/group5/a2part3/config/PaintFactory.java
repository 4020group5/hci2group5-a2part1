package hci2.group5.a2part3.config;

import android.graphics.Color;
import android.graphics.Paint;

public class PaintFactory {

	public static final int DEFAULT_ALL_RECOGNIZED_SHAPE_COLOR = Color.GREEN;
	public static final int DEFAULT_DRAFT_SHAPE_COLOR = Color.BLACK;
	
	public static int STROKE_COLOR_WHEN_FILLED = Color.RED;
	
	public static Paint defaultPaint;
	static {
		defaultPaint = new Paint();
		defaultPaint.setColor(DEFAULT_ALL_RECOGNIZED_SHAPE_COLOR);
		defaultPaint.setStyle(Paint.Style.STROKE);
		defaultPaint.setAntiAlias(true);
		defaultPaint.setStrokeJoin(Paint.Join.ROUND);
		defaultPaint.setStrokeCap(Paint.Cap.ROUND);
		defaultPaint.setStrokeWidth(2);
	}

	public static Paint draftPaint;
	static {
		draftPaint = new Paint(defaultPaint);
		draftPaint.setColor(DEFAULT_DRAFT_SHAPE_COLOR);
	}

	public static void fillAllRecognizedShapesWithColor(int color) {
		defaultPaint.setStyle(Paint.Style.FILL);
		defaultPaint.setColor(color);
	}
}
