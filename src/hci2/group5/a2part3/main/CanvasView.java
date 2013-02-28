package hci2.group5.a2part3.main;

import hci2.group5.a2part3.recognize.Recognizing;
import hci2.group5.a2part3.recognize.RecognizingRectangle;
import hci2.group5.a2part3.shape.DraftShape;
import hci2.group5.a2part3.shape.Drawable;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;

public class CanvasView extends View {

	private DraftShape _draftShape;
	private Recognizing _recognizing;
	private List<Drawable> _recoginizedShapes;

	public CanvasView(Context context) {
		super(context);
		
		_draftShape = new DraftShape();
		_recognizing = new RecognizingRectangle(); // TODO dynamically change based on user's input
		_recoginizedShapes = new ArrayList<Drawable>();
	}

	@Override
	protected void onDraw(Canvas canvas) {
		for (Drawable shape : _recoginizedShapes) {
			shape.draw(canvas);
		}
		_draftShape.draw(canvas);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		float x = event.getX();
		float y = event.getY();
		
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			_draftShape.touchDown(x, y);
			_recognizing.touchDown(x, y);
			break;
		case MotionEvent.ACTION_MOVE:
			_draftShape.touchMove(x, y);
			_recognizing.touchMove(x, y);
			break;
		case MotionEvent.ACTION_UP:
			_draftShape.touchUp(x, y);
			_recognizing.touchUp(x, y);
			break;

		default:
			break;
		}
		
		if (_recognizing.isDone()) {
			_recoginizedShapes.add(_recognizing.getRecognizedShape());
			_draftShape.reset();
		}
		
		invalidate();
		
		return true;
	}
}
