package hci2.group5.a2part3.recognize;

import hci2.group5.a2part3.shape.Line;
import hci2.group5.a2part3.util.PointMaster;

public class RecognizingLine extends Recognizing {

	private PointMaster _p1,_p2;
	
	private boolean initialDraw = true;

	@Override
	public void touchDown(float x, float y) {
		if(initialDraw){
			_p1 = new PointMaster(x,y);
			return;
		}
	}

	@Override
	public void touchMove(float x, float y) {
		
	}

	@Override
	public void touchUp(float x, float y) {
		// TODO Auto-generated method stub
		_p2 = new PointMaster(x,y);
		if(initialDraw){
			initialDraw = false;
		}
		if(!_p1.isRoughlyTheSame(_p2)){
			doneRecognizing(new Line(_p1,_p2));
		}
	}
	
}
