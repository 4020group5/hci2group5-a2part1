package hci2.group5.a2part3.recognize;

import hci2.group5.a2part3.shape.Drawable;

public abstract class Recognizing implements TouchInputListener {

	private boolean _isDone = false;
	
	private Drawable _recognizedShape;
	
	public final void doneRecognizing(Drawable recognizedShape) {
		_isDone = true;
		_recognizedShape = recognizedShape;
	}

	public boolean isDone() {
		return _isDone;
	}

	public final Drawable getRecognizedShape() {
		return _recognizedShape;
	}
}
