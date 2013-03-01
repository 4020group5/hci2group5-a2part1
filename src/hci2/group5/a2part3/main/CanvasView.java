package hci2.group5.a2part3.main;

import hci2.group5.a2part3.recognize.Recognizing;
import hci2.group5.a2part3.recognize.RecognizingTypes;
import hci2.group5.a2part3.shape.DraftShape;
import hci2.group5.a2part3.shape.Drawable;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class CanvasView extends View {
	
<<<<<<< HEAD
=======
	private RecognizingTypes _currentRecognizingTyle = RecognizingTypes.TRIANGLE; // TODO dynamically change based on user's input
	
>>>>>>> implementation of Rtriangle
	private DraftShape _draftShape;
	private RecognizingTypes _recognizingTyle;
	private Recognizing _recognizing;
	private List<Drawable> _recoginizedShapes;

	public CanvasView(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		_draftShape = new DraftShape();
		_recoginizedShapes = new ArrayList<Drawable>();
	}

	public void setRecognizing(RecognizingTypes recognizingType) {
		_recognizingTyle = recognizingType;
		_recognizing = recognizingType.getAlgrithm();
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
		if (_recognizingTyle == null) {
			throw new IllegalAccessError("Developer: No recognizing types specifid. Please call setRecgnizing(RecognizingTypes)");
		}
		
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
			setRecognizing(_recognizingTyle); // reset
		}
		
		invalidate();
		
		return true;
	}
}
