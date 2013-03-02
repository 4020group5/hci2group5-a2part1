package hci2.group5.a2part3.recognize;

import hci2.group5.a2part3.shape.Line;
import hci2.group5.a2part3.util.PointMaster;

public class RecognizingLine extends Recognizing {

	private PointMaster _p1,_p2;
	
	@Override
	public void touchDown(float x, float y) {
		_p1 = new PointMaster(x,y);
	}

	@Override
	public void touchMove(float x, float y) {
		// do nothing
	}

	@Override
	public void touchUp(float x, float y) {
		_p2 = new PointMaster(x,y);
		
		doneRecognizing(new Line(_p1,_p2));
	}
}
