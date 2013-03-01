package hci2.group5.a2part3.recognize;

import hci2.group5.a2part3.util.PointMaster;

public class RecognizingTriangle extends Recognizing {

	private PointMaster _p1,_p2,_p3,p_p;
	
	private float _x, _y;
	
	@Override
	public void touchDown(float x, float y) {
		// TODO Auto-generated method stub
		_p1 = new PointMaster(x,y);
		p_p = new PointMaster(x,y);
	}

	@Override
	public void touchMove(float x, float y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void touchUp(float x, float y) {
		// TODO Auto-generated method stub
	}
	
	private void updateBounds(float x, float y) {

	}
	
	// NOTE: when done, call doneRecognizing(Triangle blabla)
}
