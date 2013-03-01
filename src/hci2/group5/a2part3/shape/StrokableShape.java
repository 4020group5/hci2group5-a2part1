package hci2.group5.a2part3.shape;

import hci2.group5.a2part3.config.PaintFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * A shape that is drawn with stroke when filled with color
 */
public abstract class StrokableShape implements Drawable {

	public abstract Paint getPaint();
	
	@Override
	public final void draw(Canvas canvas) {
		Paint paint = getPaint();
		
		drawShape(canvas, paint);
		
		// if paint style is fill, draw stroke
		if (paint.getStyle() == Paint.Style.FILL) {
			paint.setStyle(Paint.Style.STROKE);
			int originalColor = paint.getColor();
			paint.setColor(PaintFactory.STROKE_COLOR_WHEN_FILLED);
			
			drawShape(canvas, paint);
			
			paint.setColor(originalColor);
			paint.setStyle(Paint.Style.FILL);
		}
	}

	protected abstract void drawShape(Canvas canvas, Paint paint);
}
